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
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Action;

public class UITechnician extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UITechnician window = new UITechnician();
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
	public UITechnician() {
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
		
		JLabel nameSpace = new JLabel("Username");
		nameSpace.setHorizontalAlignment(SwingConstants.CENTER);
		nameSpace.setBounds(384, 4, 75, 14);
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
		
		//End initial setup-------------------------------------------------------------------------------------------------
		
		//First Listener for radio button selection, selecting a radio button for either orders or appointments will generate a "Details" button
		ActionListener radioListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent selection) {
				
				JButton btnDetails = new JButton("Details");
				btnDetails.setBounds(10, 143, 203, 23);
				actionPanel.add(btnDetails);
				actionPanel.repaint();
				actionPanel.revalidate();
				
			}
			
		};//end radioListener
		
		//Adds event listener for all action panel buttons, all used to change view panel and subAction panel contents. STILL NEED TO ADD DETAILS AND VIEW ORDERS FUNCTIONALITY
		ActionListener actionPanelListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent click) {
				if (click.getSource() == homeButton) {
					//Setup home view, default
					subActionPanel.removeAll();
					viewPanel.removeAll();
					
					JRadioButton rdbtnNewRadioButton = new JRadioButton("Home test");
					viewPanel.add(rdbtnNewRadioButton, "4, " + "2");
					subActionPanel.repaint();
					subActionPanel.revalidate();
					viewPanel.repaint();
					viewPanel.revalidate();
					
					testLabel.setText("Home button");
					
				}//end homeButton source
				
				else if(click.getSource() == viewButton) {
					//Setup appointment view
					
					subActionPanel.removeAll();
					viewPanel.removeAll();
					
					
					ArrayList<Order> appts = new ArrayList<Order>();
					appts.clear();
					
					appts.addAll(Technician.ViewAppointments(LocalDate.now()));
					
					int yValue = 4;
					int xCorrection = 0;
					String buttonXCoordinate = "";
					String buttonYCoordinate =String.valueOf(yValue);
					
					//fills out view panel with radio buttons for each order with an appointment set for today's date.
					for(int i = 0; i < appts.size(); i++) {
						
						JRadioButton rdbtnNewRadioButton = new JRadioButton("Appt " + (i+1) + ": " + appts.get(i).getApptTime() + " Room: " + appts.get(i).getApptRoom() + " " + appts.get(i).getImagingOrder());
						buttonXCoordinate = String.valueOf(((i+1)*2)-xCorrection);
						viewPanel.add(rdbtnNewRadioButton, buttonYCoordinate + ", " + buttonXCoordinate);
						rdbtnNewRadioButton.addActionListener(radioListener);
						
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
					
					JRadioButton rdbtnNewRadioButton = new JRadioButton("Appt test");
					viewPanel.add(rdbtnNewRadioButton, "4, " + "2");
					subActionPanel.repaint();
					subActionPanel.revalidate();
					viewPanel.repaint();
					viewPanel.revalidate();
					testLabel.setText("Order button");
				}//end viewOrdersButton source
				
			}//end actionPerformed
		};//end actionPanelListener
		
		homeButton.addActionListener(actionPanelListener);
		viewButton.addActionListener(actionPanelListener);
		viewOrdersButton.addActionListener(actionPanelListener);

	}//end initialize
	

	//Will generate buttons when details view is selected, still needs to be implemented, may not need to be its own method
	public void GenerateDetailView() {
		
		JPanel subActionPanel = new JPanel();
		subActionPanel.setLayout(null);
		subActionPanel.setBounds(10, 248, 239, 214);
		frame.getContentPane().add(subActionPanel);
		
		JButton addImageButton = new JButton("Add Images");
		addImageButton.setBounds(10, 35, 203, 23);
		subActionPanel.add(addImageButton);
		
		JButton viewImageButton = new JButton("View Images");
		viewImageButton.setBounds(10, 81, 203, 23);
		subActionPanel.add(viewImageButton);
		
		JButton deleteImageButton = new JButton("Delete Image");
		deleteImageButton.setBounds(10, 125, 203, 23);
		subActionPanel.add(deleteImageButton);
		
	}//end GenerateDetailsView

}
