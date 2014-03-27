import java.awt.Color;

import javax.swing.JFrame;

public abstract class ButtonCommands{
	Program p;
	ButtonCommands(Program p){
		this.p = p;
	}
	
	abstract void execute(int caseNum);
}

class empty extends ButtonCommands{

	empty(Program p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	void execute(int caseNum) {
		// TODO Auto-generated method stub
		
	}
	
}

class solve extends ButtonCommands{

	double var1, pow1, var2, pow2, overallPow;
	boolean sign;
	solve(Program p) {
		super(p);
		
	
	}

	@Override 
	void execute(int caseNum) {
		p.initialF.initDisplay.updateInfoFromFields();
		this.var1 = p.initialF.initDisplay.var1;
		this.var2 = p.initialF.initDisplay.var2;
		this.pow1 = p.initialF.initDisplay.pow1;
		this.pow2 = p.initialF.initDisplay.pow2; 
		this.overallPow = p.initialF.initDisplay.overallPow;
		this.sign = p.initialF.initDisplay.sign;
		
		if(p.getJFrameById("Solve!")==null){
		String title = "Equation: ";
		title+="( ";
		System.out.println(var1);
		title+= var1; 	title+="x";	title += "^";		title+= pow1;
		title+= " ";
		if(sign){title+= "-";}else {title+="+";}
		title+="";
		title+= var2; 	title+="x";	title += "^";		title+= pow2;
		title+= " )" + "^" + overallPow;
		
		p.createJFrame(50, 50, title, new Color(255,153,0), false, "signIn");
		JFrame signInF = p.getJFrameById("signIn");
		Display signInD = new signInDisplay(0,0,signInF.getWidth(), signInF.getHeight(), signInF, p);
		signInF.add(signInD);
		}else{p.getJFrameById("Solve!").toFront();
		
			
		}
	}
	
}