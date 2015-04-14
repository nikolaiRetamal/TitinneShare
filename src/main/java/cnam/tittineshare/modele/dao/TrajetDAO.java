package cnam.tittineshare.modele.dao;
 
import java.util.List;
 
import cnam.tittineshare.modele.bean.Trajet;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
public class TrajetDAO {
    @Autowired
    private SessionFactory sessionFactory;
 
    public TrajetDAO() {
         
    }
     
    public TrajetDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<Trajet> list() {
        @SuppressWarnings("unchecked")
        List<Trajet> listTrajet = (List<Trajet>) sessionFactory.getCurrentSession()
                .createCriteria(Trajet.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listTrajet;
    }
 
    @Transactional
    public void saveOrUpdate(Trajet trajet) {
        sessionFactory.getCurrentSession().saveOrUpdate(trajet);
    }
 
    @Transactional
    public void delete(int id) {
        Trajet trajetToDelete = new Trajet();
        trajetToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(trajetToDelete);
    }
 
    @Transactional
    public Trajet get(int id) {
        String hql = "from trajet where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Trajet> trajets = (List<Trajet>) query.list();
         
        if (trajets != null && !trajets.isEmpty()) {
            return trajets.get(0);
        }
         
        return null;
    }
}