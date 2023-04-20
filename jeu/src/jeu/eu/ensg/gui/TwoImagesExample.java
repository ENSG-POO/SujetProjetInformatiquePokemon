package jeu.eu.ensg.gui;



import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TwoImagesExample {
    public static void main(String[] args) {
        // Charger les images
        ImageIcon image1 = new ImageIcon("../../data/Images/1G/Charizard.png");
        ImageIcon image2 = new ImageIcon("../../data/Images/1G/Charizard.png");
        // Créer les JLabels pour chaque image
        JLabel label1 = new JLabel(image1);
        JLabel label2 = new JLabel(image2);

        // Créer les JLabels pour chaque texte
        JLabel text1 = new JLabel("Image 1");
        JLabel text2 = new JLabel("Image 2");

        // Créer les boutons
        JButton button1 = new JButton("Bouton 1");
        JButton button2 = new JButton("Bouton 2");
        JButton button3 = new JButton("Bouton 3");
        JButton button4 = new JButton("Bouton 4");
        JButton fuiteButton = new JButton("Fuite");

        // Créer un conteneur pour chaque paire d'image et de texte
        JPanel imagePanel1 = new JPanel();
        imagePanel1.setLayout(new FlowLayout());
        imagePanel1.add(label1);
        imagePanel1.add(text1);

        JPanel imagePanel2 = new JPanel();
        imagePanel2.setLayout(new FlowLayout());
        imagePanel2.add(label2);
        imagePanel2.add(text2);

        // Créer un conteneur pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        // Créer un autre conteneur pour le bouton "Fuite"
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(fuiteButton);

        // Créer un conteneur pour les trois panneaux
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.add(imagePanel1);
        frame.add(imagePanel2);
        frame.add(buttonPanel);
        frame.add(bottomPanel);

        // Configurer la fenêtre
        frame.setTitle("Interface");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


