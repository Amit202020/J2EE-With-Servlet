package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head><title>Servlet1</title></head>");
	        out.println("<body>");
	        out.println("<p>Now U are inside Servlet1</p>");
	        

	        //Obtaining the init-param attribute for a single servlet
	        int months=0;
	        String wildness="";
	        
	        Enumeration e= getInitParameterNames();
	        while(e.hasMoreElements()){
	            String paramName=(String)e.nextElement();
	            if(paramName.equals("months")){
	                months=Integer.parseInt(getInitParameter(paramName));
	            }
	            if(paramName.equals("wildness")){
	                wildness=getInitParameter(paramName);
	            }
	        }
	        out.println("Months:::"+months+"WildNess:::"+wildness);
	        
	        
	        //obtaining the context-param attribute
	        ServletContext sc=getServletContext();
	        String ss=sc.getInitParameter("machineName");
	        out.println("The Machine Name is  "+ss);
	        out.println("</body></html>");
	        out.close();
	        
	}

	

}
