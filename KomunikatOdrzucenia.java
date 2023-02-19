import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KomunikatOdrzucenia {
    private JPanel MessPanel;
    private JPanel TopPanel;
    private JPanel BottomPanel;
    private JButton ExitBotton;
    private JFrame zamknijOkno;

    public KomunikatOdrzucenia(JFrame jf) {
        this.zamknijOkno =jf;
        ExitBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zamknijOkno.dispose();
            }
        });
    }

    public JPanel getMessPanel() {
        return MessPanel;
    }
}
