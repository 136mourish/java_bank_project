package javabankproject;

import java.util.Scanner;

public class bankmain {

	public static void main(String[] args) {
		 
		 boolean s = false;
		 Scanner scanner = new Scanner(System.in);
		 
		 bankfunction b =new bankfunction();
		 b.connection();
		 
		 System.out.println("                      Welcome to Bank Application                           ");
		 
		// while (s!=true) {
			 
			 System.out.println("1. Create Bank Account");
			 System.out.println("2. Check balance");
			 System.out.println("3. Cash Withdrawal");
			 System.out.println("4. Cash Deposit ");
			 
			 
			 try {
				 
				 System.out.println("\n Enter option: ");
				 switch (scanner.nextInt()) {
				  
				 case 1: 
				      b.create( );
					 // s=true;
					  break;
					  
				 case 2:
					  b.check_b();
					//  s=true;
					  break;
				
				 case 3:
					 b.withdrawal( );
					// s=true;
					 break;
				case 4:
					b.depo();
					//s=true;
					break;
					
					 
				default :
					 System.out.println("\n Invalid Option");
					 //s=true;
					 break;
					
 }
				 
				 
				 
				 
			 }
			 catch (Exception e) {
				 //e.printStackTrace();
				 System.out.println("\n not valid ! Enter an Integer");
				 
			 }
		 
     scanner.close();
	}

}
