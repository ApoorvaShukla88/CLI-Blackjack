package part1;

import java.util.Scanner;

public class BlackjackPart1 {
	
	static String[] deck = new String[52];
	
	//Easy reading
	static String[] suits = {"s", "h", "d", "c"};
	static String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		boolean WannaPlay = true;
		
			// Intialize the card
			//for(int i = 0; i < deck.length; i++) deck[i] = i;
			
			int deckIndex = 0;
			for (int i=0; i <suits.length;i++) {
				for (int j=0;j<ranks.length;j++) {
					deck[deckIndex] = suits[i] + ranks[j];
					deckIndex++;
				}
				
			}
		
		do {
			
			int dScore = 0;
			int pScore = 0;
			
			// Shuffle the cards
			for( int i = 0; i < deck.length; i++) {
				int index = (int) (Math.random() * deck.length);
				String temp = deck[i];
				deck[i] = deck[index];
				deck[index] = temp;
			}		
			
			String[] dealerHand = new String[10];
			String[] playerHand = new String[10];
			
			dScore = getScore(dealerHand,dScore);
			pScore = getScore(playerHand,pScore);
		
			// distribution of cards to player and dealer
			for(int i = 0; i < 4; i++) {
				if (i% 2 == 0) {
					playerHand[i/2] = deck[i];//+= CardValue(deck[i],playerScore);
				}else {
					//dealerScore += CardValue(deck[i],dealerScore);
					dealerHand[i/2] = deck[i];
				}
			}
			
			System.out.println("Player Hand  is " + showHand(playerHand));
			System.out.println("Player score  is " + getScore(playerHand,pScore));
			System.out.println();
			System.out.println("Dealer Hand  is " + showHand(dealerHand));
			System.out.println("Dealer Hand  is " + getScore(dealerHand,dScore));
			
			if (!checkWinner(pScore, dScore)) {
				
				System.out.println();
				int j = 3;
				int pHandIdx = 1;
				int dHandIdx = 1;
				Scanner hitOrStand = new Scanner(System.in);
				System.out.print ("Enter h to HIT or s to STAND : ");
				char userChoice = hitOrStand.next().charAt(0);
				System.out.println();
				
				while(userChoice == 'h' || userChoice == 'H'){
					j++;
					pHandIdx++;
					playerHand[pHandIdx] = deck[j];
					pScore = getScore(playerHand,pScore);
					System.out.println("Player Hand  is " + showHand(playerHand));
					System.out.println("Player score  is " + pScore);
					if (checkScore(pScore)) {
						System.out.println("Enter h to HIT or s to STAND : ");
						userChoice = hitOrStand.next().charAt(0);
						
					}else{
						System.out.println("Player lost");
						userChoice = 's';
					}
				}
				
			
				while(userChoice == 's' || userChoice == 'S') {
					
					pScore = getScore(playerHand,pScore);
					dScore = getScore(dealerHand,dScore);
					
					if(dScore < 17 && dScore < pScore) {
						j++;
						dHandIdx++;
						dealerHand[dHandIdx] = deck[j];
						dScore = getScore(dealerHand, dScore);
						System.out.println("Dealer Hand  is " + showHand(dealerHand));
						System.out.println("Dealer score  is " + dScore);
					
					}else if(dScore > 17 && dScore > pScore && dScore <=21) {
						
						System.out.println("Dealer Wins!!!!");
						System.out.println("Sorry about your luck.");
						System.out.println();
						userChoice = ' ';
						
					}else if((dScore > 17) && (pScore > dScore) && (pScore <=21)){
						
						System.out.println("Player Wins!!!!");
						System.out.println();
						userChoice = ' ';
					}else{
						userChoice = ' ';
						
					}
				}
			}
			
			WannaPlay = Continue();	
				
				
			}while(WannaPlay == true);
		
		System.out.println();
		System.out.println("Thanks for playing CLI Blackjack!");
		System.out.println("Come back to lose more money!!!!!");
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
	
	public static boolean checkScore(int score) {
		if (score <=21 ) {
			return true;
		} else {
			return false;
		}
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