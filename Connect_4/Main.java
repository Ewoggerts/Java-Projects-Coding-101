import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{ 
		//Creation of the tic tac toe board to run the game
		TicTacToeBoard TicTacToeGame = new TicTacToeBoard();
		TicTacToeGame.clearBoard();
		String startTicGame="";
		//Creates players for tic tac toe 
		TicRed player1 = new TicRed(TicTacToeGame,"Red");
		//Inheritance hierarchy shown here
		TicRed player2 = new TicYellow(TicTacToeGame,"Yellow");
		//Determines if you start tic tac toe game or skip to connect 4.
		Scanner scan = new Scanner (System.in);
		System.out.println("Print yes to start tic tac toe! Say no to skip to Connect4!");
		startTicGame = scan.nextLine();
		
		while(!startTicGame.equals("yes")&&!startTicGame.equals("no"))
		{
			System.out.println("Enter valid response");
			startTicGame = scan.nextLine();
		}
		//This is just the easy solution to skip game. It fills out the win condition for tic tac toe which end tic tac toe to start connect4.
		if(startTicGame.equals("no"))
		{
			TicTacToeGame.setLocation(0,0,"red");
			TicTacToeGame.setLocation(0,1,"red");
			TicTacToeGame.setLocation(0,2,"red");
		}
		//Instructions to play the tic tac toe.
		System.out.println("These are the simple rules of tic tac toe:");
		System.out.println("The first person is player 1 and will play X");
		System.out.println("The second person is player 2 and will play Y");
		System.out.println("The goal of the game is to be the first person to get 3 X's or Y's in a row.");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println(TicTacToeGame);
		//This run the tic tac toe game with the alloted logic created to make the game.
		while(TicTacToeGame.winnerRed()==false&&TicTacToeGame.winnerYellow()==false)
		{
			player1.makeMove();
			System.out.println(TicTacToeGame);
			if(TicTacToeGame.winnerRed())
			{
				System.out.println("Tic Red Won");
				break;
			}
			else if (TicTacToeGame.winnerYellow())
			{
				System.out.println("Tic Yellow Won");
				break;
			}
			player2.makeMove();
			System.out.println(TicTacToeGame);
			if(TicTacToeGame.winnerRed())
			{
				System.out.println("Tic Red Won");
				break;
			}
			else if (TicTacToeGame.winnerYellow())
			{
				System.out.println("Tic Yellow Won");
				break;
			}
		}
		//Creates the board for connect4.
		Board ConnectBoard = new Board();
		ConnectBoard.clearBoard();
		String startCGame="";
		//Creates players for connect4.
		Red connect1 = new Red(ConnectBoard,"Red");
		Yellow connect2 = new Yellow(ConnectBoard,"Yellow");
		//Same yes or no to skip game.
		Scanner newscan = new Scanner (System.in);
		System.out.println("Say no to stop playing Connect4 otherwise say yes!");
		startCGame = scan.nextLine();
		while(!startCGame.equals("yes")&&!startCGame.equals("no"))
		{
			System.out.println("Enter valid response");
			startCGame = scan.nextLine();
		}
		//Same cheeky method to skip the game.
		if(startCGame.equals("no"))
		{
			ConnectBoard.setLocation(5,0,"red");
			ConnectBoard.setLocation(5,1,"red");
			ConnectBoard.setLocation(5,2,"red");
			ConnectBoard.setLocation(5,3,"red");
		}
		//Instructions to play the game
		System.out.println("These are the simple rules of Connect 4:");
		System.out.println("The first person is player 1 and will play red");
		System.out.println("The second person is player 2 and will play yellow");
		System.out.println("The goal of the game is to be the first person to get 4 red marks in a row");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println(ConnectBoard);
		//This run the connect4 game with the alloted logic created to make the game.
		while(ConnectBoard.winnerRed()==false&&ConnectBoard.winnerYellow()==false)
		{
			connect1.makeMove();
			System.out.println(ConnectBoard);
			if(ConnectBoard.winnerRed())
			{
				System.out.println("Tic Red Won");
				break;
			}
			else if (ConnectBoard.winnerYellow())
			{
				System.out.println("Tic Yellow Won");
				break;
			}
			connect2.makeMove();
			System.out.println(ConnectBoard);
			if(ConnectBoard.winnerRed())
			{
				System.out.println("Tic Red Won");
				break;
			}
			else if (ConnectBoard.winnerYellow())
			{
				System.out.println("Tic Yellow Won");
				break;
			}
		}
	}//end
}
		


