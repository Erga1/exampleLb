package com.example.demo5;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login_a")
public class login extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("user");

        String pswd = request.getParameter("password");

        response.setContentType("text/html");
    if("admin".equals(name) && "123".equals(pswd)) {
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
        rd.forward(request,response);
}
        // Hello
      else{  PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" +"name= " + name+" password= " +pswd+" password or username is incorrect"+ "</h1>");
        out.println("</body></html>");}
    }

}