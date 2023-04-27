package e1_jdbc2.user.employee;

import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) throws Exception {
        System.out.println("=========welcome===========");
		Scanner sc=new Scanner(System.in);
		boolean check=true;
	  EmployeeCrud crud=new EmployeeCrud();
		
		
		do {
			System.out.println("choose your option \n 1.save  \n 2.update  \n 3.delete  \n 4.retrieveby id  \n 5.retrieve all "
					+ "\n  6.login    \n  7.exit  ");
			int choice=sc.nextInt();
			
			
			switch (choice) {
			case 1:{
				System.out.println("enter the data to save");
				crud.saveEmployee();
			}break;
			case 2:{
				System.out.println("enter the data to update");
			}break;
			case 3:{
				System.out.println("enter the id to delete the data");
			}break;
			case 4:{
				System.out.println("to retrieve your data enter your id");
			}break;
			case 5:{
				System.out.println("all employee details");
			}break;
			case 6:{
				System.out.println("login");
				boolean success =crud.loginUser();
				if(success) {
					System.out.println("logged in successsfully");
				}
				else {
					System.out.println("pls provide correct details");
					crud.loginUser();
				}
			}break;
			case 7:{
			 check=false;
			}break;

			default: {
				System.out.println("pls choose the above mentioned numbers");
			}
				break;
			}
					

			
			
		} while (check);
		
		System.out.println("=======thank you========");
		
		
		
		
		
		
		
		
		
	}

}
