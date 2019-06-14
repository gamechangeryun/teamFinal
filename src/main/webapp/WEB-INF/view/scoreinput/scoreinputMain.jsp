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
<title>성적입력메인</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
$(function(){
	var url="<%=cp%>/scoreinput/scoreinputlectrueList.do";
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

//성적입력폼 안에 조회내용 생성
function inputList() {
	var snum=$("#lecture").val();	
	if(snum=="") {	                
		$("#student option").each(function() {	
			$("#student option:eq(1)").remove();
		});
		return;
	}
	
	var url="<%=cp%>/scoreinput/scoreinputList.do";
	var params="snum="+snum+"&dumi="+new Date();
	
	$.ajax({
		type:"post"
		,url:url	
		,data:params
		,dataType:"json"
		,success:function(args){
			
			var html = "";
			var cnt = args.data1.length;
			
			if(args.data1.length > 0){
				for(i=0; i<args.data1.length; i++){
					html += "<div>";
	                html += "<div><table class='table'>";
	                html += "<tr><td>";
	                html += "<strong>이름:"+args.data1[i].name+"</strong>"
	                html += "<strong> 학과명:"+args.data1[i].temper_name+"</strong>"
	                html += " <input type='number' name='scoreinputDtoList["+i+"].score' width='10px' min='0' maxlength='5' oninput='maxlength(this)' placeholder='성적입력란'>"
	                html += "</td></tr>";
	                html += "<input type='hidden' name='scoreinputDtoList["+i+"].id' value="+args.data1[i].id+">"
	                html += "<input type='hidden' name='scoreinputDtoList["+i+"].lecture_num' value="+args.data1[i].lecture_num+">"
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
	    ,error:function(e) {
	    	alert(e.responseText);
	    }
	});
}

//성적입력칸 늘리기
function maxlength(object){
	if(object.value.length > object.maxLength)
	object.value = object.value.slice(0, object.maxLength)
}

//성적입력
$(document).ready(function(){
	//콘솔에 폼데이터 확인용
/* 	$( "form" ).on( "submit", function( event ) {
		  event.preventDefault();
		  console.log( $( this ).serialize() );
		});
	 */
	//폼안의 값 컨트롤러로 전달
	$("form").on("submit", function(){
		$.ajax({
			type:"POST",
			url:"<c:url value='/scoreinput/scoreInput.do'/>",
			dataType:"json",
			data:$(this).serialize(),
			success:function(args){
				alert("성적입력완료");
			},
			error:function(e){
			}
		});
	});
	
});

</script>
</head>
<body>

<select id="lecture">
  <option value="">::강의선택::</option>
</select>

<!-- <select id="student">
  <option value="">::이름순::</option>
</select> -->
<button id="button" onclick="inputList();">조회</button>


<form id="myform" method="post">
<div>
조회인원::<span id="cnt">
</span>명
</div>
<div>
	<span id="snamelist"></span>
</div>

<input type="submit" name="sub" value="성적입력">
<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
</form>

</body>
</html>