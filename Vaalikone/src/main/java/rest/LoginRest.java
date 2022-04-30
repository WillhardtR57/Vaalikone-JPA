package rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import data.UserData;

@Path("/loginrest")
public class LoginRest {
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;

	String adminUsername;
	String adminPassword;
	String MD5Password;
	
	@GET
	@Path("/loginpage")
	public void goToLoginPage() throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
		 dispatcher.forward(request, response); 
	}
	
	@POST
	@Path("/login")
	@Consumes("application/x-www-form-urlencoded")
	public void login(@FormParam("username") String username, @FormParam("password") String password) throws ServletException, IOException{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Server-programming-jpa");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<UserData> list=em.createQuery("SELECT a FROM Admin a").getResultList();
		em.getTransaction().commit();
		
		
		for (UserData admin : list) {
			   adminUsername = admin.getUsername();
			   adminPassword = admin.getPassword();
			   System.out.println(adminUsername + ", " + adminPassword);
		
	         }
	
		request.setAttribute("userProvidedUsername", username);
		request.setAttribute("password", password); 
		request.setAttribute("username", adminUsername);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
		dispatcher.forward(request, response); 
	}
	
	
	
	
	
	
}
