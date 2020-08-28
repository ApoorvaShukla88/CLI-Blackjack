package part1;

import java.util.*;

public class BlackjackPart1 {
	
	public static void main(String[] args) {
		
		int[] new_deck = new int[52];
		
		//Create A Deck
		new_deck = NewDeck.NewDeck();
		
		Scanner input = new Scanner(System.in);
		boolean WannaPlay = true;
		boolean DelearBlackJackCheck = false;
		
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
					
					playerScore += Score.getScore(new_deck[i]);
					
				}else {
					
					dealerScore += Score.getScore(new_deck[i]);
				}
			}
			
//			System.out.println(playerScore);
//			System.out.println(dealerScore);
			
			//Check Dealer Black Jack before play starts after dealing
			//If dealer has A + 10/J/Q/K they auto win if player doesn't have it as well
			boolean auto_lost = Winner.BlackJackCheck(playerScore, dealerScore);
			
			System.out.println(auto_lost);
			//Automatically reset the game if plater wants to continue;
			//After losing to a blackjack
			if(auto_lost) {
				WannaPlay = Continue.Continue();
				if(WannaPlay){main(args);}	
			}
			
			System.out.println("Player Score  is " + playerScore);
			System.out.println("Dealer Score  is " + dealerScore);
			System.out.println();
			
			Hit.hit(playerScore, dealerScore, auto_lost, new_deck);
			
			
			//Calls Continue Method
			WannaPlay = Continue.Continue();	
			
				
			}while(WannaPlay == true);
		
		System.out.println();
		System.out.println("Thanks for playing CLI Blackjack!");
		System.out.println("Come back to lose more money!!!!!");
		
		input.close();
	}
}










