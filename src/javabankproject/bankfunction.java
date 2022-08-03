package javabankproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bankfunction extends database {
	
	
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
	int a;
	String name;
	String type;
	int balance;
	int pin , amount;
	
	
	
	
	public void create() {
		
		 
		
		 
		  try {System.out.println("                          Creating Bank Account                          ");
		  System.out.println("   Enter your name");
			name= sc.readLine();
			
			while(!name.matches("^[a-zA-Z ]*$") ) {
				try {
				   throw new invalidException(" Invalid Name");
				} catch (invalidException ee) {
					  System.out.println("Error"+ee.getMessage());
				  }
				 finally {
				  System.out.println("    Enter your name");
				 
				  name= sc.readLine();
				 }
		}
			System.out.println("    Enter account type(saving/salary) :");
			
			type=sc.readLine();
			 
		
			  while(!type.equalsIgnoreCase("saving")) {
				  if(type.equalsIgnoreCase("salary")) {
					  break;
				  }
				  
				 try {
					 throw new invalidException(" Invalid Account Type");
				 } catch (invalidException ee) {
					 System.out.println("Error"+ee.getMessage());
				 }
				  finally{
			
				  System.out.println("   Enter account type(saving/salary) :");
				  type=sc.readLine();
				
				  }
				  
			  }
			  System.out.println(" Enter your initial deposit amount (minimum balance if saving account): ");
					  
			           balance = Integer.parseInt(sc.readLine());
					
					  while(balance<1000 && type.equals("saving")) {
						  try {
							  throw new invalidException(" Amount Less Than Minimum Balance  ");
						  }
						  catch (invalidException ee) {
							  System.out.println("Error"+ee.getMessage());
						  }
						  finally {
					
						  System.out.println("\n  Enter your initial deposit amount: ");
						
						  balance = Integer.parseInt(sc.readLine());
						  }
						  
					  }
			
			  System.out.println(" set a 4 digit pin number :");
		
			  pin = Integer.parseInt(sc.readLine());
			  while (pin<1000 || pin>9999 ) {
				  try {
					  throw new invalidException(" Invalid Enter a 4 digit Pin Number");
				  }
				  catch (invalidException ee){
					  System.out.println("Error"+ee.getMessage());
					  
				  }
				  finally {
				  System.out.print("!!! please enter 4 digit pin number!!! :");
				
				  pin = Integer.parseInt(sc.readLine());}
			  }
			a= create(name, type, balance, pin);
			
			System.out.println("\n Account Created Successfully!!");
			
			System.out.println("Your Account number is:"+a);
			  sc.close();
			}catch (IOException e) {
	
			e.printStackTrace();
		}
		  
		  
		
		
	}
	
	public void check() {
		
		 try {int b;
			System.out.println("                            Check Balance                         ");
			 System.out.println("\n Enter Account Number: ");
			
			a = Integer.parseInt(sc.readLine());
			System.out.println("\n Enter pin :");
		
			 pin = Integer.parseInt(sc.readLine());
			 b=check(a,pin);
			 
			if(b!=-1) {
			System.out.println("\n your current balance is:"+b);
			}
			else {
				System.out.println("either account number or pin is incorrect");}
			sc.close();
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
		
	
		
		
	}
	
	public void withdrawal( ) {
		 
		 
		
			try {System.out.println("                                           Withdrawal                                                           ");
			 System.out.println(" Enter account Number : ");
			
				a = Integer.parseInt(sc.readLine());
			 System.out.println("Enter pin :");
				pin = Integer.parseInt(sc.readLine());
				
				System.out.println("enter amount :");
				
					amount = Integer.parseInt(sc.readLine());
				 int c= withdrawal(a,pin,amount);
				 
				 if(c==-1) {
						
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
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		 
		
		
	}
	
	public void depo() {
		
		
		 try {
			 System.out.println("                                           Deposit                                                            ");
			 System.out.println(" Enter account Number : ");
			
			 a = Integer.parseInt(sc.readLine());
			 System.out.println("Enter pin :");
			
			 pin = Integer.parseInt(sc.readLine());
			 System.out.println("enter amount :");
		
			 amount = Integer.parseInt(sc.readLine());
			 int c= depo(a,pin,amount);
			 
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
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
	
		
	}
	
	

}
