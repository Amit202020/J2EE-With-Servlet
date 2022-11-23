package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String s1 = request.getParameter("uid");
		String s2 = request.getParameter("pass");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (s1.equals("abcdefgh")) {

			RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
			rd.forward(request, response);

		} else {

			RequestDispatcher rd = request.getRequestDispatcher("/failure.jsp");
			rd.forward(request, response);

		}
	}
}
