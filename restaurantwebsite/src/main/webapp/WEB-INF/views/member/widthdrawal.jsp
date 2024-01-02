<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="../resources/css/widthdrawal.css">
<%@ include file="../includes/header.jsp" %>
<div id="wrap">
<form action="/restaurant/member/widthdrawal" method="post" id="widthdrawal">
	<h3>회원탈퇴</h3>
	<p>회원탈퇴하기에 앞서 안내사항을 반드시 확인해주세요.</p>
		<ul class="widthdrawal_box">
          <li class="checkBox check02">
            <textarea name="01" id="" disabled="disabled">
            계정 삭제작업은 영구적이며 되돌릴 수 없습니다. 삭제하는 즉시 귀하의 계정에 액세스할 수 없게 됩니다.
            등록된 게시글 및 댓글은 탈퇴 후 삭제가 불가능 하니 등록된 게시글 및 댓글에 대한 삭제를 원하는 경우 반드시 탈퇴 전에 삭제하시기 바랍니다.
       		</textarea>
          </li>
          <li class="checkBox check01">
			<ul class="clearfix">
	           <li>해당 내용을 모두 확인했으며, 회원탈퇴에 동의합니다.</li>
	           <li class="checkAllBtn">
	               <input type="checkbox" name="widthdrawalAgree" value="Y" id="chk">
	           </li>
           </ul>
        </li>
      </ul>
    <div class="create">
        <input class="but1" type="button" value="취소" onclick="cancle()">
        <input class="but2" type="submit" value="회원탈퇴" id="widthdrawalBtn">
	 </div>
</form>
</div>
<script>
//체크박스 유효성 검사
$("#widthdrawalBtn").click(function(){
	 if($("#chk").is(":checked") == false){
		 alert("회원탈퇴에 동의 하셔야 탈퇴가 진행됩니다.");
		 return false;
	 }else{
		 alert("정말로 회원탈퇴를 하시겠습니까?");
		 return true;
	 }
});

//취소하기
function cancle(){
	alert("정말로 회원탈퇴를 취소하시겠습니까?")
	window.location.href = '/restaurant/main/main';
}
</script>
<%@ include file="../includes/footer.jsp" %>