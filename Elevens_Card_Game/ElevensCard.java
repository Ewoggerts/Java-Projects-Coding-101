
/** It generates card with pointValue, Rank, Suit*/
public class ElevensCard {
	/**Point value of the card (for war used 2-14, ace = 14, 2 = 2)*/
	private int pointValue;
	/**Name of the card*/
	private String rank;
	/**suit of the card*/
	private String suit;

	/**Constructor with parameters for the Card. It can generate any card with the values that you choose.
     *@param cardRank name of card
     *@param cardSuit suit of card
     *@param cardPV point value of card*/
	public ElevensCard(String cardRank,String cardSuit,int cardPV)
	{
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPV;
	}
	/**Getter for point value of card.
     *@return pointValue returns pointValue instance variable*/
	public int pointValue() {
		return pointValue;
	}
	/**Getter for rank of card.
     *@return rank returns rank instance variable*/
   
	public String rank(){
		return rank;
	}
	/**Getter for suit of card.
     *@return suit return suit instance variable*/
	public String suit(){
		return suit;
	}
	/**toString method that returns the rank, suit, and pointValue of the card.
     *@return rank,suit,pointValue returns instance variable rank*/
	public String toString()
	{
        String temp;
        if (suit.equalsIgnoreCase("diamonds")) {
            temp = "♦";
        } else if (suit.equalsIgnoreCase("spades")) {
            temp = "♠";
        } else if (suit.equalsIgnoreCase("clubs")) {
            temp = "♣";
        } else if (suit.equalsIgnoreCase("hearts")) {
            temp = "♥";
        } else {
            temp = suit;
        }
        return rank + " " +temp;
    }
}
