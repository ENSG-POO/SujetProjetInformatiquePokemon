package TestInter;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DispoEx {

	DispoEx() {
	    JFrame frame = new JFrame();
	    
	    JButton btn1 = new JButton("A1");
	    JButton btn2 = new JButton("A2");
	    JButton btn3 = new JButton("C");
	    JButton btn4 = new JButton("D");
	    JButton btn5 = new JButton("E");
	    JButton btn6 = new JButton("F");
	    
	    frame.add(btn1);
	    frame.add(btn2);
	    frame.add(btn3);
	    frame.add(btn4);
	    frame.add(btn5);
	    frame.add(btn6);
	    
	    //définir la disposition en grille de 3 lignes et 2 colonnes
	    frame.setLayout(new GridLayout(5,5));
	    
	    frame.setSize(400,400);
	    frame.setVisible(true);
	  }
	  
	public static void main(String[] args) {
	    new DispoEx();
	  }

}
