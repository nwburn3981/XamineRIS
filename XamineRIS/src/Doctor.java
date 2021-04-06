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
	
	
	public Patient[] returnPatient(String firstName, String lastName, String dateOfBirth, String email) {
		
		 Patient[] Patients = new Patient[5] ;
		 String  DoctorName = this.userName ;
		 
		 getConnection() ;
		
		// pass this statement to SQL to return the appropriate search criteria 
		// Select patientID , firstName , lastName , dateOfBirth , email 
		//	  From patient 
		//    Where firstName = firstName
		//    And lastName = lastName 
		//    AND email = email 
		//    AND dateOfBirth = dateofBirth 
		//    AND referringDoctorUserName = DoctorName ;
		 
		// insert results into Patient objects here 
		// can make for loop run as many times as there are sql results up to 5
		 for (int x = 0 ; x < 5 ; x++) {
			 // create Patient object with SQL result ( the returned row will correspond with the patient)
			 Patients[x] = new Patient(SQLfirstName, SQLlastName, SQLEmail );
			 Patients[x].setDateOfBirth(SQLdateOfBirth ) ;
			 Patients[x].setPatientId(SQLpatientID) ;
		 }
		 
		return Patients ;
		
	}
	
	public Order[] returnOrders(String firstName, String lastName, String dateOfBirth, String email) {
		
		 Order[] Orders = new Order[5] ;
		 Patient[] Patients = returnPatient(firstName, lastName, dateOfBirth, email) ;
		 String  DoctorName = this.userName ;
		 
		 getConnection() ;
		
		// pass this statement to SQL to return the appropriate search criteria 
		// Select OrderId, patientID, orderStatus, appointment, visitReason, imagingNeeded
		//	From imagingOrder
		//    Where patientID in (Select patientID 
		//	  	From patient 
		//    	Where firstName = firstName
		//   	And lastName = lastName 
		//   	AND email = email 
		//    	AND dateOfBirth = dateOfBirth 
		//    	AND referringDoctorUserName = DoctorName );
		 	
		// insert results into Patient objects here 
		// can make for loop run as many times as there are sql results up to 5
		 for (int x = 0 ; x < 5 ; x++) {
			 // create Patient object with SQL result ( the returned row will correspond with the patient)
			 Orders[x] = new Order(SQLOrderID , Patients[x]);
			 Orders[x].setImagingOrderStatus(SQLorderStatus);
			 Orders[x].setApptDay(SQLappointment);
			 Orders[x].setVisitReason(SQLvisitReason);
			 Orders[x].setImagingOrder(SQLimagingNeeded);
			 
		 }
		 
		return Orders ;
		
	}
	
	public void newPatient(String firstName, String lastName, String dateOfbirth, String email, String gender, String Phone, 
			boolean latex, boolean xraydye, boolean mridye, boolean asthma, String Notes  ) {
		
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
	
