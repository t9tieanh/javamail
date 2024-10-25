package com.javamail.controller;
import com.javamail.model.UserModel;
import com.javamail.utils.MailUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("views/home.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String resultMessage = "";
        String resultPost = "danger";;
        try {
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            UserModel user = new UserModel(email, firstName, lastName);


            MailUtils mailUtils = new MailUtils();
            if (mailUtils.sendEmail("phama9162@gmail.com", user.getEmail(), user.getEmailTitle(), user.getEmailContent())) {
                resultMessage = "Đã gửi email thành công !";
            } else  resultMessage =  "Chưa gửi được email";

        } catch (Exception e) {
            resultMessage = e.getMessage();
        }
        request.setAttribute("resultMessage", resultMessage);
        request.setAttribute("resultPost", resultPost);
        RequestDispatcher rd = request.getRequestDispatcher("views/home.jsp");
        rd.forward(request, response);
    }
}
