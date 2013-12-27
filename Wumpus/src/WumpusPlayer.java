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
	 * Play 
	 */
	public void Play(WumpusPolje[][] wumpusWorld){
		
		//Set first action
		int action = WumpusActions.right;
		WumpusPolje tmpPolje = GetStartPositionOfPlayer(wumpusWorld);
		
		while(!this.m_endOfGame){
			
			switch(action){
				case WumpusActions.right:
					this.GoRight(tmpPolje, wumpusWorld);
					break;
				
				case WumpusActions.down:
					this.GoDown(tmpPolje, wumpusWorld);
					break;
					
				case WumpusActions.back:
					this.GoBack(tmpPolje, wumpusWorld);
					break;
			}
		}
		
	}

	/*
	 * Action: go right
	 */
	public void GoRight(WumpusPolje tmpPolje, WumpusPolje[][] wumpusWorld) {
		
	}
	
	/*
	 * Action: go down
	 */
	public void GoDown(WumpusPolje tmpPolje, WumpusPolje[][] wumpusWorld) {
		
	}
	
	/*
	 * Action: go back
	 */
	public void GoBack(WumpusPolje tmpPolje, WumpusPolje[][] wumpusWorld) {
		
	}
	
	/*
	 * Return start position of player
	 */
	private WumpusPolje GetStartPositionOfPlayer(WumpusPolje[][] wumpusWorld) {
		
		WumpusPolje start = null;
		
		for(int row = 0; row < wumpusWorld.length; row++){
			for(int col = 0; col < wumpusWorld[0].length; col++){
				if(wumpusWorld[row][col].m_start){
					start = wumpusWorld[row][col];
					break;
				}
			}
		}
		
		return start;
	}
	
}
