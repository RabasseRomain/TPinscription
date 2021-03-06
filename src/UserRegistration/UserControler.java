package UserRegistration;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserControler implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;
    
    private boolean isInDatabase;

    @EJB
    private UserDAO userDao;

    public UserControler() {
        user = new User();
    }
	
	// ----- CRUD Functions ---------------------
	
    public String add() {
    	System.out.println("Adding user " + user.getUsername());
        userDao.add(user);
        return "HomePage";
    }
    
    public List<User> list() {
    	System.out.println("Listing All Users");
        return userDao.list();
    }
    
    public String edit() {
    	System.out.println("Editing user " + user.getUsername());
    	userDao.edit(user);
        return "HomePage";
    }
    
    public String delete(String username) {
    	System.out.println("Deleting user " + username);
        userDao.delete(username);
        return "HomePage";
    }
	
	// ----- Other Functions --------------------
	
    public String logIn() {
    	System.out.println("Looking for user " + user.getUsername());
        isInDatabase = false;
        for(User userCheck: userDao.list()) {
        	if(userCheck.getUsername().equals(user.getUsername()) && userCheck.getPassword().equals(user.getPassword())) {
        		isInDatabase = true;
        	}
        }
        if(isInDatabase) {
        	return "HomePage";
        } else {
        	return "NotAnUser";
        }
    }
	
    public void show() {
    	System.out.println("Current user: ");
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
    }
    
    public void showAll() {
    	for(User userListed: userDao.list()) {
        	System.out.println(userListed.toString());
        }
    }	
	// ----- Getters and Setters ----------------
	
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