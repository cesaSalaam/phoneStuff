package main.java;
import java.io.*;
import java.util.*; 
import java.util.Properties;
public class phoneDirectory {

		ArrayList<contact> contacts = new ArrayList<contact>();
		private Properties prop = new Properties();
		private String path = null;
		
	public phoneDirectory(){
		//Class constructor
		InputStream prop_input = null;
		
		try
		{
			prop_input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(prop_input);
			path = prop.getProperty("path");
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
			// This function adds a contact to the contacts list
			Scanner cesa = new Scanner(System.in);
			
			System.out.print("Enter name: ");
			
			String newName = cesa.nextLine();
			
			System.out.print("Enter number: ");
			
			String newNumber = cesa.nextLine();
			
			contact newContact = new contact();
			
			newContact.setName(newName);
			
			newContact.setNumber(newNumber);
			
			String refNum = newName + "REF" + newNumber;
			
			newContact.setReferenceNumber(refNum);
			
			contacts.add(newContact);
			
			writeToFile(contacts);

		}
		public void writeToFile(ArrayList<contact> list){
			try
			{
				BufferedWriter writer = new BufferedWriter ( new FileWriter(path));
				for(contact x:list){
				writer.write(x.getName() + "REF" + x.getNumber());
				writer.newLine();
				}
				writer.close();
			} catch (IOException err) {
				err.getStackTrace();
			}
		}
		public void displayContacts(){
			
			for (int i = 0; i < contacts.size(); i++){
				System.out.println(contacts.get(i).getName() + " ");
				System.out.println(contacts.get(i).getNumber());
				System.out.println("___________________________");
			}
		}
		
		public void deleteContact(){
			Scanner in = new Scanner(System.in);
			System.out.print("Enter name to delete: ");
			String name = in.nextLine();
			for (int i = 0; i < contacts.size(); i++){
				if (contacts.get(i).getName().equals(name)){
					contacts.remove(i);
					writeToFile(contacts);
					System.out.println(name + " was deleted.");
					return;
				}
			}
			System.out.println(name + " was not found in your contacts.");
		}
		public void editContact(){
			Scanner in = new Scanner(System.in);
			System.out.print("Enter name to edit: ");
			String name = in.nextLine();
			for (int i = 0; i < contacts.size(); i++){
				if (contacts.get(i).getName().equals(name)){
					System.out.println("Enter 1. to change the name. \n 2. to change the number.");
					int choice =  in.nextInt();
					switch (choice ){
					case 1:
						System.out.println("Enter the new name: ");
						String input = in.next();
						contacts.get(i).setName(input);
						System.out.println("Name was changed");
						break;
					case 2:
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
