package windows;

import model.WindowSize;

import javax.swing.*;

public class MenuCreate extends JFrame {


    public MenuCreate() {
        super("Menu Create");
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE); // permet de bien kill le process lorsque l'on ferme la fenêtre
        this.setSize(WindowSize.small_width , WindowSize.small_height); // on gére la taille de la fenêtre
        this.setResizable(false); // empêche l'utilisateur de resize la fenêtre
        this.setLocationRelativeTo(null); // centre la fenêtre par rapport au bureau
        this.setVisible(true);
    }

}
