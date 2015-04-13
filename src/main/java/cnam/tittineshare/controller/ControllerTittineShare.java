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
import cnam.tittineshare.modele.dao.TrajetDAO;
import cnam.tittineshare.modele.dao.UtilisateurDAO;

@Controller
public class ControllerTittineShare {
	
	@Autowired
    private UtilisateurDAO utilisateurDao;
    private TrajetDAO trajetDao;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView helloWorld(){
 
		ModelAndView model = new ModelAndView("accueil");
		model.addObject("msg", "hello world");
 
		return model;
	}
	
	@RequestMapping(value = "/trajets", method = RequestMethod.GET)

    public ModelAndView trajets() throws Exception {
        List<Trajet> trajets = trajetDao.list();
        ModelAndView model = new ModelAndView("trajets");
        model.addObject("trajets", trajets);
        return model;
    }
	
	@RequestMapping(value = "/modifier", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        int trajetId = Integer.parseInt(request.getParameter("id"));
        Trajet trajet = trajetDao.get(trajetId);
        ModelAndView model = new ModelAndView("modifier");
        model.addObject("trajet", trajet);
        return model;      
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int trajetId = Integer.parseInt(request.getParameter("id"));
        trajetDao.delete(trajetId);
        return new ModelAndView("redirect:/trajets");     
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute Trajet trajet) {
        trajetDao.saveOrUpdate(trajet);
        return new ModelAndView("redirect:/trajets");
    }  
}