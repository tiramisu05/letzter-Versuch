/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lernprogramm.GUI;

import Lernprogramm.Logik.Programm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Meike/Arjun
 */
public class ProgrammGUI extends JFrame {

    private Programm pprogramm;
    private QuestionManager _qManager;
    private QuestionManager _qManagerInaktiv;
    private int _questionIndex = 0;
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private List<JButton> _Buttonliste;
    private JLabel _frageLabel;

    private JLabel punkte;
    private int richtig = 0;
    final int fragenanzahl = 10;
    private JButton weiter;
    private JPanel sueden;

    public ProgrammGUI(Programm programm, QuestionManager qManagerBotanik, QuestionManager qManagerChemie) {
        super("Wer wird Bionik-Bachelor?");
        setSize(800, 600);
        setLayout(new BorderLayout());

        _qManager = qManagerBotanik;
        _qManagerInaktiv = qManagerChemie;

        if (programm == null) {
            throw new NullPointerException("Programm darf nicht 'null' sein");
        }
        if (_qManager == null) {
            throw new NullPointerException("Liste darf nicht 'null' sein");
        }

        _Buttonliste = new ArrayList<JButton>();

        pprogramm = programm;

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                pprogramm.schließen();
            }
        });

        JPanel overcontent = new JPanel();
        overcontent.setLayout(new BorderLayout());
        add(overcontent);

        JPanel content = new JPanel();
        overcontent.add(content, BorderLayout.CENTER);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JPanel fächerPanel = new JPanel();

        JButton chemie = new JButton("Chemie");
        JButton botanik = new JButton("Botanik");
        chemie.setFont(new Font("Dubai", Font.PLAIN, 14));
        fächerPanel.add(chemie);
        chemie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _qManager = qManagerChemie;
                chemie.setBackground(Color.green);
                botanik.setEnabled(false);

            }
        });

        botanik.setFont(new Font("Dubai", Font.PLAIN, 14));
        fächerPanel.add(botanik);
        botanik.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _qManager = qManagerBotanik;
                botanik.setBackground(Color.green);
                chemie.setEnabled(false);
            }
        });

        content.add(fächerPanel);

        JPanel frageP = new JPanel(new GridLayout(1, 1));
        content.add(frageP);

        _frageLabel = new JLabel("Wähle die Kategorie aus um das Quiz zu starten", SwingConstants.CENTER);
        _frageLabel.setFont(new Font("Dubai", Font.PLAIN, 24));
        frageP.add(_frageLabel);

        JPanel antworten = new JPanel();
        antworten.setLayout(new GridLayout(2, 2));
        content.add(antworten);

        a1 = new JButton("Antwort 1");
        a1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHandler(a1.getText());
//                if(Frage richtig){
//                    (button mit der richtigen Antwort).setBackground(Color.green);
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

        _Buttonliste.add(a1);

        a2 = new JButton("Antwort 2");
        a2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHandler(a2.getText());
//                if(Frage richtig){
//                    a2.setBackground(Color.green);
//                    }//else{
//                            a2.setBackground(Color.red);
//                            (button mit der richtigen Antwort).setBackground(Color.green);
//                            }
                a1.setEnabled(false);
                a2.setEnabled(false);
                a3.setEnabled(false);
                a4.setEnabled(false);
            }
        });

        _Buttonliste.add(a2);

        a3 = new JButton("Antwort 3");
        a3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHandler(a3.getText());
//                if(Frage richtig){
//                    (button mit der richtigen Antwort).setBackground(Color.green);
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

        _Buttonliste.add(a3);

        a4 = new JButton("Antwort 4");
        a4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonHandler(a4.getText());
//                if(Frage richtig){
//                    (button mit der richtigen Antwort).setBackground(Color.green);
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

        _Buttonliste.add(a4); //Add Button to Buttonlist

        antworten.add(a1);
        antworten.add(a2);
        antworten.add(a3);
        antworten.add(a4);

        sueden = new JPanel();
        content.add(sueden);

        punkte = new JLabel(richtig + " / " + fragenanzahl + " P.");
        punkte.setFont(new Font("Castellar", Font.BOLD, 20));
        sueden.add(punkte);

        weiter = new JButton("nächste Frage");
        weiter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a1.setEnabled(true);
                a2.setEnabled(true);
                a3.setEnabled(true);
                a4.setEnabled(true);

                updateView();

                punkte.setText(richtig + " / " + fragenanzahl + " P.");
            }
        });
        sueden.add(weiter);

        setLocationRelativeTo(null);
        setVisible(true);

        for (JButton button : _Buttonliste) {
            button.setEnabled(false);
        }
    }

    private void buttonHandler(String buttonText) {

        if (_qManager.getCurrentQuestion().isCorrectAnswer(buttonText)) {
            System.out.println("CorrectAnswer!!");

            for (JButton buttons : _Buttonliste) {

                if (buttons.getText().equalsIgnoreCase(buttonText)) {
                    buttons.setBackground(Color.green);
                }

            }
            richtig++;
            // TODO Counter counting usw...
        } else {
            for (JButton button : _Buttonliste) {
                if (button.getText().equalsIgnoreCase(buttonText)) {
                    button.setBackground(Color.red);

                }
                if (_qManager.getCurrentQuestion().isCorrectAnswer(button.getText())) {
                    button.setBackground(Color.green);

                }

            }

            System.out.println("Wrong Answer!!");

        }

        _qManager.getAndLoadNextQuestion();

    }

    private void updateView() {

        Frage currFrage = _qManager.getCurrentQuestion();

        if (currFrage == null) {
            System.out.println("Keine weiteren Fragen");
            _frageLabel.setText("Du hast " + richtig + " von " + fragenanzahl + " Punkten erreicht.");
            for (JButton button : _Buttonliste) {
                button.setEnabled(false);

            }
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
    }

}
