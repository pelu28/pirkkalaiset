package data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ehdokas {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nimi;
	private String sukunimi;
	private String lahiosoite;
	private String postinumero;
	private String postitoimipaikka;
	private String miksi;
	
	//bi-directional many-to-one association to Kid
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name="puolueid")
	private Puolue puolue;
	
	public Ehdokas() {
		
	}
	public Ehdokas(String nimi, String sukunimi, String lahiosoite, String postinumero, String postitoimipaikka, String miksi) {
		this.nimi=nimi;
		this.sukunimi=sukunimi;
		this.lahiosoite=lahiosoite;
		this.postinumero=postinumero;
		this.postitoimipaikka=postitoimipaikka;
		this.miksi=miksi;
	}
	public Ehdokas(String nimi, Puolue puolue) {
		this.nimi=nimi;
		this.puolue=puolue;
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
			//Do nothing
		}
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunnimi) {
		this.sukunimi = sukunimi;
	}
	
	public String getLahiosoite() {
		return lahiosoite;
	}
	public void setLahiosoite(String lahiosoite) {
		this.lahiosoite = lahiosoite;
	}
	
	public String getPostinumero() {
		return postinumero;
	}
	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}
	
	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}
	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}
	public String getMiksi() {
		return miksi;
	}
	public void setMiksi(String miksi) {
		this.miksi = miksi;
	}
	
	public Puolue getPuolue() {
		return this.puolue;
	}

	public void setPuolue(Puolue puolue) {
		this.puolue = puolue;
	}
	
	public String toString() {
		return id+": "+miksi+" / "+puolue.getNimi();
	}
}