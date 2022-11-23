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
	        int months=0;
	        String wildness="";
	        out.println("<html>");
	        out.println("<head><title>Servlet1</title></head>");
	        out.println("<body>");
	        out.println("<p>The servlet has received a GET. This is the reply.</p>");
	        
	        ServletContext sc=getServletContext();
	        String myAtt="HBI";
	        String attName;
	        Object attValue;
	        sc.setAttribute(myAtt,"Human Base India");
	        Enumeration enum1=sc.getAttributeNames();
	        while(enum1.hasMoreElements()){
	           attName=(String)enum1.nextElement();
	           attValue=sc.getAttribute(attName);
	           out.println("Attribute Name: "+attName+" Value: "+attValue+"<br>");
	        }
	        
	        String ss=sc.getInitParameter("machineName");
	        out.println("The Machine Name is  "+ss);
	        
	        //Obtaining the init-param attribute for a single servlet
	        Enumeration e=getInitParameterNames();
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
	        
	        
	        out.println("</body></html>");
	        out.close();
	}


}
