package kr.co.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MemberAttachDTO {
	private String uuid;
	private String fileName;
	
	private String nickName;
}
