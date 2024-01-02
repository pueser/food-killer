<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/findPwd.css">
<%@ include file="../includes/header.jsp" %>
<div id="wrap">
	<div class="findPwd-wrapper">
	        <h2>비밀번호 찾기</h2>
	        <p>가입한 이메일 주소로 임시 비밀번호를 알려드립니다.<br>
	        로그인 후 비밀번호를 꼭 변경해주세요.</p>
	        <form method="post" action="/restaurant/member/findPwdEmail" id="findPwd-form" >
	            <input type="text" id="inputEmail" name="email" maxlength='30' placeholder="이메일" onfocusout = ""><br>
	            <span id="Chck" style="color:red"></span><br>
	            <input type="button" value="임시 비밀번호 전송" id="findPwdBtn" onclick="">
	        </form>
	</div>
</div>
<script>
/*이메일 확인*/
$("#findPwdBtn").on("click", function(){
	var email = $("#inputEmail").val();
	var data = {email : email};
	var checkResult = $("#Chck");
	var findPwdBtn = $("#findPwdBtn");
	//document.getElementById("join_form").submit();
	
	$.ajax({
		type : "post",
		url : "/restaurant/member/findPwdEmail",
		data : data,
		success : function(result) { 
	        if(result == "fail"){
	        	checkResult.html("이메일이 존재하지 않습니다. 다시 확인 부탁드립니다.");
	        	return false;
	        }else{
	        	alert(email + "로 임시비밀번호를 전송하였습니다." +"\n"+"확인 후 로그인 진행해 주시길 바랍니다.");
	        	findPwdBtn.submit();
	        	window.location.href = "/restaurant/member/login";
	        	return true;
	        }
	    }
	});
	
});
</script>
<%@ include file="../includes/footer.jsp" %>