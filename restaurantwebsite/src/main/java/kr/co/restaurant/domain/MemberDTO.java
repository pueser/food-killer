package kr.co.restaurant.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MemberDTO {
	private String nickName;
	private String email;
	private String pwd;
	private String T1;
	private String T2;
	private String T3;
	private String termsAgree;
	private Date termsDate;
	private Timestamp regdate;
	private Timestamp updatedate; 
	private String memberState;
	private String widthdrawalAgree;
	private Timestamp widthdrawalDate;
	

}
