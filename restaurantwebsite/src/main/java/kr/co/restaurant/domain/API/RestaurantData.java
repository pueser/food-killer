package kr.co.restaurant.domain.API;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RestaurantData {
	@SerializedName("시설명")
	private String fcltyNm;
	@SerializedName("카테고리2")
	private String ctgryTwoNm;
	@SerializedName("카테고리3")
	private String ctgryThreeNm;
	@SerializedName("법정읍면동명칭")
	private String legaldongNm;
	@SerializedName("번지")
	private String lnbrNo;
	@SerializedName("위도")
	private String lcLa;
	@SerializedName("경도")
	private String lcLo;
	@SerializedName("도로명주소")
	private String rdnmadrNm;
	@SerializedName("지번주소")
	private String lnmAddr;
	@SerializedName("전화번호")
	private String telNo;
	@SerializedName("평일 운영시간")
	private String workdayOperTimeDc;
	@SerializedName("주말 운영시간")
	private String wkendOperTimeDc;
	@SerializedName("무료주차 가능여부")
	private String freParkngAt;
	@SerializedName("발렛주차 가능여부")
	private String valetParkngPosblAt;
	@SerializedName("유아의자 대여여부")
	private String infnChairLendPosblAt;
	@SerializedName("휠체어 보유여부")
	private String wchairHoldAt;
	@SerializedName("애완동물 동반입장 가능여부")
	private String petPosblAt;
	@SerializedName("채식메뉴 보유여부")
	private String vgtrMenuHoldAt;
	private String chosung;
}
