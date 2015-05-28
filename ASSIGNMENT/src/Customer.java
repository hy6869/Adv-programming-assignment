import java.io.File;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class Customer {

	private Scanner scanFile;
	private Formatter fileWriter;
	
	private int uniqueNumber;
	private String name;
	private String address;
	private String dateOfBirth;
	
	// Constructors
	public Customer() {
		
	}
	
	public Customer(int id){
		uniqueNumber = id;
	}
	
	// Setter and getters
	//**************************************************
	public int getUniqueNumber() {
		return uniqueNumber;
	}

	public void setUniqueNumber(int uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	//**************************************************
	
	// Generate a unique number
	private void generateUniqueNumber(){
		Random rand = new Random();
		
		while (true){
			// Generates a number between 1000 to 9999
			int uniqueNum = rand.nextInt(9000) + 1000;
			File file = new File("./customerRecords/" + uniqueNum + ".txt");
			
			// Breaks the loop and store the uniqueNumber if the file does not exist.
			// If the file exists, means the generated number is not unique.
			if(!file.exists()){
				uniqueNumber = uniqueNum;
				break;
			}
		}
	}
	
	// Checks if a customer exist (returns true if exist, else returns false)
	public boolean checkCustomerId(){
		// Tries to find the file "(uniqueNumber).txt"
		// Returns true if it exist, return false if it doesn't
		File file = new File("./customerRecords/" + uniqueNumber + ".txt");
		
		if(file.exists())
			return true;
		else
			return false;
	}
	
	// Create new customer
	public void createNewCustomer(){
		// Generates a unique number
		generateUniqueNumber();
		// Creates a new file with the customer's unique number	
		System.out.println("./customerRecords/" + uniqueNumber + ".txt");
		try{
			fileWriter = new Formatter("./customerRecords/" + uniqueNumber + ".txt");
			fileWriter.format("%d\n%s\n%s\n%s\n", uniqueNumber, name, address, dateOfBirth);
			fileWriter.close();
			System.out.printf("Your unique number is: %d", uniqueNumber);
		}catch(Exception e){
			System.out.println("An error occurred");
		}
	}
	
	// Reads the customer file and sets the customer information
	public void setCustomerInfo(){
		try{
			scanFile = new Scanner(new File("./customerRecords/" + uniqueNumber + ".txt"));
			
			uniqueNumber = scanFile.nextInt();
			scanFile.nextLine();
			name = scanFile.nextLine();
			address = scanFile.nextLine();
			dateOfBirth = scanFile.nextLine();
			
			scanFile.close();
		}
		catch(Exception e){
			System.out.println("File does not exists.");
		}
	}
	
	// Display customer info
	public void displayCustomerInfo() {
		System.out.println();
		System.out.printf("Name: %s\n", name);
		System.out.printf("Address: %s\n", address);
		System.out.printf("DOB: %s\n", dateOfBirth);
	}
	
}
