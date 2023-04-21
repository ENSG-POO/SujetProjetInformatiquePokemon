package jeu.eu.ensg.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

import javax.swing.*;

import jeu.eu.ensg.*;

public class FenetreCombat extends JFrame {

    public JButton change;
    public JButton fuite;
    public JButton attaque;
    public JButton attaque1;
    public JButton Yes;
    public JButton No;
    public JPanel Main;
    public JPanel ButtonPanel;
    public JPanel yn;
    public JPanel selec;
    public JComboBox<String> ch;
    public JTextArea PVJ;
    public JTextArea PVS;

    public FenetreCombat(Trainer t,Pokemon PJ,Combat ca) {
    

        // CREATION ET OUVERTURE DE LA FENETRE DE COMBAT
        JFrame fen = new JFrame();
        fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fen.setSize(1200,800);

        fen.setLayout(new BorderLayout());

        fen.add(BorderLayout.CENTER, new ImageCombat());

        fen.setLocationRelativeTo(null);
        fen.setResizable(false);
        fen.setTitle("fenetre de combat");
    

    // BOUTTON DE BASE / FUITE ATTAQUE CHANGE
        JButton fuite = new JButton("Fuir");
        fuite.setBounds(50, 50, 20, 100);
        
        JButton attaque = new JButton("Attaque STAB");
        attaque.setBounds(50, 50, 20, 100);
        
        JButton attaque1 = new JButton("Attaque de base");
        attaque1.setBounds(50, 50, 20, 100);
        
        JButton change = new JButton("Changer de pokémon");
        change.setBounds(50, 50, 20, 100);
    
    //PANEL DE BOUTTON
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(4,1));
    
    // CREATION DU PANEL BOUTTON PRINCIPAUX
        JPanel Main = new JPanel();
        Main.setLayout(new GridLayout(1,4));
        Main.add(fuite);
        Main.add(attaque);
        Main.add(attaque1);
        Main.add(change);
    
    //COMBO BOX POUR CHANGER DE POKEMON
        JTextArea ch = new JTextArea();
        ch.setText("Prochain Pokemon: "+ t.getEquipe().get(0).getNom());
    
    //PANEL POUR LA COMBO BOX
        JPanel selec = new JPanel();
        selec.setLayout(new GridLayout(1,1));
        selec.add(ch);

    //PANEL DE TEXTE
        JTextArea console = new JTextArea();
        JScrollPane csl = new JScrollPane(console);
        JPanel c = new JPanel();
        c.setLayout(new GridLayout(1,1));
        c.add(csl);
        c.setPreferredSize(new Dimension(fen.WIDTH,50));

        // Create a custom OutputStream that writes to the JTextArea
        OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                // Append the new character to the JTextArea
                console.append(String.valueOf((char) b));
                // Scroll to the bottom of the JScrollPane
                console.setCaretPosition(console.getDocument().getLength());
            }
        };

        // Set the custom OutputStream as the new System.out
        System.setOut(new PrintStream(outputStream));

    //INDICATEUR DE VIE
        JPanel vie = new JPanel();
        JTextArea PVJ = new JTextArea(1,20);
        JTextArea PVS = new JTextArea(1,20);
        vie.setLayout(new GridLayout(1, 2));
        vie.add(PVJ);
        vie.add(PVS);
        PVJ.setText(ca.getPJ().getNom() + " " + ca.getPJ().getHP()+"/"+ca.getPJ().getStats().getHpMax());
        PVS.setText(ca.getPS().getNom() + " " + ca.getPS().getHP()+"/"+ca.getPS().getStats().getHpMax());

    
    //ACTION DE CHAQUE BOUTTON

    ActionListener Attaque = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent f) {
            ca.attaque();
            ButtonPanel.setEnabled(false);
            PVJ.setText(ca.getPJ().getNom() + " " + ca.getPJ().getHP()+"/"+ca.getPJ().getStats().getHpMax());
            PVS.setText(ca.getPS().getNom() + " " + ca.getPS().getHP()+"/"+ca.getPS().getStats().getHpMax());
        }
    };

    ActionListener Fuite = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent f) {
            ca.fuir();
            fen.dispose();
            ButtonPanel.setEnabled(false);
        }
    };

    ActionListener Attaque_spe = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent f) {
            ca.attaque_spe();
            ButtonPanel.setEnabled(false);
            PVJ.setText(ca.getPJ().getNom() + " " + ca.getPJ().getHP()+"/"+ca.getPJ().getStats().getHpMax());
            PVS.setText(ca.getPS().getNom() + " " + ca.getPS().getHP()+"/"+ca.getPS().getStats().getHpMax());
        }
    };

    ActionListener Change = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent f) {

            if (t.getEquipe().size()==0) {
                System.out.println("Vous n'avez pas d'autre Pokemon!");
                ch.setText("Prochain Pokemon: Aucun autre dans le sac");
            }
            else {
            Pokemon ancien = ca.getPJ();
            ca.setPJ(t.getEquipe().get(0));
            ArrayList<Pokemon> Temp = t.getEquipe();
            Temp.remove(0);
            Temp.add(ancien);
            t.setEquipe(Temp);
            System.out.println("Votre "+ancien.getNom()+" a été remplacé par "+ca.getPJ().getNom());
            ch.setText("Prochain Pokemon: "+ t.getEquipe().get(0).getNom());
            }

            ButtonPanel.setEnabled(false);
            PVJ.setText(ca.getPJ().getNom() + " " + ca.getPJ().getHP()+"/"+ca.getPJ().getStats().getHpMax());
            PVS.setText(ca.getPS().getNom() + " " + ca.getPS().getHP()+"/"+ca.getPS().getStats().getHpMax());

        }
    };

    fuite.addActionListener(Fuite);
    attaque.addActionListener(Attaque);
    attaque1.addActionListener(Attaque_spe);
    change.addActionListener(Change);

    ButtonPanel.add(c);
    ButtonPanel.add(vie);
    ButtonPanel.add(Main);
    ButtonPanel.add(selec);
    fen.add(ButtonPanel, BorderLayout.SOUTH);
    ButtonPanel.setEnabled(false);
    c.setEnabled(true);
    fen.setVisible(true);


    }

}

