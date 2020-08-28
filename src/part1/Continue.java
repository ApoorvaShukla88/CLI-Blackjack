package part1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Continue {

public static boolean Continue() {
		
		Scanner temp_input = new Scanner(System.in);
		char UserInput;
		boolean Continue = true;
	
		try {
			
			//Prompts user for play again script
			System.out.println();
			System.out.print("Would you like to play again? (y / n) : ");
			UserInput = temp_input.next().charAt(0);
			
			if(UserInput == 'Y' || UserInput == 'y') {
				
				Continue = true;
				
			}else if(UserInput == 'n' || UserInput == 'N') {
				
				Continue = false;
				
			}else{
				
				System.out.print("Invalid Response detected.... Please Try Again");
				Continue();
			}
			
		}catch(InputMismatchException e) {
			
			System.out.println("Please either type y or n");
			System.out.println();
			temp_input.nextLine();
			
		}finally{
			
			//Closes Scanner
			temp_input.close();
			
		}
		
		return Continue;
	}
}
