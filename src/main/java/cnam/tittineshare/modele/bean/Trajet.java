package cnam.tittineshare.modele.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAJET")
public class Trajet {
	
	private Integer id;
	private String villeDepart;
	private String villeArrivee;
	private Integer departMinute;
	private Integer departHeure;
	private Integer arriveeMinute;
	private Integer arriveeHeure;
	private String dateTrajet;
	private String vehicule;
	private String lieuDepart;
	private String lieuArrivee;
	private String description;
	private Integer nbPassagers;
	
	/**
	FAIRE LES GETTERS ET SETTERS
	*/
	@Id
    @GeneratedValue
    @Column(name = "ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	public Heure getHeureDepart() {
		return new Heure(departHeure,departMinute);
	}
	public void setHeureDepart(Heure heureDepart) {
		this.departHeure = heureDepart.getHeure();
		this.departMinute = heureDepart.getMinute();
	}
	public Heure getHeureArrivee() {
		return new Heure(arriveeHeure, arriveeMinute);
	}
	public void setHeureArrivee(Heure heureArrivee) {
		this.arriveeHeure = heureArrivee.getHeure();
		this.arriveeMinute = heureArrivee.getMinute();
	}
	public String getDateTrajet() {
		return dateTrajet;
	}
	public void setDateTrajet(String dateTrajet) {
		this.dateTrajet = dateTrajet;
	}
}