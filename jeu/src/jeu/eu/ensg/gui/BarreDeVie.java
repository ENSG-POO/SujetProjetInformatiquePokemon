package jeu.eu.ensg.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BarreDeVie extends JPanel {
    
    private int maxHealth;
    private int currentHealth;
    private int width;
    private int height;
    
    public BarreDeVie(int maxHealth, int currentHealth,int width,int height) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.width = width;
        this.height = height;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int width = this.width;
        int height = this.height;
        
        g.setColor(Color.RED);
        g.fillRect(0, 0, width, height);
        
        int healthWidth = (int) (((double) currentHealth / maxHealth) * width);
        
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, healthWidth, height);
    }
    
}