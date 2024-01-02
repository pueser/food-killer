package kr.co.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CategoryDTO {
	private String freParkngAt;
	private String valetParkngPosblAt;
	private String infnChairLendPosblAt;
	private String wchairHoldAt;
	private String petPosblAt;
	private String vgtrMenuHoldAt;
	private String southAmeri;
	private String aisa;
	private String northAmeri;
	private String afri;
	private String oceania;
	private String eur;
	private String medEast;
	private String carriSea;
	private String medTerr;
	private String foodAll;
	private String serviceAll;
}
