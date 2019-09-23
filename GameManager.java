import java.awt.*;
import javax.swing.*;
public class GameManager
{
	public String OpponentKing;
	public String PlayerKing;
	public String PlayerColor;
	public String CurrentTurnMove;

	PeaceManager PCM = new PeaceManager();

	public GameManager()
	{
	}
	public void GobacktoMainMenu(JFrame CurrentFrame)
	{

		 CurrentFrame.dispose();
		 new Menu();
	}
	public void InitialtizeGame(String P_King,String O_King,String P_color,String Colofturn)
	{
		PlayerKing=P_King;
		OpponentKing = O_King;
		PlayerColor=P_color;
		CurrentTurnMove= Colofturn;

	}

	public void NewGame(String Col,int sizex,int sizey,JFrame MaineGameFrame)
	{
		MaineGameFrame.dispose();
		new Runn(Col,sizex,sizey);
	}

	public boolean TurnManager(String SelectedPeace)
	{
		if((PCM.getColorr(SelectedPeace).equals(CurrentTurnMove)  ))
		{

			if(PCM.getColorr(SelectedPeace).equals("White"))
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

	public void Quit()
	{
		System.out.println("Exiting GAME");
		System.exit(0);
	}


	public void store_moves(int x,int y)
	{
		int tempstoreMovees[];

	}
	public boolean Collision(int x0,int y0,int x1,int y1,String Peace )
	{
		boolean collision=false;

		return collision;
	}

	public boolean Vissualize(int x0,int y0,int x1,int y1,String Peace )
	{
		boolean col=true;

		return col;
	}



}


final class Consolee
{
	private Consolee()
	{

	}

	public static void log(String Msg)
	{
		System.out.println(""+Msg);
	}
}
