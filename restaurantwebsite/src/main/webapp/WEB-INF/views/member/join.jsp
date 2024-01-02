<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/join.css">
<%@ include file="../includes/header.jsp" %>
<div id="wrap">
 <form method="post" action="/restaurant/member/joinStep2" name="join_form" id="joinStep2">
      <div class="container">
      <p id="num10">*필수입력</p>
	    <div class="insert">
	        <table>
			    <tr>
			        <td class="col1">이메일<span id="num9">*</span></td>
			        <td class="col2">
			            <input type="text" name="FrontEmail" id="fEmail">
			            <span class="a" id="mEamil">@</span>
			            <input type="text" name="BackEmail"  id="bEmail" disabled="disabled">
			            <select name="mailslc" id="emailselect" onchange="directInput()">
			                <option value="" selected="selected">---선택---</option>
			                <option value="naver.com">naver.com</option>
			                <option value="gmail.com">gmail.com</option>
			                <option value="daum.com">daum.com</option>
			                <option value="self" >직접입력</option>
			            </select>
			            <input class='but2' id="emailSendBtn" type="button" value="이메일 인증번호 발송"  onclick="emailModal()">
			            <input type="hidden" name="email" id="email">
			            <p><span id="num1"></span></p>
			        </td>
			    </tr>
			    <tr>
			        <td class="col1">이메일 인증<span id="num9">*</span></td>
			        <td class="col2">
				        <div class="mail-check-box">
				        	<input type="text" name="inputAthntNmbr" id="emailChck" placeholder="인증번호 6자리" disabled="disabled" maxlength="6">
					        <input class='but5' id="emailChckBtn" type="button" disabled="disabled" value="인증" >
					        <input class='but6' id="emailResendBtn" type="button" value="인증키 재발급" disabled="disabled">
				        </div>
				        <!-- 3분 유효시간 추가기능 -->
				        <!-- <p id="num2">인증키 유효시간 3:00 남았습니다.</p> -->
				        <p id="num2">메일주소로 보낸 인증번호를 입력해주세요.</p>
			        </td>
			    </tr>
			    <tr>
			        <td class="col1">비밀번호<span id="num9">*</span></td>
			        <td class="col2">
			            <input type="password" name="pwd" maxlength="15" id="password">
			            <span id="num5">※비밀번호는 <span id="num3">특수문자(예: ~!@#$%^&*)1자 이상,영문자,숫자를 포함한 8~15자</span></span>
			            <p id="num7"></p>
			        </td>
			    </tr>
			    <tr>
			        <td class="col1">비밀번호 확인<span id="num9">*</span></td>
			        <td class="col2"><input type="password" name="inputPwdCheck" maxlength="15" id="passwordChck" disabled="disabled">
			        <p id="num4"></p>
			        </td>
			    </tr>
			    <tr>
			        <td class="col1">닉네임<span id="num9">*</span></td>
			        <td class="col2">
			            <input type="text" name="nickName" maxlength="10" id="nickName" >
			            <input class='but1' id="nickNameChk" type="button" value="중복확인">
			            <span id="num5">※닉네임은 <span id="num3">특수문자(예: ~!@#$%^&*)제외 2~10자</span></span>
			            <p id="num8"></p>
			        </td>
	    		</tr>
	    </table>
	  </div>
 
	  <div class="create">
	        <a href="/restaurant/member/joinCancel" >
	        	<input class="but3" type="button" value="가입취소" onclick="joinCancel()">
	        </a>
	        <input class="but4" type="button" value="회원가입" onclick="join()">
	  </div>
  </div>
 </form>
</div>
<script>
// 회원가입 실패시 alert창
if("${message}" != ""){
	alert("${message}");
}

let code = ""; //이메일전송 인증번호 저장위한 코드
 
//이메일 앞자리 유효성 검사
$("#fEmail").on("propertychange change keyup paste input", function() {
	let exptext = /^[A-Za-z0-9_\.\-]+$/;
	let frontEmail = document.getElementById("fEmail").value;
	
	if(frontEmail == ""){
		document.getElementById("num1").innerText = "이메일을 입력하지 않았습니다.";
		document.getElementById("fEmail").focus();
	} else if(exptext.test(frontEmail)==false){
		document.getElementById("num1").innerText = "이메일 형식에 맞게 입력해주세요.";
		document.getElementById("fEmail").focus();
	} else{
		document.getElementById("num1").innerText = "";
	}
 });
 
//이메일 뒷자리 유효성 검사
$("#bEmail").on("propertychange change keyup paste input", function() {
 	let exptext = /^[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
 	let backEmail = document.getElementById("bEmail").value;
 	
 	if(backEmail == ""){
 		document.getElementById("num1").innerText = "이메일 도메인을 선택하지 않았습니다.";
 		document.getElementById("bEmail").focus();
 	} else if(exptext.test(backEmail)==false){
 		document.getElementById("num1").innerText = "이메일 도메인 형식에 맞게 입력해주세요.";
 		document.getElementById("bEmail").focus();
 	} else{
 		document.getElementById("num1").innerText = "";
 	}
 });
 
//이메일 도메인 선택
 function directInput(){
 	let emailAdd = document.join_form.mailslc.options[join_form.mailslc.selectedIndex].value;
 	
 	if (emailAdd == "self") {
 		document.getElementById("bEmail").disabled = false;
 		document.getElementById("bEmail").value = "";
 	} else {
 		document.getElementById("bEmail").value = emailAdd;
 		document.getElementById("bEmail").disabled = true;
 	}
 }
 
//이메일 전송 모달창
 function emailModal(){
 	let exptext = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
 	let frontEmail = document.getElementById("fEmail").value;
 	let backEmail = document.getElementById("bEmail").value;
 	let email = $('#fEmail').val() +"@"+$('#bEmail').val();
 	$("#email").attr("value", email);

 //	console.log('완성된 이메일 : ' + email); // 이메일 오는지 확인
 	
 	if(exptext.test(email)!=false){
 		var cehckBox = $("#emailChck"); // 인증번호 입력칸 disable로 막아두기
 		var emailResendBtn = $("#emailResendBtn"); //인증키재발급 disable로 막아두기
 		var emailChckBtn = $("#emailChckBtn");// 인증키 disable로 막아두기
 		
		$.ajax({
		        type:"GET",
		        url:"emailChk?email=" + email,
		        success:function(data){ //data는 controller에서 생성한 난수
		        	//console.log(data)
		        	cehckBox.attr("disabled",false);
		        	emailResendBtn.attr("disabled",false);
		        	emailChckBtn.attr("disabled",false);
		        	code = data; //생성한 난수를 code 변수에 할당
		        	console.log(code)
			 		document.getElementById("num1").innerText = "";
			 		alert(frontEmail + "@" + backEmail + "으로 전송된 인증번호를 확인하여 가입절차를 완료해주세요.");
		        },	                
		        error:function(data){
		        	console.log(data)
		        	$("#num1").text(email + " 은 이미 존재한 이메일 입니다.");
		        }        
		    });
 	}else{
 		document.getElementById("num1").innerText = "이메일을 입력해 주세요";
 	}
}	

// 뷰에서 인증번호 일치여부 확인
$("#emailChckBtn").on("click", function(){
	let cehckBox = $("#emailChck"); // 인증번호 입력칸 disable로 막아두기
	let emailResendBtn = $("#emailResendBtn"); //인증키재발급 disable로 막아두기
	let emailChckBtn = $("#emailChckBtn");// 인증키 disable로 막아두기
	let inputCode = $("#emailChck").val();//회원이 입력한 인증코드    
	let num2 = document.getElementById("num2");
	 
	if(inputCode == code){
	 	document.getElementById("num2").innerText = "인증번호가 일치합니다.";
	 	num2.style.color = 'blue';
	    cehckBox.attr("disabled",true);
	    emailResendBtn.attr("disabled",true);
	    emailChckBtn.attr("disabled",true);
	} else {
		document.getElementById("num2").innerText = "인증번호를 다시 확인해주세요.";
	 	num2.style.color = 'red';
	}    
});

//인증키 재발급
$('#emailResendBtn').on("click",function() {
	let frontEmail = document.getElementById("fEmail").value;
 	let backEmail = document.getElementById("bEmail").value;
 	let email = $('#fEmail').val() +"@"+$('#bEmail').val();
 	$("#email").attr("value", email);
 	
 	$.ajax({
        type:"GET",
        url:"emailChk?email=" + email,
        success:function(data){ //data는 controller에서 생성한 난수
        	//console.log(data)
        	code = data; //생성한 난수를 code 변수에 할당
        	console.log(code)
	 		document.getElementById("num2").innerText = "메일주소로 보낸 인증번호를 입력해주세요.";
        	alert("인증키를 재발급하였습니다.")	
        },	                
        error:function(data){
        	//console.log(data)
        	$("#num1").text(email + " 은 이미 존재한 이메일 입니다.");
        }        
    });
});

//비밀번호 유효성 검사
$("#password").on("propertychange change keyup paste input", function() {
	let pw = document.getElementById("password").value;
	let num7 = document.getElementById("num7");
	let passwordChck = $("#passwordChck");
	let num = pw.search(/[0-9]/g);
	let eng1 = pw.search(/[a-z]/ig);
	let spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(pw == ""){
		document.getElementById("num7").innerText = "비밀번호를 입력하지 않았습니다.";
		num7.style.color = 'red';
		document.getElementById("password").focus();
		document.getElementById("passwordChck").value ="";
		document.getElementById("num4").innerText = "";
		passwordChck.attr("disabled",true);
	} else if (num < 0 || eng1 < 0 || spe < 0){
		document.getElementById("num7").innerText = "영문,숫자, 특수문자를 혼합하여 입력해주세요.";
		num7.style.color = 'red';
		document.getElementById("password").focus();
		document.getElementById("passwordChck").value ="";
		document.getElementById("num4").innerText = "";
		passwordChck.attr("disabled",true);
	} else if (pw.length<8 || pw.length > 16){
		document.getElementById("num7").innerText = "8~15자 이내로 입력해주세요.";
		num7.style.color = 'red';
		document.getElementById("password").focus();
		document.getElementById("passwordChck").value ="";
		document.getElementById("num4").innerText = "";
		passwordChck.attr("disabled",true);
	} else if (pw.search(/\s/) != -1){
		document.getElementById("num7").innerText = "공백없이 입력해주세요.";
		num7.style.color = 'red';
		document.getElementById("password").focus();
		document.getElementById("passwordChck").value ="";
		document.getElementById("num4").innerText = "";
		passwordChck.attr("disabled",true);
	} else{
		document.getElementById("num7").innerText = "사용가능한 비밀번호 입니다.";
		num7.style.color = 'blue';
		passwordChck.attr("disabled",false);
	}
	
});

	
//비밀번호확인 유효성 검사 
$("#passwordChck").on("propertychange change keyup paste input", function() {
	let pw = document.getElementById("password").value;
	let pwcheck = document.getElementById("passwordChck").value;
	let num4 = document.getElementById("num4");
	let passwordChck = $("#passwordChck");
		
	if(pw != pwcheck){
		document.getElementById("num4").innerText = "비밀번호가 일치하지 않습니다.";
		document.getElementById("passwordChck").focus();
		num4.style.color = 'red';
	}else{
		document.getElementById("num4").innerText = "비밀번호가 확인되었습니다.";
		num4.style.color = 'blue';
	}
});

//닉네임 유효성 검사
$("#nickName").on("propertychange change keyup paste input", function() {
	let nickName = $("#nickName").val();
	let num8 = document.getElementById("num8");
	let spe = nickName.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(nickName.search(/\s/) != -1){
		document.getElementById("num8").innerText = "공백없이 입력해주세요.";
		num8.style.color = 'red';
	}else if (nickName.length<2 || nickName.length > 11){
		document.getElementById("num8").innerText = "2~10자 이내로 입력해주세요.";
		num8.style.color = 'red';
	}else if (spe > 0){
		document.getElementById("num8").innerText = "특수문자없이 입력해주세요.";
		num8.style.color = 'red';
	}else{
		document.getElementById("num8").innerText = "";
	}
});

//닉네임 중복검사
$("#nickNameChk").on("click", function(){
	let nickName = $("#nickName").val();
	let data = {nickName : nickName};
	let num8 = document.getElementById("num8");
	
	$.ajax({
		type : "post",
		url : "/restaurant/member/nickNameChk",
		data : data,
		success:function(result){
			
			 if(result != "fail"){
				 document.getElementById("num8").innerText = "사용가능한 닉네임 입니다.";
				 num8.style.color = 'blue';
			 }else{
				 document.getElementById("num8").innerText = "닉네임이 이미 존재합니다.";
				 num8.style.color = 'red';
			 }
		}
	});
	
});

//가입하기 
function join (){
	if(document.getElementById("fEmail").value ==""){ 
		alert("이메일을 입력하세요.");         
		document.getElementById("fEmail").focus();   
		//return false;
	}else if(document.getElementById("bEmail").value ==""){
		alert("이메일 도메인을 입력하세요. ");         
		document.getElementById("bEmail").focus();   
		//return false;
	}else if(document.getElementById("num2").innerText != "인증번호가 일치합니다."){
		alert("이메일 인증을 진행해 주세요.");         
		document.getElementById("emailChck").focus();   
	}else if(document.getElementById("password").value ==""){
		alert("비밀번호를 입력하세요.");         
		document.getElementById("password").focus();   
	}else if(document.getElementById("passwordChck").value ==""){
		alert("비밀번호 확인을 진행해 주세요.");         
		document.getElementById("passwordChck").focus();   
	}else if(document.getElementById("nickName").value ==""){
		alert("닉네임을 입력하세요.");         
		document.getElementById("nickName").focus();   
	}else if(document.getElementById("num8").innerText != "사용가능한 닉네임 입니다."){
		alert("닉네임 중복확인을 진행해 주세요.");         
		document.getElementById("nickName").focus();   
	}else{
		//alert("회원가입을 축하드립니다. 로그인을 진행해주세요.")
		window.location.href = './login.html';
		document.getElementById("joinStep2").submit();
	}
}
	
//가입 취소하기
function joinCancel(){
	alert("정말로 회원가입을 취소하시겠습니까?")
}

</script>

<%@ include file="../includes/footer.jsp" %>