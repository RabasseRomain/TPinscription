package UserRegistration;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserDAO{

    @PersistenceContext(unitName = "TPinscriptionPersistence")
    private EntityManager em;
	
	// ----- CRUD -------------------------------
	
    public void add(User user) {
        em.persist(user);
    }
    
    public List<User> list() {
		List<User> listUsers = em.createQuery("SELECT u FROM User u").getResultList();
        return listUsers;
	}
    
    public void edit(User user) {
    	
    }
    
    public void delete(User user) {
    	//em.merge(user);
        em.remove(user);
    }
}