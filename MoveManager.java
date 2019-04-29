public class MoveManager extends PeaceManager
{
	String SelectedPeace ;
	String CurrentTurnMove;
	int finxX;
	public MoveManager(String Peace,String Colofturn,int xX,String Debug)
	{	
		finxX = xX;
		CurrentTurnMove= Colofturn;
	 	SelectedPeace = Peace;
		tempcam(SelectedPeace);
		System.out.println("Called From "+Debug);
	}
	public void tempcam(String Peace)
	{
		switch(Peace)
		{
			//white
			case W_King:
			{
				SelectedPeace = Peace;
				break;
			}
			case W_Queen:
			{
				SelectedPeace = Peace;
				break;
			}
			case W_Rook:
			{
				SelectedPeace = Peace;
				break;
			}
			case W_Bishop:
			{
				SelectedPeace = Peace;
				break;
			}
			case W_Knight:
			{
				SelectedPeace = Peace;

				break;
			}
			case W_Pawn:
			{
				SelectedPeace = Peace;

				break;
			}
			//black
			case B_King:
			{
				SelectedPeace = Peace;

				break;
			}
			case B_Queen:
			{
				SelectedPeace = Peace;

				break;
			}
			case B_Rook:
			{
				SelectedPeace = Peace;

				break;
			}
			case B_Bishop:
			{
				SelectedPeace = Peace;
				break;
			}
			case B_Knight:
			{
				SelectedPeace = Peace;
				break;
			}
			case B_Pawn:
			{
				SelectedPeace = Peace;
				break;
			}
			default:
			{
				
			}
		}
	}
	
	public boolean TurnManager()
	{
		if((getColorr(SelectedPeace).equals(CurrentTurnMove)  ))
		{
			
			if(getColorr(SelectedPeace).equals("White"))
			{
				CurrentTurnMove = "Black";
			}else
			{
				CurrentTurnMove = "White";
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isValidMove(String TargetPece)
	{
		String TarColor = getColorr(TargetPece);
		String CurColor = getColorr(SelectedPeace);
		
		if(CurColor.equals(TarColor) == false){
		return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean CanMove(int x,int y,boolean TakePeace,String P_Col)
	{
		 int MovesAllowedX;
		 int MovesAllowedY;
		 Boolean R_BOO=true;
		 System.out.println("X: "+x);
		 System.out.println("Y: "+y);
		if(SelectedPeace.equals(W_King) || SelectedPeace.equals(B_King)) // king
		{
				MovesAllowedX = 1;
				MovesAllowedY = 1;
				if((x <= MovesAllowedX && x >= -MovesAllowedX) && (y <= MovesAllowedY && y >= -MovesAllowedY))
				{
					R_BOO= true;
				}else
				{
					R_BOO= false;
				}
		}
		else if(SelectedPeace.equals(W_Queen) || SelectedPeace.equals(B_Queen)) // queen
		{
				MovesAllowedX = 8;
				MovesAllowedY = 8;
				if((x == y ) ||((x <= MovesAllowedX ) && y==0 || (y<=MovesAllowedY ) && x==0 ))
				{
					R_BOO= true;
				}else
				{
					R_BOO= false;
				}
		}
		else if(SelectedPeace.equals(W_Rook) || SelectedPeace.equals(B_Rook)) //rook
		{
				MovesAllowedX = 8;
				MovesAllowedY = 8;
				if((x <= MovesAllowedX && y == 0) || (y <= MovesAllowedY && x == 0))
				{
					R_BOO= true;
				}else
				{
					R_BOO= false;
				}
		}
		else if(SelectedPeace.equals(W_Bishop) || SelectedPeace.equals(B_Bishop))//bishop
		{
				MovesAllowedX = 8;
				MovesAllowedY = 8;
				if(x==y  )
				{
					R_BOO= true;
				}else
				{
					R_BOO= false;
				}
		}
		else if(SelectedPeace.equals(W_Knight) || SelectedPeace.equals(B_Knight))//knight
		{
				MovesAllowedX = 2;
				MovesAllowedY = 1;
				if((x==MovesAllowedX||x==MovesAllowedY)&&(y ==MovesAllowedY||y==MovesAllowedX ))
				{
					if(x != y){
					R_BOO= true;
					}else
					{
						R_BOO=false;
					}
				}else
				{
					R_BOO= false;
				}
		}
		else if(SelectedPeace.equals(W_Pawn) || SelectedPeace.equals(B_Pawn))//pawn
		{
				String PawnColor = getColorr(SelectedPeace);
				if(TakePeace == true )
				{
						MovesAllowedY =1;
					
				}else
				{
					MovesAllowedY =0;
				}
				int W_Border;
				int B_Border;
				if(P_Col.equals("White"))
				{
					W_Border = 4;
					B_Border = 3;
				}else
				{
					W_Border = 3;
					B_Border = 4;
				}
				
				
					if((finxX >= W_Border && getColorr(SelectedPeace).equals("White"))|| (finxX <=B_Border && getColorr(SelectedPeace).equals("Black"))){
						MovesAllowedX = 2;
					}else
					{
						MovesAllowedX =1;
					}
					
					if((x <= MovesAllowedX ) && (y== MovesAllowedY )   )
					{
						R_BOO= true;
					}else
					{
						R_BOO= false;
					}
				
		}else
		{
			System.out.println("No peacve");
		}
		return R_BOO;
	}
}
