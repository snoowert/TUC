package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.BoardRegistCommand;
import com.spring.command.PageMaker;
import com.spring.dto.BoardVO;
import com.spring.exception.NotExistPictureFileException;
import com.spring.service.BoardService;

@Controller
public class RecipeController {
	@Autowired
	private BoardService boardservice;

	// 목록보기
	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute PageMaker pagemaker, ModelAndView mnv) throws Exception {
		List<BoardVO> boardList = boardservice.list(pagemaker);
		String url = "/board/list";

		mnv.addObject("recipeList", boardList);
		mnv.setViewName(url);
		return mnv;
	}

	// 상세보기
	@GetMapping("/detail")
	public ModelAndView detail(int boardid, ModelAndView mnv) throws Exception {
		String url = "/board/detail";

		BoardVO board = boardservice.read(boardid);

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
			System.out.println(regCommand.getCategory());
			System.out.println(regCommand.getContent());
			System.out.println(regCommand.getTitle());
			System.out.println(regCommand.getWriter());
			MultipartFile multi = regCommand.getThumnail();
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
	public ResponseEntity<byte[]> getPicture(int boardid) throws Exception {
		ResponseEntity entity = null;

		BoardVO board = boardservice.read(boardid);

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
	@GetMapping("/moodifyForm")
	public ModelAndView modifyForm(int boardid, ModelAndView mnv) throws Exception {
		String url = "/board/modify";
		BoardVO board = boardservice.read(boardid);
		mnv.addObject("board", board);
		mnv.setViewName(url);
		return mnv;
	}

	// 삭제
	@GetMapping("/delete")
	public ModelAndView delete(int boardid, ModelAndView mnv) throws Exception {
		String url = "/board/delete_success";

		BoardVO board = boardservice.read(boardid);
		String savePath = this.thumnailPath;
		File imageFile = new File(savePath, board.getThumnail());
		if (imageFile.exists()) {
			imageFile.delete();
		}
		boardservice.delete(boardid);

		mnv.setViewName(url);
		return mnv;
	}

}
