package GUI;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ExempleBoutton {
	
	public ExempleBoutton(){
		JFrame frame = new JFrame();
		
		JButton btn1 = new JButton("A");
		btn1.setOpaque(false);
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);	
		
		btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bouton cliqué !");
            }
        });
		
		frame.add(btn1);
		frame.setLayout(new GridLayout(1,1));
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ExempleBoutton();

	}

}
