package sn.isi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.Etablissement;

@Stateless
public class EtablissementImpl implements IEtablissement {

	@PersistenceContext(unitName = "ExamenEJB")
	private EntityManager em;
	
	@Override
	public int add(Etablissement et) {
		try {
			em.persist(et);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Etablissement.class, id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Etablissement et) {
		try {
			em.merge(et);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Etablissement getEtablissement(int id) {
	
		return em.find(Etablissement.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etablissement> findAll() {
		try {
			return em.createQuery("select et from Etablissement et").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
