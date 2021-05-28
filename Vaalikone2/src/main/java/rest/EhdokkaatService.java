package rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Ehdokkaat;

@Path("/ehdokkaatservice")
public class EhdokkaatService {
//Reading all the rows from table prey.
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ehdokkaat> readAllEhdokkaat() {
	//Create an EntityManagerFactory with the settings from persistence.xml file
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Vaalikone2");
		//And then EntityManager, which can manage the entities.
		EntityManager em=emf.createEntityManager();
		
		//Read all the rows from table prey. Here the Prey must start with capital, 
		//because class's name starts. This returns a List of Prey objects.
		List<Ehdokkaat> list=em.createQuery("select a from Ehdokkaat a").getResultList();
		return list;
	}
	
//Adding one prey object into the table prey	
	@POST
	@Path("/addehdokas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Ehdokkaat postEhdokkaat(Ehdokkaat ehdokkaat) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Vaalikone2");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ehdokkaat);//The actual insertion line
		em.getTransaction().commit();
		return ehdokkaat;
	}

//This method uses FormParams, but does the same as previous	
	@POST
	@Path("/addehdokas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Ehdokkaat postEhdokkaatByParams(@FormParam("ehdokasnro") int ehdokasnro, @FormParam("puolue") String puolue, @FormParam("etunimi") String etunimi, @FormParam("sukunimi") String sukunimi, @FormParam("postinumero") int postinumero, @FormParam("postitoimipaikka") String postitoimipaikka, @FormParam("lahiosoite") String lahiosoite, @FormParam("miksi") String miksi) {
		Ehdokkaat ehdokkaat=new Ehdokkaat(ehdokasnro, puolue, etunimi, sukunimi, postinumero, postitoimipaikka, lahiosoite, miksi);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Vaalikone2");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ehdokkaat);
		em.getTransaction().commit();
		return ehdokkaat;
	}
}