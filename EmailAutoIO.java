import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmailAutoIO {
	private Scanner scan;
	private String subject;
	private String body="";
	

	
	File fileIn = new File("res/AutoMessage.txt");
	File fsubject = new File("res/messageSubject.txt");
	
	
	public void SaveBody(String body) {
	
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileIn));
			
				pw.println(body);
				pw.close();

			
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}	
	}
	
	
	
	
public void SaveSubject(String subject) {
	
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fsubject));
			
				pw.println(subject);
				pw.close();

			
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	
	public String getBody() {
		
		try {
			 scan = new Scanner(fileIn);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
			while(scan.hasNext()) {
				body += scan.nextLine()+"\n"; 
			}
			scan.close();
							
			
			return body;
	}
	
	
	public String getSubject() {
		try {
			 scan = new Scanner(fsubject);
		}catch(Exception e){
			System.out.println("Error: "+ e);
		}
		while(scan.hasNext()) {
			subject = scan.nextLine();
		}
			scan.close();
			return subject;
	}
	
	
	
	

	
}
