<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>학생메인페이지</title>
<style>
#first {
	overflow: hidden;
}

#privacy {
	width : 40%;
	position : static;
	float: left;
	position: static;
}

#noticeBoard {
	width : 40%;
	float: left;
	position: relative;
}

#second {
	overflow: hidden;
}

#scholarship {
	width : 40%;
	position : static;
	float: left;
	position: static;
}

#jobBoard{
	width : 40%;
	float: left;
	position: relative;
}
</style>
</head>
<body>

	<form>
		<div id="first">
			<div id="privacy">
				<h2>
					<strong>개인정보</strong>
				</h2>
				<table border="5px">
					<tr>
						<td>  
							<input type="button" value="개인정보변경" onclick="location.href='/FinalProject/changeDetailForm.do'">
							<input type="button" value="비밀번호변경" onclick="location.href='/FinalProject/changePasswordForm.do'">
							<input type="button" value="로그아웃" onclick="location.href='/FinalProject/logout.do'">
						</td>  
					</tr>
					
					<tr>
						<td>
							<img alt="개인사진이 올 공간" src="${picture }" width="150" height="150"><br />
							이름 : ${privacy.name } <br />
							학과 : ${privacy.temper_name }
						</td>
					</tr>
				</table>
			</div>

			<div id="noticeBoard">
				<h2>
					<strong>공지사항</strong>
				</h2>
				<table border="5px">
					<tr>
						<th>글번호</th>
						<th>제 목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>

					<tr>
						<c:if test="${noticeBoard.size() == 0 }">
							<h3>
								<strong>공지사항이 없습니다.</strong>
							</h3>
						</c:if>

						<c:if test="${noticeBoard.size() != 0 }">
							<c:forEach var="item" items="${noticeBoard }">
								<tr>
									<td>${item.rn }</td>
									<td><a href="/FinalProject/detailContent.do?num=${item.num}">${item.title }</a></td>
									<td>${item.name }</td>
									<td><fmt:formatDate value="${item.writedate }" pattern="yyyy-MM-dd" /></td>
									<td>${item.readcount }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tr>
				</table>
			</div>
		</div>
		<!-- first end -->

		<div id="second">
			<div id="scholarship">
				<h2>
					<strong>장학금내역</strong>
				</h2>
				<table border="5px">
					<tr>
						<th>장학금명</th>
						<th>장학금액</th>
						<th>장학금번호</th>
						<th>장학금받은학기</th>
					</tr>

					<tr>
						<c:if test="${scholarship.size() == 0 }">
							<td colspan="4"><strong>장학금 수상내역이 없습니다.</strong></td>
						</c:if>

						<c:if test="${scholarship.size() != 0 }">
							<c:forEach var="item" items="${scholarship }">
								<tr>
									<td>${item.scholarship_name }</td>
									<td>${item.scholarship_money }</td>
									<td>${item.scholarship_num }</td>
									<td>${item.scholarship_semester }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tr>
				</table>
			</div>
			
			<div id="jobBoard">
				<h2>
					<strong>취업게시판</strong>
				</h2>
				<table border="5px">
					<tr>
						<th>글번호</th>
						<th>제 목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>

					<tr>
						<c:if test="${jobBoard.size() == 0 }">
							<h3>
								<strong>취업게시판에 글이 없습니다.</strong>
							</h3>
						</c:if>

						<c:if test="${jobBoard.size() != 0 }">
							<c:forEach var="item" items="${jobBoard }">
								<tr>
									<td>${item.rn }</td>
									<td><a href="/FinalProject/detailContent.do?num=${item.num}">${item.title }</a></td>
									<td>${item.name }</td>
									<td><fmt:formatDate value="${item.writedate }" pattern="yyyy-MM-dd" /></td>
									<td>${item.readcount }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>