package org.rosedu.databinding.models.pojo;

/**
 * POJO model for an address.
 * The address is 1:1 associated with a customer.
 */

public class PojoAddress {
	private String country;
	private String city;
	private String street;
	private String number;
	private String postalCode;
	
	public PojoAddress() {
		country = "";
		city = "";
		street = "";
		number = "";
		postalCode = "";
	}
	
	public PojoAddress cloneObject() {
		PojoAddress newObj = new PojoAddress();
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
		this.country = country;
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
		this.city = city;
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
		this.street = street;
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
		this.number = number;
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
		this.postalCode = postalCode;
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
