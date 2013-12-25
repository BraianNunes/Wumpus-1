import java.util.ArrayList;
import java.util.List;


public class WumpusPlayer {
	
	//Private fields
	private static int m_numArrow = 1; 
	private static boolean m_endOfGame = false;
	private static int m_points = 0;
	
	//Public properties
	public List<WumpusPolje> obiskanaPolja;
	
	//Konstruktor
	public WumpusPlayer(){
		obiskanaPolja = new ArrayList<WumpusPolje>();
		WumpusHelper.Print("Wumpus Player ready to play.");
	}
	
	//Public methods
	/*
	 * Implement
	 */
	public void Play(WumpusPolje[][] wumpusWorld){

	}
	
}
