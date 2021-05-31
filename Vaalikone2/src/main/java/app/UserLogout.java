package app;
 
import java.io.IOException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/logout")
public class UserLogout extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserLogout() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "Login.jsp");
        
        // if (session != null) {
       //     session.removeAttribute("user");
       //      
       //     RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
       //     dispatcher.forward(request, response);
       // }
    }
}