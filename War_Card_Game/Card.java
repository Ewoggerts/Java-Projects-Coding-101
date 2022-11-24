
/** It generates card with pointValue, Rank, Suit*/
public class Card {
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
	public Card(String cardRank,String cardSuit,int cardPV)
	{
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPV;
	}
	/**Method that returns a boolean if card matches with othercard
     *@param otherCard another card object that you want to compare to the current card object
     *@return boolean reports if the card matches with othercard T/F*/
	public boolean matches(Card otherCard){
		return (otherCard.pointValue()==pointValue && 
				otherCard.rank().equals(rank) && 
				otherCard.suit().equals(suit));
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
	public String toString(){
		return rank +" of " + suit + " (point value = "+pointValue+")";
	}
	
}
