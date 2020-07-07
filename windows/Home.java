package windows;

import database.AuthService;
import model.Account;
import model.WindowSize;
import services.PointService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Home extends JFrame implements ActionListener {


    private Account User = new Account();
    private JButton Card = new JButton("Give Point to friend");
    private JComboBox listUser = new JComboBox();
    private JSpinner spinner = new JSpinner();



    public Home(Account user) throws Exception {
        super("Home");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // permet de bien kill le process lorsque l'on ferme la fenêtre
        this.setSize(WindowSize.big_width, WindowSize.big_height); // on gére la taille de la fenêtre
        this.setResizable(false); // empêche l'utilisateur de resize la fenêtre
        this.setLocationRelativeTo(null); // centre la fenêtre par rapport au bureau

        JPanel panel = (JPanel) this.getContentPane(); // on récupère le container
        panel.setLayout(null);

        User = user;


        SpinnerModel model = new SpinnerNumberModel(1, 1, user.getPoints(), 1);

        spinner.setModel(model);

        spinner.setBounds(20,80,300,50);
        panel.add(spinner);



        Account[] users = Objects.requireNonNull(AuthService.GetAllUser()).toArray(new Account[0]);



        for (Account account : users) {
            if (account.getId() != user.getId())
                listUser.addItem(account.getId() + " - " + account.getFirstname() + " " + account.getLastname());
        }
        listUser.setBounds(20,135,300,50);
        panel.add(listUser);
        Card.setBounds(20,200,300,50);
        Card.addActionListener((ActionListener) this);
        panel.add(Card);


        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object number = spinner.getValue();
        Object UserTo = listUser.getSelectedItem();
        System.out.println(" number : " + number + " User : " + UserTo);
        if (number != null && UserTo != null) {

           PointService PS = new PointService();
            try {
                PS.UpdatePoint(User.getId() , Integer.parseInt(String.valueOf(UserTo.toString().charAt(0))), Integer.parseInt(number.toString()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }


    }
}


