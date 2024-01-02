package kr.co.restaurant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.restaurant.domain.MemberAttachDTO;
import kr.co.restaurant.domain.MemberDTO;
import kr.co.restaurant.persistence.IMemberDAO;
import kr.co.restaurant.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService{
	@Autowired
	public IMemberDAO mDao;

	@Override
	public MemberDTO loginCheck(MemberDTO loginDto) throws Exception {
		return mDao.read(loginDto);
	}
	@Override
	public String memberSave(MemberDTO member, MemberAttachDTO memberAttachDTO, int reJoinResult) throws Exception {
		return mDao.insertMember(member, memberAttachDTO, reJoinResult);
	}
	@Override
	public int nickNameChk(String nickName) throws Exception {
		return mDao.selectNickName(nickName);
	}
	@Override
	public int emailChk(String email) throws Exception {
		return mDao.selectEmail(email);
	}
	@Override
	public void updatePwd(String ranPwd, String email) throws Exception {
		mDao.updatePwd(ranPwd,email);
	}
	@Override
	public MemberAttachDTO selectProfile(MemberDTO memInfo) throws Exception {
		return mDao.selectProfile(memInfo);
	}
	@Override
	public int updateProfile(MemberAttachDTO uploadResultArr, MemberDTO memInfo) throws Exception {
		return mDao.updateProfile(uploadResultArr, memInfo);
	}
	@Override
	public int deleteMember(MemberDTO memInfo, String widthdrawalAgree) throws Exception {
		return mDao.deleteMember(memInfo, widthdrawalAgree);
	}
	@Override
	public int selectMemberState(MemberDTO member) throws Exception {
		return mDao.selectMemberState(member);
	}

	@Override
	public void upadateDate(Object memInfo) throws Exception {
		mDao.upadateDate(memInfo);
		
	}


	





}
