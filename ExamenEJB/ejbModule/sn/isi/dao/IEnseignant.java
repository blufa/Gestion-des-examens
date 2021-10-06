package sn.isi.dao;

import java.util.List;

import javax.ejb.Local;

import sn.isi.entities.Enseignant;

@Local
public interface IEnseignant {

	public int add(Enseignant en);
	public int delete(int id);
	public int update(Enseignant en);
	public Enseignant getEnseignant(int id);
	public List<Enseignant> findAll();
}
