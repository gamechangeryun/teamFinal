<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<form name="insertForm" id="insertForm" action="/FinalProject/learn/LearnInsert.do" method="post" onsubmit="return checkIt()">
<div>
<span>강의번호 :<input type="number" name="lecture_num"/></span>
<span>주 차 :<input type="text" name="week"></span>
<span>학습제목 :<input type="text" name="subject_title"></span>
<span>최대학습량<input type="number" name="max_study"></span>
<span>현재학습량<input type="number" name="now_study"></span>
<input type="submit" id="inputinsert" value="등록">
</div>

</form>

</body>
</html>