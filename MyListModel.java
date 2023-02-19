import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyListModel {
    private DefaultListModel lm;

    public MyListModel() {
        lm = new DefaultListModel();
        List<String> stringOrders = new ArrayList<>();
        List<Projekt> cList = Projekt.showProjects();
        for (Projekt x: cList) {
            stringOrders.add(x.toString());
        }
        int i = 0;
        for (Projekt x:cList) {
            lm.add(i, x);
            i++;
            System.out.println(x);
        }

    }
    public ListModel getListModel() {
        return lm;
    }
}