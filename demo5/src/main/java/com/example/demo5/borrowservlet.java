package com.example.demo5;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/borrokkw")
public class borrowservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        /*String name = req.getParameter("name");
        String student_id = req.getParameter("student id");
        String book_id = req.getParameter("book");
        String phone_number = req.getParameter("phone number");*/
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> name= password=  password or username is incorrect </h1>");
        out.println("</body></html>");


/*
        req.setAttribute("right",true);
        RequestDispatcher rd=req.getRequestDispatcher("/borrow.jsp");
        rd.forward(req,resp);
        PrintWriter out = resp.getWriter();
        out.println("<html> <div class=\"verifiaction\">  <h1>Are you sure?</h1>  <h2 class=\"verify_name\"></h2>  <h2 class=\"verify_id\"></h2>  <h2 class=\"verify_phone\"></h2>  <h2 class=\"verify_book\"></h2>  <div class=\"verificatoin-btns\">  <button class=\"verificatoin-confirm verificatoin-btn\" name=\"confirm\">Confirm</button> <button class=\"verificatoin-cancel verificatoin-btn\" name=\"cancel\">Cancel</button> </div> </div> <div class=\"back-drop\"></div> </main> <script src=\"JS/borrow.js\"></script> ");
*/

    }
}
