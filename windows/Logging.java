package windows;

import database.AuthService;
import model.Account;
import model.WindowSize;

import java.awt.*;
import java.awt.event. *;
import javax.swing.*;

public class Logging extends JFrame implements ActionListener{

    private JTextField Email = new JTextField();
    private JTextField Password = new JTextField();
    private JButton Log = new JButton("Log");
    private JLabel Connexion = new JLabel("<html><font size=34 >Connexion</font></html>");
    private JLabel Message = new JLabel();


    public Logging(){

        super("Connexion"); // créé une fenêtre
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE); // permet de bien kill le process lorsque l'on ferme la fenêtre
        this.setSize(WindowSize.middle_width, WindowSize.middle_height); // on gére la taille de la fenêtre
        this.setResizable(false); // empêche l'utilisateur de resize la fenêtre
        this.setLocationRelativeTo(null); // centre la fenêtre par rapport au bureau

        JPanel panel = (JPanel) this.getContentPane(); // on récupère le container
        panel.setLayout(null);  // annule layout par défault pour pouvoir placer ses widget ou l'on souhaite


        // User Label
        JLabel EmailLabel = new JLabel();
        EmailLabel.setText("User Email :");

        // Password

        JLabel PasswordLabel = new JLabel();
        PasswordLabel.setText("Password :");


        Connexion.setBounds(360,80,300,50);
        panel.add(Connexion);
        EmailLabel.setBounds(220,180,80,30);
        panel.add(EmailLabel);
        Email.setBounds(300,180,300,30);
        panel.add(Email);
        PasswordLabel.setBounds(220,215,80,30);
        panel.add(PasswordLabel);
        Password.setBounds(300,215,300,30);
        panel.add(Password);
        Log.setBounds(300,250,300,50);
        Log.addActionListener(this);  // renvoie vers la fonction actionPerformed() lors du click
        panel.add(Log);
        Message.setBounds(300,300,300,50);
        panel.add(Message);

        this.setVisible(true);




    }

    public JMenuBar createMenuBar() {

        JMenuBar MyMenuBar = new JMenuBar();  // créé une barre de menus
        MyMenuBar.setBounds(0, 0, WindowSize.middle_width,30);  // place la barre en haut à gauche de la fenêtre
        JMenu MenuAccount = new JMenu("Account");  // on créé un menu
        MyMenuBar.add(MenuAccount); // on ajoute le menu a la barre

        JMenuItem LogIn = new JMenuItem("Log In"); // créé un item de menu
        MenuAccount.add(LogIn); // ajoute l'item au menu
        JMenuItem LogOut = new JMenuItem("Log Out");
        MenuAccount.add(LogOut);
        return MyMenuBar;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String email = Email.getText(); // récupère l'email
        String password = Password.getText(); // récupère le mdp
        System.out.println(" Email : " + email);
        System.out.println( " Password : " + password);
        if(!email.isEmpty() && !password.isEmpty()) {
            try {
                Account user = AuthService.GetUser(email, password);
                if(user != null){
                    this.dispose();
                    Home home = new Home(user);
                }
                else{
                    Message.setText("ACCOUNT NOT FOUND...");
                    Message.setForeground(Color.RED);
                }
               // this.dispose();
               // Home home = new Home();

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        else{
            Message.setText("PLEASE FILL THE TEXT FIELDS...");
            Message.setForeground(Color.RED);
        }


    }

}

