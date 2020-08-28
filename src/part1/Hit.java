package part1;

import java.util.Scanner;

public class Hit {

	public static void hit(int playerScore, int dealerScore, boolean auto_lost, int[] new_deck) {
		
	
		if (!Winner.checkWinner(playerScore, dealerScore, auto_lost)) {
			
			//Deck Starting point after dealing
			int j = 4;
			
			char userChoice = (Menu.Print_Menu()).charAt(0);
			
			while(userChoice == 'h' || userChoice =='H') {
				
				playerScore += Score.getScore(new_deck[j]);
				
				if (!Winner.checkWinner(playerScore, dealerScore, auto_lost)) {
					
					j++;
					
					dealerScore += Score.getScore(new_deck[j]);
					
					if (!Winner.checkWinner(playerScore, dealerScore, auto_lost)) {
						
						j++;
						
					userChoice = (Menu.Print_Menu()).charAt(0);}
					
				} else userChoice = 's';
		//			if (checkWinner(playerScore, dealerScore)) {
		//				WannaPlay = Continue();
		//			} else {
		//				break;
		//			}
			}
		}
	}
}
