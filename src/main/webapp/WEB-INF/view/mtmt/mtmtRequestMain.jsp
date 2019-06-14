<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
//신청자 등록 라디오버튼
$(document).ready(function(){
	
	$("input:radio[name=req]").click(function(){
		
		var max = $("#maxpeople").val();
		var now = $("#nowpeople").text();
		
		//alert(now);
		
		if(max > parseInt(now)){
			addRequest();
		}else{
			alert("신청인원 이미달성")
		}
	});
});

//신청자 취소 라디오버튼
$(document).ready(function(){
	
	var id = $("#id").val();
	
	$("input:radio[name=delete]").click(function(){
		requestDelete(id);
	});
	
});

//추가Pro
function addRequest(){
    $.ajax({
        type:'POST',
        url : "<c:url value='/mtmt/addRequest.do'/>",
        data:$("#requestForm").serialize(),		//값을 스트링으로 넘겨준다.
        success : function(data){
            if(data=="success")
            {
            	alert("신청 완료");
            	getrequestList();
            }
        },
        error:function(request,status,error){
        	getrequestList();
       }
    });
}

// 처음 페이지 로딩시 댓글 불러오기 - 레디펑션.
$(function(){
    getrequestList();
});

//신청자 불러오기(Ajax)
function getrequestList(){
    $.ajax({
        type:'POST',
        url : "<c:url value='/mtmt/requestList.do'/>",
        dataType : "json",
        data:$("#requestForm").serialize(),
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        success : function(args){
            
            var nowpeople = args.data.length;	//신청자수
            var html = "";
            
            html += "<div>";
            html += "<input type='hidden' id='nowpeople' name='nowpeople' value="+nowpeople+">";
            html += "</div>";
            
            //$("#now").html(html);		//현재인원 값을 히든으로 만들어준다.
            $("#nowpeople").html(nowpeople);		//신청인원을 삽입한다.
            
        },
        error:function(request,status,error){
       }
    });
}

//신청 취소
//삭제는 코멘트 번호값만 넘겨서 삭제 처리한다.
function requestDelete(id){
	$.ajax({
		url : "<c:url value='/mtmt/requestDelete.do'/>",
		type : 'POST',
		data : {'id' : id},
		success : function(){
			alert("취소 완료");
			getrequestList();
		}
	});
}
</script>
<body>
<div class="container">
    <form id="requestForm" name="requestForm" method="post">
	    
	    <div class="container">
			<div class="btn-group btn-group-toggle btn-xs">	
					<label class="btn btn-primary btn-xs">
						<input type="radio" name="req">멘티신청 
					</label> 
					<label class="btn btn-primary btn-xs">
						<input type="radio" name="delete">신청취소
					</label>
			</div>
		</div>
    
        <input type="hidden" id="num" name="num" value="${detailContent.num }" />  
        <input type="hidden" id="id" name="id" value="${detailContent.id }" />
        <input type="hidden" id="maxpeople" value="${detailContent.maxpeople }"/>
        <span id="now"></span>
    </form>
</div>
<div class="container">
    <form id="requesttListForm" name="requesttListForm" method="post">
        <div id="requestList">
        </div>
    </form>
</div>
 

</body>
</html>