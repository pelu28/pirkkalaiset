package app;

import java.io.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.*;

/**
 * Servlet implementation class AddOneFishbreed
 */
@WebServlet("/ReadEhdokkaat")
public class ReadEhdokkaat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadEhdokkaat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Vaalikone2");
		EntityManager em=emf.createEntityManager();
		
		out.println("<h2>Read all the Fishbreeds</h2>");
		em.getTransaction().begin();
		List<Ehdokkaat> list=em.createQuery("select f from Ehdokkaat f").getResultList();
		em.getTransaction().commit();
		out.println("<ol>");
		for (Ehdokkaat ehdokkaat:list) {
			out.println("<li>Ehdokkaat: "+ehdokkaat);
			
			
			}
			
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
