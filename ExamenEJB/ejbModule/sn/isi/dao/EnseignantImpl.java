package sn.isi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.Enseignant;

@Stateless
public class EnseignantImpl implements IEnseignant {

	@PersistenceContext(unitName = "ExamenEJB")
	private EntityManager em;
	
	@Override
	public int add(Enseignant en) {
		try {
			em.persist(en);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Enseignant.class, id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Enseignant en) {
		try {
			em.merge(en);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enseignant> findAll() {
		try {
			return em.createQuery("select en from Enseignant en").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Enseignant getEnseignant(int id) {
		
		return em.find(Enseignant.class, id);
	}

}
