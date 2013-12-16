
public class WumpusPolje {
	
	//Private fields
	public boolean m_vetrovno = false;
	public boolean m_smrad = false;
	public boolean m_wumpus = false;
	public boolean m_zlato = false;
	public boolean m_brezno = false;
	public boolean m_izhod_ = false;
	public boolean m_start = false;
	
	public WumpusPolje(){
		
	}
	
	public WumpusPolje(boolean vetrovno, boolean smrad, boolean wumpus, boolean zlato, boolean brezno, boolean izhod, boolean start){
		this.m_brezno = brezno;
		this.m_izhod_ = izhod;
		this.m_smrad = smrad;
		this.m_vetrovno = vetrovno;
		this.m_wumpus = wumpus;
		this.m_zlato = zlato;
		this.m_start = start;
	}

}
