<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수강신청현황</title>
</head>
<body>
<c:forEach var="enroll" items="${id_enrolls}" >
    <p> <c:out value="${enroll}"> </c:out> </p>
</c:forEach>
</body>
</html>
