package cnam.tittineshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView helloWorld(){
		ModelAndView model = new ModelAndView("accueil");
		model.addObject("titrePage", "accueil");
		return model;
	}
	
	/**
	 * 
	 * Servlet d'accès à la page de configuration d'un trajet
	 * Bouton "Créer trajet"
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/trajets", method = RequestMethod.GET)
    public ModelAndView trajets() {
        List<Trajet> trajets = trajetDao.list();
        ModelAndView model = new ModelAndView("trajets");
        model.addObject("trajets", trajets);
        return model;
    }
	
	/**
	 * 
	 * Servlet d'accès à la page de modification d'un trajet
	 * Bouton "Modifier trajet"
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifier", method = RequestMethod.GET)
    public ModelAndView editTrajet(HttpServletRequest request) {
        int trajetId = Integer.parseInt(request.getParameter("id"));
        Trajet trajet = trajetDao.get(trajetId);
        ModelAndView model = new ModelAndView("modifier");
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
    public ModelAndView saveTrajet(@ModelAttribute Trajet trajet) {
        trajetDao.saveOrUpdate(trajet);
        return new ModelAndView("redirect:/");
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
        utilisateurDao.saveOrUpdate(utilisateur);
        request.getSession(false).setAttribute(UTILISATEUR_SESSION, utilisateur);
		ModelAndView model = new ModelAndView("accueil");
		model.addObject("titrePage", "accueil");
		return model;
	}
	
	/**
	 * 
	 * Invalide la session en cours et renvoie à l'écran de connexion
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/erreurConnexion", method = RequestMethod.POST)
    public ModelAndView erreurConnexion(@ModelAttribute HttpServletRequest request) {
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
	@RequestMapping(value="/deconnexion", method = RequestMethod.POST)
    public ModelAndView deconnexion(@ModelAttribute HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView modele = new ModelAndView("redirect:/");
		modele.addObject("message", "Déconnexion effectuée");
	    return modele;
	}
}