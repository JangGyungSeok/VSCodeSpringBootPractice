<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page session="true" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table>
        <tr>
            <th>SEQ</th>
            <th>ITEMID</th>
        </tr>
 
        
        <c:forEach var="list" items="${list}">
            <tr>
                <td><p>${list.ID}</p></td>
                <td><p>${list.Password}</p></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
