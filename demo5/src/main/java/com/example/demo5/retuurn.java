package com.example.demo5;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet ("/return")
public class retuurn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
       /* PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" +"name= password= password or username is incorrect"+ "</h1>");
        out.println("</body></html>");*/
        RequestDispatcher rd = req.getRequestDispatcher("/return.html");
        rd.forward(req,resp);
    }
}
