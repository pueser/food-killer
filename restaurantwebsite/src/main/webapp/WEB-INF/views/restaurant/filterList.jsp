<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link rel="stylesheet" href="../resources/css/filterList.css">
<link rel="stylesheet" href="../resources/css/main.css">
<%@ include file="../includes/header.jsp" %>
<style>
/* 페이지 css */
.pageInfo{
    list-style : none;
    display: inline-block;
    margin: 50px 0 0 100px;      
  }
.pageInfo li{
    float: left;
    font-size: 20px;
    margin-left: 18px;
    padding: 2px;
    font-weight: 500;
    border: 0;
  }
 a:link {color:black; text-decoration: none;}
 a:visited {color:black; text-decoration: none;}
 a:hover {color:black; text-decoration: underline;}
 .active{
      background-color: #D0B1F0;
  }
.pageInfo_wrap{
	display: flex;
    justify-content: center;
}
</style>
<!-- <section id="map">
	<div class="restMap" >
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3261.751331165858!2d126.90398314999999!3d35.16282195!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x35718c66e2766641%3A0x13e76b577724ed56!2z6rSR7KO86rSR7Jet7IucIOu2geq1rCDqsr3slpHroZwxMDPrsojquLg!5e0!3m2!1sko!2skr!4v1693549762414!5m2!1sko!2skr" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		<div id="userName">혜진님을 위한 맛집</div>
		<button type="button" class="btn btn-outline-dark">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cursor-fill" viewBox="0 0 16 16">
  				<path d="M14.082 2.182a.5.5 0 0 1 .103.557L8.528 15.467a.5.5 0 0 1-.917-.007L5.57 10.694.803 8.652a.5.5 0 0 1-.006-.916l12.728-5.657a.5.5 0 0 1 .556.103z"/>
			</svg>
		</button>
	</div>
</section> -->

<!--카테고리별 식당 list 출력  -->
<section class="listB">
	<div class="container">
		<c:forEach items ="${ restListAll}" var="list">
			<article>
				<c:set var="restId" value="${list.restId}"></c:set>
				<c:url value="/restaurant/detailPage?restId=${restId}" var="detailUrl"></c:url>
				<a href="${detailUrl}">
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
	<!-- 페이지 처리 -->
	<div class="pageInfo_wrap" style="padding-right: 200px">
        <div class="pageInfo_area">
        	<ul class = "pageInfo">
        		<!-- 이전페이지 버튼 -->
                <c:if test="${pageMaker.prev}">
                    <li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}" style="border: none"><</a></li>
                </c:if>
                
	 			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	            	 <li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"><a href="${num}" style="border: none">${num}</a></li>
	            </c:forEach>
	            
	             <!-- 다음페이지 버튼 -->
                <c:if test="${pageMaker.next}">
                    <li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }" style="border: none">></a></li>
                </c:if>    
 
            </ul>
        </div>
    </div>
	<form method="GET" id="moveForm">
		<!-- 페이징 -->
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
        <input type="hidden" name="amount" value="${pageMaker.cri.amount }"> 
        <!-- 카테고리 -->
        <input type="hidden" name="foodAll" value="${categoryDto.foodAll}" >
        <input type="hidden" name="southAmeri" value="${categoryDto.southAmeri}" >
        <input type="hidden" name="aisa" value="${categoryDto.aisa}" >
        <input type="hidden" name="northAmeri" value="${categoryDto.northAmeri}" >
        <input type="hidden" name="afri" value="${categoryDto.afri}" >
        <input type="hidden" name="oceania" value="${categoryDto.oceania}" >
        <input type="hidden" name="eur" value="${categoryDto.eur}" >
        <input type="hidden" name="medEast" value="${categoryDto.medEast}" >
        <input type="hidden" name="carriSea" value="${categoryDto.carriSea}" >
        <input type="hidden" name="medTerr" value="${categoryDto.medTerr}" >
        <input type="hidden" name="serviceAll" value="${categoryDto.serviceAll}" >
        <input type="hidden" name="freParkngAt" value="${categoryDto.freParkngAt}" >
        <input type="hidden" name="valetParkngPosblAt" value="${categoryDto.valetParkngPosblAt}" >
        <input type="hidden" name="infnChairLendPosblAt" value="${categoryDto.infnChairLendPosblAt}" >
        <input type="hidden" name="wchairHoldAt" value="${categoryDto.wchairHoldAt}" >
        <input type="hidden" name="petPosblAt" value="${categoryDto.petPosblAt}" >
        <input type="hidden" name="vgtrMenuHoldAt" value="${categoryDto.vgtrMenuHoldAt}" >
        <!-- 검색어 -->
        <input type="hidden" name="choDiv" value="${restSearchDto.choDiv}" >
        <input type="hidden" name="restSearch" value="${cri.restSearch}" >
	</form>
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
let moveForm = $("#moveForm");

$(".pageInfo a").on("click", function(e){
	 
    e.preventDefault();
    moveForm.find("input[name='pageNum']").val($(this).attr("href"));
    moveForm.attr("action", "/restaurant/restaurant/filterList?");
    moveForm.submit();
    
});

</script>
