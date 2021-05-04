package data;

public class Vastausvaihtoehdot {
    protected int nro;
    protected String teksti;

 
    public Vastausvaihtoehdot() {
    }
 
    public Vastausvaihtoehdot(int nro) {
        this.nro = nro;
    }
 
    public Vastausvaihtoehdot(int nro, String teksti) {
        this.teksti = teksti;
        this.nro = nro;
    }
    
    public Vastausvaihtoehdot(String teksti) {
        this.teksti = teksti;
    }
     
    public int getNro() {
        return nro;
    }
 
    public void setNro(int nro) {
        this.nro = nro;
    }
 
    public String getTeksti() {
        return teksti;
    }
 
    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }
 
}
