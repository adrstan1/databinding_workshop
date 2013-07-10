package org.rosedu.databinding.models.bean;

import org.rosedu.databinding.dao.AbstractModelMemoryDao;

/**
 * A class acting like a provider for customer objects.
 * This is used by the UI code (the view) to display data about
 * the customer. 
 */
public class SimpleBeanCustomerDao extends AbstractModelMemoryDao<BeanCustomer> {
	
	public SimpleBeanCustomerDao() {
		BeanAddress address = new BeanAddress();
		address.setCountry("Romania");
		address.setCity("Bucharest");
		address.setStreet("Primaverii");
		address.setNumber("100");
		address.setPostalCode("12345");
		BeanCustomer customer = new BeanCustomer();
		customer.setFirstName("Ionescu");
		customer.setLastName("Ion");
		customer.setAge(20);
		customer.setVip(false);
		customer.setAddress(address);
		records.add(customer);
		
		address = new BeanAddress();
		address.setCountry("Romania");
		address.setCity("Pitesti");
		address.setStreet("Unirii");
		address.setNumber("200");
		address.setPostalCode("3421");
		customer = new BeanCustomer();
		customer.setFirstName("Popescu");
		customer.setLastName("George");
		customer.setAge(30);
		customer.setVip(false);
		customer.setAddress(address);
		records.add(customer);
		
		address = new BeanAddress();
		address.setCountry("USA");
		address.setCity("Washington");
		address.setStreet("White House");
		address.setNumber("1");
		address.setPostalCode("1111");
		customer = new BeanCustomer();
		customer.setFirstName("Obama");
		customer.setLastName("Barack");
		customer.setAge(52);
		customer.setVip(true);
		customer.setAddress(address);
		records.add(customer);
	}
}

