package UserRegistration;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserControler implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;

    @EJB
    private UserDAO userDao;

    public UserControler() {
        user = new User();
    }

    public void add() {
        System.out.println("adding user " + user.getEmail());
        userDao.add(user);
    }

    public String show() {
    	// Show we got the data
        System.out.println("user in form ");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        // Put User in DB
        add();
        // Go to Welcome Page
        return "HomePage";
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

}