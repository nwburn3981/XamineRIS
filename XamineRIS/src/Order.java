public class Order
{
    protected String orderID;
    protected String orderStatus;
    protected String Modality;
    protected String imagingOrder;
    protected String apptRoom;
    protected String apptTime;
    protected String dateCreated;
    protected String lastModified;
    protected String radioAnalysis;
    
    protected Boolean apptScheduled;
    protected Boolean patientCheckedIn;
    
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
