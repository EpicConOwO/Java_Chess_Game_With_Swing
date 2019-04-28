public class PeaceManager
{
		// white
	public static final String W_King   = "\u2654";
	public static final String W_Queen  = "\u2655";
	public static final String W_Rook   = "\u2656";
	public static final String W_Bishop = "\u2657";
	public static final String W_Knight = "\u2658";
	public static final String W_Pawn   = "\u2659";
		//black
	public static final String B_King   = "\u265A";
	public static final String B_Queen  = "\u265B";
	public static final String B_Rook   = "\u265C";
	public static final String B_Bishop = "\u265D";
	public static final String B_Knight = "\u265E";
	public static final String B_Pawn   = "\u265F";
	
	public String getPeace(String Peace)
	{
		String Temppeace="";
		String B_Col = "Black";
		String W_Col = "White";
		switch(Peace)
		{	//white
			case W_King:
			{
				Temppeace=King(W_Col);
				break;
			}
			case W_Queen:
			{
				Temppeace=Queen(W_Col);
				break;
			}
			case W_Rook:
			{
				Temppeace=Rook(W_Col);
				break;
			}
			case W_Bishop:
			{
				Temppeace=Bishop(W_Col);
				break;
			}
			case W_Knight:
			{
				Temppeace=Knight(W_Col);
				break;
			}
			case W_Pawn:
			{
				Temppeace=Pawn(W_Col);
				break;
			}
			//black
			case B_King:
			{
				Temppeace=King(B_Col);
				break;
			}
			case B_Queen:
			{
				Temppeace=Queen(B_Col);
				break;
			}
			case B_Rook:
			{
				Temppeace=Rook(B_Col);
				break;
			}
			case B_Bishop:
			{
				Temppeace=Bishop(B_Col);
				break;
			}
			case B_Knight:
			{
				Temppeace=Knight(B_Col);
				break;
			}
			case B_Pawn:
			{
				Temppeace=Pawn(B_Col);
				break;
			}
			default:
			{
				Temppeace = Emptytile();
			}
		}
		return Temppeace;
	}
	
	public String getColorr(String Peacee)
	{
		String Colorr="";
		
			if(Peacee.equals(W_King) ||Peacee.equals(W_Queen) ||Peacee.equals(W_Rook) ||Peacee.equals(W_Bishop) ||Peacee.equals(W_Knight) ||Peacee.equals(W_Pawn) )
			{
				Colorr = "White";
			}else
			{
				Colorr = "Black";
			}
		
		return Colorr;
	}
	// peace declarartion
	public String Emptytile()
	{
		return "";
	}
	public String King(String color)
	{	
		String King;
		
		if(color == "Black")
		{
			King=B_King;
		
		}else {
			King=W_King;
			
		}
		return King;
	}
	
	public String Queen(String color)
	{	
		String Queen;
		
		if(color == "Black")
		{
			Queen= B_Queen;
		}else
		{
			Queen= W_Queen;
		}
		return Queen;
	}
	
	public String Rook(String color)
	{	
		String Rook;
	
		if(color =="Black")
		{
			Rook = B_Rook;
		}else
		{
			Rook = W_Rook;
		}
		return Rook;
	}
	
	public String Bishop(String color)
	{	
		String Bishop;
		
		if(color == "Black"){
			Bishop = B_Bishop;
		}else
		{
			Bishop = W_Bishop;

		}
		return Bishop;
	}
	
	public String Knight(String color)
	{	
		String Knight;
	

		if(color == "Black"){
			Knight = B_Knight;
		}else
		{
			Knight=W_Knight;
		}
		return Knight;
	}
	
	public String Pawn(String color)
	{
		String Pawn;
		
		if(color == "Black")
		{
			Pawn = B_Pawn;
		}else
		{
			Pawn = W_Pawn;

		}
		return Pawn;
	}
}