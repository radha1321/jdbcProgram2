package e1_jdbc2.user;

import java.util.Scanner;

public class UserMain {

	
	public static void main(String[] args) throws Exception {
	
		UserCrud crud=new UserCrud();
		Scanner sc=new Scanner(System.in);
		boolean check=true;
		
		//to execute the code later it can check condition
	  do {
		  System.out.println("choose your choice \n 1.save \n 2.update    \n 3.delete    \n 4.allUserDetails   \n 5.exit  ");
		  int choice=sc.nextInt();
		
		  switch (choice) {
		case 1:{
			
			//asking user to provide data to save 
			System.out.println("==============enter your details to save ==============");
			System.out.println("enter your id");
			int id=sc.nextInt();
			System.out.println("enter your name");
			String name =sc.next();
			System.out.println("enter your email");
			String email=sc.next();
			System.out.println("enter your phone");
			String phone=sc.next();
			System.out.println("enter your password");
			String pwd=sc.next();
			
			User user=new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setPwd(pwd);
			
			crud.saveUser(user);
			System.out.println("*******************inserted*************");
					}
			
			break;
		case 2:{
			System.out.println("================enter your details to update==========");
			System.out.println("enter your id");
			int id=sc.nextInt();
			System.out.println("enter your email");
			String email=sc.next();
			System.out.println("enter your phone");
			String phone=sc.next();
			
			User user=new User();
			user.setId(id);
			user.setEmail(email);
			user.setPhone(phone);
			
			crud.updateUser(user);
			
			System.out.println("*********************updated**************");
			
			
		}break;
		
		case 3:{
			System.out.println("enter your id to delete");
			int id=sc.nextInt();
			User user=new  User();
			user.setId(id);
			
			crud.deleteUser(user);
			System.out.println("********************deletde ****************");
			
		}break;

		case 4:{
			crud.retrieveUser();
		}break;
		
		
		
		default: check=false;
			break;
		}
		 
	
		
	} while (check);
	  
	  System.out.println("===================thank you=============");
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
