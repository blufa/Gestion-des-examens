package sn.isi.entities;




import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Enseignant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100)
	private String matricule;
	@Column(length = 100)
	private String nom;
	@Column(length = 100)
	private String telephone;
	@Column(length = 100)
	private String adresse;
	@Column(length = 100)
	private String ville;
	@ManyToOne
	private Examen examen = new Examen();
	
	public Enseignant() {
		super();
	}

	public Enseignant(int id, String matricule, String nom, String telephone, String adresse, String ville,
			Examen examen) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.ville = ville;
		this.examen = examen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	
	
}
