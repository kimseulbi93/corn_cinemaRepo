package com.acorn.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.acorn.domain.Criteria;
import com.acorn.domain.PageMaker;
import com.acorn.model.MnMovieFileDTO;
import com.acorn.model.MovieViewJoinResultDTO;
import com.acorn.service.MnMovieBoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/MN_Movie_Board/*")
@Log4j
public class MnMovieBoardController {
	
	@Inject
	private MnMovieBoardService service; 
	
	
	/* 관리자 전체 영화 리스트 */
	@RequestMapping(value ="MN_movie_list",
			method = RequestMethod.GET)
	public void listPage(
				@ModelAttribute("cri") Criteria cri ,Model model)
						throws Exception {

		log.info(cri.toString());
		model.addAttribute("list", service.mnMovieListCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.mnMovielistCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	} // listPage
	
	/* 관리자 영화 상세페이지 */
	@RequestMapping(value ="MN_movie_detail")
	public void mnMovieDetailInfo(
			@RequestParam(value = "movie_num", required = false) String movie_num,
			@ModelAttribute("cri") Criteria cri,
			Model model
			) throws Exception{
		 log.info("mnMovieDetailInfo");
		 
		 model.addAttribute("mnMovieRead", service.mnMovieRead(movie_num));
		
	}  //mnMovieDetailInfo
	
	/* 관리자 수정 페이지 */
	
	@GetMapping("MN_movie_modify")
	   public void modifyGET(
			   @RequestParam(value = "movie_num", required = false) String movie_num,
			   Model model
			   ) throws Exception {
	      log.info("in수정페이지");
	      model.addAttribute("mnMovieRead", service.mnMovieRead(movie_num));
	} //modify
	
	
	@PostMapping("MN_movie_modify")
	public String MN_ModifyPagePOST(
			MovieViewJoinResultDTO mvdto,
			MnMovieFileDTO mfdto,
			@RequestParam("files") MultipartFile[] files,
			Model model
			) throws Exception{
		
		service.mnMovieModify(mvdto, files);
		
	     return "redirect:/MN_Movie_Board/MN_movie_list";
	
	} //MN_modifypage 
	
	/* 관리자 영화 등록 페이지 */
	@RequestMapping(value ="MN_movie_register",
			method = RequestMethod.GET)
	public void mnMovieRegisterGET() throws Exception{
		log.info("mnMovieRegisterGET");
	}
	
	@RequestMapping(value ="MN_movie_register",
			method = RequestMethod.POST)
	public String mnMovieRegisterPOSET(
			MovieViewJoinResultDTO mvdto,
			MnMovieFileDTO mfdto,
			@RequestParam("files") MultipartFile[] files,
			Model model
			) throws Exception{
		
		log.info("mnMovieRegisterPOST");
		
		service.mnMovieRegist(mvdto, files);
		
		return "redirect:/MN_Movie_Board/MN_movie_list";
		
	}  //mnMovieRegisterGET

}
