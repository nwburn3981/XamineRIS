public class Permission {

	private int accessLvl ;
	private String name, programName , codeName ;
	
	public Permission() {
		
	}
	
	void setAccessLvl(int level) {
		accessLvl = level ;
	}
	
	void setName(String firstName, String lastName, String userName) {
		
		name = userName + ": " + firstName + " " + lastName ;
	}
	
	void setCodeName(String codeName) {
		codeName = this.codeName ;
	}
	
	void setProgramName(String program) {
		programName = program ;
	}


}
