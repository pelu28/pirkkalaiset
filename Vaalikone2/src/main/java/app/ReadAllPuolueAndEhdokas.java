package app;

import java.io.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import data.*;

@WebServlet("/readallpuolueandfish")
public class ReadAllPuolueAndEhdokas extends HttpServlet {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Vaalikone2");
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    List<Puolue> list=em.createQuery("select a from Puolue a").getResultList();
	    em.getTransaction().commit();
	    request.setAttribute("puoluelist", list);
	    RequestDispatcher rd=request.getRequestDispatcher("./readehdokas.jsp");
		rd.forward(request, response);
  }
}
