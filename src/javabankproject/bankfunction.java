package javabankproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class bankfunction extends database {
	
	//Scanner scanner = new Scanner(System.in);
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
	int a;
	String name;
	String type;
	int balance;
	int pin , amount;
	
	
	
	
	public void create() {
		
		 
		
		  //name= scanner.next();
		  try {System.out.println("                          Creating Bank Account                          ");
		  System.out.println("   Enter your name");
			name= sc.readLine();
			// \\w+\\s?\\w+
			while(!name.matches("^[a-zA-Z ]*$") ){
				  System.out.println(" !!!!Enter correct name!!!");
				  System.out.println("    Enter your name");
				 // name= scanner.next();
				  name= sc.readLine();
				  
		}
			System.out.println("    Enter account type(saving/salary) :");
			 // type= scanner.next();
			type=sc.readLine();
			  //System.out.println(type);
		
			  while(!type.equals("saving")) {
				  if(type.equals("salary")) {
					  break;
				  }
				  
				  System.out.println("\n !!!!Enter a correct account type!!!!");
				  System.out.println("   Enter account type(saving/salary) :");
				  type=sc.readLine();
				 // type= scanner.next();
				  //System.out.println(type);
				  
				  
			  }
			  System.out.println(" Enter your initial deposit amount (minimum balance if saving account): ");
					  //balance= scanner.nextInt();
			           balance = Integer.parseInt(sc.readLine());
					  //System.out.println(balance);
					  while(balance<1000 && type.equals("saving")) {
						  System.out.print("!!!for saving account deposit minimum balance(1000 rs)!!!");
						  System.out.println("\n  Enter your initial deposit amount: ");
						  //balance= scanner.nextInt();
						  balance = Integer.parseInt(sc.readLine());
						  
					  }
			
			  System.out.println(" set a 4 digit pin number :");
			 // pin = scanner.nextInt();
			  pin = Integer.parseInt(sc.readLine());
			  while (pin<1000 || pin>9999 ) {
				  System.out.print("!!! please enter 4 digit pin number!!! :");
				 // pin= scanner.nextInt();
				  pin = Integer.parseInt(sc.readLine());
			  }
			a= create_account(name, type, balance, pin);
			
			System.out.println("\n Account Created Successfully!!");
			
			System.out.println("Your Account number is:"+a);
			  sc.close();
			}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		//return a;
		
	}
	
	public void check_b() {
		
		 try {int b;
			System.out.println("                            Check Balance                         ");
			 System.out.println("\n Enter Account Number: ");
			 //a= scanner.nextInt();
			a = Integer.parseInt(sc.readLine());
			System.out.println("\n Enter pin :");
			// pin=scanner.nextInt();
			 pin = Integer.parseInt(sc.readLine());
			 b=check_balance(a,pin);
			 
			if(b!=-1) {
			System.out.println("\n your current balance is:"+b);
			}
			else {
				System.out.println("either account number or pin is incorrect");}
			sc.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		//return pin;
		
		
	}
	
	public void withdrawal( ) {
		 
		 
		// pin= scanner.nextInt();
			try {System.out.println("                                           Withdrawal                                                           ");
			 System.out.println(" Enter account Number : ");
			 //a= scanner.nextInt();
				a = Integer.parseInt(sc.readLine());
			 System.out.println("Enter pin :");
				pin = Integer.parseInt(sc.readLine());
				
				System.out.println("enter amount :");
				// amount= scanner.nextInt();
					amount = Integer.parseInt(sc.readLine());
				 int c= withdraw(a,pin,amount);
				 
				 if(c==-1) {
						//System.out.println("your current balance is:"+c);
						System.out.println("withdrawal unsuccessful");
						}
				 else if (c==0) {
							System.out.println("either account number or pin is incorrect");
						}
				 else {
					 System.out.println("your current balance is:"+c);
				 }
				sc.close(); 
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
		
	}
	
	public void depo() {
		
		// a= scanner.nextInt();
		 try {
			 System.out.println("                                           Deposit                                                            ");
			 System.out.println(" Enter account Number : ");
			// a= scanner.nextInt();
			 a = Integer.parseInt(sc.readLine());
			 System.out.println("Enter pin :");
			// pin= scanner.nextInt();
			 pin = Integer.parseInt(sc.readLine());
			 System.out.println("enter amount :");
			// amount= scanner.nextInt();
			 amount = Integer.parseInt(sc.readLine());
			 int c= deposit(a,pin,amount);
			 
			 if(c!=0) {
					System.out.println("your current balance is:"+c);
					}
			 else if (c!=-1) {
						System.out.println("either account number or pin is incorrect");
					}
			 else {
				 System.out.println("withdrawal unsuccessful");
			 }
			 sc.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		//return pin;
		
	}
	
	

}
