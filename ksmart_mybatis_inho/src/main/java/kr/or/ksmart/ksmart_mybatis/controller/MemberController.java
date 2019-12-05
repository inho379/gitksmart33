package kr.or.ksmart.ksmart_mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_mybatis.service.MemberService;
import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Controller
public class MemberController {
	
	@Autowired 
	private MemberService memberService; 
	
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		
		model.addAttribute("memberList", memberService.getMemberList());
		
		return "member/memberList";
	}
	//회원가입화면 폼
	@GetMapping("/memberInsert")
	public String memberInsert(Member member) {
		
		return "member/memberInsert";
	}
	//회원가입화면 폼에서 데이터 입력시
	@PostMapping("/memberInsert")
	public String addMemberInsert(Member member) {
		memberService.addMemberInsert(member);
		System.out.println(member.toString()+"<--member");
		return "redirect:/memberList";
	}
	
	/*
	 * @GetMapping("/memberUpdate") public String memberUpdate(Member member) {
	 * 
	 * return "member/memberUpdate"; } //수정 화면 후
	 * 
	 * @PostMapping("/memberUpdate") public String updateMember(Member member) {
	 * 
	 * memberService.updateMember(member); return "redirect:/memberList"; }
	 */
	
		//수정 클릭시 select로 화면 뿌려주기
	  @GetMapping("/memberUpdate") 
	  public String selectByMember(@RequestParam(value="memberId") String memberId,Model model) 
	  {
		  System.out.println("memberId-->" + memberId);
		 
		  model.addAttribute("member", memberService.selectByMember(memberId));
	  return "member/memberUpdate"; 
	  }
	  //수정처리 하기
	   @PostMapping("/memberUpdate") 
	   public String updateMember(Member member) {
			 
		   memberService.updateMember(member); 
		   return "redirect:/memberList";
	   }
	   
	   //삭제 클릭 시 
	   @PostMapping("/deleteMember")
	   	public String deleteMember(Member member) {
		   
		   memberService.deleteMember(member);
		   return "redirect:/memberList";
	   }
	
	   //삭제 화면 보여주기
	     @GetMapping("/memberDelete")
	     public String selecDelete(@RequestParam(value="memberId") String memberId,Model model) {
	     System.out.println("memberId-->" + memberId);
	     memberService.deleteByMember(memberId);
	     model.addAttribute("member",memberService.deleteByMember(memberId));
	     
	     return "member/memberDelete"; 
	     }
	    //로그인화면 보여주기
	   @GetMapping("/login")
	   public String login() {
		   return "login/login";
	   }
	 	//로그인 검사
	  @PostMapping("/login")
	  	public String loginCheck(Member member,HttpSession session,Model model){
		  Member m =memberService.loginCheck(member);
		  if(m.getMemberId() !=null) {
			  System.out.println("아이디 일치");
			  if(m.getMemberPw().equals(member.getMemberPw())) {
				  session.setAttribute("SID", m.getMemberId());
				  session.setAttribute("SPW", m.getMemberId());
				  session.setAttribute("SLEVEL", m.getMemberId());
				  System.out.println("로그인성공");
			  }else {
				  System.out.println("비밀번호 불일치");			  }
		  }
		  return "redirect:/";
		 }
	  //리스트 검색
	  @PostMapping("/memberList")
	  public String getMemberSearchList(String sk, String sv,Model model) {
		 
		 model.addAttribute("memberList", memberService.getMemberSearchList(sk, sv));
		 return "member/memberList";
	  }
	 //로그아웃
	  @GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
	 }

