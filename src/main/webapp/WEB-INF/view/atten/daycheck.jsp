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
<title>학생출석확인</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script>
$(function(){
	var id=$("#id").val();
	
	$.ajax({
		type:"post"
		,url:"<%=cp%>/atten/attendaycheck.do"
		,data:{"id":id}
		,dataType:"json"
		,success:function(args){
			
			var cnt = args.data[0].now_checkin;
			$("#cnt").html(cnt);
			
			$("#day option").each(function() {
				$("#day option:eq(0)").remove();
			});
			
			 $("#day").append("<option value=''>::날짜선택::</option>");
			 
			 for(var idx=1; idx<32; idx++) {
				 $("#day").append("<option value='day"+idx+"'>day"+idx+"</option>");	
			 } 
		}
	    ,error:function(jqXHR, textStatus, errorThrown) {
	    	alert(errorThrown);
	    }
	});
	
});

function checkList(){
	//var days=$("#day").val();
	days=$.trim($("#day").val());
	var test = "args.data[0]."+days 
	var id=$("#id").val();
	console.log(days);
	console.log(id);
	console.log(test);
	$.ajax({
		type:"post",
		url:"<%=cp%>/atten/attendaycheck.do",
		data:{"id":id},
		dataType:"json",
		success:function(args){
			var day=eval(test);
			day=$.trim(day);
			
			var check="";
			
			if(day === '1'){
				check="출석";
			}
			else if(day === "0"){
				check="결석";
			}
			else{
				check="미정"
			}
			
			
			$("#checkDay").html(check);
		}
	});
	
}

</script>
</head>
<body>
<div>출석상황
<span id="cnt"></span>/31</div>
<select id='day' name='day' onchange="checkList();">
	<option value="">::날짜::</option>
</select>
<span id="checkDay"></span>

<input type="hidden" id="id" value=${id }>

</body>
</html>