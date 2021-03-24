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
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Action;

//TODO
//
//Add iteration to details image display and refresh when image is added to show confirmation
//View image actually displaying image
//Delete image functionality
//Send order method

public class UITechnician extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	protected Order selectedOrder; //For use in details view
	
	protected ArrayList<JRadioButton> buttonTracker = new ArrayList<>();
	protected ArrayList<Order> orderTracker = new ArrayList<>();
	private static UITechnician window;
	private User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new UITechnician(user);
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
	public UITechnician(User user) {
		currentUser = user;
		initialize();
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
		
		JLabel versionText = new JLabel("Xamine V.2382777");
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
		
		JPanel actionPanel = new JPanel();
		actionPanel.setBounds(10, 37, 239, 214);
		frame.getContentPane().add(actionPanel);
		actionPanel.setLayout(null);
		
		JButton viewButton = new JButton("View Today's Appointments");
		viewButton.setBounds(10, 75, 203, 23);
		actionPanel.add(viewButton);
		
		JButton viewOrdersButton = new JButton("View Open Orders");
		viewOrdersButton.setBounds(10, 109, 203, 23);
		actionPanel.add(viewOrdersButton);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(10, 41, 203, 23);
		actionPanel.add(homeButton);
		
		JLabel testLabel = new JLabel("New label");
		testLabel.setBounds(10, 172, 203, 14);
		actionPanel.add(testLabel);
		
		JPanel subActionPanel = new JPanel();
		subActionPanel.setLayout(null);
		subActionPanel.setBounds(10, 248, 239, 214);
		frame.getContentPane().add(subActionPanel);
		
		JPanel viewPanel = new JPanel();
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
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		//Button group for all generated radio buttons
		ButtonGroup radioButtonGroup = new ButtonGroup(); 
		
		
		
		
		
		//End initial setup-------------------------------------------------------------------------------------------------
		
		//First Listener for radio button selection, selecting a radio button for either orders or appointments will generate a "Details" button along with details listener
		ActionListener radioListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent selection) {
				
				Object selected = selection.getSource();
				int selectedIndex = buttonTracker.indexOf(selected);
				Order orderTransfer = orderTracker.get(selectedIndex);
				
				JButton detailsButton = new JButton("Details");
				detailsButton.setBounds(10, 35, 203, 23);
				subActionPanel.add(detailsButton);
				subActionPanel.repaint();
				subActionPanel.revalidate();
				
				testLabel.setText(orderTransfer.getOrderID());
				
				
				ActionListener detailsListener = new ActionListener() {
					
					public void actionPerformed(ActionEvent click) {
						
						//Setup Details view
						subActionPanel.removeAll();
						viewPanel.removeAll();
						
						//Patient info (Allergies, name, gender, age), checked-in, Appt ID, Date, Time, Order ID, Order Status, Modality, Imaging, Images on order
						//Generate Details View
						JLabel orderIDLabel = new JLabel("Order ID:");
						orderIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(orderIDLabel, "2, 2");
						
						JLabel orderIDOut = new JLabel("001");
						orderIDOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(orderIDOut, "6, 2");
						orderIDOut.setText(orderTransfer.getOrderID());
						
						JLabel patientNameLabel = new JLabel("Patient:");
						patientNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(patientNameLabel, "2, 4");
						
						JLabel patientNameOut = new JLabel(" FirstName + LastName");
						patientNameOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(patientNameOut, "6, 4");
						patientNameOut.setText(orderTransfer.getPatient().getFirstName() + " " + orderTransfer.getPatient().getLastName());
						
						JLabel ageLabel = new JLabel("Age:");
						ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(ageLabel, "2, 6");
						
						JLabel ageOut = new JLabel("Age Here");
						ageOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(ageOut, "6, 6");
						ageOut.setText(String.valueOf(orderTransfer.getPatient().getAge()));
						
						JLabel allergiesLabel = new JLabel("Known Allergies:");
						allergiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(allergiesLabel, "2, 8");
						
						JLabel allergiesOut = new JLabel("Allergies Here");
						allergiesOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(allergiesOut, "6, 8");
						allergiesOut.setText(String.valueOf(orderTransfer.getPatient().getAllergy()));
						
						JLabel orderStatusLabel = new JLabel("Order Status:");
						orderStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(orderStatusLabel, "2, 10");
						
						JLabel orderStatusOut = new JLabel("New label");
						orderStatusOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(orderStatusOut, "6, 10");
						orderStatusOut.setText(orderTransfer.getOrderStatus());
						
						JLabel modalityLabel = new JLabel("Modality:");
						modalityLabel.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(modalityLabel, "2, 12");
						
						JLabel modalityOut = new JLabel("New label");
						modalityOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(modalityOut, "6, 12");
						modalityOut.setText(orderTransfer.getModality());
						
						JLabel imagingLabel = new JLabel("Imaging:");
						imagingLabel.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(imagingLabel, "2, 14, default, center");
						
						JLabel imagingOut = new JLabel("New label");
						imagingOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(imagingOut, "6, 14");
						imagingOut.setText(orderTransfer.getImagingOrder());
						
						JLabel filesLabel = new JLabel("Files on Order:");
						filesLabel.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(filesLabel, "2, 16");
						
						JLabel filesOut = new JLabel("New label");
						filesOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(filesOut, "6, 16");
						
						if (orderTransfer.getImages().isEmpty() != true) {
						filesOut.setText(orderTransfer.getImages().get(0).getLabel());
						}
						
						//Generate Sub Action menu buttons
						
						JButton addImageButton = new JButton("Add Images");
						addImageButton.setBounds(10, 35, 203, 23);
						subActionPanel.add(addImageButton);
						
						JButton viewImageButton = new JButton("View Images");
						viewImageButton.setBounds(10, 80, 203, 23);
						subActionPanel.add(viewImageButton);
						
						JButton deleteImageButton = new JButton("Delete Image");
						deleteImageButton.setBounds(10, 125, 203, 23);
						subActionPanel.add(deleteImageButton);
						
						subActionPanel.repaint();
						subActionPanel.revalidate();
						viewPanel.repaint();
						viewPanel.revalidate();
						testLabel.setText("Details button");
						
						testLabel.setText(String.valueOf(radioButtonGroup.getButtonCount()));
						
						ActionListener imageListener = new ActionListener() {
							
							public void actionPerformed(ActionEvent click) {
								
								if (click.getSource() == addImageButton) {
									
									JFileChooser chooser= new JFileChooser();

									int choice = chooser.showOpenDialog(addImageButton);

									if (choice != JFileChooser.APPROVE_OPTION) return;

									File chosenFile = chooser.getSelectedFile();
									
									BufferedImage chosenImage = null;
									try {
										chosenImage = ImageIO.read(chosenFile);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									ImageFile newImage = new ImageFile(LocalDate.now(), chosenImage, chosenFile.getName(), "placeholder");
									
									orderTransfer.getImages().add(newImage);
								}
								
								else if (click.getSource() == viewImageButton || click.getSource() == deleteImageButton) {//THIS IS WHERE I AM CURRENTLY
									
									if (orderTransfer.getImages().isEmpty() != true) {
										
										BufferedImage displayImage = (BufferedImage) orderTransfer.getImages().get(0).getImage();
										ImageIcon icon = new ImageIcon(displayImage);
										JLabel imgLabel = new JLabel(icon);
										
										ImageViewer imageFrame = new ImageViewer();
										imageFrame.setVisible(true);
										imageFrame.viewImagePanel.add(imgLabel);
										imageFrame.viewImagePanel.repaint();
										imageFrame.viewImagePanel.revalidate();
									}
								}
								
							}
							
						};
						
						addImageButton.addActionListener(imageListener);
						viewImageButton.addActionListener(imageListener);
						deleteImageButton.addActionListener(imageListener);
					}
				};
				
				detailsButton.addActionListener(detailsListener);
				
			}
			
		};//end radioListener
		
		//Adds event listener for all action panel buttons, all used to change view panel and subAction panel contents. STILL NEED TO VIEW ORDERS FUNCTIONALITY
		ActionListener actionPanelListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent click) {
				if (click.getSource() == homeButton) {
					//Setup home view, default
					
					subActionPanel.removeAll();
					viewPanel.removeAll();
					subActionPanel.repaint();
					subActionPanel.revalidate();
					viewPanel.repaint();
					viewPanel.revalidate();
					
					testLabel.setText(String.valueOf(radioButtonGroup.getButtonCount()));
					
				}//end homeButton source
				
				else if(click.getSource() == viewButton) {
					//Setup appointment view
					
					subActionPanel.removeAll();
					viewPanel.removeAll();
					
					buttonTracker.clear();
					orderTracker.clear();
					
					ArrayList<Order> appts = new ArrayList<Order>();
					appts.clear();
					
					appts.addAll(Technician.ViewAppointments(LocalDate.now()));
					
					int yValue = 4;
					int xCorrection = 0;
					String buttonXCoordinate = "";
					String buttonYCoordinate =String.valueOf(yValue);
					
					//CREATE ARRAY FOR BUTTONS HERE
					
					//fills out view panel with radio buttons for each order with an appointment set for today's date.
					for(int i = 0; i < appts.size(); i++) {
						
						
						JRadioButton apptRdButton = new JRadioButton("Appt " + (i+1) + ": " + appts.get(i).getApptTime() + " Room: " + appts.get(i).getApptRoom() 
								+ " " + appts.get(i).getImagingOrder());
						
						buttonTracker.add(apptRdButton);
						orderTracker.add(appts.get(i));
						
						buttonXCoordinate = String.valueOf(((i+1)*2)-xCorrection);
						viewPanel.add(apptRdButton, buttonYCoordinate + ", " + buttonXCoordinate);
						apptRdButton.addActionListener(radioListener);
						radioButtonGroup.add(apptRdButton);
						
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
					
					appts.clear();
					
					testLabel.setText(String.valueOf(radioButtonGroup.getButtonCount()));
					
				}//end viewButton source
				
				else if(click.getSource() == viewOrdersButton) {
					//Setup Order view
					
					subActionPanel.removeAll();
					viewPanel.removeAll();
					
					buttonTracker.clear();
					orderTracker.clear();
					
					ArrayList<Order> orders = new ArrayList<Order>();
					orders.clear();
					
					orders.addAll(Technician.ViewOrders());
					
					int yValue = 4;
					int xCorrection = 0;
					String buttonXCoordinate = "";
					String buttonYCoordinate =String.valueOf(yValue);
					
					
					//fills out view panel with radio buttons for each order that has not been completed.
					for(int i = 0; i < orders.size(); i++) {
						
						JRadioButton orderRdButton = new JRadioButton("Order " + ": " + orders.get(i).getOrderID() + " Room: " + orders.get(i).getApptRoom() + " " + orders.get(i).getImagingOrder());
						buttonXCoordinate = String.valueOf(((i+1)*2)-xCorrection);
						viewPanel.add(orderRdButton, buttonYCoordinate + ", " + buttonXCoordinate);
						orderRdButton.addActionListener(radioListener);
						radioButtonGroup.add(orderRdButton);
						
						buttonTracker.add(orderRdButton);
						orderTracker.add(orders.get(i));
						
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
					
					orders.clear();
					
					testLabel.setText(String.valueOf(radioButtonGroup.getButtonCount()));
				}//end viewOrdersButton source
				
			}//end actionPerformed
		};//end actionPanelListener
		
		homeButton.addActionListener(actionPanelListener);
		viewButton.addActionListener(actionPanelListener);
		viewOrdersButton.addActionListener(actionPanelListener);

	}//end initialize
	
}
