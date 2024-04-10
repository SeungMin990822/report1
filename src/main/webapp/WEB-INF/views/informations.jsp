<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학점 요약</title>
</head>
<body>
<h1>학년별/학기별 이수 학점</h1>
<table border="1">
    <tr>
        <th>학년</th>
        <th>학기</th>
        <th>총 이수 학점</th>
    </tr>
    <c:forEach var="info" items="${creditSummary}">
        <tr>
            <td><c:out value="${info.year == -1 ? '총계' : info.year}" /></td>
            <td><c:out value="${info.semester == -1 ? '전체' : info.semester}" /></td>
            <td><c:out value="${info.credit}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>