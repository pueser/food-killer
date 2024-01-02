package kr.co.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RestaurantImgDTO {

	private String restUuid;
	private String restFileName;
	
	private String restId; 
	
}
