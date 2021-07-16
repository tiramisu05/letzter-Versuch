package Startbild;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//irgendwelche hilfreichen Packages von Java

import Lernprogramm.Logik.Programm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame; //Top-Level-Container = unser Fenster
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



/**
 *
 * @author Meike
 */

//StartbildGUI ist eine Klasse, die verwendet wird um einen Startbildschirm (JFrame) zu erzeugen.
//Dieser JFrame enthält einen Titel, ein Bild und einen Button der uns ins Hauptfenster bringt, wo
//das Quizprogramm stattfindet.

//Das Startbild erbt von der Swing Komponente "JFrame".
public class StartbildGUI extends JFrame {
    
    private BackgroundPanel backgroundPanel = new BackgroundPanel();
    //Das BackgrounPanel blendet das Titelbild ein.
    private JLabel titel = new JLabel("Wer wird Bioniker?", SwingConstants.CENTER);
    //Das "titel"-Label enthält die Überschrift vom Startbildschirm.
    //Der String wird mittig im Label platziert.
    private JButton startbut = new JButton("Start");
    //Der "Start"-Button bringt uns später in das Hauptfenster.
        
    
public StartbildGUI(){      //Unterklasse
        super();
        //super ruft die Oberklasse JFrame auf
        setLayout(new BorderLayout());
        //Der JFrame bekommt ein BorderLayout. Davon werden Norden, Center und Süden verwendet.
        
        titel.setFont(new Font( "Castellar", Font.PLAIN, 26));
        //Der Überschrift werden eine Schriftart, -größe und ein Schriftstil zugeordnet.
        //Die verwendete Schrift muss auf dem Computer installiert sein.
        add(titel, BorderLayout.NORTH);
        //Im Norden des BorderLayouts liegt die Überschrift.
        
        add(backgroundPanel, BorderLayout.CENTER);
        //Das Bild (im backgroundPanel) wird mittig platziert.
        setSize(backgroundPanel.getBackgroundImage().getWidth(backgroundPanel)+15, 350);
        //Das Fenster wird auf eine passende Größe skaliert, damit alle Komponenten genug Platz haben.
        //Die Breite wird vom Bild übernommen und der Rand mit einberechnet.
        //pack() wird nicht verwendet, da das backgroundPanel dort überdeckt wird.
        
        add(startbut, BorderLayout.SOUTH);
        //Der Button liegt unter dem Bild im Süden.
        startbut.setFont(new Font( "Dubai", Font.PLAIN, 20));
        //Dem String auf dem Button wird eine Schriftart, -größe und ein Schriftstil zugeordnet.
        startbut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Programm();
                dispose();
            }
            });
        //Wird der Button gedrückt wird eine neue Instanz der Klasse Programm erzeugt und das Startfenster geschlossen.
        //Die Instanz Programm hat die Funktion die Benutzeroberfläche und die Verwaltung der Fragen
        //(Klasse QuestionManager) zu starten.
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Wird das Fenster oben rechts geschlossen, ist das ganze Programm beendet.
        setLocationRelativeTo(null);
        //Das Fenster erscheint mittig auf dem Bildschirm.
        setVisible(true);
        //Das Fenster wird auf "sichtbar" gesetzt.
        
    }

        
 //Dies ist die einzige Main-Methode des gesamten Programms. Als erstes wird eine Instanz "StartbildGUI" erzeugt,
//aus welcher über den Druck des Buttons das wesentliche "Programm" mit der Benutzeroberfläche("ProgrammGUI") gestartet wird.
    public static void main(String[] args) {
        new StartbildGUI();
    }
}
