package cnam.tittineshare.modele.dao;

import java.util.List;

import cnam.tittineshare.modele.bean.Trajet;

public interface TrajetDAO {	 
	   
	    
	    public List<Trajet> list();
	    public void saveOrUpdate(Trajet trajet);
	    public void delete(int id) ;
	    public Trajet get(int id) ;
	    public List<Trajet> getByUtilisateur(int utilisateurId);
	    
}
