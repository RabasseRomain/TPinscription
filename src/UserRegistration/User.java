package UserRegistration;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
//@RequestScoped
@Entity
@Table
public class User implements Serializable {
	
	private static final long serialVersionUID = 3258246348843861675L;
	
	// ----- Parameters -------------------------
	
	@Id
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	
	// ----- Constructor ------------------------
	
	public User() {
		// Empty constructor for testing purpose
	}
	
	// ----- ToString ---------------------------
	
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	// ----- Getters and Setters ----------------
	
	public String getUsername() {
		return username;
	}
	


	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String eMail) {
		this.email = eMail;
	}

}
