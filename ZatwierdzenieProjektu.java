import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class ZatwierdzenieProjektu {
    private JPanel TopPanel;
    private JPanel BottomPanel;
    private JPanel ZatProPanel;
    private JButton NoButton;
    private JButton YesButton;
    private JList ostatniProjektList;
    private JFrame zamknijOkno;
    List<Projekt> cList = Projekt.showProjects();
    Projekt projekt = cList.get(0);

    public ZatwierdzenieProjektu(JFrame jf) {
        this.zamknijOkno =jf;
        NoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Wiadomosc");
                jFrame.setContentPane(new KomunikatOdrzucenia(jFrame).getMessPanel());
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                jFrame.setSize(800,800);
                jFrame.setVisible(true);
                zamknijOkno.dispose();
            }
        });
        YesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Panel Kierownika");
                jFrame.setContentPane(new PrzypiszZadania(jFrame).getPrzypiszZadaniePanel());
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                jFrame.setSize(800,800);
                jFrame.setVisible(true);
                zamknijOkno.dispose();
            }

        });

        ostatniProjektList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ostatniProjektList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                        Projekt c = (Projekt) ostatniProjektList.getSelectedValue();
                    System.out.println(c.toString());
                    projekt = c;
                }
            }
        });

    }

    public JPanel getZatProPanel() {
        return ZatProPanel;
    }

    public void setZatProPanel(JPanel zatProPanel) {
        ZatProPanel = zatProPanel;
    }




    private void createUIComponents() {
        MyListModel mlm = new MyListModel();
        this.ostatniProjektList = new JList(mlm.getListModel());
        this.ostatniProjektList.setCellRenderer(new DefaultListCellRenderer());
        this.ostatniProjektList.setVisible(true);

    }


}
