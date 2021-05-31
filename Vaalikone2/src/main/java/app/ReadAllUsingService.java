package app;

import java.io.*;

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

import java.util.ArrayList;
import java.util.List;
import data.*;

@WebServlet("/readallusingservice")
public class ReadAllUsingService extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
		String uri = "http://127.0.0.1:8080/services/ehdokaslist/getpuolue";

		Client asiakas=ClientBuilder.newClient();
		WebTarget wt=asiakas.target(uri);
		Builder b=wt.request();
		
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Puolue>> genericList = new GenericType<List<Puolue>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Puolue> returnedList=b.get(genericList);
	    request.setAttribute("puoluelist", returnedList);
	    RequestDispatcher rd=request.getRequestDispatcher("readehdokas.jsp");
		rd.forward(request, response);
  }
}