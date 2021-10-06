package sn.isi.dao;

import java.util.List;

import javax.ejb.Local;

import sn.isi.entities.Dossier;

@Local
public interface IDossier {

	public int add(Dossier d);
	public int delete(int id);
	public int update(Dossier d);
	public Dossier getDossier(int id);
	public List<Dossier> findAll();
	public List<Dossier> findById(int id);
}
