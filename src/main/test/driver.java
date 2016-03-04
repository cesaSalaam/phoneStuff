package main.test;
import main.java.phoneDirectory;
import java.util.*; 
public class driver {

	public static void main(String[] args){
		phoneDirectory Contacts = new phoneDirectory();
		/*Contacts.addContact();
		Contacts.displayContacts();
		Contacts.addContact();
		Contacts.displayContacts();
		Contacts.editContact();
		Contacts.displayContacts();
		Contacts.deleteContact();
		Contacts.displayContacts();*/
		Scanner input = new Scanner (System.in);
		boolean value = true;
		while (value){
			
			System.out.println(" 1. to Add Contact." + "\n 2. to display contacts. \n 3. to edit a contact. \n 4. delete contact. \n 5. to exit. ");
			int choice = input.nextInt();
			switch(choice){
			case 1:
				Contacts.addContact();
				break;
			case 2:
				Contacts.displayContacts();
				break;
			case 3:
				Contacts.editContact();
				break;
			case 4:
				Contacts.deleteContact();
				break;
			case 5:
				value = false;
				break;
			}
		}
		input.close();
	}
}
