
public final class WumpusSteps {
	
	public static final String zacetekIgre = "Vstopil sem v svet Wumpusa.";
	public static final String premikNaPolje = "Premik na polje ";
	public static final String zaznalVetric = "Zaznal vetric.";
	public static final String zaznalSmrad = "Zaznal smrad.";
	public static final String zaznalWumpus = "Wumpus je na polju ";
	public static final String zaznalBrezno = "Brezno je na polju ";
	public static final String naselZlato = "Nasel zlato na polju ";
	public static final String konecWumpus = "Wumpus me je pojedel.";
	public static final String konecBrezno = "Padel sem v brezno.";
	public static final String konecZmaga = "Zakljucil sem igro ";
	public static final String getPoints = "Skupno stevilo tock: ";
	
	public static final String PremikNaPolje(int x, int y){
		return premikNaPolje + "(" + x + ", " + y + ")";
	}
	
	public static final String ZaznalWumpus(int x, int y){
		return zaznalWumpus + "(" + x + ", " + y + ")";
	}
	
	public static final String ZaznalBrezno(int x, int y){
		return zaznalBrezno + "(" + x + ", " + y + ")";
	}
	
	public static final String NaselZlato(int x, int y){
		return naselZlato + "(" + x + ", " + y + ")";
	}
	
	public static final String KonecBrezno(int x, int y){
		return konecBrezno + "(" + x + ", " + y + ")";
	}
	
	public static final String KonecWumpus(int x, int y){
		return konecWumpus + "(" + x + ", " + y + ")";
	}
	
	public static final String KonecZmaga(int x, int y){
		return konecZmaga + "(" + x + ", " + y + ")";
	}
	
	public static final String GetPoints(int points){
		return getPoints + "(" + points + ")";
	}
}
