import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class Contact {
	
	int customerNumber;
	String dateAndTime; 
	
	public Contact(int action){
		if(action == 1){
			
		}
		else if(action == 2){
			
		}
		else if(action == 3){
			
		}
	}
	
	
	public void recordDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dateAndTime = dateFormat.format(date);
	}
	
	public void writeToFile(){
		String fileName = String.format("%d\n%s", customerNumber, dateAndTime);
		try {
			Formatter writeFile = new Formatter(fileName);
			writeFile.format("%s", dateAndTime);
			writeFile.close();
			
		} catch (Exception e) {
			System.out.println("Error occured");
		}
	}
	
}
