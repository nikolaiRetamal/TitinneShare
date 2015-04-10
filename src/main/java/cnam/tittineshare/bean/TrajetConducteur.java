package cnam.tittineshare.bean;

public class TrajetConducteur extends Trajet{

	private String vehicule;
	private String lieuDepart;
	private String lieuArrivee;
	private String description;
	private Integer nbPassagers;
	
	public String getVehicule() {
		return vehicule;
	}
	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}
	public String getLieuDepart() {
		return lieuDepart;
	}
	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}
	public String getLieuArrivee() {
		return lieuArrivee;
	}
	public void setLieuArrivee(String lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNbPassagers() {
		return nbPassagers;
	}
	public void setNbPassagers(Integer nbPassagers) {
		this.nbPassagers = nbPassagers;
	}
}
