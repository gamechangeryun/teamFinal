<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>출석확인</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script>
//학과리스트
$(function(){
	var url="<%=cp%>/atten/attenList.do";
	var params="dumi="+new Date();
	
	$.ajax({
		type:"post"		
		,url:url		
		,data:params	
		,dataType:"json"	
		,success:function(args){	
			 for(var idx=0; idx<args.data.length; idx++) {	
				 $("#lecture").append("<option class='btn btn-info' value='"+args.data[idx].lecture_num+"'>"+args.data[idx].lecture_title+"</option>");
			 }
		}
	    ,error:function(e) {	
	    	//alert(e.responseText);
	    }
	});
});

//day 조회
function inputList() {
	var snum=$("#lecture").val();	
	if(snum=="") {	                
		$("#student option").each(function() {	
			$("#student option:eq(1)").remove();
		});
		return;
	}
	
	var url="<%=cp%>/atten/attenList.do";
	var params="snum="+snum+"&dumi="+new Date();
	
	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"
		,success:function(args){
			var html = "";
			html += "<select id='day' name='day' class='btn btn-info dropdown-toggle'>";
			html += "</select>";
			$("#days").html(html);
			
			$("#day option").each(function() {
				$("#day option:eq(0)").remove();
			});
			
			 $("#day").append("<option class='btn btn-info' value=''>::날짜선택::</option>");
			 
			 for(var idx=1; idx<32; idx++) {
				 $("#day").append("<option class='btn btn-info' value='day"+idx+"'>day"+idx+"</option>");	
			 } 
		}
	    ,error:function(e) {
	    	//alert(e.responseText);
	    }
	});
}

//출석체크입력
$(document).ready(function(){
	//콘솔에 폼데이터 확인용
 	/* $( "form" ).on( "submit", function( event ) {
		  event.preventDefault();
		  console.log( $( "#myform" ).serialize() );
	}); */
	 
	//폼안의 값 컨트롤러로 전달
	$("form").on("submit", function(){
		var url="<%=cp%>/atten/attenCheck.do";
		var params=$( "#myform" ).serialize();
		
		$.ajax({
			type:"POST",
			url:url,
			dataType:"json",
			data:params,
			success:function(args){
			},
			error:function(jqXHR, textStatus, errorThrown){
				//alert( errorThrown );
			}
		});
	});
});

//조회버튼 누르고 id리스트 출력
function searchlist(){
	var lecture_num=$("#lecture").val();
	var days=$("#day option:selected").val();
	
	$.ajax({
		type:"POST",
		url:"<%=cp%>/atten/attenIDList.do",
		data:{"lecture_num":lecture_num,"day":days},
		dataType:"json",
		success:function(args){
			var html = "";
			var cnt = args.data.length;
			
			if(args.data.length > 0){
				for(i=0; i<args.data.length; i++){
					html += "<tr class='table-success'>"
		            html += "<td>"+args.data[i].id+"</td>"
		            html += "<td>"+args.data[i].name+"</td>"
					html += "<td><div class='btn-group btn-group-toggle' data-toggle='buttons'>";		           
					html += "<label class='btn btn-warning'>";		           
		            html += "출석<input type='radio' name='attenListDTO["+i+"]."+days+"' value='1'>"
		            html += "</label>";
					html += "<label class='btn btn-warning'>";		           
		            html += "결석<input type='radio' name='attenListDTO["+i+"]."+days+"' value='0'>"
		            html += "</label>";
		            html += "</div>";
		            html += "<input type='hidden' name='attenListDTO["+i+"].id' value='"+args.data[i].id+"'>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].lecture_num' value='"+lecture_num+"'>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].day' value='"+days+"'>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].max_checkin' value='31'>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].now_checkin' value='1'>"
		            html += "</td></tr>";
				}
			}else{
		        html += "<div><table class='table table-hover'><h6><strong>조회된 내용이 없습니다.</strong></h6>";
		        html += "</table></div>";
			}
			
			$("#cnt").html(cnt);
			$("#snamelist").append(html);
		}
		
	});
}
</script>

<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="../bootstrap.min.css">
</head>
<body>
<!--출석부 입력폼 버튼 ->  테스트용으로 강의번호 임의 설정  -->
<button class="btn btn-primary btn-sm" onclick="location.href='<%=cp%>/atten/attenInsertForm.do'">출석부입력</button>
<button class="btn btn-primary btn-sm" onclick="location.href='<%=cp%>/atten/daypage.do'">학생출석확인</button>

<div class="collapse navbar-collapse" id="navbarColor01">
	<form id="myform" method="post" class="form-inline my-2 my-lg-0">
		
		<!--학과 선택  -->
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
		  <div class="btn-group" role="group">
			<select id="lecture" name="lecture_num" onchange="inputList();" class="btn btn-info dropdown-toggle">
			  <option value="" class="btn btn-info">::학과::</option>
			</select>
		  </div>
		</div>
		
		<!--day 선택  -->
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
		  <div class="btn-group" role="group">
			<span id="days"></span>
		  </div>
		</div>
		
		<!--조회버튼  -->
		<input type="button" onclick="searchlist();" value="조회" class="btn btn-info">
		
		<!--조회된 인원 출력 위치  -->
		<ol class="breadcrumb">
		  <li class="breadcrumb-item active">
		  	<div>
				조회인원::<span id="cnt">
				</span>명
			</div>
		  </li>
		</ol>
		<!--출석부 인원 출력 위치  -->
		<table id="snamelist" class="table table-hover">
		    <tr class="table-primary">
		      <th>학번</th>
		      <th>이름</th>
		      <th>출석체크</th>
		    </tr>
			
			
		</table> 
		
			
		<!--과목번호 설정할 곳  -->			
		<!-- <input type="hidden" id="lecture" name="lecture_num" value="1001"> -->
		<input type="submit" name="sub" value="출석입력" class="btn btn-danger btn-sm">
		<input type="reset" value="취소" class="btn btn-primary btn-sm">
	</form>
</div>


</body>
</html>