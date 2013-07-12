package org.rosedu.databinding.ui;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
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
import org.rosedu.databinding.models.emf.customers.Address;
import org.rosedu.databinding.models.emf.customers.Customer;
import org.rosedu.databinding.models.emf.customers.CustomersFactory;
import org.rosedu.databinding.models.emf.customers.CustomersPackage;
import org.rosedu.databinding.validators.AgeValidator;

public class SwtEMFModelExample extends Composite {
	
	private Text firstNameTxt;
	private Text lastNameTxt;
	private Text ageTxt;
	private Text cityTxt;
	private Button vipBtn;
	
	private DataBindingContext bindingContext;
	
	private Customer customer;
	
	public SwtEMFModelExample(Composite parent, int style) {
		super(parent, style);
		customer = createCustomer();
		createUi(parent);
		attachListeners();
		createDataBinding();
	}
		
	private void createUi(Composite parent) {
		this.setLayout(new GridLayout(2, false));

		Label firstNameLbl = new Label(this, SWT.NONE);
		firstNameLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		firstNameLbl.setText("First name");
		firstNameTxt = new Text(this, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		firstNameTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label lastNameLbl = new Label(this, SWT.NONE);
		lastNameLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		lastNameLbl.setText("Last name");
		lastNameTxt = new Text(this, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		lastNameTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label ageLbl = new Label(this, SWT.NONE);
		ageLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		ageLbl.setText("Age");
		ageTxt = new Text(this, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		ageTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label cityLbl = new Label(this, SWT.NONE);
		cityLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		cityLbl.setText("City");
		cityTxt = new Text(this, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		cityTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		vipBtn = new Button(this, SWT.CHECK);
		vipBtn.setText("VIP");

		Button showBtn = new Button(this, SWT.PUSH);
		showBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		showBtn.setText("Show customer");

		showBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(Display.getDefault()
						.getActiveShell(), "", customer.toString());
			}

		});
	}
	
	private void attachListeners() {
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
		IObservableValue widgetValue = WidgetProperties.text(SWT.Modify).
				observe(firstNameTxt);
		IObservableValue modelValue = EMFProperties.value(CustomersPackage.Literals.CUSTOMER__FIRST_NAME).
				observe(customer);
		bindingContext.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(lastNameTxt);
		modelValue = EMFProperties.value(CustomersPackage.Literals.CUSTOMER__LAST_NAME).
				observe(customer);
		bindingContext.bindValue(widgetValue, modelValue);
		
		// Set a validator.
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		IValidator validator = new AgeValidator();
		strategy.setConverter(new IConverter() {
			
			@Override
			public Object getToType() {
				return Integer.class;
			}
			
			@Override
			public Object getFromType() {
				return String.class;
			}
			
			@Override
			public Object convert(Object fromObject) {
				if (fromObject == null || fromObject.toString().isEmpty()) {
					return 0;
				}
				return Integer.parseInt((String)fromObject);
			}
		});
		
		
		
		strategy.setBeforeSetValidator(validator);
		
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(ageTxt);
		modelValue = EMFProperties.value(CustomersPackage.Literals.CUSTOMER__AGE).
				observe(customer);
		//Binding bindValue = bindingContext.bindValue(widgetValue, modelValue);
		Binding bindValue = bindingContext.bindValue(widgetValue, modelValue, strategy, null);
		// Add some decorations.
	    ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);
		
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(cityTxt);
		FeaturePath feature = FeaturePath.fromList(CustomersPackage.Literals.CUSTOMER__ADDRESS,
				CustomersPackage.Literals.ADDRESS__CITY);
		modelValue = EMFProperties.value(feature).
				observe(customer);
		bindingContext.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.selection().
				observe(vipBtn);
		modelValue = EMFProperties.value(CustomersPackage.Literals.CUSTOMER__VIP).
				observe(customer);
		bindingContext.bindValue(widgetValue, modelValue);
	}
	
	private Customer createCustomer() {
		// Initialize the model
	    CustomersPackage.eINSTANCE.eClass();
	    // Retrieve the default factory singleton
	    CustomersFactory factory = CustomersFactory.eINSTANCE;

	    final Customer customer = factory.createCustomer();
	    customer.setFirstName("Ion");
	    customer.setLastName("Ionescu");
	    customer.setAge(35);
	    customer.setVip(true);
	    Address address = factory.createAddress();
		address.setCountry("Romania");
		address.setCity("Bucharest");
		address.setStreet("Primaverii");
		address.setNumber("100");
		address.setPostalCode("12345");
	    customer.setAddress(address);
	    return customer;
	}
}
