<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/owl.carousel.css">
<link rel="stylesheet" href="../resources/css/owl.theme.default.css">

<%@ include file="../includes/header.jsp" %>

<section id="map">
	<div class="restMap" >
		<div src="data:image/jpeg;base64,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" />
<!-- 		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3261.751331165858!2d126.90398314999999!3d35.16282195!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x35718c66e2766641%3A0x13e76b577724ed56!2z6rSR7KO86rSR7Jet7IucIOu2geq1rCDqsr3slpHroZwxMDPrsojquLg!5e0!3m2!1sko!2skr!4v1693549762414!5m2!1sko!2skr" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe> -->

		<c:if test="${not empty login}">
			<div id="userName">${nickName}님을 위한 맛집</div>
		</c:if>
		<button type="button" class="btn btn-outline-dark">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cursor-fill" viewBox="0 0 16 16">
  				<path d="M14.082 2.182a.5.5 0 0 1 .103.557L8.528 15.467a.5.5 0 0 1-.917-.007L5.57 10.694.803 8.652a.5.5 0 0 1-.006-.916l12.728-5.657a.5.5 0 0 1 .556.103z"/>
			</svg>
		</button>
	</div>
</section>

<section id="Korean_food">
	<div id="titleA">아시아음식</div>
	<div id="wrapper">
    <div class="owl-carousel owl-theme" >
		<c:forEach items ="${ asiaFoodList}" var="list">
	    	<div class="item">
				<c:set var="restId" value="${list.restId}"></c:set>
				<c:url value="/restaurant/detailPage?restId=${restId}" var="detailUrl"></c:url>
				<a href="${detailUrl}">
					<img src = "${list.restFileName}">
				</a>
				<div id="menuIrum"><h2>${list.fcltyNm }</h2></div>
				<p>${list.ctgryTwoNm }</p>
				<p>${list.legaldongNm }</p>
        	</div>
		</c:forEach>
	</div>
	</div>
</section>

<section id="Western_food">
	<div id="titleB">유럽음식</div>
	<div id="wrapper">
    <div class="owl-carousel owl-theme">
		<c:forEach items ="${ eurFoodList}" var="eurFoodList">
	    	<div class="item">
				<c:set var="restId" value="${list.restId}"></c:set>
				<c:url value="/restaurant/detailPage?restId=${restId}" var="detailUrl"></c:url>
				<a href="${detailUrl}">
				<img src = "${eurFoodList.restFileName}">
				</a>
				<div id="menuIrum"><h2>${eurFoodList.fcltyNm }</h2></div>
				<p>${eurFoodList.ctgryTwoNm }</p>
				<p>${eurFoodList.legaldongNm }</p>
        	</div>
		</c:forEach>
	</div>
	</div>
</section>

<section id="Chinese_food">
	<div id="titleC">남미음식</div>
	<div id="wrapper">
    <div class="owl-carousel owl-theme">
		<c:forEach items ="${ southAmeriFoodList}" var="southAmeriFoodList">
	    	<div class="item">
				<c:set var="restId" value="${list.restId}"></c:set>
				<c:url value="/restaurant/detailPage?restId=${restId}" var="detailUrl"></c:url>
				<a href="${detailUrl}">
					<img src = "${southAmeriFoodList.restFileName}">
				</a>
				<div id="menuIrum"><h2>${southAmeriFoodList.fcltyNm }</h2></div>
				<p>${southAmeriFoodList.ctgryTwoNm }</p>
				<p>${southAmeriFoodList.legaldongNm }</p>
        	</div>
		</c:forEach>
	</div>
	</div>
</section>

<section id="Japanese_food">
	<div id="titleD">아프리카음식</div>
	<div id="wrapper">
    <div class="owl-carousel owl-theme">
		<c:forEach items ="${ afriFoodList}" var="afriFoodList">
	    	<div class="item">
				<c:set var="restId" value="${list.restId}"></c:set>
				<c:url value="/restaurant/detailPage?restId=${restId}" var="detailUrl"></c:url>
				<a href="${detailUrl}">
					<img src = "${afriFoodList.restFileName}">
				</a>
				<div id="menuIrum"><h2>${afriFoodList.fcltyNm }</h2></div>
				<p>${afriFoodList.ctgryTwoNm }</p>
				<p>${afriFoodList.legaldongNm }</p>
        	</div>
		</c:forEach>
	</div>
	</div>
</section>

<section id="Asian_food">
	<div id="titleE">중동음식</div>
	<div id="wrapper">
    <div class="owl-carousel owl-theme">
		<c:forEach items ="${ medEastFoodList}" var="medEastFoodList">
	    	<div class="item">
				<c:set var="restId" value="${list.restId}"></c:set>
				<c:url value="/restaurant/detailPage?restId=${restId}" var="detailUrl"></c:url>
				<a href="${detailUrl}">
					<img src = "${medEastFoodList.restFileName}">
				</a>
				<div id="menuIrum"><h2>${medEastFoodList.fcltyNm }</h2></div>
				<p>${medEastFoodList.ctgryTwoNm }</p>
				<p>${medEastFoodList.legaldongNm }</p>
        	</div>
		</c:forEach>
	</div>
	</div>
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
</body>

</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src="../resources/js/owl.carousel.js"></script>
<script src="../resources/js/owl.autoplay.js"></script>
<script src="../resources/js/owl.navigation.js"></script>
<script>

/* food carousel js*/
$(function () {
    $('.owl-carousel').owlCarousel({
        items: 4,
        margin: 10,
        loop: true,
        nav: true,
        navText: ['이전', '다음'],
        /* autoplay: false, */
        /* autoplayTimeout: 3000,
        autoplayHoverPause: true */
    });
});
</script>

