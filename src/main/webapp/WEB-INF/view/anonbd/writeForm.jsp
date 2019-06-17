<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
  String cp = request.getContextPath();
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<title>Bootstrap Sign up Form Horizontal</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	color: #999;
	background: #f3f3f3;
	font-family: 'Roboto', sans-serif;
}

.form-control {
	border-color: #eee;
	min-height: 41px;
	box-shadow: none !important;
}

.form-control:focus {
	border-color: #5cd3b4;
}

.form-control, .btn {
	border-radius: 3px;
}

.signup-form {
	width: 1000px;
	margin: 0 auto;
	padding: 30px 0;
}

.signup-form h2 {
	color: #333;
	margin: 0 0 30px 0;
	display: inline-block;
	padding: 0 30px 10px 0;
	border-bottom: 3px solid #5cd3b4;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #fff;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form label {
	font-weight: normal;
	font-size: 13px;
}

.signup-form input[type="checkbox"] {
	margin-top: 2px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	border: none;
	margin-top: 20px;
	min-width: 140px;
}

.signup-form .btn:hover, .signup-form .btn:focus {
	background: #41cba9;
	outline: none !important;
}

.signup-form a {
	color: #5cd3b4;
	text-decoration: underline;
}

.signup-form a:hover {
	text-decoration: none;
}

.signup-form form a {
	color: #5cd3b4;
	text-decoration: none;
}

.signup-form form a:hover {
	text-decoration: underline;
}
</style>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>



<script>
$(document).ready(function(){
  $("#confirmContent").click(function(){
    var title = $("#title").val();
    var content = $("#content").val();
    var id = $("#id").val();
    var writer = $("writer").val();
    
    alert(title);
    alert(content);
    alert(id);
    alert(writer);
    
    document.insertContent.action="<%=cp%>/anon/insertContent.do";
    document.insertContent.submit();
  });
});
function goList() {
  location.href="<%=cp%>/anon/list.do?page=1";
}
</script>

</head>
<body>
	<div class="signup-form">

		<form name="insertContent" id="contentForm" method="post"
			class="form-horizontal">
			<input type="hidden" name="id" value="${id}">
			<div class="col-xs-8 col-xs-offset-4">
				<h2>게시물 쓰기</h2>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">제목</label>
				<div class="col-xs-8">
					<input type="text" name="title" id="title"
						placeholder="제목을 입력해주세요." class="form-control" required="required">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">ID</label>
				<div class="col-xs-8">
					<input type="text" name="id" id="id" placeholder="id를 입력해주세요."
						class="form-control" required="required">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">글내용</label>
				<div class="col-xs-8">
					<textarea class="form-control" id="content" name="content" rows="5"
						cols="20" placeholder="내용을 입력해주세요" required="required"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2">Writer</label>
				<div class="col-xs-8">
					<input type="text" name="writer" id="writer" placeholder="writer을 입력해주세요." 
					class="form-control" required="required">
				</div>
			</div>
	
			<input type="hidden" id="isnotice" name="isnotice" value="0">
			<div style="margin-left: 200px">
				<button type="button" id="confirmContent" class="btn btn-primary">확인</button>
				<input type="reset" value="다시쓰기" class="btn btn-info"> <input
					type="button" value="목록으로 " onclick="goList();"
					class="btn btn-primary">
				</div>
		</form>
	</div>
</body>
</html>
