public class Order
{
    private String orderID;
    private String orderStatus;
    private String Modality;
    private String imagingOrder;
    private String apptRoom;
    private String apptTime;
    private String dateCreated;
    private String lastModified;
    private String radioAnalysis;
    private String visitReason ;
    
    private Boolean apptScheduled;
    private Boolean patientCheckedIn;
    
    private Patient patient;
    
    // TO-DO 
    // Add a date object to hold appointment date 
    // consider an appointment object (not required) 
    // Implement image object and add it as  a varaible along with getters and setters here 
    // Implement a text box for analysis by the radiologist 


    
    public Order( String orderID, Patient patient){
     
    orderID = this.orderID ;
    patient = this.patient ;

    }
    
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getModality() {
		return Modality;
	}

	public void setModality(String modality) {
		Modality = modality;
	}

	public String getImagingOrder() {
		return imagingOrder;
	}

	public void setImagingOrder(String imagingOrder) {
		this.imagingOrder = imagingOrder;
	}

	public String getApptRoom() {
		return apptRoom;
	}

	public void setApptRoom(String apptRoom) {
		this.apptRoom = apptRoom;
	}

	public String getApptTime() {
		return apptTime;
	}

	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getRadioAnalysis() {
		return radioAnalysis;
	}

	public void setRadioAnalysis(String radioAnalysis) {
		this.radioAnalysis = radioAnalysis;
	}

	public Boolean getApptScheduled() {
		return apptScheduled;
	}

	public void setApptScheduled(Boolean apptScheduled) {
		this.apptScheduled = apptScheduled;
	}

	public Boolean getPatientCheckedIn() {
		return patientCheckedIn;
	}

	public void setPatientCheckedIn(Boolean patientCheckedIn) {
		this.patientCheckedIn = patientCheckedIn;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}
    
}
