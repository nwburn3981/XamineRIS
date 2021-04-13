package XamineRIS;

import java.awt.Image;
import java.time.LocalDate;

//TODO
//Need to fix verify
public class ImageFile {
	
	LocalDate addedOn;
	Image image;
	String label;
	String user;
	
	public ImageFile(LocalDate uploadOn, Image img, String lbl, String uploadUser) {
		
		this.addedOn = uploadOn;
		/*if (VerifyImage(lbl) == true)
			this.image = img;
		else
			System.out.println("File type not accepted, .jpg or .png only");*/
		this.image = img;
		this.label = lbl;
		this.user = uploadUser;
		
	}//end Image
	
	public Boolean VerifyImage(String lbl) {//only accepts .jpg and .png THIS BROKEN***********************
		
		int startIndex = lbl.length()-4;
		Boolean isAccepted = false;
		
		//Check substring of final 4 indexes for .jpg or .png
		if (lbl.substring(startIndex, lbl.length()) == ".jpg" || lbl.substring(startIndex, lbl.length()) == ".PNG") {
			 isAccepted = true;
		}//end if
		
		return isAccepted;
		
	}//end VerifyImage

	@Override
	public String toString() {
		return "Image [addedOn=" + addedOn + ", image=" + image + ", label=" + label + ", user=" + user + "]";
	}

	public LocalDate getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(LocalDate addedOn) {
		this.addedOn = addedOn;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
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
