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
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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
		</ul> 
		  
		<!--공지사항  -->
		<div id="tab-1" class="tab-content current">
			<a href="/FinalProject/PronoticeboardMain.do?lecture_num=${lecture_num }">공지사항</a>
		</div>
		
		<!--학습목차  -->
		<div id="tab-2" class="tab-content">
			<a href="/FinalProject/learn/LearnMain.do?lecture_num=${lecture_num }">학습목차</a>
		</div>
		
		<!--강의자료실  -->
		<div id="tab-3" class="tab-content">
		강의자료실
		</div>
		
		<!--출석  -->
		<div id="tab-4" class="tab-content">
			<c:if test="${position == 0 }">
				<a href="/FinalProject/atten/daypage.do?lecture_num=${lecture_num }">출석확인</a>
			</c:if>
			<c:if test="${position == 1 }">
				<a href="/FinalProject/atten/attenMain.do?lecture_num=${lecture_num }">출석입력</a>
			</c:if>
		</div>
		
		<!--과제  -->
		<div id="tab-5" class="tab-content">
			<a href="/FinalProject/hw_bd/board.do?lecture_num=${lecture_num }">과제제출</a>
		</div>
	
		<!--메뉴 들어가기전에 메인에서 보여줄 공간  -->
		
		<div>
			<table class="table">
				<tr>
					<td rowspan="5" align="center"><img alt="교수사진" src="/FinalProject/${picture }" width="120" height="120"></td>
				</tr>
				<tr>
					<td>교수명 &nbsp;</td><td>${proInfo.name }</td>
				</tr>
				<tr>
					<td>학과명 &nbsp;</td><td>${proInfo.temper_name }</td>
				</tr>
				<tr>
					<td>이메일 &nbsp;</td><td>${proInfo.email }</td>
				</tr>
				<tr>
					<td>강의실 &nbsp;</td><td>${proInfo.roomcode }</td>
				</tr>
			</table>
		</div>
	</div><!--class-container  -->
	
</body>
</html>