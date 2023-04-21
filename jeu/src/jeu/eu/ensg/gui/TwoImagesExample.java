package jeu.eu.ensg.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
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

        // Créer les boutons
        JButton button1 = new JButton("Bouton 1");
        JButton button2 = new JButton("Bouton 2");
        JButton button3 = new JButton("Bouton 3");
        JButton button4 = new JButton("Bouton 4");
        JButton fuiteButton = new JButton("Fuite");

        // Créer un conteneur pour chaque paire d'image et de boutons
        JPanel imagePanel1 = new JPanel();
        imagePanel1.setLayout(new BoxLayout(imagePanel1, BoxLayout.PAGE_AXIS));
        imagePanel1.add(label1);
        imagePanel1.add(button1);
        imagePanel1.add(button2);

        JPanel imagePanel2 = new JPanel();
        imagePanel2.setLayout(new BoxLayout(imagePanel2, BoxLayout.PAGE_AXIS));
        imagePanel2.add(label2);
        imagePanel2.add(button3);
        imagePanel2.add(button4);

        // Créer un conteneur pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(fuiteButton);

        // Créer un conteneur pour les deux panneaux d'images et les boutons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(imagePanel1);
        mainPanel.add(imagePanel2);
        mainPanel.add(buttonPanel);

        // Créer la fenêtre et ajouter le conteneur principal
        JFrame frame = new JFrame();
        frame.add(mainPanel);

        // Configurer la fenêtre
        frame.setTitle("Interface");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
