import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;





public class ListIO {	
	File fileIn = new File("res/EmailList.csv");



	public void addRecords(String date, String name, String email, String number) {

		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileIn,true));
				pw.println(date+","+name+","+email+","+ number);
				pw.close();
	
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		
	}
	

	
}
