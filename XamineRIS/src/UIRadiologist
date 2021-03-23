import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIRadiologist implements ActionListener {
	
	private int count = 0;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	

	public UIRadiologist () {
		
		
		frame = new JFrame ();
		JButton button = new JButton(" null ");
		button.addActionListener(this);
		
		label = new JLabel (" null ");
		
		
		
	
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(400,400,200,400));
		panel.setLayout( new GridLayout(0, 1));
		panel.add(button);
		panel.add(label);
		
		
		
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(" null ");
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		new UIRadiologist();
		
		
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
	
	
