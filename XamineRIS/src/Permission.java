public class Permission {
	
	// This object will serve as our way of ensuring that each job performed within the system corresponds
	// with the appropriate user IE Access Control. 
	// it uses an ineger value that determines wich GUI is called by the system so, 0 = no privilages, 1 = Referring Dr, 2 = Reception 
	// 3 = Technician , 4 = Radiologist 5 = SuperUser 
	// the Permission object also keeps track of the Users name, program name ex(receptionist), and codename ex(Referring Doctor = RefDr)
	// Contact me for any questions or concerns! - Ethan 
	
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
