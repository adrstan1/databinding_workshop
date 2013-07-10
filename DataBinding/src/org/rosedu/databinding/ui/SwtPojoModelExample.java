package org.rosedu.databinding.ui;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.rosedu.databinding.models.pojo.PojoCustomer;
import org.rosedu.databinding.models.pojo.SimplePojoCustomerDao;
import org.rosedu.databinding.validators.AgeValidator;

/**
 * Class used for building the UI and performing the data binding.
 */
public class SwtPojoModelExample extends Composite {
	
	// A text control bound to PojoCustomer.firstName property
	private Text firstNameTxt;
	// A text control bound to PojoCustomer.lastName property
	private Text lastNameTxt;
	// A text control bound to PojoCustomer.age property
	private Text ageTxt;
	// A text control bound to PojoCustomer.address.city property
	private Text cityTxt;
	// A text control bound to PojoCustomer.vip property
	private Button vipBtn;
	
	// The data binding context used to make the bindings.
	private DataBindingContext bindingContext;
	
	// The domain model object represented in the UI.
	private PojoCustomer customer;
	
	// A provider used for getting the domain model object.
	private SimplePojoCustomerDao customerDao;

	public SwtPojoModelExample(Composite parent, int style) {
		super(parent, style);
		customerDao = new SimplePojoCustomerDao();
		customer = customerDao.getCustomer();
		createUi(parent);
		attachListeners();
		createDataBinding();
	}
		
	private void createUi(Composite parent) {
		// Set a 2 column grid layout.
		this.setLayout(new GridLayout(2, false));

		// Create a label with the text "First name" and set
		// it in the left horizontal side.
		Label firstNameLbl = new Label(this, SWT.NONE);
		firstNameLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		firstNameLbl.setText("First name");
		// Create a text widget for the customer first name.
		firstNameTxt = new Text(this, SWT.BORDER);
		// Fill the remaining space after the label.
		firstNameTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label lastNameLbl = new Label(this, SWT.NONE);
		lastNameLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		lastNameLbl.setText("Last name");
		lastNameTxt = new Text(this, SWT.BORDER);
		lastNameTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label ageLbl = new Label(this, SWT.NONE);
		ageLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		ageLbl.setText("Age");
		ageTxt = new Text(this, SWT.BORDER);
		ageTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label cityLbl = new Label(this, SWT.NONE);
		cityLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		cityLbl.setText("City");
		cityTxt = new Text(this, SWT.BORDER);
		cityTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// Create a checkbox for the VIP state.
		vipBtn = new Button(this, SWT.CHECK);
		vipBtn.setText("VIP");

		// Create a button for displaying the model object.
		Button showBtn = new Button(this, SWT.PUSH);
		showBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		showBtn.setText("Show customer");

		// Add a selection listener. When the button is pressed, we display
		// the content of the model object in a message dialog.
		showBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(Display.getDefault()
						.getActiveShell(), "", customer.toString());
			}

		});
	}
	
	private void attachListeners() {
		// Dispose the binding context when the widget is disposed.
		this.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (bindingContext != null) {
					bindingContext.dispose();
				}
			}
		});
	}
	
	private void createDataBinding() {
		bindingContext = new DataBindingContext();
		bindData();
	}
	
	private void bindData() {
		// Bind the firstNameTxt widget to PojoCustomer.firstName 
		IObservableValue widgetValue = WidgetProperties.text(SWT.Modify).
				observe(firstNameTxt);
		IObservableValue modelValue = PojoProperties.value(PojoCustomer.class, "firstName").
				observe(customer);
		bindingContext.bindValue(widgetValue, modelValue);
		
		// Bind the lastNameTxt widget to PojoCustomer.firstName
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(lastNameTxt);
		modelValue = PojoProperties.value(PojoCustomer.class, "lastName").
				observe(customer);
		bindingContext.bindValue(widgetValue, modelValue);
		
		// Set a validator for the customer age.
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		IValidator validator = new AgeValidator();
		strategy.setBeforeSetValidator(validator);
		
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(ageTxt);
		modelValue = PojoProperties.value(PojoCustomer.class, "age").
				observe(customer);
		Binding bindValue = bindingContext.bindValue(widgetValue, modelValue, strategy, null);
		// Add some decorations to display validation errors.
	    ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);
		
	    // Bind the city text widget to PojoCustomer.address.city
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(cityTxt);
		modelValue = PojoProperties.value(PojoCustomer.class, "address.city").
				observe(customer);
		bindingContext.bindValue(widgetValue, modelValue);
		
		// Bind the checkbox widget to PojoCustomer.vip
		widgetValue = WidgetProperties.selection().
				observe(vipBtn);
		modelValue = PojoProperties.value(PojoCustomer.class, "vip").
				observe(customer);
		bindingContext.bindValue(widgetValue, modelValue);
	}
}
