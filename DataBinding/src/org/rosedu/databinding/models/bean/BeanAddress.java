package org.rosedu.databinding.models.bean;

import org.rosedu.databinding.utils.ICloneable;

/**
 * A Java Bean class modeling a customer address.
 * The address is 1:1 associated with a customer.
 */
public class BeanAddress extends AbstractBeanModelObject implements ICloneable<BeanAddress> {
	private String country;
	private String city;
	private String street;
	private String number;
	private String postalCode;
	
	public BeanAddress() {
		country = "";
		city = "";
		street = "";
		number = "";
		postalCode = "";
	}
	
	public BeanAddress cloneObject() {
		BeanAddress newObj = new BeanAddress();
		newObj.country = country;
		newObj.city = city;
		newObj.street = street;
		newObj.number = number;
		newObj.postalCode = postalCode;
		return newObj;
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		String oldValue = this.country;
		this.country = country;
		firePropertyChange("country", oldValue, this.country);
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		String oldValue = this.city;
		this.city = city;
		firePropertyChange("city", oldValue, this.city);
	}
	
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		String oldValue = this.street;
		this.street = street;
		firePropertyChange("street", oldValue, this.street);
	}
	
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		String oldValue = this.number;
		this.number = number;
		firePropertyChange("number", oldValue, this.number);
	}
	
	
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		String oldValue = this.postalCode;
		this.postalCode = postalCode;
		firePropertyChange("postalCode", oldValue, this.postalCode);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("Address:\n");
		sb.append("Country = " + country + "\n");
		sb.append("City = " + city + "\n");
		sb.append("Street = " + street + "\n");
		sb.append("Street Number = " + number + "\n");
		sb.append("Postal code = " + postalCode + "\n");
		return sb.toString();
	}
}

