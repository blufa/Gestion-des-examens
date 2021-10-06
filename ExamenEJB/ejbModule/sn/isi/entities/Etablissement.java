package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Etablissement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100)
	private String code;
	@Column(length = 100)
	private String nom;
	@Column(length = 100)
	private String adresse;
	@Column(length = 100)
	private String ville;
	@OneToMany(mappedBy = "etablissement", fetch = FetchType.EAGER)
	private List<Dossier> dossiers = new ArrayList<Dossier>();


	
	
	public Etablissement() {
		super();
	}

	public Etablissement(int id, String code, String nom, String adresse, String ville) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	public List<Dossier> getDossiers() {
		return dossiers;
	}

	public void setDossiers(List<Dossier> dossiers) {
		this.dossiers = dossiers;
	}
	
	
}
