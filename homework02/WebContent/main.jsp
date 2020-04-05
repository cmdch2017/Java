<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<body>
<%String username=(String)session.getAttribute("username"); %><!-- 获取保存在session范围在内的用户名 -->
您好！[<%=username %>],欢迎访问！<br>
<a href="exit.jsp">[退出]</a>
</body>

