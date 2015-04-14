package cnam.tittineshare.modele.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.websocket.ClientEndpoint;

@Entity
@Table(name = "TRAJET")
public class Trajet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
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
	GETTERS ET SETTERS
	*/
	@Id
    @GeneratedValue
    @Column(name = "TRAJET_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/** ** ** **  */
	@Column(name="VILLE_DEPART")
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	/** ** ** **  */
	@Column(name="VILLE_ARRIVEE")
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	
	/** ** ** **  */
	@Column(name="DATE_TRAJET")
	public String getDateTrajet() {
		return dateTrajet;
	}
	public void setDateTrajet(String dateTrajet) {
		this.dateTrajet = dateTrajet;
	}
	/** ** ** **  */
	@Column(name="DEPART_MINUTE")
	public Integer getDepartMinute() {
		return departMinute;
	}
	public void setDepartMinute(Integer departMinute) {
		this.departMinute = departMinute;
	}
	/** ** ** **  */
	@Column(name="DEPART_HEURE")
	public Integer getDepartHeure() {
		return departHeure;
	}
	public void setDepartHeure(Integer departHeure) {
		this.departHeure = departHeure;
	}
	/** ** ** **  */
	@Column(name="ARRIVEE_MINUTE")
	public Integer getArriveeMinute() {
		return arriveeMinute;
	}
	public void setArriveeMinute(Integer arriveeMinute) {
		this.arriveeMinute = arriveeMinute;
	}
	/** ** ** **  */
	@Column(name="ARRIVEE_HEURE")
	public Integer getArriveeHeure() {
		return arriveeHeure;
	}
	public void setArriveeHeure(Integer arriveeHeure) {
		this.arriveeHeure = arriveeHeure;
	}
	/** ** ** **  */
	@Column(name="VEHICULE")
	public String getVehicule() {
		return vehicule;
	}
	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}
	/** ** ** **  */
	@Column(name="LIEU_DEPART")
	public String getLieuDepart() {
		return lieuDepart;
	}
	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}
	/** ** ** **  */
	@Column(name="LIEU_ARRIVEE")
	public String getLieuArrivee() {
		return lieuArrivee;
	}
	public void setLieuArrivee(String lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}
	/** ** ** **  */
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/** ** ** **  */
	@Column(name="NB_PASSAGERS")
	public Integer getNbPassagers() {
		return nbPassagers;
	}
	public void setNbPassagers(Integer nbPassagers) {
		this.nbPassagers = nbPassagers;
	}
	
	/** ** ** **  */
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
	
}