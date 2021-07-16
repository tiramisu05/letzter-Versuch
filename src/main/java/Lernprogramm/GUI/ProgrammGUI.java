/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lernprogramm.GUI;

import Lernprogramm.Logik.Programm;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Meike
 */

public class ProgrammGUI extends JFrame {

    private Programm pprogramm;
    private QuestionManager _qManager;
    private int _questionIndex = 0;
    //Der _questionIndex gibt den Index der jeweiligen Frage an und wird hochgezählt.
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    //Auf diesen 4 Buttons werden die Antworten angezeigt.

    private JLabel _frageLabel;
    //Dieses Label bildet die Frage ab.

    private JLabel punkte;
    //Das Label "punkte" zeigt den aktuellen Punktestand. 
    private int richtig = 0;
    //Die Variable "richtig" bildet den aktuellen Punktestand ab. Für jede richtige
    //Antwort gibt es 1 Punkt.
    final int fragenanzahl = 10; 
    //In jedem Fragendurchlauf werden 10 Fragen abgerufen.
    private JButton weiter;
    //Der "weiter"-Button ruft die nächste Frage auf und aktualisiert den Punktestand.
    private JPanel sueden;
    //Im Panel sueden sind der Punktestand und der "weiter"-Button zusammengefasst.
    
    public ProgrammGUI(Programm programm, QuestionManager qManager) {
        super("Wer wird Bioniker?");
        //Mit super wird der JFrame aufgerufen und ein Titel gegeben.
        setSize(900, 600);
        //Dem JFrame wird eine festgelegte Größe zugewiesen.

        if (programm == null) {
            throw new NullPointerException("Programm darf nicht 'null' sein");
        }
        if (qManager == null) {
            throw new NullPointerException("Liste darf nicht 'null' sein");
        }
        //Mit dieser Exception wird sichergestellt, dass weder das Programm noch die Liste mit Fragen "null" sind.

        pprogramm = programm;
        _qManager = qManager;

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                pprogramm.schließen();
            }
        });
        //Wird dieser Frame per "x" geschlossen, wird das ganze Programm beendet.

       JPanel overcontent = new JPanel();
        overcontent.setLayout(new BorderLayout());
        add(overcontent);
        //Das Panel "overcontent" stellt einen Container zur Anordnung des Inhalts in einem weiteren Panel
        //im Bereich Center namens "content" dar.

        JPanel content = new JPanel();
        overcontent.add(content, BorderLayout.CENTER);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        //Das Panel content beinhaltet alle Komponenten des Hauptfensters angeordnet in einem BoxLayout entang der Y-Achse.

        JPanel fächerPanel = new JPanel();
        //Das fächerPanel fasst die Buttons zur Fächerauswahl zusammen.

        JButton chemie = new JButton("Chemie");
        chemie.setFont(new Font("Dubai", Font.PLAIN, 14));
        fächerPanel.add(chemie);
        //Der Button "chemie" ruft die Fragenliste für Chemie auf.
        //Der String hat eine Schriftart, -größe und einen Schriftstil bekommen.
        chemie.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ;//hier soll in die chemie Liste "geschaltet" werden
            }
    });
        
        JButton botanik = new JButton("Botanik");
        botanik.setFont(new Font("Dubai", Font.PLAIN, 14));
        fächerPanel.add(botanik);
        //Der Button "botanik" ruft die Fragenliste für Botanik auf.
        //Der String hat eine Schriftart, -größe und einen Schriftstil bekommen.
        botanik.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ;//hier soll in die botanik Liste "geschaltet" werden
            }
    });
        
        
        content.add(fächerPanel);
        //Das "fächerPanel" wird dem "content"-Panel zugefügt.
        
        JPanel frageP = new JPanel(new GridLayout(1, 1));
        content.add(frageP);
        //Dieses JPanel ordnet das "_frageLabel" in einem 1mal1 GridLayout an, sodass die Frage
        //sowohl in der Vertikalen als auch Horizontalen zentriert wird.
        
        _frageLabel = new JLabel("Hier steht die Frage", SwingConstants.CENTER);
        //SwingConstants ordnet den Text des Labels zentriert an.
        _frageLabel.setFont(new Font("Dubai", Font.PLAIN, 24));
        //Dem Fragentext wird eine Schriftart, -größe ud ein Schriftstil zugeordnet.
        frageP.add(_frageLabel);
        
        JPanel antworten = new JPanel();
        antworten.setLayout(new GridLayout(2, 2));
        content.add(antworten);
        //Das "antworten"-Panel ordnet die Antwort-Buttons in einem 4mal4 GridLayout an.
        

        //Die Buttons a1 bis a4 bilden jeweils eine mögliche Antwort ab, jedoch werden die
        //Antworten aus den csv-Dateien randomisiert angeordnet. Dies schließt aus,
        //dass immer der gleiche Button die richtige Antwort abbildet.
        a1 = new JButton("Antwort 1");
        a1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHandler(a1.getText());
//                if(Antwort richtig){
//                    a1.setBackground(Color.green);
//                    }else{
//                            a1.setBackground(Color.red);
//                            (button mit der richtigen Antwort).setBackground(Color.green);
//                            }
                a1.setEnabled(false);
                a2.setEnabled(false);
                a3.setEnabled(false);
                a4.setEnabled(false);
                
            }
        });
        
        //Wird ein Button gedrückt erscheint er bei der richtigen Antwort in grün. Wenn der gedrückte Button eine
        //falsche Antwort enthält wird er rot und der Button mit der richtigen ANtwort wird grün.
        //Nach jedem Druck eines Buttons werden alle Buttons deaktiviert, damit nicht mehrfach die richtige oder
        //falsche Antwort geklickt werden kann. Dies würde zu einem falschen Punktestand führen.

        a2 = new JButton("Antwort 2");
        a2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHandler(a2.getText());
//                if(Antwort richtig){
//                    a2.setBackground(Color.green);
//                    }else{
//                            a2.setBackground(Color.red);
//                            (button mit der richtigen Antwort).setBackground(Color.green);
//                            }
                a1.setEnabled(false);
                a2.setEnabled(false);
                a3.setEnabled(false);
                a4.setEnabled(false);
            }
        });

        a3 = new JButton("Antwort 3");
        a3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHandler(a3.getText());
//                if(Antwort richtig){
//                    a3.setBackground(Color.green);
//                    }else{
//                            a3.setBackground(Color.red);
//                            (button mit der richtigen Antwort).setBackground(Color.green);
//                            }
                a1.setEnabled(false);
                a2.setEnabled(false);
                a3.setEnabled(false);
                a4.setEnabled(false);
            }
        });

        a4 = new JButton("Antwort 4");
        a4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHandler(a4.getText());
//                if(Antwort richtig){
//                    a4.setBackground(Color.green);
//                    }else{
//                            a4.setBackground(Color.red);
//                            (button mit der richtigen Antwort).setBackground(Color.green);
//                            }
                a1.setEnabled(false);
                a2.setEnabled(false);
                a3.setEnabled(false);
                a4.setEnabled(false);
            }
        });

        antworten.add(a1);
        antworten.add(a2);
        antworten.add(a3);
        antworten.add(a4);

        sueden = new JPanel();
        content.add(sueden);
        //"sueden" beinhaltet den Punktestand und den "weiter"-Button.
        
        punkte = new JLabel(richtig + " / " + fragenanzahl + " P.");
        punkte.setFont(new Font("Castellar", Font.BOLD, 20));
        sueden.add(punkte);
        //Dem Punktelabel wird eine Schriftgröße, -art und ein Schriftstil zugeordnet.
        //Die Anzeige der Variable "richtig" wird mit dem Druck des "weiter"-Buttons aktualisiert.
        //Der Punkt wird in der Methode buttonHandler draufgezählt.
        
        weiter = new JButton("nächste Frage");
        weiter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateView();
                
                a1.setEnabled(true);
                a2.setEnabled(true);
                a3.setEnabled(true);
                a4.setEnabled(true);
                
                punkte.setText(richtig + " / " + fragenanzahl + " P.");
            }
        });
        //Der "weiter"-Button aktualisiert mit der updateView()-Methode die Anzeige der nächsten Frage und den Punktestand.
        //Die Buttons werden wieder aktiviert.
        sueden.add(weiter);
        
        setLocationRelativeTo(null);
        //Der JFrame der gesamten Benutzeroberfläche wird mittig auf dem Bildschirm angezeigt.
        setVisible(true);
        //Das Fenster wird sichtbar gemacht.
    }

    private void buttonHandler(String buttonText) {

        if (_qManager.getCurrentQuestion(_questionIndex).isCorrectAnswer(buttonText)) {
            System.out.println("CorrectAnswer!!");
             richtig++;
             //Ist die ausgewählte Antwort richtig wird der String auf der Konsole ausgegeben und die "richtig" Varible eins hochgezählt(der Punktestand).
        } else {
            System.out.println("Wrong Answer!!");
            //Ist die Antwort falsch wird dieser String in der Konsole ausgegeben.

        }

        _qManager.getAndLoadNextQuestion();
        
    }





    private void updateView() {

        Frage currFrage = _qManager.getCurrentQuestion();

        if (currFrage == null) {
            System.out.println("Keine weiteren Fragen");
            _frageLabel.setText("DONE.. No more Questions");
        } else {

            List<String> answ = currFrage.getAnswers();

            if (answ.size() != 4) {
                throw new IllegalArgumentException("Size diff");
            }

            a1.setText(answ.get(0));
            a2.setText(answ.get(1));
            a3.setText(answ.get(2));
            a4.setText(answ.get(3));

            _frageLabel.setText(currFrage.getQuestion());
            
            
        }
        
            a1.setBackground(null);
            a2.setBackground(null);
            a3.setBackground(null);
            a4.setBackground(null);
            //Der Hintergrund der Buttons wird wieder auf default(grau) gesetzt nachdem einige Buttons grün oder rot waren.
    }

}