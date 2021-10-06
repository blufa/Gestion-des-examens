package sn.isi.dao;

import java.util.List;

import javax.ejb.Local;

import sn.isi.entities.Etablissement;

@Local
public interface IEtablissement {

	public int add(Etablissement et);
	public int delete(int id);
	public int update(Etablissement et);
	public Etablissement getEtablissement(int id);
	public List<Etablissement> findAll();
}
