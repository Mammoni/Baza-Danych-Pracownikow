import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DodajKlienta {
    private JPanel MainPanel;
    private JPanel TopPanel;
    private JPanel BottomPanel;
    private JTextField textFieldImie;
    private JTextField textFieldEmail;
    private JTextField textFieldAdres;
    private JButton ZapiszButton;
    private JButton Dalejbutton;
    private JTextField info;
    private JFrame zamknijOkno;

    public DodajKlienta(JFrame jf) {
        this.zamknijOkno = jf;
        ZapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imieKlienta = textFieldImie.getText();
                String email = textFieldEmail.getText();
                String adres = textFieldAdres.getText();
                if(!(imieKlienta.equals("")||imieKlienta.equals(null)||adres.equals("")||adres.equals(null)||email.equals("")||email.equals(null))){
                    Klient.CreateNewKlient(imieKlienta,email,adres);
                    info.setText("Gotowe!");
                }else{
                    info.setText("Podaj dane!");
                }


            }
        });
        Dalejbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Dodaj Projekt");
                jFrame.setContentPane(new AddProject(jFrame).getAddProjectPanel());
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                jFrame.setSize(800,800);
                jFrame.setVisible(true);
                zamknijOkno.dispose();
            }
        });
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        MainPanel = mainPanel;
    }

    public JPanel getTopPanel() {
        return TopPanel;
    }

    public void setTopPanel(JPanel topPanel) {
        TopPanel = topPanel;
    }

    public JPanel getBottomPanel() {
        return BottomPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        BottomPanel = bottomPanel;
    }
}

