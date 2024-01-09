package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.BoardVO;
import com.spring.service.BoardService;
import com.spring.service.LikeTableService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	@Autowired
	BoardService boardservice;
	@Autowired
	LikeTableService likeService;
	
	@GetMapping("/list")
	public void list(Model model) throws Exception{
		List<BoardVO> boardList = boardservice.list();
		
		model.addAttribute("recipeList",boardList);
	}
}
