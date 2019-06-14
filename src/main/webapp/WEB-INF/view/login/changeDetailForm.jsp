<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>상세정보 변경 </title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	// 빈칸확인 폼
	function checkIt(){
		var input = eval("document.myform");
		
		if(!input.phone.value){
			alert("핸드폰번호를 입력하세요");
			return false;
		}
		
		if(!input.email.value){
			alert("이메일을 입력하세요");
			return false;
		}
		
		if(!input.postcode.value){
			alert("우편번호를 입력하세요");
			return false;
		}
		
		if(!input.address1.value){
			alert("주소를 입력하세요");
			return false;
		}
		
		if(!input.address2.value){
			alert("상세주소를 입력하세요");
			return false;
		}
		
		return true;
	}
	
	function sample6_execDaumPostcode() {
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
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</head>
<body>
	<form action="/FinalProject/changeDetail.do" method="post" name="myform" onsubmit="return checkIt()">
		<table border="1">
			<tr>
				<td>
					이름 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${detail.name }<br />
					전화번호 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="tel" name="phone" value="${detail.phone }" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="000-0000-0000"><br />
					이메일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="email" name="email" value="${detail.email }" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="abcd@abcd.com"><br />
					우편번호 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" id="sample6_postcode" name="postcode" value="${detail.postcode }">
					<input type="button" value="우편번호 찾기" onclick="sample6_execDaumPostcode()"><br />
					주소 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" id="sample6_address" name="address1" value="${detail.address1 }"><br />
					상세주소 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" id="sample6_detailAddress" name="address2" value="${detail.address2 }"> 
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="회원정보 변경">
					<input type="button" value="뒤로가기" onclick="location.href='/FinalProject/${mainPage}'">
				</td>
			</tr>   
		</table>
	</form>
</body>
</html>