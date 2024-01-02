<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/modifyMember.css">
<%@ include file="../includes/header.jsp" %>
<div id="wrap">
<form role="form" method="post" action="/restaurant/member/modifyMember" id="uploadForm" name="modify_form" >
      <div class="container">
	    <div class="insert">
	        <table>
			    <tr>
			        <td class="col1">프로필</td>
			        <td class="col2">
				        <div class="form-group uploadDiv">
					  		<div class="form_section">
                    			<div class="form_section_title">
                    				<div id="uploadResult"></div>
                    			</div>
                    			<div class="form_section_content">
									<input type="file" id ="fileItem" name='uploadFile' style="height: 30px;">
                    			</div>
                    		</div>  
        				</div>
				        <p id="num7">푸드킬러의 회원 프로필 사진으로 사용할 이미지를 등록해 주세요.<br>
				        <span id="num3">한장당 1MB jpg, png파일만 등록 가능합니다.</span></p>
			        </td>
			    </tr>
 			    <tr>
			        <td class="col1">비밀번호</td>
			        <td class="col2">
			            <div><input type="password" name="pwd" maxlength="15" id="password" placeholder="비밀번호"></div>
			            <p id="num5"></p>
			        	<div><input type="password" name="inputPwdCheck" maxlength="15" id="passwordChck" placeholder="비밀번호 확인"></div>
			        	<p id="num4"></p>
			            <p id="num7">※비밀번호는 <span id="num3">특수문자(예: ~!@#$%^&*)1자 이상,영문자,숫자를 포함한 8~15자</span></p>
			        </td>
			    </tr>
	    </table>
	  </div>

	  <div class="create">
	        <input class="but4" type="button" value="취소하기" onclick="cancle()">
	        <input id="submitBtn" class="but4" type="submit" value="수정하기">
	        <a href="/restaurant/member/widthdrawal"><input class="but4" type="button" value="회원탈퇴"></a> 
	  </div>
  </div>
 </form>
 </div>
 <script>

 $(document).ready(function(){
	 profileImage();
	 
	//수정하지 않았을 때 alert 띄우기
	if("${msg}" != ""){
		 alert("${msg}");
	} 
 });

 //회원DB profile사진 보여주기
 function profileImage(){
		let uploadResult = $("#uploadResult");
			
		let str = "";
		
		let fileCallPath = 's_' + '${memAttachDto.uuid}' + '_' + '${memAttachDto.fileName}';
		console.log(fileCallPath)
		str += "<div id='result_card'>";
		str += "<img src='/restaurant/display?fileName=" + fileCallPath +"'>";
		str += "</div>";
		
		uploadResult.append(str);
 }
 
//비밀번호 유효성 검사
 $("#password").on("propertychange change keyup paste input", function() {
 	let pw = document.getElementById("password").value;
 	let num7 = document.getElementById("num5");
 	let passwordChck = $("#passwordChck");
 	let num = pw.search(/[0-9]/g);
 	let eng1 = pw.search(/[a-z]/ig);
 	let spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
 	
 	if(pw == ""){
 		document.getElementById("num5").innerText = "비밀번호를 입력하지 않았습니다.";
 		num5.style.color = 'red';
 		document.getElementById("password").focus();
 		document.getElementById("passwordChck").value ="";
 		document.getElementById("num5").innerText = "";
 		passwordChck.attr("disabled",true);
 	} else if (num < 0 || eng1 < 0 || spe < 0){
 		document.getElementById("num5").innerText = "영문,숫자, 특수문자를 혼합하여 입력해주세요.";
 		num5.style.color = 'red';
 		document.getElementById("password").focus();
 		document.getElementById("passwordChck").value ="";
 		document.getElementById("num4").innerText = "";
 		passwordChck.attr("disabled",true);
 	} else if (pw.length<8 || pw.length > 16){
 		document.getElementById("num5").innerText = "8~15자 이내로 입력해주세요.";
 		num5.style.color = 'red';
 		document.getElementById("password").focus();
 		document.getElementById("passwordChck").value ="";
 		document.getElementById("num4").innerText = "";
 		passwordChck.attr("disabled",true);
 	} else if (pw.search(/\s/) != -1){
 		document.getElementById("num5").innerText = "공백없이 입력해주세요.";
 		num5.style.color = 'red';
 		document.getElementById("password").focus();
 		document.getElementById("passwordChck").value ="";
 		document.getElementById("num4").innerText = "";
 		passwordChck.attr("disabled",true);
 	} else{
 		document.getElementById("num5").innerText = "사용가능한 비밀번호 입니다.";
 		num5.style.color = 'blue';
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
 
//파일 controller 전달
 $("input[type='file']").on("change",function(){
	 
	 /* 이미지 존재시 삭제 */
	if($(".imgDeleteBtn").length > 0){
		/*해당 DB이미지 출력*/
		deleteFile();
	}
	 
	 
	let formData = new FormData();
	let fileInput = $('input[name="uploadFile"]');
	let fileList = fileInput[0].files;
	let fileObj = fileList[0];

// 	console.log("fileObj : " + fileObj);
// 	console.log("fileList : " + fileList);
// 	console.log("fileName : " + fileObj.name);
// 	console.log("fileSize : " + fileObj.size);
// 	console.log("fileType(MimeType) : " + fileObj.type);
	
	if(!fileCheck(fileObj.name, fileObj.size)){
		return false;
	}
	
	formData.append("uploadFile", fileObj);
	
	$.ajax({
		url: '/restaurant/profileUploadAjaxAction',
    	processData : false,
    	contentType : false,
    	data : formData,
    	type : 'POST',
    	dataType : 'json',
    	success : function(result){
    		console.log(result);
    		showUploadImage(result); 
    	},
    	error : function(result){
    		alert("이미지 파일이 아닙니다.");
    	}
	});	
 });
 	
//이미지 파일 업로드 파일 용량 및 파일형식
let regex = new RegExp("(.*?)\.(jpg|png)$"); //jpg와 png만 허용
let maxSize = 1048576; //1MB	

function fileCheck(fileName, fileSize){

	if(fileSize >= maxSize){
		alert("1MB 파일 사이즈 초과하였습니다.");
		return false;
	}
		  
	if(!regex.test(fileName)){
		alert("jpg, png 종류의 파일만 업로드할 수 있습니다.");
		return false;
	}
	return true;		
	
}

//profile 변경시, 기본DB profile 뷰에서 삭제
function profileImageDelete(){
	 let targetDiv = $("#result_card");
	 targetDiv.remove();
}

//이미지 출력(한개만)
function showUploadImage(uploadResultArr){
	profileImageDelete();
	/* 전달받은 데이터 검증 */
	if(!uploadResultArr || uploadResultArr.length == 0){ // 이미지가 없는 경우, return
		return;
	}
	
	let uploadResult = $("#uploadResult");
	let obj = uploadResultArr; //이미지의 데이터(filename,uuid) 첫번째 값
		
	let str = "";
	let fileCallPath = "s_" + obj.uuid + "_" + obj.fileName;
	//console.log(fileCallPath)

	str += "<div id='result_card'>";
	str += "<img src='/restaurant/display?fileName=" + fileCallPath +"'>";
	str += "<div class='imgDeleteBtn' data-file='" + fileCallPath + "'>x</div>";
	str += "<input type='hidden' name='fileName' value='"+ obj.fileName +"'>";
	str += "<input type='hidden' name='uuid' value='"+ obj.uuid +"'>";
	str += "</div>";
	
	uploadResult.append(str);
	
}
	
//이미지 삭제 파일 버튼 동작
$("#uploadResult").on("click",".imgDeleteBtn", function(e){
	deleteFile();
	profileImage(); //다시 기본DB profile 뷰에서 보이게 설정
});
	 
//파일 삭제 메서드 
function deleteFile(){
	
	let targetFile = $(".imgDeleteBtn").data("file");
	let targetDiv = $("#result_card");
	
	$.ajax({
		url: '/restaurant/deleteFile',
		data : {fileName : targetFile},
		dataType : 'text',
		type : 'POST',
		success : function(result){
			console.log(result);
			
			targetDiv.remove();
			$("input[type='file']").val(""); 
		},
		error : function(result){
			console.log(result);
			
			alert("파일을 삭제하지 못하였습니다.")
		}
      });
}

//취소하기
function cancle(){
	alert("정말 나의정보수정을 취소하시겠습니까?")
	window.location.href = '/restaurant/main/main';
}
 </script>
<%@ include file="../includes/footer.jsp" %>