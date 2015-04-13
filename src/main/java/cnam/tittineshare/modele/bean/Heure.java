package cnam.tittineshare.modele.bean;

public class Heure {
	private Integer heure;
	private Integer minute;
	
	
	public Heure(Integer heure, Integer minute) {
		super();
		this.heure = heure;
		this.minute = minute;		
	}
	
	public Integer getHeure() {
		return heure;
	}
	public void setHeure(Integer heure) {
		this.heure = heure;
	}
	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	
	
}
