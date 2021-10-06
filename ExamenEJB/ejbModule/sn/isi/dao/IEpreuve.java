package sn.isi.dao;

import java.util.List;

import javax.ejb.Local;

import sn.isi.entities.Epreuve;

@Local
public interface IEpreuve {

	public int add(Epreuve ep);
	public int delete(int id);
	public int update(Epreuve ep);
	public Epreuve getEpreuve(int id);
	public List<Epreuve> findAll();
}
