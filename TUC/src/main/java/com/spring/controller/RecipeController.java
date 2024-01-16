package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.BoardModifyCommand;
import com.spring.command.BoardRegistCommand;
import com.spring.command.CommentModifyCommand;
import com.spring.command.CommentRegistCommand;
import com.spring.command.PageMaker;
import com.spring.dto.BoardVO;
import com.spring.dto.CommentTableVO;
import com.spring.exception.NotExistPictureFileException;
import com.spring.service.BoardService;

@Controller
public class RecipeController {
	@Autowired
	private BoardService boardservice;
	// 목록보기
	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute PageMaker pageMaker, ModelAndView mnv) throws Exception {
		List<BoardVO> boardList = boardservice.list(pageMaker);
		String url = "/board/list";
		mnv.addObject("recipeList", boardList);
		mnv.setViewName(url);
		return mnv;
	}

	// 상세보기
	@GetMapping("/detail")
	public ModelAndView detail(int boardid, String from, ModelAndView mnv) throws Exception {
		String url = "/board/detail";

		BoardVO board = boardservice.read(boardid);
		if (from != null && from.equals("list")) {
			boardservice.increaseViewCount(boardid);;
			url = "redirect:/detail?boardid="+boardid;
		} else {
			board = boardservice.read(boardid);
		}
		mnv.addObject("board", board);
		mnv.setViewName(url);
		return mnv;
	}

	// 등록
	@GetMapping("/registForm")
	public ModelAndView registForm(ModelAndView mnv) throws Exception {
		String url = "/board/regist";

		mnv.setViewName(url);
		return mnv;
	}

	// 등록처리
	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public ModelAndView regist(@ModelAttribute BoardRegistCommand regCommand, ModelAndView mnv) {
		String url = "/board/regist_success";

		try {
			MultipartFile multi = regCommand.getPicture();
			String fileName = saveThumnail(null, multi);

			BoardVO board = regCommand.toBoardVO();
			board.setThumnail(fileName);
			
			boardservice.regist(board);
		} catch (NotExistPictureFileException e) {
			url = "/error/400";
			e.printStackTrace();
		} catch (Exception e) {
			url = "/err/500";
			e.printStackTrace();
		}
		mnv.setViewName(url);
		return mnv;
	}

	@Resource(name = "thumnailPath")
	private String thumnailPath;

	public String saveThumnail(String oldPicture, MultipartFile multi)
			throws NotExistPictureFileException, IllegalStateException, IOException {
		final Logger logger = LoggerFactory.getLogger(RecipeController.class);
		logger.debug("BoardController : regist - saving thumnail file");

//		if(multi ==null || multi.isEmpty())
//			return null;
//		if(multi.getSize()>1024*1024*4)
//			throw new NotExistPictureFileException();
		if (multi == null || multi.isEmpty() || multi.getSize() > 1024 * 1024 * 4)
			throw new NotExistPictureFileException();

		// 저장 파일명
		String fileName = null;

		// 파일저장폴더설정
		String uploadPath = this.thumnailPath;

		// 파일유무확인, 저장 파일명 결정

		String uuid = UUID.randomUUID().toString().replace("-", "");
		fileName = uuid + "$$" + multi.getOriginalFilename();
		File storeFile = new File(uploadPath, fileName);

		// 파일경로 생성
		storeFile.mkdirs();

		// local HDD 에 저장.
		multi.transferTo(storeFile);

		// 기존파일 삭제
		if (oldPicture != null && !oldPicture.isEmpty()) {
			File oldFile = new File(uploadPath, oldPicture);
			if (oldFile.exists()) {
				oldFile.delete();
			}
		}

		return fileName;

	}

	@GetMapping("/getPicture")
	@ResponseBody
	public ResponseEntity<byte[]> getPicture(int id) throws Exception {
		ResponseEntity entity = null;

		BoardVO board = boardservice.read(id);

		if (board == null)
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);

		String picture = board.getThumnail();
		String imgPath = this.thumnailPath;

		InputStream in = null;

		try {
			in = new FileInputStream(new File(imgPath, picture));
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
			return entity;

		} finally {
			if (in != null)
				in.close();
		}

	}

	// 수정
	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(int boardid, ModelAndView mnv) throws Exception {
		String url = "/board/modify";
		BoardVO board = boardservice.read(boardid);
		mnv.addObject("board", board);
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping(value = "/modify", produces = "text/plain;charset=utf-8")
	public ModelAndView modify(BoardModifyCommand modifyCommand, ModelAndView mnv) throws Exception {
		String url = "/board/modify_success";
		BoardVO board = modifyCommand.toBoardVO();
		try {
		String oldPicture = modifyCommand.getOldPicture();
		MultipartFile multi = modifyCommand.getPicture();
		// 파일 저장 및 삭제
		if (multi == null || multi.isEmpty()) {
			board.setThumnail(oldPicture);
		} else {
			String fileName = saveThumnail(oldPicture, multi);
			board.setThumnail(fileName);
		}
		// DB 수정
		boardservice.modify(board);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mnv.addObject("id", board.getBoardid());
		mnv.setViewName(url);
		return mnv;
	}
	// 삭제
	@GetMapping("/delete")
	public ModelAndView delete(int boardid, ModelAndView mnv) throws Exception {
		String url = "/board/delete_success";

//		BoardVO board = boardservice.read(boardid);
//		String savePath = this.thumnailPath;
//		File imageFile = new File(savePath, board.getThumnail());
//		if (imageFile.exists()) {
//			imageFile.delete();
//		}
		boardservice.delete(boardid);

		mnv.setViewName(url);
		return mnv;
	}
	//댓글 등록
	@PostMapping(value="/registComment", produces="text/plain;charset=utf-8")
	public ModelAndView registComment(CommentRegistCommand command, ModelAndView mnv) throws Exception{
		String url = "/board/registComment_success";
		CommentTableVO comment = command.toCommentVO();
		int boardid = command.getBoardid();
		
		boardservice.registComment(comment, boardid);
		
		mnv.addObject("id",boardid);
		mnv.setViewName(url);
		return mnv;
	}
	//댓글 수정
	@GetMapping("/modifyCommentForm")
	public ModelAndView modifyCommentForm(String commentid, ModelAndView mnv) throws Exception{
		String url = "board/modifyComment";
		CommentTableVO comment = boardservice.readComment(commentid);
		
		mnv.addObject("comment", comment);
		mnv.setViewName(url);
		return mnv;
	}
	//댓글 수정 처리
	@PostMapping(value = "/modifyComment", produces = "text/plain;charset=utf-8")
	public ModelAndView modifyComment(CommentModifyCommand command, ModelAndView mnv) throws Exception{
		String url = "/board/modifyComment_success";
		
		CommentTableVO comment = command.toCommentVO();
		boardservice.modifyComment(comment);
		
		mnv.setViewName(url);
		return mnv;
	}
	
	
	//댓글 삭제
	@GetMapping("/deleteComment")
	public ModelAndView deleteComment(String commentid, int boardid, ModelAndView mnv) throws Exception{
		String url = "/board/deleteComment_success";
		
		boardservice.deleteComment(commentid);
		mnv.addObject("id",boardid);
		mnv.setViewName(url);
		return mnv;
	}
}
