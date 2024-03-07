package kr.co.restaurant.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Criteria {
	
	//검색조건
	private String restSearch;//검색할 키워드
	
	//현재 페이지
	private int pageNum;
	//한 페이지 당 보여질 게시물 갯수
	private int amount;
	//기본생성자
	public Criteria() {
		this(1,10);
	}
	//생성자
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	

	
}
