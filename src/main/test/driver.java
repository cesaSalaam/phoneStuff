package main.test;
import main.java.phoneDirectory;
/**
 * @author Cesa Salaam
 * The directory program is a simple program that allows users to save contacts in a phone book. 
 * The program utilizes the properties file to hold the location of the text file that the reference number to each contact will be stored in.
 * This program has two classes: contact and phoneDirectory. Phone Directory is an arrayList that stores objects of type contact
 */
import java.util.*; 
public class driver {
	public static void main(String[] args){
		
		phoneDirectory Contacts = new phoneDirectory(); // creating an instance of phoneDirectory 
		
		Scanner input = new Scanner (System.in); // creating input stream
		
		boolean value = true;
		
		while (value){ // while loop to run menu repeatedly
			
			System.out.println(" 1. to Add Contact." + "\n 2. to display contacts. \n 3. to edit a contact. \n 4. delete contact. \n 5. to exit. ");
			
			int choice = input.nextInt();
			
			switch(choice){
			// switch statement to account for the different inputs
			
			case 1:
				//Case 1 to add a contact
				
				Contacts.addContact();
				break;
				
			case 2:
				//case 2 to display all of the contacts
				
				Contacts.displayContacts();
				break;
				
			case 3:
				//case 3 to edit a contact
				
				Contacts.editContact();
				break;
				
			case 4:
				//case 4 to delete a contact
				
				Contacts.deleteContact();
				break;
				
			case 5:
				//case 5 to exit the program
				
				value = false;
				break;
				
			}
		}
	}
}
