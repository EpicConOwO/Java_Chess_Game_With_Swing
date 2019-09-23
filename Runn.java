import javax.swing.*;
import java.awt.*;
public class Runn
{
	//Private initializations
	public JFrame MaineWindow_Frame = new JFrame("ChessGame");
	JPanel MaineWindow_Pannel;

	Runn(String Col,int SizeX,int SizeY)
	{
		System.out.println(Col+" Selected");
		MaineWindow_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		PrintTiles PT = new PrintTiles(8,Col,MaineWindow_Frame,SizeX,SizeY);
		MaineWindow_Pannel = new JPanel();
		MaineWindow_Pannel = PT.Pannnn();
		MaineWindow_Frame.setLayout(new BorderLayout());
		MaineWindow_Frame.setSize(SizeX,SizeY);
		MaineWindow_Pannel.setSize(new Dimension(SizeX,SizeY));
		MaineWindow_Frame.add(PT.Turn,BorderLayout.SOUTH);
		MaineWindow_Frame.add(PT.Toolbarr,BorderLayout.NORTH);


		MaineWindow_Frame.add(MaineWindow_Pannel);
		MaineWindow_Frame.setResizable(false);
		MaineWindow_Frame.setLocationRelativeTo(null);

		MaineWindow_Frame.setVisible(true);

	}
	public void CloseFrame()
	{
		System.out.println("lmaoplmaoamlaomlmaomla");
	}
	Runn()
	{
		Menu MM = new Menu();
	}
	public static void main(String[] Par)
	{
			SwingUtilities.invokeLater(
			new Runnable()
			{
				public void run()
				{
						new Runn();
				}

			}
		);
	}

}
