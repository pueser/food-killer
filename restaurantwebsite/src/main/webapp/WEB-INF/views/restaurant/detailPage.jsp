<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/detailPage.css">
<%@ include file="../includes/header.jsp" %>
<div class="line">
			</div>			
			<div class="content_top">
				<div class="ct_left_area">
					<div class="image_wrap">
						<img src="${restUrl}">
					</div>				
				</div>
				<div class="ct_right_area">
					<div class="title">
						<h1>
							${restDto.fcltyNm}
						</h1>
					</div>
					<div class="line">
					</div>
					<div class="detail">
						 <span>
						 	음식종류 : ${restDto.ctgryThreeNm}
						 </span>
					</div>
					<div class="detail">
						 <span>
						 	주소 : ${restDto.rdnmadrNm}
						 </span>
					</div>
					<div class="line">
					</div>	
					<div class="time">
						<div>평일 운영시간 : ${restDto.workdayOperTimeDc}</div>
						<div>주말 운영시간 : ${restDto.wkendOperTimeDc}</div>
					</div>		
					<div class="time">
						<div>전화번호 : ${restDto.telNo}</div>
					</div>		
					<div class="line">
					</div>	
					
				</div>
			</div>
						
			
			
<%@ include file="../includes/footer.jsp" %>
<script type="text/javascript">
console.log(${restDto.fcltyNm});
</script>