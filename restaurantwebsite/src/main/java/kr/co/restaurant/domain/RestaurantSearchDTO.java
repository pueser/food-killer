package kr.co.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RestaurantSearchDTO {
	
	//검색어
	private String restSearch;
	//검색어가 초성인경우 범위(가~힣)
	private String searchRange1;
	private String searchRange2;
	//검색어가 초성인지 일반인지 구분
	private String choDiv;
}
