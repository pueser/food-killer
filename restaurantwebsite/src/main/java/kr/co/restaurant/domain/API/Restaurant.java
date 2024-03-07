package kr.co.restaurant.domain.API;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Restaurant {
	@SerializedName("currentCount")
	private int currentCount;

	@SerializedName("data")
	private List<RestaurantData> data;
	
	
}
