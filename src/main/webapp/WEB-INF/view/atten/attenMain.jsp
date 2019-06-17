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
				 $("#lecture").append("<option value='"+args.data[idx].lecture_num+"'>"+args.data[idx].lecture_title+"</option>");
			 }
		}
	    ,error:function(e) {	
	    	alert(e.responseText);
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
			html += "<select id='day' name='day'>";
			html += "</select>";
			$("#days").html(html);
			
			$("#day option").each(function() {
				$("#day option:eq(0)").remove();
			});
			
			 $("#day").append("<option value=''>::날짜선택::</option>");
			 
			 for(var idx=1; idx<32; idx++) {
				 $("#day").append("<option value='day"+idx+"'>day"+idx+"</option>");	
			 } 
		}
	    ,error:function(e) {
	    	alert(e.responseText);
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
					
					html += "<div>";
		            html += "<div><table class='table'>";
		            html += "<tr><td>";
		            html += "<strong>학번:"+args.data[i].id+"</strong>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].id' value='"+args.data[i].id+"'>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].lecture_num' value='"+lecture_num+"'>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].day' value='"+days+"'>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].max_checkin' value='31'>"
		            html += "<input type='hidden' name='attenListDTO["+i+"].now_checkin' value='1'>"
		            html += "/<strong>이름:"+args.data[i].name+"</strong>"
		            html += ": 출석<input type='radio' name='attenListDTO["+i+"]."+days+"' value='1'>"
		            html += " 결석<input type='radio' name='attenListDTO["+i+"]."+days+"' value='0'>"
		            html += "</td></tr>";
		            html += "</table></div>";
		            html += "</div>";
				}
			}else{
				html += "<div>";
		        html += "<div><table class='table'><h6><strong>조회된 내용이 없습니다.</strong></h6>";
		        html += "</table></div>";
		        html += "</div>";
			}
			
			$("#cnt").html(cnt);
			$("#snamelist").html(html);
		}
		
	});
}

</script>
</head>
<body>
<!--출석부 입력폼 버튼 ->  테스트용으로 강의번호 임의 설정  -->
<button onclick="location.href='<%=cp%>/atten/attenInsertForm.do'">출석부입력</button>
<button onclick="location.href='<%=cp%>/atten/daypage.do'">학생출석확인</button>

<form id="myform" method="post">

<select id="lecture" name="lecture_num" onchange="inputList();">
  <option value="">::학과::</option>
</select>

<span id="days"></span>

<input type="button" onclick="searchlist();" value="조회">

<div>
조회인원::<span id="cnt">
</span>명
</div>
<div>
	<span id="snamelist"></span>
</div>

<input type="submit" name="sub" value="출석입력">
<input type="reset" value="취소">
</form>

</body>
</html>