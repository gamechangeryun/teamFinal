<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form>
	<!-- 학생 -->
	<c:if test="${position == 0}">
		<table>
			<tr>
				<td>
					<select name="classRelated"
						onchange="window.open(value,'_self');">
							<option value="#">수업관련</option>
							<option value="/FinalProject/hw_bd/board.do">과제제출나중에뺴기</option>
							<option value="1">수강신청</option>
							<option value="2">수강포기</option>
							<option value="3">수강조회</option>
							<option value="4">출석확인</option>
							<option value="5">강의게시판이동</option>
					</select> 
					<select name="gradeCheck" onchange="window.open(value,'_self');">
							<option value="#">성적관련</option>
							<option value="/FinalProject/totalScore.do">전체성적확인</option>
							<option value="/FinalProject/semesterScore.do">해당학기성적확인</option><!-- /FinalProject/changescore/ChangescoreinputInsert.do -->
							<option value="/FinalProject/lectureRating.do">교수강의평가</option>
					</select> 
					<select name="leaveNrein" onchange="window.open(value,'_self');">
							<option value="#">휴복학신청</option>
							<option value="/FinalProject/leaveApplyForm.do">휴학신청</option>
							<option value="/FinalProject/reinApplyForm.do">복학신청</option>
					</select> 
					<select name="board" onchange="window.open(value,'_self');">
							<option value="#">게시판</option>
							<option value="/FinalProject/noticeBoardMain.do">공지사항게시판</option>
							<option value="/FinalProject/mtmt/mtmtlist.do">멘토멘티게시판</option>
							<option value="3">자유게시판</option>
							<option value="/FinalProject/anon/list.do">대나무숲</option>
							<option value="/FinalProject/job_bd/board.do">취업게시판</option>
							<option value="/FinalProject/qna/list.do">1대1질문</option>
					</select>
				</td>
			</tr>
		</table>
	</c:if>
	
	<!-- 교수 -->
	<c:if test="${position == 1}">
		<table>
			<tr>
				<td>
					<select name="studentMana" onchange="window.open(value,'_self');">
						<option value="#">수업관련</option>
						<option value="/FinalProject/lectureapply.do">강의개설신청</option>
						<option value="/FinalProject/lectureList.do">강의리스트</option>
						<option value="/FinalProject/atten/attenMain.do">출석입력</option>
						<option value="/FinalProject/canceledlectureForm.do">휴강신청</option>
						<option value="/FinalProject/submitCanceledList.do">휴강일확인 및 보강일 확인</option>
					</select>
					
					<select name="professorMana" onchange="window.open(value,'_self');">
						<option value="#">성적관련</option>
						<option value="/FinalProject/scoreinput/scoreinputMain.do">성적입력</option>
						<option value="/FinalProject/changescore/ChangescoreinputMain.do">성적정정신청서확인</option>
						<option value="/FinalProject/lectureRating.do">강의평가확인</option>
					</select> 
					
					<select name="board" onchange="window.open(value,'_self');">
						<option value="#">게시판</option>
						<option value="/FinalProject/noticeBoardMain.do">공지사항게시판</option>
						<option value="/FinalProject/mtmt/mtmtlist.do">멘토멘티게시판</option>
						<option value="3">자유게시판</option>
						<option value="/FinalProject/anon/list.do">대나무숲</option>
						<option value="/FinalProject/job_bd/board.do">취업게시판</option>
						<option value="/FinalProject/qna/list.do">1대1질문</option>
				</select>
				</td>
			</tr>
		</table>
	</c:if>
	
	<!-- 교직원 -->
	<c:if test="${position == 2}">
		<table>
			<tr>
				<td>
					<select name="studentMana" onchange="window.open(value,'_self');">
						<option value="#">학생관리</option>
						<option value="/FinalProject/person/main.do">신규학생등록</option>
						<option value="/FinalProject/leaveApplySubmit.do">휴학신청허용</option>
						<option value="/FinalProject/reinApplyList.do">복학신청허용</option>
						<option value="/FinalProject/leaveStudent.do">휴학생확인</option>
						<option value="/FinalProject/tuition/main.do">등록금납부현황</option>
						<option value="/FinalProject/scholarship.do">장학금지급현황</option>
						<option value="5">졸업가능여부</option>
						<option value="/FinalProject/gra/graboard.do">졸업생확인</option>
					</select>
					
					<select name="professorMana" onchange="window.open(value,'_self');">
						<option value="#">교수관리</option>
						<option value="/FinalProject/person/main.do">신규교수등록</option>
						<option value="/FinalProject/lectureapplyList.do">강의개설허용</option>
						<option value="/FinalProject/canceledList.do">휴강신청허용</option>
						<option value="/FinalProject/wol/list.do">교수급여관리</option>
					</select>
					
					<select name="guestMana" onchange="window.open(value,'_self');">
						<option value="#">게스트관리</option>
						<option value="/FinalProject/guestInputSubmit.do">게스트권한허용</option>
					</select>
					
					<select name="board" onchange="window.open(value,'_self');">
						<option value="#">게시판</option>
						<option value="/FinalProject/noticeBoardMain.do">공지사항게시판</option>
						<option value="/FinalProject/mtmt/mtmtlist.do">멘토멘티게시판</option>
						<option value="3">자유게시판</option>
						<option value="/FinalProject/anon/list.do">대나무숲</option>
						<option value="/FinalProject/job_bd/board.do">취업게시판</option>
						<option value="/FinalProject/qna/list.do">1대1질문</option>
					</select>
				</td>
			</tr>
		</table>
	</c:if>
	
	<!-- 게스트 -->
	<c:if test="${position == 3}">
		<table>
			<tr>
				<td>
					<a href="/FinalProject/guestInputForm.do">글쓰기 신청</a>
				</td>
			</tr>
		</table>
	</c:if>
	
	
</form>