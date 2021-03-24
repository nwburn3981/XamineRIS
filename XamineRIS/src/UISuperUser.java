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

		JPanel actionPanel = new JPanel();
		actionPanel.setBounds(10, 37, 239, 214);
		frame.getContentPane().add(actionPanel);
		actionPanel.setLayout(null);
	}
}
