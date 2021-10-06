package sn.isi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.Role;

@Stateless
public class RoleImpl implements IRole {

	@PersistenceContext(unitName = "ExamenEJB")
	private EntityManager em;
	
	@Override
	public int add(Role r) {
		try {
			em.persist(r);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(Role.class, id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Role r) {
		try {
			em.merge(r);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Role getRole(int id) {
		
		return em.find(Role.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> lister() {
		try {
			return em.createQuery("select r from Role r").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
