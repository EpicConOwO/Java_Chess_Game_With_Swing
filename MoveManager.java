public class MoveManager extends PeaceManager
{
	String SelectedPeace ;
	public String StoreMoves[][] = new String[8][8];
	int StoreMoves_pos=-1;
	String PeaceColor;
	public MoveManager(String Peace,String Debug)
	{
	 	SelectedPeace = Peace;
		PeaceColor=getColorr(SelectedPeace);
		System.out.println("Called From "+Debug);
	}


	public void StoreFuturePosition(int x0,int y0,int x1,int y1,String C_Peace,String PlayerOneColor)
	{
		String TempInit = ""+x0+y0;
		String TempFin = ""+x1+y1;

		System.out.println("-------DEBUG----------X0 pos "+x0);
		System.out.println("-------DEBUG----------y0 pos "+y0);
		System.out.println("-------DEBUG----------x1 pos "+x1);
		System.out.println("-------DEBUG----------y1 pos "+y1);
		int blocksmovedx = x0 - x1;
		int blocksmovedy = y0 - y1;
		int blockx = x0 - x1;
		int blocky = y0 - y1;
		if(PeaceColor.equals("Black")){
			for(int i=x0;i<=x1;i++)
			{
				for(int j=0;j<=y1;j++)
				{
	blocksmovedx = i-x1;
						blocksmovedy = j-y1;
						blockx = i - x1;
						blocky = j - y1;

						if(blocksmovedx <0)
						{
							blocksmovedx = blocksmovedx *-1;
						} if(blocksmovedy <0)
						{
							blocksmovedy = blocksmovedy *-1;
						}
						System.out.println("blocksmovedx "+blocksmovedx);
						System.out.println("blocksmovedx "+blocksmovedy);
						if(CanMove(blocksmovedx,blocksmovedy,false,PlayerOneColor,blockx,blocky,x1) == true)
						{	String tempVar = ""+i+j;

							if((Integer.parseInt(tempVar) >= Integer.parseInt(TempInit))&&(Integer.parseInt(tempVar) <= Integer.parseInt(TempFin)))
							{
								StoreMoves[i][j]=tempVar;
								System.out.println("___________________Store pos "+tempVar);
								StoreMoves_pos++;
							}
						}

				}
			}
		}else
		{
			for(int i=7;i>=0;i--)
			{
				for(int j=7;j>=0;j--)
				{
					blocksmovedx = i - x1;
					blocksmovedy = j - y1;
					blockx = i - x1;
					blocky = j - y1;
					String tempVar = ""+i+j;
					if(blocksmovedx <0)
					{
						blocksmovedx = blocksmovedx *-1;
					} if(blocksmovedy <0)
					{
						blocksmovedy = blocksmovedy *-1;
					}
					if(CanMove(blocksmovedx,blocksmovedy,false,PlayerOneColor,blockx,blocky,x1) == true)
					{
						if((Integer.parseInt(tempVar) <= Integer.parseInt(TempInit))&&(Integer.parseInt(tempVar) >= Integer.parseInt(TempFin))){
							StoreMoves[i][j]=tempVar;
							System.out.println("___________________Store pos "+tempVar);
							StoreMoves_pos++;
						}
					}
				}
			}
		}
		StoreMoves_pos = -1;
	}

	public boolean isValidMove(String TargetPece)
	{
		String TarColor = getColorr(TargetPece);

		if(PeaceColor.equals(TarColor) == false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean Calculate_futureMove(int x,int y)
	{
		System.out.println("/////////////////////////// "+x+y);
		int Moves_alllowed_Pawn=2;
		boolean R_S=false;

		int blocksmovedx = x - Moves_alllowed_Pawn;
		int blocksmovedy = 0;
		int blockx = x - Moves_alllowed_Pawn;
		int blocky = 0;
		if(blocksmovedx <0)
		{
			blocksmovedx = blocksmovedx *-1;
		} if(blocksmovedy <0)
		{
			blocksmovedy = blocksmovedy *-1;
		}

		if(SelectedPeace.equals(W_King) || SelectedPeace.equals(B_King)) // king
		{

		}
		else if(SelectedPeace.equals(W_Queen) || SelectedPeace.equals(B_Queen)) // queen
		{

		}
		else if(SelectedPeace.equals(W_Rook) || SelectedPeace.equals(B_Rook)) //rook
		{

		}
		else if(SelectedPeace.equals(W_Bishop) || SelectedPeace.equals(B_Bishop))//bishop
		{

		}
		else if(SelectedPeace.equals(W_Knight) || SelectedPeace.equals(B_Knight))//knight
		{

		}
		else if(SelectedPeace.equals(W_Pawn) || SelectedPeace.equals(B_Pawn))//pawn
		{
				if((CanMove(blocksmovedx,blocksmovedy,false,"White",blockx,blocky, x))==true)
				{
					R_S = true;
				}

		}else
		{
			System.out.println("No peacve");
		}
		return R_S;
	}

	public boolean CanMove(int x,int y,boolean TakePeace,String P_Col,int inx,int iny,int finxX)
	{
		 int MovesAllowedX;
		 int MovesAllowedY;
		 Boolean R_BOO=true;
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
				if(TakePeace == true )
				{
						MovesAllowedY =1;

				}else
				{
					MovesAllowedY =0;
				}
				int W_Border;
				int B_Border;
				boolean tempbo = false;
				if(P_Col.equals("White"))
				{
					W_Border = 4;
					B_Border = 3;
				}else
				{
					W_Border = 3;
					B_Border = 4;
				}

					if((finxX == W_Border && getColorr(SelectedPeace).equals("White"))|| (finxX ==B_Border && getColorr(SelectedPeace).equals("Black"))){
						MovesAllowedX = 2;
					}else
					{
						MovesAllowedX =1;
					}

				if(P_Col.equals("White"))
				{
					if(inx > 0 && getColorr(SelectedPeace).equals("White"))
					{
						tempbo = true;
					}else if(inx < 0 && getColorr(SelectedPeace).equals("Black"))
					{
						tempbo = true;
					}

				}else if(P_Col.equals("Black"))
				{
					if(inx > 0 && getColorr(SelectedPeace).equals("Black"))
					{
						tempbo = true;
					}else if(inx < 0 && getColorr(SelectedPeace).equals("White"))
					{
						tempbo = true;
					}
				}
					if(((x <= MovesAllowedX ) && (y== MovesAllowedY ) ) && tempbo == true )
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
