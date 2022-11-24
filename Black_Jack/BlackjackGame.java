

import java.util.ArrayList;
import java.util.Scanner;
//add and auto

public class BlackjackGame {
	/**creates deck for blackjack*/
	private BlackjackDeck deck;
	/**creates deck that contains the dealer's hand*/
	private BlackjackDeck dealerHand;
	/**creates deck that contains the player's hand*/
	private BlackjackDeck playerHand;
	/**creates a instance integer that contains the value of the dealer's hand*/
	private int dealerValue;
	/** creates a instance integer that contains the value of the player's hand*/
	private int playerValue;
	/** it creates a instance boolean that determines whether the game has been split*/
	private boolean splitGame;
	/** it creates a instance to hold the card once the hand has been split(to be used in table)*/
	private BlackjackCard tempCard;
	/** it creates the blackjack game that doesn't require a param*/
	public BlackjackGame() {
		splitGame = false;
		dealerValue = 0;
		playerValue = 0;
		deck = new BlackjackDeck();
		deck.shuffle();
		
		dealerHand = new BlackjackDeck(new ArrayList<BlackjackCard>());
		dealerHand.addCard(0, deck.deal());
		dealerHand.addCard(0, deck.deal());
		
		playerHand = new BlackjackDeck(new ArrayList<BlackjackCard>());
		playerHand.addCard(0, deck.deal());
		playerHand.addCard(0, deck.deal());
		updatePlayerValue();
		updateDealerValue();
		System.out.println();
		printHands();
		evaluateRound();
	/** it creates the blackjack game that requires a param in order to be able to split.
	 *  this allows us to put the split card into a game of its own(process happens in table class)
	 *  @param dealer uses dealer param in order to hard code in the values generated at random later in split
	 *  @param player does the same thing as dealer*/
	}
	public BlackjackGame(BlackjackDeck dealer, BlackjackCard player) {
		splitGame = true;
		dealerValue = 0;
		playerValue = 0;
		deck = new BlackjackDeck();
		deck.shuffle();
		
		dealerHand = dealer;
		playerHand = new BlackjackDeck(new ArrayList<BlackjackCard>());
		playerHand.addCard(0,player);
		playerHand.addCard(playerHand.size(),deck.deal());
		
		updatePlayerValue();
		updateDealerValue();
		System.out.println();
		printHands();
		evaluateRound();
	}
	/** it get the dealer's hand
	 * @return dealerHand it returns dealer hand*/
	public BlackjackDeck getDealerHand() {
		return dealerHand;
	}
	/** it returns the card that get's split. it is stored in tempcard
	 * @return tempCard returns card being split*/
	public BlackjackCard getSplitCard(){
		return tempCard;
	}
	/**it evaluates the possible actions you can take with your hand given and prints result based off of choice*/
	public void evaluateRound() {
		if (isBlackjack(dealerHand)) {
			System.out.println("dealer has blackjack, you lose");
		} else if (isBlackjack(playerHand)) {
			System.out.println("you have blackjack, you win");
		} else {
	
			while (!isBust(playerHand) && !has21(playerHand)) {
				if (canSplit(playerHand) && !splitGame) {
					System.out.println("hit, stand, double, split");
				} else if  (playerHand.size()==2){
					System.out.println("hit, stand, double");
				} else {
					System.out.println("hit, stand");
				}
				Scanner scan = new Scanner(System.in);
				String input = scan.nextLine().trim();
			
				if (input.equalsIgnoreCase("hit")) {
					hit(playerHand);
					updatePlayerValue();
					System.out.println();
					printHands();
				} else if (input.equalsIgnoreCase("stand")) {
					updatePlayerValue();
					updateDealerValue();
					System.out.println();
					break;
				} else if (input.equalsIgnoreCase("double") && playerHand.size()==2) {
					hit(playerHand);
					updatePlayerValue();
					updateDealerValue();
					System.out.println();
					printHands();
					System.out.println();
					break;
				} else if (!splitGame && input.equalsIgnoreCase("split") && canSplit(playerHand)) {
					System.out.println("splitting hand");
					System.out.println();
					tempCard = playerHand.get(1);
					split();
					playerHand.remove(1);
					playerHand.addCard(playerHand.size(), deck.deal());
					
					updatePlayerValue();
					printHands();
				} else {
					System.out.println("try again");
				}	
				if (has21(playerHand)) {
					System.out.println("you have 21, you win\n");
				} 
			}
			if (!isBust(playerHand)) {
				while (dealerValue<17) {
					dealerHand.addCard(dealerHand.size(), deck.deal());
					updateDealerValue();
					printHands();
					System.out.println("dealer drew a card\n");	
				} 
				if (isBust(dealerHand)) {
					System.out.println("dealer went bust, you win");
				} 	else if (playerValue > dealerValue) {
					System.out.println("you have higher hand, you win");
				} else if (dealerValue > playerValue) {
					System.out.println("dealer has higher hand, you lose.");
				} else {
					System.out.println("you have the same value hand, push");
				}
			} else {
				System.out.println("you went over 21, game over");
			}
		}
	}
	/** determines if your hand is 21pts while setting ace to 11pts
	 * @param hand takes hand parameter to determine if it is black jack
	 * @return total returns total of 21 if blackjack else it returns pointValue of hand*/
	public boolean isBlackjack(BlackjackDeck hand) {
		int total = 0;
		for (int i = 0;i<hand.size();i++) {
			if (hand.get(i).isAce()) {
				total+=11;
			} else {
				total += hand.get(i).pointValue();
			}
		}
		return total==21;
	}
	/**returns the boolean true or false if the players hand given the soft total or hard total is equal to 21
	 * @param hand takes hand parameter to determine if your hand value is 21 with soft and hard total
	 * @return boolean returns true soft and hard total = 21 else false*/
	public boolean has21(BlackjackDeck hand) {
		int softTotal = 0, hardTotal = 0;
		for (int i = 0;i<hand.size();i++) {
			if (hand.get(i).isAce()) {
				softTotal +=11;
				hardTotal +=1;
			} else {
				softTotal +=hand.get(i).pointValue();
				hardTotal +=hand.get(i).pointValue();
			}
		}
		return softTotal==21 || hardTotal ==21;
	}
	/**it determines if the player's hand is over 21
	 * @param hand takes cards in hand deck and determines if it is bust
	 * @return boolean returns t/f if totals are over 21*/
	public boolean isBust(BlackjackDeck hand) {
		int softTotal = 0, hardTotal = 0;
		for (int i = 0;i<hand.size();i++) {
			if (hand.get(i).isAce()) {
				softTotal +=11;
				hardTotal +=1;
			} else {
				softTotal +=hand.get(i).pointValue();
				hardTotal +=hand.get(i).pointValue();
			}
		}
		return softTotal>21 && hardTotal > 21;
	}
	/**updates the value of the dealer's hand. if hard or soft value is = 21 the dealer's value is set to 21*/
	public void updateDealerValue() {
		int softTotal = 0, hardTotal = 0;
		for (int i = 0;i<dealerHand.size();i++) {
			if (dealerHand.get(i).isAce()) {
				softTotal +=11;
				hardTotal +=1;
			} else {
				softTotal +=dealerHand.get(i).pointValue();
				hardTotal +=dealerHand.get(i).pointValue();
			}
		}
		if (softTotal>21 && hardTotal<=21) {
			dealerValue =  hardTotal;
		}  else {
			dealerValue =  softTotal;
		}
	}
	/**updates the value of the player's hand. if hard or soft value is = 21 the player value is set to 21*/
	public void updatePlayerValue() {
		int softTotal = 0, hardTotal = 0;
		for (int i = 0;i<playerHand.size();i++) {
			if (playerHand.get(i).isAce()) {
				softTotal +=11;
				hardTotal +=1;
			} else {
				softTotal +=playerHand.get(i).pointValue();
				hardTotal +=playerHand.get(i).pointValue();
			}
		}
		if (softTotal>21 && hardTotal<=21) {
			playerValue =  hardTotal;
		}  else {
			playerValue =  softTotal;
		}
	}
	/**prints the value of the hands*/
	public void printHands() {
		System.out.println("--dealer hand: " + dealerHand + " value: " + dealerValue
				+ "\n--your hand: "+playerHand + " value: " + playerValue);
	}
	/** it determines if the player's hand can use the split action
	 * @param hand takes hand param and determines if it can be split
	 * @return boolean t/f if can split*/
	public boolean canSplit(BlackjackDeck hand) {
		return hand.size()==2 && hand.get(0).pointValue()==hand.get(1).pointValue();
	}
	/**it allows you to hit and gain a card
	 * @param hand takes hand param to hit*/
	public void hit(BlackjackDeck hand) {
		hand.addCard(hand.size(), deck.deal());
	}
	/** it changes splitGame boolean to true once split has been used. Mainly used to keep track if split has occured.*/
	public void split() {
		splitGame = true;
	}
	/** returns the boolean based off of the split game to determine if it has been run once already
	 * @return splitGame returns boolean of splitgame*/
	public boolean splitGame() {
		return splitGame;	
	}

}
