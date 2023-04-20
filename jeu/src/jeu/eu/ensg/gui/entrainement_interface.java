package Type.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class entrainement_interface {

	
		public static void main(String[] args){
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					//On crée une nouvelle instance de notre JDialog
					JDialog dialog = new JDialog();
					dialog.setSize(300, 200);//On lui donne une taille
					dialog.setTitle("Première fenêtre"); //On lui donne un titre
					dialog.setVisible(true);//On la rend visible
					
				}
			});
		}
	
	
	try { 
		Thread.sleep(5000);
	} catch (InterruptedException e) {}

	System.exit(0);

}




