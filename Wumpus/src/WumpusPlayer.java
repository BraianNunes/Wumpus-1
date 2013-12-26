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
		WumpusPolje tmpPolje = wumpusWorld[0][0];
		
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
//		tmpPolje.m_x += 1;
//		tmpPolje.m_y += 0;
		
		WumpusHelper.Print(WumpusSteps.PremikNaPolje(tmpPolje.m_x, tmpPolje.m_y));
		
//		if(tmpPolje.m_zlato == true){
//			WumpusHelper.Print(WumpusSteps.naselZlato);
//		} else if(tmpPolje.m_vetrovno == true){
//			WumpusHelper.Print(WumpusSteps.zaznalVetric);
//		} else if(tmpPolje.m_smrad){
//			WumpusHelper.Print(WumpusSteps.zaznalSmrad);
//		} else if(tmpPolje.m_brezno){
//			WumpusHelper.Print(WumpusSteps.konecBrezno);
//		} else if(tmpPolje.m_wumpus){
//			WumpusHelper.Print(WumpusSteps.konecWumpus);
//		} else if(tmpPolje.m_izhod_){
//			WumpusHelper.Print(WumpusSteps.konecZmaga);
//		}
	}
	
	/*
	 * Action: go down
	 */
	public void GoDown(WumpusPolje tmpPolje, WumpusPolje[][] wumpusWorld) {
		
		
//		if(tmpPolje.m_zlato == true){
//		WumpusHelper.Print(WumpusSteps.naselZlato);
//	} else if(tmpPolje.m_vetrovno == true){
//		WumpusHelper.Print(WumpusSteps.zaznalVetric);
//	} else if(tmpPolje.m_smrad){
//		WumpusHelper.Print(WumpusSteps.zaznalSmrad);
//	} else if(tmpPolje.m_brezno){
//		WumpusHelper.Print(WumpusSteps.konecBrezno);
//	} else if(tmpPolje.m_wumpus){
//		WumpusHelper.Print(WumpusSteps.konecWumpus);
//	} else if(tmpPolje.m_izhod_){
//		WumpusHelper.Print(WumpusSteps.konecZmaga);
//	}
	}
	
	/*
	 * Action: go back
	 */
	public void GoBack(WumpusPolje tmpPolje, WumpusPolje[][] wumpusWorld) {
//		tmpPolje.m_oce = wumpusWorld[i][j];
	}
	
}
