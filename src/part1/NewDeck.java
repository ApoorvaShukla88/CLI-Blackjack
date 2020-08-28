package part1;

public class NewDeck {
	
	public static int[] NewDeck() {
		
		//Creates new array of 52 cards
		int[] deck = new int[52];
		
		//Actually Creates the deck
		for(int i = 0; i < deck.length; i++) deck[i] = i;
		
			// Shuffle the cards
			for( int i = 0; i < deck.length; i++) {
				int index = (int) (Math.random() * deck.length);
				int temp = deck[i];
				
				deck[i] = deck[index];
				
				deck[index] = temp;
			}
		
		return deck;
	}

}
