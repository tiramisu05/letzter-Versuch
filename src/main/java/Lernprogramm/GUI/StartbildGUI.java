package Lernprogramm.GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//irgendwelche hilfreichen Packages von Java
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame; //Top-Level-Container = unser Fenster
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Meike
 */
public class StartbildGUI extends JFrame {

    JPanel control = new JPanel(new BorderLayout());
    JLabel titel = new JLabel("Wer wird Bionik-Bachelor?");
    JButton logo = new JButton("Start");
    BackgroundPanel backgroundPanel = new BackgroundPanel();

    public StartbildGUI() {      //Unterklasse
        super("Startbild");
        setSize(800, 400);
        setLayout(new BorderLayout());

        add(control, BorderLayout.NORTH);
        control.add(titel, BorderLayout.NORTH);
        add(logo, BorderLayout.CENTER);
        logo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFrame();
            }

            private void showFrame() {
                //Fragenkarte();
            }

        });

        add(backgroundPanel, BorderLayout.SOUTH);
        setSize(backgroundPanel.getBackgroundImage().getWidth(backgroundPanel), backgroundPanel.getBackgroundImage().getHeight(backgroundPanel));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        var gui = new StartbildGUI();
    }
}
