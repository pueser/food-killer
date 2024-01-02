<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/filter.css">
<%@ include file="../includes/header.jsp" %>
<div class="wrap" >
	<div class="filter_box">
    	<div class="filter_header">
    		<h3>필터</h3>
    	</div>
	    <form name="foodfilter" action="/restaurant/restaurant/filterList" method="GET" id="filterForm">
		 	<p class="num1">
				<span class="foodTitle">음식 종류</span>
					<label><input id="foodAll" class="food" type="checkbox" name="foodAll" value="1" checked value="1" style="width: 20px; height: 20px; accent-color: #B942F5;" checked>상관없음</label>
			        <label><input id="food" class="food" type="checkbox" name="southAmeri" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">남미음식</label>
			        <label><input id="food" class="food" type="checkbox" name="aisa" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">아시아음식</label>
			        <label><input id="food" class="food" type="checkbox" name="northAmeri" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">북미음식</label>
			        <label><input id="food" class="food" type="checkbox" name="afri" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">아프리카음식</label>
			        <label><input id="food" class="food" type="checkbox" name="oceania" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">오세아니아음식</label>
			        <label><input id="food" class="food" type="checkbox" name="eur" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">유럽음식</label>
			        <label><input id="food" class="food" type="checkbox" name="medEast" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">중동음식</label>
			        <label><input id="food" class="food" type="checkbox" name="carriSea" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">카브리해음식</label>
			        <label><input id="food" class="food" type="checkbox" name="medTerr" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">지중해음식</label>
			</p><br>
			<p class="doubleselect1">*중복선택가능</p>
				
			<p id="num1">
				<span class="serviceTitle">서비스</span>
					<label><input id="serviceAll" class="service" type="checkbox" name="serviceAll" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;" checked >상관없음</label>
					<label><input id="service" class="service" type="checkbox" name="freParkngAt" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">무료주차</label>
			        <label><input id="service" class="service" type="checkbox" name="valetParkngPosblAt" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">발렛주차</label>
			        <label><input id="service" class="service" type="checkbox" name="infnChairLendPosblAt" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">유아의자 대여</label>
			        <label><input id="service" class="service" type="checkbox" name="wchairHoldAt" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">휠체어 보유</label>
			        <label><input id="service" class="service" type="checkbox" name="petPosblAt" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">애완동물 동반입장</label>
			        <label><input id="service" class="service" type="checkbox" name="vgtrMenuHoldAt" value="1" style="width: 20px; height: 20px; accent-color: #B942F5;">채식메뉴 보유</label>
			</p><br>
			<p class="doubleselect2">*중복선택가능</p>
		    <input type="submit" value="필터 적용" id="filterForm" onclick="check_on();">
		</form>
	</div>
</div>
<script>
$(document).ready(function(){
	//"상관없음"체크시 나머지 체크박스해제
	$("#foodAll").click(function(){
		if($("#foodAll").prop("checked")){
 		    $("#foodAll").prop("checked",true);
		    $("input:checkbox[id='food']").prop("checked",false);
		}

	});
	
	$("#serviceAll").click(function(){
		if($("#serviceAll").prop("checked")){
 		    $("#serviceAll").prop("checked",true);
		    $("input:checkbox[id='service']").prop("checked",false);
		}
	});
	
	//체크박스 선택 안되었을때, 선택이 전부 되었을때 "상관없음"체크
	$(".food").click(function() {
	    if($('input:checkbox[id="food"]:checked').length == 0){
	    	$("#foodAll").prop("checked", true);
	    }else{
	    	$("#foodAll").prop("checked", false);
	    }
    });
	
	$(".service").click(function() {
	    if($('input:checkbox[id="service"]:checked').length == 0 ){
	    	$("#serviceAll").prop("checked", true);
	    }else{
	    	$("#serviceAll").prop("checked", false);
	    }
    });
});
</script>
<%@ include file="../includes/footer.jsp" %>