import java.util.Scanner;
/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */


public class AddressBook {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Define a 2D array to store address book entries
        String[][] addressBook = new String[100][8];

        // Column headers for the address book
        addressBook[0][0] = "ID";
        addressBook[0][1] = "First Name";
        addressBook[0][2] = "Last Name";
        addressBook[0][3] = "Address";
        addressBook[0][4] = "City";
        addressBook[0][5] = "County";
        addressBook[0][6] = "Mobile Number";
        addressBook[0][7] = "Telephone Number";

        // Pre-populated data for testing
        addressBook[1][0] = "1";
        addressBook[1][1] = "David";
        addressBook[1][2] = "Needham";
        addressBook[1][3] = "Sraleens, Achill";
        addressBook[1][4] = "Galway";
        addressBook[1][5] = "Mayo";
        addressBook[1][6] = "086-1518077";
        addressBook[1][7] = "098-45368";

        addressBook[2][0] = "2";
        addressBook[2][1] = "Mc";
        addressBook[2][2] = "Lovin";
        addressBook[2][3] = "Hawaii";
        addressBook[2][4] = "Hawaii";
        addressBook[2][5] = "Hawaii";
        addressBook[2][6] = "12345";
        addressBook[2][7] = "412-555-1234";

        // Variable to track the number of entries
        int entryCount = 2; // We already have two pre-filled entries

        // Display menu options in a loop
        while (true) {
            System.out.println("\nWelcome to My Address Book!");
            System.out.println("1 - Insert a New Contact");
            System.out.println("2 - Search Contact by Last Name");
            System.out.println("3 - Delete Contact");
            System.out.println("4 - Show All Contacts");
            System.out.println("5 - Exit");

            System.out.print("\nChoose your option: ");
            int option = input.nextInt();
            input.nextLine(); // Consume the newline character

            if (option == 1) {
                // Insert a new contact
                entryCount++;
                System.out.println("\nAdding a new contact:");

                addressBook[entryCount][0] = String.valueOf(entryCount);
                System.out.print("Enter First Name: ");
                addressBook[entryCount][1] = input.nextLine();

                System.out.print("Enter Last Name: ");
                addressBook[entryCount][2] = input.nextLine();

                System.out.print("Enter Address: ");
                addressBook[entryCount][3] = input.nextLine();

                System.out.print("Enter City: ");
                addressBook[entryCount][4] = input.nextLine();

                System.out.print("Enter County: ");
                addressBook[entryCount][5] = input.nextLine();

                System.out.print("Enter Mobile Number: ");
                addressBook[entryCount][6] = input.nextLine();

                System.out.print("Enter Telephone Number: ");
                addressBook[entryCount][7] = input.nextLine();

                System.out.println("Contact added successfully!");

            } else if (option == 2) {
                // Search for a contact by last name
                System.out.print("\nEnter the last name to search: ");
                String lastName = input.nextLine();
                boolean found = false;

                for (int i = 1; i <= entryCount; i++) {
                    if (addressBook[i][2] != null && addressBook[i][2].equalsIgnoreCase(lastName)) {
                        System.out.println("Contact Found: ");
                        System.out.println("ID: " + addressBook[i][0] + ", Name: " + addressBook[i][1] + " " + addressBook[i][2]);
                        System.out.println("Address: " + addressBook[i][3] + ", City: " + addressBook[i][4]);
                        System.out.println("County: " + addressBook[i][5] + ", Mobile: " + addressBook[i][6]);
                        System.out.println("Telephone: " + addressBook[i][7]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No contact found with the last name: " + lastName);
                }

            } else if (option == 3) {
                // Delete a contact by ID
                System.out.print("\nEnter the ID of the contact to delete: ");
                String id = input.nextLine();
                boolean deleted = false;

                for (int i = 1; i <= entryCount; i++) {
                    if (addressBook[i][0] != null && addressBook[i][0].equals(id)) {
                        // Shift remaining entries up to overwrite the deleted contact
                        for (int j = i; j < entryCount; j++) {
                            addressBook[j] = addressBook[j + 1];
                        }
                        entryCount--;
                        deleted = true;
                        System.out.println("Contact deleted successfully!");
                        break;
                    }
                }

                if (!deleted) {
                    System.out.println("No contact found with the ID: " + id);
                }

            } else if (option == 4) {
                // Show all contacts
                System.out.println("\nAll Contacts:");
                for (int i = 0; i <= entryCount; i++) {
                    if (addressBook[i][0] != null) {
                        System.out.println(String.join("\t", addressBook[i]));
                    }
                }

            } else if (option == 5) {
                // Exit the program
                System.out.println("Exiting Address Book. Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }
}

