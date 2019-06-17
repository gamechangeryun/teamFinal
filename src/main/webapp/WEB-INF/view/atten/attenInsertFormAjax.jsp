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


//강의번호 선택하면 학생들 값 받아온다.
$(function(){
	
	$("#btnList").on("click", function(){
		var lecture_num = $("#lecture").val();
		
		if(lecture_num == ""){
			alert("학과를 먼저 선택해주세요")
			return false;
		}
		
		var url = "<%=cp%>/atten/attenInsertFormAjax.do";
		var max = $("#max").val();
		var now = $("#now").val();
		
		$.ajax({
			type:"post"
			,url:url
			,data:{"lecture_num":lecture_num}
			,dataType:"json"
			,success:function(args){
				$(".showDtos tr").each(function(){
					$(".showDtos tr:eq(1)").remove();
				});
				for (var i = 0; i < args.data.length; i++) {
					$(".showDtos").append("<tr id='"+args.data[i].id+"'><td>"+args.data[i].lecture_num+"</td><td>"+args.data[i].temper_name+"</td><td>"+args.data[i].id+"</td><td>"+args.data[i].name+"</td><td class='"+args.data[i].id+"'><button type='button' class='input_check' onclick='choiceFunc("+args.data[i].id+",\""+args.data[i].lecture_num+"\",\""+max+"\",\""+now+"\",\""+args.data[i].temper_name+"\",\""+args.data[i].name+"\",\""+i+"\")'>선택</button></td><td><input type='hidden' name='attenListDTO["+i+"].id' value='"+args.data[i].id+"'/><br/><input type='hidden' name='attenListDTO["+i+"].lecture_num' value='"+args.data[i].lecture_num+"'/><br/><input type='hidden' name='attenListDTO["+i+"].max_checkin' value='"+args.data[i].max_checkin+"'/><br><input type='hidden' name='attenListDTO["+i+"].now_checkin' value='"+args.data[i].now_checkin+"'/></td></tr>");
				}
			}
			,error:function(e){
				alert(e.responseTest+"에러");
			}
		});
		
		//출석부 입력 버튼 - 입력 처리후 경로 지정가능
		$("#btnApply").click(function(){
			<%-- document.applyForm.action="<%=cp%>/atten/attenInsertPro.do";
			document.applyForm.submit(); --%>
			
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
	
	//$("#applyList").append("<tr class='"+id+"'><td>"+id+"</td><td class='"+id+"'><button type='button' onclick='deleteFunc("+id+")'>삭제</button></td><input type='hidden' name='"+id+"' value='"+id+"'</tr>");
	$("#applyList").append("<tr id='"+id+"'><td>"+lecture_num+"</td><td>"+temper_name+"</td><td>"+id+"</td><td>"+name+"</td><td class='"+id+"'><button type='button' class='input_check' onclick='deleteFunc("+id+",\""+lecture_num+"\",\""+max+"\",\""+now+"\",\""+temper_name+"\",\""+name+"\",\""+i+"\")'>선택취소</button></td><td><input type='hidden' name='attenListDTO["+i+"].id' value='"+id+"'/><input type='hidden' name='attenListDTO["+i+"].lecture_num' value='"+lecture_num+"'/><input type='hidden' name='attenListDTO["+i+"].max_checkin' value='"+max+"'/><input type='hidden' name='attenListDTO["+i+"].now_checkin' value='"+now+"'/></td></tr>");
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
	$(".showDtos").append("<tr id='"+id+"'><td>"+lecture_num+"</td><td>"+temper_name+"</td><td>"+id+"</td><td>"+name+"</td><td class='"+id+"'><button type='button' class='input_check' onclick='choiceFunc("+id+",\""+lecture_num+"\",\""+max+"\",\""+now+"\",\""+temper_name+"\",\""+name+"\",\""+i+"\")'>선택</button></td><td><input type='hidden' name='attenListDTO["+i+"].id' value='"+id+"'/><input type='hidden' name='attenListDTO["+i+"].lecture_num' value='"+lecture_num+"'/><input type='hidden' name='attenListDTO["+i+"].max_checkin' value='"+max+"'/><input type='hidden' name='attenListDTO["+i+"].now_checkin' value='"+now+"'/></td></tr>")
}

//출석부 입력 버튼
$("#btnApply").on("click",function(){
	
});

</script>
</head>
<body>
<form name="searchLecture" id="searchLecture" method="post">
<table>
<tr>
	<td>
		<select id="lecture" name="lecture_num">
  			<option value="">::학과::</option>
		</select>
	</td>
	<td>최대출석<input type="number" id="max" name="max_checkin" value="31" readonly></td>
	<td>현재출석입력<input type="number" id="now" name="now_checkin" placeholder="0 ~ 31" min="0" max="31"></td>
	<td><input type="button" id="btnList" value="입력"></td>
</tr>
</table>
</form>

<table border="1" class="showDtos">
	<tr>
		<th>강의번호</th>
		<th>학과명</th>
		<th>학번</th>
		<th>학생이름</th>
		<th>
		<!--전체 선택 버튼  -->
		<input type="button" id="check_all" value="전체선택">
		</th>
	</tr>
</table>
<hr>
<form name="applyForm" id="applyForm" method="post">
<table border="1" id="applyList">
	<tr>
		<th>목록</th>
		<th>
			<button type="button" id="btnApply">출석부입력</button>
		</th>
	</tr>
</table>
</form>

	
	<%@ include file="bootstrap.jsp" %>
</body>
</html>