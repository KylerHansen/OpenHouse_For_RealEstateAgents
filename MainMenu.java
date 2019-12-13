import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;








public class MainMenu extends JPanel { 
	 
	private static final long serialVersionUID = 1L;

	
	private JFrame window = new JFrame("Home Hosting Pro 1.0"); 
	private JButton setup = new JButton("<html><h2><bold>Setup</bold></h2></html>");
	private JButton newemail = new JButton("<html><h2><bold>Create New Email</bold></h2></html>");
	private JButton useexisting = new JButton("<html><h2><bold>Use Existing Email</bold></h2></html>");
	private JButton mainmenu = new JButton("<html><h2><bold>Main Menu</bold></h2></html>");	
	private JButton gotologin = new JButton("<html><h2>Go to Sign In</h2></html>");
	private JButton excellist = new JButton("<html><h2>View List</h2></html>");
	private JButton submit = new JButton("<html><h2>Click Submit</h2></html>");
	
	private JTextField name = new JTextField("");
	private JTextField email = new JTextField("");
	private JTextField number = new JTextField("");

	
	private JTextArea textArea = new JTextArea(8,30);
	private JScrollPane NewEmailBody = new JScrollPane(textArea);
	private JTextField NewEmailSubject = new JTextField("");
	
	private JLabel title = new JLabel ("Home Hosting");
	private JLabel subjectlbl = new JLabel ("<html><h2>Subject:</h2></html>");
	private JLabel bodylbl = new JLabel ("<html><h2>Message:</h2></html>");
	private JLabel namelbl = new JLabel ("<html><h2>Name:</h2></html>");
	private JLabel emaillbl = new JLabel ("<html><h2>Email:</h2></html>");
	private JLabel numberlbl = new JLabel ("<html><h2>Phone Number:</h2></html>");

	
	private JLabel disclaimer = new JLabel("<html><h2><em>* Note: we do not share/sell your information *</em></h2></html>");
	
		
	private	JButton Logo = new JButton(new ImageIcon("res/image/logo.gif"));
	
//	private JButton Logo = new JButton(new ImageIcon(getClass.getResources("res/image/logo.gif")));
	
	private JLabel invalidEmail = new JLabel("<html><h2><em>* ERROR: Must Enter A Valid Email Address *</em></h2></html>");
	private JLabel invalidname = new JLabel ("<html><h2><em>* ERROR: Must Provide Your Name *</em></h2></html>");
	private JButton SubmitEmail = new JButton("<html><h2>Create Email</h2></html>");
	GridBagConstraints gbc = new GridBagConstraints();
	
	int clicktime=0;
	
	Timer stopwatch;
	int count = 0;
	int delay = 1000;
	
	ListIO addlist = new ListIO();
	EmailAutoIO addMessage = new EmailAutoIO();
	
	static String recepient = "";
	static String emailSubject = "";
	static String emailBody = "";
	 
	Date mydate = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm");
	String date = dateFormat.format(mydate);
	
	File openlist = new File("res/EmailList.csv");
	

	public MainMenu() {//this is the constructor
			
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ends the program when the window is closed
		window.setLayout(new BorderLayout());
		window.setSize(1000, 700); //size of window (x,y)
		window.setLocationRelativeTo(null); //default centers the window location relative to screen.
		setLayout(new GridBagLayout()); 
	    setSize(400,300);
	    setBackground(new Color (42,171,226));
	   
		window.add(this,BorderLayout.CENTER); //Adding the current object (this) to the window the current object is a JPanel	
		window.setVisible(true); //shows the window
		
	 
	    
	    Logo.setOpaque(false);
	    Logo.setContentAreaFilled(false);
	    Logo.setBorderPainted(false);
	  
	    title.setFont(new Font("Arial", Font.PLAIN, 40));
	    name.setFont(new Font("Arial", Font.PLAIN, 20));
	    email.setFont(new Font("Arial", Font.PLAIN, 20));
	    number.setFont(new Font("Arial", Font.PLAIN, 20));
	    textArea.setFont(new Font("Arial", Font.PLAIN, 20));
	    NewEmailSubject.setFont(new Font("Arial", Font.PLAIN, 20));
	    disclaimer.setForeground(Color.black);
	    invalidEmail.setForeground(Color.black);
	    invalidname.setForeground(Color.black);
	    
	    
	      
	    //Add the windows components below using this.add(ComponentName);
	     gbc.gridx = 2;
	     gbc.gridy = 0;
	     gbc.gridwidth = 3;
	     gbc.fill = GridBagConstraints.HORIZONTAL;
	     gbc.insets = new Insets(20, 20, 20, 20);
	     add(title, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 2;
	     gbc.gridwidth = 3;
	     gbc.insets = new Insets(20, 20, 20, 20);
	     gbc.fill = GridBagConstraints.HORIZONTAL;
	     add(setup, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 3;
	     gbc.gridwidth = 3;
	     gbc.insets = new Insets(20, 20, 20, 20);
	     gbc.fill = GridBagConstraints.HORIZONTAL;
	     add(excellist, gbc);
	     
	         	     	 	     
	     gbc.gridx = 2;
	     gbc.gridy = 2;
	     gbc.insets = new Insets(20, 20, 20, 20);
	     add(newemail, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 1;
	     gbc.insets = new Insets(20, 20, 20, 20);
	     add(useexisting, gbc);
	     
	     gbc.gridx = 1;
	     gbc.gridy = 1;
	     gbc.insets = new Insets(0, 20, 0, 20);
	     add(subjectlbl, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 2;
	     gbc.insets = new Insets(0, 20, 20, 20);
	     add(NewEmailSubject, gbc);
	     
	     gbc.gridx = 1;
	     gbc.gridy = 3;
	     gbc.insets = new Insets(0, 10, 0, 0);//(top,left,bottom,right)
	     add(bodylbl, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 4;
	     gbc.insets = new Insets(0, 20, 20, 20);
	     add(NewEmailBody, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 5;
	     gbc.insets = new Insets(20,20,20,20);
	     add(SubmitEmail, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 6; 
	     gbc.insets = new Insets(20,20,20,20);
	     add(mainmenu, gbc);
	
	     gbc.gridx = 2;
	     gbc.gridy = 1;
	     gbc.insets = new Insets(20, 20, 20, 20);
	     add(gotologin, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 1;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(0, 10, 0, 10);
	     add(invalidname, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 3;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(0, 10, 0, 10);
	     add(invalidEmail, gbc);
	          
	     gbc.gridx = 2;
	     gbc.gridy = 2;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(10, 10, 10, 10);//(top,left,bottom,right)
	     add(name, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 4;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(10, 10, 10, 10);
	     add(email, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 5;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(10, 10, 10, 10);
	     add(number, gbc);
	     	     
	     gbc.gridx = 1;
	     gbc.gridy = 2;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(10, 20, 10, 0);
	     gbc.fill = GridBagConstraints.HORIZONTAL;
	     add(namelbl, gbc);
	     
	     gbc.gridx = 1;
	     gbc.gridy = 4;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(10, 20, 10, 0);//(top,left,bottom,right)
	     add(emaillbl, gbc);
	     
	 
	     gbc.gridx = 1;
	     gbc.gridy = 5;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(10, 20, 10, 0);
	     add(numberlbl, gbc);
	     
	     gbc.gridx = 2;
	     gbc.gridy = 6;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(10, 20, 0, 20);
	     add(disclaimer, gbc);
	     
	     
	     gbc.gridx = 2;
	     gbc.gridy = 7;
	     gbc.gridwidth = 1;
	     gbc.insets = new Insets(0, 20, 20, 20);
	     add(submit, gbc);
	     
	     
	     gbc.gridx = 1;
	     gbc.gridy = 7;
	     gbc.insets = new Insets(20, 20, 20, 100); //(top,left,bottom,right)
	     gbc.fill = 4;
	     gbc.gridwidth = 1;
	     add(Logo, gbc);
	     
	     
	    
	   
	    
	    
	   
		newemail.setVisible(false);
		useexisting.setVisible(false);
		mainmenu.setVisible(false);
		gotologin.setVisible(false);
		name.setVisible(false);
		email.setVisible(false);
		namelbl.setVisible(false);
		emaillbl.setVisible(false);
		number.setVisible(false);
		numberlbl.setVisible(false);
		submit.setVisible(false);
		disclaimer.setVisible(false);
		Logo.setVisible(false);
		SubmitEmail.setVisible(false);
		invalidEmail.setVisible(false);
		invalidname.setVisible(false);
		NewEmailSubject.setVisible(false);
		NewEmailBody.setVisible(false);
		bodylbl.setVisible(false);
		subjectlbl.setVisible(false);
		
		
		//--------------Add Action Listeners for each Component Below using----------
		  setup.addActionListener(new ActionListener(){
		         public void actionPerformed(ActionEvent ae){
		        	title.setText("Set Up Manager");
		            setup.setVisible(false);
		            newemail.setVisible(true);
		    		useexisting.setVisible(true);
		    		mainmenu.setVisible(true);
		    		
		    		excellist.setVisible(false);
		            
		         }//End ActionPerformed
		      });//End ActionListener setup
		  
		  
		  excellist.addActionListener(new ActionListener(){
		         public void actionPerformed(ActionEvent ae){		    		
		    		try {
						Desktop.getDesktop().open(openlist);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		         }//End ActionPerformed
		      });//End ActionListener setup
		
		
		newemail.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent ae){
	        	title.setText("New Email");
	        	newemail.setVisible(false);
	     		useexisting.setVisible(false);
	     		mainmenu.setVisible(true);
	     		NewEmailSubject.setVisible(true);
	    		NewEmailBody.setVisible(true);
	     		SubmitEmail.setVisible(true);
	     		bodylbl.setVisible(true);
	    		subjectlbl.setVisible(true);
	     		
	     		
	     		
	         }//End ActionPerformed
	      });//End ActionListener
		
		
		useexisting.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent ae){
	        	title.setText("Select House");
	        	newemail.setVisible(false);
	     		useexisting.setVisible(false);
	     		mainmenu.setVisible(true);
	     		gotologin.setVisible(true);
	     		gotologin.setVisible(true);
	     			     		
	         }//End ActionPerformed
	      });//End ActionListener
		
		
			
		
		mainmenu.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent ae){
	        	title.setText("Home Hosting");
	        	newemail.setVisible(false);
	     		useexisting.setVisible(false);
	     		gotologin.setVisible(false);
		     	mainmenu.setVisible(false);
		        setup.setVisible(true);
		        excellist.setVisible(true);
		    	name.setVisible(false);
				email.setVisible(false);
				namelbl.setVisible(false);
				emaillbl.setVisible(false);
				number.setVisible(false);
				numberlbl.setVisible(false);
				NewEmailSubject.setVisible(false);
	    		NewEmailBody.setVisible(false);
				SubmitEmail.setVisible(false);
				bodylbl.setVisible(false);
				subjectlbl.setVisible(false);
				
				
				
	     		
	         }//End ActionPerformed
	      });//End ActionListener
		
		Logo.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent ae){
	        	 clicktime=clicktime+1;
	        	 if (clicktime==2) {
	        	clicktime=0;
	            title.setText("Home Hosting");
	        	Logo.setVisible(false);
	        	newemail.setVisible(false);
	     		useexisting.setVisible(false);
	     		gotologin.setVisible(false);
	     		mainmenu.setVisible(false);
		        setup.setVisible(true);
		        excellist.setVisible(true);
		    	name.setVisible(false);
				email.setVisible(false);
				namelbl.setVisible(false);
				emaillbl.setVisible(false);
				number.setVisible(false);
				numberlbl.setVisible(false);
				submit.setVisible(false);
				disclaimer.setVisible(false);
				 invalidname.setVisible(false);
       	 		 invalidEmail.setVisible(false);
       	 		
	        	 }
	     		
	     		
	         }//End ActionPerformed
	      });//End ActionListener
		
		
		SubmitEmail.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent ae){
	        	 String subject = NewEmailSubject.getText();
	        	 String body = textArea.getText();
	        	 addMessage.SaveBody(body);
	        	 addMessage.SaveSubject(subject);
	        	title.setText("Email Saved");
	        	textArea.setText("");
	        	NewEmailSubject.setText("");
	     		
	         }//End ActionPerformed
	      });//End ActionListener
		
		
		gotologin.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent ae){
	        	title.setText("Sign In");
	        	mainmenu.setVisible(false);
	        	submit.setVisible(true);
	        	gotologin.setVisible(false);
	        	name.setVisible(true);
	    		email.setVisible(true);
	    		namelbl.setVisible(true);
	    		emaillbl.setVisible(true);
	    		number.setVisible(true);
	    		numberlbl.setVisible(true);
	    		disclaimer.setVisible(true);
	    		Logo.setVisible(true);
	     		
	     		
	         }//End ActionPerformed
	      });//End ActionListener
		


		
		submit.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent ae){ 
	        	 submit.setEnabled(false);
				 String nameinput = name.getText().trim();
	        	 String emailinput = email.getText().trim();
	        	 String numberinput = number.getText().trim();
	        	boolean checkemail = validateEmail(emailinput); //outputs false if invalid, true if valid.
	        	boolean checkname = validateName(nameinput); //outputs true if valid.
	        
	        
	        	if(checkemail == true && checkname==false) {
	        		 invalidEmail.setVisible(false);
	        		 invalidname.setVisible(true);
	        		 submit.setEnabled(true);
	        		 
	        	 }else if(checkemail == false && checkname==false) {
	        		 invalidEmail.setVisible(true);
	        		 invalidname.setVisible(true);
	        		 submit.setEnabled(true);
	        		 
	        	 }else if(checkemail== false && checkname==true) { 
	        		 invalidEmail.setVisible(true);
	        		 invalidname.setVisible(false);
	        		 submit.setEnabled(true);
	        		 	        		 
	        	 }else if(emailinput.isEmpty()) {
	        		 invalidEmail.setVisible(true);
	        		 submit.setEnabled(true);
	        		 
	    	        		 
	        	 }else if (checkemail == true && checkname == true){
	        		    name.setText(" ");
	        			email.setText(" ");
	        			number.setText(" ");
	        			
	        			addlist.addRecords(date,nameinput, emailinput, numberinput);
	        			StartTimer(2);
	        		
	        				        			
	        			recepient = emailinput;
	        			emailSubject = addMessage.getSubject();
	        			emailBody = addMessage.getBody();
	        			
	        			
	        			new SendEmail(recepient, emailSubject, emailBody);
	     			
	      	     			
	        	 }
	        
	        
	        	
	        	 
	         }//End ActionPerformed
	      });//End ActionListener
		
	   
	}//----------------endConstructor---------------------------------------------------------
	



	public void StartTimer(int countpassed) {
		ActionListener action = new ActionListener(){
	         public void actionPerformed(ActionEvent e){
	         	if(count==0) {
	         		stopwatch.stop();
	         		finishedtimer();
	         	}else {
	         		count--;
	         		initializeTimer();
	         	}
	        	 
	        	 
	         }//End ActionPerformed
	      };//End ActionListener
	      stopwatch = new Timer(delay, action);
	      stopwatch.setInitialDelay(0);
	      stopwatch.start();
	      count = countpassed;
	}//end StartTimer Method 
	
	public void initializeTimer() {
	title.setText("Thank you!");
		namelbl.setVisible(false);
		invalidname.setVisible(false);
		
		invalidEmail.setVisible(false);
		name.setVisible(false);
		email.setVisible(false);
		emaillbl.setVisible(false);
		number.setVisible(false);
		numberlbl.setVisible(false);
		submit.setVisible(false);
		disclaimer.setVisible(false);
		Logo.setVisible(false);
	}
	
	
	public void finishedtimer() {
		title.setText("Sign In");
		namelbl.setText("<html><h2>Name:</h2></html>");
		invalidname.setText("<html><h2><em>* ERROR: Must Provide Your Name *</em></h2></html>");
		invalidname.setVisible(false);
	 		invalidEmail.setVisible(false);
	 		name.setVisible(true);
			email.setVisible(true);
			namelbl.setVisible(true);
			emaillbl.setVisible(true);
			number.setVisible(true);
			numberlbl.setVisible(true);
			submit.setVisible(true);
			disclaimer.setVisible(true);
			Logo.setVisible(true);
			submit.setEnabled(true);
			
	}
		
	
	public boolean validateName(String input) {
		String regex = "^[A-Za-z]+\\s*[A-Za-z]+$";
		Pattern pat = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pat.matcher(input);
		return matcher.find();
		
	
	}//ends validate name
	
	public boolean validateEmail(String input) {
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(input);
		return matcher.find();
	}//ends validate email
	
	

	 public static void main(String [] args){
	      //Runs the window creation code
	      new MainMenu();
	   }
}//ends  Class
