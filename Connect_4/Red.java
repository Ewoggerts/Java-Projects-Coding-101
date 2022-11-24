import java.util.Scanner;
public class Red extends Player
{
	//constructor for red connect 4 player using board 
	public Red(Board insert,String player)
	{
		super(insert,player);
	}
	//Makes move for red connect 4 player with logic in place to prevent errors and proper game mechanics.
	public void makeMove()
	{
		int row;
		int col;
		Scanner scan=new Scanner (System.in);
		super.RowInstruct(t.getPlayer1());
		row = scan.nextInt();
		super.ColInstruct(t.getPlayer1());
		col=scan.nextInt();
		while ((row>5||col>7||getLocationInfo(row,col)!="-0-")||(row!=5&&getLocationInfo(row+1,col)=="-0-"))
		{
				super.IncorrectEntry();
				super.RowEntry(t.getPlayer1());
				row = scan.nextInt();
				super.ColEntry(t.getPlayer1());
				col = scan.nextInt();	 
		} 
		t.setLocation(row, col, t.getPlayer1());
	}
	//Checks if the Win variable is triggered to true.
	public void checkWin()
	{
		Win=t.winnerRed();
	}
	//Returns win variable whether it is true for false.
	public boolean getWin()
	{
		return Win;
	}
	

}
