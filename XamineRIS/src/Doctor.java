
import java.sql.*;

public class Doctor extends User {
	
	private String userId, firstName, lastName , email , userName, password; 
	private boolean isActive, isStaff, isSuperUser ;
	private Permission userPermission ;
	
	public Doctor( String firstName, String lastName, String email, String userName) {
		super(firstName, lastName, email, userName);
		
		//userPermission.setAccessLvl(1) ;
		//userPermission.setCodeName("RefDr");
		//userPermission.setProgramName("Referring Doctor");
		//userPermission.setName(userName, firstName, lastName) ;
	}
	
	public static Connection getConnection(){
		 try{
			   String driver = "com.mysql.cj.jdbc.Driver";
			   String url = "jdbc:mysql://localhost:3306/xaminedatabase";
			   String username = "root";
			   String password = "Et70670!";
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
	
	public Patient[] returnPatient(String firstName, String lastName, String dateOfBirth, String email) throws SQLException {
		
		 Patient[] Patients = new Patient[10] ;
		 String  DoctorName = this.userName ;
		 int index = 0 ;
		 
		 Connection conn = getConnection() ;
		 PreparedStatement statement = conn.prepareStatement(" Select patientID , firstName , lastName , dateOfBirth , email \r\n\t" + 
		 		"From patient" + "\r\n\t" + 
		 		"Where firstName = ? \r\n\t" + 
		 		"And lastName = ? \r\n\t" + 
		 		"AND email = ? \r\n\t" + 
		 		"AND dateOfBirth = ? ;") ;
		 
		statement.setString(1, firstName);
		statement.setString(2, lastName);
		statement.setString(3, email);
		statement.setString(4, dateOfBirth);
		ResultSet result = statement.executeQuery() ;
		
		while(result.next() && index <= 4) {
			 Patients[index] = new Patient(result.getString("firstName"), result.getString("lastName")) ;
			 index++ ;
		 }
		
		result.close();
		
		return Patients ;
	}
	
	public Order[] returnOrders(String firstName, String lastName, String dateOfBirth, String email) throws SQLException {
		
		 Order[] Orders = new Order[5] ;
		 Patient[] Patients = returnPatient(firstName, lastName, dateOfBirth, email) ;
		 String  DoctorName = this.userName ;
		 
		 getConnection() ;
		
		
		 
		return Orders ;
		
	}
	
	public void newPatient(String firstName, String lastName, String dateOfbirth, String email, String gender, String Phone, 
			boolean latex, boolean xraydye, boolean mridye, String Notes  ) {
		
		int IDnum ;
		getConnection() ;
		
		// SQL need to find the max patient ID and add one to it 
		// IDnum = select MAX(patientID) from patient ;
		// IDnum++ ;
		
		// SQL Command to insert into Patient table 
		// Insert into patient values( IDnum , userName, firstName, lastName, email, dateOfbirth, gender , latex, xraydye, mridye , notes , phoneNumber);
		
	}
	
	public void newOrder( Patient patient , String imagesNeeded , String notes  ) {
		
		int IDnum ;
		getConnection() ;
		
		// SQL command needed to find the order with the largest id num 
		// IDnum = select MAX(orderID) from imagingOrder ;
		// IDnum++ ;
		
		// SQL needed to create a new order.
		// Insert into imagingorder values( IDnum , patient.getPatientID() , "Open" , null , notes , imagesNeeded , null, null, null, null ) ;
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
	
}
