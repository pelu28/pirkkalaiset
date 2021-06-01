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
@WebServlet("/ehdokastesti")
public class EhdokasTesti extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EhdokasTesti() {
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
       

       
        //Including an HTML form + start of the html page
        RequestDispatcher rd=request.getRequestDispatcher("./readehdokas.jsp");
        rd.include(request,  response);
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
            out.println(ehdokkaat);
        }
    }
}