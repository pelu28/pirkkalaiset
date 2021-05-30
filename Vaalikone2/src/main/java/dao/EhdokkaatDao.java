package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import data.Ehdokkaat;

public class EhdokkaatDao {
    private static EntityManagerFactory emf;
    private static EntityManager getEntityManager() {
        if (emf==null) {
            emf=Persistence.createEntityManagerFactory("rest-t8-ehdokkaatservice-jpa");
        }
        return emf.createEntityManager();
    }
   
    public static void addEhdokas(Ehdokkaat ehdokkaat) {
        EntityManager em=getEntityManager();
        em.getTransaction().begin();
        em.persist(ehdokkaat);
        em.getTransaction().commit();
        em.close();
    }
   
    public static List<Ehdokkaat> getEhdokkaat(){
        EntityManager em=getEntityManager();
        List<Ehdokkaat> list=em.createQuery("select a from Ehdokkaat a").getResultList();
        em.close();
        return list;
    }

    public static boolean deleteEhdokkaat(int id) {
        EntityManager em=getEntityManager();
        Ehdokkaat b=em.find(Ehdokkaat.class, id);
        if (b!=null) {
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        return false;
    }
    public void updateEhdokkaat(Ehdokkaat ehdokkaat) {
       
    }
}