<%@ page contentType="text/html; charset=UTF-8"%>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="../bootstrap.min.css">
</head>

<body>
<div class="container">
<form name="insertForm" id="insertForm" action="<%=cp %>/learn/LearnInsert.do" method="post" onsubmit="return checkIt()">
	<fieldset>
	<legend>학습 목차 입력</legend>
		<div class="form-group row">
	      <label for="staticEmail" class="col-sm-2 col-form-label">강의 번호</label>
	      <div class="col-sm-10">
	        <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${lecture_num }">
	      </div>
	    </div>
		<input type="hidden" name="lecture_num" value="${lecture_num }">
		
		<div class="form-group row">
	      <label for="staticEmail" class="col-sm-2 col-form-label">학습 주차</label>
	      <div class="col-sm-10">
	        <input type="text" name="week" class="form-control-plaintext" id="staticEmail">
	      </div>
	    </div>
		
		<div class="form-group row">
	      <label for="staticEmail" class="col-sm-2 col-form-label">학습 제목</label>
	      <div class="col-sm-10">
	        <input type="text" name="subject_title" class="form-control-plaintext" id="staticEmail">
	      </div>
	    </div>
		
		
		<div class="form-group row">
	      <label for="staticEmail" class="col-sm-2 col-form-label">최대학습량</label>
	      <div class="col-sm-10">
	        <input type="number" name="max_study" class="form-control-plaintext" id="staticEmail">
	      </div>
	    </div>
		
		
		<div class="form-group row">
	      <label for="staticEmail" class="col-sm-2 col-form-label">현재학습량</label>
	      <div class="col-sm-10">
	        <input type="number" name="now_study" class="form-control-plaintext" id="staticEmail">
	      </div>
	    </div>
		
		<input type="submit" id="inputinsert" value="등록" class="btn btn-primary">
		
	</fieldset>
</form>
</div>


</body>
</html>