package TestInter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Main extends JFrame {
	
	public static void main(String[] argv)
	 {  
	   JFrame frame = new JFrame("frame"); 
	   frame.setLayout(new FlowLayout()); 
	  
	   String[] items = { "item1", "item2", "item3" };
	   JComboBox cb = new JComboBox(items);
	   cb.addActionListener(new ActionListener() {     
	     @Override
	     public void actionPerformed(ActionEvent e) {
	        System.out.println("Valeur: " + cb.getSelectedItem().toString());      
	     }
	     
	    
	     
	   });
	   
	  
	  
	   frame.add(cb); 
	   frame.setSize(250, 250); 
	   frame.show();
	 }
    
    }

