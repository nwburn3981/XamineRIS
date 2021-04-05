import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.Popup;

import java.awt.Label;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Choice;
import java.awt.Color;

//toDo
//CheckIn -add popup for confirmation may skip for time.

public class UIReceptionist extends JFrame {

	private JPanel contentPane;
	private Panel todayAppointmentPanel;
	
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
	
	//Patients for test use in system
	private Patient patient1 = new Patient("John", "Kramer", "jkramer@ung.edu", "5557777878");
	private Patient patient2 = new Patient("Isa", "Balmer", "ibalmer@ung.edu", "7865551234");
	private Patient patient3 = new Patient("Pop", "Johnson", "pjohnson@ung.edu", "8885551111");
	private Patient patient4 = new Patient("James", "Williams", "jwilliams@ung.edu", "5050555050");
	
	//ArrayList to simulate database
	private ArrayList<Order> testOrders = new ArrayList<>();
	private ArrayList<Patient> testPatients = new ArrayList<>();
	private ArrayList<Team> testTeams = new ArrayList<>();
	
	//Orders for test use
	private Order order1 = new Order("001", patient1);
	private Order order2 = new Order("002", patient2);
	private Order order3 = new Order("003", patient3);
	private Order order4 = new Order("004", patient4);
	private Order orderTransfer;
	
	//Teams for test use
	private Team team1 = new Team("01", "Team1");
	private Team team2 = new Team("02", "Team2");
	private Team team3 = new Team("03", "Team3");
	
	//Modalities for test use
	private Modality Xray = new Modality("01");
	private Modality MRI = new Modality("02");
	private Modality Ultrasound = new Modality("03");
	
	private JPanel actionPanel;
	private JPanel subActionPanel;
	
	private JButton todaysAppointments;
	private JButton viewUnscheduledOrders;
	private JButton viewOrdersButton;
	private JButton searchPatient;
	
	protected ArrayList<JRadioButton> buttonTracker = new ArrayList<>();
	protected ArrayList<Order> orderTracker = new ArrayList<>();

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
		
		//Adding parameters for testing
		order1.setApptDay(LocalDate.now());
		order1.setApptTime("11:00am");
		order1.setApptRoom("101");
		order1.setImagingOrder("X-Ray");
		order1.setOrderStatus("Check-In");
		order1.setPatientCheckedIn(true);
		
		order2.setApptDay(LocalDate.now());
		order2.setApptTime("1:00pm");
		order2.setApptRoom("102");
		order2.setImagingOrder("Ultrasound");
		order2.setOrderStatus("open");
		
		order3.setApptDay(LocalDate.now());
		order3.setApptTime("10:00am");
		order3.setApptRoom("103");
		order3.setImagingOrder("MRI");
		order3.setOrderStatus("completed");
		
		order4.setImagingOrder("Ultrasound");
		order4.setOrderStatus("open");
		
		//filling test Order list
		testOrders.add(order1);
		testOrders.add(order2);
		testOrders.add(order3);
		testOrders.add(order4);
		
		testPatients.add(patient1);
		testPatients.add(patient2);
		testPatients.add(patient3);
		testPatients.add(patient4);
		
		testTeams.add(team1);
		testTeams.add(team2);
		testTeams.add(team3);
		
		Initialize();
		InitializeListeners();
		
		
		JLabel lblSuccessfulCheckIn = new JLabel("Patient Checked-In Successfully! ");
		lblSuccessfulCheckIn.setForeground(Color.BLACK);
		lblSuccessfulCheckIn.setBounds(10, 395, 175, 14);
		
	}//end constructor
	
	private void Initialize() {
		
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
		
		JLabel nameSpace = new JLabel(currentUser.getFirstName() + " " + currentUser.getLastName());
		nameSpace.setHorizontalAlignment(SwingConstants.CENTER);
		nameSpace.setBounds(384, 4, 265, 14);
		statusBar.add(nameSpace);
		
		JButton notifyButton = new JButton("Notifications");
		notifyButton.setBounds(928, 3, 105, 20);
		statusBar.add(notifyButton);
		
		subActionPanel = new JPanel();
		subActionPanel.setLayout(null);
		subActionPanel.setBounds(10, 248, 239, 214);
		getContentPane().add(subActionPanel);
		
		actionPanel = new JPanel();
		subActionPanel.add(actionPanel);
		actionPanel.setBounds(10, 33, 239, 420);
		actionPanel.setLayout(null);
		
		todaysAppointments = new JButton("Today's Appointments");
		todaysAppointments.setBounds(10, 28, 203, 23);
		actionPanel.add(todaysAppointments);
		
		searchPatient = new JButton("Search Patients");
		searchPatient.setBounds(10, 130, 203, 23);
		actionPanel.add(searchPatient);
		
		viewUnscheduledOrders = new JButton("Unscheduled orders");
		viewUnscheduledOrders.setBounds(10, 62, 203, 23);
		actionPanel.add(viewUnscheduledOrders);
		
	}//end Initialize
	
	public void InitializeListeners() {
		
		todaysAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewTodayAppts();
			}
		});
		
		viewUnscheduledOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ViewUnScheduledAppts();
			}
		});
		
		searchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Search();
			}
		});
	}//end InitializeListener
	
	
	public void ViewTodayAppts() {
		

		// here is the panel that displays todays appointments 
		//
		//
		subActionPanel.removeAll();	
		subActionPanel.add(actionPanel);
		
		todayAppointmentPanel = new Panel();
		todayAppointmentPanel.setBounds(255, 33, 913, 420);
		todayAppointmentPanel.setLayout(null);
		
		JLabel lblCurrentOrderTodayAppointments = new JLabel("");
		lblCurrentOrderTodayAppointments.setBounds(100, 22, 122, 14);
		todayAppointmentPanel.add(lblCurrentOrderTodayAppointments);		
		
		JLabel lblAppointmentsDate = new JLabel(String.valueOf(LocalDate.now()));
		lblAppointmentsDate.setBounds(594, 22, 139, 14);//use this xy coords
		todayAppointmentPanel.add(lblAppointmentsDate);
		
		JLabel lblTodaysAppointments = new JLabel("Today's Appointments");
		lblTodaysAppointments.setBounds(566, 0, 190, 18);
		todayAppointmentPanel.add(lblTodaysAppointments);
		lblTodaysAppointments.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPatientNameLabel = new JLabel("Patient: ");
		lblPatientNameLabel.setBounds(10, 47, 47, 14);
		todayAppointmentPanel.add(lblPatientNameLabel);
		
		JLabel lblNamelabel = new JLabel("Last Name , First Name");
		lblNamelabel.setBounds(60, 47, 275, 14);
		todayAppointmentPanel.add(lblNamelabel);
		
		JLabel lblAppointmentLabel = new JLabel("Appointment:");
		lblAppointmentLabel.setBounds(10, 75, 79, 14);
		todayAppointmentPanel.add(lblAppointmentLabel);
		
		JLabel lblInsertADate = new JLabel("Insert a Date and time here. Maybe just time ");
		lblInsertADate.setBounds(90, 75, 260, 14);
		todayAppointmentPanel.add(lblInsertADate);
		
		JLabel lblImagingNeededLabel = new JLabel("-- Imaging Required --");
		lblImagingNeededLabel.setBounds(100, 100, 122, 14);
		todayAppointmentPanel.add(lblImagingNeededLabel);
		
		JTextArea textAreaTodayAppointment = new JTextArea();
		textAreaTodayAppointment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaTodayAppointment.setLineWrap(true);
		textAreaTodayAppointment.setText("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
		textAreaTodayAppointment.setBounds(10, 125, 315, 181);
		todayAppointmentPanel.add(textAreaTodayAppointment);
		
		JButton btnCheckIn = new JButton("Appointment Check-in");
		btnCheckIn.setBounds(60, 345, 180, 23);
		todayAppointmentPanel.add(btnCheckIn);
		
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				todayAppointmentPanel.removeAll();
				CheckIn(orderTransfer.getPatient().getFirstName(), orderTransfer.getPatient().getLastName());
				
			}
		});	
				
		//Special listener for radio buttons
		ActionListener radioListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent selection) {
				
				Object selected = selection.getSource();
				int selectedIndex = buttonTracker.indexOf(selected);
				orderTransfer = orderTracker.get(selectedIndex);
				
				lblCurrentOrderTodayAppointments.setText(orderTransfer.getOrderID());
				lblNamelabel.setText(orderTransfer.getPatient().getLastName() + ", " + orderTransfer.getPatient().getFirstName() );
				textAreaTodayAppointment.setText(orderTransfer.getImagingOrder());
				lblInsertADate.setText(String.valueOf(orderTransfer.getApptDay()) + " " + orderTransfer.getApptTime());
				
			}//end Action
		};//end radioListener
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		
		int yValue = 40;
		int xValue = 594;
		
		//Iterates through Arraylist looking for current date, will iterate through database Order table in final version 
		for(int i = 0; i < testOrders.size(); i++) {
			
			if(testOrders.get(i).getApptDay() != null) {
				
				if(testOrders.get(i).getApptDay().equals(LocalDate.now()) == true && testOrders.get(i).getPatientCheckedIn() == false) {
					JRadioButton orderRdButton = new JRadioButton("Order " + ": " + testOrders.get(i).getOrderID());
					orderRdButton.setBounds(xValue, yValue, 140, 14);
					todayAppointmentPanel.add(orderRdButton);
					orderRdButton.addActionListener(radioListener);
					radioButtonGroup.add(orderRdButton);
				
					buttonTracker.add(orderRdButton);
					orderTracker.add(testOrders.get(i));
				
					yValue += 20;
				}//end nested if
			}//end if
		}//end for loop

		subActionPanel.add(todayAppointmentPanel) ;
		subActionPanel.revalidate();
		subActionPanel.repaint();
	}//end viewTodayAppts
	
	public void ViewUnScheduledAppts() {
		
		subActionPanel.removeAll() ;
		subActionPanel.add(actionPanel);
		
				// This panel creates the view of all the unscheduled orders 
				// To-Do have a way for the receptionist to make an appointment 
				// add GUI components for that as well 
		
				Panel unscheduledOrdersPanel = new Panel();
				unscheduledOrdersPanel.setBounds(255, 33, 913, 420);
				unscheduledOrdersPanel.setLayout(null);
				
				JLabel lblselectedOrderUnscheduled = new JLabel();
				lblselectedOrderUnscheduled.setBounds(100, 10, 122, 14);
				unscheduledOrdersPanel.add(lblselectedOrderUnscheduled);
				
				JLabel lblSelectedPatientNameUnscheduled = new JLabel("Patient: ");
				lblSelectedPatientNameUnscheduled.setBounds(20, 30, 47, 14);
				unscheduledOrdersPanel.add(lblSelectedPatientNameUnscheduled);
				lblSelectedPatientNameUnscheduled.setVisible(false);
				
				JLabel lblUnscheduledOrders = new JLabel("Unscheduled Orders");
				lblUnscheduledOrders.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblUnscheduledOrders.setBounds(566, 10, 190, 18);
				unscheduledOrdersPanel.add(lblUnscheduledOrders);
				
				JLabel lblSelectedPatientName = new JLabel();
				lblSelectedPatientName.setBounds(75, 30, 270, 14);
				unscheduledOrdersPanel.add(lblSelectedPatientName);
				
				JLabel lblEnterADate = new JLabel("Schedule Appointment Date:");
				lblEnterADate.setBounds(20, 60, 270, 25);
				unscheduledOrdersPanel.add(lblEnterADate);
				
				JTextField dateField = new JTextField();
				dateField.setBounds(20, 80, 270, 25);
				unscheduledOrdersPanel.add(dateField);
				
				JLabel lblEnterATime = new JLabel("Schedule Appointment Time:");
				lblEnterATime.setBounds(20, 105, 270, 25);
				unscheduledOrdersPanel.add(lblEnterATime);
				
				JTextField timeField = new JTextField();
				timeField.setBounds(20, 125, 270, 25);
				unscheduledOrdersPanel.add(timeField);
				
				//Special listener for radio buttons
				ActionListener radioListener = new ActionListener() {
					
					public void actionPerformed(ActionEvent selection) {
						
						Object selected = selection.getSource();
						int selectedIndex = buttonTracker.indexOf(selected);
						orderTransfer = orderTracker.get(selectedIndex);
						
						lblselectedOrderUnscheduled.setText("Order ID:  " + orderTransfer.getOrderID());
						lblSelectedPatientName.setText(orderTransfer.getPatient().getLastName() + ", " + orderTransfer.getPatient().getFirstName() );
						lblSelectedPatientNameUnscheduled.setVisible(true);
						
					}//end Action
				};//end radioListener
				
				ButtonGroup radioButtonGroup = new ButtonGroup();
				
				int yValue = 40;
				int xValue = 594;
				
				//Iterates through Arraylist looking for current date, will iterate through database Order table in final version 
				for(int i = 0; i < testOrders.size(); i++) {
					
					if(testOrders.get(i).getApptDay() == null) {
						JRadioButton orderRdButton = new JRadioButton("Order " + ": " + testOrders.get(i).getOrderID());
						orderRdButton.setBounds(xValue, yValue, 140, 14);
						unscheduledOrdersPanel.add(orderRdButton);
						orderRdButton.addActionListener(radioListener);
						radioButtonGroup.add(orderRdButton);
						
						buttonTracker.add(orderRdButton);
						orderTracker.add(testOrders.get(i));
						
						yValue += 20;
					}//end if
					
				}//end for loop
				
				JButton btnNewAppointment = new JButton("Schedule Appointment");
				btnNewAppointment.setBounds(60, 200, 170, 23);
				unscheduledOrdersPanel.add(btnNewAppointment);
				
				//special listener for schedule button
				ActionListener appointmentListener = new ActionListener() {
					
					public void actionPerformed(ActionEvent click){
						if (dateField.getText() != "" && timeField.getText() != "" && orderTransfer != null) {
							
							LocalDate scheduled = LocalDate.parse(dateField.getText());
							String ID = orderTransfer.getOrderID();
							
							for(int i = 0; i < testOrders.size(); i++) {
								if(ID == testOrders.get(i).getOrderID()) {
									testOrders.get(i).setApptDay(scheduled);
									testOrders.get(i).setApptTime(timeField.getText());
									testOrders.get(i).setApptScheduled(true);
									break;
								}//end if
							}//end for
							
							ViewUnScheduledAppts();
						}//end if
						
					}//end Action
				};//end appointmentListener
				
				btnNewAppointment.addActionListener(appointmentListener);
				
		subActionPanel.add(unscheduledOrdersPanel);
	}//end viewUnscheduledAppts
	
	public void ChecKIn(String appt, String apptRoom) {
		
		
	}//end CheckIn
	
	//Opens view for Search Patient and Search Order
	public void Search() {
		
		subActionPanel.removeAll();
		subActionPanel.add(actionPanel);
		
		// the first panel that is added when the search patient button is clicked 
				// The receptionist can use this interface to look up patients that come in 
				// ideally searching for a patient shows all scheduled and unscheduled orders 
				
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
				
				JButton searchPatientSearchButton = new JButton("Search Patient");
				searchPatientSearchButton.setBounds(70, 250, 164, 23);
				SearchPatientPanel.add(searchPatientSearchButton);
				
				JLabel lblviewOrderInfo = new JLabel("Order Information");
				lblviewOrderInfo.setBounds(70, 290, 134, 14);
				SearchPatientPanel.add(lblviewOrderInfo);
				
				JLabel lblviewOrderOrderIdNumber = new JLabel("Order ID Number");
				lblviewOrderOrderIdNumber.setBounds(28, 335, 101, 14);
				SearchPatientPanel.add(lblviewOrderOrderIdNumber);
				
				txtviewOrderOrderId = new JTextField();
				txtviewOrderOrderId.setBounds(130, 335, 129, 20);
				SearchPatientPanel.add(txtviewOrderOrderId);
				txtviewOrderOrderId.setColumns(10);
				
				JButton searchOrderSearchButton = new JButton("Search Order");
				searchOrderSearchButton.setBounds(70, 380, 164, 23);
				SearchPatientPanel.add(searchOrderSearchButton);
				
				JLabel searchPatientinstructionsLabel = new JLabel("Patient Information");
				searchPatientinstructionsLabel.setBounds(70, 26, 134, 14);
				SearchPatientPanel.add(searchPatientinstructionsLabel);
				
				JLabel searchPatientsResultsLabel = new JLabel("Search Results");
				searchPatientsResultsLabel.setBounds(596, 26, 89, 14);
				SearchPatientPanel.add(searchPatientsResultsLabel);
				
				JLabel fNameResult = new JLabel();
				fNameResult.setBounds(500, 50, 165, 20);
				SearchPatientPanel.add(fNameResult);
				fNameResult.setVisible(false);
				
				JLabel lNameResult = new JLabel();
				lNameResult.setBounds(700, 50, 165, 20);
				SearchPatientPanel.add(lNameResult);
				lNameResult.setVisible(false);
				
				JLabel emailResult = new JLabel();
				emailResult.setBounds(500, 100, 165, 20);
				SearchPatientPanel.add(emailResult);
				emailResult.setVisible(false);
				
				JLabel phoneNumResult = new JLabel();
				phoneNumResult.setBounds(700, 100, 165, 20);
				SearchPatientPanel.add(phoneNumResult);
				phoneNumResult.setVisible(false);
				
				JLabel allergyResult = new JLabel();//Might need changed too, text area
				allergyResult.setBounds(500, 150, 365, 20);
				SearchPatientPanel.add(allergyResult);
				allergyResult.setVisible(false);
				
				JLabel notesResult = new JLabel();//Change this to a text area or something
				notesResult.setBounds(500, 200, 365, 20);
				SearchPatientPanel.add(notesResult);
				notesResult.setVisible(false);
				
				JLabel orderStatusResult = new JLabel();
				orderStatusResult.setBounds(500, 100, 165, 20);
				SearchPatientPanel.add(orderStatusResult);
				orderStatusResult.setVisible(false);
				
				JLabel modalityResult = new JLabel();
				modalityResult.setBounds(700, 100, 165, 20);
				SearchPatientPanel.add(modalityResult);
				modalityResult.setVisible(false);
				
				JLabel apptScheduledResult = new JLabel();
				apptScheduledResult.setBounds(500, 150, 250, 20);
				SearchPatientPanel.add(apptScheduledResult);
				apptScheduledResult.setVisible(false);
				
				JLabel imagingOrderResult = new JLabel();
				imagingOrderResult.setBounds(500, 200, 165, 20);
				SearchPatientPanel.add(imagingOrderResult);
				imagingOrderResult.setVisible(false);
				
				JLabel imagingOrderStatusResult = new JLabel();
				imagingOrderStatusResult.setBounds(700, 200, 165, 20);
				SearchPatientPanel.add(imagingOrderStatusResult);
				imagingOrderStatusResult.setVisible(false);

				JLabel visitReasonResult = new JLabel();//Change this to a text area or something
				visitReasonResult.setBounds(500, 250, 365, 20);
				SearchPatientPanel.add(visitReasonResult);
				visitReasonResult.setVisible(false);
				
				ActionListener searchListener = new ActionListener() {
					
					public void actionPerformed(ActionEvent click) {
						Boolean resultFound = false;
						
						if (click.getSource() == searchPatientSearchButton) {
							//Take in search parameters FirstName, LastName, EMail, DoB use SQL to make comparisons until proper patient found
							//Return all patient Info from matching patient, phone number, notes, allergies
							String fName = txtsearchPatientFirstName.getText();
							String lName = txtsearchPatientLastName.getText();
							
							//Remove results from any previous  order searches
							orderStatusResult.setVisible(false);
							visitReasonResult.setVisible(false);
							modalityResult.setVisible(false);
							apptScheduledResult.setVisible(false);
							imagingOrderResult.setVisible(false);
							imagingOrderStatusResult.setVisible(false);
							
							for(int i = 0; i < testPatients.size(); i++) {
								if(testPatients.get(i).getFirstName().equalsIgnoreCase(fName) && testPatients.get(i).getLastName().equalsIgnoreCase(lName)) {
									fNameResult.setText("First Name:  " + fName);
									fNameResult.setVisible(true);
									lNameResult.setText("Last Name:  " + lName);	
									lNameResult.setVisible(true);
									emailResult.setText("Email:  " + testPatients.get(i).getEmail());	
									emailResult.setVisible(true);
									phoneNumResult.setText("Phone #:  " + testPatients.get(i).getPhoneNumber());
									phoneNumResult.setVisible(true);
									allergyResult.setText("Allergies:  " + testPatients.get(i).getAllergy());	
									allergyResult.setVisible(true);
									notesResult.setText("Notes:  " + testPatients.get(i).getNotes());
									notesResult.setVisible(true);
									
									resultFound = true;
									
									SearchPatientPanel.revalidate();
									SearchPatientPanel.repaint();
									
									break;
								}//end if
								
							}//end for
								
							if (resultFound == false) {
								fNameResult.setText("");
								lNameResult.setText("");									
								emailResult.setText("");									
								phoneNumResult.setText("");									
								allergyResult.setText("");									
								notesResult.setText("No results, please check input");
								notesResult.setVisible(true);
								
								SearchPatientPanel.revalidate();
								SearchPatientPanel.repaint();
							}//end if
						
						}//end source if
						
						else if (click.getSource() == searchOrderSearchButton) {
							
							//Remove results from any previous patient searches
							emailResult.setVisible(false);
							phoneNumResult.setVisible(false);
							allergyResult.setVisible(false);
							notesResult.setVisible(false);

							for(int i = 0; i < testOrders.size(); i++) {
								if(testOrders.get(i).getOrderID().equals(txtviewOrderOrderId.getText())) {
									fNameResult.setText("First Name:  " + testOrders.get(i).getPatient().getFirstName());	
									fNameResult.setVisible(true);
									lNameResult.setText("Last Name:  " + testOrders.get(i).getPatient().getLastName());		
									lNameResult.setVisible(true);
									orderStatusResult.setText("Order Status:  " + testOrders.get(i).getOrderStatus());	
									orderStatusResult.setVisible(true);
									
									if ((testOrders.get(i).getApptScheduled()) == true) {
										apptScheduledResult.setText("Appointment:  " + String.valueOf(testOrders.get(i).getApptDay()));
										apptScheduledResult.setVisible(true);
									}//end if
									else {
										apptScheduledResult.setText("Appointment:  " + "No appointment scheduled");
										apptScheduledResult.setVisible(true);
									}//end else
										
									modalityResult.setText("Modality:  " + testOrders.get(i).getModality());
									modalityResult.setVisible(true);
									imagingOrderResult.setText("Imaging Ordered:  " + testOrders.get(i).getImagingOrder());
									imagingOrderResult.setVisible(true);
									imagingOrderStatusResult.setText("Imaging Status:  " + testOrders.get(i).getImagingOrderStatus());
									imagingOrderStatusResult.setVisible(true);
									visitReasonResult.setText("Reason for Visit:  " + testOrders.get(i).getVisitReason());
									visitReasonResult.setVisible(true);
									
									resultFound = true;
									
									SearchPatientPanel.revalidate();
									SearchPatientPanel.repaint();
									
									break;
								}//end if
								
							}//end for
							
							if (resultFound == false) {
								fNameResult.setText("");
								lNameResult.setText("");									
								emailResult.setText("");									
								phoneNumResult.setText("");									
								allergyResult.setText("");									
								notesResult.setText("No results, please check input");
								notesResult.setVisible(true);
								
								SearchPatientPanel.revalidate();
								SearchPatientPanel.repaint();
							}//end if
							
						}//end source else if
						
					}//end Action
				};//end searchListner
				
				searchPatientSearchButton.addActionListener(searchListener);
				searchOrderSearchButton.addActionListener(searchListener);
				
		subActionPanel.add(SearchPatientPanel);	
	}//end SearchPatient
	
	public void ViewPatientInfo (String patientFirstName, String patientLastName) {
		
		
	}//end ViewPatientInfo
	
	public void CheckIn (String patientFirstName, String patientLastName) {
		
		// panel for checking in a patient. use choice boxes to select an open technician, modality / equipment / room
				// Ideally this panel is called when an appointment is selected from "Todays Appointment" and uses the order and patient 
				// object to send to this panel to be sent to the proper equipment IE checking in. 
				
				JPanel CheckinPanel = new JPanel();
				CheckinPanel.setBounds(0, 33, 913, 420);
				CheckinPanel.setLayout(null);
				
				JLabel lblCheckInSelectedlabel = new JLabel("OrderID: " + orderTransfer.getOrderID());
				lblCheckInSelectedlabel.setBounds(100, 23, 122, 14);
				CheckinPanel.add(lblCheckInSelectedlabel);
				
				JLabel lblCheckInPatientDisp = new JLabel("Patient:");
				lblCheckInPatientDisp.setBounds(10, 47, 47, 14);
				CheckinPanel.add(lblCheckInPatientDisp);
				
				JLabel lblAppoinmnetCheckInLabel = new JLabel("Appointment: ");
				lblAppoinmnetCheckInLabel.setBounds(10, 75, 79, 14);
				CheckinPanel.add(lblAppoinmnetCheckInLabel);
				
				JLabel lblPatientNameCheckIn = new JLabel(orderTransfer.getPatient().getLastName() + ", " + orderTransfer.getPatient().getFirstName());
				lblPatientNameCheckIn.setBounds(60, 47, 275, 14);
				CheckinPanel.add(lblPatientNameCheckIn);
				
				JLabel lblAppointmentDateCheckIn = new JLabel(String.valueOf(orderTransfer.getApptDay()) + " " + orderTransfer.getApptTime());
				lblAppointmentDateCheckIn.setBounds(90, 75, 260, 14);
				CheckinPanel.add(lblAppointmentDateCheckIn);
				
				JLabel lblImagingRequiredCheckIn = new JLabel("-- Imaging Required --");
				lblImagingRequiredCheckIn.setBounds(100, 100, 122, 14);
				CheckinPanel.add(lblImagingRequiredCheckIn);
				
				JTextArea textAreaCheckIn = new JTextArea();
				textAreaCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
				textAreaCheckIn.setLineWrap(true);
				textAreaCheckIn.setEditable(false);
				textAreaCheckIn.setBounds(10, 125, 315, 181);
				textAreaCheckIn.setText(orderTransfer.getImagingOrder());
				CheckinPanel.add(textAreaCheckIn);
				
				JLabel lblCheckIn = new JLabel("-- Check In Information --");
				lblCheckIn.setBounds(566, 23, 155, 14);
				CheckinPanel.add(lblCheckIn);
				
				JLabel lblSelectOpenRoom = new JLabel("Select An Open Room: ");
				lblSelectOpenRoom.setBounds(430, 75, 135, 14);
				CheckinPanel.add(lblSelectOpenRoom);
				
				Choice choiceAvailableModality = new Choice();				
				choiceAvailableModality.setBounds(566, 75, 250, 20);
				CheckinPanel.add(choiceAvailableModality);
				//Fill Choice menu
				choiceAvailableModality.add(Xray.getModalityName());
				choiceAvailableModality.add(MRI.getModalityName());
				choiceAvailableModality.add(Ultrasound.getModalityName());
								
				JLabel lblNewLabel = new JLabel("Select Available Team:");
				lblNewLabel.setBounds(430, 115, 135, 14);
				CheckinPanel.add(lblNewLabel);
				
				Choice choiceAvailableTeam = new Choice();
				choiceAvailableTeam.setBounds(566, 115, 250, 20);
				CheckinPanel.add(choiceAvailableTeam);
				//Fill choice menu
				for(Team team: testTeams) {
				choiceAvailableTeam.add(team.getTeamName());
				}//end for each 
				
				JLabel lblRoomConfirmationdonotchange = new JLabel("Selected Room:");
				lblRoomConfirmationdonotchange.setBounds(430, 200, 135, 14);
				CheckinPanel.add(lblRoomConfirmationdonotchange);
				
				JLabel lblTeamConfirmationdonotchange = new JLabel("Selected Team:");
				lblTeamConfirmationdonotchange.setBounds(430, 240, 135, 14);
				CheckinPanel.add(lblTeamConfirmationdonotchange);
				
				JLabel lblRoomConfirmation = new JLabel();
				lblRoomConfirmation.setBounds(566, 200, 250, 14);
				CheckinPanel.add(lblRoomConfirmation);
				
				JLabel lblTeamConfirmation = new JLabel();
				lblTeamConfirmation.setBounds(566, 240, 250, 14);
				CheckinPanel.add(lblTeamConfirmation);
				
				
				
				ItemListener choiceListener = new ItemListener() {
					
					public void itemStateChanged(ItemEvent choice) {
						
						if (choice.getSource() == choiceAvailableTeam) {
							
							lblTeamConfirmation.setText(choiceAvailableTeam.getSelectedItem());
						}//end if
						
						if (choice.getSource() == choiceAvailableModality) {
							
							lblRoomConfirmation.setText(choiceAvailableModality.getSelectedItem());
						}//end if
					}//end ItemEvent
				};//end itemListener
				
				choiceAvailableTeam.addItemListener(choiceListener);
				choiceAvailableModality.addItemListener(choiceListener);
				
				JButton btnConfirmCheckIn = new JButton("Check-in Patient");
				
				btnConfirmCheckIn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// order status = checked-in 
						// SQL ammend modality and team to the selected order 
						
						String ID = orderTransfer.getOrderID();
						
						for(int i = 0; i < testOrders.size(); i++) {
							if(ID == testOrders.get(i).getOrderID()) {
								testOrders.get(i).setPatientCheckedIn(true);
								testOrders.get(i).setModality(choiceAvailableModality.getSelectedItem());
								testOrders.get(i).setApptRoom(choiceAvailableTeam.getSelectedItem());
								testOrders.get(i).setOrderStatus("Checked-In");
								break;
							}//end if
						}//end for
						
						/*JOptionPane confirm = new JOptionPane("Patient checked-in", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
						confirm.setVisible(true);*/
						
						// consider a success pop-up frame here 
						ViewTodayAppts();
						
					}
				});
				btnConfirmCheckIn.setBounds(566, 285, 130, 23);
				CheckinPanel.add(btnConfirmCheckIn);
				todayAppointmentPanel.add(CheckinPanel);
				
				todayAppointmentPanel.revalidate();
				todayAppointmentPanel.repaint();
		
	}//end CheckIn
	

}