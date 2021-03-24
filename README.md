# Xamine_Hub
Base Xamine repository

Username and Passwords for testing

SuperUser Username:psuper01 
Doctor Username: jdoctor01
Receptionist: trecep01
Technician: ptechson01
Radiologist: iraddon01

All passwords are: password (super duper secure)

Here is the code for the logout button just to save everyone time

		ActionListener logoutListener = new ActionListener() {

			public void actionPerformed(ActionEvent click) {
				
				UILogin.main(null);
				frame.dispose();	
			}
		};
			
		logoutButton.addActionListener(logoutListener);
