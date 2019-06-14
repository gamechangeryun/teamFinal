<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<html>
<head>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Insert title here</title>
<%-- <%@ include file ="../include/header.jsp"%> --%>
<!-- include libraries(jQuery, bootstrap) -->
<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

include summernote css/js
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script> -->
</head> 
<body>


<c:forEach var="row" items="${list1}">
 <br>
 <a href="/FinalProject/wol/view.do?id=${row.id}">${row.id}</a><br> 
 ${row.name}<br>
${row.howmuch}<br>
${row.commition}<br>
</c:forEach>
</body>
</html>