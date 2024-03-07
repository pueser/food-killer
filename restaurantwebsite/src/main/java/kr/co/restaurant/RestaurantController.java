package kr.co.restaurant;



import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.Criteria;
import kr.co.restaurant.domain.PageMakerDTO;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;
import kr.co.restaurant.domain.RestaurantSearchDTO;
import kr.co.restaurant.domain.API.Restaurant;
import kr.co.restaurant.domain.API.RestaurantData;
import kr.co.restaurant.domain.API.RestaurantImg;
import kr.co.restaurant.domain.API.RestaurantImgs;
import kr.co.restaurant.service.IRestaurantService;
import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/restaurant")
@Log4j
public class RestaurantController {
	
	@Autowired
	public IRestaurantService service;
	
	@RequestMapping(value ="/filter", method = RequestMethod.GET)
	public void listFilter() throws Exception {
		
	}
	
	//식당 상세페이지
	@RequestMapping(value = "/detailPage", method = RequestMethod.GET)
	public String detailPage(@RequestParam("restId")String restId, Model model) throws Exception {
		System.out.println("detailPage get....");
		System.out.println("받아온 restId =" + restId);
		
		//식당 정보찾기
		RestaurantDTO restDto = service.detailPage(restId);
		System.out.println("restDto = " + restDto.toString());
		
		//식당 이미지 url
		String url = service.detailPageImgUrl(restId);
		System.out.println("url = " + url);
		
		model.addAttribute("restDto", restDto);
		model.addAttribute("restUrl", url);
		
		return "restaurant/detailPage";
	}
	
	
	@RequestMapping(value = "/filterList", method = RequestMethod.GET)
	public void filterList(CategoryDTO categoryDto , Model model, Criteria cri, String choDiv) throws Exception{
		System.out.println("filterList get...");
		System.out.println("cri = " + cri.toString());
		System.out.println("categoryDto = " + categoryDto.toString());
		System.out.println("choDiv = " + choDiv);

		
		model.addAttribute("categoryDto", categoryDto);
		model.addAttribute("cri", cri);
		
		
		
		//식당이름 검색
		/* 초성 리스트 */
		List<String> index_list = new ArrayList<>();
		index_list.add("ㄱ");
		index_list.add("ㄴ");
		index_list.add("ㄷ");    
		index_list.add("ㄹ");
		index_list.add("ㅁ");
		index_list.add("ㅂ");
		index_list.add("ㅅ");
		index_list.add("ㅇ");
		index_list.add("ㅈ");    
		index_list.add("ㅊ");
		index_list.add("ㅋ");
		index_list.add("ㅌ");
		index_list.add("ㅍ");
		index_list.add("ㅎ");
		
		/* 검색어가 초성인경우 */
		RestaurantSearchDTO restSearchDto = new RestaurantSearchDTO(); 
		String restSearch = cri.getRestSearch();
		String searchRange1 = null;
		String searchRange2 = null;
		int num = 0;
		if((choDiv.equals("choSrch") && restSearch != null) || choDiv.equals("choMoreSrch")) {
			/* 한글자 초성 */
			if(cri.getRestSearch().length() == 1) {
				for( int i = 0; i < index_list.size(); i++ ) {
				    if( restSearch.equals(index_list.get(i)) ) {
				    
				        num = i + 1;
				        break;
				    }
				}
				/* 초성 글자 범위 설정 */
				if(num == 1) {
					searchRange1 = "가";
					searchRange2 = "나";
				}else if(num == 2) {
					searchRange1 = "나";
					searchRange2 = "다";
				}else if(num == 3) {
					searchRange1 = "다";
					searchRange2 = "라";
				}else if(num == 4) {
					searchRange1 = "라";
					searchRange2 = "마";
				}else if(num == 5) {
					searchRange1 = "마";
					searchRange2 = "바";
				}else if(num == 6) {
					searchRange1 = "바";
					searchRange2 = "사";
				}else if(num == 7) {
					searchRange1 = "사";
					searchRange2 = "아";
				}else if(num == 8) {
					searchRange1 = "아";
					searchRange2 = "자";
				}else if(num == 9) {
					searchRange1 = "자";
					searchRange2 = "차";
				}else if(num == 10) {
					searchRange1 = "차";
					searchRange2 = "카";
				}else if(num == 11) {
					searchRange1 = "카";
					searchRange2 = "타";
				}else if(num == 12) {
					searchRange1 = "타";
					searchRange2 = "파";
				}else if(num == 13) {
					searchRange1 = "파";
					searchRange2 = "하";
				}else  {
					searchRange1 = "하";
					searchRange2 = "힝";
				}
				
				restSearchDto.setChoDiv("choSrch");
				restSearchDto.setSearchRange1(searchRange1);
				restSearchDto.setSearchRange2(searchRange2);
				
			/* 한글자 이상 초성 */
			}else {
				restSearchDto.setChoDiv("choMoreSrch");
				restSearchDto.setRestSearch(restSearch);
			}
		}
		/* 검색어가 일반글자인 경우 */
		if(choDiv.equals("gnrlSrch") && restSearch != null) {
			restSearchDto.setChoDiv("gnrlSrch");
			restSearchDto.setRestSearch(restSearch);
		}
		
		System.out.println("restSearchDto = " + restSearchDto.toString());
		model.addAttribute("restSearchDto",restSearchDto);
        
		//페이징 처리
		int total = service.restTotalCnt(categoryDto, restSearchDto);
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker", pageMake);
		
		System.out.println("total = " + total);
		System.out.println("pageMaker = " + pageMake.toString());
		
		//카테고리별 식당 list 출력
		List<RestaurantDTO> restDto = service.listAll(categoryDto, cri, restSearchDto);
		model.addAttribute("restListAll",restDto);
		
	}
	
	
	
	
	//식당 API 
	@GetMapping("/restAPI")
	public void restAPIGET() throws Exception {
		/* 식당이름 저장 */
    	ArrayList<String> fcltyNmList = new ArrayList<String>();
		/* API 데이터 담기 */
    	ArrayList<RestaurantData> data = new ArrayList<RestaurantData>();
		int count = 0;
		for (int i = 0; i < 3; i++) {
			
			StringBuffer urlBuilder = new StringBuffer("https://api.odcloud.kr/api/15111398/v1/uddi:65f027c0-2c92-411b-b9f5-cb7382fde662?");
			urlBuilder.append("serviceKey=xx4DIEK9h8d0qDk00eu%2Bzu8DZDE8XLRMrkIRA6FDe%2FYEURzeZ8j6ACMqfNldYEADOeI7RFf0T0Rxe2fl9Apdtg%3D%3D");
			
			System.out.println("count = " + count);
			if (count == 0) {
				urlBuilder.append("&page=1");
			}else if (count == 1) {
				urlBuilder.append("&page=2");
			}else {
				urlBuilder.append("&page=3");
			}
			urlBuilder.append("&perPage=3500");
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			conn.connect();
			System.out.println("Response code: " + conn.getResponseCode());
			
			BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        String result = sb.toString();
	        count ++;
	        
	    	Gson gson = new Gson();
	    	Restaurant response = gson.fromJson(result, Restaurant.class);
	    	
			/* fcltyNmList 에 식당이름 넣기 */
	    	for (int j = 0; j < response.getData().size(); j++) {
	    		fcltyNmList.add(response.getData().get(j).getFcltyNm());
			}
	    	data.addAll(response.getData());
			
		}
		service.insertApi(data, fcltyNmList);
	}
        
    //식당 이미지 넣기(식당API에 이미지가 없어서 다른 이미지API 넣기)
	@GetMapping("/restImgAPI")
	public void restImgAPIGET() throws Exception {
		
		
		StringBuffer urlBuilder = new StringBuffer("https://busan-food.openapi.redtable.global/api/food/img?");
		urlBuilder.append("serviceKey=Iq9SZDgF7zbqKPvHvRmNu571VfEjvkUFxlzzXva53PZ6xqnCWRXJblZCpuJmdm37");
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.connect();
		System.out.println("Response code: " + conn.getResponseCode());
		
		BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        String result = sb.toString();
        
    	Gson gson = new Gson();
		
	  	//식당 restid 가져오기
	    List<String> restaurantID = service.selectRestId();
	    
	    //gson 파싱해서 DTO객체에 담기
	    ArrayList<String> foodUrl = new ArrayList<>(); // FOOD_IMG_URL 데이터 LIST 넣기
	    RestaurantImgDTO restImg = new RestaurantImgDTO(); //레스토랑 이미지를(restId,restUuid,restFileName) DB에 넣을 객체 생성
	   
        int i = 0;
	        while(i < 24) {
	        	int j = 0;
	        	RestaurantImgs restImgs = gson.fromJson(sb.toString(), RestaurantImgs.class);//gson파싱
	        	List<RestaurantImg> restaurantImgs = restImgs.getBody();
	    	while(j < 406) {
	    		foodUrl.add(restaurantImgs.get(j).getFOOD_IMG_URL());
	    		System.out.println("url === " + foodUrl.get(j));
	    		j++;
	    	}
	    	i++;
	    }
	    System.out.println("url === " + foodUrl.size());
	   
	    
	    //DB에 9502개 데이터(restId,restUuid,restFileName)  넣기
	    for (int k = 0; k < 9502; k++) {
	    	String restId = restaurantID.get(k); 
	    	String restUuid = UUID.randomUUID().toString(); 
	    	String restFileName = foodUrl.get(k);
	    	
	    	System.out.println("id === " + restId);
	    	System.out.println("uuid === " + restUuid);
	    	System.out.println("fileName === " + restFileName);
	    	
	    	restImg.setRestFileName(restFileName);
	    	restImg.setRestId(restId);
	    	restImg.setRestUuid(restUuid);
	    	
	    	service.insertImgList(restImg);
	    	System.out.println("restImg === " + restImg.toString());
	    	
	    }
	    
	    System.out.println("url 갯수 === " + foodUrl.size());
    
	}     
		

}
