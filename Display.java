import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;


abstract class Display extends JComponent {

	Program hostProgram;
	JFrame hostFrame;
	int x;
	int y;
	int width;
	int height;
	
	
	
	public Display(int x, int y, int w, int h, JFrame f, Program program) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		hostFrame = f;
		hostProgram = program;
		this.setBounds(x, y, w, h);
		init();
		
	}



	abstract void init();
	
	
	protected abstract void paintComponent(Graphics g);
	
}
