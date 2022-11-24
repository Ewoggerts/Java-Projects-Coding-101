

public class BlackjackCard {
	private int pointValue;
	private String rank;
	private String suit;
/**It creates a card using param
 * @param cardRank sets rank of card
 * @param cardSuit sets suit of card
 * @param cardPV sets point value based on card*/
	public BlackjackCard(String cardRank,String cardSuit,int cardPV)
	{
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPV;
	}
	/**gets point value of card
	 * @return returns pointValue of card*/
	public int pointValue() {
		return pointValue;
	}
	/**gets rank of card
	 * @return rank returns rank of card*/
	public String rank(){
		return rank;
	}
	/**get suit of card
	 * @return suit returns suit of card*/
	public String suit(){
		return suit;
	}
	/**It checks if the card is an ACE
	 * @return boolean returns a boolean determining if it is an ace*/
	public boolean isAce() {
		return rank.equalsIgnoreCase("A");
	}
	/**returns the rank and the suit of the card
	 * @return rank&suit it returns rank and suit of the card*/
	public String toString(){
		String temp;
		if (suit.equalsIgnoreCase("diamonds")) {
			temp = "\u2666";
		} else if (suit.equalsIgnoreCase("spades")) {
			temp = "\u2660";
		} else if (suit.equalsIgnoreCase("clubs")) {
			temp = "\u2663";
		} else if (suit.equalsIgnoreCase("hearts")) {
			temp = "\u2665";
		} else {
			temp = suit;
		}
		return rank + " " +temp;
	}
	public static void main(String[] args) {
		BlackjackCard test = new BlackjackCard("A","clubs",1);
		System.out.println(test);
	}
	
}
