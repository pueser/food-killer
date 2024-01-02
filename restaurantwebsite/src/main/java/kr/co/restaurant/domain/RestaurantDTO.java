package kr.co.restaurant.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RestaurantDTO {
	private String restId; 
	private String fcltyNm;
	private String ctgryTwoNm;
	private String ctgryThreeNm;
	private String legaldongNm;
	private String lnbrNo;
	private String lcLa;
	private String lcLo;
	private String rdnmadrNm;
	private String lnmAddr;
	private String telNo;
	private String workdayOperTimeDc;
	private String wkendOperTimeDc;
	private String freParkngAt;
	private String valetParkngPosblAt;
	private String infnChairLendPosblAt;
	private String wchairHoldAt;
	private String petPosblAt;
	private String vgtrMenuHoldAt;
	
	//RestaurantImgDTO
	private String restUuid;
	private String restFileName;
	
}
