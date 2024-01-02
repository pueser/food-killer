<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<link rel="stylesheet" href="../resources/css/header.css">



</head>
<body>
<header>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/restaurant/main/main">푸드킬러</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <!-- 검색창 -->
	    <form class="d-flex" role="search">
	        <input class="form-control me-2" type="search" placeholder="지역음식 또는 식당명 입력하세요" name ="restSearch" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">
	        	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
	  				<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
				</svg>
			</button>
	      </form>
	      <!-- 로그인, 회원가입, 필터 탭 -->
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
		        <c:if test="${empty login}">
					<a class="nav-link" href="/restaurant/member/login">로그인</a>
				</c:if>
				<c:if test="${not empty login}">
					<select class="form-select" aria-label="Default select example" onchange="if(this.value) window.open(this.value);">
					  <option selected>${login.nickName}님</option>
					  <option value="/restaurant/member/modifyMember">나의정보 수정</option>
					  <option value="2">내가 좋아요한</option>
					  <option value="3">내 포스트</option>
					</select>
				</c:if>
	        </li>
	        <li class="nav-item">
	        	<c:if test="${empty login}">
					<a class="nav-link" href="/restaurant/member/agree">회원가입</a>
				</c:if>
				<c:if test="${not empty login}">
					<a class="nav-link" href="/restaurant/member/logout">로그아웃</a>
				</c:if>
	        </li>
	        <li class="nav-item">
	 			<button onclick="openModal();"class="nav-link" type="button">
	 		         <svg xmlns="http://www.w3.org/2000/svg" width="16" height="20" fill="currentColor" class="bi bi-funnel" viewBox="0 0 16 16"> -->
	 		 		<path d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5v-2zm1 .5v1.308l4.372 4.858A.5.5 0 0 1 7 8.5v5.306l2-.666V8.5a.5.5 0 0 1 .128-.334L13.5 3.308V2h-11z"/> -->
					</svg>
	 				<a href="/restaurant/restaurant/filter">필터</a>
	 	 		</button>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
</header>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>       
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        