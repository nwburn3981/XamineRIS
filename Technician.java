import java.util.Date;

/*
 * On login, portal is generated with options to view all scheduled appointments for current day, along with option to view all open orders  
 * Techs can upload images to selected orders, remove images, and submit completed orders
 * 
 */
public class Technician extends User {
	
	private String userId, firstName, lastName , password , email , userName; 
	private boolean isActive, isStaff, isSuperUser ;
	private Permission userPermission ;
	
	public Technician(String firstName, String lastName, String email, String userName) {
		
		super(firstName, lastName, email, userName);
		
		userPermission.setAccessLvl(2) ;
		userPermission.setCodeName("Tech");
		userPermission.setProgramName("Technician");
		userPermission.setName(userName, firstName, lastName);
		
	}
	
	public void viewAppointments(Date today) {
		/*Searches through orders for current day's appointments
		 * Displays orderID, appt time, room number, and imaging ordered
		 * User can select appt and press select button to display patient information
		 */
	}
	
	public void viewOrders(String openOrder) {
		/*Displays all uncompleted orders
		 * Displays orderID, appt time, room number, imaging ordered, and any attached images
		 * User can select order and press select button to display patient information
		 */
	}
	
	/*public Order SelectOrder(String orderID) {
	 * 
	 * Displays Patient info, if patient has been checked in, and all previous info displayed
	 * Generates buttons to submit order, view images on order and to add images to order.
	 * 
	 * 
	 *	Order order = ("SQL statement to receive order with orderID");
	 *	
	 *	return order;
	 *}//end SelectOrder
	 */
	
	public void ViewImage() {
		
		/*opens image viewer allowing user to view all images attached to order
		 * generates buttons to close viewer and to remove image from order 
		 * 
		 */
		
	}
	
	public void AddImage(Image img) {
		
		/*Generates prompt to upload a selected file along with option to browse file system for desired image
		 * Checks to confirm file is accepted type
		 */
		
	}//end AddImage
	
	public void RemoveImage() {
		
		/*Removes image from order
		 * 
		 */
		
		
	}//end DeleteImage
	
	public Boolean CheckIfEmpty() {
		
		//Checks if image field is empty before allowing order submittal 
		
		Boolean isEmpty = true;
		
		return isEmpty;
		
	}//end CheckIfEmpty
	
	public Boolean AssignedAppointment(String orderId) {//Notifies team when appointment is made, should be in receptionist class
		
		Boolean apptScheduled = false;
		
		return apptScheduled;
		
	}//end AssignedAppointment
	
	public void SubmitOrder() {
		
		/*Sends notification to radiologist that order is ready for analysis
		 * 
		 * 
		 */
		
		
	}//end SubmitOrder


}
