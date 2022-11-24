
public class TicTacToeBoard extends Board
{
	//it constructs a TicTacToeBoard with a requirement to enter your own values. Other methods from the Board super class is useful in this sub class thats why most of the stuff isn't needed in this class.
	public TicTacToeBoard() 
	{
		A=new String [3][3];
	}
	//It checks Red win condition for tictactoe. Overrides original method.
	public boolean winnerRed() 
	{
		if ((LocationInfo(0,0)!=("-0-") && LocationInfo(0,0) == LocationInfo(1,1) && LocationInfo(0,0)==LocationInfo(2,2))
				|| (LocationInfo(0,2)!=("-0-") && LocationInfo(0,2) == LocationInfo(1,1) && LocationInfo(0,2)==LocationInfo(2,0)))
		{
			if(LocationInfo(0,0)=="red")
			{
				return true;
			}
		}
		else
		{
			for(int i=0;i<numRows();i++)
			{
				if(LocationInfo(i, 0)!=("-0-") && LocationInfo(i, 0)==LocationInfo(i, 1)
						&& LocationInfo(i, 0)==LocationInfo(i, 2)) 
				{
					if(LocationInfo(i,0)=="red")
					{
						return true;
					}
				}
			}
			for (int i = 0;i<numHeight();i++) 
			{
				if (LocationInfo(0,i)!=("-0-") && LocationInfo(0,i)==LocationInfo(1,i)
						&& LocationInfo(0,i)==LocationInfo(2,i)) 
				{
					if (LocationInfo(0, i)=="red") 
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	//It checks Yellow win condition for tictactoe. Overrides original method.
	public boolean winnerYellow() 
	  {
		  //checks second player
		  if ((LocationInfo(0,0)!=("-0-") && LocationInfo(0,0) == LocationInfo(1,1) && LocationInfo(0,0)==LocationInfo(2,2))
				  || (LocationInfo(0,2)!=("-0-") && LocationInfo(0,2) == LocationInfo(1,1) && LocationInfo(0,2)==LocationInfo(2,0)))
		  {
			  if(LocationInfo(0,0)=="yellow")
			  {
				  return true;
			  }
		  }
		  else
		  {
			  for(int i=0;i<numRows();i++)
			  {
				  if(LocationInfo(i, 0)!=("-0-") && LocationInfo(i, 0)==LocationInfo(i, 1)
						  && LocationInfo(i, 0)==LocationInfo(i, 2)) 
				  {
					  if(LocationInfo(i,0)=="yellow")
					  {
						  return true;
					  }
				  }
			  }
			  for (int i = 0;i<numHeight();i++) 
			  {
				  if (LocationInfo(0,i)!=("-0-") && LocationInfo(0,i)==LocationInfo(1,i)
						  && LocationInfo(0,i)==LocationInfo(2,i)) 
				  {
					  if (LocationInfo(0, i)=="yellow") 
					  {
						  return true;
					  }
				  }
			  }
		  }
		  return false;
	  }
}
