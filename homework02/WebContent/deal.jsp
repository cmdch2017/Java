<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<body>
<%
    String[][] userList={{"ab","123"},{"cd","456"}};//保存用户列表
    boolean flag=false;//登陆状态
    request.setCharacterEncoding("utf-8");
    String username = request.getParameter("username");
    String pwd=request.getParameter("pwd");
    for(int i=0;i<userList.length;i++){
        if(userList[i][0].equals(username)){
            if(userList[i][1].equals(pwd)){
                flag=true;//表示登陆成功
                break;
            }
        }
    }
    if(flag){
    	//为了重定向可以共享数据使用session进行跳转
        session.setAttribute("username", username);//保存用户名&nbsp;到session范围的变量中
        response.sendRedirect("main.jsp");//跳转到主页
    }else{
        response.sendRedirect("login.jsp");//跳转到登录页面
    }
%>
</body>

