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
    
    @SuppressWarnings("unchecked")
	public List<User> list() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}
    
    public void edit(User newUser) {
    	User oldUser = em.find(User.class, newUser.getUsername());
    	oldUser.setEmail(newUser.getEmail());
    	oldUser.setPassword(newUser.getPassword());  	
    }
    
    public void delete(String username) {
    	User user = em.find(User.class, username);
        em.remove(user);
    }
}