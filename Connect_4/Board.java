
public class Board 
{
	//Creates a 2d array which will be the basis of the board
	String [][] A;
	String player2="yellow";
	String player1="red";
	//no param construction for connect 4 board
	public Board() 
	{
		A=new String [6][7];
	}
	public Board(int row, int col)
	{
		A=new String [row][col];
	}
	//method set the board to a easily identified empty slot
	public void clearBoard()
	{
		for(int row=0;row<A.length;row++)
		{
			for(int col=0;col<A[0].length;col++)
			{
				A[row][col]="-0-";
			}
		}
	}
	//method pulls information from specific information
	public String LocationInfo(int insertrow, int insertcol)
	{
		return (A[insertrow][insertcol]);
	}
	//method set information into specific location either red or yellow
	public void setLocation(int insertrow, int insertcol, String insert)
	{
		A[insertrow][insertcol]=insert;
	}
	//method calculate and returns the number of rows
	public int numRows()
	{
		return A.length;
	}
	//method calculates and returns the number of columns
	public int numHeight()
	{
		return A[0].length;
	}
	//it is a win condition for the connect 4 for yellow
	public boolean winnerYellow()
	{
		for(int r=A.length-1;r>0;r--)
		{
			for(int c=0;c<4;c++)
			{
				if (A[r][c].equals(A[r][c+1])
						&&A[r][c].equals(A[r][c+2])
						&&A[r][c].equals(A[r][c+3])
						&&!(A[r][c].equals("-0-"))
						&&(A[r][c].equals("yellow")))
				{
					return true;
				}

			}
		}
		
		for(int c=0;c<A[0].length;c++)
		{
			for(int r=A.length-1;r>=3;r--)
			{

				if (A[r][c].equals(A[r-1][c])
						&&A[r][c].equals(A[r-2][c])
						&&A[r][c].equals(A[r-3][c])
						&&!(A[r][c].equals("-0-"))
						&&(A[r][c].equals("yellow")))
				{
					return true;
				}

			}
		}
		
		for(int r=A.length-1;r>=3;r--)
		{
			for(int c=0;c<=3;c++)
			{
				
				if (A[r][c].equals(A[r-1][c+1])
						&&A[r][c].equals(A[r-2][c+2])
						&&A[r][c].equals(A[r-3][c+3])
						&&!(A[r][c].equals("-0-"))
						&&(A[r][c].equals("yellow")))
				{
					System.out.println("true");return true;
				}

			}
		}
		
		for(int r=A.length-1;r>=3;r--)
		{
			for(int c=A[0].length-1;c>=3;c--)
			{

				if (A[r][c].equals(A[r-1][c-1])
						&&A[r][c].equals(A[r-2][c-2])
						&&A[r][c].equals(A[r-3][c-3])
						&&!(A[r][c].equals("-0-"))
						&&(A[r][c].equals("yellow")))
				{
					System.out.println("true");return true;
				}
				
			}
		}return false;
	}
	//it is a win condition for the connect 4 for red
	public boolean winnerRed()
	{
		for(int r=A.length-1;r>0;r--)
		{
			for(int c=0;c<4;c++)
			{
				if (A[r][c].equals(A[r][c+1])
						&&A[r][c].equals(A[r][c+2])
						&&A[r][c].equals(A[r][c+3])
						&&!(A[r][c].equals("-0-"))
						&&(A[r][c].equals("red")))
				{
					return true;
				}

			}
		}
		
		for(int c=0;c<A[0].length;c++)
		{
			for(int r=A.length-1;r>=3;r--)
			{

				if (A[r][c].equals(A[r-1][c])
						&&A[r][c].equals(A[r-2][c])
						&&A[r][c].equals(A[r-3][c])
						&&!(A[r][c].equals("-0-"))
						&&(A[r][c].equals("red")))
				{
					return true;
				}

			}
		}
		
		for(int r=A.length-1;r>=3;r--)
		{
			for(int c=0;c<=3;c++)
			{
				
				if (A[r][c].equals(A[r-1][c+1])
						&&A[r][c].equals(A[r-2][c+2])
						&&A[r][c].equals(A[r-3][c+3])
						&&!(A[r][c].equals("-0-"))
						&&(A[r][c].equals("red")))
				{
					return true;
				}

			}
		}
		
		for(int r=A.length-1;r>=3;r--)
		{
			for(int c=A[0].length-1;c>=3;c--)
			{

				if (A[r][c].equals(A[r-1][c-1])
						&&A[r][c].equals(A[r-2][c-2])
						&&A[r][c].equals(A[r-3][c-3])
						&&!(A[r][c].equals("-0-"))
						&&(A[r][c].equals("red")))
				{
					return true;
				}
				
			}
		}return false;
	}
	// it pulls the player with the color
	public String getPlayer1()
	{
		return player1;
	}
	// it pulls the player with the color
	public String getPlayer2()
	{
		return player2;
	}
	// returns the entire array
	public String toString()
	{
		String returnArray="";
		for(int row=0;row<A.length;row++)
		{
			for(int col=0;col<A[0].length;col++)
			{
				returnArray+=A[row][col];
			}returnArray+="\n";
		}return returnArray;

	}
	
	//tester
	//public static void main(String[] args)
	//{
		//Board Connect4 = new Board();
		//Connect4.clearBoard();
		//System.out.println(Connect4);
		//Connect4.setLocation(5, 0, "yellow");
		//Connect4.setLocation(4, 1, "yellow");
		//Connect4.setLocation(3, 2, "yellow");
		//Connect4.setLocation(2, 3, "yellow");
		//System.out.println(Connect4);
		//Connect4.winnerYellow();
	//}
}
