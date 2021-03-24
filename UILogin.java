import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class UILogin extends JFrame {

	/** TODO
	 * Need to figure out how to close window
	 * Need to fix password char array to deal with blank indexes
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField usernameIn;
	private JPasswordField passwordIn;
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	private User user5;
	private UILogin window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UILogin window = new UILogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UILogin() {
		
		//Test permissions
		Permission doctor = new Permission("ReferringDr");
		Permission receptionist = new Permission("Receptionist");
		Permission tech = new Permission("Technician");
		Permission radio = new Permission("Radiologist");
		Permission superUser = new Permission("SuperUser");
		//Test users
		user1 = new User("Jeff", "Doctorman", "jDoctorman@ung.edu", "jdoctor01");
		user2 = new User("Polly", "Techson", "pTechson@ung.edu", "ptechson01");
		user3 = new User("Ted", "Recep", "tRecep@ung.edu", "trecep01");
		user4 = new User("Innis", "Raddon", "iRaddon@ung.edu", "iraddon01");
		user5 = new User("Pa", "Super", "pSuper@ung.edu", "psuper01");
		
		user1.setPassword("password");
		user1.setUserPermission(doctor);
		user2.setPassword("password");
		user2.setUserPermission(tech);
		user3.setPassword("password");
		user3.setUserPermission(receptionist);
		user4.setPassword("password");
		user4.setUserPermission(radio);
		user5.setPassword("password");
		user5.setUserPermission(superUser);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 375, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(25, 100, 117, 23);
		frame.getContentPane().add(usernameLabel);
		
		usernameIn = new JTextField();
		usernameIn.setBounds(180, 100, 143, 20);
		frame.getContentPane().add(usernameIn);
		usernameIn.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(25, 150, 117, 23);
		frame.getContentPane().add(passwordLabel);
		
		JButton logInButton = new JButton("Log in");
		logInButton.setBounds(125, 215, 89, 23);
		frame.getContentPane().add(logInButton);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		statusPanel.setBounds(0, 0, 359, 25);
		frame.getContentPane().add(statusPanel);
		statusPanel.setLayout(null);
		
		JLabel versionLabel = new JLabel("Xamine V.2382777");
		versionLabel.setBounds(0, 0, 125, 23);
		statusPanel.add(versionLabel);
		versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		passwordIn = new JPasswordField(10);
		passwordIn.setBounds(180, 151, 143, 20);
		frame.getContentPane().add(passwordIn);
		
		
		JLabel testLabel = new JLabel("New label");
		testLabel.setBounds(50, 267, 216, 14);
		frame.getContentPane().add(testLabel);
		
		ActionListener loginListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent login) {
				String usernameValue = usernameIn.getText();
				char[] passwordValue = new char[8];
				passwordValue = passwordIn.getPassword();
				int permissionLvl = 6;//Set to 6 since this permission does not exist
				
				if(usernameValue.equals(user1.getUserName()) && Arrays.equals(passwordValue, user1.getPassword())) {
					
					permissionLvl = user1.getUserPermission().getAccessLvl();
				}
				
				else if(usernameValue.equals(user2.getUserName()) && Arrays.equals(passwordValue, user2.getPassword())) {
					
					permissionLvl = user2.getUserPermission().getAccessLvl();
				}
				
				else if(usernameValue.equals(user3.getUserName()) && Arrays.equals(passwordValue, user3.getPassword())) {
					
					permissionLvl = user3.getUserPermission().getAccessLvl();
				}

				else if(usernameValue.equals(user4.getUserName()) && Arrays.equals(passwordValue, user4.getPassword())) {
	
					permissionLvl = user4.getUserPermission().getAccessLvl();
				}
				
				else if(usernameValue.equals(user5.getUserName()) && Arrays.equals(passwordValue, user5.getPassword())) {
	
					permissionLvl = user5.getUserPermission().getAccessLvl();
				}
				
				else {
						testLabel.setText(String.valueOf(permissionLvl));
				}
				
				
				switch(permissionLvl) {
				case 0:{
					UISuperUser.main(null);
					testLabel.setText(String.valueOf(permissionLvl));
					frame.dispose();
					break;
				}
				case 1:{
					UIReferringDoctor.main(null);
					frame.dispose();
					break;
				}
				case 2:{
					//Receptionist here
					testLabel.setText("Should go to Receptionist");
					break;
				}
				case 3:{
					UITechnician.main(user2);
					frame.dispose();
					break;
				}
				case 4:{
					//Radiologist
					testLabel.setText("Should go to Radiologist");
					break;
					
				}
				
				}
			}
			
			
		};
		
		logInButton.addActionListener(loginListener);
	}

	protected void close() {
		// TODO Auto-generated method stub
		window.close();
	}
}
