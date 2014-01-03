
public class WumpusPolje {
	
	//Public fields
	public boolean m_vetrovno = false;
	public boolean m_smrad = false;
	public boolean m_wumpus = false;
	public boolean m_zlato = false;
	public boolean m_brezno = false;
	public boolean m_izhod = false;
	public boolean m_start = false;
	public int m_x = 0;
	public int m_y = 0;
	public WumpusPolje m_oce;
	public int m_lastAction;
	
	public WumpusPolje(int x, int y){
		this.m_x = x;
		this.m_y = y;
		this.m_brezno = false;
		this.m_izhod = false;
		this.m_smrad = false;
		this.m_vetrovno = false;
		this.m_wumpus = false;
		this.m_zlato = false;
		this.m_start = false;
		this.m_oce = null;
		this.m_lastAction = WumpusActions.none;
	}
	
	public WumpusPolje(int x, int y, boolean start, boolean izhod, boolean zlato, boolean smrad, boolean vetrovno, boolean brezno, boolean wumpus){
		this.m_x = x;
		this.m_y = y;
		this.m_start = start;
		this.m_izhod = izhod;
		this.m_zlato = zlato;
		this.m_smrad = smrad;
		this.m_vetrovno = vetrovno;
		this.m_brezno = brezno;
		this.m_wumpus = wumpus;
		this.m_oce = null;
		this.m_lastAction = WumpusActions.none;
	}
	
	public boolean IsSafe(){
		if(!this.m_smrad && !this.m_vetrovno && !this.m_brezno && !this.m_wumpus){
			return true;
		}
		else{
			return false;
		}
	}
}
