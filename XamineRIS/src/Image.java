import java.io.File;
import java.util.Date;

public class Image {
	
	Date addedOn;
	File image;
	String label;
	String user;
	
	public Image(Date uploadOn, File img, String lbl, String uploadUser) {
		
		this.addedOn = uploadOn;
		if (VerifyImage(lbl) == true)
			this.image = img;
		else
			System.out.println("File type not accepted, .jpg or .png only");
		this.label = lbl;
		this.user = uploadUser;
		
	}//end Image
	
	public Boolean VerifyImage(String lbl) {//only accepts .jpg and .png
		
		int startIndex = lbl.length()-4;
		Boolean isAccepted = false;
		
		//Check substring of final 4 indexes for .jpg or .png
		if (lbl.substring(startIndex, lbl.length()) == ".jpg" || lbl.substring(startIndex, lbl.length()) == ".png") {
			 isAccepted = true;
		}//end if
		
		return isAccepted;
		
	}//end VerifyImage

	@Override
	public String toString() {
		return "Image [addedOn=" + addedOn + ", image=" + image + ", label=" + label + ", user=" + user + "]";
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	

}