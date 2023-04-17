package GUI;

import javax.swing.*;
import java.awt.*;

public class PokemonWorldMapUI extends JFrame {
    private JLabel mapLabel;

    public PokemonWorldMapUI() {
        setTitle("Pokemon World Map");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon mapIcon = new ImageIcon("../images/carte_pokemon.jpg");
        mapLabel = new JLabel(mapIcon);

        setLayout(new BorderLayout());
        add(mapLabel, BorderLayout.CENTER);
    }

  
    public static void main(String[] args) {
        PokemonWorldMapUI worldMapUI = new PokemonWorldMapUI();
        worldMapUI.setVisible(true);
    }
}
