package JAXRStest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import UserRegistration.User;
import UserRegistration.UserDAO;

@Path("user")
public class requestUser {
	
	@EJB
    private UserDAO userDao;
    
	// ----- TEST -------------------------------
	
    @GET
    @Path("hello")
    @Produces("text/html")
    public String hello(@QueryParam("username") String username) {
        return "Hello " + username;
    }	
    
	// ----- CREATE -----------------------------
	
    @GET
    @Path("add")
    @Produces("application/json")
    public User add(@QueryParam("username") String username, @QueryParam("email") String email, @QueryParam("password") String password) {
    	User userReturn = new User();
    	userReturn.setUsername(username);
    	userReturn.setEmail(email);
    	userReturn.setPassword(password);
        userDao.add(userReturn);
        return show(username);
    }
    
    // ----- READ -------------------------------
    
    @GET
    @Path("show")
    @Produces("application/json")
    public User show(@QueryParam("username") String username) {
    	User userReturn = new User();
        for(User user : userDao.list()) {
        	if(user.getUsername().equals(username)) { userReturn = user; }
        }
        return userReturn;
    }
    
    // ----- UPDATE -----------------------------
    
    @GET
    @Path("update")
    @Produces("application/json")
    public User update(@QueryParam("username") String username, @QueryParam("email") String email, @QueryParam("password") String password) {
    	User userUpdate = new User();
    		for(User user : userDao.list()) {
    			if(user.getUsername().equals(username)) { userUpdate = user; }
        }
    	userUpdate.setEmail(email);
    	userUpdate.setPassword(password);
        userDao.edit(userUpdate);
        return show(username);
    }
	
	// ----- DELETE -----------------------------
	
    @GET
    @Path("delete")
    @Produces("text/html")
    public String delete(@QueryParam("username") String username) {
    	userDao.delete(username);
        return username + " was deleted.";
    }
    
}

