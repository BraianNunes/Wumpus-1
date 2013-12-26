import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class WumpusMain {

	//Private fields
	public static WumpusPolje[][] svetWumpus;
	public static int numRows = 0;
	public static int numCol = 0;

	public static void main(String[] args) {

		//Read from input file
		String file = args[0];
		//String file = "/Users/matjaz/Desktop/svet_wumpusa.txt";
		
		if(!file.isEmpty()){
			try{
				boolean success = InitializeWumpusWorld(ReadFromFile(file));
				if(success){
					WumpusPlayer player = new WumpusPlayer();
					player.Play(svetWumpus);
				}
				else{
					WumpusHelper.Print("Game did not start!");
				}
			}
			catch(Exception ex){
				WumpusHelper.Print(ex.getMessage());
			}
		}
		else{
			WumpusHelper.Print("Insert Wumpus world!");
		}

	}
	
	//Method for initializing Wumpus world
	private static boolean InitializeWumpusWorld(List<String> readFromFile) {
		if(readFromFile.size() > 0){
			for(int i = 0; i < readFromFile.size() - 1; i++)
			{	
				if(readFromFile.get(i).matches("^M[0-9][0-9]")){
					numRows = Integer.parseInt(readFromFile.get(i).substring(2));
					numCol = Integer.parseInt(readFromFile.get(i).substring(1, 2));

					svetWumpus = new WumpusPolje[numRows][numCol];
					for(int row = 0; row < svetWumpus.length; row++){
						for(int col = 0; col < svetWumpus[0].length; col++){
							svetWumpus[row][col] = new WumpusPolje(row, col);
						}
					}
					break;
				}
			}

			for(int i = 0; i < readFromFile.size() - 1; i++){
				if(!readFromFile.get(i).matches("^M[0-9][0-9]")){
					if(readFromFile.get(i).matches("^A[0-9][0-9]")){

						int x = Integer.parseInt(readFromFile.get(i).substring(2));
						int y = Integer.parseInt(readFromFile.get(i).substring(1, 2));

						if(svetWumpus[x-1][y-1] != null){
							svetWumpus[x-1][y-1].m_start = true;
						}
						else{
							WumpusPolje polje = new WumpusPolje(x-1, y-1, true, false, false, false, false, false, false);
							svetWumpus[x-1][y-1] = polje;
						}	
					}
					else if(readFromFile.get(i).matches("^GO[0-9][0-9]")){

						int x = Integer.parseInt(readFromFile.get(i).substring(3));
						int y = Integer.parseInt(readFromFile.get(i).substring(2, 3));

						if(svetWumpus[x-1][y-1] != null){
							svetWumpus[x-1][y-1].m_izhod_ = true;
						}
						else{
							WumpusPolje polje = new WumpusPolje(x-1, y-1, false, true, false, false, false, false, false);
							svetWumpus[x-1][y-1] = polje;
						}	
					}
					else if(readFromFile.get(i).matches("^G[0-9][0-9]")){

						int x = Integer.parseInt(readFromFile.get(i).substring(2));
						int y = Integer.parseInt(readFromFile.get(i).substring(1, 2));

						if(svetWumpus[x-1][y-1] != null){
							svetWumpus[x-1][y-1].m_zlato = true;
						}
						else{
							WumpusPolje polje = new WumpusPolje(x-1, y-1, false, false, true, false, false, false, false);
							svetWumpus[x-1][y-1] = polje;
						}	
					}
					else if(readFromFile.get(i).matches("^S[0-9][0-9]")){

						int x = Integer.parseInt(readFromFile.get(i).substring(2));
						int y = Integer.parseInt(readFromFile.get(i).substring(1, 2));

						if(svetWumpus[x-1][y-1] != null){
							svetWumpus[x-1][y-1].m_smrad = true;
						}
						else{
							WumpusPolje polje = new WumpusPolje(x-1, y-1, false, false, false, true, false, false, false);
							svetWumpus[x-1][y-1] = polje;
						}	
					}
					else if(readFromFile.get(i).matches("^B[0-9][0-9]")){

						int x = Integer.parseInt(readFromFile.get(i).substring(2));
						int y = Integer.parseInt(readFromFile.get(i).substring(1, 2));

						if(svetWumpus[x-1][y-1] != null){
							svetWumpus[x-1][y-1].m_vetrovno = true;
						}
						else{
							WumpusPolje polje = new WumpusPolje(x-1, y-1, false, false, false, false, true, false, false);
							svetWumpus[x-1][y-1] = polje;
						}	
					}
					else if(readFromFile.get(i).matches("^P[0-9][0-9]")){

						int x = Integer.parseInt(readFromFile.get(i).substring(2));
						int y = Integer.parseInt(readFromFile.get(i).substring(1, 2));

						if(svetWumpus[x-1][y-1] != null){
							svetWumpus[x-1][y-1].m_brezno = true;
						}
						else{
							WumpusPolje polje = new WumpusPolje(x-1, y-1, false, false, false, false, false, true, false);
							svetWumpus[x-1][y-1] = polje;
						}	
					}
					else if(readFromFile.get(i).matches("^W[0-9][0-9]")){

						int x = Integer.parseInt(readFromFile.get(i).substring(2));
						int y = Integer.parseInt(readFromFile.get(i).substring(1, 2));

						if(svetWumpus[x-1][y-1] != null){
							svetWumpus[x-1][y-1].m_wumpus = true;
						}
						else{
							WumpusPolje polje = new WumpusPolje(x-1, y-1, false, false, false, false, false, false, true);
							svetWumpus[x-1][y-1] = polje;
						}	
					}
				}
			}

			return true;
		}
		else{
			return false;
		}
	}

	//Read from file
	private static List<String> ReadFromFile(String file) {

		List<String> seznam = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			seznam.add(line);

			while (line != null) {
				line = br.readLine();
				seznam.add(line);
			}

			br.close();
			return seznam;
		}
		catch(Exception ex){
			WumpusHelper.Print(ex.getMessage());
			System.exit(0);
			return seznam;
		}
	}
}
