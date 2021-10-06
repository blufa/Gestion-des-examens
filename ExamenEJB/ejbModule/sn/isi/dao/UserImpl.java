package sn.isi.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.User;

@Stateless
public class UserImpl implements IUser {

	@PersistenceContext(unitName = "ExamenEJB")
	private EntityManager em;
	
	@Override
	public int add(User u) {
		try {
			em.persist(u);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			em.remove(em.find(User.class, id));
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(User u) {
		try {
			em.merge(u);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User getUser(int id) {
		
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> lister() {
		try {
			return em.createQuery("select u from User u").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User logon(String email, String password) {
		try {
			return (User)em.
					createQuery("SELECT u FROM User u WHERE u.email =:em AND u.password =:pass")
					.setParameter("em", email)
					.setParameter("pass", password)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
