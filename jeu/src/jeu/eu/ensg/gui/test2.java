package jeu.eu.ensg.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test2 extends JFrame {
    public test2() {
        super("Ma fenêtre Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Création d'un JButton avec le texte "Cliquez ici"
        JButton button1 = new JButton("Cliquez ici");

        // Ajout d'un écouteur d'événements au bouton
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton a été cliqué !");
            }
        });

        // Ajout du bouton à la fenêtre
        getContentPane().add(button1, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new test2().setVisible(true);
    }
}
