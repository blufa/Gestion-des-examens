package sn.isi.dao;

import java.util.List;

import javax.ejb.Local;

import sn.isi.entities.Role;

@Local
public interface IRole {

	public int add(Role r);
	public int delete(int id);
	public int update(Role r);
	public Role getRole(int id);
	public List<Role> lister();
}
