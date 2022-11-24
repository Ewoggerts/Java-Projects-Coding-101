

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackTable {
	/** creates instance variable in order to keep track of the amount of games (important once split command gets run)*/
	private static int gameNum = 0;
	/** creates an instance arraylist called games*/
	private ArrayList<BlackjackGame> games;
	/**runs the actual blackjackGame*/
	public BlackjackTable() {
		//new arrayList of to hold the games in order
		games = new ArrayList<BlackjackGame>();
		System.out.print("welcome to blackjack. goal is to get 21. press enter to play, when prompted type hit to hit, etc");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		while (!input.equalsIgnoreCase("s")) {
			int handNum = 0;
			if (input.equals("")) {
				gameNum++;
				handNum++;
				System.out.println("-----------------\ngame "+gameNum+"\n\nhand "+handNum);
				//make new blackjack game
				games.add(new BlackjackGame());
				// if the game was split
				if (games.get(0).splitGame()) {	
					handNum++;
					//add new game with the two cards from the first game
					System.out.println("\nhand "+handNum);
					games.add(new BlackjackGame(games.get(0).getDealerHand(),games.get(0).getSplitCard()));
					games.remove(1);
				}
				games.remove(0);
				//remove game when done
				System.out.println("\npress enter to play again or s to stop");
			} else {
				System.out.println("\nplease try again");
			}
			input = scan.nextLine();
		}
		System.out.println("thanks for playing");
		
		scan.close();
	}
	public static void main(String[] args) {
		new BlackjackTable();
	}
}
