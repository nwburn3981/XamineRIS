import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JLabel;

public class ImageViewer extends JFrame {

	JPanel contentPane;
	JPanel viewImagePanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageViewer frame = new ImageViewer();
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
	public ImageViewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton prevButton = new JButton("Previous Image");
		prevButton.setBounds(10, 227, 130, 23);
		contentPane.add(prevButton);
		
		viewImagePanel.setBounds(10, 11, 414, 205);
		contentPane.add(viewImagePanel);
		viewImagePanel.setLayout(null);
		
		JLabel imageLabel = new JLabel("New label");
		imageLabel.setBounds(184, 5, 46, 14);
		viewImagePanel.add(imageLabel);
		
		JButton nextButton = new JButton("Next Image");
		nextButton.setBounds(294, 227, 130, 23);
		contentPane.add(nextButton);
		
		JButton deleteButton = new JButton("Delete Image");
		deleteButton.setBounds(150, 227, 130, 23);
		contentPane.add(deleteButton);
	}
	
	public void paintComponent(Graphics g) {}
}
