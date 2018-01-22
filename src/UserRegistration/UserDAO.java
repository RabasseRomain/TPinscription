package UserRegistration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserDAO{

    @PersistenceContext(unitName = "TPinscriptionPersistence")
    private EntityManager em;

    public void add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
    }
    
    public void delete(User user) {
        System.out.println("em: " + em);
        em.remove(user);
    }
    
    

}