import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import java.awt.Font;

//ToDO
//Password stuff, gonna wait for SQL
//Add a setTeam function

public class UISuperUser extends JFrame {

	private JFrame frame;

	protected ArrayList<JRadioButton> buttonTracker = new ArrayList<JRadioButton>();
	protected ArrayList<User> userTracker = new ArrayList<User>();
	protected ArrayList<User> userList = new ArrayList<User>();
	
	private JPanel viewPanel;
	private JPanel actionPanel;
	private JPanel subActionPanel;
	
	private JButton addUserButton;
	private JButton homeButton;
	private JButton editUserButton;
	private JButton removeUserButton;
	
	private ActionListener actionPanelListener;
	private ActionListener subActionPanelListener;
	private ActionListener radioListener;
	
	ButtonGroup radioButtonGroup;
	
	private Permission doctor;
	private Permission receptionist;
	private Permission tech;
	private Permission radio;
	private Permission superUser;
	
	private User currentUser;
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	private User user5;
	private User userTransfer;
	
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField userIDTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JLabel Userlbl;
	private JLabel UserOut;
	private JLabel fname;
	private JLabel fnameOut;
	private JLabel lname;
	private JLabel lnameOut;
	private JLabel email;
	private JLabel emailOut;
	private JLabel username;
	private JLabel usernameOut;
	private JLabel password;
	private JLabel passwordOut;
	private JLabel userIDlbl;
	private JLabel fnamelbl;
	private JLabel lnamelbl;
	private JLabel emaillbl;
	private JLabel usernamelbl;
	private JLabel passwordlbl;
	private JLabel perlbl;
	private JTextField userIDOut;
	private JTextField fnameoutlbl;
	private JTextField lnameoutlbl;
	private JTextField emailoutlbl;
	private JTextField usernameoutlbl;
	private JTextField passwordoutlbl;
	/**
	 * Launch the application.
	 */
	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UISuperUser window = new UISuperUser(user);
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
	public UISuperUser(User user) {
		currentUser = user;
		
		//Test permissions
		doctor = new Permission("ReferringDr");
		receptionist = new Permission("Receptionist");
		tech = new Permission("Technician");
		radio = new Permission("Radiologist");
		superUser = new Permission("SuperUser");
		//Test users
		user1 = new User("Jeff", "Doctorman", "jDoctorman@ung.edu", "jdoctor01");
		user2 = new User("Polly", "Techson", "pTechson@ung.edu", "ptechson01");
		user3 = new User("Ted", "Recep", "tRecep@ung.edu", "trecep01");
		user4 = new User("Innis", "Raddon", "iRaddon@ung.edu", "iraddon01");
		user5 = new User("Pa", "Super", "pSuper@ung.edu", "psuper01");
		
		user1.setPassword("password");
		user1.setUserPermission(doctor);
		user1.setUserId("001");
		user2.setPassword("password");
		user2.setUserPermission(tech);
		user2.setUserId("002");
		user3.setPassword("password");
		user3.setUserPermission(receptionist);
		user3.setUserId("003");
		user4.setPassword("password");
		user4.setUserPermission(radio);
		user4.setUserId("004");
		user5.setPassword("password");
		user5.setUserPermission(superUser);
		user5.setUserId("005");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		
		initialize();
		InitializeListeners();
		GenerateUsers();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1204, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel statusBar = new JPanel();
		statusBar.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		statusBar.setBounds(0, 0, 1178, 25);
		frame.getContentPane().add(statusBar);
		statusBar.setLayout(null);
		
		JLabel versionText = new JLabel("Admin Portal");
		versionText.setBounds(0, 0, 125, 23);
		statusBar.add(versionText);
		versionText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.setBounds(1043, 3, 125, 20);
		statusBar.add(logoutButton);
		
		ActionListener logoutListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent click) {
				
				UILogin.main(null);
				frame.dispose();
				
			}
		};
			
		logoutButton.addActionListener(logoutListener);
		
		JLabel nameSpace = new JLabel(currentUser.getFirstName() + " " + currentUser.getLastName());
		nameSpace.setHorizontalAlignment(SwingConstants.CENTER);
		nameSpace.setBounds(384, 4, 265, 14);
		statusBar.add(nameSpace);

		actionPanel = new JPanel();
		actionPanel.setBounds(10, 37, 239, 212);
		frame.getContentPane().add(actionPanel);
		actionPanel.setLayout(null);
		
		addUserButton = new JButton("Add User");
		addUserButton.setBounds(10, 115, 219, 37);
		actionPanel.add(addUserButton);		
		
		homeButton = new JButton("Home");
		homeButton.setBounds(10, 50, 219, 37);
		actionPanel.add(homeButton);
		
		viewPanel = new JPanel();
		viewPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		viewPanel.setBounds(259, 36, 919, 426);
		frame.getContentPane().add(viewPanel);
		viewPanel.setLayout(null);		

		//Button group for all generated radio buttons
		radioButtonGroup = new ButtonGroup(); 
		
		subActionPanel = new JPanel();
		subActionPanel.setLayout(null);
		subActionPanel.setBounds(10, 250, 239, 212);
		frame.getContentPane().add(subActionPanel);
		
	}
	
	private void InitializeListeners() {
		
		//First Listener for radio button selection, selecting a radio button for either orders or appointments will generate a "Details" button along with details listener
		 radioListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent selection) {
				
				Object selected = selection.getSource();
				int selectedIndex = buttonTracker.indexOf(selected);
				userTransfer = userTracker.get(selectedIndex);
				
				JButton detailsButton = new JButton("Details");
				detailsButton.setBounds(10, 30, 219, 37);
				subActionPanel.add(detailsButton);
				subActionPanel.repaint();
				subActionPanel.revalidate();
				
				ActionListener detailListener = new ActionListener() {
					
					public void actionPerformed(ActionEvent click) {
						
						viewUser(userTransfer);
					}//end Action
				};//end detailListener
				
				detailsButton.addActionListener(detailListener);
			}//end Action
		};//end radioListener
		
		actionPanelListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent click) {
				
				if(click.getSource() == homeButton) {
					GenerateUsers();
				}//end if
				
				if(click.getSource() == addUserButton) {
					AddUsers();
				}//end if
				
			}//end Action
		};//end actionPanelListener
		
		homeButton.addActionListener(actionPanelListener);
		addUserButton.addActionListener(actionPanelListener);
		
		subActionPanelListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent click) {
				
				if (click.getSource() == editUserButton) {
					EditUser(userTransfer);
				}//end if
				
				if (click.getSource() == removeUserButton) {
					DeleteUser(userTransfer);
				}//end if
				
			}//end Action
			
		};//end subActionPanelListener
		
	}//end InitializeListeners
	
	private void GenerateUsers() {
	//Setup Users radio list on portal generation and Home Button click
					
					subActionPanel.removeAll();
					viewPanel.removeAll();
					
					buttonTracker.clear();					
					userTracker.clear();
					
					int yValue = 10;
					int xValue = 20;					
					
					//fills out view panel with radio buttons for each order that has not been completed.
					for(int i = 0; i < userList.size(); i++) {
						
						JRadioButton userRdButton = new JRadioButton("UserID: " + userList.get(i).getUserId() + " - " + userList.get(i).getFirstName() + " " + userList.get(i).getLastName());
						userRdButton.setBounds(xValue, yValue, 250, 15);
						viewPanel.add(userRdButton);
						userRdButton.addActionListener(radioListener);
						radioButtonGroup.add(userRdButton);
						
						buttonTracker.add(userRdButton);
						userTracker.add(userList.get(i));
						
					}//end for
					
					subActionPanel.repaint();
					subActionPanel.revalidate();
					viewPanel.repaint();
					viewPanel.revalidate();

		
	}//end GenerateUsers
	
	private void viewUser(User user) {
		
		subActionPanel.removeAll();
		viewPanel.removeAll();
		
		JLabel userIDLabel = new JLabel("User ID: ");
		userIDLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		userIDLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		userIDLabel.setBounds(315, 50, 100, 24);
		viewPanel.add(userIDLabel);
		
		JLabel userIDCurrentLabel = new JLabel(user.getUserId());
		userIDCurrentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		userIDCurrentLabel.setBounds(485, 50, 100, 24);
		viewPanel.add(userIDCurrentLabel);
		
		JLabel firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstNameLabel.setBounds(315, 100, 100, 24);
		viewPanel.add(firstNameLabel);
		
		JLabel firstNameCurrentLabel= new JLabel(user.getFirstName());
		firstNameCurrentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstNameCurrentLabel.setBounds(485, 100, 100, 24);
		viewPanel.add(firstNameCurrentLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name: ");
		lastNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastNameLabel.setBounds(315, 146, 100, 24);
		viewPanel.add(lastNameLabel);
		
		JLabel lastNameCurrentLabel = new JLabel(user.getLastName());
		lastNameCurrentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastNameCurrentLabel.setBounds(485, 146, 100, 24);
		viewPanel.add(lastNameCurrentLabel);
		
		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailLabel.setBounds(315, 191, 100, 24);
		viewPanel.add(emailLabel);
		
		JLabel emailCurrentLabel = new JLabel(user.getEmail());
		emailCurrentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailCurrentLabel.setBounds(485, 191, 100, 24);
		viewPanel.add(emailCurrentLabel);
		
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameLabel.setBounds(315, 240, 100, 24);
		viewPanel.add(usernameLabel);
		
		JLabel usernameCurrentLabel = new JLabel(user.getUserName());
		usernameCurrentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameCurrentLabel.setBounds(485, 240, 100, 24);
		viewPanel.add(usernameCurrentLabel);
		
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLabel.setBounds(315, 286, 100, 24);
		viewPanel.add(passwordLabel);
		
		JLabel passwordCurrentLabel = new JLabel("Hidden");
		passwordCurrentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordCurrentLabel.setBounds(485, 286, 100, 24);
		viewPanel.add(passwordCurrentLabel);
		
		editUserButton = new JButton("Edit User");
		editUserButton.setBounds(10, 30, 219, 37);
		subActionPanel.add(editUserButton);
		editUserButton.addActionListener(subActionPanelListener);
		
		removeUserButton = new JButton("Remove User");
		removeUserButton.setBounds(10, 90, 219, 37);
		subActionPanel.add(removeUserButton);
		removeUserButton.addActionListener(subActionPanelListener);
		
		subActionPanel.repaint();
		subActionPanel.revalidate();
		viewPanel.repaint();
		viewPanel.revalidate();
	}//end viewUser
	
	private void AddUsers() {
		
		subActionPanel.removeAll();
		viewPanel.removeAll();
		
		JLabel userIDLabel = new JLabel("User ID:");
		userIDLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		userIDLabel.setBounds(80, 50, 100, 23);
		viewPanel.add(userIDlbl);
		
		userIDTextField = new JTextField();
		userIDTextField.setBounds(173, 53, 201, 20);
		viewPanel.add(userIDTextField);
		userIDTextField.setColumns(10);
		
		JLabel permissionLabel = new JLabel("Permission:");
		permissionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		permissionLabel.setBounds(587, 50, 100, 23);
		viewPanel.add(permissionLabel);
		
		JRadioButton refDrRdButton = new JRadioButton("01 Referring Doctor");
		refDrRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		refDrRdButton.setBounds(677, 52, 201, 23);
		viewPanel.add(refDrRdButton);
		
		JRadioButton recepRdButton = new JRadioButton("02 Receptionist");
		recepRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		recepRdButton.setBounds(677, 99, 201, 23);
		viewPanel.add(recepRdButton);
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstNameLabel.setBounds(80, 98, 100, 23);
		viewPanel.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(173, 101, 201, 20);
		viewPanel.add(firstNameTextField);
		
		JRadioButton techRdButton = new JRadioButton("03 Technician");
		techRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		techRdButton.setBounds(677, 146, 201, 23);
		viewPanel.add(techRdButton);
		
		JRadioButton radRdButton = new JRadioButton("04 Radiologist");
		radRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radRdButton.setBounds(677, 182, 201, 23);
		viewPanel.add(radRdButton);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastNameLabel.setBounds(80, 132, 100, 23);
		viewPanel.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(173, 135, 201, 20);
		viewPanel.add(lastNameTextField);
		
		JRadioButton supRdButton = new JRadioButton("05 Super User");
		supRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		supRdButton.setBounds(677, 222, 201, 23);
		viewPanel.add(supRdButton);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailLabel.setBounds(80, 181, 100, 23);
		viewPanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(173, 184, 201, 20);
		viewPanel.add(emailTextField);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameLabel.setBounds(80, 240, 100, 23);
		viewPanel.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(173, 243, 201, 20);
		viewPanel.add(usernameTextField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLabel.setBounds(80, 294, 100, 23);
		viewPanel.add(passwordLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(173, 297, 201, 20);
		viewPanel.add(passwordTextField);
		
		JButton submitButton = new JButton("Submit Changes");
		submitButton.setBounds(626, 296, 252, 23);
		viewPanel.add(submitButton);
		
		ActionListener submitNewButton = new ActionListener() {
			
			public void actionPerformed (ActionEvent click) {
				
				User newUser = new User(firstNameTextField.getText(), lastNameTextField.getText(), emailTextField.getText(), usernameTextField.getText());
				newUser.setPassword(passwordTextField.getText());
				newUser.setUserId(userIDTextField.getText());
				
				if(radioButtonGroup.getSelection() == refDrRdButton)
					newUser.setUserPermission(doctor);
				else if(radioButtonGroup.getSelection() == recepRdButton)
					newUser.setUserPermission(receptionist);
				else if(radioButtonGroup.getSelection() == techRdButton)
					newUser.setUserPermission(tech);
				else if(radioButtonGroup.getSelection() == radRdButton)
					newUser.setUserPermission(radio);
				else if(radioButtonGroup.getSelection() == supRdButton)
					newUser.setUserPermission(superUser);
				
				userList.add(newUser);
				GenerateUsers();
				
			}//end Action
			
		};//end submitNewListener
		
		submitButton.addActionListener(submitNewButton);
		
		subActionPanel.repaint();
		subActionPanel.revalidate();
		viewPanel.repaint();
		viewPanel.revalidate();

		
		
	}//end AddUsers
	
	private void EditUser(User user) {
		
		String permission = user.getUserPermission().getProgramName();
		
		subActionPanel.removeAll();
		viewPanel.removeAll();
		
		JLabel userIDLabel = new JLabel("User ID:");
		userIDLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		userIDLabel.setBounds(80, 50, 100, 23);
		viewPanel.add(userIDlbl);
		
		userIDTextField = new JTextField();
		userIDTextField.setBounds(173, 53, 201, 20);
		viewPanel.add(userIDTextField);
		userIDTextField.setColumns(10);
		
		JLabel permissionLabel = new JLabel("Permission:");
		permissionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		permissionLabel.setBounds(587, 50, 100, 23);
		viewPanel.add(permissionLabel);
		
		JRadioButton refDrRdButton = new JRadioButton("01 Referring Doctor");
		refDrRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		refDrRdButton.setBounds(677, 52, 201, 23);
		viewPanel.add(refDrRdButton);
		
		JRadioButton recepRdButton = new JRadioButton("02 Receptionist");
		recepRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		recepRdButton.setBounds(677, 99, 201, 23);
		viewPanel.add(recepRdButton);
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstNameLabel.setBounds(80, 98, 100, 23);
		viewPanel.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(173, 101, 201, 20);
		viewPanel.add(firstNameTextField);
		
		JRadioButton techRdButton = new JRadioButton("03 Technician");
		techRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		techRdButton.setBounds(677, 146, 201, 23);
		viewPanel.add(techRdButton);
		
		JRadioButton radRdButton = new JRadioButton("04 Radiologist");
		radRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radRdButton.setBounds(677, 182, 201, 23);
		viewPanel.add(radRdButton);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastNameLabel.setBounds(80, 132, 100, 23);
		viewPanel.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(173, 135, 201, 20);
		viewPanel.add(lastNameTextField);
		
		JRadioButton supRdButton = new JRadioButton("05 Super User");
		supRdButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		supRdButton.setBounds(677, 222, 201, 23);
		viewPanel.add(supRdButton);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailLabel.setBounds(80, 181, 100, 23);
		viewPanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(173, 184, 201, 20);
		viewPanel.add(emailTextField);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameLabel.setBounds(80, 240, 100, 23);
		viewPanel.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(173, 243, 201, 20);
		viewPanel.add(usernameTextField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordLabel.setBounds(80, 294, 100, 23);
		viewPanel.add(passwordLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(173, 297, 201, 20);
		viewPanel.add(passwordTextField);
		
		
		//Makes sure proper permission is selected on view generation
		switch(permission) {
		case "ReferringDr":{
			refDrRdButton.setSelected(true);
			break;
		}
		case "Receptionist":{
			recepRdButton.setSelected(true);
			break;
		}
		case "Technician":{
			techRdButton.setSelected(true);
			break;
		}
		case "Radiologist":{
			radRdButton.setSelected(true);
			break;
		}
		case "SuperUser":{
			supRdButton.setSelected(true);
			break;
		}
		}//end switch

		
		JButton submitButton = new JButton("Submit Changes");
		submitButton.setBounds(626, 296, 252, 23);
		viewPanel.add(submitButton);
		
		ActionListener submitEditListener = new ActionListener() {
			
			public void actionPerformed (ActionEvent click) {
				
				user.setFirstName(firstNameTextField.getText());
				user.setLastName(lastNameTextField.getText());
				user.setEmail(emailTextField.getText());
				user.setUserName(usernameTextField.getText());
				user.setPassword(passwordTextField.getText());
				user.setUserId(userIDTextField.getText());
				
				if(radioButtonGroup.getSelection() == refDrRdButton)
					user.setUserPermission(doctor);
				else if(radioButtonGroup.getSelection() == recepRdButton)
					user.setUserPermission(receptionist);
				else if(radioButtonGroup.getSelection() == techRdButton)
					user.setUserPermission(tech);
				else if(radioButtonGroup.getSelection() == radRdButton)
					user.setUserPermission(radio);
				else if(radioButtonGroup.getSelection() == supRdButton)
					user.setUserPermission(superUser);
				
				GenerateUsers();
				
			}//end Action
			
		};//end submitNewListener
		
		submitButton.addActionListener(submitEditListener);
		
		subActionPanel.repaint();
		subActionPanel.revalidate();
		viewPanel.repaint();
		viewPanel.revalidate();
		
	}//end EditUser
	
	private void DeleteUser(User user) {
		
		//Removes user after asking for confirmation
		int index = userList.indexOf(user);
		userList.remove(index);
		GenerateUsers();
	}//end DeleteUser
}
