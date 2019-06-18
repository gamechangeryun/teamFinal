<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>출석부입력</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script>
//체크박스 전체버튼
$(function(){
    $("#check_all").click(function(){
		$('.input_check').prop('click', this.click);
    });
});

//학과리스트
<%-- $(function(){
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
}); --%>


//강의번호 선택하면 학생들 값 받아온다.
$(function(){
	
	$("#btnList").on("click", function(){
		var lecture_num = $("#lecture_num").val();
		
		/* if(lecture_num == ""){
			alert("학과를 먼저 선택해주세요")
			return false;
		} */
		
		var url = "<%=cp%>/atten/attenInsertFormAjax.do";
		var max = $("#max").val();
		var now = $("#now").val();
		
		$.ajax({
			type:"post"
			,url:url
			,data:{"lecture_num":lecture_num}
			,dataType:"json"
			,success:function(args){
				$("#showDtos tr").each(function(){
					$("#showDtos tr:eq(1)").remove();
				});
				for (var i = 0; i < args.data.length; i++) {
					$("#showDtos").append("<tr id='"+args.data[i].id+"'><td>"+args.data[i].lecture_num+"</td><td>"+args.data[i].temper_name+"</td><td>"+args.data[i].id+"</td><td>"+args.data[i].name+"</td><td class='"+args.data[i].id+"'><button type='button' class='input_check btn btn-success btn-sm' onclick='choiceFunc("+args.data[i].id+",\""+args.data[i].lecture_num+"\",\""+max+"\",\""+now+"\",\""+args.data[i].temper_name+"\",\""+args.data[i].name+"\",\""+i+"\")'>선택</button></td><input type='hidden' name='attenListDTO["+i+"].id' value='"+args.data[i].id+"'/><input type='hidden' name='attenListDTO["+i+"].lecture_num' value='"+args.data[i].lecture_num+"'/><input type='hidden' name='attenListDTO["+i+"].max_checkin' value='"+args.data[i].max_checkin+"'/><br><input type='hidden' name='attenListDTO["+i+"].now_checkin' value='"+args.data[i].now_checkin+"'/></tr>");
				}
			}
			,error:function(e){
				alert(e.responseTest+"에러");
			}
		});
		
		//출석부 입력 버튼 - 입력 처리후 경로 지정가능
		$("#btnApply").click(function(){
			$.ajax({
				type:"POST",
				url:"<%=cp%>/atten/attenInsertPro.do",
				data:$("#applyForm").serialize(),
				success:function(){
					location.replace("<%=cp%>/atten/attenMain.do"); 
				},
				error:function(jqXHR, textStatus, errorThrown){
					alert( errorThrown );
				}
			});
		});
	});
});
	
//선택버튼
function choiceFunc(){
	var id = arguments[0];
	var lecture_num = arguments[1];
	var max = arguments[2];
	var now = arguments[3];
	var temper_name = arguments[4];
	var name = arguments[5];
	var i = arguments[6];
	
	$("#"+id).remove();
	
	$("#applyList").append("<tr id='"+id+"'><td>"+lecture_num+"</td><td>"+temper_name+"</td><td>"+id+"</td><td>"+name+"</td><td class='"+id+"'><button type='button' class='input_check btn btn-Danger btn-sm' onclick='deleteFunc("+id+",\""+lecture_num+"\",\""+max+"\",\""+now+"\",\""+temper_name+"\",\""+name+"\",\""+i+"\")'>선택취소</button></td><input type='hidden' name='attenListDTO["+i+"].id' value='"+id+"'/><input type='hidden' name='attenListDTO["+i+"].lecture_num' value='"+lecture_num+"'/><input type='hidden' name='attenListDTO["+i+"].max_checkin' value='"+max+"'/><input type='hidden' name='attenListDTO["+i+"].now_checkin' value='"+now+"'/></tr>");
}

//취소버튼
function deleteFunc(){
	var id = arguments[0];
	var lecture_num = arguments[1];
	var max = arguments[2];
	var now = arguments[3];
	var temper_name = arguments[4];
	var name = arguments[5];
	var i = arguments[6];
	
	$("#"+id).remove();
	
	//$("#"+id).append("<td class='"+id+"'><button type='button' onclick='choiceFunc("+id+")'>선택</button></td>")
	$("#showDtos").append("<tr id='"+id+"'><td>"+lecture_num+"</td><td>"+temper_name+"</td><td>"+id+"</td><td>"+name+"</td><td class='"+id+"'><button type='button' class='input_check btn btn-success btn-sm' onclick='choiceFunc("+id+",\""+lecture_num+"\",\""+max+"\",\""+now+"\",\""+temper_name+"\",\""+name+"\",\""+i+"\")'>선택</button></td><input type='hidden' name='attenListDTO["+i+"].id' value='"+id+"'/><input type='hidden' name='attenListDTO["+i+"].lecture_num' value='"+lecture_num+"'/><input type='hidden' name='attenListDTO["+i+"].max_checkin' value='"+max+"'/><input type='hidden' name='attenListDTO["+i+"].now_checkin' value='"+now+"'/></tr>")
}

//출석부 입력 버튼
$("#btnApply").on("click",function(){
	
});

</script>
<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="../bootstrap.min.css" />

</head>
<body>
<form name="searchLecture" id="searchLecture" method="post">
<table class="table table-hover">
		<tr class="table-info">
			<td>
				강의명:
				<!--학과 선택  -->
				<!-- <select id="lecture" name="lecture_num">
		  			<option value="">::학과::</option>
				</select> -->
			</td>
			<td>최대출석 : 31</td>
			<td>현재출석 : 0</td>
			<td><input type="button" id="btnList" value="조회" class="btn btn-primary btn-sm"></td>
		</tr>
</table>
			<input type="hidden" id="max" name="max_checkin" value="31">
			<input type="hidden" id="now" name="now_checkin" value="1">
			<!--과목번호 설정해야함  -->
			<input type="hidden" id="lecture_num" name="lecture_num" value="1001">
			<input type="hidden" id="lecture_title" name="lecture_title" value="화학">
</form>

<table border="1" id="showDtos" class="table table-hover">
	<tr class="table-primary">
		<th>강의번호</th>
		<th>학과명</th>
		<th>학번</th>
		<th>학생이름</th>
		<th>
		<!--전체 선택 버튼  -->
		<input type="button" id="check_all" class="btn btn-primary btn-sm" value="전체선택">
		</th>
	</tr>
</table>
<hr>
<form name="applyForm" id="applyForm" method="post">
<table border="1" id="applyList" class="table table-hover">
	<tr class="table-primary">
		<th>목록</th>
		<th colspan="4">
			<button type="button" id="btnApply" class="btn btn-primary btn-sm">출석부입력</button>
		</th>
	</tr>
</table>
</form>

	
</body>
</html>