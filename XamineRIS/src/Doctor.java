import java.sql.*;

public class Doctor extends User {
	
	private String userId, firstName, lastName , password , email , userName; 
	private boolean isActive, isStaff, isSuperUser ;
	private Permission userPermission ;
	
	public Doctor( String firstName, String lastName, String email, String userName) {
		
		super(firstName, lastName, email, userName);
		
		
		userPermission.setAccessLvl(1) ;
		userPermission.setCodeName("RefDr");
		userPermission.setProgramName("Referring Doctor");
		userPermission.setName(userName, firstName, lastName) ;
	}

	public static Connection getConnection(){
		try{
			String driver = "com.mysql.jdbc.Driver";
		 	String url = "jdbc:mysql://localhost:3306/xaminedatabase";
			String username = "root";
			String password = "EnterYourSQLPasswordHere";
			Class.forName(driver);
			   
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			System.out.println("");
			return conn;
		} 
		catch(Exception e){
			System.out.println(e);
		}	  
		return null ;
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

	public Permission getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(Permission userPermission) {
		this.userPermission = userPermission;
	}
	
