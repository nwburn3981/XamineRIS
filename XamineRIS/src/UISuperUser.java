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

public class UISuperUser extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UISuperUser window = new UISuperUser();
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
	public UISuperUser() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		panel.setBounds(0, 0, 1178, 25);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nameSpace = new JLabel("Xamine V.2382777");
		nameSpace.setBounds(0, 0, 125, 23);
		panel.add(nameSpace);
		nameSpace.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton logoutButton = new JButton("Log out");
		logoutButton.setBounds(1043, 0, 125, 23);
		panel.add(logoutButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 37, 123, 425);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton viewButton = new JButton("View User");
		viewButton.setBounds(10, 120, 89, 23);
		panel_1.add(viewButton);
		
		JButton editUserButton = new JButton("Edit User");
		editUserButton.setBounds(10, 154, 89, 23);
		panel_1.add(editUserButton);
		
		JButton deleteButton = new JButton("Delete User");
		deleteButton.setBounds(10, 188, 89, 23);
		panel_1.add(deleteButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(138, 36, 1040, 426);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea txtrHowDoesThis = new JTextArea();
		txtrHowDoesThis.setText("HOw does this work? I dont know oh god oh jeez");
		txtrHowDoesThis.setBounds(10, 11, 1020, 404);
		panel_2.add(txtrHowDoesThis);
	}
}