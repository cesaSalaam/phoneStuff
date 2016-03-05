package main.java;
import java.io.*;
import java.util.*; 
import java.util.Properties;
/**
 * @author Cesa Salaam
 * The phoneDirectory stores objects of type contact.
 * phoneDirectory has 5 methods: addContact(), writeToFile(), displayContacts(), deleteContact(), editContact.
 * phoneDirectory has 3 data members: contacts of type ArrayList, prop of type properties and path of type string.
 */

public class phoneDirectory {

		private ArrayList<contact> contacts = new ArrayList<contact>();
		private Properties prop = new Properties();
		private String path = null;
		
	public phoneDirectory(){
		/**
		 * The phoneDirectory class constructors sets the value of path to the location of the directory.txt file.
		 * @return null. This returns nothing.
		 */
		InputStream prop_input = null;
		
		try
		{
			prop_input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(prop_input);
			path = prop.getProperty("path"); // getting the location of the directory.txt file
		} catch (IOException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
		} finally {
			if (prop_input != null) {
				try
				{
					prop_input.close();
				} catch (IOException err)
				{
					err.printStackTrace();
				}
			}
		}
	}
	
		public void addContact(){
			/**
			 * The addContact() method adds a contact to the contacts list and to the directory.txt file which stores a reference number of the contact.
			 * @param this takes no parameters
			 * @return null.
			 */
			Scanner in = new Scanner(System.in);
			
			System.out.print("Enter name: ");
			
			String newName = in.nextLine(); // taking in the new name
			
			System.out.print("Enter number: ");
			
			String newNumber = in.nextLine(); // taking in the new number
			
			contact newContact = new contact();
			
			newContact.setName(newName); // adding the name to the contact
			
			newContact.setNumber(newNumber); // adding the number to the contact
			
			String refNum = newName + "REF" + newNumber; // creating reference number
			
			newContact.setReferenceNumber(refNum);  // adding reference number to the contact
			
			contacts.add(newContact); // adding contact to contacts list
			
			writeToFile(contacts); // adding contacts to the file
			
			in.close();
		}
		public void writeToFile(ArrayList<contact> list){
			/**
			 * The writeToFile(ArrayList<contact> list) method adds the contacts list to the directory.txt file which stores a reference number of the contact.
			 * @param ArrayList
			 * @return null.
			 **/
			try
			{
				BufferedWriter writer = new BufferedWriter ( new FileWriter(path));
				for(contact x:list){
				writer.write(x.getReferenceNumber()); // adds reference number to text file.
				writer.newLine();
				}
				writer.close();
			} catch (IOException err) {
				err.getStackTrace();
			}
		}
		public void displayContacts(){
			/**
			 * The writeToFile(ArrayList<contact> list) method adds the contacts list to the directory.txt file which stores a reference number of the contact.
			 * @param ArrayList
			 * @return null.
			 **/
			for (int i = 0; i < contacts.size(); i++){
				System.out.println(contacts.get(i).getName() + " ");
				System.out.println(contacts.get(i).getNumber());
				System.out.println("___________________________");
			}
		}
		
		public void deleteContact(){
			/**
			 * The deleteContact() method removes a contact from the contacts list and from the directory file.
			 * @param no params
			 * @return null.
			 **/
			Scanner in = new Scanner(System.in);
			System.out.print("Enter name to delete: ");
			String name = in.nextLine(); // gets name of contact that has to be removed
			for (int i = 0; i < contacts.size(); i++){ // for loop to find contact
				if (contacts.get(i).getName().equals(name)){ // if statement to check if the contact has been found
					contacts.remove(i); // removes contact from contacts
					writeToFile(contacts); // rewrites the file with new list of contacts
					System.out.println(name + " was deleted.");
					return;
				}
			}
			System.out.println(name + " was not found in your contacts.");
		}
		
		public void editContact(){
			/**
			 * The editContact() method edits a contact from the contacts list.
			 * @param no params
			 * @return null.
			 **/
			Scanner in = new Scanner(System.in);
			System.out.print("Enter name to edit: ");
			String name = in.nextLine(); // gets name of contact that wants to edit
			for (int i = 0; i < contacts.size(); i++){ // for loop to find contact
				if (contacts.get(i).getName().equals(name)){ // if statement to check if contact was found
					System.out.println("Enter 1. to change the name. \n 2. to change the number.");
					int choice =  in.nextInt(); // takes in integer value of choice made
					switch (choice ){ // switch statement to account for the possible choices made
					case 1:
						// case one to edit the name of the  contact
						System.out.println("Enter the new name: ");
						String input = in.next();
						contacts.get(i).setName(input);
						System.out.println("Name was changed");
						break;
					case 2:
						//case two to edit the number of the contact
						System.out.println("Enter the new number: ");
						String number = in.next();
						contacts.get(i).setNumber(number);
						System.out.println("Name was changed");
						break;
					}
					return;
				}
			}
			System.out.println(name + " was not found in your contacts.");
		}
}
