package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.CommentTableVO;
import com.spring.service.CommentTableService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentTableService commentService;

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		List<CommentTableVO> commentList = commentService.list();

		model.addAttribute("commentList", commentList);
	}

}
