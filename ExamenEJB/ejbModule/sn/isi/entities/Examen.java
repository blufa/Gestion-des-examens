package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Examen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100)
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date dateexamen;
	@OneToMany(mappedBy = "examen")
	private List<Epreuve> epreuves = new ArrayList<Epreuve>();
	@OneToMany(mappedBy = "examen")
	private List<Enseignant> enseignants = new ArrayList<Enseignant>();
	@OneToMany(mappedBy = "examen")
	private List<Dossier> dossiers = new ArrayList<Dossier>();
	
	public Examen() {
		super();
	}

	public Examen(int id, String nom, Date dateexamen, List<Epreuve> epreuves) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateexamen = dateexamen;
		this.epreuves = epreuves;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateexamen() {
		return dateexamen;
	}

	public void setDateexamen(Date dateexamen) {
		this.dateexamen = dateexamen;
	}

	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}

	public List<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	
}
