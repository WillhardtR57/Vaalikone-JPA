package rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dao.Dao;
import data.*;

@Path("/candidatesrest")
public class CandidatesRest {
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;

	@GET
	@Path("/readcandidates")
	@Produces(MediaType.APPLICATION_JSON)
	public void readCandidates() {
		List<Candidates> list = new ArrayList<Candidates>();
		Dao dao = new Dao();
		list = dao.readCandidates();
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/listcandidates.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/candidatepicker")
	@Produces(MediaType.APPLICATION_JSON)
	public void readPicker() {
		List<Candidates> list = new ArrayList<Candidates>();
		Dao dao = new Dao();
		list = dao.readCandidates();
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candidatepicker.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/addcandidate")
	@Produces(MediaType.APPLICATION_JSON)
	public void addCandidate() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
