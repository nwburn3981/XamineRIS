
public class User {

	private String userId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userName; 
	private boolean isActive, isStaff, isSuperUser ;
	private Permission userPermission ;
	
	// TO-DO 
	// date joined? 
	// permissions system 
	// set password 
	
	public User( String firstName, String lastName, String email, String userName){
		
		userName = this.userName ;
		firstName = this.firstName ;
		lastName = this.lastName ;
		email = this.email ;
		
		userPermission.setAccessLvl(0) ;
		userPermission.setName(userName, firstName, lastName) ;
	
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isStaff() {
		return isStaff;
	}

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	public boolean isSuperUser() {
		return isSuperUser;
	}

	public void setSuperUser(boolean isSuperUser) {
		this.isSuperUser = isSuperUser;
	}
	
	public String toString(){
		String result ;
		
		result = "Username: " + userName + "\n" + "Name: " + firstName + " " +
				 lastName + "\n" + "Email: " + email ;
		
		return result ;
		
	}
	
	
}