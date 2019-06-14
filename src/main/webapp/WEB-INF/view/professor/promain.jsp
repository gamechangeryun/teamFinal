<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);
body{
  margin-top: 100px;
  font-family: 'nanumgothic', serif;
  line-height: 1.6
}
.container{
  width: 800px;
  margin: 0 auto;
}
ul.tabs{
  margin: 0px;
  padding: 0px;
  list-style: none;
}
ul.tabs li{
  background: none;
  color: #222;
  display: inline-block;
  padding: 10px 15px;
  cursor: pointer;
}
 
ul.tabs li.current{
  background: #ededed;
  color: #222;
}
 
.tab-content{
  display: none;
  background: #ededed;
  padding: 15px;
}
 
.tab-content.current{
  display: inherit;
}

</style>
<title>교수메인</title>
<script>
$(document).ready(function(){
	   
	$('ul.tabs li').click(function(){
	  var tab_id = $(this).attr('data-tab');
	    $('ul.tabs li').removeClass('current');
	    $('.tab-content').removeClass('current');
	 
	    $(this).addClass('current');
	    $("#"+tab_id).addClass('current');
	})
})
</script>

</head>
<body>
	<!--탭 메뉴 목록  -->
	<div class="container">
		<ul class="tabs">
		  <li class="tab-link current" data-tab="tab-1">공지사항</li>
		  <li class="tab-link" data-tab="tab-2">학습목차</li>
		  <li class="tab-link" data-tab="tab-3">강의자료실</li>
		  <li class="tab-link" data-tab="tab-4">출석</li>
		  <li class="tab-link" data-tab="tab-5">과제</li>
		  <li class="tab-link" data-tab="tab-6">과목정보</li>
		</ul> 
		  
		<!--공지사항  -->
		<div id="tab-1" class="tab-content current">
		공지사항
		</div>
		
		<!--학습목차  -->
		<div id="tab-2" class="tab-content">
		학습목차
		</div>
		
		<!--강의자료실  -->
		<div id="tab-3" class="tab-content">
		강의자료실
		</div>
		
		<!--출석  -->
		<div id="tab-4" class="tab-content">
		출석
		</div>
		
		<!--과제  -->
		<div id="tab-5" class="tab-content">
		과제
		</div>
		
		<!--과목정보  -->
		<div id="tab-6" class="tab-content">
		과목정보
		</div>
	
		<!--메뉴 들어가기전에 메인에서 보여줄 공간  -->
		
		<div>
			<table class="table">
				<tr>
					<td rowspan="5" align="center">교수사진</td>
				</tr>
				<tr>
					<td>대표교수</td><td><!--  --></td>
				</tr>
				<tr>
					<td>학과명</td><td><!--  --></td>
				</tr>
				<tr>
					<td>이메일</td><td><!--  --></td>
				</tr>
				<tr>
					<td>강의실</td><td><!--  --></td>
				</tr>
			</table>
		</div>
	</div><!--class-container  -->
	
</body>
</html>