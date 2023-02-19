import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProject {
    private JPanel AddProjectPanel;
    private JTextField OpistextField;
    private JTextField NazwatextField;
    private JButton nextButton;
    private JButton zapiszButton;
    private JTextField TyptextField;
    private JTextField info;
    private JFrame zamknijOkno;


    public AddProject(JFrame jf) {
        this.zamknijOkno = jf;
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwaProjektu = NazwatextField.getText();
                String opis = OpistextField.getText();
                String typ = TyptextField.getText();
                if(!(nazwaProjektu.equals("")||nazwaProjektu.equals(null)||opis.equals("")||opis.equals(null)||opis.equals("")||opis.equals(null))){
                    Projekt.CreateNewProject(nazwaProjektu,opis,typ);
                    info.setText("Gotowe!");
                }else{
                    info.setText("Brakuje danych!");
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Panel kierownika");
                jFrame.setContentPane(new ZatwierdzenieProjektu(jFrame).getZatProPanel());
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                jFrame.setSize(800,800);
                jFrame.setVisible(true);
                zamknijOkno.dispose();
            }
        });
    }

    public JPanel getAddProjectPanel() {
        return AddProjectPanel;
    }

    public void setAddProjectPanel(JPanel addProjectPanel) {
        AddProjectPanel = addProjectPanel;
    }
}
