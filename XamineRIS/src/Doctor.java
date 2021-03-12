
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
	
}
