<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- <link rel="stylesheet" href="/css/bootstrap.css"> -->
</head>
<body>
<div class="container">
    <form id="commentForm" name="commentForm" method="post">
    <br><br>
        <div>
            <div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td>
                            <textarea rows="3" cols="80" id="content" name="content"></textarea>
                            <br>
                            <div>
                                <a href='#' onClick="fn_comment('${detailContent.num }')" class="btn pull-right btn-success">등록</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" id="num" name="num" value="${detailContent.num }" />  
        <input type="hidden" id="name" name="name" value="${detailContent.id }" />      
        <input type="hidden" id="id" name="id" value="${detailContent.id }" />      
    </form>
</div>
<div class="container">
    <form id="commentListForm" name="commentListForm" method="post">
        <div id="commentList">
        </div>
    </form>
</div>
 
<script>
//댓글 등록하기(Ajax)
function fn_comment(code){
    
    $.ajax({
        type:'POST',
        url : "<c:url value='/mtmt/addComment.do'/>",
        data:$("#commentForm").serialize(),		//값을 스트링으로 넘겨준다.
        success : function(data){
            if(data=="success")
            {
                getCommentList();		//성공했을 경우 리스트 뽑아오는 메소드 실행
                $("#content").val("");	//코멘트 창은 다시 입력할수있게 클린시킨다.
            }
        },
        error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
    });
}

// 처음 페이지 로딩시 댓글 불러오기 - 레디펑션.
$(function(){
    getCommentList();
});
 
// 댓글 불러오기(Ajax)
function getCommentList(){
    $.ajax({
        type:'GET',
        url : "<c:url value='/mtmt/commentList.do'/>",
        dataType : "json",
        data:$("#commentForm").serialize(),		//아이디가 commentForm인 태그의 값 넘긴다. - 그냥 num값만  넘겨도된다.
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        success : function(args){
            
            var html = "";
            var cCnt = args.data.length;	//코멘트 갯수
            
            //각각의 코멘트를 표현하기 위해 for문으로 각각 태그를 지정해서 표현해준다.
            //각 코멘트 내용마다 수정삭제가 필요하므로 태그로 링크를 걸어준다. 
            if(args.data.length > 0){
                
                for(i=0; i<args.data.length; i++){
                    html += "<div>";
                    html += "<div><table class='table'><h6><strong>id:"+args.data[i].id+"</strong></h6>";
                    html += args.data[i].content + "<tr><td>";
                    html += '<a onclick="commentUpdate('+args.data[i].comment_num+',\''+args.data[i].content+'\');"> 수정 </a>';
                    html += '<a onclick="commentDelete('+args.data[i].comment_num+');"> 삭제 </a> </div>';
                    html += ""+args.date[i]+"</td></tr>";
                    html += "</table></div>";
                    html += "</div>";
                }
            } else {
                html += "<div>";
                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                html += "</table></div>";
                html += "</div>";
            }
            
            $("#cCnt").html(cCnt);		//코멘트 갯수를 삽입한다.
            $("#commentList").html(html);	//코멘트 리스트에 설정한 html값을 삽입한다.
            
        },
        error:function(request,status,error){
       }
    });
}

//댓글 수정
function commentUpdate(comment_num, content){
	var str = '';
	
	str += '<div>';
	str += '<input type="text" name="content_'+comment_num+'" value="'+content+'">';
	str += '<span><button type="button" onclick="commentUpdatePro('+comment_num+');">수정</button> </span>';
	str += '</div>';
	
	$("#commentList").html(str);	//수정폼을 따로 태그로 삽입해서 바로 수정할 수 있게 설정 
}

//댓글 수정 Pro
function commentUpdatePro(comment_num){
	var updateContent = $('[name=content_'+comment_num+']').val();	//태그 네임으로 content_뒤에 코멘트 번호를 붙여서 새로운 네임속성 지정후 그값을 찾아온다.
	
	//수정은 수정내용과 코멘트 번호만 데이터로 넘기면 된다.
	$.ajax({
		url : "<c:url value='/mtmt/commentUpdate.do'/>",
		type : 'POST',
		data : {'content' : updateContent, 'comment_num' : comment_num},
		success : function(){
			getCommentList();	//수정 완료후 다시 댓글 목록을 불러온다.
		}
	});
}

//댓글 삭제
//삭제는 코멘트 번호값만 넘겨서 삭제 처리한다.
function commentDelete(comment_num){
	$.ajax({
		url : "<c:url value='/mtmt/commentDelete.do'/>",
		type : 'POST',
		data : {'comment_num' : comment_num},
		success : function(){
			getCommentList();	//삭제처리후에 댓글 목록을 불러온다.
		}
	});
}
</script>
</body>
</html>