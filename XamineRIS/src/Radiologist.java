import java.security.Permission;


public class Radiologist extends User {
	
	private String userID, firstName, lastName , password , email , userName; 
	private boolean isActive, isStaff, isSuperUser ;
	private Permission userPermission ;
	private Order order;
	
	
public Radiologist(String firstName, String lastName, String email, String userName) {
		
		super(firstName, lastName, email, userName);
		
		userPermission.setAccessLvl(4) ;
		userPermission.setCodeName("Super User");
		userPermission.setProgramName("Super User");
		userPermission.setName(userName, firstName, lastName) ;
		
	}//end Radiologist

	
		
		public void selectOrder(Order order) {
			
		}
		
		public void AddReport() {
			
		}
		
		public void saveReport() {
			
		}
		
		public String retrieveReport() {
				
		}
		
		public void SubmitOrder() {

		
		}
	
	
}
