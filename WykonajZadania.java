import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WykonajZadania {
    private JList ZadaniaList;
    private JButton WykonajButton;
    private JButton NextButton;
    private JTextField info;
    private JPanel WykonajPanel;
    private JTextField kamilJedrzejczykTextField;
    private JFrame zamknijOkno;

    public WykonajZadania(JFrame jf) {
        this.zamknijOkno = jf;
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Ocena Zadan");
                jFrame.setContentPane(new OcenaKlienta(jFrame).getOcenaPanel());
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                jFrame.setSize(800,800);
                jFrame.setVisible(true);
                zamknijOkno.dispose();
            }
        });
        WykonajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Zadanie.wykonajZadania();
                info.setText("Zadanie Wykonano");
            }
        });
    }

    public JPanel getWykonajPanel() {
        return WykonajPanel;
    }

    public void setWykonajPanel(JPanel wykonajPanel) {
        WykonajPanel = wykonajPanel;
    }

    private void createUIComponents() {
        MyListModelZadania mlm = new MyListModelZadania();
        this.ZadaniaList = new JList(mlm.getListModel());
        this.ZadaniaList.setCellRenderer(new DefaultListCellRenderer());
        this.ZadaniaList.setVisible(true);
    }
}
