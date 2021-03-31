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

//ToDO
//Password stuff, gonna wait for SQL

public class UISuperUser extends JFrame {

	private JFrame frame;
	private User currentUser;
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
		viewPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(16dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(104dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(124dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(117dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		

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
					
					int yValue = 2;
					int xCorrection = 0;
					String buttonXCoordinate = "";
					String buttonYCoordinate =String.valueOf(yValue);
					
					
					//fills out view panel with radio buttons for each order that has not been completed.
					for(int i = 0; i < userList.size(); i++) {
						
						JRadioButton userRdButton = new JRadioButton("UserID: " + userList.get(i).getUserId() + " - " + userList.get(i).getFirstName() + " " + userList.get(i).getLastName());
						buttonXCoordinate = String.valueOf(((i+1)*2)-xCorrection);
						viewPanel.add(userRdButton, buttonYCoordinate + ", " + buttonXCoordinate);
						userRdButton.addActionListener(radioListener);
						radioButtonGroup.add(userRdButton);
						
						buttonTracker.add(userRdButton);
						userTracker.add(userList.get(i));
						
						//This if statement iterates to the next column once the current one is filled to avoid out of bounds errors.
						if (((i+1)*2)%10 == 0) {
							yValue += 2;
							xCorrection += 10;
							buttonYCoordinate =String.valueOf(yValue);	
						}//end if
						
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
		viewPanel.add(userIDLabel, "8, 6, right, default");
		
		JLabel userIDCurrentLabel = new JLabel(user.getUserId());
		viewPanel.add(userIDCurrentLabel, "10, 6, fill, default");
		
		JLabel firstNameLabel = new JLabel("First Name: ");
		viewPanel.add(firstNameLabel, "8, 10, right, default");
		
		JLabel firstNameCurrentLabel= new JLabel(user.getFirstName());
		viewPanel.add(firstNameCurrentLabel, "10, 10, fill, default");
		
		JLabel lastNameLabel = new JLabel("Last Name: ");
		viewPanel.add(lastNameLabel, "8, 14, right, default");
		
		JLabel lastNameCurrentLabel = new JLabel(user.getLastName());
		viewPanel.add(lastNameCurrentLabel, "10, 14, fill, default");
		
		JLabel emailLabel = new JLabel("Email: ");
		viewPanel.add(emailLabel, "8, 18, right, default");
		
		JLabel emailCurrentLabel = new JLabel(user.getEmail());
		viewPanel.add(emailCurrentLabel, "10, 18, fill, default");
		
		JLabel usernameLabel = new JLabel("Username: ");
		viewPanel.add(usernameLabel, "8, 22");
		
		JLabel usernameCurrentLabel = new JLabel(user.getUserName());
		viewPanel.add(usernameCurrentLabel, "10, 22, fill, default");
		
		JLabel passwordLabel = new JLabel("Password: ");
		viewPanel.add(passwordLabel, "8, 26, right, default");
		
		JLabel passwordCurrentLabel = new JLabel("Hidden");
		viewPanel.add(passwordCurrentLabel, "10, 26, fill, default");
		
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
		viewPanel.add(userIDLabel, "8, 6, right, default");
		
		userIDTextField = new JTextField();
		viewPanel.add(userIDTextField, "10, 6, fill, default");
		userIDTextField.setColumns(10);
		
		JLabel permissionLabel = new JLabel("Permission:");
		viewPanel.add(permissionLabel, "26, 6, right, default");
		
		JRadioButton refDrRdButton = new JRadioButton("01 Referring Doctor");
		viewPanel.add(refDrRdButton, "30, 6");
		
		JRadioButton recepRdButton = new JRadioButton("02 Receptionist");
		viewPanel.add(recepRdButton, "30, 8");
		
		JLabel firstNameLabel = new JLabel("First Name:");
		viewPanel.add(firstNameLabel, "8, 10, right, default");
		
		firstNameTextField = new JTextField();
		viewPanel.add(firstNameTextField, "10, 10, fill, default");
		firstNameTextField.setColumns(10);
		
		JRadioButton techRdButton = new JRadioButton("03 Technician");
		viewPanel.add(techRdButton, "30, 10");
		
		JRadioButton radRdButton = new JRadioButton("04 Radiologist");
		viewPanel.add(radRdButton, "30, 12");
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		viewPanel.add(lastNameLabel, "8, 14, right, default");
		
		lastNameTextField = new JTextField();
		viewPanel.add(lastNameTextField, "10, 14, fill, default");
		lastNameTextField.setColumns(10);
		
		JRadioButton supRdButton = new JRadioButton("05 Super User");
		viewPanel.add(supRdButton, "30, 14");
		
		JLabel emailLabel = new JLabel("Email:");
		viewPanel.add(emailLabel, "8, 18, right, default");
		
		emailTextField = new JTextField();
		viewPanel.add(emailTextField, "10, 18, fill, default");
		emailTextField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username:");
		viewPanel.add(usernameLabel, "8, 22");
		
		usernameTextField = new JTextField();
		viewPanel.add(usernameTextField, "10, 22, fill, default");
		usernameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		viewPanel.add(passwordLabel, "8, 26, right, default");
		
		passwordTextField = new JTextField();
		viewPanel.add(passwordTextField, "10, 26, fill, default");
		passwordTextField.setColumns(10);
		
		JButton submitButton = new JButton("Submit Changes");
		viewPanel.add(submitButton, "30, 22");
		
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
		viewPanel.add(userIDLabel, "8, 6, right, default");
		
		userIDTextField = new JTextField();
		viewPanel.add(userIDTextField, "10, 6, fill, default");
		userIDTextField.setColumns(10);
		userIDTextField.setText(user.getUserId());
		
		JLabel permissionLabel = new JLabel("Permission:");
		viewPanel.add(permissionLabel, "26, 6, right, default");
		
		JRadioButton refDrRdButton = new JRadioButton("01 Referring Doctor");
		viewPanel.add(refDrRdButton, "30, 6");
		
		JRadioButton recepRdButton = new JRadioButton("02 Receptionist");
		viewPanel.add(recepRdButton, "30, 8");
		
		JLabel firstNameLabel = new JLabel("First Name:");
		viewPanel.add(firstNameLabel, "8, 10, right, default");
		
		firstNameTextField = new JTextField();
		viewPanel.add(firstNameTextField, "10, 10, fill, default");
		firstNameTextField.setColumns(10);
		firstNameTextField.setText(user.getFirstName());
		
		JRadioButton techRdButton = new JRadioButton("03 Technician");
		viewPanel.add(techRdButton, "30, 10");
		
		JRadioButton radRdButton = new JRadioButton("04 Radiologist");
		viewPanel.add(radRdButton, "30, 12");
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		viewPanel.add(lastNameLabel, "8, 14, right, default");
		
		lastNameTextField = new JTextField();
		viewPanel.add(lastNameTextField, "10, 14, fill, default");
		lastNameTextField.setColumns(10);
		lastNameTextField.setText(user.getLastName());
		
		JRadioButton supRdButton = new JRadioButton("05 Super User");
		viewPanel.add(supRdButton, "30, 14");
		
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

		
		JLabel emailLabel = new JLabel("Email:");
		viewPanel.add(emailLabel, "8, 18, right, default");
		
		emailTextField = new JTextField();
		viewPanel.add(emailTextField, "10, 18, fill, default");
		emailTextField.setColumns(10);
		emailTextField.setText(user.getEmail());
		
		JLabel usernameLabel = new JLabel("Username:");
		viewPanel.add(usernameLabel, "8, 22");
		
		usernameTextField = new JTextField();
		viewPanel.add(usernameTextField, "10, 22, fill, default");
		usernameTextField.setColumns(10);
		usernameTextField.setText(user.getUserName());
		
		JLabel passwordLabel = new JLabel("Password:");
		viewPanel.add(passwordLabel, "8, 26, right, default");
		
		passwordTextField = new JTextField();
		viewPanel.add(passwordTextField, "10, 26, fill, default");
		passwordTextField.setColumns(10);
		
		JButton submitButton = new JButton("Submit Changes");
		viewPanel.add(submitButton, "30, 22");
		
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
