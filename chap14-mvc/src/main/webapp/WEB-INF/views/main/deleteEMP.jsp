<%--
  Created by IntelliJ IDEA.
  User: gram
  Date: 2023-11-26
  Time: 오후 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원 퇴사 페이지</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>
    <h1>전체 조회</h1>
    <a href="/employees">전체 조회</a>
    <h1>개별 조회</h1>
    <form action="/employees" method="get">
        <label>사원 번호를 입력하세요 : </label>
        <input type="text" name="empId"/>
        <button type="submit">요청하기</button>
    </form>

    <h3>사원 번호를 정해 삭제처리</h3>
    <form action="${pageContext.servletContext.contextPath}/employeesd" method="post">
        퇴사 처리 할 사원 번호 : <input type="number" name="empId"> <br>
        <br>
        <br>
        <input type="submit" value="등록하기"/>
    </form>
</body>
</html>
