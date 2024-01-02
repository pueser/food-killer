<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/login.css">
<%@ include file="../includes/header.jsp" %>

<div id ="wrap" class="login-wrapper">
	<h2>로그인</h2>
	<form action="loginPost" method="post" id="login-form" >
	    <input type="text" id="inputEmail" name="email" maxlength='30' placeholder="이메일">
	    <input type="password" id="inputPassword" name="pwd" maxlength='15'placeholder="비밀번호" ><br>
	    <span id="Chck" style="color:red">
	    	<c:out value="${list}"/>
	    </span><br>
	    <input type="button" value="Login" id="postForm" onclick="nullCheck()"> 
	    <div id="container">
          <a id="passFind" href="/restaurant/member/findPwd">비밀번호 찾기 |</a>
          <a href="/restaurant/member/agree">회원가입</a>
	    </div>
	  </form>
	  
	  <!-- 타계정 로그인 추가기능  -->
	  <!-- <div class="striped">
	  	<span class="striped-line"></span>
	  	<span class="striped-text">Or</span>
	  	<span class="striped-line"></span>
	</div>
    
	<nav class="snsLogin">
		<ul>
			<li>
				<button onclick="init();" id="google_login"> <img id="icon-img" src="https://t1.daumcdn.net/cfile/tistory/99D8AF415B743DB636" ></button>
			</li>
			<li>
				<a class="p-2" href="https://kauth.kakao.com/oauth/authorize?client_id=cb990a220e6e0a0850b07b8dbf6bf212&redirect_uri=http://localhost:9090/restaurant/member/main&response_type=code">
					<img id="icon-img" src="https://t1.daumcdn.net/cfile/tistory/992DA6415B743DB62B">
				</a>
			</li>
			<li>
				<a href="#">
					<img id="icon-img" src="https://t1.daumcdn.net/cfile/tistory/9922CF415B743DB62D">
				</a>
			</li>
		</ul>
	</nav> -->
</div>

<script>
/* 회원가입 성공시 alert창 */
if("${message}" != ""){
	alert("${message}");
}

/*login 이메일, 비번 유효성 체크*/		
function nullCheck(){
	 let email = document.getElementById("inputEmail").value;
	 let pw = document.getElementById("inputPassword").value;
	 let exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	 let num = pw.search(/[0-9]/g);
	 let eng = pw.search(/[a-z]/ig);
	 let spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(email == ""){
		document.getElementById("Chck").innerText = "이메일을 입력하지 않았습니다.";
		document.getElementById("inputEmail").focus();
		return false;
	} else if(exptext.test(email)==false){
		document.getElementById("Chck").innerText = "이메일 형식에 맞게 입력해주세요.";
		document.getElementById("inputEmail").focus();
		return false;
	}else{
		document.getElementById("Chck").innerText = "";
		if(pw == ""){
			document.getElementById("Chck").innerText = "비밀번호를 입력하지 않았습니다.";
			document.getElementById("inputPassword").focus();
			return false;
		}else if (num < 0 || eng < 0 || spe < 0 ){
			document.getElementById("Chck").innerText = "영문,숫자, 특수문자를 혼합하여 입력해주세요.";
			document.getElementById("inputPassword").focus();
			return false;
		} else if (pw.length<8 || pw.length > 16){
			document.getElementById("Chck").innerText = "8~15자 이내로 입력해주세요.";
			document.getElementById("inputPassword").focus();
			return false;
		} else if (pw.search(/\s/) != -1){
			document.getElementById("Chck").innerText = "공백없이 입력해주세요.";
			document.getElementById("inputPassword").focus();
			return false;
		}else{
 			document.getElementById("login-form").submit();
			return true;
		}
	}
}

</script>
<%@ include file="../includes/footer.jsp" %>
