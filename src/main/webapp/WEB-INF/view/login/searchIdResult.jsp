<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>아이디 찾기 결과</title>
</head>
<body>
	<c:if test="${id == 0 }">
		해당아이디가 존재하지 않습니다.
	</c:if>
	
	<c:if test="${id != 0 }">
		아이디 : ${id }
	</c:if>
</body>
</html>