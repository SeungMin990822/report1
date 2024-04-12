<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>수강신청</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/docreateEnroll" modelAttribute="enroll">
    <table class="formtable">
        <tr>
            <td class="label"> 년도:</td>
            <td><sf:input class="control" type="text" path="year"/>  <br/>
                <sf:errors path="year" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 학기:</td>
            <td><sf:select path="semester" class="control">
                <sf:option value="">-- 선택 --</sf:option>
                <sf:option value="1">1</sf:option>
                <sf:option value="2">2</sf:option>
            </sf:select> <br/>
                <sf:errors path="semester" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 과목명:</td>
            <td><sf:input class="control" type="text" path="title"/> <br/>
                <sf:errors path="title" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 교과구분:</td>
            <td><sf:select path="status" class="control">
                <sf:option value="">-- 선택 --</sf:option>
                <sf:option value="전선">전선</sf:option>
                <sf:option value="전필">전필</sf:option>
                <sf:option value="토대">토대</sf:option>
                <sf:option value="필교">필교</sf:option>
                <sf:option value="일교">일교</sf:option>
                <sf:option value="핵심">핵심</sf:option>
            </sf:select> <br/>
                <sf:errors path="status" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> 교수님성함:</td>
            <td><sf:input class="control" type="text" path="name"/>  <br/>
                <sf:errors path="name" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> 학점:</td>
            <td><sf:input class="control" type="text" path="credit"/>  <br/>
                <sf:errors path="credit" class="error"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="수강신청"/> </td>
        </tr>
    </table>
</sf:form>

</body>
</html>
