import java.util.Scanner;

public class TicRed extends Red
{
	//constructor for red tictactoe player using board 
	public TicRed(TicTacToeBoard insert,String player)
	{
		super(insert,player);
	}
	//Makes move for yellow connect 4 player with logic in place to prevent errors and proper game mechanics.
	public void makeMove()
	{
		int row;
		int col;
		Scanner scan=new Scanner (System.in);
		super.RowInstruct(t.getPlayer1());
		row = scan.nextInt();
		super.ColInstruct(t.getPlayer1());
		col=scan.nextInt();
		while (row>2||col>2||getLocationInfo(row,col)!="-0-")
		{
			super.IncorrectEntry();
			super.RowEntry(t.getPlayer1());
			row = scan.nextInt();
			super.ColEntry(t.getPlayer1());
			col = scan.nextInt();	 
		} 
		t.setLocation(row, col, t.getPlayer1());
	}
}
