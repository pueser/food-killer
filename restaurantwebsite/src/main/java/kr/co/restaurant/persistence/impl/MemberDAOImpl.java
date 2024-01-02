package kr.co.restaurant.persistence.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.restaurant.domain.MemberAttachDTO;
import kr.co.restaurant.domain.MemberDTO;
import kr.co.restaurant.persistence.IMemberDAO;
import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class MemberDAOImpl implements IMemberDAO{
	@Autowired
	public SqlSession session;
	
	//회원 로그인체크
	@Override
	public MemberDTO read(MemberDTO loginDto) throws Exception {
		return session.selectOne("memberMapper.read", loginDto);
	}
	//회원가입 DB 저장(아이디, 닉네임, 이메일) 및 profile 기본 이미지 저장
	@Transactional
	@Override
	public String insertMember(MemberDTO member, MemberAttachDTO memberAttachDTO, int reJoinResult) throws Exception {
		
		System.out.print("member회원가입 정보 +++++++++++" + member.toString());
		
		if(reJoinResult != 0) {
			//재가입 회원 memberState('ING') 변경
			session.update("memberMapper.updateMemberState", member);
			//기본profile 저장
			Map<Object, Object> map = new HashMap<>();
			map.put("uuid", memberAttachDTO.getUuid());
			map.put("fileName", memberAttachDTO.getFileName());
			map.put("email", member.getEmail());
			session.insert("memberMapper.insertBasicProfile", map);
			
			System.out.println("기 회원시 기본 이미지만 저장");
		}else {
			//회원정보 저장
			session.insert("memberMapper.insertMember", member);
			
			//기본profile 저장
			Map<Object, Object> map = new HashMap<>();
			map.put("uuid", memberAttachDTO.getUuid());
			map.put("fileName", memberAttachDTO.getFileName());
			map.put("email", member.getEmail());
			session.insert("memberMapper.insertBasicProfile", map);
			
			System.out.println("회원이 아닐 시 기본 이미지, 회원 정보 저장");
		}
		return member.getNickName();
	}
	// 닉네임 중복검사
	@Override
	public int selectNickName(String nickName) throws Exception {
		return session.selectOne("memberMapper.selectNickName", nickName);
	}
	//이메일 존재여부 확인(임시 비밀번호 전송시 사용)
	@Override
	public int selectEmail(String email) throws Exception {
		return session.selectOne("memberMapper.selectEmail", email);
	}
	//임시 비밀번호 발급시 비번변경
	@Override
	public void updatePwd(String ranPwd, String email) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ranPwd", ranPwd);
		map.put("email", email);
		session.update("memberMapper.updatePwd", map);
		
	}
	//회원 프로필 사진 가져오기
	@Override
	public MemberAttachDTO selectProfile(MemberDTO memInfo) throws Exception {
		log.info("memInfo++++++++++++++++++++++++++" + memInfo.toString());
		return session.selectOne("memberMapper.selectProfile", memInfo);
	}
	//회원 프로필 사진 수정(update)
	@Override
	public int updateProfile(MemberAttachDTO uploadResultArr, MemberDTO memInfo) throws Exception {
		Map<Object, Object> map = new HashMap<>();
		map.put("uuid", uploadResultArr.getUuid());
		map.put("fileName", uploadResultArr.getFileName());
		map.put("email", memInfo.getEmail());
		
		log.info("memInfo++++++++++++++++++++++++++" + memInfo.toString());
		log.info("uploadImage"+uploadResultArr.toString());
		
		return  session.update("memberMapper.updateProfile", map);
		
	}
	// 회원 탈퇴('WITHDRAW')
	@Override
	@Transactional
	public int deleteMember(MemberDTO memInfo, String widthdrawalAgree) throws Exception {
		session.delete("memberMapper.deleteProfileMember", memInfo); //프로필 삭제
		
		Map<Object, String> map = new HashMap<>();
		map.put("nickName", memInfo.getNickName());
		map.put("email", memInfo.getEmail());
		map.put("pwd", memInfo.getPwd());
		map.put("widthdrawalAgree", widthdrawalAgree);
		return session.update("memberMapper.withDrawMember", map);
	}
	// 탈퇴 후 재가입 회원인지 판단
	@Override
	public int selectMemberState(MemberDTO member) throws Exception {
		return session.selectOne("memberMapper.selectMemberState", member);
	}
	//로그아웃 후 최근접속일 변경
	@Override
	public void upadateDate(Object memInfo) throws Exception {
		log.info("로그아웃 시 회원정보 === " + memInfo.toString());
		session.update("memberMapper.update", memInfo);
		
	}

	
	
}
