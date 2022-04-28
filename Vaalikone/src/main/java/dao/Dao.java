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

}
