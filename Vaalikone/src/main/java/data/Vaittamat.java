package data;

public class Vaittamat {
    protected int id;
    protected String otsikko;
    protected String vaite_teksti;
    protected String luokka;
 
    public Vaittamat() {
    }
 
    public Vaittamat(int id) {
        this.id = id;
    }
 
    public Vaittamat(int id, String otsikko, String vaite_teksti, String luokka) {
        this(otsikko, vaite_teksti, luokka);
        this.id = id;
    }
     
    public Vaittamat(String otsikko, String vaite_teksti, String luokka) {
        this.otsikko = otsikko;
        this.vaite_teksti = vaite_teksti;
        this.luokka = luokka;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getOtsikko() {
        return otsikko;
    }
 
    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }
 
    public String getVaite() {
        return vaite_teksti;
    }
 
    public void setVaite(String vaite_teksti) {
        this.vaite_teksti = vaite_teksti;
    }
 
    public String getLuokka() {
        return luokka;
    }
 
    public void setLuokka(String luokka) {
        this.luokka = luokka;
    }
}
