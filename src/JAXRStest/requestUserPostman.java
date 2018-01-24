package JAXRStest;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import UserRegistration.User;
import UserRegistration.UserDAO;

@Path("PmUser")
public class requestUserPostman {
	
	@EJB
    private UserDAO userDao;
    
	// ----- TEST -------------------------------
	
    @GET
    @Path("hello/{username}")
    @Produces("text/html")
    public String hello(@PathParam("username") String username) {
        return "Hello " + username;
    }	
    
	// ----- CREATE -----------------------------
	
    @POST
    @Path("add/{username}/{email}/{password}")
    @Produces("application/json")
    public User add(@PathParam("username") String username, @PathParam("email") String email, @PathParam("password") String password) {
    	User userReturn = new User();
    	userReturn.setUsername(username);
    	userReturn.setEmail(email);
    	userReturn.setPassword(password);
        userDao.add(userReturn);
        return show(username);
    }
    
    // ----- READ -------------------------------
    
    @GET
    @Path("show/{username}")
    @Produces("application/json")
    public User show(@PathParam("username") String username) {
    	User userReturn = new User();
        for(User user : userDao.list()) {
        	if(user.getUsername().equals(username)) { userReturn = user; }
        }
        return userReturn;
    }
    
    // ----- UPDATE -----------------------------
    
    @PUT
    @Path("update/{username}/{email}/{password}")
    @Produces("application/json")
    public User update(@PathParam("username") String username, @PathParam("email") String email, @PathParam("password") String password) {
    	User userUpdate = new User();
    	userUpdate.setUsername(username);
    	userUpdate.setEmail(email);
    	userUpdate.setPassword(password);
        userDao.edit(userUpdate);
        return show(username);
    }
	
	// ----- DELETE -----------------------------
	
    @DELETE
    @Path("delete/{username}")
    @Produces("text/html")
    public String delete(@PathParam("username") String username) {
    	userDao.delete(username);
        return username + " was deleted.";
    }
    
}

