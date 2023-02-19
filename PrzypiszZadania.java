import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrzypiszZadania {
    private JTextField opisTextField;
    private JButton przypiszZadanieButton;
    private JButton NextButton;
    private JTextField danePracownikaTextField;
    private JPanel PrzypiszZadaniePanel;
    private JFrame zamknijOkno;

    public PrzypiszZadania(JFrame jf) {
        this.zamknijOkno = jf;
        przypiszZadanieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opisZadania = opisTextField.getText();
                Zadanie.CreateNewZadanie(opisZadania);
            }
        });
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Panel Pracownika");
                jFrame.setContentPane(new WykonajZadania(jFrame).getWykonajPanel());
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                jFrame.setSize(800,800);
                jFrame.setVisible(true);
                zamknijOkno.dispose();
            }
        });
    }

    public JPanel getPrzypiszZadaniePanel() {
        return PrzypiszZadaniePanel;
    }

}
