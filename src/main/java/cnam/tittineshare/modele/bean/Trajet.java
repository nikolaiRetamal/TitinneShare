package cnam.tittineshare.modele.bean;

public class Trajet {
	private Integer id;
	private String villeDepart;
	private String villeArrivee;
	private Heure heureDepart;
	private Heure heureArrivee;
	private String dateTrajet;
	
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
		return heureDepart;
	}
	public void setHeureDepart(Heure heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Heure getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Heure heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public String getDateTrajet() {
		return dateTrajet;
	}
	public void setDateTrajet(String dateTrajet) {
		this.dateTrajet = dateTrajet;
	}
}
