package kr.co.restaurant;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;
import kr.co.restaurant.domain.API.RestaurantImg;
import kr.co.restaurant.domain.API.RestaurantImgs;
import kr.co.restaurant.service.IRestaurantService;


@Controller
public class RestaurantImgController {
	String uploadFolder = "C:\\workspace\\spring4-4.10.0.RELEASE\\restaurantwebsite\\src\\main\\webapp\\resources\\restaurant\\restaurantImages";
	
	@Autowired
	private IRestaurantService service;
	
	//식당 이미지 API 
	@GetMapping("/restImgAPI")
	public void restImgGET() throws Exception {
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
        
        Gson gson = new Gson();
      	//식당 restid 가져오기
        List<String> restaurantID = service.selectRestId();
        
        //gson 파싱해서 DTO객체에 담기
        ArrayList<String> foodUrl = new ArrayList<>(); // FOOD_IMG_URL 데이터(9744개) LIST 넣기
        RestaurantImgDTO restImg = new RestaurantImgDTO(); //레스토랑 이미지를(restId,restUuid,restFileName) DB에 넣을 객체 생성
   
        int i = 0;
        while(i < 24) {
        	int j = 0;
        	RestaurantImgs restImgs = gson.fromJson(sb.toString(), RestaurantImgs.class);//gson파싱
        	List<RestaurantImg> restaurantImgs = restImgs.getBody();// 406개의 데이터가 포함되어 있음.
        	while(j < 406) {
        		foodUrl.add(restaurantImgs.get(j).getFOOD_IMG_URL());
        		System.out.println("url === " + foodUrl.get(j));
        		j++;
        	}
        	i++;
        }
        System.out.println("url === " + foodUrl.size());//9744
       
        
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
	


