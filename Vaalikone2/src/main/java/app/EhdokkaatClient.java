package app;

import java.io.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.*;

@WebServlet("/ehdokkaatclient")
public class EhdokkaatClient extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EhdokkaatClient() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        String deleteId=request.getParameter("deleteId");
       
        //Tulostetaan HTML-sivun alku ja lomake
        RequestDispatcher rd = request.getRequestDispatcher("./ehdokasform.html");
        rd.include(request,  response);

        boolean deleteOk = false;
        if (deleteId!=null) {
            if (deleteEhdokkaat(deleteId)) {
                out.println("Ehdokas on poistettu!<br>");
            }
        }
       
        String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/getall";

        Client asiakas = ClientBuilder.newClient();
        WebTarget wt = asiakas.target(uri);
        Builder b = wt.request();
       
        //Luodaan GenericType, jotta saadaan lista objekteista
        //post-metodin toinen parametri
        GenericType<List<Ehdokkaat>> genericList = new GenericType<List<Ehdokkaat>>() {};
       
        //Haetaan kaikki ehdokkaat
        List<Ehdokkaat> returnedList = b.get(genericList);
       
        //Tulostetaan ehdokkaat ja poisto-linkit
        out.println("<h1>Ehdokkaat</h1>");
        out.println("<table border=1>");
        out.println("<tr><th>Numero</th><th>Puolue</th><th>Etunimi</th><th>Sukunimi</th><th>Osoite</th><th>Postinumero</th><th>Kunta</th><th colspan=2 align=left>Miksi ehdokkaaksi</th><tr>"); 
        for (int i=0;i<returnedList.size();i++) {
            Ehdokkaat ehdokkaat = returnedList.get(i);
            out.println("<tr><td>"+ehdokkaat.getEhdokasnro()+"</td><td>"+ehdokkaat.getPuolue()+"</td><td>"+ehdokkaat.getEtunimi()+"</td><td>"+ehdokkaat.getSukunimi()+"</td><td>"+ehdokkaat.getLahiosoite()+"</td><td>"+ehdokkaat.getPostinumero()+"</td><td>"+ehdokkaat.getPostitoimipaikka()+"</td><td>"+ehdokkaat.getMiksi()+"</td><td>"+"<a href='./ehdokkaatclient?deleteId="+ehdokkaat.getId()+"'>Poista ehdokas</a></td></tr>");
        }
        
        out.println("</table>");  

        //Tulosteaan html-dokumentin loppu
        out.println("</body></html>");
    }

    private boolean deleteEhdokkaat(String deleteId) {
        String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/deleteehdokas/"+deleteId;

        Client asiakas = ClientBuilder.newClient();
        WebTarget wt = asiakas.target(uri);
        Builder b = wt.request();
       
        boolean ok = b.delete(Boolean.class);
        return ok;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/addehdokas";

        //Lähetettävä ehdokas-objekti
        String ehdokasnro = request.getParameter("ehdokasnro");
        String puolue = request.getParameter("puolue");
        String etunimi = request.getParameter("etunimi");
        String sukunimi = request.getParameter("sukunimi");
        String postinumero = request.getParameter("postinumero");
        String postitoimipaikka = request.getParameter("postitoimipaikka");
        String lahiosoite = request.getParameter("lahiosoite");
        String miksi = request.getParameter("miksi");
        
        Ehdokkaat ehdokkaat = new Ehdokkaat(ehdokasnro, puolue, etunimi, sukunimi, postinumero, postitoimipaikka, lahiosoite, miksi);
       
        Client c = ClientBuilder.newClient();
        WebTarget wt = c.target(uri);
        Builder b = wt.request();
        Entity<Ehdokkaat> e=Entity.entity(ehdokkaat,MediaType.APPLICATION_JSON);
       
        b.post(e);

        doGet(request, response);
    }

}