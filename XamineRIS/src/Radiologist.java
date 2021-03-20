
public class Radiologist extends User {
	
	private String userId, firstName, lastName , password , email , userName; 
	private boolean isActive, isStaff, isSuperUser ;
	private Permission userPermission ;
	
public Radiologist(String firstName, String lastName, String email, String userName) {
		
		super(firstName, lastName, email, userName);
		
		userPermission.setAccessLvl(4) ;
		userPermission.setCodeName("SupUser");
		userPermission.setProgramName("Super User");
		userPermission.setName(userName, firstName, lastName) ;
		
	}//end Radiologist

}
