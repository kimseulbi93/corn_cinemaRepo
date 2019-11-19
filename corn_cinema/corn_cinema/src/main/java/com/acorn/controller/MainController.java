package com.acorn.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.domain.ViewVO;
import com.acorn.service.MovieViewJoinResultService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainController {
	@Inject
	private MovieViewJoinResultService service;

	@GetMapping("/")
	public String Main(Model model) throws Exception {
		log.info("Get-Main");

		List<MovieViewJoinResultVO> list1 = service.boxMovieList(); // 박스오피스
		List<MovieViewJoinResultVO> list2 = service.newMovieList(); // 최신상영작
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		
		log.info("list1:::::"+list1) ;
		
		return "index";
	}

	@GetMapping("/index.html")
	public String Main_index() {
		log.info("Get-Main-Re");
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("로그아웃!!");
		session.removeAttribute("login");
		return "redirect:/";
	}

}// end class
