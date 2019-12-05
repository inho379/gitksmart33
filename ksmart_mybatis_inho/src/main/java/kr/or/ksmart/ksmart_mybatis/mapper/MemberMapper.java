package kr.or.ksmart.ksmart_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Mapper
public interface MemberMapper {
	public List<Member> getMemberList();
	//회원가입
	public int addMemberInsert(Member member);
		
	//회원정보 수정 화면보여주기
	public Member selectByMember(String memberId);
	
	//회원수정 처리
	public int updateMember(Member member); 
	
	//회원정보 삭제 화면 보여주기
	public Member deleteByMember(String member);
	
	//회원정보 삭제 처리
	public int deleteMember(Member member);
	
	//회원 검색
	public List<Member> getMemberSearchList(String sk, String sv);	
	
	//로그인 체크
	public Member loginCheck(Member member);
}
