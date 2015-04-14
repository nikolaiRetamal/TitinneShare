package cnam.tittineshare.modele.dao;

import java.util.List;

import cnam.tittineshare.modele.bean.Utilisateur;

public interface UtilisateurDAO {
	
	 	public List<Utilisateur> list() ;
	    public void saveOrUpdate(Utilisateur user) ;
	    public void delete(int id);
	    public Utilisateur get(int id) ;

}
