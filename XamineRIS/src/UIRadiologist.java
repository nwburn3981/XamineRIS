

/*import java.awt.BorderLayout;
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
public class UIRadiologist extends JFrame {

	private JPanel contentPane;
	private static UIRadiologist frame;
	//private User currentUser;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UIRadiologist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public UIRadiologist() {
		//currentUser = user;
		
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
		
		// un-comment this when testing login feature with a user object 
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
		
		

		JButton newPatient = new JButton("New Patient");
		newPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		newPatient.setBounds(10, 96, 203, 23);
		actionPanel.add(newPatient);
		
		JButton viewOrdersButton = new JButton("View Open Orders");
		viewOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		viewOrdersButton.setBounds(10, 62, 203, 23);
		actionPanel.add(viewOrdersButton);
		
		JButton searchPatient = new JButton("Search Patients");
		searchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		searchPatient.setBounds(10, 28, 203, 23);
		actionPanel.add(searchPatient);
		
		JButton newOrder = new JButton("New Order");
		newOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		newOrder.setBounds(10, 130, 203, 23);
		actionPanel.add(newOrder);
		
	}
}
	
	
*/



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

//Nick's changes, added static frame for added logout functionality, added User parameter for displaying username, *******
public class UIRadiologist extends JFrame {

	private JPanel contentPane;
	private static UIRadiologist frame;
	//private User currentUser;
	
	
	
	
	
	

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
					frame = new UIRadiologist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public UIRadiologist() {
		//currentUser = user;
		
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
				
				//UILogin.main(null);
				frame.dispose();	
			}
		};
			
		logoutButton.addActionListener(logoutListener);
		
		// un-comment this when testing login feature with a user object 
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
		
		
		
		
		Panel SearchPatientPanel = new Panel();
		SearchPatientPanel.setBounds(255, 33, 1000, 420);
		SearchPatientPanel.setLayout(null);
		
		
		

		
		txtsearchPatientFirstName = new JTextField();
		txtsearchPatientFirstName.setBounds(125, 74, 164, 20);
		SearchPatientPanel.add(txtsearchPatientFirstName);
		txtsearchPatientFirstName.setColumns(10);
		
		Label lblsearchPatientFirstName = new Label("First Name ");
		lblsearchPatientFirstName.setBounds(15, 72, 74, 22);
		SearchPatientPanel.add(lblsearchPatientFirstName);
		txtsearchPatientFirstName.setColumns(10);
		
		
		
		
		txtsearchPatientLastName = new JTextField();
		txtsearchPatientLastName.setBounds(125, 115, 164, 20);
		SearchPatientPanel.add(txtsearchPatientLastName);
		txtsearchPatientLastName.setColumns(10);
		
		Label lblsearchPatientLastName = new Label("Last Name ");
		lblsearchPatientLastName.setBounds(15, 113, 74, 22);
		SearchPatientPanel.add(lblsearchPatientLastName);
		txtsearchPatientFirstName.setColumns(10);
		
		
	
		Label lblsearchPatientDoB = new Label("Date of Birth*");
		lblsearchPatientDoB.setBounds(15, 155, 95, 22);
		SearchPatientPanel.add(lblsearchPatientDoB);
		
		
		
		txtsearchPatientDoB = new JTextField();
		txtsearchPatientDoB.setText("YYYY-MM-DD");
		txtsearchPatientDoB.setBounds(125, 160, 164, 20);
		SearchPatientPanel.add(txtsearchPatientDoB);
		txtsearchPatientDoB.setColumns(10);
		
		
		txtsearchPatientLastName = new JTextField();
		txtsearchPatientLastName.setBounds(125, 115, 164, 20);
		SearchPatientPanel.add(txtsearchPatientLastName);
		txtsearchPatientLastName.setColumns(10);
		
		
	
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(49,269,89,23);
		SearchPatientPanel.add(addButton);
		
	
		
		JButton retrieveButton = new JButton("Retrieve");
		retrieveButton.setBounds(141, 269, 89, 23);
		SearchPatientPanel.add(retrieveButton);
		
		
		
		JButton saveButton = new JButton ("Save ");
		saveButton.setBounds(233,269,89,23);
		SearchPatientPanel.add(saveButton);
		

		JButton submitOrder = new JButton("Submit ");
		submitOrder.setBounds(323, 269, 89, 23);
		SearchPatientPanel.add(submitOrder);
		
		JButton Searchbutton1 = new JButton("Search");
		Searchbutton1.setBounds(92, 213, 257, 23);
		SearchPatientPanel.add(Searchbutton1);
		
		
		
		
		//---------------------------------------------------------------
		
		
		
		Panel viewOrdersButtonPanel = new Panel();
		viewOrdersButtonPanel.setBounds(255, 33, 913, 420);
		viewOrdersButtonPanel.setLayout(null);
		
		
		
		
		JLabel lblviewOrderInfo = new JLabel("Order Information");
		lblviewOrderInfo.setBounds(93, 35, 148, 14);
		viewOrdersButtonPanel.add(lblviewOrderInfo);
		
		JLabel lblviewOrderOrderIdNumber = new JLabel("Order ID Number");
		lblviewOrderOrderIdNumber.setBounds(15, 70, 130, 14);
		viewOrdersButtonPanel.add(lblviewOrderOrderIdNumber);
		
		txtviewOrderOrderId = new JTextField();
		txtviewOrderOrderId.setBounds(138, 67, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderOrderId);
		txtviewOrderOrderId.setColumns(10);
		
		JLabel lblviewOrderPatient = new JLabel("Patient Information");
		lblviewOrderPatient.setBounds(93, 108, 148, 14);
		viewOrdersButtonPanel.add(lblviewOrderPatient);
		
		JLabel lblviewOrderFirstName = new JLabel("First Name");
		lblviewOrderFirstName.setBounds(15, 146, 75, 14);
		viewOrdersButtonPanel.add(lblviewOrderFirstName);
		
		
		txtviewOrderFirstName = new JTextField();
		txtviewOrderFirstName.setBounds(138, 143, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderFirstName);
		txtviewOrderFirstName.setColumns(10);

		
		JLabel lblviewOrderLastName = new JLabel("Last Name");
		lblviewOrderLastName.setBounds(15, 190, 75, 24);
		viewOrdersButtonPanel.add(lblviewOrderLastName);
		
		TextField txtviewOrderLastName = new TextField();
		txtviewOrderLastName.setBounds(138, 192, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderLastName);
		
		JLabel lblviewOrderDateOfBirth = new JLabel("Date Of Birth");
		lblviewOrderDateOfBirth.setBounds(15, 247, 87, 14);
		viewOrdersButtonPanel.add(lblviewOrderDateOfBirth);
		
		txtviewOrderDateOfBirth = new JTextField();
		txtviewOrderDateOfBirth.setText("YYYY-MM-DD");
		txtviewOrderDateOfBirth.setBounds(138, 244, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderDateOfBirth);
		txtviewOrderDateOfBirth.setColumns(10);
		
		
		JButton Searchbutton = new JButton("Search");
		Searchbutton.setBounds(85, 300, 257, 23);
		viewOrdersButtonPanel.add(Searchbutton);
		
		
		
		
		//---------------------------------------------------
		
		
		
		Panel newPatientPanel = new Panel();
		newPatientPanel.setBounds(255, 33, 913, 420);
		newPatientPanel.setLayout(null);
		
		
		
		JLabel lblNewPatient = new JLabel("New Patient Information ");
		lblNewPatient.setBounds(15, 11, 179, 14);
		newPatientPanel.add(lblNewPatient);
		
		JLabel NewPatinetFirstName = new JLabel("First Name ");
		NewPatinetFirstName.setBounds(15, 66, 89, 14);
		newPatientPanel.add(NewPatinetFirstName);
		
		Label NewPatientLastName = new Label("Last Name ");
		NewPatientLastName.setBounds(15, 100, 89, 22);
		newPatientPanel.add(NewPatientLastName);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date of Birth ");
		lblDateOfBirth_1.setBounds(15, 148, 99, 14);
		newPatientPanel.add(lblDateOfBirth_1);
		
		JLabel lblEmail = new JLabel("E-Mail ");
		lblEmail.setBounds(15, 196, 89, 14);
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
		
		
		

		JButton newPatient = new JButton("New Patient");
		newPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				subActionPanel.add(newPatientPanel);
				subActionPanel.remove(SearchPatientPanel);
				subActionPanel.remove(viewOrdersButtonPanel);
				
				
				
				
				
				
				
			}
		});
		newPatient.setBounds(10, 96, 203, 23);
		actionPanel.add(newPatient);
		
		JButton viewOrdersButton = new JButton("View Open Orders");
		viewOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				subActionPanel.add(viewOrdersButtonPanel);
				subActionPanel.remove(SearchPatientPanel);
				subActionPanel.remove(newPatientPanel);
				
				
				
				
				
			}
		});
		viewOrdersButton.setBounds(10, 62, 203, 23);
		actionPanel.add(viewOrdersButton);
		
		JButton searchPatient = new JButton("Search Patients");
		searchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
		
				subActionPanel.add(SearchPatientPanel);
				subActionPanel.remove(viewOrdersButtonPanel);
				subActionPanel.remove(newPatientPanel);
				
				
			}
		});
		searchPatient.setBounds(10, 28, 203, 23);
		actionPanel.add(searchPatient);
		
		
				
		

}
}






















--------------------------------------------------------------------------------------------------
	
	
					//2nd GUI
	
	
	
	
	
	
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

//Nick's changes, added static frame for added logout functionality, added User parameter for displaying username, *******
public class UIRadiologist extends JFrame {

	private JPanel contentPane;
	private static UIRadiologist frame;
	//private User currentUser;
	
	
	
	
	
	

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
	
	private JTextArea analysis1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UIRadiologist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public UIRadiologist() {
		//currentUser = user;
		
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
				
				//UILogin.main(null);
				frame.dispose();	
			}
		};
			
		logoutButton.addActionListener(logoutListener);
		
		// un-comment this when testing login feature with a user object 
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
		
		
		
		
		Panel SearchPatientPanel = new Panel();
		SearchPatientPanel.setBounds(255, 33, 1000, 420);
		SearchPatientPanel.setLayout(null);
		
		
		

		
		txtsearchPatientFirstName = new JTextField();
		txtsearchPatientFirstName.setBounds(125, 74, 164, 20);
		SearchPatientPanel.add(txtsearchPatientFirstName);
		txtsearchPatientFirstName.setColumns(10);
		
		Label lblsearchPatientFirstName = new Label("First Name ");
		lblsearchPatientFirstName.setBounds(15, 72, 74, 22);
		SearchPatientPanel.add(lblsearchPatientFirstName);
		txtsearchPatientFirstName.setColumns(10);
		
		
		
		
		txtsearchPatientLastName = new JTextField();
		txtsearchPatientLastName.setBounds(125, 115, 164, 20);
		SearchPatientPanel.add(txtsearchPatientLastName);
		txtsearchPatientLastName.setColumns(10);
		
		Label lblsearchPatientLastName = new Label("Last Name ");
		lblsearchPatientLastName.setBounds(15, 113, 74, 22);
		SearchPatientPanel.add(lblsearchPatientLastName);
		txtsearchPatientFirstName.setColumns(10);
		
		
	
		Label lblsearchPatientDoB = new Label("Date of Birth*");
		lblsearchPatientDoB.setBounds(15, 155, 95, 22);
		SearchPatientPanel.add(lblsearchPatientDoB);
		
		
		
		txtsearchPatientDoB = new JTextField();
		txtsearchPatientDoB.setText("YYYY-MM-DD");
		txtsearchPatientDoB.setBounds(125, 160, 164, 20);
		SearchPatientPanel.add(txtsearchPatientDoB);
		txtsearchPatientDoB.setColumns(10);
		
		
		txtsearchPatientLastName = new JTextField();
		txtsearchPatientLastName.setBounds(125, 115, 164, 20);
		SearchPatientPanel.add(txtsearchPatientLastName);
		txtsearchPatientLastName.setColumns(10);
		
		
		
		analysis1 = new JTextArea();
		analysis1.setBounds(446, 62, 292, 290);
		SearchPatientPanel.add(analysis1);
		analysis1.setColumns(10);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Analysis");
		lblNewLabel.setBounds(502, 23, 174, 31);
		SearchPatientPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 17));
	
		
		//JButton addButton = new JButton("Add");
		//addButton.setBounds(414,382,96,29);
		//SearchPatientPanel.add(addButton);
		
	
		
		//JButton retrieveButton = new JButton("Retrieve");
		//retrieveButton.setBounds(502, 382, 96, 29);
		//SearchPatientPanel.add(retrieveButton);
		
		
		
		JButton saveButton = new JButton ("Save ");
		saveButton.setBounds(453,382,138,29);
		SearchPatientPanel.add(saveButton);
		

		JButton submitOrder = new JButton("Submit ");
		submitOrder.setBounds(604, 382, 138, 29);
		SearchPatientPanel.add(submitOrder);
		
		JButton Searchbutton1 = new JButton("Search");
		Searchbutton1.setBounds(92, 213, 257, 23);
		SearchPatientPanel.add(Searchbutton1);
		
		
		
		
		//---------------------------------------------------------------
		
		
		
		Panel viewOrdersButtonPanel = new Panel();
		viewOrdersButtonPanel.setBounds(255, 33, 913, 420);
		viewOrdersButtonPanel.setLayout(null);
		
		
		
		
		JLabel lblviewOrderInfo = new JLabel("Order Information");
		lblviewOrderInfo.setBounds(93, 35, 148, 14);
		viewOrdersButtonPanel.add(lblviewOrderInfo);
		
		JLabel lblviewOrderOrderIdNumber = new JLabel("Order ID Number");
		lblviewOrderOrderIdNumber.setBounds(15, 70, 130, 14);
		viewOrdersButtonPanel.add(lblviewOrderOrderIdNumber);
		
		txtviewOrderOrderId = new JTextField();
		txtviewOrderOrderId.setBounds(138, 67, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderOrderId);
		txtviewOrderOrderId.setColumns(10);
		
		JLabel lblviewOrderPatient = new JLabel("Patient Information");
		lblviewOrderPatient.setBounds(93, 108, 148, 14);
		viewOrdersButtonPanel.add(lblviewOrderPatient);
		
		JLabel lblviewOrderFirstName = new JLabel("First Name");
		lblviewOrderFirstName.setBounds(15, 146, 75, 14);
		viewOrdersButtonPanel.add(lblviewOrderFirstName);
		
		
		txtviewOrderFirstName = new JTextField();
		txtviewOrderFirstName.setBounds(138, 143, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderFirstName);
		txtviewOrderFirstName.setColumns(10);

		
		JLabel lblviewOrderLastName = new JLabel("Last Name");
		lblviewOrderLastName.setBounds(15, 190, 75, 24);
		viewOrdersButtonPanel.add(lblviewOrderLastName);
		
		TextField txtviewOrderLastName = new TextField();
		txtviewOrderLastName.setBounds(138, 192, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderLastName);
		
		JLabel lblviewOrderDateOfBirth = new JLabel("Date Of Birth");
		lblviewOrderDateOfBirth.setBounds(15, 247, 87, 14);
		viewOrdersButtonPanel.add(lblviewOrderDateOfBirth);
		
		txtviewOrderDateOfBirth = new JTextField();
		txtviewOrderDateOfBirth.setText("YYYY-MM-DD");
		txtviewOrderDateOfBirth.setBounds(138, 244, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderDateOfBirth);
		txtviewOrderDateOfBirth.setColumns(10);
		
		
		JButton Searchbutton = new JButton("Search");
		Searchbutton.setBounds(85, 300, 257, 23);
		viewOrdersButtonPanel.add(Searchbutton);
		
		
		
		
		//---------------------------------------------------
		
		
		
		Panel newPatientPanel = new Panel();
		newPatientPanel.setBounds(255, 33, 913, 420);
		newPatientPanel.setLayout(null);
		
		
		
		JLabel lblNewPatient = new JLabel("New Patient Information ");
		lblNewPatient.setBounds(15, 11, 179, 14);
		newPatientPanel.add(lblNewPatient);
		
		JLabel NewPatinetFirstName = new JLabel("First Name ");
		NewPatinetFirstName.setBounds(15, 66, 89, 14);
		newPatientPanel.add(NewPatinetFirstName);
		
		Label NewPatientLastName = new Label("Last Name ");
		NewPatientLastName.setBounds(15, 100, 89, 22);
		newPatientPanel.add(NewPatientLastName);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date of Birth ");
		lblDateOfBirth_1.setBounds(15, 148, 99, 14);
		newPatientPanel.add(lblDateOfBirth_1);
		
		JLabel lblEmail = new JLabel("E-Mail ");
		lblEmail.setBounds(15, 196, 89, 14);
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
		
		
		

		//JButton newPatient = new JButton("New Patient");
		//newPatient.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				
				
				
				//subActionPanel.add(newPatientPanel);
				//subActionPanel.remove(SearchPatientPanel);
			//	subActionPanel.remove(viewOrdersButtonPanel);
				
				
				
				
				
				
				
		//	}
		//});
		//newPatient.setBounds(10, 96, 203, 23);
	//	actionPanel.add(newPatient);
		
		
		
		
		
		JButton viewOrdersButton = new JButton("View Open Orders");
		viewOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				subActionPanel.add(viewOrdersButtonPanel);
				subActionPanel.remove(SearchPatientPanel);
				subActionPanel.remove(newPatientPanel);
				
				
				
				
				
			}
		});
	viewOrdersButton.setBounds(10, 62, 203, 23);
		actionPanel.add(viewOrdersButton);
		
		JButton searchPatient = new JButton("Search Patients");
		searchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
		
				subActionPanel.add(SearchPatientPanel);
				subActionPanel.remove(viewOrdersButtonPanel);
				subActionPanel.remove(newPatientPanel);
				
				
			}
		});
		searchPatient.setBounds(10, 28, 203, 23);
	actionPanel.add(searchPatient);
		
		
				
		

}
}
