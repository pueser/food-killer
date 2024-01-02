package kr.co.restaurant;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.restaurant.domain.MemberDTO;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.service.IMemberService;
import kr.co.restaurant.service.IRestaurantService;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/main")
@Log4j
public class MainController {
	@Autowired
	public IMemberService service;
	@Autowired
	private IRestaurantService restService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main(Model model, HttpSession session) throws Exception {
		
		//지도위 닉네임 표시
		if(session.getAttribute("login") != null) {
			MemberDTO loginDto = (MemberDTO) session.getAttribute("login");
			System.out.println("session의 이메일 ==" + loginDto.getEmail());
			System.out.println("session의 패스워드 ==" + loginDto.getPwd());
			
			
			MemberDTO member = service.loginCheck(loginDto);
			String nickName = member.getNickName();
			System.out.println("nickName === " + nickName);
			model.addAttribute("nickName", nickName);
		}
		
		//메인 Swipe이미지 출력
		List<String> ctgryTwoNm = new ArrayList<String>();
		
		
		//유럽 식당 Swipe 표시
		ctgryTwoNm.add("유럽음식");
		System.out.println("식당 Swipe 데이터 == " + ctgryTwoNm.toString());
		List<RestaurantDTO> eurFoodList = restService.foodListSwipe(ctgryTwoNm);
		model.addAttribute("eurFoodList",eurFoodList);
		
		//남미 식당 Swipe 표시
		ctgryTwoNm.set(0, "남미음식");
		System.out.println("식당 Swipe 데이터 == " + ctgryTwoNm.toString());
		List<RestaurantDTO> southAmeriFoodList = restService.foodListSwipe(ctgryTwoNm);
		model.addAttribute("southAmeriFoodList",southAmeriFoodList);
		
		//중동음식 식당 Swipe 표시
		ctgryTwoNm.set(0, "중동음식");
		System.out.println("식당 Swipe 데이터 == " + ctgryTwoNm.toString());
		List<RestaurantDTO> medEastFoodList = restService.foodListSwipe(ctgryTwoNm);
		model.addAttribute("medEastFoodList",medEastFoodList);
		
		//아프리카 식당 Swipe 표시
		ctgryTwoNm.set(0, "아프리카음식");
		ctgryTwoNm.add("아프리카");
		System.out.println("식당 Swipe 데이터 == " + ctgryTwoNm.toString());
		List<RestaurantDTO> afriFoodList = restService.foodListSwipe(ctgryTwoNm);
		model.addAttribute("afriFoodList",afriFoodList);
		
		//아시아 식당 Swipe 표시
		ctgryTwoNm.set(0,"동아시아음식");
		ctgryTwoNm.set(1,"동남아시아음식");
		ctgryTwoNm.add("서아시아음식");
		ctgryTwoNm.add("인도아시아음식");
		System.out.println("식당 Swipe 데이터 == " + ctgryTwoNm.toString());
		List<RestaurantDTO> asiaFoodList = restService.foodListSwipe(ctgryTwoNm);
		model.addAttribute("asiaFoodList",asiaFoodList);

	}

}
