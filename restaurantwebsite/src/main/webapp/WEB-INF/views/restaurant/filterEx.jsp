<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<body>
<form name="foodfilter" action="list" method="get" >
			체크된거 :<span id="multiPrint1"></span><br>
			음식종류 :<span id="multiPrint2"></span><br>
	        <p id="foodTitle">음식 종류</p>
	       <!--  <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="allfood">전체 -->
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="southAmeri" >남미음식
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="aisa" >아시아음식
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="northAmeri" >북미음식
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="afri" >아프리카음식
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="oceania" >오세아니아음식
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="eur" >유럽음식
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="medEast" >중동음식
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="carriSea" >카브리해음식
	        <input id="food" class="check" type="checkbox" name="ctgryTwoNm" value="medTerr" >지중해음식
	        <p class="doubleselect">*중복선택가능</p>
	        
	        <p class="serviceTitle">서비스</p>
	        <!-- <input class="check" type="checkbox" name="allService" value="1" checked>전체 -->
	        <input class="check" type="checkbox" name="freParkngAt" value="1" >무료주차
	        <input class="check" type="checkbox" name="valetParkngPosblAt" value="1" >발렛주차
	        <input class="check" type="checkbox" name="infnChairLendPosblAt" value="1" >유아의자 대여
	        <input class="check" type="checkbox" name="wchairHoldAt" value="1" >휠체어 보유
	        <input class="check" type="checkbox" name="petPosblAt" value="1" >애완동물 동반입장
	        <input class="check" type="checkbox" name="vgtrMenuHoldAt" value="1" >채식메뉴 보유
	        <p class="doubleselect">*중복선택가능</p>
	        <input type="submit" value="필터 적용">
	     </form>
<script>
// 화면에 체크한거 표기
 $(document).ready(function(){
	$('input[type="checkbox"]').click(function(){
		let str = "";
		
		$('input[type="checkbox"]:checked').each(function(){
			str += $(this).val() + " "; 
		});
	$("#multiPrint1").text(str);
	});
	
}); 
 
//식당종류 배열에 담기
 $(document).ready(function(){
	$('input:checkbox[id="food"]').click(function(){
		let str = "";
		
		$('input:checkbox[id="food"]:checked').each(function(){
			str += $(this).val() + " "; 
		});
	$("#multiPrint2").text(str);
	});
	
}); 


</script>
</body>
</html>