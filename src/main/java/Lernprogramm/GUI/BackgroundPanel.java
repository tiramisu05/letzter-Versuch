package Lernprogramm.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meike
 */


class BackgroundPanel extends JPanel {
        
        private static final long serialVersionUID = 1L;
	private Image img;

	public BackgroundPanel() {
            
            try {
            img = ImageIO.read(new File("Bild700.jpg"));
            } catch (IOException ex) {
            System.out.println("Bild konnte nicht geladen werden");
            }
        }
        
        
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
        }

	public Image getBackgroundImage() {
		return img;
	}


}