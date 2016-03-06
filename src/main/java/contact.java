package main.java;
/**
 * @author Cesa Salaam
 * The contact class represents an entity in the phoneDirectory
 * contact has 6 methods: setName(), getName(), setNumber(), getReferenceNumber(), getReferenceNumber().
 * contact has private 3 data members: number of type String, name of type String and referenceNum of type string.
 */
public class contact {
	// Data members for class
	private String number; 
	/**
	 * The contact number Data member is of type String and holds the contacts phoneNumber
	 */
	private String name;
	/**
	 * The contact name Data member is of type String and holds the contacts name
	 */
	private String referenceNum;
	/**
	 * The contact referenceNum Data member is of type String and holds the contacts reference number
	 */
	public contact(){
		//Class constructor
	}
	// Methods for the class
	public void setName(String name){
		//This method sets the name of the contact
		this.name = name;
	}
	public String getName(){
		//this method returns the name of the contact, because the name data member is private
		return name;
	}
	public void setNumber(String number){
		//This method sets the number data member
		this.number = number;
	}
	public String getNumber(){
		//this method returns the number of the contact, because the number data member is private
		return number;
	}
	public void setReferenceNumber(String refNumber){
		// this method sets the reference number data member
		this.referenceNum = refNumber;
	}
	public String getReferenceNumber(){
		//this method returns the reference number of the contact,  because the referenceNum data member is private
		return referenceNum;
	}
}
