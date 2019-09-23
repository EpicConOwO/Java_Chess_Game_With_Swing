import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu
{
	JFrame MaineMenu_Frame;
	JLabel Label_ChoseColor,ScrSize,ShowSize,Label_GameName;
	JButton JB1,JB2,JB3;
	JPanel MaineMenu_Pannel,MainMenu_OptionPannel;
	JRadioButton Black_JR,White_JR;
	JComboBox ScreenSizeX,ScreenSizeY;
	int ResalutionX;
	int ResalutionY;
	String[] _ScreenSizeListX = new String[]{"800","1024","1080","1280","1920"};
	String[] _ScreenSizeListY = new String[]{"720","720","800","1080"};
	String Col;
	static GameManager GManger = new GameManager();

//menu constructor
	Menu()
	{

		ScreenSizeX = new JComboBox(_ScreenSizeListX);
		ScreenSizeY = new JComboBox(_ScreenSizeListY);
		MaineMenu_Frame = new JFrame("Main Menu");
		MaineMenu_Pannel = new JPanel(new GridLayout(0,1,0,0));

		Label_ChoseColor = new JLabel("Chose Color ",SwingConstants.LEFT);
		ScrSize = new JLabel("Chose ScreenSize ",SwingConstants.LEFT);
		Label_GameName = new JLabel("<html> <div style='font-size:1.9em; color:black; '	><u>[\u2654 <em >Chess</em> \u265A]</u></div> </html>",SwingConstants.CENTER);
		ShowSize = new JLabel("",SwingConstants.CENTER);
		Black_JR = new JRadioButton("<html><b style='font-size:15px;'>Black \u265A</b> </html> ",false);
		White_JR = new JRadioButton("<html><b style='font-size:15px;'>White \u2654</b> </html> ",true);


		MainMenu_OptionPannel = new JPanel(new GridLayout(2,3));

		MaineMenu_Frame.setSize(620,720);
		MaineMenu_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		ButtonGroup BG = new ButtonGroup();
		updateLabel();

		BG.add(Black_JR);
		BG.add(White_JR);
		MaineMenu_Frame.setResizable(false);
		JB1 = new JButton("Start Game");
		JB3 = new JButton("");
		JB2 = new JButton("Quit");

		JB3.setEnabled(false);
		JB3.setBorderPainted(false);
		MaineMenu_Frame.setLocationRelativeTo(null);

		MaineMenu_Pannel.add(Label_GameName);
		SetLabel(JB3,MaineMenu_Pannel,true);

		MaineMenu_Pannel.add(MainMenu_OptionPannel);
		SetLabel(Label_ChoseColor,MainMenu_OptionPannel,true);
		MainMenu_OptionPannel.add(Black_JR);
		MainMenu_OptionPannel.add(White_JR);


		SetLabel(ScrSize,MainMenu_OptionPannel,true);
		SetLabel(ScreenSizeX,MainMenu_OptionPannel,true);
		SetLabel(ScreenSizeY,MainMenu_OptionPannel,true);

		SetLabel(ShowSize,MaineMenu_Pannel,true);

		setupbuttons(JB1);
		setupbuttons(JB2);

		SetLabel(JB1,MaineMenu_Pannel,true);

		SetLabel(JB2,MaineMenu_Pannel,true);



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


				}else if(White_JR.isSelected()==true)
				{
					 Col = "White";

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
public void setupbuttons(Component MenuElements)
{
	MenuElements.setForeground(Color.BLACK);
	MenuElements.setFocusable(false);
}
public void SetLabel(Component lb,JPanel pan,boolean panadd)
{
		int fontstize =25;
		int FontFormat=1;
		if(panadd == true){

		if(lb == Label_GameName){
			fontstize=75;
			FontFormat =3;
		 }

		 pan.add(lb);
	 }
 	lb.setFont(new Font("Times New Roman",FontFormat,fontstize));
}


	// game over menu
		JFrame GM_MENU;
		JLabel	GM_Label;
		JButton GM_BUTT_NewGame,GM_BUTT_QuitGame,GM_BUTT_MainMenu;
		JFrame MaineGameFrame;





	 public Menu(boolean GameOver,JFrame MaineFrameWindow,int x,int y,String Col)
	{
		if(GameOver == true)
		{
			MaineGameFrame = MaineFrameWindow;
			System.out.println("==================GameOver==================");

		GM_MENU = new JFrame("Game Over");
		GM_MENU.setLayout(new GridLayout(0,1));

		GM_Label = new JLabel("<html> <b style='font-size:20px;'><em>Game Over</em></b> </html>",SwingConstants.CENTER);
		GM_BUTT_NewGame =new JButton("Play Again");
		GM_BUTT_MainMenu =new JButton("Main Menu");
		GM_BUTT_QuitGame=  new JButton("Quit Game");
		GM_MENU.setSize(480,360);
		GM_MENU.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GM_MENU.setLocationRelativeTo(MaineGameFrame);

		GM_MENU.add(GM_Label);
		GM_MENU.add(GM_BUTT_NewGame);
		GM_MENU.add(GM_BUTT_MainMenu);
		GM_MENU.add(GM_BUTT_QuitGame);
		GM_MENU.setVisible(true	);

		GM_BUTT_NewGame.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent E)
				{
					Consolee.log("Starting New GAME");
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
		}

	}


	public void updateLabel()
	{
		ResalutionX = Integer.parseInt(""+ScreenSizeX.getSelectedItem());
		ResalutionY = Integer.parseInt(""+ScreenSizeY.getSelectedItem());
		ShowSize.setText("Game Resolution "+ResalutionX+" x "+ResalutionY);


	}
}
