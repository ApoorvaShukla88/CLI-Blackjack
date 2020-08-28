package part1;

public class Score {

	public static int getScore(int cardIndex) {
		/**
		 * 
		 * So, we need to figure out how to handle 1, because 1 is 1 and 11 simultaneously
		 */
		
		//Defined Ranks and Suits
		String[] suits = {"s", "h", "d", "c"};
		String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
		
		//Card index already an int
		String suit = suits[cardIndex / 13];
		String rank = ranks[cardIndex % 13];
		
		int result = Integer.parseInt(rank);
		
		//Face Cards
        switch (Integer.parseInt(rank))
        {
            case 11:
            case 12:
            case 13:
                result =  10;
        }
        return result;
		
	}
}
