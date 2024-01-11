package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.command.PageMaker;
import com.spring.dto.BoardVO;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	@Autowired
	private BoardService boardservice;
	
	@GetMapping("/list")
	public void list(@ModelAttribute PageMaker pagemaker, Model model) throws Exception{
		List<BoardVO> boardList = boardservice.list(pagemaker);
		
		model.addAttribute("recipeList",boardList);
	}
}
