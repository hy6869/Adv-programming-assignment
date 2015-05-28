import java.util.Scanner;

public class CRMTest {

	public static void main(String[] args) {
		
		Scanner keyboardIn = new Scanner(System.in);
		boolean isExistingCustomer = false;
		
		while (true){
			System.out.println("Are you an existing customer? (Y/N)");
			String existingCust = keyboardIn.next();
			existingCust = existingCust.toUpperCase();
	
			if (existingCust.equals("Y")){
				// Asks for customer unique number if its an existing customer
				System.out.print("Enter your customer ID: ");
				int uniqueNumber = keyboardIn.nextInt();
				
				// Creates new customer object and check if the id exist.
				Customer customer = new Customer(uniqueNumber);
				
				if (customer.checkCustomerId()){
					// Sets and display the customer information.
					customer.setCustomerInfo();
					customer.displayCustomerInfo();
					isExistingCustomer = true;
				} else {
					// Restart from the beginning of the loop again if customer doesnt exist
					System.out.println("Customer does not exist.\n");
				}
				
			} else if (existingCust.equals("N")){
				isExistingCustomer = false;
				break;
			} else {
				// Restart from the beginning of the loop again
				System.out.println("Please enter \'Y\' or \'N\'");
			}
		}
		
		// If the customer is an existing customer
		if(isExistingCustomer) {
			System.out.println("What would you like to do? Enter the number.");
			System.out.println("(1) Order a product");
			System.out.println("(2) Make an enquiry about product");
			System.out.println("(3) Return a purchased product");
			System.out.println("(0) Exit");
			int customerAction = keyboardIn.nextInt();
			
			if(customerAction == 1){
				
			} 
			else if(customerAction == 2){
				
			}
			else if(customerAction == 3){
				
			}
			else if(customerAction == 0){
				System.out.println("Exiting program...");
			}
		} 
		else {
			keyboardIn.nextLine();
			System.out.println("Creating a new customer...");
			System.out.println("Please enter your details");
			
			// Gets the customer details
			Customer customer = new Customer();
			System.out.print("Name: ");
			customer.setName(keyboardIn.nextLine());
			System.out.print("Address: ");
			customer.setAddress(keyboardIn.nextLine());
			System.out.print("Date of birth: ");
			customer.setDateOfBirth(keyboardIn.nextLine());
			
			// Writes the customer details to the file
			customer.createNewCustomer();
		}
		
	}

}
