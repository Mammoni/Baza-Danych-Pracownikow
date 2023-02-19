import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OcenaKlienta {
    private JButton OkButton;
    private JButton NoButton;
    private JList ZadaniaList;
    private JPanel OcenaPanel;
    private JTextField info;
    private JFrame zamknijOkno;

    public OcenaKlienta(JFrame jf) {
        this.zamknijOkno =jf;
        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    info.setText("Dziękujemy za skorzystanie z naszych usług");
            }
        });
        NoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info.setText("Przykro nam z powodu pańskiego niezadowolenia ");
            }
        });
    }

    public JPanel getOcenaPanel() {
        return OcenaPanel;
    }

    private void createUIComponents() {
        MyListModelZadania mlm = new MyListModelZadania();
        this.ZadaniaList = new JList(mlm.getListModel());
        this.ZadaniaList.setCellRenderer(new DefaultListCellRenderer());
        this.ZadaniaList.setVisible(true);
    }
}
