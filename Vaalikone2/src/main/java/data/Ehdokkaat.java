package data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ehdokkaat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ehdokasnro;
    private String puolue;
    private String etunimi;
    private String sukunimi;
    private int postinumero;
    private String postitoimipaikka;
    private String lahiosoite;
    private String miksi;
    
    public Ehdokkaat() {
    }

   public Ehdokkaat(int ehdokasnro, String puolue, String etunimi, String sukunimi, int postinumero, String postitoimipaikka, String
   lahiosoite, String miksi){
	   this.setEhdokasnro(ehdokasnro);
	   this.setPuolue(puolue);
	   this.setEtunimi(etunimi);
	   this.setSukunimi(sukunimi);
	   this.setPostinumero(postinumero);
	   this.setPostitoimipaikka(postitoimipaikka);
	   this.setLahiosoite(lahiosoite);
	   this.setMiksi(miksi);
   }
   
   public Ehdokkaat(int id, int ehdokasnro, String puolue, String etunimi, String sukunimi, int postinumero, String postitoimipaikka, String
		   lahiosoite, String miksi){
	   	this.id=id;
		this.setEhdokasnro(ehdokasnro);
		this.setPuolue(puolue);
	    this.setEtunimi(etunimi);
		this.setSukunimi(sukunimi);
		this.setPostinumero(postinumero);
		this.setPostitoimipaikka(postitoimipaikka);
		this.setLahiosoite(lahiosoite);
		this.setMiksi(miksi);
   }
   
   public Ehdokkaat(String ehdokasnro, String puolue, String etunimi, String sukunimi, String postinumero, String postitoimipaikka, String
		   lahiosoite, String miksi){
			   this.setEhdokasnro(ehdokasnro);
			   this.setPuolue(puolue);
			   this.setEtunimi(etunimi);
			   this.setSukunimi(sukunimi);
			   this.setPostinumero(postinumero);
			   this.setPostitoimipaikka(postitoimipaikka);
			   this.setLahiosoite(lahiosoite);
			   this.setMiksi(miksi);	   
   }
   
   public Ehdokkaat(String id, String ehdokasnro, String puolue, String etunimi, String sukunimi, String postinumero, String postitoimipaikka, String
		   lahiosoite, String miksi){
	   		   this.setId(id);
			   this.setEhdokasnro(ehdokasnro);
			   this.setPuolue(puolue);
			   this.setEtunimi(etunimi);
			   this.setSukunimi(sukunimi);
			   this.setPostinumero(postinumero);
			   this.setPostitoimipaikka(postitoimipaikka);
			   this.setLahiosoite(lahiosoite);
			   this.setMiksi(miksi);
   }
   
   public int getId() {
		return id;
   }
   
   public void setId(int id) {
		this.id = id;
   }
   
   public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
   }

   public int getEhdokasnro() {
		return ehdokasnro;
   }

   public void setEhdokasnro(int ehdokasnro) {
		this.ehdokasnro = ehdokasnro;
   }
	
   public void setEhdokasnro(String ehdokasnro) {
		try {
			this.ehdokasnro = Integer.parseInt(ehdokasnro);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
   }

   public String getPuolue() {
		return puolue;
   }

   public void setPuolue(String puolue) {
		this.puolue = puolue;
   }

   public String getEtunimi() {
		return etunimi;
   }

   public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
   }

   public String getSukunimi() {
		return sukunimi;
   }

   public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
   }

   public int getPostinumero() {
		return postinumero;
   }

   public void setPostinumero(String postinumero) {
		try {
			this.postinumero = Integer.parseInt(postinumero);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value is not changed
		}
   }

   public void setPostinumero(int postinumero) {
		this.postinumero = postinumero;
   }

   public String getPostitoimipaikka() {
		return postitoimipaikka;
   }

   public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
   }

   public String getLahiosoite() {
		return lahiosoite;
   }

   public void setLahiosoite(String lahiosoite) {
		this.lahiosoite = lahiosoite;
   }

   public String getMiksi() {
		return miksi;
   }

   public void setMiksi(String miksi) {
		this.miksi = miksi;
   }
	
   public String toString() {
		return this.ehdokasnro+" "+this.puolue+" "+this.etunimi+" "+this.sukunimi+" "+this.lahiosoite+" "+this.postinumero+" "+this.postitoimipaikka+ " "+this.miksi;
   }
}