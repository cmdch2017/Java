<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>application</title>
</head>
<body>
<%
    int i = 0;
    synchronized (application) {
        if (application.getAttribute("times") == null) {
            i = 1;
        } else {
            i = Integer.parseInt((String) application.getAttribute("times"));
        }
        application.setAttribute("time", Integer.toString(i));
    }
%>
<table>
    <tr>
        <td>您是第 <font color="red"><%=i %></font> 位访问本网站的游客</td>

    </tr>
</table>
</body>
</html>

