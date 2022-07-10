<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Requests information list</title>
</head>
<body>
    <h3 align="left">Requests information list</h3>
        <table border="3">
            <thead>
                <tr>
                    <th>IP Address</th>
                    <th>User Agent</th>
                    <th>Request time</th>
                </tr>
            </thead>
                <tbody>
                    <c:forEach var="information" items="${informationList}">
                        <tr>
                            <td><b>${information.ipAddress}</b></td>
                            <td><b>${information.userAgent}</b></td>
                            <td>${information.localTime}</td>
                        </tr>
                    </c:forEach>
                </tbody>
        </table>
</body>
</html>