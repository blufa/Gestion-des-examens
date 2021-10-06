package sn.isi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.Examen;

@Stateless
public class ExamenImpl implements IExamen {

	@PersistenceContext(unitName = "ExamenEJB")
	private EntityManager em;
	
	@Override
	public int add(Examen ex) {
		try {
			em.persist(ex);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Examen.class, id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Examen ex) {
		try {
			em.merge(ex);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Examen getExamen(int id) {

		return em.find(Examen.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Examen> findAll() {
		try {
			return em.createQuery("select ex from Examen ex").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
