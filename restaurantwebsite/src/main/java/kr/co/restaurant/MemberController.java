package kr.co.restaurant;

import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.MemberAttachDTO;
import kr.co.restaurant.domain.MemberDTO;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.persistence.IRestaurantDAO;
import kr.co.restaurant.service.IMemberService;
import kr.co.restaurant.service.IRestaurantService;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@SessionAttributes("member")
@Log4j
public class MemberController {
	@Autowired
	public IMemberService service;
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	private IRestaurantService restService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(MemberDTO mDto, Model model) throws Exception {
		
	}
	@RequestMapping(value = "/agree", method = RequestMethod.GET)
	public void agreeGET() throws Exception {
		log.info("loginCheck get....................");
	}
	
	@RequestMapping(value = "/explain", method = RequestMethod.GET)
	public void explain() throws Exception {
		
		
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join() throws Exception {
		
	}
	@RequestMapping(value = "/findPwd", method = RequestMethod.GET)
	public void findPwd() throws Exception {
		
	}
	@RequestMapping(value = "/widthdrawal", method = RequestMethod.GET)
	public void widthdrawal() throws Exception {
		
	}
	
	// 회원탈퇴(회원정보 수정 'WIDTHDRAW', 프로필 삭제)
	@RequestMapping(value = "/widthdrawal", method = RequestMethod.POST)
	public String widthdrawal(HttpSession session, MemberDTO member)throws Exception{
		MemberDTO memInfo = (MemberDTO) session.getAttribute("login");
		String widthdrawalAgree = member.getWidthdrawalAgree();/*회원 탈퇴 동의 여부*/
		
		/*회원 프로필 정보 가져온 후 파일 삭제*/
		MemberAttachDTO memAttachDto = service.selectProfile(memInfo);
		File file = null;
		if(!memAttachDto.getUuid().equals("a")) {
			/*update 전 썸네일 파일 삭제 */
			file = new File("C:\\workspace\\spring4-4.10.0.RELEASE\\restaurantwebsite\\src\\main\\webapp\\resources\\fileUpload\\profile\\", "s_" +  memAttachDto.getUuid() + "_" + memAttachDto.getFileName()); 
			file.delete();
			
			/*update 전 원본 파일 삭제 */
			String originFileName = file.getAbsolutePath().replace("s_", ""); //이미 썸네일 파일 지정하면서 file경로가 있기 때문에..
			file = new File(originFileName);
			file.delete();
		}
		
		/*회원정보 삭제*/
		service.deleteMember(memInfo, widthdrawalAgree);
		
		Object obj = session.getAttribute("login"); // 세션이 객체이기 때문 object로 담아준다. 
		System.out.println("세션객체 확인 === >" + obj);
		
		if(obj != null) { //로그인 된 상태
			session.removeAttribute("login"); // 객체 비움
			session.invalidate(); // 소멸 시켜준다.
		}
		
		return "redirect:/main/main";
	}
	
	//회원 프로필 정보 GET
	@RequestMapping(value = "/modifyMember", method = RequestMethod.GET)
	public void modifyMemberGET(HttpSession session, Model model) throws Exception {
		//회원 DB에 있는 profile 이미지 꺼내오기
		MemberDTO memInfo = (MemberDTO) session.getAttribute("login");
		MemberAttachDTO memAttachDto =  service.selectProfile(memInfo);
		
		model.addAttribute("memAttachDto", memAttachDto);
	}
	
	//회원 프로필 정보 수정
	@RequestMapping(value="/modifyMember", method = RequestMethod.POST)
		public String modifyMemberPOST(HttpSession session, MemberAttachDTO uploadResultArr, MemberDTO memberDto, RedirectAttributes rttr)throws Exception{
			MemberDTO memInfo = (MemberDTO) session.getAttribute("login");
			
			/*회원 비밀번호 수정*/
			String ranPwd = memberDto.getPwd();
			String uuidCheck = uploadResultArr.getUuid();
			
			
			
			if(!ranPwd.equals("") || uploadResultArr.getUuid() != null) {//비번수정을하거나, 이미지 수정 했을 때
				if(!ranPwd.equals("")) {// 비번수정
					String email = memInfo.getEmail();
					service.updatePwd(ranPwd, email);
					
					System.out.println("비번 수정완료");
				}
				
				if(uploadResultArr.getUuid() != null) { //이미지 수정 했을 때
					System.out.println("이미지 수정");
					/*회원 DB의 profile uuid 취득*/
					MemberAttachDTO MemberAttachDTO = service.selectProfile(memInfo);
					String uuid = MemberAttachDTO.getUuid();
					String fileName = MemberAttachDTO.getFileName();
					
					/*회원 DB에 수정한 profile 이미지 update*/
					service.updateProfile(uploadResultArr, memInfo);
					File file = null;
				
						if(!uuid.equals("a")) {
							/*update 전 썸네일 파일 삭제 */
							file = new File("C:\\workspace\\spring4-4.10.0.RELEASE\\restaurantwebsite\\src\\main\\webapp\\resources\\fileUpload\\profile\\", "s_" +  uuid + "_" + fileName); 
							file.delete();
							
							/*update 전 원본 파일 삭제 */
							String originFileName = file.getAbsolutePath().replace("s_", ""); //이미 썸네일 파일 지정하면서 file경로가 있기 때문에..
							file = new File(originFileName);
							file.delete();
						}
					System.out.println("프로필 파일 변경 완료");
				}
				rttr.addFlashAttribute("msg", "정보가 수정되었습니다.");
				return "redirect:/member/modifyMember";
			}else {
				rttr.addFlashAttribute("msg", "수정한 정보가 없습니다.");
				return "redirect:/member/modifyMember";
			}
		}
	
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public String loginPost(MemberDTO mDto,Model model, HttpSession session,RedirectAttributes rttr) throws Exception {
		log.info("loginPost get....................");
		String returnURL = "";
		MemberDTO memInfo = service.loginCheck(mDto); //로그인 정보가 들어있음
		//System.out.println("로그인 전에 로그인 회원 정보 확인 +++++++++++++" + memInfo.toString());
		if(memInfo == null || memInfo.getMemberState().equals("WITHDRAW")) {
			//rttr.addFlashAttribute("list", mDto.getEmail());
			rttr.addFlashAttribute("list", "이메일 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/member/login";
		}
		model.addAttribute("memInfo", memInfo);
		
		
				
		return returnURL;
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) throws Exception {
		log.info("logout=================");
		Object memInfo = session.getAttribute("login"); // 세션이 객체이기 때문 object로 담아준다. 
		if(memInfo != null) { //로그인 된 상태
			service.upadateDate(memInfo);
			System.out.println("updatedate 바꾸기");
			session.removeAttribute("login"); // 객체 비움
			session.invalidate(); // 소멸 시켜준다.
		}
		return "redirect:/main/main";
	}
	
	//step1 요청메소드 실행전에 model이 session에 담기도록
	@ModelAttribute("member")
	public MemberDTO member() {
		return new MemberDTO();
	}
	//약관동의 session 저장
	@RequestMapping(value = "/joinStep1", method = RequestMethod.POST)
	public String joinStep1(@ModelAttribute("member") MemberDTO member, Model model) throws Exception {
		System.out.println("memberDTO 약관동의 T1 = " + member.getT1());
		return "redirect:/member/join";
	}
	//회원가입 session 저장
	@RequestMapping(value = "/joinStep2", method = RequestMethod.POST)
	public String joinStep2(@ModelAttribute("member") MemberDTO member,Model model, SessionStatus sessionStatus,RedirectAttributes rttr) throws Exception {
		//회원가입시 기본 프로필 저장
		MemberAttachDTO memberAttachDTO = new MemberAttachDTO();
		
		String uuid = "a";
		String fileName = "anonymousImg.png";

		memberAttachDTO.setUuid(uuid);
		memberAttachDTO.setFileName(fileName);
		
		//탈퇴후 재가입 회원인지 판단
		int reJoinResult = service.selectMemberState(member);
		System.out.println("reJoinResult 결과 = " + reJoinResult);
		if(reJoinResult != 0) {
			//재가입 회원 MemberState 변경(ING)
			String joinResult = service.memberSave(member, memberAttachDTO, reJoinResult);//닉네임 돌려줌
			String msgSuccess = joinResult + "님 환영합니다. 로그인을 진행해 주세요.";
			String msgFail = "회원가입에 실패하였습니다.";
			
			if(joinResult != null) {
				sessionStatus.setComplete(); // sessionStatus 세션 해제
				rttr.addFlashAttribute("message", msgSuccess);
				return "redirect:/member/login";
			}else {
				rttr.addFlashAttribute("message", msgFail);
				return "redirect:/member/join";
			}
			
		}else {
			//새로운 회원 회원가입
			String joinResult = service.memberSave(member, memberAttachDTO, reJoinResult); //닉네임 돌려줌
			String msgSuccess = joinResult + "님 환영합니다. 로그인을 진행해 주세요.";
			String msgFail = "회원가입에 실패하였습니다.";
			
			if(joinResult != null) {
				sessionStatus.setComplete(); // sessionStatus 세션 해제
				rttr.addFlashAttribute("message", msgSuccess);
				return "redirect:/member/login";
			}else {
				rttr.addFlashAttribute("message", msgFail);
				return "redirect:/member/join";
			}
		}
		
	}
	//회원가입 및 약관동의 취소시 세션 해제
	@RequestMapping(value = "/joinCancel", method = RequestMethod.GET)
	public String joinCancel(SessionStatus sessionStatus) throws Exception {
		sessionStatus.setComplete(); //세션 해제
		return "redirect:/main/main";
	}
	//회원가입 이메일 인증코드 발송
	@RequestMapping(value="/emailChk", method=RequestMethod.GET)
    public ResponseEntity<String> emailChk(String email) throws Exception{
        
        System.out.println("이메일 : " + email);
        int emailCheck = service.emailChk(email);
        
        if(emailCheck != 0) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(email);
        }else {
        	//난수생성
        	Random random = new Random();
        	int randomNum = random.nextInt(899999) + 100000;
        	
        	//이메일 보내기
        	String setFrom = "hwanghyejin932@gmail.com";
        	String toMail = email;
        	String title = "<푸드킬러>회원가입 인증 이메일 입니다.";
        	String content = 
        			"홈페이지를 방문해주셔서 감사합니다." +
        					"<br><br>" + 
        					"인증 번호는 " + randomNum + "입니다." + 
        					"<br>" + 
        					"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
//        try {
//            
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//            helper.setFrom(setFrom);
//            helper.setTo(toMail);
//            helper.setSubject(title);
//            helper.setText(content,true);
//            mailSender.send(message);
//            
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        	
        	String num = Integer.toString(randomNum);
        	return ResponseEntity.status(HttpStatus.OK).body(num);
        	
        }
        
    }
	
	//임시비밀번호 전송전 이메일 확인
	@RequestMapping(value="/findPwdEmail", method=RequestMethod.POST)
	@ResponseBody
	public String findPwdEmail(@RequestParam String email) throws Exception{
		int result = service.emailChk(email);
		if(result != 1) {
			return "fail";
		}else {
		//뷰(View)로부터 넘어온 데이터 확인
		log.info("이메일 데이터 전송 확인");
		log.info("인증번호 : " + email);
		
		//임시비밀번호 생성
		StringBuffer buf = new StringBuffer();
		Random random = new Random();

		char[] pwdSet1 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

		char[] pwdSet2 = { '!', '@', '#', '$', '%', '^', '&', '*' };
		char[] pwdSet3 = {'1', '2', '3', '4', '5', '6', '7', '8','9', '0'};
		for (int i = 0; i < 6; i++) {
			buf.append(pwdSet1[random.nextInt(pwdSet1.length)]);
		}
		for (int i = 0; i < 1; i++) {
			buf.append(pwdSet2[random.nextInt(pwdSet2.length)]);
		}
		for (int i = 0; i < 1; i++) {
			buf.append(pwdSet3[random.nextInt(pwdSet3.length)]);
		}
		
		String ranPwd = buf.toString();
		
		//이메일 보내기
		String setFrom = "hwanghyejin932@gmail.com";
		String toMail = email;
		String title = "<푸드킬러>임시 비밀번호 발급";
		String content = 
				"임시 비밀번호 입니다. 해당 비밀번호로 로그인 후 비밀번호를 변경해주세요." +
						"<br><br>" + 
						"임시비밀번호는 " + ranPwd + "입니다.";
        try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
			service.updatePwd(ranPwd, email);
			return "success";
		}

	}
	
	//회원가입시 닉네임 중복여부 확인
	@RequestMapping(value="/nickNameChk", method = RequestMethod.POST)
	@ResponseBody
	public String nickNameChk(String nickName)throws Exception {
		int result = service.nickNameChk(nickName);
		
		if(result != 0) {
			return "fail"; //중복된 닉네임 존재
		}else {
			return "success"; // 중복된 닉네임 없음
		}
	}
	
	
		
}

