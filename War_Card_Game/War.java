

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This War class simulates the card game war in a text-based format.
 * 
 * @author Bryant and Ethan
 * @version 1.0
 * @since 2/2/2021
 */

public class War 
{
	//deck object representing the computer's deck
	/**
	 * Deck object representing the computer's deck (26 cards)
	 */
	private Deck compDeck;

	//deck object representing the player's deck
	/**
	 * Deck object representing the player's deck (26 cards)
	 */
	private Deck playerDeck;

	//arraylist representing the temporary deck, the "pot"
	/**
	 * ArrayList of Card objects representing the temporary deck, the "pot"
	 */
	private ArrayList<Card> tempDeck;

	//gameover
	/**
	 * boolean variable that represents wheter the game is over (true) or not (false)
	 */
	private boolean gameOver;


	//create a new game of war
	/**
	 * Creates a new game of war, and sets the player and computer decks to 1/2 of a shuffled 52-card deck
	 * Prints out the sizes of both decks and starts the game afterward
	 */
	public War()
	{
		//create 52 card deck
		Deck deck = new Deck();
		//shuffle deck
		deck.shuffle();
		//create two temporary arrayLists to store each half of the deck
		ArrayList<Card> deckHalf1 = new ArrayList<Card>();
		ArrayList<Card> deckHalf2 = new ArrayList<Card>();
		//deal out the randomized deck, both 26 cards
		for (int i = 0;i<deck.size();i++)
		{
			if (i%2==0)
			{
				deckHalf1.add(deck.get(i));
			} 
			else 
			{
				deckHalf2.add(deck.get(i));
			}
		}
		//initialized both comp and player deck to the two split halves of the randomized deck
		compDeck = new Deck(deckHalf1);
		playerDeck = new Deck(deckHalf2);
		//initalize the temporary deck to empty arraylist
		tempDeck = new ArrayList<Card>();
		gameOver = false;
		//print out deck sizes for start of game
		System.out.println("Deck sizes: "+playerDeck.size()+" (yours) vs. "+ compDeck.size()+ " (computer's)\n");
		playGame();
	}

	//updates the sizes of the computer and player decks
	/**
	 * updates the sizes of the computer and player's decks
	 */
	public void updateSizes()
	{
		compDeck.updateSize();
		playerDeck.updateSize();
	}

	//compares the point values of the two card parameters
	/**
	 * compares two card objects and adjusts the decks accordingly
	 * takes cards from computer and player deck and adds them to tempDeck
	 * prints out the results of the comparison, and the deck sizes
	 * handles ties as well
	 * @param comp the computer's card
	 * @param player the player's card
	 */
	public void compare(Card comp,Card player)
	{
		//cards won by either computer or player
		int cardsWon = tempDeck.size();
		//if player wins
		if (comp.pointValue()<player.pointValue())
		{
			//transfers cards in tempDeck to playerDeck, updates sizes
			for (int i = tempDeck.size()-1;i>=0;i--) {
				playerDeck.addCard(tempDeck.remove(i));
				updateSizes();
			}
			//prints out results of game
			System.out.println("You won " + cardsWon + " cards! "	
					+playerDeck.size()+" (yours) vs. "+ compDeck.size()+ " (computer's)\n");

		}

		//if computer wins
		else if (comp.pointValue()>player.pointValue())
		{
			//transfers cards in tempDeck to compDeck, updates sizes
			for (int i = tempDeck.size()-1;i>=0;i--) {
				compDeck.addCard(tempDeck.remove(i));
				updateSizes();
			}
			//prints out results of game
			System.out.println("Computer won " + cardsWon + " cards! Deck sizes: "
					+playerDeck.size()+" (yours) vs. "+ compDeck.size()+ " (computer's)\n");

		}

		//if tie
		else
		{
			System.out.println("It's a tie! Battle Again!\nYou and the computer lay down three cards");
			//calls on createTempDeck, which adds 6 cards to tempDeck, 3 from each comp and player deck
			addTempDeck();
			//plays another round
			playRound();

		}
	}

	//plays the round
	/**
	 * simulates a single round of war
	 * checks if either deck is empty, and prints out the respective message
	 * processes scanner input, including shuffle and playing the next round
	 */
	public void playRound()
	{
		//checks if either deck is 0, if so, then game is over
		if (compDeck.size()==0) {
			System.out.println("You win, computer out of cards");
			gameOver=true;
		} else if (playerDeck.size()==0) {
			System.out.println("You lose, you are out of cards");
			gameOver=true;
		} else {
			//wait for input to be entered then execute rest of this block
			//if input is s then run .shuffle() method on playerDeck
			System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");		
			Scanner scan = new Scanner(System.in);
			String enterkey = scan.nextLine();
			if(enterkey.equals (""))
			{
				//deals one card from both decks, updates sizes
				Card compCard = compDeck.deal();
				Card playerCard = playerDeck.deal();
				updateSizes();
				//adds both to tempDeck
				tempDeck.add(compCard);
				tempDeck.add(playerCard);
				//prints out results of draw
				System.out.println("You drew a "+playerCard);
				System.out.println("Computer drew a "+compCard);
				//calls on compare method to decide what happens
				compare(compCard,playerCard);
			} else if (enterkey.equalsIgnoreCase("s")) {
				playerDeck.shuffle();
				System.out.println("Your deck has been shuffled\n");
			} else {
				System.out.println("Try again\n");
			}
		}
	}

	//adds 6 cards to tempDeck
	/**
	 * adds 6 cards to tempDeck to simulate what happens during a tie
	 * also checks for either deck being empty
	 * if either deck has less than 3 cards then what is left is added
	 */
	public void addTempDeck()
	{
		//checks if either deck is empty
		if (compDeck.size()==0) {
			System.out.println("You win, computer out of cards");
			gameOver=true;
		} else if (playerDeck.size()==0) {
			System.out.println("You lose, you are out of cards");
			gameOver=true; 
		} else {
			//at all times tries to add 3 cards, if either deck has <3 then add whatever is left
			for (int i = 0;i<3 && i<compDeck.size();i++)
			{
				if (compDeck.size()==0) {
					System.out.println("Computer is out of cards");

				} else {
					tempDeck.add(compDeck.deal());
				}
			}
			for (int i = 0;i<3 && i<playerDeck.size();i++)
			{
				if (playerDeck.size()==0) {	
					System.out.println("You are out of cards");
				} else {
					tempDeck.add(playerDeck.deal());
				}
			}
		}
	}
	//gets gameOver instance variable
	/**
	 * returns the game status; true if game is over, false if not
	 * @return boolean the status of the game
	 */
	public boolean gameStatus()
	{
		return gameOver;
	}
	/**
	 * simulates a standard game, keeps playing rounds until the game is over
	 * 
	 */
	public void playGame() {
		while(gameOver==false) {
			playRound();
		}
	}

}

