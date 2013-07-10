package org.rosedu.databinding.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "org.rosedu.databinding.view";

	private TabFolder tabFolder;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		tabFolder = new TabFolder(parent, SWT.TOP);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createPojoSampleTableItem();
		createBeanSampleTableItem();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		tabFolder.setFocus();
	}
	
	private void createPojoSampleTableItem() {
		TabItem pojoTabItem = new TabItem(tabFolder, SWT.NONE);
		pojoTabItem.setText("Pojo Model example");
		SwtPojoModelExample pojoSample = new SwtPojoModelExample(tabFolder, SWT.NONE);
		pojoTabItem.setControl(pojoSample);
	}
	
	private void createBeanSampleTableItem() {
		TabItem beanTabItem = new TabItem(tabFolder, SWT.NONE);
		beanTabItem.setText("Bean Model example");
		SwtBeanModelExample pojoSample = new SwtBeanModelExample(tabFolder, SWT.NONE);
		beanTabItem.setControl(pojoSample);
	}
}