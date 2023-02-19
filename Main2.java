import javax.swing.*;

public class Main2 {
   public static void main(String[]args)throws Exception{



        JFrame jFrame = new JFrame("Dodaj Klienta");
        jFrame.setContentPane(new DodajKlienta(jFrame).getMainPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(800,800);
        jFrame.setVisible(true);






   }
}
