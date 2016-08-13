package org.mattpayne.springboot.sql.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		System.out.println("Hello!  I am a servlet and an applciation.");
		PrintWriter out = new PrintWriter(System.out);
		square(out);
		out.flush();
	}

	private static void square(PrintWriter out) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 10; y++) {
				// TODO: Use font awesome!
				out.print("*");
			}
			out.println();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1>It is now " + new java.util.Date() + "</h1>");
		out.println("<pre>");
		square(out);
		out.println("</pre>");
		out.flush();
	}

}
