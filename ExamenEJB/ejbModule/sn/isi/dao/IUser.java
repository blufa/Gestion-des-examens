package sn.isi.dao;

import java.util.List;

import javax.ejb.Local;

import sn.isi.entities.User;

@Local
public interface IUser {

	public int add(User u);
	public int delete(int id);
	public int update(User u);
	public User getUser(int id);
	public List<User> lister();
	public User logon(String email, String password);
}
