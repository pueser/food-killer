package kr.co.restaurant.persistence;

import kr.co.restaurant.domain.MemberAttachDTO;
import kr.co.restaurant.domain.MemberDTO;

public interface IMemberDAO {
	public String insertMember(MemberDTO member, MemberAttachDTO memberAttachDTO, int reJoinResult) throws Exception;
	public MemberDTO read(MemberDTO loginDto) throws Exception;
	public int selectNickName(String nickName) throws Exception;
	public int selectEmail(String email) throws Exception;
	public void updatePwd(String ranPwd, String email)throws Exception;
	public MemberAttachDTO selectProfile(MemberDTO memInfo)throws Exception;
	public int updateProfile(MemberAttachDTO uploadResultArr, MemberDTO memInfo)throws Exception;
	public int deleteMember(MemberDTO memInfo, String widthdrawalAgree)throws Exception;
	public int selectMemberState(MemberDTO member)throws Exception;
	public void upadateDate(Object memInfo)throws Exception;
}
