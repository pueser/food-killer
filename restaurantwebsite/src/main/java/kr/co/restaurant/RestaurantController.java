package kr.co.restaurant;



import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.Criteria;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;
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
	
	@RequestMapping(value = "/detailPage", method = RequestMethod.GET)
	public void detailPage() {
		
	}
	
	@RequestMapping(value = "/filterList", method = RequestMethod.GET)
	public void filterList(CategoryDTO categoryDto , Model model, Criteria cri) throws Exception{
		//카테고리별 식당 list 출력
		List<RestaurantDTO> restDto = service.listAll(categoryDto, cri);
		model.addAttribute("restListAll",restDto);
		
		//페이징 처리
		//service.getListPaging(cri);
		//model.addAttribute("restListAll", service.getListPaging(cri));
		
	}
	
	//식당 API 
	@GetMapping("/restAPI")
	public void restAPIGET() throws Exception {
		StringBuffer urlBuilder = new StringBuffer("https://api.odcloud.kr/api/15111398/v1/uddi:65f027c0-2c92-411b-b9f5-cb7382fde662?");
		urlBuilder.append("serviceKey=xx4DIEK9h8d0qDk00eu%2Bzu8DZDE8XLRMrkIRA6FDe%2FYEURzeZ8j6ACMqfNldYEADOeI7RFf0T0Rxe2fl9Apdtg%3D%3D");
		
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
        
        Gson gson = new Gson();
      	//식당 restid 가져오기
//        List<String> restaurantID = service.selectRestId();
//        
//        //gson 파싱해서 DTO객체에 담기
//        ArrayList<String> foodUrl = new ArrayList<>(); // FOOD_IMG_URL 데이터(9744개) LIST 넣기
//        RestaurantImgDTO restImg = new RestaurantImgDTO(); //레스토랑 이미지를(restId,restUuid,restFileName) DB에 넣을 객체 생성
//   
//        int i = 0;
//        while(i < 24) {
//        	int j = 0;
//        	RestaurantImgs restImgs = gson.fromJson(sb.toString(), RestaurantImgs.class);//gson파싱
//        	List<RestaurantImg> restaurantImgs = restImgs.getBody();// 406개의 데이터가 포함되어 있음.
//        	while(j < 406) {
//        		foodUrl.add(restaurantImgs.get(j).getFOOD_IMG_URL());
//        		System.out.println("url === " + foodUrl.get(j));
//        		j++;
//        	}
//        	i++;
//        }
//        System.out.println("url === " + foodUrl.size());//9744
//       
//        
//        //DB에 9502개 데이터(restId,restUuid,restFileName)  넣기
//        for (int k = 0; k < 9502; k++) {
//        	String restId = restaurantID.get(k); 
//        	String restUuid = UUID.randomUUID().toString(); 
//        	String restFileName = foodUrl.get(k);
//        	
//        	System.out.println("id === " + restId);
//        	System.out.println("uuid === " + restUuid);
//        	System.out.println("fileName === " + restFileName);
//        	
//        	restImg.setRestFileName(restFileName);
//        	restImg.setRestId(restId);
//        	restImg.setRestUuid(restUuid);
//        	
//        	service.insertImgList(restImg);
//        	System.out.println("restImg === " + restImg.toString());
//        	
//        }
//        
//        System.out.println("url 갯수 === " + foodUrl.size());
        

        
	}     

}
