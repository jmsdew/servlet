<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
    <jsp:forward page="WEB-INF/views/main/deleteEMP.jsp"/>
   <%-- <a href="/employees">전체 조회</a>

    <form action="/employees" method="get">
        <label>사원 번호를 입력하세요 : </label>
        <input type="text" name="empId"/>
        <button type="submit">요청하기</button>
    </form>--%>

</body>
</html>