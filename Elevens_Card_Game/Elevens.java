
import java.util.ArrayList;
import java.util.Scanner;


public class Elevens {
	/**deck player draws from*/
	private ElevensDeck compDeck;
	/**the "hand" or cards on table*/
	private ElevensDeck hand;
	
	/**constructor without param that runs the game as well*/
	public Elevens() {
		//creates standard 52 card deck
		ElevensDeck deck = new ElevensDeck();
		//shuffles deck
		deck.shuffle();
		//sets compDeck to that deck
		compDeck = deck;
		
		//creates empty arrayList for initializing the hand
		ArrayList<ElevensCard> temp = new ArrayList<ElevensCard>();
		hand = new ElevensDeck(temp);
		//draws 9 cards from compDeck to start the hand
		for (int i = 0;i<9;i++) {
			hand.addCard(0, compDeck.deal());
		}
		
		//for storing inputed numbers
		String[] inputArray;
		//if input has numbers, for correct error message
		boolean hasNums = false;
		//if user exited game 
		boolean exitedGame = false;
		//scanner
		Scanner scan = new Scanner(System.in);
		//while loop for main game
		while (canPlay()) {
			//prints the hand
			printHand();
			System.out.print("enter two or three numbers separated by space or type s to stop playing: ");
			//trims whitespace from input and puts into inputArray, separated by spaces
			inputArray = scan.nextLine().trim().split("\\s+");
			//if the input is s or S then end game
			if (inputArray[0].equalsIgnoreCase("s")) {
				exitedGame = true;
				break;
			}
			//int arrayList for storing the input numbers
			ArrayList<Integer> nums = new ArrayList<Integer>();
			//uses isNumber to check if each input is number, if so then add to nums arrayList
			//else tell user to input a number
			for (String str: inputArray) {
				if (isNumber(str)) {
					int possibleIndex = Integer.parseInt(str);
					nums.add(possibleIndex);
					hasNums = true;
				}  else {
					System.out.println("\ntype a number please");
					break;
				}
			}
			//if input has a number and is valid input then remove card from hand and replace with card from compDeck
			//if compDeck is empty then print out message 
			if (hasNums && isValidInput(nums)) {
				for (int i = 0;i<nums.size();i++) {
					hand.remove(nums.get(i));
					if (!compDeck.isEmpty()) {
						hand.addCard(nums.get(i),compDeck.deal());
					} else {
						System.out.println("you win");
						break;
					}
				}
			} else {
				System.out.println("\nchoose a valid index");
			}
			//print empty line for clarity/spacing
			System.out.println();
		//end while loop
			
		}
		//if game was exited print hand
		if (!exitedGame) {
			printHand();
		}
		//close scanner
		scan.close();
		System.out.println("\ngame over");
	//end method
	}
	/**determines whether the numbers provided in the input were valid
	 * @return boolean It returns true or false to determine if the input is valid*/
	public boolean isValidInput(ArrayList<Integer> nums) {
		//if any numbers were not between 0 and 8 then return false
		for (int i = 0;i<nums.size();i++) {
			if (nums.get(i)>8 || nums.get(i)<0) {
				return false;
			}
		}
		//if two nums given and the chosen cards from hand add up to 11 return true
		if (nums.size()==2) {
			if (hand.get(nums.get(0)).pointValue() + hand.get(nums.get(1)).pointValue() ==11) {
				return true;
			} 
		} else 
			//if three nums given
		if (nums.size()==3) {
			//if all three nums are J Q or K 
			if (hand.get(nums.get(0)).pointValue()==0 && hand.get(nums.get(1)).pointValue()==0 && hand.get(nums.get(2)).pointValue()==0) {
				//if all three nums are different
				if (!hand.get(nums.get(0)).rank().equals(hand.get(nums.get(1)).rank()) && !hand.get(nums.get(0)).rank().equals(hand.get(nums.get(2)).rank()))
					return true;
				
			}
		}
		//returns false in all other cases
		return false;
	}
	/**prints out the hand with numbers above them representing indexes*/
	public void printHand() {
		System.out.println(" 0     1     2     3     4     5     6     7     8");
		System.out.println(hand);
	}
	/**determines if the user can still play
	 * @return boolean determines if you can still continue the game or if you lose
	 */
	public boolean canPlay() {
		//for each card determines if there is another card in hand that can equal to 11 when added together
		for (int i = 0;i<hand.size()-1;i++) {
			for (int j = 1; j<hand.size();j++) {
				if (hand.get(i).pointValue()+hand.get(j).pointValue()==11) {
					return true;
				}
			}
		}
		//for each card in hand that is J Q or K 
		//adds to temp the first time a J Q or K is seen, so no duplicates
		//if hand has all three then returns true
		String temp = "";
		for (int i = 0;i<hand.size();i++) {
			if (hand.get(i).pointValue()==0 && !temp.contains(hand.get(i).rank())) {
				temp+=hand.get(i).rank();
			}
		}
		if (temp.length()==3) {
			return true;
		}
		return false;
	}
	/**determines if a string is a number or not
	 * @param str It takes in a string to convert to a number
	 * @return boolean It returns true or false to determine if the input can be taken if it is a String representing a number
	 */
	public static boolean isNumber(String str) {
		//if string is null return false
	    if (str == null) {
	        return false;
	    }
	    // else try to convert the string into a number
	    try {
	        int num = Integer.parseInt(str);
	     //if an error is thrown then return false, because not number
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    // else return true, is number
	    return true;
	}
}
