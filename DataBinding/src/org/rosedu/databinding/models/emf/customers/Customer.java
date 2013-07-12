/**
 */
package org.rosedu.databinding.models.emf.customers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.rosedu.databinding.models.emf.customers.Customer#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.rosedu.databinding.models.emf.customers.Customer#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.rosedu.databinding.models.emf.customers.Customer#getAge <em>Age</em>}</li>
 *   <li>{@link org.rosedu.databinding.models.emf.customers.Customer#isVip <em>Vip</em>}</li>
 *   <li>{@link org.rosedu.databinding.models.emf.customers.Customer#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.rosedu.databinding.models.emf.customers.CustomersPackage#getCustomer()
 * @model
 * @generated
 */
public interface Customer extends EObject {
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.rosedu.databinding.models.emf.customers.CustomersPackage#getCustomer_FirstName()
	 * @model
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.rosedu.databinding.models.emf.customers.Customer#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see org.rosedu.databinding.models.emf.customers.CustomersPackage#getCustomer_LastName()
	 * @model
	 * @generated
	 */
	String getLastName();

	/**
	 * Sets the value of the '{@link org.rosedu.databinding.models.emf.customers.Customer#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see org.rosedu.databinding.models.emf.customers.CustomersPackage#getCustomer_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link org.rosedu.databinding.models.emf.customers.Customer#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Vip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vip</em>' attribute.
	 * @see #setVip(boolean)
	 * @see org.rosedu.databinding.models.emf.customers.CustomersPackage#getCustomer_Vip()
	 * @model
	 * @generated
	 */
	boolean isVip();

	/**
	 * Sets the value of the '{@link org.rosedu.databinding.models.emf.customers.Customer#isVip <em>Vip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vip</em>' attribute.
	 * @see #isVip()
	 * @generated
	 */
	void setVip(boolean value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' reference.
	 * @see #setAddress(Address)
	 * @see org.rosedu.databinding.models.emf.customers.CustomersPackage#getCustomer_Address()
	 * @model required="true"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link org.rosedu.databinding.models.emf.customers.Customer#getAddress <em>Address</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

} // Customer
