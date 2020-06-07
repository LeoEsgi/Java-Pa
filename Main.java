import pa.PA;

import java.util.Scanner;
import java.awt. *;
import java.awt.event. *;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class Main extends Application {

    public static void main(String[] args) {

        JFrame fen = new JFrame("JAVA_PA"); // on créé une fenêtre
        fen.setSize(400 , 300); // on gére la taille de la fenêtre
        JPanel panel = new JPanel(); // on créé un panel
        fen.setContentPane(panel); // ajoute le panel a la fenêtre
        panel.setLayout(null);  // annule layout par défault pour pouvoir placer ses widget ou l'on souhaite
        JMenuBar MyMenuBar = new JMenuBar();  // créé une barre de menus
        panel.add(MyMenuBar); // ajoute la barre au panel
        MyMenuBar.setBounds(0, 0, 400,30);  // place la barre en haut à gauche de la fenêtre
        JMenu MenuAccount = new JMenu("Account");  // on créé un menu
        MyMenuBar.add(MenuAccount); // on ajoute le menu a la barre

        JMenuItem LogIn = new JMenuItem("Log In"); // créé un item de menu
        MenuAccount.add(LogIn); // ajoute l'item au menu
        JMenuItem LogOut = new JMenuItem("Log Out");
        MenuAccount.add(LogOut);
        JMenuItem Quit = new JMenuItem("Quit");
        MenuAccount.add(Quit);

        // créé l'action qui va être éxécuté
        Quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fen.dispose(); // quitter la fenêtre

            }
        });

        fen.setVisible(true); // affiche la fenêtre





    }
}

