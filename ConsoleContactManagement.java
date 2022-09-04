/* 
 * ConsoleContactManagement.java
 * 
 * Maina Dhar
 * Java Project
 * 
 * This java project incorporates and deletes contact details. The system 
 * will let customers add contacts, with names and email addresses. The end 
 * result of this project will be an application similar to a phonebook application. 
 * This project will acquaint with major data handling and data structuring.
 * 
 */

import java.util.*;

public class ConsoleContactManagement {

	// ArrayList of type ContactProperty
	List<ContactProperty> cparry = new ArrayList<>();
	
	// Adds as many contacts as user wants
	void AddContacts() {

		// scanner and instance
		Scanner sc = new Scanner(System.in);

		// how many contacts need to be added
		System.out.print("\nHow many contacts would you like to add? ");
		int times = sc.nextInt();

		sc.nextLine();

		// loop depends on user input
		for (int i = 0; i < times; i++) {

			ContactProperty cp = new ContactProperty();

			System.out.println("\nCONTACT #" + (i + 1) + "\n");

			// name
			System.out.print("Conatct Name: ");
			String name = sc.nextLine();
			cp.name = name;

			// gender
			System.out.print("Male or Female: ");
			String gender = sc.nextLine();
			cp.gender = gender;

			// age
			System.out.print("Conatct Age: ");
			int age = sc.nextInt();
			cp.age = age;

			sc.nextLine();

			// phonenum
			System.out.print("Conatct Phone Number: ");
			String phonenum = sc.nextLine();
			cp.phonenum = phonenum;

			// address
			System.out.print("Conatct Address: ");
			String address = sc.nextLine();
			cp.address = address;

			// add to contacts array
			cparry.add(cp);
			
		}

		System.out.println();

		// back to menu
		ShowMenu();

	}

	// Shows all contacts added
	void ShowContacts() {

		// if array is empty, print message
		if (cparry.size() == 0) {

			System.out.println("\nNO CONTACTS AVAILABLE!");

		}

		// loops on size of array
		for (int i = 0; i < cparry.size(); i++) {

			System.out.println("\nCONTACT #" + (i + 1) + "\n");

			// get cparray value at i
			// typecast to ContactProperty
			ContactProperty cp = (ContactProperty) cparry.get(i);

			// print each attribute
			System.out.println("Name: " + cp.name + "\nGender: " + cp.gender + "\nAge: " + cp.age + "\nPhone Number: "
					+ cp.phonenum + "\nAddress: " + cp.address);

		}

		System.out.println();

		// back to menu
		ShowMenu();

	}

	// for given name, find and show contact(s)
	void GetContact() {
		boolean foundName = false;

		// scanner to ask user for contact name
		Scanner sc = new Scanner(System.in);
		System.out.print("\nConatct Name: ");
		String name = sc.nextLine();

		// loop through cparray
		for (int i = 0; i < cparry.size(); i++) {

			ContactProperty cp = (ContactProperty) cparry.get(i);

			// if user entered name is in system, then show info
			if (cp.name.equals(name)) {
				System.out.println("\nName: " + cp.name + "\nGender: " + cp.gender + "\nAge: " + cp.age
						+ "\nPhone Number: " + cp.phonenum + "\nAddress: " + cp.address);

				// state name is FOUND
				foundName = true;

			}

		}

		// after looping, if name is NOT FOUND, then say message
		if (foundName == false) {

			System.out.println("\nNO CONTACT FOUND!");

		}

		System.out.println();

		// back to menu
		ShowMenu();

	}

	// deletes contact given name
	void DeleteContact() {

		// ask user for contact name
		Scanner sc = new Scanner(System.in);
		System.out.print("\nConatct Name: ");
		String name = sc.nextLine();

		// loop through a the cparry
		for (int i = 0; i < cparry.size(); i++) {

			ContactProperty cp = (ContactProperty) cparry.get(i);

			// is name attribute in array is same as user input
			if (cp.name.equals(name)) {
				// remove all attributes associated with that name
				cparry.remove(i);
			}

		}
		
		System.out.println();

		// back to menu
		ShowMenu();

	}

	// modifys contact given name
	void ModifyContact() {

		// ask user for name
		Scanner sc = new Scanner(System.in);
		System.out.print("\nConatct Name: ");
		String name = sc.nextLine();

		// loop through cparry
		for (int i = 0; i < cparry.size(); i++) {

			ContactProperty cp = (ContactProperty) cparry.get(i);

			// is name found in arraylist
			if (cp.name.equals(name)) {

				boolean needModify = true;

				while (needModify == true) {
					// ask what needs modification
					System.out.print("\nWhat do you want to modify: ");
					String modifyWhat = sc.nextLine();

					// different responses:
					if (modifyWhat.equals("age")) {
						System.out.print("\nNew Age: ");
						int newAge = sc.nextInt();
						cp.age = newAge;
						sc.nextLine();
					}

					if (modifyWhat.equals("gender")) {
						System.out.print("\nNew Gender: ");
						String newGender = sc.nextLine();
						cp.gender = newGender;
					}

					if (modifyWhat.equals("address")) {
						System.out.print("\nNew Address: ");
						String newAddress = sc.nextLine();
						cp.address = newAddress;
					}

					if (modifyWhat.equals("phone number")) {
						System.out.print("\nNew Phone Number: ");
						String newPhoneNum = sc.nextLine();
						cp.phonenum = newPhoneNum;
					}

					System.out.print("\nDo you want to modify again (y/n): ");
					String modifyAgain = sc.nextLine();

					if (modifyAgain.equals("y")) {

						needModify = true;

					} else {

						needModify = false;

					}

				}
			} else {

				System.out.println("\nNAME NOT FOUND");

			}

		}
		System.out.println();

		// back to menu again
		ShowMenu();

	}

	// initial display of menu page
	void ShowMenu() {

		// menu options
		System.out.println("MENU PAGE\nLET'S GET STARTED!");
		System.out.println();
		System.out.println("1--------->ADD CONTACT");
		System.out.println("2--------->SHOW CONTACT");
		System.out.println("3--------->DELETE CONTACT");
		System.out.println("4--------->GET CONTACT");
		System.out.println("5--------->MODIFY CONTACT");
		System.out.println("6--------->EXIT\n");

		System.out.print("Option: ");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		// switch statment
		switch (option) {
				
			case 1:
				AddContacts();
				break;
				
			case 2:
				ShowContacts();				
				break;
				
			case 3:
				DeleteContact();
				break;
				
			case 4:
				GetContact();
				break;
				
			case 5:
				ModifyContact();
				break;
				
			case 6:
				System.out.println("\nbye bye...");
				break;
				
			default:
				System.out.println("Not a Valid Option!");
				break;
		
		}

	}

	public static void main(String[] args) {

		// create object
		ContactManagement cm = new ContactManagement();
		
		// display initial menu page
		cm.ShowMenu();

	}

}
