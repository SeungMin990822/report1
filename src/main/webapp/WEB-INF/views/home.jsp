<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>학사 정보 시스템 </h1>
  <div>
    <button>로그인</button>
  </div>
  <table border="1">
    <tr>
      <td><a href="${pageContext.request.contextPath}/informations">학년별 이수학점 조회</a></td>
      <td><a href="${pageContext.request.contextPath}/createoffer">오퍼신청</a></td>
      <td><a href="${pageContext.request.contextPath}/createEnroll">수강 신청하기</a></td>
      <td><a href="${pageContext.request.contextPath}/enrolls">수강 신청 조회하기</a></td>
    </tr>
  </table>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
      <a href="javascript:document.getElementById('logout').submit()">Logout</a>
    </c:if>

    <form id="logout"  action="<c:url value="/logout" />"method="post">
      <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
    </form>

  </body>
</html>
