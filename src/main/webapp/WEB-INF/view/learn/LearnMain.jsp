<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>학습목차</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
p { margin:20px 0px; }
</style>
	<!-- jQuery -->
	<script src="//code.jquery.com/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
   <!--  <script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script> -->
<script>

//종료 알러트창으로 확인
$("input:submit[name=closeSubmit]").click(function(){
	
	if(confirm("종료하시겠습니까?")){
		return true;
	}
	return false;
});

$(document).ready(function(){
	
	$(".add").on("click",function(){
		var lecture_num=$(this).attr('name');
		var week=$(this).attr('id');
		var now_study=$("#now_"+week+"").val();
		
		addNow(lecture_num,week,now_study);
	});
	
	$(".dis").on("click",function(){
		var lecture_num=$(this).attr('name'); 
		var week=$("#now_"+lecture_num+"").val();
		var now_study=$("#now_"+week+"").val();
		
		disNow(lecture_num,week,now_study);
	});
	
});	//레디펑션end


//단계증가
function addNow(lecture_num,week,now_study){
   
		
	$.ajax({
        type:'POST',
        url : "<c:url value='/learn/addNow.do'/>",
        data:{'lecture_num' : lecture_num, 'week' : week, 'now_study' : now_study},
        success : function(){
        	location.href="/FinalProject/learn/LearnMain.do";
        },
        error:function(request,status,error){
       }
    });
}

//단계감소
function disNow(lecture_num,week,now_study){
	
	$.ajax({
		type : 'POST',
		url : "<c:url value='/learn/deleteNow.do'/>",
		data : {'lecture_num' : lecture_num, 'week' : week, 'now_study' : now_study},
		success : function(){
			location.href="/FinalProject/learn/LearnMain.do";
		}
	});
}

//목차입력빈칸확입
function checkIt(){
	var myform = eval("document.insertForm");
	
	if(!myform.lecture_num.value){
		alert("강의번호를 입력하세요");
		return false;
	}
	
	if(!myform.subject_title.value){
		alert("학습제목을 입력하세요");
		return false;
	}
	
	if(!myform.week.value){
		alert("주차를 입력하세요");
		return false;
	}
	
	if(!myform.max_study.value){
		alert("최대학습량을 입력하세요")
		return false;
	}
	
	if(!myform.now_study.value){
		alert("현재학습량을 입력하세요")
		return false;
	}
	
	return true;
}

//학습목차 삽입폼 생성
/* $("#insertbtn").on("click",function(){
	
	var str = '';

	str += '<div>';
	str += '<span>강의번호 :<input type="number" name="lecture_num"/></span>';
	str += '<span>주 차 :<input type="text" name="week"></span>';
	str += '<span>학습제목 :<input type="text" name="subject_title"></span>';
	str += '<span>최대학습량<input type="number" name="max_study"></span>';
	str += '<span>현재학습량<input type="number" name="now_study"></span>';
	str += '<input type="submit" id="inputinsert" value="등록">';
	str += '</div>';
	
	$("#insert").html(str);
}); */


//현재페이지불러오기
function getList(){
	$.ajax({
		type : "GET",
		url : "<c:url value='/learn/LearnMain.do'/>",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success : function(args){
        },
        error:function(request,status,error){
        }
	});
}

</script>

</head>
  <body>
    <div class="container">
    <input type="button" id="insertbtn" value="목차입력" onclick="location.href='/FinalProject/learn/LearnInsertForm.do'">
      <div class="row">
    	<!--목차 입력칸 생성 및 바로 입력  -->
    	<!-- <form name="insertForm" id="insertForm" action="/FinalProject/learn/LearnInsert.do" method="post" onsubmit="return checkIt()">
    	<span id="insert"></span>
    	</form> -->
    	<!--목차 입력 끝  -->
    	
    	<!--DB에 내용 없으면  -->    
		<c:if test="${mainList.size() == 0 }">
			<p> 내용이 없습니다. </p>
		</c:if>
	
		<!--DB에 내용 있으면  -->
		<c:if test="${mainList.size() > 0 }">	        
	        <c:forEach var="item" items="${mainList }">
		        <div class="col-6">
		        	<p></p>
		          <div class="card">
		            <div class="card-header">
		              <span>${item.week }</span>
		            </div>
		            <!-- <img src="images/card-image.png" alt="" /> -->
		            <div class="card-body">
		            <div class="dis">
		              <h5 class="card-title">${item.subject_title }</h5>
		              <div>
		              	<form id="nowMaxForm">
		              	<span class="meter">
		              	진행단계 : 
		              	<progress max="${item.max_study }"  value="${item.now_study }"></progress>
		              	${item.now_study }/${item.max_study }
		              	<input type="button" class="add" id="${item.week }" name="${item.lecture_num}" value="증가">
		              	<input type="hidden" id="now_${item.week }" value="${item.now_study}">
		              	<input type="hidden" id="now_${item.lecture_num }" value="${item.week }">
		              	<input type="button" class="dis" name="${item.lecture_num }" value="감소">
		              	</span>
		              	</form>
		              </div>
		              <p class="card-text">
		              <form id="closeForm" name="closeForm" action="/FinalProject/learn/learnDelete.do" method="post">
			              <input type="hidden" id="lecture_num" name="lecture_num" value="${item.lecture_num}"/> 
			              <input type="hidden" id="week" name="week" value="${item.week}"/> 
		              	  <input type="submit" class="btn btn-primary" value="종료">
		              </form>
		             </div>
		            </div>
		          </div>
		        </div>
	        </c:forEach>
		</c:if>        
        
      </div><!--row  -->
    </div><!--container  -->
</body>
</html>
