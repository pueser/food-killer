package kr.co.restaurant.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Criteria {
	
	//현재 페이지
	private int pageNum;
	//한 페이지 당 보여질 게시물 갯수
	private int amount;
	//스킵할 게시물의 수
	private int skip;
	//기본생성자
	public Criteria() {
		this(1,10);
	}
	//생성자
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	//pagenum과 setamount가 값이 변경되기 때문에, skip???
	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1)*this.amount;
		this.pageNum = pageNum;
	}
	public void setAmount(int amount) {
		this.skip = (this.pageNum-1)*amount;
		this.amount = amount;
	}
}
