package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapWithPoints extends JFrame {

    private JPanel mapPanel;
    private Point point;
    private JButton validateButton;

    public MapWithPoints() {    	
        setTitle("Ajout d'un point");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon mapImage = new ImageIcon("../images/carte_pokemon.jpg");
        
        mapPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (mapImage != null) {
                    g.drawImage(mapImage.getImage(), 0, 0, getWidth(), getHeight(), null);
                }
                
                if (point != null) {
                    g.setColor(Color.RED);
                    g.fillOval(point.x - 5, point.y - 5, 10, 10);
                }
            }
        };
        
        mapPanel.setFocusable(true);
        mapPanel.requestFocus();
        
        mapPanel.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseClicked(MouseEvent e) {
        		 int x = e.getX();
                 int y = e.getY();
                 point = new Point(x, y);
                 mapPanel.repaint(); 
                 System.out.println(point);
            }
        });
        
        mapPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int step = 5;
                
                if (keyCode == KeyEvent.VK_UP) {
                    point.y -= step;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    point.y += step;
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    point.x -= step;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    point.x += step;
                }
                mapPanel.repaint();
            }
        });
        
        validateButton = new JButton("Valider la position");
        validateButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (point != null) {
                    System.out.println("Position du point : x=" + point.x + ", y=" + point.y);
                }
        	}
        });
        
        JPanel controlPanel = new JPanel();
        controlPanel.add(validateButton);
        add(controlPanel, BorderLayout.NORTH);
        
        add(mapPanel);
        pack();
        setLocationRelativeTo(null);
		setSize(600, 600);
        setVisible(true);;
    }
    
    
    public static void main(String[] args) {
    	new MapWithPoints();
    }
}
