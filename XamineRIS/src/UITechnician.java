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
//Send order method is finished but has bug that should be fixed by SQL introduction
//Implement allergy conflict

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
	private int currentIndex = 0;

	/**
	 * Launch the application.
	 */
	public static void main(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new UITechnician(user);
					window.frame.setVisible(true);
				}//end try
				catch (Exception e) {
					e.printStackTrace();
				}//end catch
			}//end run
		}//end Runnable
		);
	}//end main

	/**
	 * Create the application.
	 */
	public UITechnician(User user) {
		currentUser = user;
		initialize();
	}//end UITechnician

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
		
		JLabel versionText = new JLabel("Technician Portal");
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
				
			}//end Action
		};//end logoutListener
			
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
		
		JLabel testLabel = new JLabel("Test");
		testLabel.setBounds(10, 164, 203, 14);
		actionPanel.add(testLabel);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(10, 41, 203, 23);
		
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
						
						JLabel filesOut = new JLabel();
						filesOut.setHorizontalAlignment(SwingConstants.CENTER);
						viewPanel.add(filesOut, "6, 16");
						
						if (orderTransfer.getImages().isEmpty() != true) {
							
							for(int i = 0; i < orderTransfer.getImages().size(); i++) {
								filesOut.setText(filesOut.getText() + orderTransfer.getImages().get(i).getLabel() + "   ");
							}//end for
						}//end if
						
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
						
						JButton submitOrderButton = new JButton("Submit Order");
						submitOrderButton.setBounds(10, 170, 203, 23);
						subActionPanel.add(submitOrderButton);
						
						subActionPanel.repaint();
						subActionPanel.revalidate();
						viewPanel.repaint();
						viewPanel.revalidate();
						
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
									}//end try 
									catch (IOException e) {
										
										e.printStackTrace();
									}//end catch
									
									ImageFile newImage = new ImageFile(LocalDate.now(), chosenImage, chosenFile.getName(), "placeholder");
									
									orderTransfer.getImages().add(newImage);
									int index = orderTransfer.getImages().indexOf(newImage);
									
									filesOut.setText(filesOut.getText() + "   " + orderTransfer.getImages().get(index).getLabel());
									
									//Create method for each event, easier to call on several which may be what is needed to function properly
								}//end if
								
								else if (click.getSource() == viewImageButton || click.getSource() == deleteImageButton) {//THIS IS WHERE I AM CURRENTLY
									
									if (orderTransfer.getImages().isEmpty() != true) {
										
										BufferedImage displayImage = (BufferedImage) orderTransfer.getImages().get(0).getImage();
										ImageIcon icon = new ImageIcon(displayImage);
										
										JLabel imageLabel = new JLabel(icon);
										imageLabel.setBounds(184, 5, 46, 14);
										
										ImageViewer imageFrame = new ImageViewer();
										imageFrame.setVisible(true);
										
										JButton nextButton = new JButton("Next Image");
										nextButton.setBounds(514, 431, 130, 23);
										imageFrame.contentPane.add(nextButton);
										
										JButton prevButton = new JButton("Previous Image");
										prevButton.setBounds(234, 431, 130, 23);
										imageFrame.contentPane.add(prevButton);
										
										JButton deleteButton = new JButton("Delete Image");
										deleteButton.setBounds(374, 431, 130, 23);
										imageFrame.contentPane.add(deleteButton);
										
										imageFrame.viewImagePanel.add(imageLabel, BorderLayout.CENTER);
										imageFrame.viewImagePanel.repaint();
										imageFrame.viewImagePanel.revalidate();
										
										ActionListener imageFrameListener = new ActionListener() {
										
											public void actionPerformed(ActionEvent click) {
												
												BufferedImage currentImage;
												ImageIcon currentIcon = new ImageIcon();
												
												if (click.getSource() == nextButton) {
													
													if (currentIndex + 1 < orderTransfer.getImages().size()) {
														
														currentIndex = currentIndex+1;
														currentImage = (BufferedImage) orderTransfer.getImages().get(currentIndex).getImage();
														currentIcon.setImage(currentImage); 
														imageLabel.setIcon(currentIcon);
														imageFrame.viewImagePanel.repaint();
														imageFrame.viewImagePanel.revalidate();
														
													
													}//end nested if
													
													else {
														
														currentIndex = 0;
														currentImage = (BufferedImage) orderTransfer.getImages().get(currentIndex).getImage();
														currentIcon.setImage(currentImage); 
														imageLabel.setIcon(currentIcon);
														imageFrame.viewImagePanel.repaint();
														imageFrame.viewImagePanel.revalidate();
														
													}//end nested else
													
												}//end if
												
												else if (click.getSource() == prevButton) {
													
													if (currentIndex -1 >= 0) {
														
														currentIndex = currentIndex-1;
														currentImage = (BufferedImage) orderTransfer.getImages().get(currentIndex).getImage();
														currentIcon.setImage(currentImage); 
														imageLabel.setIcon(currentIcon);
														imageFrame.viewImagePanel.repaint();
														imageFrame.viewImagePanel.revalidate();
														
													
													}//end nested if
													
													else {
														
														currentIndex = orderTransfer.getImages().size()-1;
														currentImage = (BufferedImage) orderTransfer.getImages().get(currentIndex).getImage();
														currentIcon.setImage(currentImage); 
														imageLabel.setIcon(currentIcon);
														imageFrame.viewImagePanel.repaint();
														imageFrame.viewImagePanel.revalidate();
														
													}//end nested else
													
												}//end else if
												
												else if (click.getSource() == deleteButton) {
													
													if (orderTransfer.getImages().size() <= 1) {
														
														orderTransfer.getImages().clear();
														imageLabel.setIcon(null);
														imageLabel.setText("No images");
														imageFrame.viewImagePanel.repaint();
														imageFrame.viewImagePanel.revalidate();
													}//end nested if
													
													else {
														orderTransfer.getImages().remove(currentIndex);
														currentImage = (BufferedImage) orderTransfer.getImages().get(currentIndex).getImage();
														currentIcon.setImage(currentImage); 
														imageLabel.setIcon(currentIcon);
														imageFrame.viewImagePanel.repaint();
														imageFrame.viewImagePanel.revalidate();
													}//end else
												}//end else if
											}//end Action
										};//end imageFrameListener
										
										
										nextButton.addActionListener(imageFrameListener);
										prevButton.addActionListener(imageFrameListener);
										deleteButton.addActionListener(imageFrameListener);
										
										
									}//end if
										
								}//end else if
							}//end Action
								
							};//end imageListener
							
							ActionListener submitListener = new ActionListener() {

							
								public void actionPerformed(ActionEvent click) {
									
									if (click.getSource() == submitOrderButton) {
										
										if(orderTransfer.getImages().size() > 0) {
											
											orderTransfer.setOrderStatus("Complete");
											orderStatusOut.setText(orderTransfer.getOrderStatus());
											testLabel.setText(orderTransfer.getOrderStatus());
										}//end nested if
										
										else if(orderTransfer.getImages().size() == 0) {
											
											testLabel.setText("No images on order");
										}//end nested else
										
									}//end if
									
								}//end Action
								
								
							};//end submitListener
						
						addImageButton.addActionListener(imageListener);
						viewImageButton.addActionListener(imageListener);
						deleteImageButton.addActionListener(imageListener);
						submitOrderButton.addActionListener(submitListener);
						
					}//end Action
				};//end detailsListener
				
				detailsButton.addActionListener(detailsListener);
				
			}//end Action
			
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

				}//end viewOrdersButton source
				
			}//end actionPerformed
		};//end actionPanelListener
		
		homeButton.addActionListener(actionPanelListener);
		viewButton.addActionListener(actionPanelListener);
		viewOrdersButton.addActionListener(actionPanelListener);

	}//end initialize
	
	private void updateDetails() {
		
		
	}
}
