import java.util.Scanner;
public class Yellow extends Red
{
	//constructor for yellow connect 4 player using board 
	public Yellow(Board insert,String player)
	{
		super(insert,player);
	}
	//Makes move for yellow connect 4 player with logic in place to prevent errors and proper game mechanics.
	public void makeMove()
	{
		int row;
		int col;
		Scanner scan=new Scanner (System.in);
		super.RowInstruct(t.getPlayer2());
		row = scan.nextInt();
		super.ColInstruct(t.getPlayer2());
		col=scan.nextInt();
		while ((row>5||col>7||getLocationInfo(row,col)!="-0-")||(row!=5&&getLocationInfo(row+1,col)=="-0-"))
		{
			super.IncorrectEntry();
			super.RowEntry(t.getPlayer2());
			row = scan.nextInt();
			super.ColEntry(t.getPlayer2());
			col = scan.nextInt();	 
		} 
		t.setLocation(row, col, t.getPlayer2());
	}
	//Checks if the Win variable is triggered to true.
	public void checkWin()
	{
		Win=t.winnerYellow();
	}
	
}