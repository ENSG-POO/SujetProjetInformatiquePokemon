package TestInter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyListener extends JFrame {
	  //créer un JTextField 
	  JTextField textField = new JTextField("Appuyez sur Entrée");
	  //constructeur
	  public MyListener() 
	  {
	    //ajouter le listener sur le JTextField
	    textField.addActionListener(new ActionListener() {
	      //capturer un événement sur le JTextField
	      public void actionPerformed(ActionEvent e) {
	        //récupérer et afficher le contenu de JTextField dans la console
	        System.out.println("Text=" + textField.getText());
	      }
	    });
	    //ajouter le JTextField au frame
	    getContentPane().add(textField);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(300,100);
	  }
	  public static void main(String[] args) {
	    new MyListener().setVisible(true);
	  }
	}

