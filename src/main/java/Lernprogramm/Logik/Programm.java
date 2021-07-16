package Lernprogramm.Logik;

import Lernprogramm.GUI.ProgrammGUI;
import Lernprogramm.GUI.QuestionManager;

/**
 *
 * @author Meike
 */

//Die "Programm"-Klasse startet die Benutzeroberfläche und den QuestionManager (Verwaltung der Fragen).

public class Programm {

    private ProgrammGUI pprogrammGUI;

    public Programm() {

        QuestionManager qManager = new QuestionManager();
        //Die Instanz qManager wird erzeugt und damit sozusagen die Logik des Programms gestartet.
        pprogrammGUI = new ProgrammGUI(this, qManager);
        //Die Instanz pprogrammGUI wird erzeugt und damit eine grafische Benutzeroberfläche gestartet.
    }

    //Wird diese Methode aufgerufen, schließt sich die grafische Oberfläche.
    public void schließen() {
        pprogrammGUI.dispose();
    }

}
