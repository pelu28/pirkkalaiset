package app;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.*;

@WebServlet("/addpuolueandehdokas")
public class AddPuolueAndEhdokas extends HttpServlet {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Vaalikone2");
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  Puolue puolue=new Puolue("muurarit");
	    Ehdokas f1=new Ehdokas("Martti", "Vainaa","kuja 3", "3350", "Pirkkala", "tahdon");
	    puolue.addEhdokas(f1);
	    Ehdokas f2=new Ehdokas("Sami", "Samson","katu 45", "33456", "Takala", "haluan");
	    puolue.addEhdokas(f2);
	   
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(puolue);
	    em.getTransaction().commit();
  }
}
