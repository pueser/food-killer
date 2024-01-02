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
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3261.751331165858!2d126.90398314999999!3d35.16282195!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x35718c66e2766641%3A0x13e76b577724ed56!2z6rSR7KO86rSR7Jet7IucIOu2geq1rCDqsr3slpHroZwxMDPrsojquLg!5e0!3m2!1sko!2skr!4v1693549762414!5m2!1sko!2skr" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>

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
				<a href="#"><img src = "${list.restFileName}"></a>
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
				<a href="#"><img src = "${eurFoodList.restFileName}"></a>
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
				<a href="#"><img src = "${southAmeriFoodList.restFileName}"></a>
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
				<a href="#"><img src = "${afriFoodList.restFileName}"></a>
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
				<a href="#"><img src = "${medEastFoodList.restFileName}"></a>
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

