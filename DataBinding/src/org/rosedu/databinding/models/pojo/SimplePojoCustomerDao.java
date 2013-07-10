package org.rosedu.databinding.models.pojo;

/**
 * A class acting as a provider for a PojoCustomer object.
 * This is used by the UI code (the view) to display data about
 * the customer. 
 */
public class SimplePojoCustomerDao {
	
	public PojoCustomer getCustomer() {
		PojoAddress address = new PojoAddress();
		address.setCountry("Romania");
		address.setCity("Bucharest");
		address.setStreet("Primaverii");
		address.setNumber("100");
		address.setPostalCode("12345");
		PojoCustomer customer = new PojoCustomer();
		customer.setFirstName("Ionescu");
		customer.setLastName("Ion");
		customer.setAge(20);
		customer.setVip(true);
		customer.setAddress(address);
		return customer;
	}
}
