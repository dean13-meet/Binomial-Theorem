import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class signInDisplay extends Display {

	public signInDisplay(int x, int y, int w, int h, JFrame f, Program program) {
		super(x, y, w, h, f, program);
		// TODO Auto-generated constructor stub
	}

	@Override
	void init() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(80,0,0));
		g.fillRect(10, 10, 200, 200);

	}

}
