package Startbild;

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
//Diese Klasse ist nur ein von JPanel erbender Container, mit der Aufgabe ein Bild darzustellen.

class BackgroundPanel extends JPanel {
        //Die Klasse erbt von der Swing Komponente JPanel.
	private Image img;
        //Die Variable img
        
	public BackgroundPanel() {
            
            try {
            img = ImageIO.read(new File("Bild700.jpg"));
            //"ImageIO" liest die Datei ein. Bei uns liegt das Bild im Projektordner.
            } catch (IOException ex) {
            System.out.println("Bild konnte nicht geladen werden");
            //Kann das Bild nicht geladen werden, wird diese Exception geworfen.
            }
        }
        
        
        //Die Methode paintComponent des Graphics-Pakets wird überschrieben.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
                //Das JPanel wird aufgerufen und die Grafik "g" darin gezeichnet.
                
		g.drawImage(img, 0, 0, this);
                //Die Grafik "g" zeichnet uns unser Bild.
        }
        
        //Diese Methode gibt mit der Variable "img" das Hintergrundbild zurück.
	public Image getBackgroundImage() {
		return img;
	}


}