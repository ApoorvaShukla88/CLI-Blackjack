package part1;

import java.util.Scanner;

public class BlackjackPart1 {
	
	public static void main(String[] args) {
		
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
			
			// Display first four cards
			for(int i = 0; i < deck.length; i++) {
				String suit = suits[deck[i] / 13];
				String rank = ranks[deck[i] % 13];
				System.out.println(rank + suit);
			}
			
			
			
			
			
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
				
			}
			
			
		
	}
