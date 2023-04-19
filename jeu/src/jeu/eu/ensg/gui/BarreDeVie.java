package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BarreDeVie extends JPanel {
    
    private int maxHealth;
    private int currentHealth;
    
    public BarreDeVie(int maxHealth, int currentHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int width = getWidth();
        int height = getHeight();
        
        g.setColor(Color.RED);
        g.fillRect(0, 0, width, height);
        
        int healthWidth = (int) (((double) currentHealth / maxHealth) * width);
        
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, healthWidth, height);
    }
    
}