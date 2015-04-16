package cnam.tittineshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cnam.tittineshare.modele.bean.Trajet;
import cnam.tittineshare.modele.bean.Utilisateur;
import cnam.tittineshare.modele.dao.TrajetDAO;
import cnam.tittineshare.modele.dao.UtilisateurDAO;

@Controller
public class ControllerTittineShare {
	
	@Autowired
    private UtilisateurDAO utilisateurDao;
	@Autowired
    private TrajetDAO trajetDao;
	
	private static final String UTILISATEUR_SESSION = "utilisateur";

	/**
	 * 
	 * Servlet d'accueil, renvoie vers le menu de choix
	 * Oriente l'utilisateur vers "créer trajet" ou "modifier trajet"
	 * 
	 * @return
	 */
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public ModelAndView accueil(){
		ModelAndView model = new ModelAndView("accueil");
		model.addObject("titrePage", "accueil");
		return model;
	}
	
	/**
	 * 
	 * Servlet d'accès à la page d'identification
	 * Si l'on est "redirigé" sur cette servlet, celle-ci recycle le message transmis.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView identification(HttpServletRequest request){
		ModelAndView model = new ModelAndView("identification");
		model.addObject("titrePage", "identification");
		model.addObject("message", request.getParameter("message"));
		return model;
	}
	
	/**
	 * 
	 * Servlet d'accès à la page de configuration d'un trajet
	 * Bouton "Créer trajet"
	 * Renvoie la liste des trajets de l'utilisateur connecté
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/trajets", method = RequestMethod.GET)
    public ModelAndView trajets(HttpServletRequest request) {
		Utilisateur utilisateur = getUtilisateur(request);
        List<Trajet> trajets = trajetDao.getByUtilisateur(utilisateur.getId());
        ModelAndView model = new ModelAndView("trajets");
        model.addObject("trajets", trajets);
        return model;
    }
	
	/**
	 * 
	 * Servlet d'accès à la page de modification d'un trajet
	 * Bouton "Modifier trajet"
	 * Renvoie vers le formulaire de création/modification 
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifier", method = RequestMethod.GET)
    public ModelAndView editTrajet(@RequestParam("id") String id) {
        Trajet trajet = trajetDao.get(Integer.parseInt(id));
        ModelAndView model = new ModelAndView("creerTrajet");
        model.addObject("trajet", trajet);
        return model;      
    }
	
	/**
	 * 
	 * Servlet de suppression d'un trajet, sur la page de configuration d'un trajet
	 * Renvoie à la liste de choix des trajets existants
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteTrajet(HttpServletRequest request) {
        int trajetId = Integer.parseInt(request.getParameter("id"));
        trajetDao.delete(trajetId);
        return new ModelAndView("redirect:/trajets");     
    }
	
	/**
	 * 
	 * Servlet de sauvegarde d'un trajet
	 * Appellée lors de la validation des formulaires de création
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createTrajet(HttpServletRequest request) {
        return new ModelAndView("creerTrajet");     
    }
	
	/**
	 * 
	 * Servlet de sauvegarde d'un trajet
	 * Appellée lors de la validation du formulaire de modification
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute Trajet trajet, HttpServletRequest request) {
		Utilisateur utilisateur = getUtilisateur(request);
		trajet.setUtilisateurId(utilisateur.getId());
        trajetDao.saveOrUpdate(trajet);
        ModelAndView model = new ModelAndView("detailTrajet");
        model.addObject("trajet", trajet);
        if(trajet.getTypeTrajet().equals(0)){
        	model.addObject("typeTrajet", "Conducteur");
        }else{
        	model.addObject("typeTrajet", "Passager");
        }
        return model;
    } 
	
	@RequestMapping(value = "/detailTrajet", method = RequestMethod.GET)
    public ModelAndView detailTrajet(@RequestParam("id") String id) {
		Trajet trajet = trajetDao.get(Integer.parseInt(id));
        ModelAndView model = new ModelAndView("detailTrajet");
        model.addObject("trajet", trajet);
        if(trajet.getTypeTrajet().equals(0)){
        	model.addObject("typeTrajet", "Conducteur");
        }else{
        	model.addObject("typeTrajet", "Passager");
        }
        return model;     
    }

	/**
	 * 
	 * Crée l'utilisateur en fonction du formulaire
	 * Ajoute l'utilisateur en base et en session
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/connexion", method = RequestMethod.POST)
	public ModelAndView connexion(@ModelAttribute Utilisateur utilisateur, HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("accueil");
		
		/*Contrôle de cohérence*/
		if(utilisateur.getNom() == null || "".equals(utilisateur.getNom())
				|| utilisateur.getPrenom() == null || "".equals(utilisateur.getPrenom())){
			 
			model = new ModelAndView("redirect:/");
			model.addObject("message", "Vous devez saisir un nom et un prénom");
			
		}else{

			utilisateur = utilisateurDao.saveOrUpdate(utilisateur);
	        request.getSession(false).setAttribute(UTILISATEUR_SESSION, utilisateur);
			model.addObject("titrePage", "accueil");
		}
		
		return model;
	}
	
	/**
	 * 
	 * Invalide la session en cours et renvoie à l'écran de connexion
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/erreurConnexion", method = RequestMethod.GET)
    public ModelAndView erreurConnexion(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView modele = new ModelAndView("redirect:/");
		modele.addObject("message", "Votre session est invalide !");
	    return modele;
	}

	/**
	 * 
	 * Invalide la session en cours et renvoie à l'écran de connexion
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deconnexion", method = RequestMethod.GET)
    public ModelAndView deconnexion(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView modele = new ModelAndView("redirect:/");
		modele.addObject("message", "Déconnexion effectuée");
	    return modele;
	}
	
	private Utilisateur getUtilisateur(HttpServletRequest request){
		return (Utilisateur) request.getSession(false).getAttribute(UTILISATEUR_SESSION);
	}
}
