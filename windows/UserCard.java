package windows;

import model.WindowSize;

import javax.swing.*;
import java.awt.*;

public class UserCard extends JFrame {

    public static int width = 1400; // largeur de la fenêtre
    public static int height = 800; // taille de la fenêtre

    public UserCard(){
        super("User Card");
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE); // permet de bien kill le process lorsque l'on ferme la fenêtre
        this.setSize(WindowSize.small_width , WindowSize.small_height); // on gére la taille de la fenêtre
        this.setResizable(false); // empêche l'utilisateur de resize la fenêtre
        this.setLocationRelativeTo(null); // centre la fenêtre par rapport au bureau
        this.setVisible(true);
    }
}
