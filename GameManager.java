import java.awt.*;
import javax.swing.*;
public class GameManager
{
	public GameManager()
	{
		
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
}