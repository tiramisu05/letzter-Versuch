package Lernprogramm.Logik;

import Lernprogramm.GUI.ProgrammGUI;
import Lernprogramm.GUI.QuestionManager;

/**
 *
 * @author Meike
 */
public class Programm { //Äquivalent zu class Addressbook

    private ProgrammGUI pprogrammGUI;

    public Programm() {

        QuestionManager qManagerBotanik = new QuestionManager("res/FragenBotanik.csv");
        QuestionManager qManagerChemie = new QuestionManager("res/FragenChemie.csv");

        pprogrammGUI = new ProgrammGUI(this, qManagerBotanik, qManagerChemie);

    }

    public void schließen() {
        pprogrammGUI.dispose();
    }

}
