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

import javax.swing.Action;
import java.awt.Font;

import java.sql.Date;
import java.sql.SQLException;




import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;















//Nick's changes, added static frame for added logout functionality, added User parameter for displaying username, *******
public class UIRadiologist extends JFrame {

	private JPanel contentPane;
	private static UIRadiologist frame;
	//private User currentUser;
	
	
	private static final long serialVersionUID = 1L;
	protected Order selectedOrder; //For use in details view
	protected ArrayList<JRadioButton> buttonTracker = new ArrayList<>();
	protected ArrayList<Order> orderTracker = new ArrayList<>();
	private static UIRadiologist window;
	//private User currentUser;
	private int currentIndex = 0;
	
	
	

	

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
		
		JLabel versionText = new JLabel("Radiologist Portal");
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
		
		
		

		
		JTextField txtsearchPatientFirstName = new JTextField();
		txtsearchPatientFirstName.setBounds(125, 74, 164, 20);
		SearchPatientPanel.add(txtsearchPatientFirstName);
		txtsearchPatientFirstName.setColumns(10);
		
		Label lblsearchPatientFirstName = new Label("First Name ");
		lblsearchPatientFirstName.setBounds(15, 72, 74, 22);
		SearchPatientPanel.add(lblsearchPatientFirstName);
		txtsearchPatientFirstName.setColumns(10);
		
		
		
		
		JTextField txtsearchPatientLastName = new JTextField();
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
		
		
		
		JTextField txtsearchPatientDoB = new JTextField();
		txtsearchPatientDoB.setText("YYYY-MM-DD");
		txtsearchPatientDoB.setBounds(125, 160, 164, 20);
		SearchPatientPanel.add(txtsearchPatientDoB);
		txtsearchPatientDoB.setColumns(10);
		
		
		txtsearchPatientLastName = new JTextField();
		txtsearchPatientLastName.setBounds(125, 115, 164, 20);
		SearchPatientPanel.add(txtsearchPatientLastName);
		txtsearchPatientLastName.setColumns(10);
		
		
		
		JTextArea analysis1 = new JTextArea();
		analysis1.setBounds(446, 62, 292, 290);
		SearchPatientPanel.add(analysis1);
		analysis1.setColumns(10);
		
		
		
		
		JLabel analysis = new JLabel("Analysis");
		analysis.setBounds(502, 23, 174, 31);
		SearchPatientPanel.add(analysis);
		analysis.setHorizontalAlignment(SwingConstants.CENTER);
		analysis.setFont(new Font("Lucida Grande", Font.BOLD, 17));
	
		
	
		JButton submitOrder = new JButton("Submit ");
		submitOrder.setBounds(502, 382, 174, 29);
		SearchPatientPanel.add(submitOrder);
		
		
		
	/*	submitOrder.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            String areaText = an.getText();
	            saveText(areaText);
	        }
	    });
		
		
		
		
		JButton Searchbutton1 = new JButton("Search Images ");
		Searchbutton1.setBounds(92, 213, 257, 23);
		SearchPatientPanel.add(Searchbutton1);
		
		*/
		
		
		//---------------------------------------------------------------
		
		
		
		
		
		
	
					
		
		ActionListener imageListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent click) {
				
				if (click.getSource() == Searchbutton1) {
					
					JFileChooser chooser= new JFileChooser();

					int choice = chooser.showOpenDialog(Searchbutton1);

					if (choice != JFileChooser.APPROVE_OPTION) return;

					File chosenFile = chooser.getSelectedFile();
					
					BufferedImage chosenImage = null;
					try {
						chosenImage = ImageIO.read(chosenFile);
					}//end try 
					catch (IOException e) {
						
						e.printStackTrace();
					}//end catch
					
					
		
		
		

			
					

		
		
		
		
		
		
				}}};
				

		
		
		
		
		
		
		
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
		
		JTextField txtviewOrderOrderId = new JTextField();
		txtviewOrderOrderId.setBounds(138, 67, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderOrderId);
		txtviewOrderOrderId.setColumns(10);
		
		JLabel lblviewOrderPatient = new JLabel("Patient Information");
		lblviewOrderPatient.setBounds(93, 108, 148, 14);
		viewOrdersButtonPanel.add(lblviewOrderPatient);
		
		JLabel lblviewOrderFirstName = new JLabel("First Name");
		lblviewOrderFirstName.setBounds(15, 146, 75, 14);
		viewOrdersButtonPanel.add(lblviewOrderFirstName);
		
		
		JTextField txtviewOrderFirstName = new JTextField();
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
		
		JTextField txtviewOrderDateOfBirth = new JTextField();
		txtviewOrderDateOfBirth.setText("YYYY-MM-DD");
		txtviewOrderDateOfBirth.setBounds(138, 244, 129, 20);
		viewOrdersButtonPanel.add(txtviewOrderDateOfBirth);
		txtviewOrderDateOfBirth.setColumns(10);
		
		
		JButton Searchbutton = new JButton("Search");
		Searchbutton.setBounds(85, 300, 257, 23);
		viewOrdersButtonPanel.add(Searchbutton);
		
		
		
	
		
		
		
		
		
		
		
		JButton searchPatient = new JButton("Search Patients");
		searchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	
				
				
				
		
				subActionPanel.add(SearchPatientPanel);
			
				
				
				
			}
		});
		searchPatient.setBounds(10, 28, 203, 23);
	actionPanel.add(searchPatient);
		
		
				
		

}
}
