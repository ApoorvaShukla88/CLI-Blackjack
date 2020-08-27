package part1;

import java.util.Scanner;

public class BlackjackPart1 {
	
	static int[] deck = new int[52];
	
	//Easy reading
	static String[] suits = {"s", "h", "d", "c"};
	static String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		boolean WannaPlay = true;
		
		
		
			// Intialize the card
			for(int i = 0; i < deck.length; i++) deck[i] = i;	
		
		do {	
			
			// Shuffle the cards
						for( int i = 0; i < deck.length; i++) {
							int index = (int) (Math.random() * deck.length);
							int temp = deck[i];
							deck[i] = deck[index];
							deck[index] = temp;
							
							
						}		
				
				

				
				
				int dealerScore = 0;
				int playerScore = 0;
				
				// distrobution of cards to player and dealer
				for(int i = 0; i < 4; i++) {
					if (i% 2 == 0) {
						playerScore += getScore(deck[i]);
					}else {
						dealerScore += getScore(deck[i]);
					}
				}
				System.out.println("Player Score  is " + playerScore);
				System.out.println("Dealer Score  is " + dealerScore);
				
				if (!checkWinner(playerScore, dealerScore)) {
					int j = 4;
					Scanner hitOrStand = new Scanner(System.in);
					System.out.println("Enter h to HIT or s to STAND : ");
					char userChoice = hitOrStand.next().charAt(0);
					while(userChoice == 'h') {
						playerScore += getScore(deck[j]);
						if (!checkWinner(playerScore, dealerScore)) {
							j++;
							dealerScore += getScore(deck[j]);
							if (!checkWinner(playerScore, dealerScore)) {
								j++;
							userChoice = hitOrStand.next().charAt(0);}
						} else userChoice = 's';
//						if (checkWinner(playerScore, dealerScore)) {
//							WannaPlay = Continue();
//						} else {
//							break;
//						}
					}
				}
				
				
				
				WannaPlay = Continue();	
				
				
			}while(WannaPlay == true);
		
		System.out.println();
		System.out.println("Thanks for playing CLI Blackjack!");
		System.out.println("Come back to lose more money!!!!!");
		
		input.close();
	}
	
	
	public static int getScore(int cardIndex) {
		String suit = suits[deck[cardIndex] / 13];
		String rank = ranks[deck[cardIndex] % 13];
		int result = Integer.parseInt(rank);
        switch (Integer.parseInt(rank))
        {
            case 11:
            case 12:
            case 13:
                result =  10;
        }
        return result;
		
	}
	
	public static boolean checkWinner(int playerScore, int dealerScore) {
		
		if (playerScore == 21 || dealerScore > 21) {
			System.out.println("Player Wins");
			return true;
		} else if (dealerScore ==21 || playerScore > 21) {
			System.out.println("Dealer Wins");
			return true;
		} else {
			return false;
		}
		
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