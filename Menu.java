import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu
{
	JFrame MaineMenu_Frame;
	JLabel MaineMenu_Label,ScrSize,ShowSize;
	JButton JB1,JB2,JB3;
	JPanel MaineMenu_Pannel;
	JRadioButton Black_JR,White_JR;
	JComboBox ScreenSizeX,ScreenSizeY;
	int ResalutionX;
	int ResalutionY;
	String[] _ScreenSizeListX = new String[]{"800","1024","1080","1280","1920"};
	String[] _ScreenSizeListY = new String[]{"670","720","800","1080"};
	String Col="White";
	GameManager GManger = new GameManager();
	Menu()
	{
		
		ScreenSizeX = new JComboBox(_ScreenSizeListX);
		ScreenSizeY = new JComboBox(_ScreenSizeListY);
		MaineMenu_Frame = new JFrame("Main Menu");
		MaineMenu_Label = new JLabel("Chose Color",SwingConstants.CENTER);
		ScrSize = new JLabel("Chose ScreenSize:",SwingConstants.CENTER);
		ShowSize = new JLabel("",SwingConstants.CENTER);
		MaineMenu_Frame.setSize(400,200);
		MaineMenu_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		MaineMenu_Pannel = new JPanel(new GridLayout(3,3));
		Black_JR = new JRadioButton("Black \u2654",false); 
		White_JR = new JRadioButton("White  \u265A",true); 
		ButtonGroup BG = new ButtonGroup();
		updateLabel();
		
		BG.add(Black_JR);
		BG.add(White_JR);
		MaineMenu_Frame.setResizable(false);
		JB1 = new JButton("Start Game");
		JB3 = new JButton();
		JB2 = new JButton("Quit");
		
		JB3.setEnabled(false);
		MaineMenu_Frame.setLocationRelativeTo(null);
		
		MaineMenu_Pannel.add(MaineMenu_Label);
		MaineMenu_Pannel.add(Black_JR);
		MaineMenu_Pannel.add(White_JR);
		MaineMenu_Pannel.add(ScrSize);
		MaineMenu_Pannel.add(ScreenSizeX);
		MaineMenu_Pannel.add(ScreenSizeY);

		MaineMenu_Pannel.add(JB1);
		MaineMenu_Pannel.add(ShowSize);

		MaineMenu_Pannel.add(JB2);
		MaineMenu_Frame.add(MaineMenu_Pannel);
		MaineMenu_Frame.setVisible(true);
		
		ScreenSizeX.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent a)
				{
					System.out.println("Scren X Size :"+ScreenSizeX.getSelectedItem());
					updateLabel();
				}
			}
		);
		ScreenSizeY.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent a)
				{
					System.out.println("Scren Y Size :"+ScreenSizeY.getSelectedItem());
					
					updateLabel();
				}
			}
		);

		JB1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent E)
			{   
				updateLabel();

				if(Black_JR.isSelected()==true){
					 Col = "Black";
					System.out.println("String Game");
					
				}else if(White_JR.isSelected()==true)
				{
					 Col = "White";

				}else
				{
					System.out.println("This shouldnt happen :/");
				}
				new Runn(Col,ResalutionX,ResalutionY);
				MaineMenu_Frame.dispose();
				}
		});
		JB2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent E)
			{
				System.exit(0);
			}
		});
		
	}
		JFrame GM_MENU;
		JLabel	GM_Label;
		JButton GM_BUTT_NewGame,GM_BUTT_QuitGame;
		JFrame MaineGameFrame;
		
	 public Menu(boolean GameOver,JFrame MaineFrameWindow,int x,int y)
	{
		if(GameOver == true)
		{
			MaineGameFrame = MaineFrameWindow;
			System.out.println("==================GameOver============");
		
		GM_MENU = new JFrame("Game Over");
		GM_MENU.setLayout(new BorderLayout());
		GM_Label = new JLabel("GameOver",SwingConstants.CENTER); 
		GM_BUTT_NewGame =new JButton("Play Again");
		GM_BUTT_QuitGame=  new JButton("Quit Game");
		GM_MENU.setSize(300,100);
		GM_MENU.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GM_MENU.setLocationRelativeTo(MaineGameFrame);
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
					GManger.NewGame(Col,x,y,MaineFrameWindow);
				}
			}
		);
		GM_BUTT_QuitGame.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent E)
				{
					GManger.Quit();
				}
			}
		);
		}else
		{
			System.out.println("wtf :/ ");
		}
		
	}
	
	
	public void updateLabel()
	{
		ResalutionX = Integer.parseInt(""+ScreenSizeX.getSelectedItem());
		ResalutionY = Integer.parseInt(""+ScreenSizeY.getSelectedItem());
		ShowSize.setText("Screen Size:"+ResalutionX+"x"+ResalutionY);

	}
}
