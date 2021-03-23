import java.security.Permission;
import java.util.ArrayList;

public class Radiologist extends User {


	
	 private String userID, userPassword, firstName, lastName, email, userName ;
	 
	 private boolean isActive, isStaff, isSuperUser ;
	 private Permission userPermission ;
	 
	 	 
		
		public Radiologist(String userID, String userPassword,String firstName, String lastName) {
			
			
			
			super(firstName, lastName);
			
			userPermission.setAccessLvl(4) ;
			userPermission.setCodeName("Super User");
			userPermission.setProgramName("Super User");
			userPermission.setName(userName, firstName, lastName) ;
			
		}
		
		
		
		public Order SelectOrder(Order order) {
			
			
			
		}
		
		

		
		public void AddReport() {
			
			
		
			
		}
		
		public void saveReport() {
			
			
			
			
			
		}
		
		
		
		public String retrieveReport() {
			
			
			
		}
		
		
		public void SubmitOrder() {

		
		}

		
		-----Setters/Getters----
		
		public String getUserId() {
			return userID;
		}

		public void setUserId(String userId) {
			this.userID = userId;
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
			return userPassword;
		}

		public void setPassword(String password) {
			this.userPassword = password;
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

		public Permission getUserPermission() {
			return userPermission;
		}

		public void setUserPermission(Permission userPermission) {
			this.userPermission = userPermission;
		}
		

		
		
		
	
		
		
}
	
