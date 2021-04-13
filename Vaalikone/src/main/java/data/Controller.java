package data;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VaittamatDao vaittamatDao;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        vaittamatDao = new VaittamatDao(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertVaittamat(request, response);
                break;
            case "/delete":
                deleteVaittamat(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateVaittamat(request, response);
                break;
            default:
                listVaittamat(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listVaittamat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Vaittamat> listVaittamat = vaittamatDao.listAllVaittamat();
        request.setAttribute("listVaittamat", listVaittamat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("VaiteList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("VaiteKirjaa.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Vaittamat existingVaittamat = vaittamatDao.getVaittamat(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("VaiteKirjaa.jsp");
        request.setAttribute("vaittama", existingVaittamat);
        dispatcher.forward(request, response);
 
    }
 
    private void insertVaittamat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String otsikko = request.getParameter("otsikko");
        String vaite_teksti = request.getParameter("vaite_teksti");
        String luokka = request.getParameter("luokka");
 
        Vaittamat newVaittamat = new Vaittamat(otsikko, vaite_teksti, luokka);
        vaittamatDao.insertVaittamat(newVaittamat);
        response.sendRedirect("list");
    }
 
    private void updateVaittamat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String otsikko = request.getParameter("otsikko");
        String vaite_teksti = request.getParameter("vaite_teksti");
        String luokka = request.getParameter("luokka");
 
        Vaittamat vaittama = new Vaittamat(id, otsikko, vaite_teksti, luokka);
        vaittamatDao.updateVaittamat(vaittama);
        response.sendRedirect("list");
    }
 
    private void deleteVaittamat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Vaittamat vaittama = new Vaittamat(id);
        vaittamatDao.deleteVaittamat(vaittama);
        response.sendRedirect("list");
 
    }
}