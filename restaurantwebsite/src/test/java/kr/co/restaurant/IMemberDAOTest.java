package kr.co.restaurant;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.restaurant.domain.MemberAttachDTO;
import kr.co.restaurant.domain.MemberDTO;
import kr.co.restaurant.persistence.IMemberDAO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class IMemberDAOTest {
	@Autowired
	public IMemberDAO mDao;
	
//	@Test
//	// 회원가입
//	public void testUserListSave() throws Exception{
//		MemberDTO userList = new MemberDTO();
//		userList.setEmail("hwang6641@naver.com");
//		userList.setNickName("혜진짱");
//		userList.setPwd("ghkd3626@@");
//		mDao.create(userList);
//		log.info("userList:----------------------------------------" + userList);
//	}
	
	//로그인 체크
//	@Test
//	public void testLogin() throws Exception {
//		MemberDTO loginCheck = new MemberDTO();
//		loginCheck.setEmail("hyejin@kako.com");
//		loginCheck.setNickName("찬호짱");
//		loginCheck.setPwd("g3626@@");
//		mDao.read(loginCheck);
//		
//		log.info("loginCheck : ====================================================" + loginCheck.toString());
//	}
	
//	@Test
//	public void testNickCheck() throws Exception {
//		String nickName = "혜진짱";
//		int result = mDao.selectNickName(nickName);
//		
//		log.info("닉네임 체크 unit test ========" + result);
//	}
	
//	@Test
//	public void testMemberSave()throws Exception{
//		MemberDTO member = new MemberDTO();
//		member.setEmail("chwang6641@naver.com");
//		member.setNickName("혜진짱");
//		member.setPwd("1");
//		member.setT1("1");
//		member.setT2("1");
//		member.setT3("1");
//		
//		MemberAttachDTO memberAttachDTO = new MemberAttachDTO();
//		memberAttachDTO.setFileName("anonymousImg.png");
//		memberAttachDTO.setUuid("a");
//		
//		int reJoinResult = 1;
//		mDao.insertMember(member, memberAttachDTO, reJoinResult);
//	}
//	
//	@Test
//	public void testAgreeTerms() {
//		String terms = "01";
//	}
	
//	@Test
//	public void testEmailChk() throws Exception {
//		
//		String email = "chwang6641@naver.com";
//		mDao.selectEmail(email);
//		nickName, email, pwd, T1, T2, T3, termsAgree
//	}
	
//	@Test
//	public void testRanNum() throws Exception{
//		String ranPwd = "ghkd3626";
//		String email = "chwang6641@naver.com";
//		
//		mDao.updatePwd(ranPwd, email);
//	}
	
//	@Test
//	public void testBasicProfile()throws Exception{
//		MemberDTO member = new MemberDTO();
//		member.setEmail("chwang6641@naver.com");
//		member.setNickName("혜진짱");
//		member.setPwd("ghkd6641@");
//		member.setT1("1");
//		member.setT2("1");
//		member.setT3("1");
//		
//		MemberAttachDTO memberAttachDTO = new MemberAttachDTO();
//		
//		String uuid = UUID.randomUUID().toString();
//		String fileName = "anonymousImg.png";
//		String uploadPath = "C:\\workspace\\spring4-4.10.0.RELEASE\\restaurantwebsite\\src\\main\\webapp\\resources\\fileUpload\\anonymousImg.png";
//	
//		memberAttachDTO.setUuid(uuid);
//		memberAttachDTO.setFileName(fileName);
//		memberAttachDTO.setUploadPath(uploadPath);
//		
//		mDao.insertMember(member, memberAttachDTO);
//		
//	}
	
//	@Test
//	public void testUpdateProfile() throws Exception {
//		MemberAttachDTO uploadResultArr = new MemberAttachDTO();
//		MemberDTO memInfo = new MemberDTO();
//		
//		String uuid = "0b8a5058-0411-4043-b4f0-101aad78696b";
//		String uploadPath = "2023\10\10";
//		String fileName = "anonymousImg";
//		String nickName = "혜진짱";
//		
//		uploadResultArr.setFileName(fileName);
//		uploadResultArr.setUploadPath(uploadPath);
//		uploadResultArr.setUuid(uuid);
//		memInfo.setNickName(nickName);
//		
//		
//		mDao.updateProfile(uploadResultArr, memInfo);
//	}
	
//	@Test
//	public void testMemberState() throws Exception {
//		MemberDTO member = new MemberDTO();
//		member.setEmail("chwang6641@naver.com");
//		int result = mDao.selectMemberState(member);
//		
//		
//		log.info("MemberState 체크 unit test ========" + result);
//	}
	
//	@Test
//	public void testUpdateMemberState() throws Exception {
//		MemberDTO member = new MemberDTO();
//		member.setEmail("chwang6641@naver.com");
//		member.setNickName("혜진짱");
//		member.setPwd("ghkd6641@");
//		member.setT1("1");
//		member.setT2(null);
//		member.setT3("1");
//		mDao.updateMemberState(member);
//		
		
		//log.info("MemberState 체크 unit test ========" + result);
	//}
}
