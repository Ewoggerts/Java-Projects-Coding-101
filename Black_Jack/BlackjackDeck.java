

import java.util.ArrayList;
import java.util.Random;



public class BlackjackDeck {
	/**arraylist representing the deck of deck class*/
	private ArrayList<BlackjackCard> deck;
	/**construct new ElevensDeck using arrayList of ElevensCard*/
	public BlackjackDeck(ArrayList<BlackjackCard> deck) {
		this.deck = deck;
	}
	/**creates Deck for blackjack (52 cards)*/
	public BlackjackDeck() {
		deck = new ArrayList<BlackjackCard>();
		String[] suits = {"diamonds","clubs","hearts","spades"};
		String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int[] pointValues = {1,2,3,4,5,6,7,8,9,10,10,10,10};
		for (int i = 0;i<suits.length;i++){
			for (int j = 0;j<ranks.length;j++){
				deck.add(new BlackjackCard(ranks[j], suits[i], pointValues[j]));
			}	
		}
	}
	/**deals card from deck and removes it as well
	 * @return removed it returns removed card from deck or null*/
	public BlackjackCard deal(){
		if (deck!=null && deck.size()!=0){
			return deck.remove(0);
		}
		return null;
	}
	/** it gets the blackjack card from deck given the index in the deck
	 * @param index uses index param in order to get blackjack card from deck 
	 * @return card returns card found in index*/
	public BlackjackCard get(int index) {
		if (deck!=null && deck.size()!=0 && index<deck.size()) {
			return deck.get(index);
		}
		return null;
	}
	/**checks t/f if the deck is empty
	 * @return boolean it determines if deck is empty*/
	public boolean isEmpty(){
		return deck.size()==0;
	}
	/**it adds card in a specific index of the deck card given index
	 * @param index uses index in order to determine where to add card
	 * @param card it is the card you want to place in certain index*/
	public void addCard(int index, BlackjackCard card) {
		deck.add(index,card);
	}
	/**shuffles deck*/
	public void shuffle(){
		//create new random object
		Random rand = new Random();
		//swaps card at index i with card at random index i to deck size
		for (int i = 0;i<deck.size();i++) {
			int randomIndex = i+rand.nextInt(deck.size()-i);
			BlackjackCard temp = deck.get(randomIndex);
			deck.set(randomIndex, deck.get(i));
			deck.set(i, temp);
		}
	}
	/**gets the size of the deck
	 * @return size it returns the size of the deck*/
	public int size() {
		return deck.size();
	}
	/**it removes card from index in the deck
	 * @param index it takes the index value to determine where to remove a card in deck or null if not there*/
	public void remove(int index) {
		if (deck!= null && deck.size()!=0 && index<deck.size()) {
			deck.remove(index);
		}
	}
	/**toString to returns cards in deck
	 * @return newString it returns string with the list of cards*/
	public String toString(){
		String newString = "";
		for (BlackjackCard card: deck)
		{
			if (card.rank().equals("10"))
			{
				newString+=card+"  ";
			}
			else
			{
				newString +=card+"   ";
			}
		}
		return newString;
	}
	public static void main(String[] args) {
		BlackjackDeck test = new BlackjackDeck();
		System.out.println(test);
	}
}
