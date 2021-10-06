package sn.isi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.Dossier;

@Stateless
public class DossierImpl implements IDossier {

	@PersistenceContext(unitName = "ExamenEJB")
	private EntityManager em;
	
	
	@Override
	public int add(Dossier d) {
		try {
			em.persist(d);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Dossier.class, id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Dossier d) {
		try {
			em.merge(d);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Dossier getDossier(int id) {
		
		return em.find(Dossier.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dossier> findAll() {
		try {
			return em.createQuery("select d from Dossier d").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dossier> findById(int id) {
		try {
			String query ="select doss from Dossier doss join doss.etablissement eta where eta.id=:id";
			return em.createQuery(query).setParameter("id", id).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
