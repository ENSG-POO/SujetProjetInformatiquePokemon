package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MapPanel extends JPanel {

    private static Point point;
    private JButton validButton;
    private Image mapImage;
    

    public MapPanel() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
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
                repaint();
            }
        });

        validButton = new JButton("Valider");
        validButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (point != null) {
                    System.out.println("Position du point : x=" + point.x + ", y=" + point.y);
                    requestFocusInWindow();
                }
            }
        });
        
        try {
            mapImage = ImageIO.read(new File("../images/carte_pokemon.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel controlPanel = new JPanel();
        controlPanel.add(validButton);
        add(controlPanel, BorderLayout.NORTH);
       
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                point = new Point(x, y);
                repaint();
            }
        });

        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (mapImage != null) {
        	g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);
        }

        if (point != null) {
            g.setColor(Color.RED);
            g.fillOval(point.x - 5, point.y - 5, 10, 10);
        }
    }
}
