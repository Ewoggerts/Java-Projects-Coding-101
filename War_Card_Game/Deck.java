/** Utils that need to be imported for the code to work.*/
import java.util.ArrayList;
import java.util.Random;

/** it generates a deck from a arraylist of cards*/
public class Deck {
	/**arraylist representing the deck of cards*/
	private ArrayList<Card> cards;
	/**size of the deck*/
	private int size;

	/**constructor for deck which uses array parameters 
     *@param ranks uses an array of available ranks
     *@param suits uses an array of available suits
     *@param values uses an array of available values*/
	public Deck(String[] ranks, String[] suits, int[] values){
		cards = new ArrayList<Card>();
		for (int i = 0;i<ranks.length && i<suits.length &&i<values.length;i++){
			cards.add(new Card(ranks[i],suits[i],values[i]));
		}
		size = cards.size();
	}
	/**constructor with arraylist of cards
     *@param deck uses arraylist of cards to make them into a deck object*/
	public Deck(ArrayList<Card> deck) {
		cards = deck;
		size = deck.size();
	}
	/**makes a standard 52 card deck, in order*/
	public Deck(){
		
		cards = new ArrayList<Card>();
		//create arrays contaning all the values and suits and point values
		String[] suits = {"diamonds","clubs","hearts","spades"};
		String[] ranks = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
		//2 is the lowest, ace is the biggest (14), j=11, q=12, k =13
		int[] pointValues = {2,3,4,5,6,7,8,9,10,11,12,13,14};
		//set each card in the deck to all possible cards
		for (int i = 0;i<suits.length;i++){
			for (int j = 0;j<ranks.length;j++){
				cards.add(new Card(ranks[j], suits[i], pointValues[j]));
			}	
		}
		size = cards.size();
	}
	/**The method deals the first card from the deck, checks if deck is empty
     *@return card if card is removed from deck it returns removed card; null if deck is empty*/
	public Card deal(){
		if (size==0){
			return null;
		} else {

			return cards.remove(0);
		}
	}
	/**Gets the card at the given index, returns null if not possible
     *@param index index is the index in which the card is located
     *@return card returns card if card is at specified index; null if card not at index*/
	public Card get(int index) {
		if (index<cards.size()) {
			return cards.get(index);
		}
		return null;
	}
	/**checks if deck card size is 0
     *@return boolean returns boolean stating T/F if card array is empty*/
	public boolean isEmpty(){
		return cards.size()==0;
	}
	/**adds card to the end of the deck
     *@param card adds card object to the end of the deck*/
	public void addCard(Card card){
		cards.add(card);
	}
	/**adds card to the given index
     *@param index location in cards
     *@param card it is the card object that you are adding*/
	public void addCard(int index, Card card) {
		cards.add(index,card);
	}
	/**This method shuffles and randomizes deck*/
	public void shuffle(){
		//create new random object
		Random rand = new Random();
		//swaps card at index i with card at random index i to deck size
		for (int i = 0;i<cards.size();i++) {
			int randomIndex = i+rand.nextInt(cards.size()-i);
			Card temp = cards.get(randomIndex);
			cards.set(randomIndex, cards.get(i));
			cards.set(i, temp);
		}
	}
	/**returns size of deck
   *@return size return instance variable called size*/
	public int size(){
		return size;
	}
	/**sets size of deck to current size, if not done so already*/
	public void updateSize() {
		size = cards.size();
	}
	/**toString to return all the cards in their array
     *@return ret returns all the cards in the array of card in a string*/
	public String toString(){
		String ret = "";
		for (Card card:cards){
			ret +=card+"\n";
		}
		return ret;
	}
}
