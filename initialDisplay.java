import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




public class initialDisplay extends Display{

	
	
	Button Solve;	int sIx;	int sIy;	int sIw;	int sIh;
	double var1, pow1, var2, pow2, overallPow;
	JTextField firstVarF, firstPowerF, signF, secondVarF, secondPowerF, overallPowerF;
	JTextField tempTextField;
	boolean sign; //false is +, true is -
	
	public initialDisplay(int x, int y, int w, int h, JFrame f, Program program) {
		super(x, y, w, h, f, program);
		// TODO Auto-generated constructor stub
	}

	@Override
	void init() {
		int h = (int)(((width-200)/2+100) - 77.5-25/2);//horizontal shift is set in a way that the sign (+/-) with be above center of button.
		JLabel rParentheses = new JLabel("(");
		rParentheses.setBounds(new Rectangle(h-15, 190, 20, 35));
		rParentheses.setForeground(Color.CYAN);
		rParentheses.setFont(new Font("Serif", Font.BOLD, 30));
		add(rParentheses);
		rParentheses.setVisible(true);
		firstVarF = new JTextField(20);
		firstVarF.setName("First Var");
		firstVarF.addActionListener(new JTextListener());
		firstVarF.setBounds(new Rectangle(h, 200, 30, 25));
		add(firstVarF);
		firstVarF.setVisible(true);
		
		JLabel x = new JLabel("X");
		x.setBounds(new Rectangle(h+35, 200, 50, 25));
		x.setForeground(Color.orange);
		x.setFont(new Font("Serif", Font.BOLD, 20));
		add(x);		
		x.setVisible(true);
		
		firstPowerF = new JTextField(20);
		firstPowerF.setName("First Pow");
		firstPowerF.addActionListener(new JTextListener());
		firstPowerF.setBounds(new Rectangle(h+40, 175, 25, 25));
		add(firstPowerF);
		firstPowerF.setVisible(true);
		
		signF = new JTextField(20);
		signF.setName("Sign");
		signF.addActionListener(new JTextListener());
		signF.setBounds(new Rectangle((int)(h + 77.5), 200, 25, 25));
		add(signF);
		signF.setVisible(true);
	
		secondVarF = new JTextField(20);
		secondVarF.setName("Second Var");
		secondVarF.addActionListener(new JTextListener());
		secondVarF.setBounds(new Rectangle(h + 115, 200, 30, 25));
		add(secondVarF);
		secondVarF.setVisible(true);
		
		
		JLabel x2 = new JLabel("X");
		x2.setBounds(new Rectangle(h+150, 200, 50, 25));
		x2.setForeground(Color.orange);
		x2.setFont(new Font("Serif", Font.BOLD, 20));
		add(x2);
		x2.setVisible(true);
		
		secondPowerF = new JTextField(20);
		secondPowerF.setName("Second Pow");
		secondPowerF.addActionListener(new JTextListener());
		secondPowerF.setBounds(new Rectangle(h + 155, 175, 25, 25));
		add(secondPowerF);
		secondPowerF.setVisible(true);
		
		overallPowerF = new JTextField(20);
		overallPowerF.setName("Overall Pow");
		overallPowerF.addActionListener(new JTextListener());
		overallPowerF.setBounds(new Rectangle(h + 200, 175, 25, 25));
		add(overallPowerF);
		overallPowerF.setVisible(true);
		
		
		
		JLabel lParentheses = new JLabel(")");
		lParentheses.setBounds(new Rectangle(h+185, 190, 20, 35));
		lParentheses.setForeground(Color.CYAN);
		lParentheses.setFont(new Font("Serif", Font.BOLD, 30));
		add(lParentheses);
		lParentheses.setVisible(true);
		
		
		
		String[] sItext = {"Solve!"}; sIw = 200; sIh = 70; sIx = (width-sIw)/2; sIy = (height-sIh)/2+50;
		Solve = new Button(new solve(hostProgram), sItext, sIx, sIy, sIw, sIh);
		add(Solve);
		
		repaint();
		
	}
	public void updateInfoFromFields(){
	
		JTextListener tool = new JTextListener();
		tool.actionPerformed(new ActionEvent(firstVarF, 0, "u"));
		tool.actionPerformed(new ActionEvent(firstPowerF, 0, "u"));
		tool.actionPerformed(new ActionEvent(secondVarF, 0, "u"));
		tool.actionPerformed(new ActionEvent(secondPowerF, 0, "u"));
		tool.actionPerformed(new ActionEvent(signF, 0, "u"));
		tool.actionPerformed(new ActionEvent(overallPowerF, 0, "u"));
		
	}
	
	public void addJTextField( JTextField j, String name, Rectangle r){
		tempTextField = j;
		tempTextField = new JTextField(20);
		tempTextField.setName(name);	   
		tempTextField.addActionListener(new JTextListener());
		tempTextField.setBounds(r);
	    add(tempTextField);
	    tempTextField.setVisible(true);
	
}

	@Override
	protected void paintComponent(Graphics g) {
	
		
		
	}
	
	
	class JTextListener extends JPanel implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) throws NumberFormatException {
			Object source = arg0.getSource();
			JTextField textField = (JTextField)source;
			
			String text = textField.getText();
	        textField.selectAll();
	        
	        if(textField.getName()=="First Var") {
	        	var1=Double.parseDouble(text); 
	        	System.out.println(var1);
	        }
	        if(textField.getName()=="First Pow") {
	        	pow1=Double.parseDouble(text); 
	        }
	        if(textField.getName()=="Sign") {
	        	if(text.equals("-")){
	        		sign = true;
	        	}
	        	else if(text.equals("+")){
	        		sign = false;
	        	}
	        	else{
	        		throw new NumberFormatException();
	        	}
	        }
	        if(textField.getName()=="Second Var") {
	        	var2=Double.parseDouble(text); 
	        }
	        if(textField.getName()=="Second Pow") {
	        	pow2=Double.parseDouble(text); 
	        }
	        if(textField.getName()=="Overall Pow") {
	        	overallPow=Double.parseDouble(text); 
	        }
			
		}
		
	}
	

}

