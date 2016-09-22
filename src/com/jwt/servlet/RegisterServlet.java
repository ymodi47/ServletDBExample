package com.jwt.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("username");
        String e = request.getParameter("email");
        String m = request.getParameter("phone_no");
        String p = request.getParameter("password");
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb", "root", "magily2015");
            PreparedStatement ps = con.prepareStatement("insert into info values(?,?,?,?)");
            ps.setString(1, n);
            ps.setString(2, e);
            ps.setString(3, m);
            ps.setString(4, p);
            int i = ps.executeUpdate();
            if (i > 0)
            	response.sendRedirect("final.html");
         } catch (Exception e2) {
            System.out.println(e2);
        } 
        out.close();
    }
 }