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
    
    private Boolean apptScheduled;
    private Boolean patientCheckedIn;
    
    //Image image;
    //Patient patient;


    
    public Order( String OrderID){
     
    orderID;
    orderStatus;
    Modality;
    imagingOrder;
    apptRoom;
    apptTime;
    dateCreated;
    lastModified;
    radioAnalysis;
    
    apptScheduled = false;
    patientCheckedIn = false;
    
    image = new Image();
    patient = new Patient();

    }
    
    public String GetOrderID(){
        
        return orderID;
    }
    
    public void SetOrderID(String oID){
        
         orderID = oID;
    }
    

    }
    

    
}
