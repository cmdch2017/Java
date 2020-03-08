package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class countServlet1
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		//获取全局的共享数据
		ServletContext servletContext = this.getServletContext();
		
		//获取计数器count
		Integer count = (Integer) servletContext.getAttribute("count");
		
		//如果获取的计算器对象为空 ，说明是第一次访问，并将count，放入servletCount
		if( servletContext.getAttribute("count") == null) {
			count = 1;
			servletContext.setAttribute("count", count);
		}else {
			//否则就不是第一次访问，将登陆的计数器进行加1的数据更新
			servletContext.setAttribute("count", count+1);
		}
		
		//将登陆的次数显示在页面上
		PrintWriter out =response.getWriter();
		out.print("<!DOCTYPE html>\r\n" + 
				  "<html>\r\n" + 
				  "<head>\r\n" + 
				  "<meta charset=\"UTF-8\">\r\n" + 
				  "<title>登陆网页次数统计</title>\r\n" + 
				  "</head>\r\n" + 
				  "<body>");
		out.print("<h1>");
		out.print("您是第 "+ servletContext.getAttribute("count")+"位访客");
		out.print("<h1>");
		out.print("</body>\r\n" + 
				  "</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

