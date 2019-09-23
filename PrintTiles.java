import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrintTiles
{
	PeaceManager PCM = new PeaceManager();
	Font font     = new Font("Ariel", Font.BOLD, 62);
	int G_Size;
	private JLabel[][] lab ;
	public JLabel Turn;
	public JLabel[] PeacesPlayer1,PeacesPlayer2;
	private JButton[][] Butt;
	JButton ToolBarButton[];

	public JToolBar Toolbarr;
	int Lastx=-1;
	int Lasty=-1;
	String CurrentSelectedPeace = null;
	String lasttileSelected = null;
	public String CurrentTurn = "White";
	JPanel pan;
	GameManager GManager = new GameManager();

	String PlayerOneColor;
		int black_peace ;
		int B_Pawn ;
		int B_King ;
		int B_Queen ;
		int BL_Rook ;
		int BR_Rook ;
		int BL_Bishop ;
		int BR_Bishop ;
		int BL_Knght ;
		int BR_Knght ;
		//white  initialization
		int white_peace ;
		int W_pawn  ;
		int W_King  ;
		int W_Queen ;
		int WL_Rook  ;
		int WR_Rook  ;
		int WL_Bishop  ;
		int WR_Bishop  ;
		int WL_Knight  ;
		int WR_Knight  ;
	int Player1TakenPeace = 1;
	int Player2TakenPeace = 1;
	String OpponentKing;
	String PlayerKing;
	public int XSize;
	public int YSize;
	public boolean _GameOver =false;
	public JFrame MaineFrmeJIF;
	int[][] StorPos = new int[8][8];



	PrintTiles(int Size,String Cool,JFrame JIF,int SizeX,int SizeY)
	{

		XSize=SizeX;
		YSize=SizeY;
		MaineFrmeJIF = JIF;
		PlayerOneColor = Cool;
		GManager.InitialtizeGame(PlayerKing,OpponentKing,PlayerOneColor,CurrentTurn);
		if(Cool.equals("White"))
		{
			OpponentKing =PCM.B_King;
			PlayerKing =PCM.W_King;
		}else
		{
			OpponentKing =PCM.W_King;
			PlayerKing =PCM.B_King;
		}

		G_Size = Size;
		lab	= new JLabel[G_Size][G_Size];
		Butt = new JButton[Size][Size];
		pan = new JPanel(new GridLayout(G_Size,G_Size));
		Toolbarr = new JToolBar("");
		ToolBarButton = new JButton[3];
		ToolBarButton[0] = new JButton("Main Menu");
		ToolBarButton[1] = new JButton("New Game");
		ToolBarButton[2] = new JButton("Quit Game");
		Toolbarr.add(ToolBarButton[0]);
		Toolbarr.add(ToolBarButton[1]);
		Toolbarr.add(ToolBarButton[2]);
		Toolbarr.setFloatable(false);

		Turn = new JLabel(GetTurn(),SwingConstants.CENTER);
		PeacesPlayer1 = new JLabel[16];
		PeacesPlayer2 = new JLabel[16];
		PeacesPlayer1[Player1TakenPeace] = new JLabel("Player 1",SwingConstants.LEFT);
		PeacesPlayer2[Player1TakenPeace] = new JLabel("Player 2",SwingConstants.RIGHT);

		for(int i =1 ; i<16;i++){
		PeacesPlayer1[i] = new JLabel(" ",SwingConstants.LEFT);
		PeacesPlayer2[i] = new JLabel(" ",SwingConstants.RIGHT);
		}

		pan.setSize(800,760);
		pan.setBackground(Color.BLACK);
		if(PlayerOneColor.equals("White")){
		//Black peace initialization
		 black_peace = 0;
		 B_Pawn = 1;
		 B_King = 3;
		 B_Queen = 4;
		 BL_Rook = 0;
		 BR_Rook = 7;
		 BL_Bishop=2;
		 BR_Bishop=5;
		 BL_Knght=1;
		 BR_Knght=6;
		//white peace initialization
		 white_peace = 7;
		 W_pawn = 6;
		 W_King = 4;
		 W_Queen= 3;
		 WL_Rook = 0;
		 WR_Rook = 7;
		 WL_Bishop = 2;
		 WR_Bishop = 5;
		 WL_Knight = 1;
		 WR_Knight = 6;
		}else
		{
		 black_peace = 7;
		 B_Pawn = 6;
	     B_King = 4;
		 B_Queen = 3;
		 BL_Rook = 0;
		 BR_Rook = 7;
		 BL_Bishop=2;
		 BR_Bishop=5;
		 BL_Knght=1;
		 BR_Knght=6;
		//white_peace peace initialization
		 white_peace = 0;
		 W_pawn = 1;
		 W_King = 3;
		 W_Queen= 4;
		 WL_Rook = 0;
		 WR_Rook = 7;
		 WL_Bishop = 2;
		 WR_Bishop = 5;
		 WL_Knight = 1;
		 WR_Knight = 6;
		}
		ToolBarButton[0].addActionListener(
			new ActionListener()
			{
					public void actionPerformed(ActionEvent A)
					{
						GManager.GobacktoMainMenu(MaineFrmeJIF);

					}

			}
		);
		ToolBarButton[1].addActionListener(
			new ActionListener()
			{
					public void actionPerformed(ActionEvent A)
					{
						GManager.NewGame(PlayerOneColor,XSize,YSize,MaineFrmeJIF);

					}

			}
		);
		ToolBarButton[2].addActionListener(
			new ActionListener()
			{
					public void actionPerformed(ActionEvent A)
					{
						GManager.Quit();
					}

			}
		);

		for(int row=0;row< Size ; row++)
		{
			for(int col = 0;col< Size;col++)
			{
				Consolee.log("Blocks Created at :" +row+col);
				lab[row][col] = new JLabel("",SwingConstants.CENTER);
				Butt[row][col] = new JButton("");
				setChessPeace(row,col,"");
				Butt[row][col].setBackground(Color.WHITE);
				if((row%2==0)==(col%2==0))
				{
					Butt[row][col].setBackground(Color.WHITE);
				}else
				{
					Butt[row][col].setBackground(Color.GRAY);
				}
				pan.add(Butt[row][col]);
				if(row==black_peace)
				{
					if(col==B_King)
					{
						setChessPeace(row,col,PCM.B_King);

					}if(col==B_Queen)
					{
						setChessPeace(row,col,PCM.B_Queen);

					}if((col==BL_Rook) || (col==BR_Rook))
					{
						setChessPeace(row,col,PCM.B_Rook);
					}
					if((col==BL_Bishop) || (col==BR_Bishop))
					{
						setChessPeace(row,col,PCM.B_Bishop);
					}
					if((col==BL_Knght) || (col==BR_Knght))
					{
						setChessPeace(row,col,PCM.B_Knight);
					}
				}else if(row==B_Pawn)
				{
					setChessPeace(row,col,PCM.B_Pawn);
				}if(row==white_peace)
				{
					if(col==B_King)
					{
						setChessPeace(row,col,PCM.W_King);
					}
					if(col==B_Queen)
					{
						setChessPeace(row,col,PCM.W_Queen);
					}
					if((col==BL_Rook) || (col==BR_Rook))
					{
						setChessPeace(row,col,PCM.W_Rook);
					}
					if((col==BL_Bishop) || (col==BR_Bishop))
					{
						setChessPeace(row,col,PCM.W_Bishop);
					}
					if((col==BL_Knght) || (col==BR_Knght))
					{
						setChessPeace(row,col,PCM.W_Knight);
					}

				}else if(row==W_pawn)
				{
					setChessPeace(row,col,PCM.W_Pawn);
				}

				Butt[row][col].setOpaque(true);
				final int tempx = row;
				final int tempy = col;
				Butt[row][col].addActionListener (new ActionListener(){

					public void actionPerformed (ActionEvent AE)
					{
						final Color PrevCol = Butt[tempx][tempy].getBackground();
						Consolee.log("Clicked on : "+tempx+tempy);
							CurrentSelectedPeace= ""+tempx+tempy;
							Consolee.log("Setted CurrentSelectedPeace  to  : "+tempx+tempy+"\n");
							if(_GameOver == false)
							{

								if(CurrentSelectedPeace.equals(lasttileSelected) == false )//checks if current tile is pressed twice
								{
									if(lasttileSelected == null) // cheks if user has clicked on another button
									{
										if(lab[tempx][tempy].getText().isEmpty() == false ) // if selected button dont has a empty label
										{
											Consolee.log(" CurrentSelectedPeace " +CurrentSelectedPeace );

											Lastx = tempx;
											Lasty = tempy;
											lasttileSelected = ""+Lastx+Lasty; // makes the current tile the last tile
											Consolee.log(" setted lasttileSelected to  " +lasttileSelected );
											//PredictFutpos(tempx,tempy,lab[tempx][tempy].getText());
										}else
										{
											Consolee.log("No Peace in Tile");
										}
									}else
									{

											if(lab[tempx][tempy].getText() != "")
											{
												TakePeace(lab[tempx][tempy].getText(),lab[Lastx][Lasty].getText(), Lastx,Lasty,tempx, tempy);
											}else
											{

													MovePeace(lab[Lastx][Lasty].getText(), Lastx,Lasty,tempx, tempy,false);

											}
											lasttileSelected = null;
											CurrentSelectedPeace= null;

									}
								}else
								{
									Consolee.log(" Clicked on same tile");
								}
							}else
							{
								GameOver();
							}
					}
				});
			}
		}
	}

	public boolean Collision(int x0,int y0,int x1,int y1,String Pece,MoveManager MoveMan)
	{
		String TempInit = ""+x0+y0;
		String TempFin= ""+x1+y1;
		boolean collisionn = false;
		int inistartpoint=0;
		int iniendpoint=7;
		MoveManager Moveman = new MoveManager(Pece,"From Collision");
		MoveMan.StoreFuturePosition( x0, y0, x1, y1,Pece , PlayerOneColor);
		if(PCM.getColorr(Pece).equals("Black")){
			for(int i=inistartpoint;i <= iniendpoint ;i++)
			{
				for(int j= inistartpoint;j<=iniendpoint ;j++)
				{
					String tempVar = ""+i+j;
					if((Integer.parseInt(tempVar) >= Integer.parseInt(TempInit))&&(Integer.parseInt(tempVar) <= Integer.parseInt(TempFin)))
					{
						if(tempVar.equals(MoveMan.StoreMoves[i][j]))
						{

								if(tempVar.equals(TempInit)==false)
								{
									if((lab[i][j].getText()!=""))
									{
										System.out.println("=================There Maybe A peace at "+i+j);
										collisionn= true;
									}
								}

						}
					}
				}
			}
		}else
		{
			for(int i=iniendpoint;i >= inistartpoint ;i--)
			{
				for(int j= iniendpoint;j>=inistartpoint ;j--)
				{
					String tempVar = ""+i+j;
					if((Integer.parseInt(tempVar) <= Integer.parseInt(TempInit))&&(Integer.parseInt(tempVar) >= Integer.parseInt(TempFin)))
					{
						if(tempVar.equals(Moveman.StoreMoves[i][j]))
						{
								if(tempVar.equals(TempInit)==false)
								{
									if((lab[i][j].getText()!=""))
									{
										System.out.println("=================There Maybe A peace at "+i+j);
										collisionn= true;
									}
								}
						}
					}
				}
			}
		}
		return collisionn;
	}

	public void PredictFutpos(int Inx,int Iny,String C_Peace)
	{
		MoveManager Moveman = new MoveManager(C_Peace,"Calculate pos");
		for(int i=Inx;i<8;i++)
		{
			for(int j=Iny;j<8;j++){					//doesnt work as expected for some reason will rewrite this in future
				Inx=Inx+1;
				Inx=Iny+1;
				if((Moveman.Calculate_futureMove(Inx,Iny)) == true)
				{
					System.out.println("======Avaiable Moves "+Inx+Iny);
				}
			}
		}
	}

	public int Get_TakenPeaces(String Player)
	{
		if(Player == "Player1")
		{
			return Player1TakenPeace;
		}else
		{
			return Player2TakenPeace;
		}

	}
	public void AddTakenPeaceToPannel(String TakenPeace,String Player)
	{
		if(Player.equals("Player1"))
		{
			PeacesPlayer1[Player1TakenPeace].setText(TakenPeace);
			Player1TakenPeace++;
		}else
		{
			PeacesPlayer1[Player2TakenPeace].setText(TakenPeace);
			Player2TakenPeace++;


		}
	}
	public void GameOver()
	{
		_GameOver = true;
		for(int row=0;row<G_Size;row++)
		{
			for(int col=0;col<G_Size;col++)
			{
				Butt[row][col].setEnabled(false);
			}
		}
		Menu gm = new Menu(_GameOver,MaineFrmeJIF,XSize,YSize,PlayerOneColor);
	}

	public String GetTurn()
	{
		return CurrentTurn+"'s Turn";
	}
	public JPanel Pannnn()
	{
		return pan;
	}

	public void visualize(int Initialx,int Initialy,int FinalX,int FinalY,String Peec)
	{
		for(int i = Initialx ;i<=FinalX;i++)
		{
			for(int j=Initialy;j<=FinalY;j++)
			{
				//System.out.println(""+StorPos[i][j]);
				if((i == Initialx && j == Initialy) == false){
					if((lab[i][j].getText().isEmpty() == true) )
					{
						System.out.println("Nothing in waer "+i+j); // needs to implent it with the function PredictFutpos
						Butt[i][j].setBackground(Color.GREEN);

					}else
					{
							System.out.println("Someting colided at " +i+j);
							Butt[i][j].setBackground(Color.RED);
					}
				}else
				{
					System.out.println("WTFFFFFFFF " +i+j+Initialx+Initialy);
				}
			}
		}
	}




	public void TakePeace(String TargetPece,String CurrentPeace,int InitX,int InitY,int finX,int finy)
	{
		MoveManager MovMan = new MoveManager(CurrentPeace,"Take Pece");

		if(MovMan.isValidMove( TargetPece) == true) // checks if peace is targetting other team or it self
		{
			if((CurrentPeace.equals(PCM.W_Pawn) == true )|| (CurrentPeace.equals(PCM.B_Pawn) == true))
			{
				MovePeace(CurrentPeace, InitX,InitY,finX, finy,true);
			}
			else
			{

				MovePeace(CurrentPeace, InitX,InitY,finX, finy,false);

			}
			if(TargetPece.equals(OpponentKing) || TargetPece.equals(PlayerKing))
			{
				int blocksmovedx = InitX - finX;
				int blocksmovedy = InitY - finy;
				int blockx = InitX - finX;
				int blocky = InitY - finy;
				if(blocksmovedx <0)
				{
					Consolee.log("Minus value at blocksmovedx ");
					blocksmovedx = blocksmovedx *-1;
				} if(blocksmovedy <0)
				{
					Consolee.log("Minus value at blocksmovedy");
					blocksmovedy = blocksmovedy *-1;
				}
				if(MovMan.CanMove(blocksmovedx,blocksmovedy,true,PlayerOneColor,blockx,blocky,finX) == true)
				{
					GameOver();
				}
			}

			//AddTakenPeaceToPannel(TargetPece,"Player1");
		}else
		{
				Consolee.log("Cant Kill Ur Own Team");
		}
	}

	public void MovePeace(String Pece,int InitX,int InitY,int finX,int finy,boolean Tem)
	{
		MoveManager MovMan = new MoveManager(Pece,"MovePeace");
		int blocksmovedx = InitX - finX;
		int blocksmovedy = InitY - finy;
		int blockx = InitX - finX;
		int blocky = InitY - finy;
		if(blocksmovedx <0)
		{
			Consolee.log("Minus value at blocksmovedx ");
			blocksmovedx = blocksmovedx *-1;
		} if(blocksmovedy <0)
		{
			Consolee.log("Minus value at blocksmovedy");
			blocksmovedy = blocksmovedy *-1;
		}
		if(MovMan.CanMove(blocksmovedx,blocksmovedy,Tem,PlayerOneColor,blockx,blocky,finX) == true)
		{	MovMan.StoreFuturePosition(InitX, InitY, finX, finy,Pece , PlayerOneColor);

			if(Collision(InitX,InitY,finX,finy,Pece,MovMan)==false)
			{
				//visualize( InitX, InitY, finX, finy, Pece);//rewritethis
				if((GManager.TurnManager(Pece) == true )  )
				{


						Consolee.log("Moved "+Pece+" From "+InitX+InitY+" to " +finX+finy);

						lab[InitX][InitY].setText("");
						lab[finX][finy].setText(Pece);
						CurrentTurn= GManager.CurrentTurnMove;
				}else
				{
					Consolee.log("Not ur Turn  its : " + CurrentTurn+ "'s Turn");
				}
			}
		}else
		{
			Consolee.log("Invalid Movement");
		}
				Turn.setText(GetTurn());

	}
	public void setChessPeace(int x, int y,String Pece)
	{

		lab[x][y] = new JLabel(Pece,SwingConstants.CENTER);
		lab[x][y].setFont(font);
		Consolee.log(" " +Pece+" Spawned at : " +x+y);
		Butt[x][y].add(lab[x][y]);
	}
}
