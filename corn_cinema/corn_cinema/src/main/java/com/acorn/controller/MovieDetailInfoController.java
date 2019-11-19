
  package com.acorn.controller;
  
  import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import
  org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import
  org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acorn.domain.MemberReplyJoinResultVO;
import com.acorn.domain.MovieAvgScoreResultVO;
import com.acorn.service.MovieAvgScoreResultService;
import com.acorn.service.MovieViewJoinResultService;

import lombok.extern.log4j.Log4j;
  
  @Log4j	
  @RequestMapping("/")
  @Controller 
  public class MovieDetailInfoController {
  
	@Inject
	private MovieViewJoinResultService service;
	
	@Inject
	private MovieAvgScoreResultService avgScoreResultSevice;

	
	@RequestMapping(value ="/movie_detail")
	public void movieRead(@RequestParam(value = "movie_num", required = false) String movie_num, Model model)
			throws Exception {

		model.addAttribute("movieRead", service.movieRead(movie_num));
		
		} // movieRead
	
	
	@RequestMapping(value = "/movie_avgScore_Result_update")
	   public @ResponseBody void avgScoreResultUpdate(
			  @RequestParam(value = "movie_num", required = false) String movie_num,
			  @ModelAttribute("MovieAvgScoreResultVO") MovieAvgScoreResultVO vo) 
	               throws Exception {  
		
		  log.info("movie_avgScore_Result_update");
	      avgScoreResultSevice.replyScoreUpdate(vo);

	   } // avgScoreResult update
	
	 @RequestMapping(value = "/movie_avgScore_Result_select")
	   public @ResponseBody MovieAvgScoreResultVO avgScoreResultSelect(
			   @RequestParam(value = "movie_num", required = false) String movie_num,
	           HttpServletRequest reqeust,
	           HttpServletResponse response,
	           HttpSession session) 
	   
	               throws Exception {
	      log.info("movie_avgScore_Result_update");
	  
	      MovieAvgScoreResultVO avgScoreResult = avgScoreResultSevice.replyScoreSelect(movie_num);

	      return avgScoreResult;

	   } // avgScoreResultSelect
	
}