package kr.co.lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LombokTest {
	private String id;
	private String name;
	private String age;
}
