package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import data.Candidates;

public class Dao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone-jpa");
	
	public List<Candidates> readCandidates() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Candidates> list = em.createQuery("select a from ehdokkaat a").getResultList();
		em.getTransaction().commit();
		return list;
	}
	
	public String addCandidate(Candidates c) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return null;
	}
	
	public List<Candidates> editCandidates(Candidates candidate) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Candidates c = em.find(Candidates.class, candidate.getEhdokas_id());
		if (c!=null) {
			em.merge(candidate);
		}
		em.getTransaction().commit();
		List<Candidates> list = readCandidates();
		em.close();
		return null;
	}
	
	public String deleteCandidate(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("delete from ehdokkaat where ehdokas_id="+id).executeUpdate();
		Object candidate = em.createQuery("select c from ehdokkaat c where c.ehdokas_id=?1").setParameter(1, id).getSingleResult();
		em.remove(candidate);
		em.getTransaction().commit();
		return null;
	}

}
