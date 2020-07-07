import windows.Logging;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;



public class Main {


    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel( new NimbusLookAndFeel()); // on applique un look

        Logging app = new Logging();





    }
}
