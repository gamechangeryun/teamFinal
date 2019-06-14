<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적정정</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
$(document).ready(function(){
	
	//성적정정승인입력칸
	$(".btn").on("click", function(){
		var id = $(this).attr('name');
		var lecture_num = $("#id_"+studentnum+"").val();
		console.log(studentnum);
		console.log(lecture_num);
		
		var html="";
		html += "<div>";
		html += "<input type='number' name='score_"+id+"'>";
		html += "<span><button onclick='acceptPro("+lecture_num+",\""+id+"\");'>정정입력</button></span>";
		html += "<div>";
		
		$("#acceptins_"+id+"").html(html);
	});
	 
});

//수정입력처리
function acceptPro(lecture_num, id){
	var changescore=$("[name=score_"+id+"]").val();
	
	$.ajax({
		url:"<%=cp%>/changescore/ChangescoreinputUpdate.do",
		type:"POST",
		data:{'lecture_num':lecture_num,'id':id,'score':changescore},
		success:function(){
			location.href="<%=cp%>/changescore/ChangescoreinputMain.do";
		}
	});
}	

</script>
</head>
<body>
<form id="Listform">
<table border="1">
	<c:if test="${mainList.size() == 0}">
		<tr>
			<td colspan="6">조회된 내용이 없습니다.</td>
		</tr>
	</c:if>
		
	<c:if test="${mainList.size() > 0 }">
		<tr>
			<td>강의번호</td>
			<td>학번</td>
			<td>학생이름</td>
			<td>정정신청사유</td>
		</tr>
		<tr>
			<c:forEach var="item" items="${mainList}">
			<tr>
				<td>${item.lecture_num }</td>
				<td>${item.id }</td>
				<td>${item.name }</td>
				<td>${item.changereason}
				<input type="button" value="기각" onClick="location.href='<%=cp%>/changescore/ChangescoreinputDelete.do?lecture_num=${item.lecture_num }&studentnum=${item.id }'">
				<input type="hidden" id="id_${item.id }" value="${item.lecture_num }">
				<input type="button" value="정정승인" class="btn" name="${item.id }">
				<span id="acceptins_${item.id }"></span>
				</td>
			</tr>
			</c:forEach>
		</tr>
	</c:if>
</table>
</form>

</body>
</html>