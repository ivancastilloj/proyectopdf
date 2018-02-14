<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date</th>
    </tr>
    <c:forEach var="c" items="${courses}">
        <tr>
            <td>${c.name}</td>
            <td>${c.name2}</td>
            <td><fmt:formatDate value="${c.date}" pattern="MM/dd/yy"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>