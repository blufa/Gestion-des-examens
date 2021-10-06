package sn.isi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.Epreuve;

@Stateless
public class EpreuveImpl implements IEpreuve {

	@PersistenceContext(unitName = "ExamenEJB")
	private EntityManager em;
	
	@Override
	public int add(Epreuve ep) {
		try {
			em.persist(ep);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Epreuve.class, id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Epreuve ep) {
		try {
			em.merge(ep);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Epreuve getEpreuve(int id) {
		
		return em.find(Epreuve.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Epreuve> findAll() {
		try {
			return em.createQuery("select ep from Epreuve ep").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
