package Lernprogramm.GUI;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arjun Büsing
 */
public class Frage {

    private final String _fragestellung;
    private final List<String> _antworten;
    private final String _richtigeAntwort;

    public Frage(String[] fullQuestion) {
        _fragestellung = fullQuestion[0];
        _antworten = new ArrayList<String>();
        _richtigeAntwort = fullQuestion[fullQuestion.length - 1];

        for (int i = 1; i < fullQuestion.length; i++) {
            _antworten.add(fullQuestion[i]);
        }
        Collections.shuffle(_antworten); //Antworten in zufälliger reihenfolge

    }


    public boolean isCorrectAnswer(String answer){
        return answer.equalsIgnoreCase(_richtigeAntwort);
    }

    public List<String> getAnswers(){
        return _antworten;
    }


    public void PrintoutQuestion() {
        System.out.println("____________________________");
        System.out.println("Frage: "+_fragestellung);
        Iterator<String> it = _antworten.iterator();
        while (it.hasNext()) {
            System.out.println("Antwort: "+it.next());
        }

    }


    public String getQuestion() {
        return _fragestellung;
    }

}
