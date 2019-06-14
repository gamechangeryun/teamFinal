<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!DOCTYPE html>
<html>

<%-- <c:set var="path" value="${request.getContextPath()}"/> --%>
<head>
<title>Insert title here</title>


 <script>

$(function(){
	$("#btnUpdate").click(function(){
		document.form1.action="/FinalProject/wol/update.do";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("delete?")){
			document.form1.action="/FinalProject/wol/delete.do";
			document.form1.submit();
		}
	});
}); 

  
</script>
</head>
<body>
<%-- <%@ include file="../include/menu.jsp" %> --%>
<form name="form1" method="post">
<input type="hidden" name="id" value="${dto.id}">
<table border="1" width="400px">
<tr>
<td>id</td>
<td>${dto.id}</td>
</tr>
<tr>
<td>name</td>
<td>${dto.name}</td>
</tr>
<tr>
<td>howmuch</td>
<td><input  name="howmuch" value="${dto.howmuch}" />
</td>
</tr>
<tr>
<td>bonus</td>
<td><input name="commition" value="${dto.commition}" /></td>
</tr>
</table>

<input type="button" value="update" id="btnUpdate">
<input type="button" value="delete" id="btnDelete"> 
</form>



</body>
</html>