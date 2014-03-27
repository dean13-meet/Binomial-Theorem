import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;


public class Program {
	
	ArrayList<JFrame> frames = new ArrayList<JFrame>();
	ArrayList<String> framesId = new ArrayList<String>();

	static JFrame initialF = new JFrame(); 
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double width = screenSize.getWidth();
	static double height = screenSize.getHeight();
	static final int DISPLAY_WIDTH = (int) (width/1.4); 
	static final int DISPLAY_HEIGHT = (int) (height/1.4); 
	static final int xOffSet = 10;
	static final int yOffSet = xOffSet;

	Program(){

		initialF.setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT); 
		initialF.setLayout(null); 
		initialF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		initialF.setTitle("ResturantRate"); 
		initialF.getContentPane().setBackground(new Color(96,96,96));
		
		initialDisplay initialD = createDisplay(xOffSet, yOffSet, DISPLAY_WIDTH - (2*xOffSet), 
				DISPLAY_HEIGHT - (2*yOffSet), initialF);

		
		initialF.initDisplay = initialD;
	
		initialF.add(initialF.initDisplay); 
		initialF.setVisible(true);
		initialF.setResizable(false);

	}
	public initialDisplay createDisplay(int x, int y, int w, int h, JFrame f) {

		return new initialDisplay(x, y, w, h, f, this);
	} 
	public void createJFrame(double percentageOfScreenWidth, double percentageOfScreenHeight,
			String title, Color background, Boolean resizable, final String id){
		
		final JFrame retVal = new JFrame();
	
		retVal.setSize((int)(DISPLAY_WIDTH*percentageOfScreenWidth/100), (int)(DISPLAY_HEIGHT*percentageOfScreenHeight/100));
		retVal.setLayout(null); 
		retVal.setTitle(title); 
		retVal.getContentPane().setBackground(background);
		retVal.setVisible(true);
		retVal.setResizable(resizable);
		retVal.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	framesId.remove(id);
		    	frames.remove(retVal);
		    	
		    }
		});
		framesId.add(id);
		frames.add(retVal);
		
	}
	public JFrame getJFrameById(String id){
		int i = framesId.indexOf(id);
		
		if(i >=0 ){
			return frames.get(i);
		}
		return null;
	}
}
