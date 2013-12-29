import java.util.ArrayList;
import java.util.List;


public class WumpusPlayer {
	
	//Private fields 
	private static boolean m_endOfGame = false;
	private static int m_points = 0;
	private static int action = WumpusActions.down; //First action
	private static WumpusPolje tmpPolje = null;
	
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
		
		//Temporary WumpusPolje
		tmpPolje = GetStartPositionOfPlayer(wumpusWorld);
		tmpPolje.m_lastAction = action;
		obiskanaPolja.add(tmpPolje);
		
		while(!this.m_endOfGame){
			
			switch(action){
				case WumpusActions.right:
					this.GoRight(wumpusWorld);
					break;
				
				case WumpusActions.down:
					this.GoDown(wumpusWorld);
					break;
					
				case WumpusActions.back:
					this.GoBack(wumpusWorld);
					break;
			}
		}
		
	}

	/*
	 * Action: go right
	 */
	public void GoRight(WumpusPolje[][] wumpusWorld) {
		
		WumpusPolje oce = tmpPolje;
		tmpPolje = wumpusWorld[tmpPolje.m_x][tmpPolje.m_y + 1];
		obiskanaPolja.add(tmpPolje);
		tmpPolje.m_oce = oce;
		this.m_points += WumpusRating.action;
		WumpusHelper.Print(WumpusSteps.PremikNaPolje(tmpPolje.m_x, tmpPolje.m_y));
		
		//Varno
		if(tmpPolje.IsSafe()){
			this.action = WumpusActions.down;
			tmpPolje.m_lastAction = action;
		}
		
		//Vetric
		if(tmpPolje.m_vetrovno){
			WumpusHelper.Print(WumpusSteps.zaznalVetric);
			this.action = GetLogicAction(wumpusWorld);
			tmpPolje.m_lastAction = action;
		}
			
		//Smrad
		if(tmpPolje.m_smrad){
			WumpusHelper.Print(WumpusSteps.zaznalSmrad);
			this.action = GetLogicAction(wumpusWorld);
			tmpPolje.m_lastAction = action;
		}
		
		//Zlato
		if(tmpPolje.m_zlato && (!tmpPolje.m_wumpus || !tmpPolje.m_brezno)){
			WumpusHelper.Print(WumpusSteps.NaselZlato(tmpPolje.m_x, tmpPolje.m_y));
			this.m_points += WumpusRating.findGold;
		}
		
		//Jama
		if(tmpPolje.m_brezno){
			WumpusHelper.Print(WumpusSteps.KonecBrezno(tmpPolje.m_x, tmpPolje.m_y));
			this.m_points = WumpusRating.fallingIntoAPit;
			this.m_endOfGame = true;
			WumpusHelper.Print(WumpusSteps.GetPoints(this.m_points));
		}
		
		//Wumpus
		if(tmpPolje.m_wumpus){
			WumpusHelper.Print(WumpusSteps.KonecWumpus(tmpPolje.m_x, tmpPolje.m_y));
			this.m_points = WumpusRating.eatenByWumpus;
			this.m_endOfGame = true;
			WumpusHelper.Print(WumpusSteps.GetPoints(this.m_points));
		}
		
		//Izhod
		if(tmpPolje.m_izhod){
			WumpusHelper.Print(WumpusSteps.KonecZmaga(tmpPolje.m_x, tmpPolje.m_y));
			this.m_points = WumpusRating.climbOutOfCave;
			this.m_endOfGame = true;
			WumpusHelper.Print(WumpusSteps.GetPoints(this.m_points));
		}
		
	}
	
	/*
	 * Action: go down
	 */
	public void GoDown(WumpusPolje[][] wumpusWorld) {
		
		WumpusPolje oce = tmpPolje;
		tmpPolje = wumpusWorld[tmpPolje.m_x + 1][tmpPolje.m_y];
		obiskanaPolja.add(tmpPolje);
		tmpPolje.m_oce = oce;
		this.m_points += WumpusRating.action;
		WumpusHelper.Print(WumpusSteps.PremikNaPolje(tmpPolje.m_x, tmpPolje.m_y));
		
		//Varno
		if(tmpPolje.IsSafe()){
			this.action = WumpusActions.down;
			tmpPolje.m_lastAction = action;
		}
		
		//Vetric
		if(tmpPolje.m_vetrovno){
			WumpusHelper.Print(WumpusSteps.zaznalVetric);
			this.action = GetLogicAction(wumpusWorld);
			tmpPolje.m_lastAction = action;
		}
			
		//Smrad
		if(tmpPolje.m_smrad){
			WumpusHelper.Print(WumpusSteps.zaznalSmrad);
			this.action = GetLogicAction(wumpusWorld);
			tmpPolje.m_lastAction = action;
		}
		
		//Zlato
		if(tmpPolje.m_zlato && (!tmpPolje.m_wumpus || !tmpPolje.m_brezno)){
			WumpusHelper.Print(WumpusSteps.NaselZlato(tmpPolje.m_x, tmpPolje.m_y));
			this.m_points += WumpusRating.findGold;
		}
		
		//Jama
		if(tmpPolje.m_brezno){
			WumpusHelper.Print(WumpusSteps.KonecBrezno(tmpPolje.m_x, tmpPolje.m_y));
			this.m_points = WumpusRating.fallingIntoAPit;
			this.m_endOfGame = true;
			WumpusHelper.Print(WumpusSteps.GetPoints(this.m_points));
		}
		
		//Wumpus
		if(tmpPolje.m_wumpus){
			WumpusHelper.Print(WumpusSteps.KonecWumpus(tmpPolje.m_x, tmpPolje.m_y));
			this.m_points = WumpusRating.eatenByWumpus;
			this.m_endOfGame = true;
			WumpusHelper.Print(WumpusSteps.GetPoints(this.m_points));
		}
		
		//Izhod
		if(tmpPolje.m_izhod){
			WumpusHelper.Print(WumpusSteps.KonecZmaga(tmpPolje.m_x, tmpPolje.m_y));
			this.m_points = WumpusRating.climbOutOfCave;
			this.m_endOfGame = true;
			WumpusHelper.Print(WumpusSteps.GetPoints(this.m_points));
		}
		
	}
	
	/*
	 * Action: go back
	 */
	public void GoBack(WumpusPolje[][] wumpusWorld) {
		
		tmpPolje = tmpPolje.m_oce;
		obiskanaPolja.add(tmpPolje);
		this.m_points += WumpusRating.action;
		WumpusHelper.Print(WumpusSteps.PremikNaPolje(tmpPolje.m_x, tmpPolje.m_y));
		
		if(tmpPolje.m_lastAction == WumpusActions.down && tmpPolje.IsSafe() && !obiskanaPolja.contains(wumpusWorld[tmpPolje.m_x][tmpPolje.m_y + 1])){
			action = WumpusActions.right;
			tmpPolje.m_lastAction = action;
		}
		else if(tmpPolje.m_lastAction == WumpusActions.right && tmpPolje.IsSafe() && !obiskanaPolja.contains(wumpusWorld[tmpPolje.m_x + 1][tmpPolje.m_y])){
			action = WumpusActions.down;
			tmpPolje.m_lastAction = action;
		}
		else{
			if(tmpPolje.m_oce != null){
				action = WumpusActions.back;
				tmpPolje.m_lastAction = action;
			}
			else{
				if(tmpPolje.m_izhod){
					this.m_points += WumpusRating.climbOutOfCave;
					this.m_endOfGame = true;
					WumpusHelper.Print(WumpusSteps.KonecZmaga(tmpPolje.m_x, tmpPolje.m_y));
					WumpusHelper.Print(WumpusSteps.GetPoints(this.m_points));
				}
			}
		}
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
	
	/*
	 * Return WumpusAction 
	 */
	private int GetLogicAction(WumpusPolje[][] wumpusWorld){
		
		if(tmpPolje.m_vetrovno){
			
			//Down
			if(tmpPolje.m_x + 1 < wumpusWorld.length && tmpPolje.m_y - 1 >= 0){
				if(obiskanaPolja.contains(wumpusWorld[tmpPolje.m_x + 1][tmpPolje.m_y - 1]) && !wumpusWorld[tmpPolje.m_x + 1][tmpPolje.m_y - 1].m_vetrovno){
					return WumpusActions.down;
				}
			}
			
			//Right
			if(tmpPolje.m_x - 1 >= 0 && tmpPolje.m_y + 1 < wumpusWorld[0].length){
				if(obiskanaPolja.contains(wumpusWorld[tmpPolje.m_x - 1][tmpPolje.m_y + 1]) && !wumpusWorld[tmpPolje.m_x - 1][tmpPolje.m_y + 1].m_vetrovno){
					return WumpusActions.right;
				}
			}
			
		}
		
		if(tmpPolje.m_smrad){
			
			//Down
			if(tmpPolje.m_x + 1 < wumpusWorld.length && tmpPolje.m_y - 1 >= 0){
				if(obiskanaPolja.contains(wumpusWorld[tmpPolje.m_x + 1][tmpPolje.m_y - 1]) && !wumpusWorld[tmpPolje.m_x + 1][tmpPolje.m_y - 1].m_smrad){
					return WumpusActions.down;
				}
			}
			
			//Right
			if(tmpPolje.m_x - 1 >= 0 && tmpPolje.m_y + 1 < wumpusWorld[0].length){
				if(obiskanaPolja.contains(wumpusWorld[tmpPolje.m_x - 1][tmpPolje.m_y + 1]) && !wumpusWorld[tmpPolje.m_x - 1][tmpPolje.m_y + 1].m_smrad){
					return WumpusActions.right;
				}
			}
			
		}
		
		return WumpusActions.back;
	}
}
