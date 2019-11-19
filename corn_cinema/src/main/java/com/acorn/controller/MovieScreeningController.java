package com.acorn.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acorn.domain.MovieViewJoinResultVO;
import com.acorn.service.MovieViewJoinResultService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("contents/*")
@Controller
public class MovieScreeningController {
	
	@Inject
	private MovieViewJoinResultService service;
	
	@GetMapping("/movie")
	public void MoiveScreeningGetMovie( Model model ) throws Exception {
		log.info("MovieScreeningController::MoiveScreeningGetMovie invoked");
		
		List<MovieViewJoinResultVO> list = service.newMovieList();
		
		log.info("MovieScreeningController list :" + list);
		
		model.addAttribute("list", list);
	}
	
	public class MovieReserveController {
		
		@GetMapping("/reserve")
		public String reserve() {
			log.info("reserve invoked");
			
			return "contents/movie/reserve";
		} //예매

	}

}
