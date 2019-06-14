<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person writeForm</title>
<!-- jquery js파일 추가 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
$(document).ready(function(){
	$("#btnConfirm").click(function(){
		var name = $("#name").val();
		var phone = $("#phone").val();
		var email = $("#email").val();
		var temper_num = $("#temper_num").val();
		var postcode = $("#postcode").val();
		var address1 = $("#address1").val();
		var address2 = $("#address2").val();
		var gender = $("#gender").val();
		var birthday = $("#birthday").val();
		
		if(name == "") {
			alert("이름을 입력하세요.");
			document.insertPerson.name.focus();
			return;
		}
		if(phone == "") {
			alert("연락처를 입력하세요.");
			document.insertPerson.phone.focus();
			return;
		}
		if(email == "") {
			alert("email을 입력하세요.");
			document.insertPerson.email.focus();
			return;
		}
		if(temper_num == "") {
			alert("소속번호를 입력하세요.");
			document.insertPerson.temper_num.focus();
			return;
		}
		if(postcode == "") {
			alert("우편번호를 입력하세요.");
			document.insertPerson.postcode.focus();
			return;
		}
		if(address1 == "") {
			alert("주소1을 입력하세요.");
			document.insertPerson.address1.focus();
			return;
		}
		if(address2 == "") {
			alert("주소2를 입력하세요.");
			document.insertPerson.address2.focus();
			return;
		}
		if(birthday == "") {
			alert("생년월일을 입력하세요.");
			document.insertPerson.birthday.focus();
			return;
		}
		if(gender == "") {
			alert("성별을 입력하세요.");
			document.insertPerson.gender.focus();
			return;
		}
		if(gender!="m" && gender!="f"){
			alert("성별은 m(남자) 또는 f(여자) 로만 입력해주세요")
			document.insertPerson.gender.focus();
			return;
		}
		document.insertPerson.action="<%=cp%>/person/insertPerson.do";
		document.insertPerson.submit();
	})
})

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }
         
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("address2").focus();
        }
    }).open();
}
function goList() {
	location.href="<%=cp%>/person/main.do?page=1";
}
function getTemperList() {
	var options1 = $("#options1").val();
	if(options1 == "") {
		$("#options2 option").each(function(){
			$("options2 option:eq(1)").remove();
		});
		$("#options2").append("<option value=''>::소속::</option>");
		return;
	}
	
	var url ="<%=cp%>/person/getTemper.do";
	var params = "options1="+options1;
	
	$.ajax({
		type:"post"
		,url:url
		,data:params
		,dataType:"json"
		,success:function(args){
			$("#options2 option").each(function(){
				$("#options2 option:eq(0)").remove();
			});
			$("#options2").append("<option value=''>::소속::</option>");
			for (var i = 0; i< args.data1.length; i++) {
				$("#options2").append("<option value='" + args.data1[i].temper_name+"'>"+args.data1[i].temper_name+"</option>");
			}
		}
		,error:function(e){
			alert(e.responseTest);
		}
	});
}
</script>
</head>
<body>
<h2>Person 추가</h2>
<hr>
<form name="insertPerson" id="insertPerson" enctype="multipart/form-data" method="post" >
	<table border="1">
		<tr>
			<td>분류</td>
			<td>
				<select id="options1" name="options1" onchange="getTemperList()">
					<option value="" selected="selected">::분류::</option>
					<option value="0">학생</option>
					<option value="1">교수</option>
					<option value="2">교직원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" id="name" placeholder="이름을 입력해주세요.">
			</td>
		</tr>
		
		<tr>
			<td>이미지 첨부</td>
			<td>
				<input type="file" name="file" id="file">
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type="text" name="gender" id="gender" placeholder="남자  : 'm', 여자 : 'f'">
			</td>
		</tr>
		
		<tr>
			<td>생년월일</td>
			<td>
				<input type="text" name="birthday" id="birthday" pattern="[0-9]{6}" placeholder="생일 6자리를 적어주세요." title="YYMMDD">
			</td>
		</tr>
		<tr>
			<td>소속</td>
			<td>
				<select id="options2" name="options2">
					<option value="">::소속::</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<input type="tel" name="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="000-0000-0000" value="">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="abcd@abcd.com" value="">
					
			</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td>
				<input type="text" id="postcode" name="postcode">
				<input type="button" value="우편번호찾기" onclick="execDaumPostcode()"><br/>
				
			</td>
		</tr>
		<tr>
			<td>주소1</td>
			<td>
				<input type="text" id="address1" name="address1">	
			</td>
		</tr>
		<tr>
			<td>주소2</td>
			<td>
				<input type="text" id="address2" name="address2"> 
			</td>
		</tr>
	</table>
	<button type="button" id="btnConfirm">추가</button>
	<input type="reset" value="다시쓰기">
	<input type="button" value="목록으로" onclick="goList();">
</form>
</body>
</html>