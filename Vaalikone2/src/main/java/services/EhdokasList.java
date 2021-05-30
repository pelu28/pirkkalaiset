package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Puolue;

@Path("/ehdokaslist")
public class EhdokasList {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Vaalikone2");

	@GET
	@Path("/getpuolue")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Puolue> getPuolue(){
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    List<Puolue> list=em.createQuery("select a from Puolue a").getResultList();
	    em.getTransaction().commit();
		return list;
	}
}