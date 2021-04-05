
public class Modality {

	private String modalityID;
	private String modalityName;
	
	public Modality(String id) {
		this.modalityID = id;
		
		switch(modalityID) {
		case "01":{
			this.modalityName = "XRay";
			break;
		}
		case "02":{
			this.modalityName = "MRI";
			break;
		}
		case "03":{
			this.modalityName = "Ultrasound";
			break;
		}
	
		}//end switch
	}

	public String getModalityID() {
		return modalityID;
	}

	public String getModalityName() {
		return modalityName;
	}
	
	
}
