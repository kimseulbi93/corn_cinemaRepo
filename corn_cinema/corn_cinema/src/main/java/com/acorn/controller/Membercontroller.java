package com.acorn.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acorn.domain.MemberVo;
import com.acorn.domain.MypageVO;
import com.acorn.email.Email;
import com.acorn.email.EmailAuthenNum;
import com.acorn.email.EmailSender;
import com.acorn.model.LoginDTO;
import com.acorn.model.MemberDTO;
import com.acorn.security.Sha256;
import com.acorn.service.LoginService;
import com.acorn.service.MemberService;
import com.acorn.service.MypageService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/*")
public class Membercontroller {

   @Autowired
   private MemberService memberservice;

   @Autowired
   private MypageService service;
   @Autowired
   private LoginService loginservice;

   private final String loginkey = "login";
   @Autowired
   private Email email;

   @Autowired
   private EmailSender emailSender;
   // ------------------------------------ idCheck-----------------------------------------//
   
   @PostMapping("/idcheck")
   @ResponseBody
   public int idCheck(@RequestParam("userId") String user_id) throws Exception {
      return memberservice.DuplicateId(user_id);

   } // idCheck

   // ------------------------------------ emailcheck -----------------------------------------//
   @PostMapping("/emailcheck")
   @ResponseBody
   public int emailcheck(@RequestParam("userEmail") String user_email) throws Exception {
      return memberservice.DuplicateEmail(user_email);

   }// emailcheck
   
   //------------------------------withdrawal_password_ckeck--------------------------------------//
   @PostMapping("withdrawalCk")
   @ResponseBody
   public int withdrawalCk(@RequestParam("password") String passwordCk, 
                         @RequestParam("memberId") String memberId,
                         HttpSession session) throws Exception {
 
      int userRemoveCount = 0;

      MemberVo vo = new MemberVo();

      vo.setId(memberId);
      vo.setPassword(Sha256.encrypt(passwordCk));
      userRemoveCount = memberservice.remove(vo);

      log.info("userRemoveCount:" + userRemoveCount);

      if (userRemoveCount == 1) {           //삭제된 행이 있다면  ~
         session.invalidate();             // 세션 제거 !
      }

      return userRemoveCount;
   } //withdrawalCk

   //------------------------------reset_Password--------------------------------------//
   @PostMapping("reset_Password")
   @ResponseBody
   public int reset_Password(@RequestParam("userId") String user_Id, 
                           @RequestParam("userEmail") String user_Email, 
                              HttpSession session) throws Exception {
 
      //   int Information_match = 0;
         
         MemberVo vo = new MemberVo();
         
         vo.setId(user_Id);
         vo.setEmail(user_Email);
         
      //   System.out.println("Information_match::: " + Information_match);
         
         //Information_match = memberservice.getNewPw(vo);
         //return Information_match;
         return  memberservice.getNewPw(vo);

      } // reset_Password
   
   
   //------------------------------------ login -----------------------------------------//
   @GetMapping("/login")
   public void login() {

      log.info("Get-Login");
   } // login()

   @PostMapping("login_Post")
   public String login_result(LoginDTO dto, Model model) throws Exception {
      log.info("POST-Login");

      String encryPassword = Sha256.encrypt(dto.getPassword()); // 비번 암호화
      dto.setPassword(encryPassword);

      MemberVo vo = loginservice.checkLogin(dto);

      if (vo == null) {
         log.info("로그인 실패 !");

         return "redirect:/member/login"; // return"/member/login"; << 대신 redirect 사용 안그러면 홈페이지 오류! ( F5 눌렀을때오류)
      } // if
      
      model.addAttribute("memberInfo", vo);      
      
    //   vo.setConnection_time(null); 
      memberservice.connection_time(vo);

      // memberservice
   
      return "/index";
   } // login_POST

   // ------------------------------------ join-----------------------------------------//

   @GetMapping("/agree")
   public void agree() {
      log.info("agree");

   } // agree
   
   @GetMapping("/join")
   public void join() {
      log.info("join");

   } // join

   @PostMapping("/join")
   public String join_result(MemberDTO dto) throws Exception {

      log.info("POST_result");

      MemberVo vo = new MemberVo();

      String encryPassword = Sha256.encrypt(dto.getPassword()); // 비번 암호화

      vo.setId(dto.getId());
      vo.setPassword(encryPassword); 
      vo.setName(dto.getName());
      vo.setEmail(dto.getEmail());
 
      memberservice.regist(vo);

      return "/member/join_result";
      
   } // join_result

   
   //-------------------------------------------인증 및 확인-------------------------------------------------------//
   @PostMapping("/emailAuthen")
   @ResponseBody
   public void emailAuthen(@RequestParam("email") String mail, HttpSession session) throws Exception {

      String randomNumber = EmailAuthenNum.AuthenNum(); // 인증번호 6자리 생성

      session.setAttribute("randomNumber", randomNumber); /*randomNumber번호를 
                                                          Session스코프에 공유.-> 인증 확인 번호와 일치 check 위함*/
      
      email.setContent("인증번호는 :" + randomNumber + " 입니다"); //내용
      email.setReceiver(mail); //받는사람 메일  
      email.setSubject("corn_movie 인증번호 입니다."); //제목
      emailSender.SendEmail(email); //메일 전송
      
   } //emailAuthen

   @PostMapping("/authen")
   @ResponseBody
   public int authen(@RequestParam("authenNum") String authenNum, HttpSession session) throws Exception {

      int authenValue = 0;
      String authenNumber = (String) session.getAttribute("randomNumber");

      if (authenNum.equals(authenNumber)) {  //인증번호 일치 여부 , 일치하면 = 1 return;
         authenValue = 1;
         return authenValue;
      }

      return authenValue;
   } //authen
  //--------------------------------------------------------------------------------------------------------//
   
   
   // ------------------------------------ modify -----------------------------------------//

   @GetMapping("/member_modify")
   public void modify() {
      log.info("in회원정보수정페이지");
   } //modify

   @PostMapping("/member_modify")
   public String member_modify(MemberDTO dto, HttpSession session) throws Exception {

      MemberVo vo = new MemberVo();

      String encryPassword = Sha256.encrypt(dto.getPassword()); // 비번 암호화

      vo.setName(dto.getName());
      vo.setId(dto.getId());
      vo.setPassword(encryPassword);
      vo.setEmail(dto.getEmail());

      session.setAttribute("login", vo);

      memberservice.modify(vo);

      return "redirect:/";
   } //member_modify


   // ------------------------------------ withdrawal -----------------------------------------//
   
    @GetMapping("/withdrawal_result") 
    public void withdrawal_result() throws Exception { }

    
   // --------------------------------------mypage ---------------------------------------------//
   
   @GetMapping("/mypage")
   public void mypage(HttpSession session, Model model) throws Exception {

      MemberVo memberInfo1 = (MemberVo) session.getAttribute(loginkey);
      String id = memberInfo1.getId();
      
      LoginDTO dto = new LoginDTO();
      dto.setId(id);
      
        List<MypageVO> list1 = service.getReservationOk(dto);//예매내역
        List<MypageVO> list2 = service.getReservationNOk(dto);//지난내역
      
      
      model.addAttribute("list1", list1);//예약내역
      model.addAttribute("list2", list2);//지난내역
      
//      String movie_start_time = service.get
   }// mypage

   @PostMapping("/mypage/delete")
   @ResponseBody
   public String delete(@RequestParam("reservation_num") String reservation_num) throws Exception {
      log.info("reservation_num: " + reservation_num);
      LoginDTO dto = new LoginDTO();

      dto.setReservation_num(reservation_num);//

      service.remove(dto);
      return "redirect:/";
   } // join

} // end class