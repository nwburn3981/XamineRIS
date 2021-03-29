

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JList;
import java.awt.List;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Choice;

//Nick's changes, added static frame for added logout functionality, added User parameter for displaying username, *******
public class UIReceptionist extends JFrame {

	private JPanel contentPane;
	private JTextField txtsearchPatientFirstName;
	private JTextField txtsearchPatientLastName;
	private JTextField txtsearchPatientDoB;
	private JTextField txtsearchPatientEmail;
	private JTextField txtviewOrderOrderId;
	private JTextField txtviewOrderFirstName;
	private JTextField txtviewOrderDateOfBirth;
	private JTextField txtviewOrderEmail;
	private static UIReceptionist frame;
	private User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UIReceptionist(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIReceptionist(User user) {
		currentUser = user;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1204, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel statusBar = new JPanel();
		statusBar.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		statusBar.setBounds(0, 0, 1178, 25);
		getContentPane().add(statusBar);
		statusBar.setLayout(null);
		
		JLabel versionText = new JLabel("Receptionist Portal");
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
		
		//JLabel nameSpace = new JLabel(currentUser.getFirstName() + " " + currentUser.getLastName());
		//nameSpace.setHorizontalAlignment(SwingConstants.CENTER);
		//nameSpace.setBounds(384, 4, 265, 14);
		//statusBar.add(nameSpace);
		
		JButton notifyButton = new JButton("Notifications");
		notifyButton.setBounds(928, 3, 105, 20);
		statusBar.add(notifyButton);
		
		JPanel subActionPanel = new JPanel();
		subActionPanel.setLayout(null);
		subActionPanel.setBounds(10, 248, 239, 214);
		getContentPane().add(subActionPanel);
		
		JPanel actionPanel = new JPanel();
		subActionPanel.add(actionPanel);
		actionPanel.setBounds(10, 33, 239, 420);
		actionPanel.setLayout(null);
		
		
		// the first panel that is added when the search patient button is clicked 
		// The receptionsit can use this interface to look up patients that come in 
		// ideally searching for a patient shows all schduled and unschduled orders 
		
		Panel SearchPatientPanel = new Panel();
		SearchPatientPanel.setBounds(255, 33, 913, 420);
		SearchPatientPanel.setLayout(null);
		
		txtsearchPatientFirstName = new JTextField();
		txtsearchPatientFirstName.setBounds(106, 74, 164, 20);
		SearchPatientPanel.add(txtsearchPatientFirstName);
		txtsearchPatientFirstName.setColumns(10);
		
		Label lblsearchPatientFirstName = new Label("First Name ");
		lblsearchPatientFirstName.setBounds(28, 72, 62, 22);
		SearchPatientPanel.add(lblsearchPatientFirstName);
		
		txtsearchPatientLastName = new JTextField();
		txtsearchPatientLastName.setBounds(106, 115, 164, 20);
		SearchPatientPanel.add(txtsearchPatientLastName);
		txtsearchPatientLastName.setColumns(10);
		
		Label lblsearchPatientLastName = new Label("Last Name");
		lblsearchPatientLastName.setBounds(28, 113, 74, 22);
		SearchPatientPanel.add(lblsearchPatientLastName);
		
		txtsearchPatientDoB = new JTextField();
		txtsearchPatientDoB.setBounds(106, 160, 164, 20);
		SearchPatientPanel.add(txtsearchPatientDoB);
		txtsearchPatientDoB.setColumns(10);
		
		Label lblsearchPatientDoB = new Label("Date of Birth");
		lblsearchPatientDoB.setBounds(28, 158, 74, 22);
		SearchPatientPanel.add(lblsearchPatientDoB);
		
		txtsearchPatientEmail = new JTextField();
		txtsearchPatientEmail.setBounds(106, 210, 164, 20);
		SearchPatientPanel.add(txtsearchPatientEmail);
		txtsearchPatientEmail.setColumns(10);
		
		Label lblsearchPatientEmail = new Label("E-mail");
		lblsearchPatientEmail.setBounds(28, 208, 74, 22);
		SearchPatientPanel.add(lblsearchPatientEmail);
		
		JButton searchPatientSearchButton = new JButton("Search");
		searchPatientSearchButton.setBounds(141, 269, 89, 23);
		SearchPatientPanel.add(searchPatientSearchButton);
		
		JLabel searchPatientinstructionsLabel = new JLabel("Patient Information");
		searchPatientinstructionsLabel.setBounds(125, 26, 134, 14);
		SearchPatientPanel.add(searchPatientinstructionsLabel);
		
		List searchPatientlist = new List();
		searchPatientlist.setBounds(422, 74, 430, 156);
		SearchPatientPanel.add(searchPatientlist);
		
		JLabel searchPatientsResultsLabel = new JLabel("Search Results");
		searchPatientsResultsLabel.setBounds(596, 26, 89, 14);
		SearchPatientPanel.add(searchPatientsResultsLabel);
		
		
		
		// Second panel that allows the receptionist to view open orders 
		// the receptionist can search for orders and ideally add a date to the orders that lack a date 
		Panel viewOpenOrdersPanel = new Panel();
		viewOpenOrdersPanel.setBounds(255, 33, 913, 420);
		viewOpenOrdersPanel.setLayout(null);
		
		JLabel lblviewOrderInfo = new JLabel("Order Information");
		lblviewOrderInfo.setBounds(93, 35, 148, 14);
		viewOpenOrdersPanel.add(lblviewOrderInfo);
		
		JLabel lblviewOrderOrderIdNumber = new JLabel("Order ID Number");
		lblviewOrderOrderIdNumber.setBounds(27, 70, 101, 14);
		viewOpenOrdersPanel.add(lblviewOrderOrderIdNumber);
		
		txtviewOrderOrderId = new JTextField();
		txtviewOrderOrderId.setBounds(138, 67, 129, 20);
		viewOpenOrdersPanel.add(txtviewOrderOrderId);
		txtviewOrderOrderId.setColumns(10);
		
		JLabel lblviewOrderPatient = new JLabel("Patient Information");
		lblviewOrderPatient.setBounds(93, 108, 148, 14);
		viewOpenOrdersPanel.add(lblviewOrderPatient);
		
		JLabel lblviewOrderFirstName = new JLabel("First Name");
		lblviewOrderFirstName.setBounds(27, 146, 75, 14);
		viewOpenOrdersPanel.add(lblviewOrderFirstName);
		
		txtviewOrderFirstName = new JTextField();
		txtviewOrderFirstName.setBounds(138, 143, 129, 20);
		viewOpenOrdersPanel.add(txtviewOrderFirstName);
		txtviewOrderFirstName.setColumns(10);
		
		JLabel lblviewOrderLastName = new JLabel("Last Name");
		lblviewOrderLastName.setBounds(27, 190, 75, 24);
		viewOpenOrdersPanel.add(lblviewOrderLastName);
		
		TextField txtviewOrderLastName = new TextField();
		txtviewOrderLastName.setBounds(138, 192, 129, 22);
		viewOpenOrdersPanel.add(txtviewOrderLastName);
		
		JLabel lblviewOrderDateOfBirth = new JLabel("Date Of Birth");
		lblviewOrderDateOfBirth.setBounds(27, 247, 87, 14);
		viewOpenOrdersPanel.add(lblviewOrderDateOfBirth);
		
		txtviewOrderDateOfBirth = new JTextField();
		txtviewOrderDateOfBirth.setBounds(138, 244, 129, 20);
		viewOpenOrdersPanel.add(txtviewOrderDateOfBirth);
		txtviewOrderDateOfBirth.setColumns(10);
		
		txtviewOrderEmail = new JTextField();
		txtviewOrderEmail.setBounds(138, 304, 129, 20);
		viewOpenOrdersPanel.add(txtviewOrderEmail);
		txtviewOrderEmail.setColumns(10);
		
		JLabel lblviewOrderEMail = new JLabel("E mail");
		lblviewOrderEMail.setBounds(27, 307, 75, 14);
		viewOpenOrdersPanel.add(lblviewOrderEMail);
		
		List searchOrderlist = new List();
		searchOrderlist.setBounds(422, 74, 430, 156);
		viewOpenOrdersPanel.add(searchOrderlist);
		
		JLabel searchOrderResultsLabel = new JLabel("Search Results");
		searchOrderResultsLabel.setBounds(596, 26, 89, 14);
		viewOpenOrdersPanel.add(searchOrderResultsLabel);

		
		// panel for checking in a patient. use choice boxes to select an open technician, modality / equipment / room
		// Ideally this panel is called when an appointment is selected from "Todays Appointment" and uses the order and patient 
		// object to send to this panel to be sent to the proper equipment IE checking in. 
		
		JPanel CheckinPanel = new JPanel();
		CheckinPanel.setBounds(255, 33, 913, 420);
		CheckinPanel.setLayout(null);
		
		JLabel lblAppointmentCheckin = new JLabel("Appointment Check-In: ");
		lblAppointmentCheckin.setBounds(29, 11, 139, 14);
		CheckinPanel.add(lblAppointmentCheckin);
		
		JLabel lblCurrentPatient = new JLabel("Current patient + Appointment time displayed here ");
		lblCurrentPatient.setBounds(172, 11, 315, 14);
		CheckinPanel.add(lblCurrentPatient);
		
		JLabel lblAvailableRooms = new JLabel("Select a Room: ");
		lblAvailableRooms.setBounds(65, 70, 82, 14);
		CheckinPanel.add(lblAvailableRooms);
		
		Choice selectRoom = new Choice();
		selectRoom.setBounds(159, 70, 118, 20);
		CheckinPanel.add(selectRoom);
		
		JLabel lblSelectATechnician = new JLabel("Select a Technician Team:");
		lblSelectATechnician.setBounds(10, 109, 139, 14);
		CheckinPanel.add(lblSelectATechnician);
		
		Choice selectTeam = new Choice();
		selectTeam.setBounds(157, 109, 120, 20);
		CheckinPanel.add(selectTeam);
		
		JLabel lblSelectEquipment = new JLabel("Select Equipment:");
		lblSelectEquipment.setBounds(51, 150, 104, 14);
		CheckinPanel.add(lblSelectEquipment);
		
		Choice choice = new Choice();
		choice.setBounds(157, 151, 120, 20);
		CheckinPanel.add(choice);
		
		JButton todaysAppointments = new JButton("Today's Appointments");
		todaysAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		todaysAppointments.setBounds(10, 96, 203, 23);
		actionPanel.add(todaysAppointments);
		
		JButton viewOrdersButton = new JButton("View Open Orders");
		viewOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subActionPanel.remove(SearchPatientPanel);	
				subActionPanel.remove(CheckinPanel);
				subActionPanel.add(viewOpenOrdersPanel) ;
			}
		});
		viewOrdersButton.setBounds(10, 62, 203, 23);
		actionPanel.add(viewOrdersButton);
		
		JButton searchPatient = new JButton("Search Patients");
		searchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				subActionPanel.remove(viewOpenOrdersPanel) ;
				subActionPanel.remove(CheckinPanel);
				subActionPanel.add(SearchPatientPanel);	
			}
		});
		searchPatient.setBounds(10, 28, 203, 23);
		actionPanel.add(searchPatient);
		
		JButton newOrder = new JButton("Unscheduled orders");
		newOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		newOrder.setBounds(10, 130, 203, 23);
		actionPanel.add(newOrder);
		
		JButton btnCheckIn = new JButton("Appointment Check-in");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subActionPanel.remove(SearchPatientPanel);	
				subActionPanel.remove(viewOpenOrdersPanel) ;
				subActionPanel.add(CheckinPanel);
			}
		});
		btnCheckIn.setBounds(10, 164, 203, 23);
		actionPanel.add(btnCheckIn);

		
	}
}
