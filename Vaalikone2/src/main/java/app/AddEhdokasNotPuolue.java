package app;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Ehdokas;
import data.Puolue;

@WebServlet("/addehdokasnotpuolue")
public class AddEhdokasNotPuolue extends HttpServlet {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Vaalikone2");
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  Ehdokas ehdokas=new Ehdokas("Simo","Suomi","kujalla","33960","Pirkkala","en osaa sanoa");
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(ehdokas);
	    em.getTransaction().commit();
  }
}
