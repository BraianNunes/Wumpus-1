import java.util.ArrayList;
import java.util.List;


public class WumpusPlayer {
	
	//Private fields
	private static int m_numArrow = 1; 
	private static boolean m_endOfGame = false;
	private static int m_points = 0;
	
	//Set first action
	int action = WumpusActions.down;
	
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
		if(wumpusWorld[tmpPolje.m_x][tmpPolje.m_y] != null){
			tmpPolje.m_x += 0;
			tmpPolje.m_y += 1;
		}
		
		WumpusHelper.Print(WumpusSteps.PremikNaPolje(tmpPolje.m_x, tmpPolje.m_y));
		
		if(tmpPolje.m_vetrovno == true){
			WumpusHelper.Print(WumpusSteps.zaznalVetric);
			action = WumpusActions.back;
			m_points += WumpusRating.action;
		} else if(tmpPolje.m_smrad){
			WumpusHelper.Print(WumpusSteps.zaznalSmrad);
			action = WumpusActions.back;
			m_points += WumpusRating.action;
		} else if(tmpPolje.m_zlato == true){
			WumpusHelper.Print(WumpusSteps.naselZlato);
			m_points += WumpusRating.findGold;
		} else if(tmpPolje.m_brezno){
			WumpusHelper.Print(WumpusSteps.konecBrezno);
			m_points += WumpusRating.fallingIntoAPit;
			m_endOfGame = true;
		} else if(tmpPolje.m_wumpus){
			WumpusHelper.Print(WumpusSteps.konecWumpus);
			m_points += WumpusRating.eatenByWumpus;
			m_endOfGame = true;
		} 
//		else if(tmpPolje.m_izhod_){
//			WumpusHelper.Print(WumpusSteps.konecZmaga);
//			m_points += WumpusRating.climbOutOfCave;
//			m_endOfGame = true;
//		}
	}
	
	/*
	 * Action: go down
	 */
	public void GoDown(WumpusPolje tmpPolje, WumpusPolje[][] wumpusWorld) {
		if(wumpusWorld[tmpPolje.m_x][tmpPolje.m_y] != null){
			tmpPolje.m_x += 1;
			tmpPolje.m_y += 0;
		}

		WumpusHelper.Print(WumpusSteps.PremikNaPolje(tmpPolje.m_x, tmpPolje.m_y));
		
		if(tmpPolje.m_vetrovno == true){
			WumpusHelper.Print(WumpusSteps.zaznalVetric);
			action = WumpusActions.back;
			m_points += WumpusRating.action;
		} else if(tmpPolje.m_smrad){
			WumpusHelper.Print(WumpusSteps.zaznalSmrad);
			action = WumpusActions.back;
			m_points += WumpusRating.action;
		} else if(tmpPolje.m_zlato == true){
			WumpusHelper.Print(WumpusSteps.naselZlato);
			m_points += WumpusRating.findGold;
		} else if(tmpPolje.m_brezno){
			WumpusHelper.Print(WumpusSteps.konecBrezno);
			m_points += WumpusRating.fallingIntoAPit;
			m_endOfGame = true;
		} else if(tmpPolje.m_wumpus){
			WumpusHelper.Print(WumpusSteps.konecWumpus);
			m_points += WumpusRating.eatenByWumpus;
			m_endOfGame = true;
		} 
//		else if(tmpPolje.m_izhod_){
//			WumpusHelper.Print(WumpusSteps.konecZmaga);
//			m_points += WumpusRating.climbOutOfCave;
//			m_endOfGame = true;
//		}
	}
	
	/*
	 * Action: go back
	 */
	public void GoBack(WumpusPolje tmpPolje, WumpusPolje[][] wumpusWorld) {
		tmpPolje.m_oce = wumpusWorld[tmpPolje.m_x][tmpPolje.m_y];
		WumpusHelper.Print("sem tukaj!");
		action = WumpusActions.right;
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
