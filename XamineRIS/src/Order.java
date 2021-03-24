import java.time.LocalDate;
import java.util.ArrayList;

public class Order
{
    private String orderID;
    private String orderStatus;
    private String Modality;
    private String imagingOrder;
    private String imagingOrderStatus = "open";
    private String apptRoom;
    private String lastModified;
    private String radioAnalysis;
    private String visitReason ;
    private String apptTime;
    
    private LocalDate apptDay;
    private LocalDate dateCreated;
    
    private Boolean apptScheduled;
    private Boolean patientCheckedIn;
    
    private Patient patient;
    
    private ArrayList<ImageFile> images = new ArrayList<>();
    
    // TO-DO 
    // Add a date object to hold appointment date DONE 
    // consider an appointment object (not required) 
    // Implement image object and add it as  a variable along with getters and setters here DONE
    // Implement a text box for analysis by the radiologist 


    
    public Order( String orderID, Patient patient){
     
    this.orderID = orderID;
    this.patient = patient;

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

	public String getImagingOrderStatus() {
		return imagingOrderStatus;
	}

	public void setImagingOrderStatus(String imagingOrderStatus) {
		this.imagingOrderStatus = imagingOrderStatus;
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

	//Format and verify string is an accepted time
	public void setApptTime(String apptTime ) {
		this.apptTime = apptTime;
	}

	public LocalDate getApptDay() {
		return apptDay;
	}

	public void setApptDay(LocalDate apptDay) {
		this.apptDay = apptDay;
	}

	public ArrayList<ImageFile> getImages() {
		return images;
	}

	public void setImages(ArrayList<ImageFile> images) {
		this.images = images;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
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