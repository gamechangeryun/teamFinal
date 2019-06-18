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
				 $("#lecture").append("<option class='btn btn-info' value='"+args.data[idx].lecture_num+"'>"+args.data[idx].lecture_title+"</option>");
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
	                html += "<tr class='table-success'>";
	                html += "<td><strong>"+args.data1[i].name+"</strong></td>"
	                html += "<td><strong>"+args.data1[i].temper_name+"</strong><td>"
	                html += "<td><input type='number' name='scoreinputDtoList["+i+"].score' width='10px' min='0' maxlength='5' oninput='maxlength(this)' placeholder='성적입력란'></td>"
	                html += "</tr>";
	                html += "<input type='hidden' name='scoreinputDtoList["+i+"].id' value="+args.data1[i].id+">"
	                html += "<input type='hidden' name='scoreinputDtoList["+i+"].lecture_num' value="+args.data1[i].lecture_num+">"
				}
			}else{
				html += "<div><table class='table table-hover'><h6><strong>조회된 내용이 없습니다.</strong></h6>";
		        html += "</table></div>";
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
			},
			error:function(e){
			}
		});
	});
	
});

</script>
</head>
<body>


<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
  <div class="btn-group" role="group">
	<select id="lecture" class="btn btn-info dropdown-toggle">
	  <option class='btn btn-info' value="">::강의선택::</option>
	</select>
  </div>
</div>

<button id="button" class="btn btn-primary" onclick="inputList();">조회</button>

<form id="myform" method="post">

<!--조회된 인원 출력 위치  -->
<ol class="breadcrumb">
  <li class="breadcrumb-item active">
  	<div>
		조회인원::<span id="cnt">
		</span>명
	</div>
  </li>
</ol>

<!--성적 입력 인원 출력 위치  -->
<table id="snamelist" class="table table-hover">
    <tr class="table-primary">
      <th>이름</th>
      <th>학과</th>
      <th>성적입력</th>
    </tr>
	
</table> 

<input type="submit" name="sub" value="성적입력" class="btn btn-primary">
<input type="button" value="메인으로" class="btn btn-link" onclick="location.href='/FinalProject/${returnPage}'">
</form>

</body>
</html>