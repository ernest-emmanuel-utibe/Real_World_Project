package phoneEmulator;
import java.util.*;

//        This code defines an array of contacts and a map of phone numbers,
//        and uses them to simulate a phone book. It then prompts the user for a contact name to call,
//        and checks if the contact is in the phone book before making the call.

public class Phone_Emulator {
    public static void main(String[] args) {


        // Define an array of contacts
        String[] contacts = {"John Doe", "Jane Smith", "Bob Johnson", "Sara Lee"};

        // Define a map of phone numbers
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("John Doe", "555-1234");
        phonebook.put("Jane Smith", "509-1734");
        phonebook.put("Bob Johnson", "423-8573");
        phonebook.put("Sara Lee", "726-7846");

        // Print the list of contacts and phone numbers
        System.out.println("Contacts");
        for (String contact : contacts) {
            System.out.println(contact + ": " + phonebook.get(contact));
        }

        // Prompt the user for a contact name to call
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a contact name to call: ");
        String name = scanner.nextLine();

        // Check if the contact is in the phonebook
        if (phonebook.containsKey(name)) {
            System.out.println("Calling " + name + " at " + phonebook.get(name));
        } else {
            System.out.println("Sorry, " + name + " is not in your contacts.");
        }
    }
}
