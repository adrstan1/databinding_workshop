package org.rosedu.databinding.ui;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
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
import org.rosedu.databinding.dao.IModelDao;
import org.rosedu.databinding.models.bean.BeanCustomer;
import org.rosedu.databinding.models.bean.SimpleBeanCustomerDao;
import org.rosedu.databinding.validators.AgeValidator;

public class SwtBeanModelExample extends Composite {
	
	private Text firstNameTxt;
	private Text lastNameTxt;
	private Text ageTxt;
	private Text cityTxt;
	private Button vipBtn;
	
	private DataBindingContext bindingContext;
	
	private BeanCustomer customer;
	private WritableValue customerValue;
	private IModelDao<BeanCustomer> customerDao;

	public SwtBeanModelExample(Composite parent, int style) {
		super(parent, style);
		customerValue = new WritableValue();
		customerDao = new SimpleBeanCustomerDao();
		customer = getFirstCustomer();
		creatUi(parent);
		attachListeners();
		createDataBinding();
	}
	
	private BeanCustomer getFirstCustomer() {
		customerDao.moveFirst();
		return customerDao.getCurrentRecord();
	}
	
	private void creatUi(Composite parent) {
		this.setLayout(new GridLayout(2, false));

		Label firstNameLbl = new Label(this, SWT.NONE);
		firstNameLbl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false));
		firstNameLbl.setText("First name");
		firstNameTxt = new Text(this, SWT.BORDER);
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

		vipBtn = new Button(this, SWT.CHECK);
		vipBtn.setText("VIP");
		vipBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 2, 1));

		Button showModelBtn = new Button(this, SWT.PUSH);
		showModelBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 2, 1));
		showModelBtn.setText("Show model customer");
		showModelBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(Display.getDefault()
						.getActiveShell(), "", customer.toString());
			}

		});
		
		Button showStoredBtn = new Button(this, SWT.PUSH);
		showStoredBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 2, 1));
		showStoredBtn.setText("Show stored customer");
		showStoredBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(Display.getDefault()
						.getActiveShell(), "", customerDao.getCurrentRecord().toString());

			}

		});
		
		Button setVipBtn = new Button(this, SWT.PUSH);
		setVipBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 2, 1));
		setVipBtn.setText("Change VIP status");
		setVipBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				customer.setVip(!customer.isVip());
			}

		});
		
		Button nextBtn = new Button(this, SWT.PUSH);
		GridData nextBtnData = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		nextBtnData.widthHint = 70;
		nextBtn.setLayoutData(nextBtnData);
		nextBtn.setText("Next");
		nextBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (customerDao.hasNext()) {
					customerDao.moveNext();
					customer = customerDao.getCurrentRecord();
					customerValue.setValue(customer); 
				}
			}

		});
		
		Button prevBtn = new Button(this, SWT.PUSH);
		GridData prevBtnData = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		prevBtnData.widthHint = 70;
		prevBtn.setLayoutData(prevBtnData);
		prevBtn.setText("Previous");
		prevBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (customerDao.hasPrevious()) {
					customerDao.movePrevious();
					customer = customerDao.getCurrentRecord();
					customerValue.setValue(customer);
				}
			}

		});
		
		Button applyBtn = new Button(this, SWT.PUSH);
		GridData applyBtnData = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		applyBtnData.widthHint = 70;
		applyBtn.setLayoutData(applyBtnData);
		applyBtn.setText("Apply");
		applyBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				customerDao.saveCurrentRecord(customer);
			}

		});
		
		Button revertBtn = new Button(this, SWT.PUSH);
		GridData revertBtnData = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		revertBtnData.widthHint = 70;
		revertBtn.setLayoutData(revertBtnData);
		revertBtn.setText("Revert");
		revertBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				customer = customerDao.getCurrentRecord();
				customerValue.setValue(customer);
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
		IObservableValue modelValue = BeanProperties.value(BeanCustomer.class, "firstName").
				observeDetail(customerValue);
		bindingContext.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(lastNameTxt);
		modelValue = BeanProperties.value(BeanCustomer.class, "lastName").
				observeDetail(customerValue);
		bindingContext.bindValue(widgetValue, modelValue);
		
		// Set a validator.
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		IValidator validator = new AgeValidator();
		strategy.setBeforeSetValidator(validator);
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(ageTxt);
		modelValue = BeanProperties.value(BeanCustomer.class, "age").
				observeDetail(customerValue);
		Binding bindValue = bindingContext.bindValue(widgetValue, modelValue, strategy, null);
		// Add some decorations.
	    ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.LEFT);
		
		widgetValue = WidgetProperties.text(SWT.Modify).
				observe(cityTxt);
		modelValue = BeanProperties.value(BeanCustomer.class, "address.city").
				observeDetail(customerValue);
		bindingContext.bindValue(widgetValue, modelValue);
		
		widgetValue = WidgetProperties.selection().
				observe(vipBtn);
		modelValue = BeanProperties.value(BeanCustomer.class, "vip").
				observeDetail(customerValue);
		bindingContext.bindValue(widgetValue, modelValue);

		customerValue.setValue(customer); 
	}
}
