<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>등록금 납부 현황</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script>
//학과리스트
$(function(){
	var url="<%=cp%>/tuition/temperList.do";
	var params="dumi="+new Date();
	$.ajax({
		type:"GET"		// 포스트방식
		,url:url		// url 주소
		,data:params	//  요청에 전달되는 프로퍼티를 가진 객체
		,dataType:"json"	//특정한 형식으로 이루어진 텍스트를 말한다.
		,success:function(arg){	//응답이 성공 상태 코드를 반환하면 호출되는 함수
			for(var idx=0; idx<arg.data.length; idx++) {	//컨트롤러에서 json으로 생성해서 보낸 "data"
				 $("#temper1").append("<option value='"+arg.data[idx].temper_name+"'>"+arg.data[idx].temper_name+"</option>");
			}
			for(var idx=0; idx<arg.data.length; idx++) {	//컨트롤러에서 json으로 생성해서 보낸 "data"
				 $("#temper2").append("<option value='"+arg.data[idx].temper_name+"'>"+arg.data[idx].temper_name+"</option>");
			}
		}	
	    ,error:function(e) {	// 이곳의 ajax에서 에러가 나면 알러트창으로 에러 메시지 출력
	    	alert(e.responseText);
	    }
	});
});

//납부자조회버튼
function checkInput(){
	var check=$("#temper1 :selected").text();
	var url="<%=cp%>/tuition/temperCheck.do";
	var inputmoney=1;
	$.ajax({
		type:"post"
		,url:url	
		,data:{'temper_name' : check, 'inputmoney' : inputmoney}
		,dataType:"json"
		,success:function(args){
			var html = "";
			var cnt = args.data.length;	//조회인원수
			
			if(args.data.length > 0){
				for(var i=0; i<args.data.length; i++) {	//컨트롤러에서 json으로 생성해서 보낸 "data"
					html += "<div>";
	                html += "<div><table class='table table-striped'>";
	                html += "<tr>";
	                html += "<th>번호(id)</th>";
	                html += "<th>납부금액</th>";
	                html += "<th>납부여부</th>";
	                html += "<th>납부일</th>";
	                html += "</tr>";
	                html += "<tr>";
	                html += "<td>"+args.data[i].id+"</td>";
	                html += "<td>"+args.data[i].howmuch+"</td>";
	                html += "<td>납부 완료</td>";
	                html += "<td>"+args.date[i]+"</td>";
	                html += "</tr>";
				}
			}
			else{
				html += "<div>";
	            html += "<div><table class='table'><h6><strong>조회된 인원이 없습니다.</strong></h6>";
	            html += "</table></div>";
	            html += "</div>";
			}
			$("#now1").html(html);
			$("#cnt1").html(cnt);
		}
	    ,error:function(e) {
	    	alert(e.responseText);
	    }
	});
}

//미납자 조회버튼
function check(){
	var check=$("#temper2 :selected").text();
	var url="<%=cp%>/tuition/temperCheck.do";
	var inputmoney=0;
	
	$.ajax({
		type:"post"
		,url:url	
		,data:{'temper_name' : check , 'inputmoney' : inputmoney}
		,dataType:"json"
		,success:function(args){
			var html = "";
			var cnt = args.data.length;	//조회인원수
			
			if(args.data.length > 0){
				for(var i=0; i<args.data.length; i++) {	//컨트롤러에서 json으로 생성해서 보낸 "data"
					html += "<div>";
	                html += "<div><table class='table table-striped'>";
	                html += "<tr>";
	                html += "<th>번호(id)</th>";
	                html += "<th>납부금액</th>";
	                html += "<th>납부여부</th>";
	                html += "<th>납부일</th>";
	                html += "</tr>";
	                html += "<tr>";
	                html += "<td>"+args.data[i].id+"</td>";
	                html += "<td>"+args.data[i].howmuch+"</td>";
	                html += "<td>납부 완료</td>";
	                html += "<td>"+args.data[i].inputdate+"</td>";
	                html += "</tr>";
				}
			}
			else{
				html += "<div>";
	            html += "<div><table class='table'><h6><strong>조회된 인원이 없습니다.</strong></h6>";
	            html += "</table></div>";
	            html += "</div>";
			}
			$("#now2").html(html);
			$("#cnt2").html(cnt);
		}
	    ,error:function(e) {
	    	alert(e.responseText);
	    }
	});
}
</script>
<style type="text/css">
h2{text-align: center;}
</style>
</head>
<body>
	<div class="h2">
		<h2>등록금 납부 현황</h2>
	</div>
	<ul class="nav nav-tabs">
	  <li class="nav-item">
	    <a class="nav-link active" data-toggle="tab" href="#input">납부자</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#nor">미납자</a>
	  </li>
	</ul>
	  <div class="tab-pane fade show active" id="input">
	    <div class="container">
			<select id="temper1">
			  <option value="">::학과선택::</option>
			</select>
			
			<button onclick="checkInput()">조회</button>
			<div id="now1"></div>
			<div>
			조회 인원:<span id="cnt1"></span>
			</div>
		</div>
	  </div>
	  <!--탭항목  -->
	  <div class="tab-pane fade" id="nor">
	  	<div class="container">
	  		<select id="temper2">
				  <option value="">::학과선택::</option>
				</select>
				
				<button onclick="check()">조회</button>
				<div id="now2"></div>
				<div>
	  			조회 인원:<span id="cnt2"></span>
				</div>
		</div>
	  </div>
</body>
</html>