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
	
}