package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static java.lang.System.out;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

@WebServlet(
		name = "RemoveEhdokas",
		urlPatterns = {"/removeEhdokas"}
 )	


public class RemoveEhdokas extends HttpServlet {
	private Dao dao;
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "root");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		String id=request.getParameter("id");
		ArrayList<Ehdokkaat> list=null;
		if (dao.getConnection()) {
			list=dao.removeEhdokas(id);
			System.out.println("connected");
			System.out.println(list);
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("ehdokkaatlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("ehdokkaattesti.jsp");
		rd.forward(request,  response);
		}
	}

