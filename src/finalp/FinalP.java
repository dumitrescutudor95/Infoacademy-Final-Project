package finalp;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class FinalP {

    //Splashul de inceput
    static FereastraStart intro;

    //Timer pentru asunderea splashului de inceput la momentul selectat
    private static Timer timerIntro = new Timer();
    private static TimerTask ascundeIntroul = new TimerTask() {
        public void run() {
            intro.setVisible(false);
        }
    };

    public static void main(String[] args) {
//Declararea agendei si a obiectului AdaugareContact
        Agenda a = new Agenda();
        AdaugaContact ac = new AdaugaContact(a);
        a.setAdaugaContact(ac);

        ac.setVisible(false);
        ac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Declararea frameului
        Frame fereastra = new Frame(a);
        fereastra.setVisible(true);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ac.setFrame(fereastra);

        //Initializarea ferestrei splash
        intro = new FereastraStart();
        intro.setVisible(true);
        //Si oprirea ei dupa o secunda si jumatate
        timerIntro.schedule(ascundeIntroul, 1500);
    }

}
