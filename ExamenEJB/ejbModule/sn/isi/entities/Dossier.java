package sn.isi.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Dossier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100)
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date datenaissance;
	@ManyToOne
	private Examen examen = new Examen();
	@ManyToOne
	private Etablissement etablissement = new Etablissement();
	
	
	public Dossier() {
		super();
	}

	
	public Dossier(int id, String nom, Date datenaissance, Examen examen, Etablissement etablissement) {
		super();
		this.id = id;
		this.nom = nom;
		this.datenaissance = datenaissance;
		this.examen = examen;
		this.etablissement = etablissement;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}


	public Etablissement getEtablissement() {
		return etablissement;
	}


	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Date getDatenaissance() {
		return datenaissance;
	}


	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	
}
