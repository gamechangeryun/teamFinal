<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>게스트페이지</title>
<style>
#first {
	overflow: hidden;
}

#noticeBoard {
	width : 33%;
	position : static;
	float: left;
	position: static;
}

#jobBoard {
	width : 33%;
	float: left;
	position: relative;
}

#mtmtBoard {
	width : 33%;
	float: left;
	position: relative;
}

#second {
	overflow: hidden;
}

#freeBoard {
	width : 33%;
	position : static;
	float: left;
	position: static;
}

#anonBoard {
	width : 33%;
	float: left;
	position: relative;
}

#notice {
	width : 33%;
	float: left;
	position: relative;
}
</style>
</head>
<body>
	<form>
		<div id="first">
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
							<td colspan="5">
								<h3><strong>공지사항 게시판에 글이 없습니다.</strong></h3>
							</td>
						</c:if>

						<c:if test="${noticeBoard.size() != 0 }">
							<c:forEach var="item" items="${noticeBoard }">
								<tr>
									<td>${item.rn }</td>
									<td><a
										href="/FinalProject/detailContent.do?num=${item.num}">${item.title }</a></td>
									<td>${item.name }</td>
									<td><fmt:formatDate value="${item.writedate }"
											pattern="yyyy-MM-dd" /></td>
									<td>${item.readcount }</td>
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
							<td colspan="5">
								<h3><strong>취업게시판에 글이 없습니다.</strong></h3>
							</td>
						</c:if>

						<c:if test="${jobBoard.size() != 0 }">
							<c:forEach var="item" items="${jobBoard }">
								<tr>
									<td>${item.rn }</td>
									<td><a href="/FinalProject/job_bd/detailContent.do?num=${item.num}">${item.title }</a></td>
									<td>${item.name }</td>
									<td><fmt:formatDate value="${item.writedate }" pattern="yyyy-MM-dd" /></td>
									<td>${item.readcount }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tr>
				</table>
			</div>
			
			<div id="mtmtBoard">
				<h2>
					<strong>멘토멘티게시판</strong>
				</h2>
				<table border="5px">
					<tr>
						<th>글번호</th>
						<th>제 목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>분류</th>
					</tr>

					<tr>
						<c:if test="${mtmtBoard.size() == 0 }">
							<td colspan="6">
								<h3><strong>멘토멘티게시판에 글이 없습니다.</strong></h3>
							</td>
						</c:if>

						<c:if test="${mtmtBoard.size() != 0 }">
							<c:forEach var="item" items="${mtmtBoard }">
								<tr>
									<td>${item.rn }</td>
									<td><a href="/FinalProject/mtmt/detailContent.do?num=${item.num}">${item.title }</a></td>
									<td>${item.name }</td>
									<td><fmt:formatDate value="${item.writedate }" pattern="yyyy-MM-dd" /></td>
									<td>${item.readcount }</td>
									<td>${item.position }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tr>
				</table>
			</div>
		</div>
		
		<div id="second">
			<div id="freeBoard">
				<h2>
					<strong>자유게시판</strong>
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
						<c:if test="${freeBoard.size() == 0 }">
							<td colspan="5">
								<h3><strong>자유게시판에 글이 없습니다.</strong></h3>
							</td>
						</c:if>

						<c:if test="${freeBoard.size() != 0 }">
							<c:forEach var="item" items="${freeBoard }">
								<tr>
									<td>${item.rn }</td>
									<td><a
										href="/FinalProject/detailContent.do?num=${item.num}">${item.title }</a></td>
									<td>${item.name }</td>
									<td><fmt:formatDate value="${item.writedate }"
											pattern="yyyy-MM-dd" /></td>
									<td>${item.readcount }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tr>
				</table>
			</div>
			
			<div id="anonBoard">
				<h2>
					<strong>대나무숲게시판</strong>
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
						<c:if test="${anonBoard.size() == 0 }">
							<td colspan="5">
								<h3><strong>대나무숲게시판에 글이 없습니다.</strong></h3>
							</td>
						</c:if>

						<c:if test="${anonBoard.size() != 0 }">
							<c:forEach var="item" items="${anonBoard }">
								<tr>
									<td>${item.rn }</td>
									<td><a href="/FinalProject/anon/showContent.do?num=${item.num}">${item.title }</a></td>
									<td>${item.name }</td>
									<td><fmt:formatDate value="${item.writedate }" pattern="yyyy-MM-dd" /></td>
									<td>${item.readcount }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tr>
				</table>
			</div>
			
			<div id="notice">
				<table border="5px">
					<tr><td>
						<h1>해당 페이지 주의사항!</h1>
						<h4>해당 페이지는 게스트 계정으로 로그인 된 페이지 입니다.</h4>
						<h4>학교의 소속 인원이 아니므로 게시판을 읽기만 가능합니다.</h4>
						<h4>만약, 게시판에 글 쓰기를 희망 하시면 상단 좌측에 글 쓰기 링크를 클릭해주세요</h4>
						<h4>교직원이 검토 후 게시판에 등록을 하도록 도와드리겠습니다.</h4>
						<h4>감사합니다.</h4>
					</td></tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>