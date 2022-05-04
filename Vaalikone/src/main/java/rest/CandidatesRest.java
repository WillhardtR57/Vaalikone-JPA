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
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	public void addCandidate(@FormParam("sukunimi")String sukunimi, @FormParam("etunimi")String etunimi, 
			@FormParam("puolue")String puolue, @FormParam("kotipaikkakunta")String kotipaikkakunta, @FormParam("ika")String ika,
			@FormParam("miksi_eduskuntaan")String miksi_eduskuntaan, @FormParam("mita_asioita_haluat_edistaa")String mita_asioita_haluat_edistaa,
			@FormParam("ammatti")String ammatti) {
		Candidates c = new Candidates();
		c.setSukunimi(sukunimi);
		c.setEtunimi(etunimi);
		c.setPuolue(puolue);
		c.setKotipaikkakunta(kotipaikkakunta);
		c.setIka(ika);
		c.setMiksiEduskuntaan(miksi_eduskuntaan);
		c.setMitaAsioitaHaluatEdistaa(mita_asioita_haluat_edistaa);
		c.setAmmatti(ammatti);
		Dao dao = new Dao();
		String list = dao.addCandidate(c);		
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/editcandidates")
	@Produces(MediaType.APPLICATION_JSON)
	public void editCandidates(@FormParam("ehdokas_id")String ehdokas_id, @FormParam("sukunimi")String sukunimi, @FormParam("etunimi")String etunimi, 
			@FormParam("puolue")String puolue, @FormParam("kotipaikkakunta")String kotipaikkakunta, @FormParam("ika")String ika,
			@FormParam("miksi_eduskuntaan")String miksi_eduskuntaan, @FormParam("mita_asioita_haluat_edistaa")String mita_asioita_haluat_edistaa,
			@FormParam("ammatti")String ammatti) {
		List<Candidates> list = new ArrayList<Candidates>();
		Dao dao = new Dao();
		Candidates c = new Candidates(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa,
				ammatti);
		list = dao.editCandidates(c);
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candidatepicker.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/deletecandidate/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCandidate(@PathParam("id")int id) {
		Dao dao = new Dao();
		String list = dao.deleteCandidate(id);
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/rest/candidatesrest/candidatepicker");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/getcandidateid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getCandidateId(@PathParam("id")int id) {
		Candidates list = new Candidates();
		Dao dao = new Dao();
		list = dao.getCandidateId(id);
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editcandidate.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
