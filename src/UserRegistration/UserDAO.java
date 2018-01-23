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
		return em.createQuery("SELECT u FROM User u").getResultList();
	}
    
    public void edit(User user) {
    	
    }
    
    public void delete(String username) {
    	User user = em.find(User.class, username);
        em.remove(user);
    }
}