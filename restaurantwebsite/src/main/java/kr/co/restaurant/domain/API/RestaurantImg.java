package kr.co.restaurant.domain.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantImg {
	
	//식당 ID
	private int RSTR_ID;
	
	//식당명
	private String RSTR_NM;
	
	//지역명
	private String AREA_NM;
	
	//메뉴 ID
	private int MENU_ID;
	
	// 음식이미지
	private String FOOD_IMG_URL;
	
	
}
