package org.rosedu.databinding.models.pojo;

/**
 * POJO model class for a customer.
 * We use data binding to synchronize the properties of customer objects
 * with the user interface.
 * The synchronization is one-way, from UI to the model.
 */
public class PojoCustomer {
	
	private String firstName;
	private String lastName;
	private int age;
	private boolean vip;
	private PojoAddress address;
	
	public PojoCustomer() {
		firstName = "";
		lastName = "";
		age = 0;
		vip = false;
		address = new PojoAddress();
	}
	
	public PojoCustomer cloneObject() {
		PojoCustomer newObj = new PojoCustomer();
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
		this.firstName = firstName;
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
		this.lastName = lastName;
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
		this.age = age;
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
		this.vip = vip;
	}

	/**
	 * @return the address
	 */
	public PojoAddress getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(PojoAddress address) {
		this.address = address;
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
