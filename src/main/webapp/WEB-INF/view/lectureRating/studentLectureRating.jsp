<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>학생 강의평가</title>
</head>
<body>
	<form action="/FinalProject/insertLectureRating.do" method="post">
		<h3>강의평가 과목선택</h3>
		<select name="selectLecture">
				<option value="#" selected="selected">강의선택</option>
			<c:forEach var="item" items="${LectureList }">
				<option value="${item.lecture_num }">${item.lecture_title }</option>
			</c:forEach>
		</select>
		<h3>1. 강의계획서가 충실하게 구성되어 강좌선택에 도움이 되었다.</h3>
		<input type="radio"	name="q1" value="1">전혀아니다
		<input type="radio"	name="q1" value="2">아니다
		<input type="radio"	name="q1" value="3">보통이다
		<input type="radio"	name="q1" value="4">그렇다
		<input type="radio"	name="q1" value="5">매우그렇다
		
		<h3>2. 강의자료가 적절히 활용되어 학습에 도움이 되었다.</h3>
		<input type="radio"	name="q2" value="1">전혀아니다
		<input type="radio"	name="q2" value="2">아니다
		<input type="radio"	name="q2" value="3">보통이다
		<input type="radio"	name="q2" value="4">그렇다
		<input type="radio"	name="q2" value="5">매우그렇다
		
		<h3>3. 이  수업은 전반적으로 출결관리가 잘 되었다.</h3>
		<input type="radio"	name="q3" value="1">전혀아니다
		<input type="radio"	name="q3" value="2">아니다
		<input type="radio"	name="q3" value="3">보통이다
		<input type="radio"	name="q3" value="4">그렇다
		<input type="radio"	name="q3" value="5">매우그렇다
		
		<h3>4. 교수님은 학생들의 참여와 소통을 독료하였다.</h3>
		<input type="radio"	name="q4" value="1">전혀아니다
		<input type="radio"	name="q4" value="2">아니다
		<input type="radio"	name="q4" value="3">보통이다
		<input type="radio"	name="q4" value="4">그렇다
		<input type="radio"	name="q4" value="5">매우그렇다
		
		<h3>5. 시험, 과제 등 성적평가의 기준이 적절하며 공정하였다.</h3>
		<input type="radio"	name="q5" value="1">전혀아니다
		<input type="radio"	name="q5" value="2">아니다
		<input type="radio"	name="q5" value="3">보통이다
		<input type="radio"	name="q5" value="4">그렇다
		<input type="radio"	name="q5" value="5">매우그렇다
		
		<h3>6. 강의내용이 효과적으로 전달되어 이해하기 쉬웠다.</h3>
		<input type="radio"	name="q6" value="1">전혀아니다
		<input type="radio"	name="q6" value="2">아니다
		<input type="radio"	name="q6" value="3">보통이다
		<input type="radio"	name="q6" value="4">그렇다
		<input type="radio"	name="q6" value="5">매우그렇다
		
		<h3>7. 본 강의를 통하여 해당분야에 대한 충분한 지적 자극을 받았다.</h3>
		<input type="radio"	name="q7" value="1">전혀아니다
		<input type="radio"	name="q7" value="2">아니다
		<input type="radio"	name="q7" value="3">보통이다
		<input type="radio"	name="q7" value="4">그렇다
		<input type="radio"	name="q7" value="5">매우그렇다
		
		<h3>8. 교수님은 열의를 가지고 강의를 진행하였다.</h3>
		<input type="radio"	name="q8" value="1">전혀아니다
		<input type="radio"	name="q8" value="2">아니다
		<input type="radio"	name="q8" value="3">보통이다
		<input type="radio"	name="q8" value="4">그렇다
		<input type="radio"	name="q8" value="5">매우그렇다
		
		<h3>9. 본 강의를 다른 학생에게 추천하고 싶다.</h3>
		<input type="radio"	name="q9" value="1">전혀아니다
		<input type="radio"	name="q9" value="2">아니다
		<input type="radio"	name="q9" value="3">보통이다
		<input type="radio"	name="q9" value="4">그렇다
		<input type="radio"	name="q9" value="5">매우그렇다
		
		<h3>10. 본 강의는 전반적으로 유익하였다.</h3>
		<input type="radio"	name="q10" value="1">전혀아니다
		<input type="radio"	name="q10" value="2">아니다
		<input type="radio"	name="q10" value="3">보통이다
		<input type="radio"	name="q10" value="4">그렇다
		<input type="radio"	name="q10" value="5">매우그렇다
		
		<h2>교수님께 하고 싶은 말</h2>
		<textarea rows="5" cols="50" name="totalcomment"></textarea><br />
		
		<input type="submit" value="제출">
		<input type="button" value="뒤로가기" onclick="location.href='/FinalProject/${returnPage }'">
	</form>
</body>
</html>