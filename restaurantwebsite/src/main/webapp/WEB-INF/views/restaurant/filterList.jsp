<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link rel="stylesheet" href="../resources/css/filterList.css">
<link rel="stylesheet" href="../resources/css/main.css">
<%@ include file="../includes/header.jsp" %>
<section id="map">
	<div class="restMap" >
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3261.751331165858!2d126.90398314999999!3d35.16282195!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x35718c66e2766641%3A0x13e76b577724ed56!2z6rSR7KO86rSR7Jet7IucIOu2geq1rCDqsr3slpHroZwxMDPrsojquLg!5e0!3m2!1sko!2skr!4v1693549762414!5m2!1sko!2skr" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		<div id="userName">혜진님을 위한 맛집</div>
		<button type="button" class="btn btn-outline-dark">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cursor-fill" viewBox="0 0 16 16">
  				<path d="M14.082 2.182a.5.5 0 0 1 .103.557L8.528 15.467a.5.5 0 0 1-.917-.007L5.57 10.694.803 8.652a.5.5 0 0 1-.006-.916l12.728-5.657a.5.5 0 0 1 .556.103z"/>
			</svg>
		</button>
	</div>
</section>

<!--카테고리별 식당 list 출력  -->
<section class="listB">
	<div class="container">
		<c:forEach items ="${ restListAll}" var="list">
			<article>
				<a href="#">
					<img src = "${list.restFileName}" alt="이미지가 없습니다.">
					<div class="text">
						<h2>${list.fcltyNm }</h2>
						<p>${list.ctgryTwoNm }</p>
						<p>${list.legaldongNm }</p>
					</div>
				</a>
			</article>
		</c:forEach>
	</div>
	<c:if test="${empty restListAll}">
		<div class="container">
			<article>
				<a href="#">
					<div class="text" style="width: 100%; background-color: rgba(0, 0, 0, 0.125);  text-align: center; height:200px; font-size: 25px; padding-top:70px; margin:0px;">
						식당이 없습니다.
					</div>
				</a>
			</article>
		</div>
	</c:if>
</section>
		
			
<div id="topButton">
	<a href="#">
		<svg xmlns="http://www.w3.org/2000/svg" width="45" height="45" fill="currentColor"  class="bi bi-arrow-up-square-fill" viewBox="0 0 16 16">
	 			<path d="M2 16a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2zm6.5-4.5V5.707l2.146 2.147a.5.5 0 0 0 .708-.708l-3-3a.5.5 0 0 0-.708 0l-3 3a.5.5 0 1 0 .708.708L7.5 5.707V11.5a.5.5 0 0 0 1 0z"/>
		</svg>
	</a>
</div>

<footer>
	<div class="footA">
		<h2>(주)푸드킬러</h2>
			<p>
				광주광역시 북구 경양로 100번길<br>
			</p>
			<p>
				이메일 문의(chwang6641@naver.com)<br>
			</p>
			<p>
				전화문의(010-6641-3626)(평일 10:00 ~ 19:00)<br>
			</p>
	</div>
</footer>
<script type="text/javascript">


</script>
