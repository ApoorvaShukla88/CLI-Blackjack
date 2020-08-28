package part1;

import java.util.*;

public class BlackjackPart1 {
	
	public static void main(String[] args) {
		
		int[] new_deck = new int[52];
		
		
		
		//Create A Deck
		new_deck = NewDeck.NewDeck();
		
		Scanner input = new Scanner(System.in);
		boolean WannaPlay = true;
		
			// Initialize the card
				
		
		do {	
			
			//Reset to 0 each iteration
			int dealerScore = 0;
			int playerScore = 0;
			
			//Creates instance of new deck
			new_deck = NewDeck.NewDeck();
				

				
				// Distribution of cards to player and dealer
				for(int i = 0; i < 4; i++) {
					//Dealer, Player, Dealer, Player
					if (i% 2 == 0) {
						
						playerScore += getScore(new_deck[i]);
						
					}else {
						
						dealerScore += getScore(new_deck[i]);
					}
				}
				
				System.out.println("Player Score  is " + playerScore);
				System.out.println("Dealer Score  is " + dealerScore);
				
				if (!checkWinner(playerScore, dealerScore)) {
					int j = 4;
					
					Scanner hitOrStand = new Scanner(System.in);
					
					System.out.println("Enter h to HIT or s to STAND : ");
					
					char userChoice = hitOrStand.next().charAt(0);
					
					while(userChoice == 'h' || userChoice =='H') {
						
						playerScore += Score.getScore(new_deck[j]);
						
						if (!checkWinner(playerScore, dealerScore)) {
							
							j++;
							
							dealerScore += Score.getScore(new_deck[j]);
							
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
				
				
				//Calls Continue Method
				WannaPlay = Continue.Continue();	
				
				
			}while(WannaPlay == true);
		
		System.out.println();
		System.out.println("Thanks for playing CLI Blackjack!");
		System.out.println("Come back to lose more money!!!!!");
		
		input.close();
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
	
		
}