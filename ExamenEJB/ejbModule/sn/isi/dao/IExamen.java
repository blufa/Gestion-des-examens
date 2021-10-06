package sn.isi.dao;

import java.util.List;

import javax.ejb.Local;

import sn.isi.entities.Examen;

@Local
public interface IExamen {

	public int add(Examen ex);
	public int delete(int id);
	public int update(Examen ex);
	public Examen getExamen(int id);
	public List<Examen> findAll();
}
