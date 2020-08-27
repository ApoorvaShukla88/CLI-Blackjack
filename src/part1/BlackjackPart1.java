package part1;

import java.util.Scanner;

public class BlackjackPart1 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		boolean WannaPlay = true;
		
		do {
			int[] deck = new int[52];
			
			//Easy reading
			String[] suits = {"s", "h", "d", "c"};
			String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
			
				// Intialize the card
				for(int i = 0; i < deck.length; i++) deck[i] = i;
				
				// Shuffle the cards
				for( int i = 0; i < deck.length; i++) {
					int index = (int) (Math.random() * deck.length);
					int temp = deck[i];
					deck[i] = deck[index];
					deck[index] = temp;
					
					
				}
//				
	//			// Display first four cards
	//			for(int i = 0; i < deck.length; i++) {
	//				String suit = suits[deck[i] / 13];
	//				String rank = ranks[deck[i] % 13];
	//				System.out.println(rank + suit);
	//			}
	//			
				
				
				
				
			// Game starts - 
	//			String userHand = new String[10];
	//			String dealerHand = new String[10];
	//			
	//			
	//			boolean HIT = true;
	//			
	//			// Display the cards
	//			while (HIT) {
	//				Scanner input = new Scanner(System.in);
	//				String a = input.next();
	//				if(a == 'HIT') {
	//					
	//				}
				
				WannaPlay = Continue();
				
			}while(WannaPlay == true);
		
		System.out.println();
		System.out.println("Thanks for playing CLI Blackjack!");
		System.out.println("Come back to lose more money!!!!!");
		
		input.close();
	}
	
	//Continue class
	public static boolean Continue() {
		
		Scanner temp_input = new Scanner(System.in);
		
		boolean temp_bool = false;
		char UserInput;

		System.out.println();
		System.out.print("Would you like to play again? (y / n) : ");
		
		UserInput = temp_input.next().charAt(0);
		
//		System.out.println(UserInput);
//		System.out.println((UserInput == 'y') + "  " + (UserInput == 'Y'));
		
		if(UserInput != 'Y' && UserInput != 'y' && UserInput != 'N' && UserInput != 'n') {
			
			System.out.print("Invalid response detected. Please try again...... \n\n");
			
			Continue();
			
		}else if(UserInput == 'y' || UserInput == 'Y') {
			
			temp_bool = true;
			
		}else if (UserInput == 'n' || UserInput == 'N') {
			
			temp_bool =  false;
			
		}else{
			
			System.out.println("Fatal Error... Please Try again.....");
			
			Continue();
		}
		
		
		
		return temp_bool;
	}
		
}