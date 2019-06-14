<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 찾기 결과</title>
</head>
<body>
	<c:if test="${password == 0 }">
		해당아이디가 존재하지 않습니다.
	</c:if>
	
	<c:if test="${password != 0 }">
		비밀번호 : ${password }
	</c:if>
</body>
</html>