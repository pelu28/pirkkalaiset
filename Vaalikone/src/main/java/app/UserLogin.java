package app;

import java.io.*;
//import java.io.Serializable;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import data.User;
import data.UserDAO;
 
@WebServlet("/login")
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserLogin() {
        super();
    }
    	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        UserDAO userDao = new UserDAO();
         
        try {
            User user = userDao.checkLogin(email, password);
            String destPage = "Login.jsp";
             
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "VaiteList.jsp";
            } else {
                String message = "Väärä käyttäjätunnus / salasana";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}