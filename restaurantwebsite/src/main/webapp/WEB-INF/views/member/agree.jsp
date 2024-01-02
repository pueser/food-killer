<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/agree.css">
<%@ include file="../includes/header.jsp" %>
<div id="wrap">
<form action="/restaurant/member/joinStep1" method="post" id="joinForm">
	<h3>이용약관 동의</h3>
	<p>푸드킬러 사이트는 정보통신망법의 개인정보 취급방침을 준수하고 있습니다.<br>아래의 이용약관 및 개인정보방침, 위치기반서비스 이용약관을 반드시 읽어보신 후에 동의합니다. 체크해주시기 바랍니다.</p>
	<ul class="join_box">
          <li class="checkBox check02">
          	<ul class="clearfix">
            	<li>홈페이지 이용약관<span id="num1">(필수)</span></li>
                <li class="checkBtn">
                	<input type="checkbox" name="T1" value ="1" id="chk1" class="normal" > 
                </li>
            </ul>
            <textarea name="01" id="" disabled="disabled">
            여러분을 환영합니다.
			네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       		</textarea>
          </li>
          <li class="checkBox check03">
              <ul class="clearfix">
                  <li>개인정보 수집 및 이용<span id="num1">(필수)</span></li>
                  <li class="checkBtn">
                      <input type="checkbox" name="T2" value="1" id="chk1" class="normal">
                  </li>
              </ul>
 			  <textarea name="02" id="" disabled="disabled">여러분을 환영합니다.
				네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       		  </textarea>
           </li>
           <li class="checkBox check03">
               <ul class="clearfix">
                   <li>위치기반서비스 이용약관<span id="num1">(필수)</span></li>
                   <li class="checkBtn">
                       <input type="checkbox" name="T3" value="1" id="chk1" class="normal">
                   </li>
               </ul>
			   <textarea name="03" id="" disabled="disabled">여러분을 환영합니다.
					네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       		   </textarea>
            </li>
            <li class="checkBox check01">
 			<ul class="clearfix">
	            <li>이용약관(필수), 개인정보 수집 및 이용(필수),
	                위치정보 이용약관(필수)에 모두 동의합니다.</li>
	            <li class="checkAllBtn">
	                <input type="checkbox" name="checkbox" value="04" id="chk2" class="chkAll">
	            </li>
             </ul>
          </li>
      </ul>
    <div class="create">
	        <a href="/restaurant/member/joinCancel" ><input class="but3" type="button" value="가입취소" onclick="joinCancel()"></a>
	        <input class="but4" type="submit" value="다음단계" id="nextBtn">
	  </div>
</form>
</div>
<script>

//체크박스 전체 선택, 전체 해제
$(".join_box").on("click", "#chk2", function () {
  var checked = $(this).is(":checked");

  if(checked){
  	$(this).parents(".join_box").find('input').prop("checked", true);
  } else {
  	$(this).parents(".join_box").find('input').prop("checked", false);
  }
});

//개별 선택시 전체 해제
$(".join_box").on("click", "#chk1", function() {
  var checked = $(this).is(":checked");

  if (!checked) {
  	$("#chk2").prop("checked", false);
  }
});

//개별 선택시 전체 선택
$(".join_box").on("click", ".normal", function() {
    var is_checked = true;
    
    $(".join_box .normal").each(function(){
        is_checked = is_checked && $(this).is(":checked");
    });
    
    $("#chk2").prop("checked", is_checked);
});

//체크박스 선택여부
 $(document).ready(function(){
      $("#nextBtn").click(function(){    
          if($("#chk2").is(":checked") == false){
              alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
              return false;
          }else{
              window.location.href = '/restaurant/member/join';
              return true;
          }
      });    
});

//가입취소
function joinCancel(){
	alert("정말로 회원가입을 취소하시겠습니까?")
}
</script>
<%@ include file="../includes/footer.jsp" %>