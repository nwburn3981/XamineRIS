package XamineRIS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/*
 * On login, portal is generated with options to view all scheduled appointments for current day, along with option to view all open orders  
 * 
 * 
 */
public class Technician extends User {
	private int  userId;
	private String firstName, lastName , password , email , userName; 
	private boolean isActive, isStaff, isSuperUser ;
	private Permission userPermission ;
	
	//Patients for test use in system
	//public static Patient patient1 = new Patient("John", "Kramer", "jkramer@ung.edu", "5557777878");
	//public static Patient patient2 = new Patient("Isa", "Balmer", "ibalmer@ung.edu", "7865551234");
	//public static Patient patient3 = new Patient("Pop", "Johnson", "pjohnson@ung.edu", "8885551111");
	
	//ArrayList to simulate database
	//static ArrayList<Order> testOrders = new ArrayList<>();
	
	//Orders for test use
	//static Order order1 = new Order("001", patient1);
	//static Order order2 = new Order("002", patient2);
	//static Order order3 = new Order("003", patient3);
	
	
	
	
	
	public Technician(String firstName, String lastName, String email, String userName) {
		
		super(firstName, lastName, email, userName);
		
		userPermission.setAccessLvl(2) ;
		userPermission.setCodeName("Tech");
		userPermission.setProgramName("Technician");
		userPermission.setName(userName, firstName, lastName);
		
		
		

				
	}//end Technician
	
	public static Connection getConnection(){
		 try{
			   String driver = "com.mysql.cj.jdbc.Driver";
			   String url = "jdbc:mysql://localhost:3306/xaminedatabase";
			   String username = "root";
			   String password = "";
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
	
	public static Patient returnPatient(int ID) throws SQLException {
		
		 ArrayList<Patient> Patients = new ArrayList<>() ;
		 Patient currPatient[] = new Patient[1] ;
		 int index = 0 ;
		 
		 Connection conn = getConnection() ;
		 PreparedStatement statement = conn.prepareStatement("Select * from patient Where patientID  = ?  ;") ;
		 
		statement.setInt(1, ID );
		
		ResultSet result = statement.executeQuery() ;
		
		while(result.next()) {
			 currPatient[0] = new Patient(result.getString("firstName"), result.getString("lastName")) ;
			 currPatient[0].setPatientId(result.getInt("patientID"));
			 currPatient[0].setEmail(result.getString("email"));
			 currPatient[0].setDateOfBirth(result.getString("dateOfBirth"));
			
	}
		 
		
		result.close();
		
		return currPatient[0] ;
	}
	
	
	public static ArrayList<Order> ViewAppointments(LocalDate Newdate) throws SQLException {
		/*Searches through orders for current day's appointments
		 * Puts Orders for selected date in arraylist for UIManager to access and display
		 * UIManager displays orderID, appt time, room number, and imaging ordered
		 * User can select appt and press select button to display patient information
		 */		
		
		String date = Newdate.toString();
		
		//Adding parameters for testing
		ArrayList<Order> todaysOrders = new ArrayList<>();
		Patient currPatient ;
		int index = 0;
		Connection conn = getConnection() ;
		
		PreparedStatement statement = conn.prepareStatement("Select * from imagingorder Where appointment = ? ; " ) ;
		statement.setString(1, date);
		
		ResultSet result = statement.executeQuery() ;
		
		while(result.next()) {
			currPatient = returnPatient(result.getInt("OrderId")) ;
			todaysOrders.add(index, new Order(result.getInt("OrderId"), currPatient ));
			todaysOrders.get(index).setApptTime(result.getString("appointment"));
			todaysOrders.get(index).setImagingOrder(result.getString("imagingNeeded"));
			todaysOrders.get(index).setVisitReason(result.getString("visitReason"));
			todaysOrders.get(index).setOrderStatus(result.getString("orderStatus"));
			todaysOrders.get(index).setApptTime(result.getString("appointment"));
			index++ ;
		}
		
		System.out.println(" Today's appointments found successfully");
		return todaysOrders ;
	}
	
	
	
	public static ArrayList<Order> ViewOrders() throws SQLException {
		/*Displays all uncompleted orders
		 * Puts open Orders in arraylist for UIManager to access and display
		 * UIManager displays orderID, appt time, room number, imaging ordered, and if any images are attached
		 * User can select order and press select button to display patient information
		 */
		
		//Adding parameters for testing

		ArrayList<Order> testOrders = ViewAppointments(LocalDate.now()) ;		
		
		//List for UIManager 
		ArrayList<Order> openOrders = new ArrayList<>();
		
		
		//Iterates through Arraylist looking for open Order, will iterate through database Order table in final version
		for(int i = 0; i < testOrders.size(); i++) {
			if(testOrders.get(i).getOrderStatus() == "Open") {
				openOrders.add(testOrders.get(i));
			}//end if
			
		}//end for loop
		
		testOrders.clear();
		
		return openOrders;
		
	}
	
	//pretty sure this should be in UIManager handled by button, may move once more of the UI is developed
	public String SelectOrder(Order selectedOrder) {
	  
	  /*Displays Patient info, if patient has been checked in, and all previous info displayed
	   *Generates buttons to submit order, view images on order and to add images to order.
	  */
		
		//Display orderID, patient name, patient gender, patient age, appt time, appt day, room number, imaging ordered, number of images if images exist
	 	
	 	return "Patient Name: " + selectedOrder.getPatient().getFirstName() + " " + selectedOrder.getPatient().getLastName();
	 }//end SelectOrder
	 
	
	
	public void RemoveImage(Order selectedOrder, ImageFile img) {
		
		/*Removes image from order
		 * 
		 */
		
		selectedOrder.getImages().remove(img);
		
		
	}//end DeleteImage
	
	public ImageFile ViewImage(Order selectedOrder) {
		
		/*opens image viewer allowing user to view all images attached to order
		 * generates buttons to close viewer and to remove image from order 
		 * 
		 */
		
		//Will select first image in list, next and previous button can be used to display more images in list by iterating index number
		ImageFile selectedImg = selectedOrder.getImages().get(0);
		
		return selectedImg;
		
	}
	
	public ImageFile ViewNextImage(Order selectedOrder, ImageFile img) {
		
		/*opens image viewer allowing user to view all images attached to order
		 * generates buttons to close viewer and to remove image from order 
		 * 
		 */
		
		//finds index of currently selected image
		int currentIndex = selectedOrder.getImages().indexOf(img);
		
		//Will select next image in list
		ImageFile nextImg = selectedOrder.getImages().get(currentIndex+1);
		
		return nextImg;
		
	}
	
public ImageFile ViewPreviousImage(Order selectedOrder, ImageFile img) {
		
		/*opens image viewer allowing user to view all images attached to order
		 * generates buttons to close viewer and to remove image from order 
		 * 
		 */
		
		//finds index of currently selected image
		int currentIndex = selectedOrder.getImages().indexOf(img);
		
		//Will select next image in list
		ImageFile prevImg = selectedOrder.getImages().get(currentIndex-1);
		
		return prevImg;
		
	}
	
	
	public Boolean CheckIfEmpty(Order selectedOrder) {
		
		//Checks if image field is empty before allowing order submittal 
		
		Boolean isEmpty = true;
		
		if (selectedOrder.getImages() != null)
			 isEmpty = false;
		
		return isEmpty;
		
	}//end CheckIfEmpty
	
	
	public void SubmitOrder(Order selectedOrder) {
		
		/*Sends notification to radiologist that order is ready for analysis
		 *Best way to do this may be to have a check at the loading of every UI element - 1 notification for each order status set to complete,
		 *viewing notifications will display orders with completed imaging
		 * 
		 */
		selectedOrder.setImagingOrderStatus("Complete");
		
	}//end SubmitOrder
	
	//------------------------------Setters/Getters------------------------------------------------

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	//public String getPassword() {
	//	return password;
	//}

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
