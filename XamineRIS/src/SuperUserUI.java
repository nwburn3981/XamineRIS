import org.eclipse.swt.widgets.Composite;

public class SuperUserUI extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SuperUserUI(Composite parent, int style) {
		super(parent, style);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
