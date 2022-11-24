
import java.util.ArrayList;
import java.util.Random;


public class ElevensDeck {
	/**arraylist representing the deck of deck*/
	private ArrayList<ElevensCard> deck;
	/**construct new ElevensDeck using arrayList of ElevensCard*/
	public ElevensDeck(ArrayList<ElevensCard> deck) {
		this.deck = deck;
	}
	/**no param constructor - makes standard 52 card deck*/
	public ElevensDeck(){

		deck = new ArrayList<ElevensCard>();
		//create arrays contaning all the values and suits and point values
		String[] suits = {"diamonds","clubs","hearts","spades"};
		String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int[] pointValues = {1,2,3,4,5,6,7,8,9,10,0,0,0};
		//set each card in the deck to all possible deck
		for (int i = 0;i<suits.length;i++){
			for (int j = 0;j<ranks.length;j++){
				deck.add(new ElevensCard(ranks[j], suits[i], pointValues[j]));
			}	
		}
	}
	/**deals card can return null if empty
	 * @return null It returns null if there are no more cards to deal*/
	public ElevensCard deal(){
		if (deck!=null && deck.size()!=0){
			return deck.remove(0);
		}
		return null;
	}
	/**gets card at index
	 * @param index It takes the index of the Deck arraylist and returns the value at that index.
	 * @return null It returns null when nothing can be found at the index */
	public ElevensCard get(int index) {
		if (deck!=null && deck.size()!=0 && index<deck.size()) {
			return deck.get(index);
		}
		return null;
	}
	/**checks whether deck is empty or not
	 * @return size it returns the size of the deck
	 */
	public boolean isEmpty(){
		return deck.size()==0;
	}
	/**adds card at given index
	 * @param index It accepts an index in order to add a card at that index
	 * @param card It accepts a card in order to add that card at that index
	 */
	public void addCard(int index, ElevensCard card) {
		deck.add(index,card);
	}
	/**shuffles deck method*/
	public void shuffle(){
		//create new random object
		Random rand = new Random();
		//swaps card at index i with card at random index i to deck size
		for (int i = 0;i<deck.size();i++) {
			int randomIndex = i+rand.nextInt(deck.size()-i);
			ElevensCard temp = deck.get(randomIndex);
			deck.set(randomIndex, deck.get(i));
			deck.set(i, temp);
		}
	}
	/**returns size of deck
	 * @return size It returns size of the deck
	 */
	public int size() {
		return deck.size();
	}
	/**removes card at given index
	 * @param index It removes value from specified index in the deck
	 */
	public void remove(int index) {
		if (deck!= null && deck.size()!=0 && index<deck.size()) {
			deck.remove(index);
		}
	}
	/**toString method to returns card
	 * @return newString It returns card in a string format
	 */
	public String toString(){
        String newString = "";
        for (ElevensCard card: deck)
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
}