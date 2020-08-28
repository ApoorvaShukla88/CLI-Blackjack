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
			
			//Creates Players hand and Dealers Hand
			String[] dealerHand = new String[10];
			String[] playerHand = new String[10];
			
			//Sets Scores to 0
			int dScore = 0;
			int pScore = 0;
			//Creates instance of new deck
			new_deck = NewDeck.NewDeck();
		
			
			
			// distribution of cards to player and dealer
			for(int i = 0; i < 4; i++) {
				if (i% 2 == 0) {
					playerHand[i/2] = new_deck[i];//+= CardValue(deck[i],pScore);
				}else {
					//dealerScore += CardValue(deck[i],dealerScore);
					dealerHand[i/2] = new_deck[i];
				}
			}

			
			//Check Dealer Black Jack before play starts after dealing
			//If dealer has A + 10/J/Q/K they auto win if player doesn't have it as well
			boolean auto_lost = Winner.BlackJackCheck(pScore, dScore);
			
			System.out.println(auto_lost);
			//Automatically reset the game if plater wants to continue;
			//After losing to a blackjack
			if(auto_lost) {
				WannaPlay = Continue.Continue();
				if(WannaPlay){main(args);}	
			}
			
			System.out.println("Player Hand  is " + showHand(playerHand));
			System.out.println("Player score  is " + getScore(playerHand,pScore));
			System.out.println("Dealer Hand  is " + showHand(dealerHand));
			System.out.println("Dealer Hand  is " + getScore(dealerHand,dScore));
			
			Hit.hit(pScore, dScore, auto_lost, new_deck);
			
			
			//Calls Continue Method
			WannaPlay = Continue.Continue();	
			
				
			}while(WannaPlay == true);
		
		System.out.println();
		System.out.println("Thanks for playing CLI Blackjack!");
		System.out.println("Come back to lose more money!!!!!");
		
		input.close();
	}
	
	public static String showHand(String[] hand) {
		String handStr = "";
		for(int i=0;i<hand.length;i++) {
			if (hand[i] == null) continue;
			handStr = handStr + hand[i] +" ";
		}
		return handStr;
	}
	
	public static int getScore(String[] hand, int score) {
		for(int i=0;i<hand.length;i++) {
			if (hand[i] == null) continue;
			score = CardValue(hand[i], score);
		}
		return score;
	}
}




/**
 * 	Scanner input = new Scanner(System.in);
		
		boolean WannaPlay = true;

		
		do {	
				
				
				
				
				
				
				if (!checkWinner(pScore, dScore)) {
					int j = 3;
					int pHandIdx = 1;
					Scanner hitOrStand = new Scanner(System.in);
					System.out.println("Enter h to HIT or s to STAND : ");
					char userChoice = hitOrStand.next().charAt(0);
					while(userChoice == 'h') {
						j++;
						pHandIdx++;
						playerHand[pHandIdx] = deck[j];
						pScore = getScore(playerHand,pScore);
						System.out.println("Player Hand  is " + showHand(playerHand));
						System.out.println("Player score  is " + pScore);
						if (checkScore(pScore)) {
							System.out.println("Enter h to HIT or s to STAND : ");
							userChoice = hitOrStand.next().charAt(0);
							
						} else {
							System.out.println("Player lost");
							break;
						}
					}
				}
				
				
				
				WannaPlay = Continue();	
				
				
			}while(WannaPlay == true);
		
		System.out.println();
		System.out.println("Thanks for playing CLI Blackjack!");
		System.out.println("Come back to lose more money!!!!!");
		
		input.close();
	}
	
	
	
	
	
	
	public static boolean checkScore(int score) {
		if (score <=21 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkWinner(int pScore, int dealerScore) {
		
		if (pScore == 21 || dealerScore > 21) {
			System.out.println("Player Wins");
			return true;
		} else if (dealerScore ==21 || pScore > 21) {
			System.out.println("Dealer Wins");
			return true;
		} else {
			return false;
		}
		
	}
	
	// Card Value Calculating
	public static int CardValue(String faceValue, int score) {
		String[] value = faceValue.split("",2);
		if(value[1].equals("J") || value[1].equals("K") || value[1].equals("Q")) {
			return 10+score;	
		} else if (value[1].equals("A") && score > 10) {
			return 1+score;
		} else if (value[1].equals("A") && score <= 10) {
			return 11+score;
		}else {
			return Integer.parseInt(value[1])+score;
		}
	}
		
}
 */





