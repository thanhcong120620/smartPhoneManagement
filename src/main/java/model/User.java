package model;

public class User {
	private String email;
	private String password;
	private String message = "Error validating information !";
	

	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean validate() {
		if(password.length()<8) {
			message = "Password must be at least 8 character";
			return false;
		} else if(password.matches("\\w*\\s+\\w*")) {
			message =  "Password cannot contain space.";
			return false;
		}
		
		if(email==null) {
			message = "No email address was set";
			return false;
		}
		if(password == null) {
			message = "No password was set";
			return false;
		}
		
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email addess";
			return false;
		}
		
		return true;
	}

}
