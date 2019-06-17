<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
  String cp = request.getContextPath();
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 보기</title>
<!-- jquery js파일 추가 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
  $("#showContent #deleteContent").click(function(){
    if(confirm("삭제하시겠습니까?")){
      document.showContent.action = "<%=cp%>/anon/deleteContent.do";
      document.showContent.submit();
    }
  })
  $("#insertComment").click(function(){
    var content = $("#content").val();
    var comment_writer = $("comment_writer").val()
    if(content == "") {
      alert("content를 입력하세요.");
      document.showContent.content.focus();
      return;
    }
    if(comment_writer == "") {
      alert("comment_writer를 입력하세요.");
      document.showContent.comment_writer.focus();
      return;
    }
    
    document.showContent.action="<%=cp%>/anon/insertComment.do";
    document.showContent.submit();
  })
})
function goList() {
  location.href="<%=cp%>/anon/list.do?page=1";
}
</script>
</head>
<body>
  <h2>게시글</h2>
  <hr>
  <form name="showContent" id="showContent" method="post" class="form-control">
    <table class="table table-striped table-hover" >
      <tr>
        <th>글번호</th>
        <th>
        <%System.out.println("여기1"); %>
          ${content.num}
        <%System.out.println("여기2"); %>
        </th>
      </tr>
      <tr>
        <th>제목</th>
        <th>
          ${content.title}
        </th>
      </tr>
      <tr>
        <th>내용</th>
        <th>
          ${content.content}
        </th>
      </tr>
      <tr>
        <th>작성자(익명)</th>
        <th>
          ${content.writer }  
        </th>
      </tr>
      <tr>
        <th>조회수</th>
        <th>
          ${content.readcount}
        </th>
      </tr>
    </table>
    <input type="hidden" id="num" name="num" value="${content.num}" class="form-control">
    <button type="button" id="modifyContent" onclick="location.href='<%=cp%>/anon/modifyContent.do?num=${content.num}'" class="btn btn-primary">수정하기</button>
    <button type="button" id="deleteContent" class="btn btn-primary">삭제하기</button>
    <input type="button" value="목록으로 " onclick="goList();" class="btn btn-primary">
    <table class="table table-striped table-hover">
      <tr>
        <th colspan="3">댓글쓰기</th>
      </tr>
      <tr>
        <th>
          <input type="text" name="content" id="content" width="30" placeholder="댓글내용" class="form-control">
        </th>
        <th>
          <input type="text" name="comment_writer" id="comment_writer" placeholder="작성자(익명)" class="form-control">
        </th>
        <th>
          <button type="button" id="insertComment" class="form-control">입력</button>
        </th>
      </tr>
      <tr>
        <th colspan="2">
          댓글작성자(익명)
        </th>
        <th>
          작성시간
        </th>
      </tr>
      <c:forEach var="comment" items="${comments}">
      <tr align="left">
        <td>${comment.comment_writer}</td>
        <td>${comment.content}</td>
        <td> 
          <fmt:formatDate value="${comment.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/> 
        </td>
        <td>
          <button type="button" onclick="location.href='<%=cp%>/anon/deleteComment.do?num=${content.num}&comment_num=${comment.comment_num}'" class="btn btn-danger">삭제</button>
        </td>
        <!-- 

        <button type="button" id="modifyContent" onclick="location.href='<%=cp%>/anon/modifyContent.do?num=${content.num}'">수정하기</button>
        -->
      </tr>
      </c:forEach>
    </table>
    
  </form>

</body>

</html>