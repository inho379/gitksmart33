package kr.or.ksmart.ksmart_mybatis.service;

import java.util.List;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_mybatis.mapper.MemberMapper;
import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;

	public List<Member> getMemberList() {
		List<Member> list = memberMapper.getMemberList();
		System.out.println(list.toString());

		return memberMapper.getMemberList();
	}

	// 회원가입
	public int addMemberInsert(Member member) {

		return memberMapper.addMemberInsert(member);
	}

	// 회원수정처리
		
	  public int updateMember(Member member) {
	  
	  return memberMapper.updateMember(member); 
	  }
	 
	  
	//수정화면
	 public Member selectByMember(String memberId) {
		 
		 return memberMapper.selectByMember(memberId);
	 }
	 //회원 삭제 화면
	 public Member deleteByMember(String member) {
		 
		 return memberMapper.deleteByMember(member);
	 }
	 //회원삭제처리
	 public int deleteMember(Member member) {
		 
		return memberMapper.deleteMember(member);
	 }
	//회원검색
	
	 public List<Member> getMemberSearchList(String sk, String sv){
	
			List<Member> list = memberMapper.getMemberSearchList(sk, sv);
			
			return list;
	 }
	//로그인 체크
	 public Member loginCheck(Member member) {
		 return memberMapper.loginCheck(member);
	 }
}
