package XamineRIS;

import java.awt.BorderLayout;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIReferringDoctor frame = new UIReferringDoctor();
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
	public UIReferringDoctor() {
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
		
		JLabel versionText = new JLabel("Xamine V.2382777");
		versionText.setBounds(0, 0, 125, 23);
		statusBar.add(versionText);
		versionText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.setBounds(1043, 3, 125, 20);
		statusBar.add(logoutButton);
		
		JLabel nameSpace = new JLabel("Username");
		nameSpace.setHorizontalAlignment(SwingConstants.CENTER);
		nameSpace.setBounds(384, 4, 75, 14);
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
		actionPanel.setBounds(10, 33, 239, 293);
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
		
		
		JPanel newOrderPanel = new JPanel();
		newOrderPanel.setBounds(255, 33, 913, 420);
		newOrderPanel.setLayout(null);
		
		JLabel lblSelectThePatient = new JLabel("Select the Patient");
		lblSelectThePatient.setBounds(75, 33, 96, 14);
		newOrderPanel.add(lblSelectThePatient);
		
		JLabel lblnewOrderFirstName = new JLabel("First Name");
		lblnewOrderFirstName.setBounds(33, 66, 72, 14);
		newOrderPanel.add(lblnewOrderFirstName);
		
		JLabel lblnewOrderLastName = new JLabel("Last Name");
		lblnewOrderLastName.setBounds(33, 91, 72, 14);
		newOrderPanel.add(lblnewOrderLastName);
		
		JLabel lblnewOrderDateOfBirth = new JLabel("Date of Birth ");
		lblnewOrderDateOfBirth.setBounds(33, 116, 96, 14);
		newOrderPanel.add(lblnewOrderDateOfBirth);
		
		JLabel lblnewOrderEmail = new JLabel("E-Mail");
		lblnewOrderEmail.setBounds(33, 141, 72, 14);
		newOrderPanel.add(lblnewOrderEmail);
		
		txtnewOrderLastName = new JTextField();
		txtnewOrderLastName.setBounds(111, 88, 96, 20);
		newOrderPanel.add(txtnewOrderLastName);
		txtnewOrderLastName.setColumns(10);
		
		txtnewOrderDoB = new JTextField();
		txtnewOrderDoB.setBounds(111, 116, 96, 20);
		newOrderPanel.add(txtnewOrderDoB);
		txtnewOrderDoB.setColumns(10);
		
		txtnewOrderEMail = new JTextField();
		txtnewOrderEMail.setBounds(111, 147, 96, 20);
		newOrderPanel.add(txtnewOrderEMail);
		txtnewOrderEMail.setColumns(10);
		
		txtnewOrderFirstName = new JTextField();
		txtnewOrderFirstName.setBounds(111, 58, 96, 20);
		newOrderPanel.add(txtnewOrderFirstName);
		txtnewOrderFirstName.setColumns(10);
		
		JButton btnnewOrderSearch = new JButton("Search");
		btnnewOrderSearch.setBounds(82, 178, 89, 23);
		newOrderPanel.add(btnnewOrderSearch);
		
		Choice newOrderPatientChoice = new Choice();
		newOrderPatientChoice.setBounds(33, 221, 174, 20);
		newOrderPanel.add(newOrderPatientChoice);
		
		JTextArea newOrderReasonForVisit = new JTextArea();
		newOrderReasonForVisit.setLineWrap(true);
		newOrderReasonForVisit.setBounds(620, 61, 283, 205);
		newOrderPanel.add(newOrderReasonForVisit);
		
		JLabel lblReasonForDoctor = new JLabel("Reason For Doctor Visit");
		lblReasonForDoctor.setBounds(708, 33, 139, 14);
		newOrderPanel.add(lblReasonForDoctor);
		
		JLabel lblModalityRequired = new JLabel("Modality Required ");
		lblModalityRequired.setBounds(266, 33, 109, 14);
		newOrderPanel.add(lblModalityRequired);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(256, 54, 109, 23);
		newOrderPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(256, 82, 109, 23);
		newOrderPanel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(256, 112, 109, 23);
		newOrderPanel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBounds(256, 137, 109, 23);
		newOrderPanel.add(rdbtnNewRadioButton_3);
		
		JLabel lblImagingRequired = new JLabel("Imaging Required");
		lblImagingRequired.setBounds(447, 33, 116, 14);
		newOrderPanel.add(lblImagingRequired);
		
		JLabel lblnewOrder = new JLabel("Create a New Order");
		lblnewOrder.setBounds(33, 0, 143, 14);
		newOrderPanel.add(lblnewOrder);
		

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
		
		
		//subActionPanel.add(newOrderPanel);
		
		
	}
}
