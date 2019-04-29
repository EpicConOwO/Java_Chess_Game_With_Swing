import java.awt.*;
import javax.swing.*;
public class GameManager
{
	public String OpponentKing;
	public String PlayerKing;
	public String PlayerColor;
	public GameManager()
	{
		
	}
	public void InitialtizeGame(String P_King,String O_King,String P_color)
	{
		PlayerKing=P_King;
		OpponentKing = O_King;
		PlayerColor=P_color;
	}
	
	public void NewGame(String Col,int sizex,int sizey,JFrame MaineGameFrame)
	{
		MaineGameFrame.dispose();
		new Runn(Col,sizex,sizey);
	}
	public void Quit()
	{
		System.out.println("Exiting GAME");
		System.exit(0);
	}
	public void LogConsole(String log)
	{
		System.out.println(log);
	}
}
