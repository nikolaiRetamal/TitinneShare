package cnam.tittineshare.modele.dao;
 
import java.util.List;
 
import cnam.tittineshare.modele.bean.Utilisateur;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
public class UtilisateurDAO {
    @Autowired
    private SessionFactory sessionFactory;
 
    public UtilisateurDAO() {
         
    }
     
    public UtilisateurDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Utilisateur> list() {
        @SuppressWarnings("unchecked")
        List<Utilisateur> listUtilisateur = (List<Utilisateur>) sessionFactory.getCurrentSession()
                .createCriteria(Utilisateur.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUtilisateur;
    }

    /**
     * 
     * Cette classe crée un nouvel utilisateur avec les noms/prénoms fournis.
     * Si il existe déjà un utilisateur en base pour la clef noms/prénoms la méthode renvoie plutôt cet utilisateur.
     * Cependant la clef primaire reste le utilisateur_id qui sert de clef étrangère dans la table des trajets.
     * 
     * @param user
     * @return
     */
    @Transactional
    public Utilisateur saveOrUpdate(Utilisateur user) {
    	
    	Utilisateur myUser = get(user.getNom(), user.getPrenom());
    	
    	if(myUser == null){
            sessionFactory.getCurrentSession().saveOrUpdate(user);
            myUser = get(user.getNom(), user.getPrenom());
    	}
    	
    	return myUser;
    }
 

    @Transactional
    public void delete(int id) {
        Utilisateur userToDelete = new Utilisateur();
        userToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }


    @Transactional
    public Utilisateur get(int id) {
        String hql = "from Utilisateur where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Utilisateur> users = (List<Utilisateur>) query.list();
         
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
         
        return null;
    }
    
    /**
     * 
     * Renvoie un utilisateur avec les nom/prénom fournis si il existe en base.
     * La comparaison est réalisée via un UPPERCASE()
     * 
     * @param nom
     * @param prenom
     * @return
     */
    @Transactional
    public Utilisateur get(String nom,String prenom) {
        String hql = "from Utilisateur where UCASE(UTILISATEUR_NOM) like UCASE('" + nom + "')"+
        			 " and UCASE(UTILISATEUR_PRENOM) like UCASE('"+prenom+"')";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Utilisateur> users = (List<Utilisateur>) query.list();
         
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
         
        return null;
    }
}
