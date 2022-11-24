import java.util.Scanner;

public class TicYellow extends TicRed
{
	//constructor for yellow tictactoe player using board 
	public TicYellow(TicTacToeBoard insert, String player) 
	{
		super(insert, player);
		// TODO Auto-generated constructor stub
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
		while (row>2||col>2||getLocationInfo(row,col)!="-0-")
		{
			super.IncorrectEntry();
			super.RowEntry(t.getPlayer2());
			row = scan.nextInt();
			super.ColEntry(t.getPlayer2());
			col = scan.nextInt();	 
		} 
		t.setLocation(row, col, t.getPlayer2());
	}
}
