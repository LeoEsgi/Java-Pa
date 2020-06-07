package windows;

import model.WindowSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame  {


    private JButton Create = new JButton("Create Menu");
    private JButton Remove = new JButton("Remove Menu");
    private JButton Change = new JButton("Change Menu");
    private JButton Card = new JButton("Point Card");

    public Home(){
        super("Home");
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE); // permet de bien kill le process lorsque l'on ferme la fenêtre
        this.setSize(WindowSize.big_width, WindowSize.big_height); // on gére la taille de la fenêtre
        this.setResizable(false); // empêche l'utilisateur de resize la fenêtre
        this.setLocationRelativeTo(null); // centre la fenêtre par rapport au bureau

        JPanel panel = (JPanel) this.getContentPane(); // on récupère le container
        panel.setLayout(new GridLayout(2,2,10,10));  // place les items dans une grid

        Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCreate mc = new MenuCreate();
            }
        });
        panel.add(Create);
        Remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuRemove mr = new MenuRemove();
            }
        });
        panel.add(Remove);
        Change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuChange mc = new MenuChange();
            }
        });
        panel.add(Change);
        Card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCard uc = new UserCard();
            }
        });
        panel.add(Card);



        this.setVisible(true);


    }

}


