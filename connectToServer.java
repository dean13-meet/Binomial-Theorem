import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class connectToServer {

	private File f = new File("");
	private final String serverAddress = f.getAbsolutePath() + "/src/Server/";
	
	
	public BufferedReader accessFile(String s){
		try {
			return new BufferedReader(new FileReader(serverAddress + s));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}
	public String getLineFromFile(String file, int line){
		BufferedReader a = accessFile(file);
		int x = 0;
		while(x < line -1){
			try {
				a.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			return a.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<String> getAllLinesFromFileInArrayList(String file){
		BufferedReader a = accessFile(file);
		ArrayList<String> retVal = new ArrayList<String>();
		try {
			while(a.ready()){
				retVal.add(a.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
	public String[] getAllLinesFromFileInArray(String file){
		ArrayList<String> a = getAllLinesFromFileInArrayList(file);
		String[] finalRetVal = new String[a.size()];
		for(int i = 0; i < a.size(); i++){
			finalRetVal[i] = a.get(i);
		}
		return finalRetVal;
	}
}
