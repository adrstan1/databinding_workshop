package org.rosedu.databinding.models.bean;

import org.rosedu.databinding.models.bean.BeanAddress;
import org.rosedu.databinding.utils.ICloneable;

/**
 * A Java Bean class modeling a customer.
 * We use data binding to synchronize the properties of customer objects
 * with the user interface.
 * The synchronization is bidirectional, between the UI and the model objects. 
 */
public class BeanCustomer extends AbstractBeanModelObject implements ICloneable<BeanCustomer> {
	
	private String firstName;
	private String lastName;
	private int age;
	private boolean vip;
	private BeanAddress address;
	
	public BeanCustomer() {
		super();
		firstName = "";
		lastName = "";
		age = 0;
		vip = false;
		address = new BeanAddress();
	}
	
	public BeanCustomer cloneObject() {
		BeanCustomer newObj = new BeanCustomer();
		newObj.firstName = firstName;
		newObj.lastName = lastName;
		newObj.age = age;
		newObj.vip = vip;
		newObj.address = address.cloneObject();
		return newObj;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		String oldValue = this.firstName;
		this.firstName = firstName;
		firePropertyChange("firstName", oldValue, this.firstName);
	}
	
	/**
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		String oldValue = this.lastName;
		this.lastName = lastName;
		firePropertyChange("lastName", oldValue, this.lastName);
	}
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		int oldValue = this.age;
		this.age = age;
		firePropertyChange("age", oldValue, this.age);
	}
	
	/**
	 * @return check VIP status
	 */
	public boolean isVip() {
		return vip;
	}
	
	/**
	 * @param vip the VIP status
	 */
	public void setVip(boolean vip) {
		boolean oldValue = this.vip;
		this.vip = vip;
		firePropertyChange("vip", oldValue, this.vip);
	}

	/**
	 * @return the address
	 */
	public BeanAddress getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(BeanAddress address) {
		BeanAddress oldValue = this.address;
		this.address = address;
		firePropertyChange("address", oldValue, this.address);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("Customer:\n");
		sb.append("First name = " + firstName + "\n");
		sb.append("Last name = " + lastName + "\n");
		sb.append("Age = " + age + "\n");
		sb.append("VIP = " + vip + "\n\n");
		sb.append(address + "\n");
		return sb.toString();
	}
}
