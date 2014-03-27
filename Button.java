import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
		
		public int timesClicked = 0;
		public int roundLength; //How many times button must be clicked to return to original
		//position.
		ButtonCommands command;
		String[] strs; //Contains the strings that will be displayed on the button
		//with every click.
		private Color hoverBackgroundColor;
        private Color pressedBackgroundColor;
		
		Button(ButtonCommands command, String[]strs, int x, int y, int w, int h) {
			super(strs[0]);
			addActionListener(this);
			this.command = command;
			roundLength = strs.length;
			this.strs = strs;
			this.setBounds(x, y, w, h);
			setFontSize();
			
			repaint();
			
		}

		private void setFontSize() {
			Font labelFont = this.getFont();
			String labelText = this.getText();

			int stringWidth = this.getFontMetrics(labelFont).stringWidth(labelText);
			int componentWidth = (int) (this.getWidth()/1.3);

			// Find out how much the font can grow in width.
			double widthRatio = (double)componentWidth / (double)stringWidth;

			int newFontSize = (int)(labelFont.getSize() * widthRatio);
			int componentHeight = this.getHeight();

			// Pick a new font size so it will not be larger than the height of label.
			int fontSizeToUse = Math.min(Math.min(newFontSize, componentHeight), 20);

			// Set the label's font size to the newly determined size.
			this.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
			
		}
		protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(pressedBackgroundColor);
               
            } else if (getModel().isRollover()) {
                g.setColor(hoverBackgroundColor);
            } else {
                g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
		}
		public void actionPerformed(ActionEvent arg0) {			
			
			this.setText(strs[(timesClicked+1)%roundLength]);
			setFontSize();
			command.execute(timesClicked);
			timesClicked++;	
			
		}
		
		public void setHoverBackgroundColor(Color c){
			hoverBackgroundColor = c;
		}
		public void setPressedBackgroundColor(Color c){
			pressedBackgroundColor = c;
		}
	}