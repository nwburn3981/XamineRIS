package XamineRIS;

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
public class UIReferringDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtsearchPatientFirstName;
	private JTextField txtsearchPatientLastName;
	private JTextField txtsearchPatientDoB;
	private JTextField txtsearchPatientEmail;
	private JTextField txtviewOrderOrderId;
	private JTextField txtviewOrderFirstName;
	private JTextField txtviewOrderDateOfBirth;
	private JTextField txtviewOrderEmail;
	private JTextField txtnewPatientEMail;
	private JTextField txtnewPatientDoB;
	private JTextField txtnewPatientLastName;
	private JTextField txtnewPatientGender;
	private JTextField txtnewPatientPhoneNumber;
	private JTextField txtnewOrderLastName;
	private JTextField txtnewOrderDoB;
	private JTextField txtnewOrderEMail;
	private JTextField txtnewOrderFirstName;
	private static UIReferringDoctor frame;
	private User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UIReferringDoctor(user);
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
	public UIReferringDoctor(User user) {
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
		
		JLabel versionText = new JLabel("Doctor Portal");
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
		
		Label lblsearchPatientLastName = new Label("Last Name*");
		lblsearchPatientLastName.setBounds(28, 113, 74, 22);
		SearchPatientPanel.add(lblsearchPatientLastName);
		
		txtsearchPatientDoB = new JTextField();
		txtsearchPatientDoB.setText("YYYY-MM-DD");
		txtsearchPatientDoB.setBounds(106, 160, 164, 20);
		SearchPatientPanel.add(txtsearchPatientDoB);
		txtsearchPatientDoB.setColumns(10);
		
		Label lblsearchPatientDoB = new Label("Date of Birth*");
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
		
		JLabel searchPatientsResultsLabel = new JLabel("Search Results");
		searchPatientsResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchPatientsResultsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchPatientsResultsLabel.setBounds(520, 0, 120, 14);
		SearchPatientPanel.add(searchPatientsResultsLabel);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientId.setBounds(277, 30, 70, 14);
		SearchPatientPanel.add(lblPatientId);
		
		JLabel PatientIDLabel01 = new JLabel("1 ");
		PatientIDLabel01.setHorizontalAlignment(SwingConstants.CENTER);
		PatientIDLabel01.setBounds(289, 75, 48, 14);
		SearchPatientPanel.add(PatientIDLabel01);
		
		JLabel PatientIDLabel02 = new JLabel("1 ");
		PatientIDLabel02.setHorizontalAlignment(SwingConstants.CENTER);
		PatientIDLabel02.setBounds(289, 155, 48, 14);
		SearchPatientPanel.add(PatientIDLabel02);
		
		JLabel PatientIDLabel03 = new JLabel("1 ");
		PatientIDLabel03.setHorizontalAlignment(SwingConstants.CENTER);
		PatientIDLabel03.setBounds(289, 115, 48, 14);
		SearchPatientPanel.add(PatientIDLabel03);
		
		JLabel PatientIDLabel04 = new JLabel("1 ");
		PatientIDLabel04.setHorizontalAlignment(SwingConstants.CENTER);
		PatientIDLabel04.setBounds(289, 195, 48, 14);
		SearchPatientPanel.add(PatientIDLabel04);
		
		JLabel PatientIDLabel05 = new JLabel("1 ");
		PatientIDLabel05.setHorizontalAlignment(SwingConstants.CENTER);
		PatientIDLabel05.setBounds(289, 235, 48, 14);
		SearchPatientPanel.add(PatientIDLabel05);
		
		JLabel PatientFirstNameLabel01 = new JLabel("Patient First Name");
		PatientFirstNameLabel01.setHorizontalAlignment(SwingConstants.CENTER);
		PatientFirstNameLabel01.setBounds(347, 75, 108, 14);
		SearchPatientPanel.add(PatientFirstNameLabel01);
		
		JLabel PatientFirstNameLabel02 = new JLabel("Patient First Name");
		PatientFirstNameLabel02.setHorizontalAlignment(SwingConstants.CENTER);
		PatientFirstNameLabel02.setBounds(347, 115, 108, 14);
		SearchPatientPanel.add(PatientFirstNameLabel02);
		
		JLabel PatientFirstNameLabel03 = new JLabel("Patient First Name");
		PatientFirstNameLabel03.setHorizontalAlignment(SwingConstants.CENTER);
		PatientFirstNameLabel03.setBounds(347, 155, 108, 14);
		SearchPatientPanel.add(PatientFirstNameLabel03);
		
		JLabel PatientFirstNameLabel04 = new JLabel("Patient First Name");
		PatientFirstNameLabel04.setHorizontalAlignment(SwingConstants.CENTER);
		PatientFirstNameLabel04.setBounds(347, 195, 108, 14);
		SearchPatientPanel.add(PatientFirstNameLabel04);
		
		JLabel PatientFirstNameLabel05 = new JLabel("Patient First Name");
		PatientFirstNameLabel05.setHorizontalAlignment(SwingConstants.CENTER);
		PatientFirstNameLabel05.setBounds(347, 235, 108, 14);
		SearchPatientPanel.add(PatientFirstNameLabel05);
		
		JLabel PatientLastNameLabel01 = new JLabel("Patient Last Name");
		PatientLastNameLabel01.setHorizontalAlignment(SwingConstants.CENTER);
		PatientLastNameLabel01.setBounds(465, 75, 108, 14);
		SearchPatientPanel.add(PatientLastNameLabel01);
		
		JLabel PatientLastNameLabel02 = new JLabel("Patient Last Name");
		PatientLastNameLabel02.setHorizontalAlignment(SwingConstants.CENTER);
		PatientLastNameLabel02.setBounds(465, 115, 108, 14);
		SearchPatientPanel.add(PatientLastNameLabel02);
		
		JLabel PatientLastNameLabel03 = new JLabel("Patient Last Name");
		PatientLastNameLabel03.setHorizontalAlignment(SwingConstants.CENTER);
		PatientLastNameLabel03.setBounds(465, 155, 108, 14);
		SearchPatientPanel.add(PatientLastNameLabel03);
		
		JLabel PatientLastNameLabel04 = new JLabel("Patient Last Name");
		PatientLastNameLabel04.setHorizontalAlignment(SwingConstants.CENTER);
		PatientLastNameLabel04.setBounds(465, 195, 108, 14);
		SearchPatientPanel.add(PatientLastNameLabel04);
		
		JLabel PatientLastNameLabel05 = new JLabel("Patient Last Name");
		PatientLastNameLabel05.setHorizontalAlignment(SwingConstants.CENTER);
		PatientLastNameLabel05.setBounds(465, 235, 108, 14);
		SearchPatientPanel.add(PatientLastNameLabel05);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(347, 30, 108, 14);
		SearchPatientPanel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setBounds(465, 30, 108, 14);
		SearchPatientPanel.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfBirth.setBounds(573, 30, 108, 14);
		SearchPatientPanel.add(lblDateOfBirth);
		
		JLabel PatientDateOfBirth01 = new JLabel("Date of Birth");
		PatientDateOfBirth01.setHorizontalAlignment(SwingConstants.CENTER);
		PatientDateOfBirth01.setBounds(573, 75, 108, 14);
		SearchPatientPanel.add(PatientDateOfBirth01);
		
		JLabel PatientDateOfBirth02 = new JLabel("Date of Birth");
		PatientDateOfBirth02.setHorizontalAlignment(SwingConstants.CENTER);
		PatientDateOfBirth02.setBounds(573, 115, 108, 14);
		SearchPatientPanel.add(PatientDateOfBirth02);
		
		JLabel PatientDateOfBirth03 = new JLabel("Date of Birth");
		PatientDateOfBirth03.setHorizontalAlignment(SwingConstants.CENTER);
		PatientDateOfBirth03.setBounds(573, 155, 108, 14);
		SearchPatientPanel.add(PatientDateOfBirth03);
		
		JLabel PatientDateOfBirth04 = new JLabel("Date of Birth");
		PatientDateOfBirth04.setHorizontalAlignment(SwingConstants.CENTER);
		PatientDateOfBirth04.setBounds(573, 195, 108, 14);
		SearchPatientPanel.add(PatientDateOfBirth04);
		
		JLabel PatientDateOfBirth05 = new JLabel("Date of Birth");
		PatientDateOfBirth05.setHorizontalAlignment(SwingConstants.CENTER);
		PatientDateOfBirth05.setBounds(573, 235, 108, 14);
		SearchPatientPanel.add(PatientDateOfBirth05);
		
		JLabel lblSearchPatientEmail = new JLabel("E-Mail");
		lblSearchPatientEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchPatientEmail.setBounds(680, 30, 108, 14);
		SearchPatientPanel.add(lblSearchPatientEmail);
		
		JLabel PatientEmail01 = new JLabel("E-Mail");
		PatientEmail01.setHorizontalAlignment(SwingConstants.CENTER);
		PatientEmail01.setBounds(680, 75, 108, 14);
		SearchPatientPanel.add(PatientEmail01);
		
		JLabel PatientEmail02 = new JLabel("E-Mail");
		PatientEmail02.setHorizontalAlignment(SwingConstants.CENTER);
		PatientEmail02.setBounds(680, 115, 108, 14);
		SearchPatientPanel.add(PatientEmail02);
		
		JLabel PatientEmail03 = new JLabel("E-mail");
		PatientEmail03.setHorizontalAlignment(SwingConstants.CENTER);
		PatientEmail03.setBounds(680, 155, 108, 14);
		SearchPatientPanel.add(PatientEmail03);
		
		JLabel PatientEmail04 = new JLabel("E-Mail");
		PatientEmail04.setHorizontalAlignment(SwingConstants.CENTER);
		PatientEmail04.setBounds(680, 195, 108, 14);
		SearchPatientPanel.add(PatientEmail04);
		
		JLabel PatientEmail05 = new JLabel("E-Mail");
		PatientEmail05.setHorizontalAlignment(SwingConstants.CENTER);
		PatientEmail05.setBounds(680, 235, 108, 14);
		SearchPatientPanel.add(PatientEmail05);
		
		JButton btnPatientId01 = new JButton("Select ");
		btnPatientId01.setBounds(798, 75, 89, 20);
		SearchPatientPanel.add(btnPatientId01);
		
		JButton btnPatientId02 = new JButton("Select");
		btnPatientId02.setBounds(798, 111, 89, 20);
		SearchPatientPanel.add(btnPatientId02);
		
		JButton btnPatientId03 = new JButton("Select");
		btnPatientId03.setBounds(798, 151, 89, 20);
		SearchPatientPanel.add(btnPatientId03);
		
		JButton btnPatientId04 = new JButton("Order ID");
		btnPatientId04.setBounds(798, 191, 89, 20);
		SearchPatientPanel.add(btnPatientId04);
		
		JButton btnPatientId05 = new JButton("Order ID");
		btnPatientId05.setBounds(798, 231, 89, 20);
		SearchPatientPanel.add(btnPatientId05);
		
		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.setBounds(633, 301, 120, 23);
		SearchPatientPanel.add(btnNextPage);
		
		JButton btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.setBounds(465, 301, 120, 23);
		SearchPatientPanel.add(btnPreviousPage);
		
		
		// Panel to view/search all orders associtated to a patient 
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
		
		JLabel lblviewOrderLastName = new JLabel("Last Name*");
		lblviewOrderLastName.setBounds(27, 190, 75, 24);
		viewOpenOrdersPanel.add(lblviewOrderLastName);
		
		TextField txtviewOrderLastName = new TextField();
		txtviewOrderLastName.setBounds(138, 192, 129, 22);
		viewOpenOrdersPanel.add(txtviewOrderLastName);
		
		JLabel lblviewOrderDateOfBirth = new JLabel("Date Of Birth*");
		lblviewOrderDateOfBirth.setBounds(27, 247, 87, 14);
		viewOpenOrdersPanel.add(lblviewOrderDateOfBirth);
		
		txtviewOrderDateOfBirth = new JTextField();
		txtviewOrderDateOfBirth.setText("YYYY-MM-DD");
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
		
		JLabel searchOrderResultsLabel = new JLabel("Search Results");
		searchOrderResultsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchOrderResultsLabel.setBounds(573, 0, 100, 20);
		viewOpenOrdersPanel.add(searchOrderResultsLabel);
		
		JLabel lblOrderPatientId = new JLabel("Patient ID");
		lblOrderPatientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderPatientId.setBounds(277, 30, 70, 14);
		viewOpenOrdersPanel.add(lblOrderPatientId);
		
		JLabel OrderPatientIDLabel01 = new JLabel("1 ");
		OrderPatientIDLabel01.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientIDLabel01.setBounds(289, 75, 48, 14);
		viewOpenOrdersPanel.add(OrderPatientIDLabel01);
		
		JLabel OrderPatientIDLabel02 = new JLabel("1 ");
		OrderPatientIDLabel02.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientIDLabel02.setBounds(289, 155, 48, 14);
		viewOpenOrdersPanel.add(OrderPatientIDLabel02);
		
		JLabel OrderPatientIDLabel03 = new JLabel("1 ");
		OrderPatientIDLabel03.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientIDLabel03.setBounds(289, 115, 48, 14);
		viewOpenOrdersPanel.add(OrderPatientIDLabel03);
		
		JLabel OrderPatientIDLabel04 = new JLabel("1 ");
		OrderPatientIDLabel04.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientIDLabel04.setBounds(289, 195, 48, 14);
		viewOpenOrdersPanel.add(OrderPatientIDLabel04);
		
		JLabel OrderPatientIDLabel05 = new JLabel("1 ");
		OrderPatientIDLabel05.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientIDLabel05.setBounds(289, 235, 48, 14);
		viewOpenOrdersPanel.add(OrderPatientIDLabel05);
		
		JLabel OrderPatientFirstNameLabel01 = new JLabel("Patient First Name");
		OrderPatientFirstNameLabel01.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientFirstNameLabel01.setBounds(347, 75, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientFirstNameLabel01);
		
		JLabel OrderPatientFirstNameLabel02 = new JLabel("Patient First Name");
		OrderPatientFirstNameLabel02.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientFirstNameLabel02.setBounds(347, 115, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientFirstNameLabel02);
		
		JLabel OrderPatientFirstNameLabel03 = new JLabel("Patient First Name");
		OrderPatientFirstNameLabel03.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientFirstNameLabel03.setBounds(347, 155, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientFirstNameLabel03);
		
		JLabel OrderPatientFirstNameLabel04 = new JLabel("Patient First Name");
		OrderPatientFirstNameLabel04.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientFirstNameLabel04.setBounds(347, 195, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientFirstNameLabel04);
		
		JLabel OrderPatientFirstNameLabel05 = new JLabel("Patient First Name");
		OrderPatientFirstNameLabel05.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientFirstNameLabel05.setBounds(347, 235, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientFirstNameLabel05);
		
		JLabel OrderPatientLastNameLabel01 = new JLabel("Patient Last Name");
		OrderPatientLastNameLabel01.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientLastNameLabel01.setBounds(465, 75, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientLastNameLabel01);
		
		JLabel OrderPatientLastNameLabel02 = new JLabel("Patient Last Name");
		OrderPatientLastNameLabel02.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientLastNameLabel02.setBounds(465, 115, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientLastNameLabel02);
		
		JLabel OrderPatientLastNameLabel03 = new JLabel("Patient Last Name");
		OrderPatientLastNameLabel03.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientLastNameLabel03.setBounds(465, 155, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientLastNameLabel03);
		
		JLabel OrderPatientLastNameLabel04 = new JLabel("Patient Last Name");
		OrderPatientLastNameLabel04.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientLastNameLabel04.setBounds(465, 195, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientLastNameLabel04);
		
		JLabel OrderPatientLastNameLabel05 = new JLabel("Patient Last Name");
		OrderPatientLastNameLabel05.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientLastNameLabel05.setBounds(465, 235, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientLastNameLabel05);
		
		JLabel OrderlblFirstName = new JLabel("First Name");
		OrderlblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		OrderlblFirstName.setBounds(347, 30, 108, 14);
		viewOpenOrdersPanel.add(OrderlblFirstName);
		
		JLabel OrderlblLastName = new JLabel("Last Name");
		OrderlblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		OrderlblLastName.setBounds(465, 30, 108, 14);
		viewOpenOrdersPanel.add(OrderlblLastName);
		
		JLabel OrderlblDateOfBirth = new JLabel("Date of Birth");
		OrderlblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		OrderlblDateOfBirth.setBounds(573, 30, 108, 14);
		viewOpenOrdersPanel.add(OrderlblDateOfBirth);
		
		JLabel OrderPatientDateOfBirth01 = new JLabel("Date of Birth");
		OrderPatientDateOfBirth01.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientDateOfBirth01.setBounds(573, 75, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientDateOfBirth01);
		
		JLabel OrderPatientDateOfBirth02 = new JLabel("Date of Birth");
		OrderPatientDateOfBirth02.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientDateOfBirth02.setBounds(573, 115, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientDateOfBirth02);
		
		JLabel OrderPatientDateOfBirth03 = new JLabel("Date of Birth");
		OrderPatientDateOfBirth03.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientDateOfBirth03.setBounds(573, 155, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientDateOfBirth03);
		
		JLabel OrderPatientDateOfBirth04 = new JLabel("Date of Birth");
		OrderPatientDateOfBirth04.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientDateOfBirth04.setBounds(573, 195, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientDateOfBirth04);
		
		JLabel OrderPatientDateOfBirth05 = new JLabel("Date of Birth");
		OrderPatientDateOfBirth05.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientDateOfBirth05.setBounds(573, 235, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientDateOfBirth05);
		
		JLabel OrderlblOrderStatus = new JLabel("Order Status");
		OrderlblOrderStatus.setHorizontalAlignment(SwingConstants.CENTER);
		OrderlblOrderStatus.setBounds(680, 30, 108, 14);
		viewOpenOrdersPanel.add(OrderlblOrderStatus);
		
		JLabel OrderPatientOrderStatus01 = new JLabel("Order Status");
		OrderPatientOrderStatus01.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientOrderStatus01.setBounds(680, 75, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientOrderStatus01);
		
		JLabel OrderPatientOrderStatus02 = new JLabel("Order Status");
		OrderPatientOrderStatus02.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientOrderStatus02.setBounds(680, 115, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientOrderStatus02);
		
		JLabel OrderPatientOrderStatus03 = new JLabel("Order Status");
		OrderPatientOrderStatus03.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientOrderStatus03.setBounds(680, 155, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientOrderStatus03);
		
		JLabel OrderPatientOrderStatus04 = new JLabel("Order Status");
		OrderPatientOrderStatus04.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientOrderStatus04.setBounds(680, 195, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientOrderStatus04);
		
		JLabel OrderPatientOrderStatus05 = new JLabel("Order Status");
		OrderPatientOrderStatus05.setHorizontalAlignment(SwingConstants.CENTER);
		OrderPatientOrderStatus05.setBounds(680, 235, 108, 14);
		viewOpenOrdersPanel.add(OrderPatientOrderStatus05);
		
		JButton OrderbtnOrderId01 = new JButton("Order ID");
		OrderbtnOrderId01.setBounds(798, 75, 89, 20);
		viewOpenOrdersPanel.add(OrderbtnOrderId01);
		
		JButton OrderbtnOrderId02 = new JButton("Order ID");
		OrderbtnOrderId02.setBounds(798, 111, 89, 20);
		viewOpenOrdersPanel.add(OrderbtnOrderId02);
		
		JButton OrderbtnOrderId03 = new JButton("Order ID");
		OrderbtnOrderId03.setBounds(798, 151, 89, 20);
		viewOpenOrdersPanel.add(OrderbtnOrderId03);
		
		JButton OrderbtnOrderId04 = new JButton("Order ID");
		OrderbtnOrderId04.setBounds(798, 191, 89, 20);
		viewOpenOrdersPanel.add(OrderbtnOrderId04);
		
		JButton OrderbtnOrderId05 = new JButton("Order ID");
		OrderbtnOrderId05.setBounds(798, 231, 89, 20);
		viewOpenOrdersPanel.add(OrderbtnOrderId05);
		
		JButton OrderbtnNextPage = new JButton("Next Page");
		OrderbtnNextPage.setBounds(633, 301, 120, 23);
		viewOpenOrdersPanel.add(OrderbtnNextPage);
		
		JButton OrderbtnPreviousPage = new JButton("Previous Page");
		OrderbtnPreviousPage.setBounds(465, 301, 120, 23);
		viewOpenOrdersPanel.add(OrderbtnPreviousPage);
		
		
		// Panel to create a new Patient 
		Panel newPatientPanel = new Panel();
		newPatientPanel.setBounds(255, 33, 913, 420);
		newPatientPanel.setLayout(null);
		
		JLabel lblNewPatient = new JLabel("New Patient Information ");
		lblNewPatient.setBounds(46, 11, 179, 14);
		newPatientPanel.add(lblNewPatient);
		
		JLabel NewPatinetFirstName = new JLabel("First Name **");
		NewPatinetFirstName.setBounds(46, 66, 79, 14);
		newPatientPanel.add(NewPatinetFirstName);
		
		Label NewPatientLastName = new Label("Last Name **");
		NewPatientLastName.setBounds(46, 100, 79, 22);
		newPatientPanel.add(NewPatientLastName);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date of Birth **");
		lblDateOfBirth_1.setBounds(46, 148, 99, 14);
		newPatientPanel.add(lblDateOfBirth_1);
		
		JLabel lblEmail = new JLabel("E-Mail **");
		lblEmail.setBounds(46, 196, 48, 14);
		newPatientPanel.add(lblEmail);
		
		txtnewPatientEMail = new JTextField();
		txtnewPatientEMail.setBounds(155, 193, 128, 20);
		newPatientPanel.add(txtnewPatientEMail);
		txtnewPatientEMail.setColumns(10);
		
		txtnewPatientDoB = new JTextField();
		txtnewPatientDoB.setBounds(155, 145, 128, 20);
		newPatientPanel.add(txtnewPatientDoB);
		txtnewPatientDoB.setColumns(10);
		
		txtnewPatientLastName = new JTextField();
		txtnewPatientLastName.setBounds(155, 102, 128, 20);
		newPatientPanel.add(txtnewPatientLastName);
		txtnewPatientLastName.setColumns(10);
		
		TextField txtnewPatientFirstName = new TextField();
		txtnewPatientFirstName.setBounds(155, 58, 128, 22);
		newPatientPanel.add(txtnewPatientFirstName);
		
		Label lblnewPatientGender = new Label("Preferred Gender");
		lblnewPatientGender.setBounds(42, 236, 103, 22);
		newPatientPanel.add(lblnewPatientGender);
		
		txtnewPatientGender = new JTextField();
		txtnewPatientGender.setBounds(155, 238, 128, 20);
		newPatientPanel.add(txtnewPatientGender);
		txtnewPatientGender.setColumns(10);
		
		JLabel lblnewPatientPhoneNumber = new JLabel("Phone Number");
		lblnewPatientPhoneNumber.setBounds(46, 292, 99, 14);
		newPatientPanel.add(lblnewPatientPhoneNumber);
		
		txtnewPatientPhoneNumber = new JTextField();
		txtnewPatientPhoneNumber.setBounds(155, 289, 128, 20);
		newPatientPanel.add(txtnewPatientPhoneNumber);
		txtnewPatientPhoneNumber.setColumns(10);
		
		JLabel lblnewPatientAllergies = new JLabel("Allergies");
		lblnewPatientAllergies.setBounds(394, 11, 148, 14);
		newPatientPanel.add(lblnewPatientAllergies);
		
		JLabel lblPatientNotes = new JLabel("Patient Notes");
		lblPatientNotes.setBounds(707, 11, 196, 14);
		newPatientPanel.add(lblPatientNotes);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(602, 45, 283, 276);
		newPatientPanel.add(textArea);
		
		JRadioButton rdbtnnewPatientLatex = new JRadioButton("Latex");
		rdbtnnewPatientLatex.setBounds(394, 62, 109, 23);
		newPatientPanel.add(rdbtnnewPatientLatex);
		
		JRadioButton rdbtnnewPatientMridye = new JRadioButton("Mridye");
		rdbtnnewPatientMridye.setBounds(394, 99, 109, 23);
		newPatientPanel.add(rdbtnnewPatientMridye);
		
		JRadioButton rdbtnnewPatientAsthma = new JRadioButton("Asthma");
		rdbtnnewPatientAsthma.setBounds(394, 139, 109, 23);
		newPatientPanel.add(rdbtnnewPatientAsthma);
		
		JRadioButton rdbtnnewPatientXrayDye = new JRadioButton("X-Ray Dye");
		rdbtnnewPatientXrayDye.setBounds(394, 180, 109, 23);
		newPatientPanel.add(rdbtnnewPatientXrayDye);
		
		JLabel lblRequiredFields = new JLabel("** required fields");
		lblRequiredFields.setBounds(46, 27, 128, 14);
		newPatientPanel.add(lblRequiredFields);
		
		JButton btnCreateNewPatient = new JButton("Create New Patient");
		btnCreateNewPatient.setBounds(380, 347, 179, 23);
		newPatientPanel.add(btnCreateNewPatient);
		
		
		// panel to create a new order 
		JPanel newOrderPanel = new JPanel();
		newOrderPanel.setBounds(255, 33, 913, 420);
		newOrderPanel.setLayout(null);
				
		JLabel lblSelectThePatient = new JLabel("First Select a Patient");
		lblSelectThePatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectThePatient.setBounds(43, 63, 150, 20);
		newOrderPanel.add(lblSelectThePatient);
				
		JTextArea newOrderReasonForVisit = new JTextArea();
		newOrderReasonForVisit.setLineWrap(true);
		newOrderReasonForVisit.setBounds(620, 66, 283, 284);
		newOrderPanel.add(newOrderReasonForVisit);
				
		JLabel lblReasonForDoctor = new JLabel("Reason For Doctor Visit");
		lblReasonForDoctor.setBounds(708, 33, 139, 14);
		newOrderPanel.add(lblReasonForDoctor);
				
		JLabel lblImagingRequired = new JLabel("Imaging Required");
		lblImagingRequired.setBounds(389, 33, 116, 14);
		newOrderPanel.add(lblImagingRequired);
				
		JLabel lblnewOrder = new JLabel("Create a New Order");
		lblnewOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblnewOrder.setBounds(43, 33, 143, 14);
		newOrderPanel.add(lblnewOrder);
				
		JLabel lblCurrentPatient = new JLabel("Current patient displayed here");
		lblCurrentPatient.setBounds(10, 351, 181, 14);
		actionPanel.add(lblCurrentPatient);
				
		JTextArea txtimagesneeded = new JTextArea();
		txtimagesneeded.setLineWrap(true);
		txtimagesneeded.setBounds(294, 66, 283, 284);
		newOrderPanel.add(txtimagesneeded);
				
		Button buttoncreateorder = new Button("Create Order");
		buttoncreateorder.setBounds(560, 388, 80, 22);
		newOrderPanel.add(buttoncreateorder);
		
		JLabel lblSelectedPatient = new JLabel("Selected Patient:");
		lblSelectedPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectedPatient.setBounds(43, 172, 150, 14);
		newOrderPanel.add(lblSelectedPatient);
		
		JLabel lblNewOrderName = new JLabel("First Name:");
		lblNewOrderName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewOrderName.setBounds(0, 200, 78, 14);
		newOrderPanel.add(lblNewOrderName);
		
		JLabel lblNeworderdob = new JLabel("Date of Birth:");
		lblNeworderdob.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNeworderdob.setBounds(0, 260, 78, 14);
		newOrderPanel.add(lblNeworderdob);
		
		JLabel lblNewOrderLastName = new JLabel("Last Name:");
		lblNewOrderLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewOrderLastName.setBounds(0, 230, 78, 14);
		newOrderPanel.add(lblNewOrderLastName);
		
		JLabel lblNewOrderEmail = new JLabel("Email:");
		lblNewOrderEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewOrderEmail.setBounds(0, 290, 78, 14);
		newOrderPanel.add(lblNewOrderEmail);
		
		JLabel lblNewOrderPatietFirstName = new JLabel("First Name:");
		lblNewOrderPatietFirstName.setBounds(88, 200, 150, 14);
		newOrderPanel.add(lblNewOrderPatietFirstName);
		
		JLabel lblNewOrderPatientLastName = new JLabel("Last Name:");
		lblNewOrderPatientLastName.setBounds(88, 230, 150, 14);
		newOrderPanel.add(lblNewOrderPatientLastName);
		
		JLabel lblNewOrderPatientDoB = new JLabel("Date of Birth:");
		lblNewOrderPatientDoB.setBounds(88, 260, 150, 14);
		newOrderPanel.add(lblNewOrderPatientDoB);
		
		JLabel lblNewOrderPatientEmail = new JLabel("Email:");
		lblNewOrderPatientEmail.setBounds(88, 290, 150, 14);
		newOrderPanel.add(lblNewOrderPatientEmail);

		
		
		
		JButton newPatient = new JButton("New Patient");
		newPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subActionPanel.remove(SearchPatientPanel);
				subActionPanel.remove(viewOpenOrdersPanel);
				subActionPanel.remove(newOrderPanel);
				subActionPanel.add(newPatientPanel);
			}
		});
		newPatient.setBounds(10, 96, 203, 23);
		actionPanel.add(newPatient);
		
		JButton viewOrdersButton = new JButton("View Open Orders");
		viewOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subActionPanel.remove(SearchPatientPanel);
				subActionPanel.remove(newPatientPanel);
				subActionPanel.remove(newOrderPanel);
				subActionPanel.add(viewOpenOrdersPanel);
				
			}
		});
		viewOrdersButton.setBounds(10, 62, 203, 23);
		actionPanel.add(viewOrdersButton);
		
		JButton searchPatient = new JButton("Search Patients");
		searchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subActionPanel.remove(viewOpenOrdersPanel);
				subActionPanel.remove(newPatientPanel);
				subActionPanel.remove(newOrderPanel);
				subActionPanel.add(SearchPatientPanel);
				
			}
		});
		searchPatient.setBounds(10, 28, 203, 23);
		actionPanel.add(searchPatient);
		
		JButton newOrder = new JButton("New Order");
		newOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subActionPanel.remove(viewOpenOrdersPanel);
				subActionPanel.remove(newPatientPanel);
				subActionPanel.remove(SearchPatientPanel);
				subActionPanel.add(newOrderPanel);
				
			}
		});
		newOrder.setBounds(10, 130, 203, 23);
		actionPanel.add(newOrder);
		
		
		JButton newpatientbutton = new JButton("New Patient");
		newpatientbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subActionPanel.remove(SearchPatientPanel);
				subActionPanel.remove(viewOpenOrdersPanel);
				subActionPanel.remove(newOrderPanel);
				subActionPanel.add(newPatientPanel);
			}
		});
		newpatientbutton.setBounds(43, 128, 150, 23);
		newOrderPanel.add(newpatientbutton);
		
		JButton newSelectPatient = new JButton("Search for Patient");
		newSelectPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subActionPanel.remove(viewOpenOrdersPanel);
				subActionPanel.remove(newPatientPanel);
				subActionPanel.remove(newOrderPanel);
				subActionPanel.add(SearchPatientPanel);
			}
		});
		newSelectPatient.setBounds(43, 94, 150, 23);
		newOrderPanel.add(newSelectPatient);
	
		//subActionPanel.remove(newPatientPanel);
		//subActionPanel.remove(SearchPatientPanel);
		//subActionPanel.add(newOrderPanel);
		//subActionPanel.add(viewOpenOrdersPanel);
	}
}
