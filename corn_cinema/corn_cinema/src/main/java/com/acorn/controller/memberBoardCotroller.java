package com.acorn.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acorn.domain.MemberBoardVO;
import com.acorn.model.PageDTO;
import com.acorn.service.MemberBoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/admin/*")
public class memberBoardCotroller {
	
	@Inject
    private MemberBoardService memberboardservice;
	
	@RequestMapping("/memberBoardList")
	public void memberBoardList(
			
			  @RequestParam(value="selectPageNum",required=false, defaultValue="1") int selectPageNum
			, @RequestParam(value="keyword",required=false, defaultValue="") String keyword
			, Model model) throws Exception  {
		
		
	     	System.out.println("memberBoardList invoked");
	    	System.out.println("model:" + model);
	    	
			PageDTO pageDTO = new PageDTO(selectPageNum,10);
			pageDTO.setKeyword(keyword); 			                                System.out.println("keyword:" +keyword);
			int memberListCount = memberboardservice.getMemberListCount(pageDTO); 	System.out.println("memberListCount:" + memberListCount);
			
			
			pageDTO.setTotalCount(memberListCount);
			
			List<MemberBoardVO> list = memberboardservice.MemberBoardList(pageDTO);
			model.addAttribute("list", list);
			model.addAttribute("pageDTO", pageDTO); 
			model.addAttribute("memberListCount", memberListCount);
			
	     
	
			System.out.println("selectPageNum:" + selectPageNum);

			System.out.println("model:" + model);
			
	        System.out.println("==========================");
            System.out.println("list:" + list);
            System.out.println("==========================");
            System.out.println("pageDTO" +  pageDTO);
			
			
		}
	
	   @RequestMapping("/admin_member_modify")
	   public void admin_member_modify(@RequestParam (value ="id") String id , Model model)
			    throws Exception {
		    System.out.println("admin_member_modify invoked");
            System.out.println("id:"+id);
            
            model.addAttribute("modifyId",  memberboardservice.selectMember(id));

	   }
	
	
	
	
	
	
	}
	
	

