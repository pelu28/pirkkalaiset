package app;

import java.io.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
import javax.ws.rs.core.Response;

import dao.EhdokkaatDao;
import data.Ehdokkaat;


/**
 * Servlet implementation class BookClient
 */
@WebServlet("/ehdokasclient")
public class EhdokasClient extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EhdokasClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       
        String deleteId=request.getParameter("deleteId");
       
        //Including an HTML form + start of the html page
        RequestDispatcher rd=request.getRequestDispatcher("ehdokkaat.jsp");
        rd.include(request,  response);

       
        boolean deleteOk=false;
        if (deleteId!=null) {
            if (deleteEhdokas(deleteId)) {
                out.println("Ehdokas has been removed!<br>");
            }
        }
       
        // TODO Auto-generated method stub
        String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/getall";

        Client asiakas=ClientBuilder.newClient();
        WebTarget wt=asiakas.target(uri);
        Builder b=wt.request();
       
       
        //Create a GenericType to be able to get List of objects
        //This will be the second parameter of post method
        GenericType<List<Ehdokkaat>> genericList = new GenericType<List<Ehdokkaat>>() {};
       
        //Getting all the Books
        List<Ehdokkaat> returnedList=b.get(genericList);
       
        //And print the objects
        for (int i=0;i<returnedList.size();i++) {
            Ehdokkaat ehdokkaat=returnedList.get(i);
            out.println(ehdokkaat+" <a href='./ehdokasclient?deleteId="+ehdokkaat.getId()+"'>Remove</a><br>");
        }
       
        //Printing the end of an html document
        out.println("</body></html>");
    }

    private boolean deleteEhdokas(String deleteId) {
        String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/deleteehdokas/"+deleteId;

        Client asiakas=ClientBuilder.newClient();
        WebTarget wt=asiakas.target(uri);
        Builder b=wt.request();
       
        boolean ok=b.delete(Boolean.class);
        return ok;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String uri = "http://127.0.0.1:8080/rest/ehdokaservice/addoneehdokas";

        //A Book object to send to our web-service
        String ehdokasnro=request.getParameter("ehdokasnro");
        String puolue=request.getParameter("puolue");
        String etunimi=request.getParameter("etunimi");
        String sukunimi=request.getParameter("sukunimi");
        String postinumero=request.getParameter("postinumero");
        String postitoimipaikka=request.getParameter("postitoimipaikka");
        String lahiosoite=request.getParameter("lahiosoite");
        String miksi=request.getParameter("miksi");
        Ehdokkaat ehdokkaat=new Ehdokkaat(ehdokasnro, puolue, etunimi, sukunimi, postinumero, postitoimipaikka, lahiosoite, miksi);
       
        Client c=ClientBuilder.newClient();
        WebTarget wt=c.target(uri);
        Builder b=wt.request();
        Entity<Ehdokkaat> e=Entity.entity(ehdokkaat,MediaType.APPLICATION_JSON);
       
        b.post(e);

       
        doGet(request, response);
    }

}