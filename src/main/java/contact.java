package main.java;

public class contact {
	//This class is for the entity in the Phone Directory

	String number;
	String name;
	String referenceNum;
	public contact(){
		//Class constructor
	}
	//Getters and setters name and number and reference number
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setNumber(String number){
		this.number = number;
	}
	public String getNumber(){
		return number;
	}
	public void setReferenceNumber(String refNumber){
		this.referenceNum = refNumber;
	}
	public String getReferenceNumber(){
		return referenceNum;
	}
}
