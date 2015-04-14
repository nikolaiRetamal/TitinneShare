package cnam.tittineshare.modele.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAJET")
public class Trajet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name = "TRAJET_ID")
	private Integer id;
	@Column(name="VILLE_DEPART")
	private String villeDepart;
	@Column(name="VILLE_ARRIVEE")
	private String villeArrivee;
	@Column(name="DEPART_MINUTE")
	private Integer departMinute;
	@Column(name="DEPART_HEURE")
	private Integer departHeure;
	@Column(name="ARRIVEE_MINUTE")
	private Integer arriveeMinute;
	@Column(name="ARRIVEE_HEURE")
	private Integer arriveeHeure;
	@Column(name="DATE_TRAJET")
	private String dateTrajet;
	@Column(name="VEHICULE")
	private String vehicule;
	@Column(name="LIEU_DEPART")
	private String lieuDepart;
	@Column(name="LIEU_ARRIVEE")
	private String lieuArrivee;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="NB_PASSAGERS")
	private Integer nbPassagers;
	
	/**
	GETTERS ET SETTERS
	*/

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/** ** ** **  */
	
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	/** ** ** **  */
	
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	
	/** ** ** **  */
	
	public String getDateTrajet() {
		return dateTrajet;
	}
	public void setDateTrajet(String dateTrajet) {
		this.dateTrajet = dateTrajet;
	}
	/** ** ** **  */
	
	public Integer getDepartMinute() {
		return departMinute;
	}
	public void setDepartMinute(Integer departMinute) {
		this.departMinute = departMinute;
	}
	/** ** ** **  */
	
	public Integer getDepartHeure() {
		return departHeure;
	}
	public void setDepartHeure(Integer departHeure) {
		this.departHeure = departHeure;
	}
	/** ** ** **  */
	public Integer getArriveeMinute() {
		return arriveeMinute;
	}
	public void setArriveeMinute(Integer arriveeMinute) {
		this.arriveeMinute = arriveeMinute;
	}
	/** ** ** **  */

	public Integer getArriveeHeure() {
		return arriveeHeure;
	}
	public void setArriveeHeure(Integer arriveeHeure) {
		this.arriveeHeure = arriveeHeure;
	}
	/** ** ** **  */

	public String getVehicule() {
		return vehicule;
	}
	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}
	/** ** ** **  */

	public String getLieuDepart() {
		return lieuDepart;
	}
	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}
	/** ** ** **  */
	public String getLieuArrivee() {
		return lieuArrivee;
	}
	public void setLieuArrivee(String lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}
	/** ** ** **  */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/** ** ** **  */

	public Integer getNbPassagers() {
		return nbPassagers;
	}
	public void setNbPassagers(Integer nbPassagers) {
		this.nbPassagers = nbPassagers;
	}
	
}