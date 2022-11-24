
public class Player 
{
	public Board t;
	boolean Win= false;
	int WinCond=0;
	String player;
	//Constructor for player. It requires the insertion of a Board
	public Player(Board insert,String player)
	{
		t=insert;
		this.player=player;
	}
	//Similar constructor but required for tic tac toe board. I don't think i used this. It seems to work with only board.
	public Player(TicTacToeBoard insert,String player)
	{
		t=insert;
		this.player=player;
	}
	//gets the location ported over, but probably not needed or used in the code.
	public String getLocationInfo(int rowint, int colint)
	{
		return t.LocationInfo(rowint,colint);
	}
	//Print string stating incorrect entry.
	public void IncorrectEntry()
	{
		System.out.println("Invalid entry! try again");
		
	}
	//Prints instructions for entering your specified row
	public void RowInstruct(String color)
	{
		System.out.println("Player "+color+" please enter the row"+
				" you want to place your marker.");
	}
	//Prints instructions for entering your specified col
	public void ColInstruct(String color)
	{
		System.out.println("Player "+color+" please enter the col"+
					" you want to place your marker.");
	}
	//Clarification for row
	public void RowEntry(String player)
	{
		System.out.println("Enter the row you want to place your "+ player+". "
						 + "The rows are in order to 0,1,2. For connect 4 you start at the largest values to the smallest.");
	}
	//Clarification for col
	public void ColEntry(String player)
	{
		System.out.println("Enter the column you want to place your "+ player+". "
				 + "The rows are in order to 0,1,2. For connect 4 you start at the largest values to the smallest.");
	}
	
}
