import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;

public class UIManager {

	protected Shell shell;
	private Text usernameBox;
	private Text passBox;
	
	
	//temp usernames and passwords to test login
	//admin, adminPass;
	//dr, drPass;
	//recep, recepPass;
	//tech, techPass;
	//radio, radioPass

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		try {
			UIManager window = new UIManager();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		loadLogin();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Xamine");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmXaminev = new MenuItem(menu, SWT.NONE);
		mntmXaminev.setText("XamineV.0273316");
		
		new MenuItem(menu, SWT.SEPARATOR);
		
		MenuItem mntmCurrentUserHere = new MenuItem(menu, SWT.NONE);
		mntmCurrentUserHere.setEnabled(false);
		
		MenuItem mntmLogOut = new MenuItem(menu, SWT.NONE);
		mntmLogOut.setEnabled(false);
		mntmLogOut.setText("Log out");
	
	}//end createContents

	/*Loads in login composite, new composite will be loaded in based on user logging in. 
	*Dr login will remove this composite and load Dr portal composite, admin admin portal, etc.
	*Logging a user out will reload this composite.
	*/
	protected void loadLogin() {
		
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 434, 241);
		
		usernameBox = new Text(composite, SWT.BORDER);
		usernameBox.setLocation(132, 71);
		usernameBox.setSize(156, 21);
		
		passBox = new Text(composite, SWT.BORDER);
		passBox.setLocation(129, 101);
		passBox.setSize(156, 21);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLocation(48, 68);
		lblNewLabel.setSize(74, 30);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("Username:");
		
		Label lblPassword = new Label(composite, SWT.NONE);
		lblPassword.setLocation(52, 100);
		lblPassword.setSize(74, 30);
		lblPassword.setAlignment(SWT.CENTER);
		lblPassword.setText("Password:");
		
		Label lblLoginMessage = new Label(composite, SWT.NONE);
		lblLoginMessage.setLocation(48, 187);
		lblLoginMessage.setSize(344, 15);
		lblLoginMessage.setAlignment(SWT.CENTER);
		lblLoginMessage.setEnabled(false);
		lblLoginMessage.setText("Put messages here");
		
				
				
				Button btnLogin = new Button(composite, SWT.NONE);
				btnLogin.setLocation(164, 137);
				btnLogin.setSize(75, 25);
				btnLogin.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						
						String usernameIn = usernameBox.getText();
						String passIn = passBox.getText();
						String currentUserFirstN = "";
						String currentUserLastN = "";
						
						/*using temp usernames and passwords for testing, this should be handled by SQL calls to check if username exists and the password matches, 
						once database is set up*/
						switch(usernameIn) {
							case "dr": 
								if (passIn.equals("drPass")) {
									lblLoginMessage.setText("Dr login successful");
									mntmLogOut.setEnabled(true);
									currentUserFirstN = "Dr";
									currentUserLastN = "User";
									mntmCurrentUserHere.setText(currentUserFirstN + " " + currentUserLastN);
									mntmCurrentUserHere.setEnabled(true);
								}
								else
									lblLoginMessage.setText("Invalid Password " + "password entered: " + passIn);		
								break;
							case "admin": 
								if (passIn.equals("adminPass")) {
									lblLoginMessage.setText("Admin login successful");
									mntmLogOut.setEnabled(true);
									currentUserFirstN = "Sue";
									currentUserLastN = "Storm";
									mntmCurrentUserHere.setText(currentUserFirstN + " " + currentUserLastN);
									mntmCurrentUserHere.setEnabled(true);
								}
								else 
									lblLoginMessage.setText("Invalid Password " + "password entered: " + passIn);
								break;
							case "recep": 
								if (passIn.equals("recepPass")) {
									lblLoginMessage.setText("Receptionist login successful");
									mntmLogOut.setEnabled(true);
									currentUserFirstN = "Jay";
									currentUserLastN = "Desk";
									mntmCurrentUserHere.setText(currentUserFirstN + " " + currentUserLastN);
									mntmCurrentUserHere.setEnabled(true);
								}
								else
									lblLoginMessage.setText("Invalid Password " + "password entered: " + passIn);			
								break;
							case "tech": 
								if (passIn.equals("techPass")) {
									lblLoginMessage.setText("Technician login successful");
									mntmLogOut.setEnabled(true);
									currentUserFirstN = "John";
									currentUserLastN = "Techie";
									mntmCurrentUserHere.setText(currentUserFirstN + " " + currentUserLastN);
									mntmCurrentUserHere.setEnabled(true);
								}
								else
									lblLoginMessage.setText("Invalid Password " + "password entered: " + passIn);	
								break;
							case "radio": 
								if (passIn.equals("radioPass")) {
									lblLoginMessage.setText("Radiologist login successful");
									mntmLogOut.setEnabled(true);
									currentUserFirstN = "Dr";
									currentUserLastN = "Radio";
									mntmCurrentUserHere.setText(currentUserFirstN + " " + currentUserLastN);
									mntmCurrentUserHere.setEnabled(true);
								}
								else
									lblLoginMessage.setText("Invalid Password " + "password entered: " + passIn);
								break;
							default:
								lblLoginMessage.setText("Login unsuccessful " + "Username: " + usernameIn + " " + "Password: " + passIn);
						
						}
						
					}
				});
				btnLogin.setText("Login");
		

	}
	
}
