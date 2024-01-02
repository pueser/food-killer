<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>fds</h1>

<%-- <c:forEach items="${list }" var="board"> --%>

${board.title }
	<%-- <c:forEach items="${read}" var="board">
								<tr>
									<td>${board }</td>
									<td>${board.title }</a></td>
									<td>${board.writer }</td>
									<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/> </td>
									<td><span class="badge bg-ref">${board.viewcnt }</span></td>
								</tr>
							</c:forEach>
							</tbody> --%>
<%-- </c:forEach>  --%>
</body>
</html>