import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class PrintTiles 
{	
	PeaceManager PCM = new PeaceManager();
	Font font     = new Font("Ariel", Font.BOLD, 62);
	int initial_pos = 0;
	int Final_pos = 0;
	int G_Size;
	private JLabel[][] lab ;
	public JLabel Turn;
	public JLabel[] PeacesPlayer1;
	public JLabel[] PeacesPlayer2;
	private JButton[][] Butt;
	JButton ToolBarButton[];
	public JToolBar Toolbarr;
	int Lastx=-1;
	int Lasty=-1;
	String CurrentSelectedPeace = null;
	String lasttileSelected = null;
	String TileSelected;
	public String CurrentTurn = "White";
	JPanel pan;
	JFrame GM_MENU;
	JLabel GM_Label;
	JButton GM_BUTT_NewGame;
	JButton GM_BUTT_QuitGame;
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
	public int XSize;
	public int YSize;
	public boolean _GameOver =false;
	public JFrame MaineFrmeJIF;
	PrintTiles(int Size,String Cool,JFrame JIF,int SizeX,int SizeY)
	{	
		XSize=SizeX;
		YSize=SizeY;
		MaineFrmeJIF = JIF;
		PlayerOneColor = Cool;
		if(Cool.equals("White"))
		{
			OpponentKing =PCM.B_King;
		}else
		{
			OpponentKing =PCM.W_King;
		}
		
		G_Size = Size;
		lab	= new JLabel[G_Size][G_Size];
		Butt = new JButton[Size][Size];
		pan = new JPanel(new GridLayout(G_Size,G_Size));
		Toolbarr = new JToolBar("");
		ToolBarButton = new JButton[3];
		ToolBarButton[0] = new JButton("New Game"); 
		ToolBarButton[1] = new JButton("Quit Game");
		Toolbarr.add(ToolBarButton[0]);
		Toolbarr.add(ToolBarButton[1]);
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
						System.out.println("LOLOLOL");
						NewGame();
					}
				
			}
		);
		ToolBarButton[1].addActionListener(
			new ActionListener()
			{
					public void actionPerformed(ActionEvent A)
					{
						System.out.println("LOLOLOL");
						Quit();
					}
				
			}
		);

		for(int row=0;row< Size ; row++)
		{
			for(int col = 0;col< Size;col++)
			{	 
				System.out.println("Blocks Created at :" +row+col);
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
						System.out.println("Clicked on : "+tempx+tempy);
							CurrentSelectedPeace= ""+tempx+tempy;
							System.out.println("Setted CurrentSelectedPeace  to  : "+tempx+tempy+"\n");
							if(_GameOver == false)
							{
												
								if(CurrentSelectedPeace.equals(lasttileSelected) == false )//checks if current tile is pressed twice
								{
									if(lasttileSelected == null) // cheks if user has clicked on another button
									{	
										if(lab[tempx][tempy].getText().isEmpty() == false )
										{
										System.out.println(" CurrentSelectedPeace " +CurrentSelectedPeace );
										
										Lastx = tempx; 
										Lasty = tempy;
										lasttileSelected = ""+Lastx+Lasty; // makes the current tile the last tile
										System.out.println(" setted lasttileSelected to  " +lasttileSelected );
										}else
										{
										System.out.println("No Peace in Tile");
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
									System.out.println(" Clicked on same tile");
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
	
	public void NewGame()
	{
		MaineFrmeJIF.dispose();
		new Runn(PlayerOneColor,XSize,YSize);
	}
	public void Quit()
	{
		System.out.println("Exiting GAME");
					System.exit(0);
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
		System.out.println("==================GameOver============");
		for(int row=0;row<G_Size;row++)
		{
			for(int col=0;col<G_Size;col++)
			{
				Butt[row][col].setEnabled(false);
			}
		}		
		GM_MENU = new JFrame("Game Over");
		GM_MENU.setLayout(new BorderLayout());
		GM_Label = new JLabel("GameOver",SwingConstants.CENTER); 
		GM_BUTT_NewGame =new JButton("Play Again");
		GM_BUTT_QuitGame=  new JButton("Quit Game");
		GM_MENU.setSize(300,100);
		GM_MENU.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GM_MENU.setLocationRelativeTo(pan);
		GM_MENU.add(GM_Label,BorderLayout.NORTH);
		GM_MENU.add(GM_BUTT_NewGame,BorderLayout.WEST);
		GM_MENU.add(GM_BUTT_QuitGame,BorderLayout.EAST);
		GM_MENU.setVisible(true	);
		GM_BUTT_NewGame.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent E)
				{
					System.out.println("Starting New GAME");
					GM_MENU.dispose();
					NewGame();
				}
			}
		);
		GM_BUTT_QuitGame.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent E)
				{
					Quit();
				}
			}
		);
		
	}
	
	public String GetTurn()
	{
		return CurrentTurn+"'s Turn";
	}
	public JPanel Pannnn()
	{
		return pan;
	}
	public boolean colision(int Initialx,int Initialy,int FinalX,int FinalY,String Peec)
	{
		MoveManager moveman = new MoveManager(Peec,CurrentTurn,FinalX,"Collision");
		for(int i = Initialx ;i<=FinalX;i++)
		{
			for(int j=Initialy;j<=FinalY;j++)
			{
					System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ "+i+j);
				
					if(lab[i][j].getText().isEmpty() == false && (lab[i][j].equals(PCM.W_Knight) || lab[i][j].equals(PCM.B_Knight)))
					{
						if(i==Initialx && j==Initialy){
						 System.out.println("skipped "+i+j);
						}else
						{
							 System.out.println("Collided at "+i+j);
							//Butt[i][j].setBackground(Color.RED);
							return true;
						}
					}else
					{
						 System.out.println("empy tile at "+i+j);

						//Butt[i][j].setBackground(Color.GREEN);
							return false;
					}
			}
		}
		return false;
	}
	public void visualize(int Initialx,int Initialy,int FinalX,int FinalY,String Peec)
	{
				MoveManager moveman = new MoveManager(Peec,CurrentTurn,FinalX,"Visuzlize");

		for(int i = Initialx ;i<=FinalX;i++)
		{
			for(int j=Initialy;j<=FinalY;j++)
			{
					if(lab[i][j].getText().isEmpty() == true)
					{
						System.out.println("Nothing in waer "+i+j);
						Butt[i][j].setBackground(Color.GREEN);
					}else
					{
							System.out.println("Someting colided at " +i+j);
							Butt[i][j].setBackground(Color.RED);
					}
			}
		}
	}
	public void TakePeace(String TargetPece,String CurrentPeace,int InitX,int InitY,int finX,int finy)
	{
		MoveManager MovMan = new MoveManager(CurrentPeace,CurrentTurn,finX,"Take Pece");
		 
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
			if(TargetPece.equals(OpponentKing))
			{
				GameOver();
			}
			
			//AddTakenPeaceToPannel(TargetPece,"Player1");
		}else
		{
				System.out.println("Cant Kill Ur Own Team");
		}
	}
	
	public void MovePeace(String Pece,int InitX,int InitY,int finX,int finy,boolean Tem)
	{	
		String Temp = PCM.getPeace(Pece);
		MoveManager MovMan = new MoveManager(Pece,CurrentTurn,finX,"MovePeace");
		int blocksmovedx = InitX - finX;
		int blocksmovedy = InitY - finy;
		if(MovMan.CanMove(blocksmovedx,blocksmovedy,Tem) == true)
		{
			//visualize( InitX, InitY, finX, finy, Pece);//rewritethis
			if((MovMan.TurnManager() == true  )  )
			{
				if(colision(InitX,InitY,finX,finy,Pece)==false){
				System.out.println("Moved "+Pece+" From "+InitX+InitY+" to " +finX+finy);
				
				lab[InitX][InitY].setText("");
				lab[finX][finy].setText(Temp);
				CurrentTurn= MovMan.CurrentTurnMove;
				}else
				{
					System.out.println("Coliison has occured");
				}
			}else
			{
				System.out.println("Not ur Turn  its : " + CurrentTurn+ "'s Turn");
			}
		}else
		{
			System.out.println("Invalid Movement");
		}
				Turn.setText(GetTurn());

	}
	public void setChessPeace(int x, int y,String Pece)
	{
		
		String Temp = PCM.getPeace(Pece);
		lab[x][y] = new JLabel(Temp,SwingConstants.CENTER);
		lab[x][y].setFont(font);
		System.out.println(" " +Pece+" Spawned at : " +x+y);
		Butt[x][y].add(lab[x][y]);
	}
}