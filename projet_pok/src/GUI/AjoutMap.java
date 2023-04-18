package GUI;

import javax.swing.*;

public class AjoutMap{
  AjoutMap()  {
    JFrame f = new JFrame("Ajouter une image dans JFrame");
    ImageIcon icon = new ImageIcon("../images/carte_pokemon.jpg");
    f.add(new JLabel(icon));
    f.pack();
    f.setVisible(true);
  }
  public static void main(String args[])   {
    new AjoutMap();
  }
}