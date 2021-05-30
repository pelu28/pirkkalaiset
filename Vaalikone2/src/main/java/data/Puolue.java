package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Puolue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nimi;

	//bi-directional many-to-one association to Fish
	@OneToMany(mappedBy="puolue", cascade = CascadeType.PERSIST)
	private List<Ehdokas> ehdokaslist;
	
	public Puolue() {
		
	}
	public Puolue(String nimi) {
		this.nimi=nimi;
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

	public List<Ehdokas> getEhdokaslist() {
		if (this.ehdokaslist==null) {
			ehdokaslist=new ArrayList<>();
		}
		return this.ehdokaslist;
	}

	public void setEhdokaslist(List<Ehdokas> ehdokaslist) {
		this.ehdokaslist = ehdokaslist;
	}

	public Ehdokas addEhdokas(Ehdokas ehdokas) {
		getEhdokaslist().add(ehdokas);
		ehdokas.setPuolue(this);

		return ehdokas;
	}

	public Ehdokas removeEhdokas(Ehdokas ehdokas) {
		getEhdokaslist().remove(ehdokas);
		ehdokas.setPuolue(null);
		return ehdokas;
	}
	
	
	public String toString() {
		return id+": "+nimi+" / ";
	}
}