import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyListModelZadania {
    private DefaultListModel lm;

    public MyListModelZadania() {
        lm = new DefaultListModel();
        List<String> stringOrders = new ArrayList<>();
        List<Zadanie> cList = Zadanie.showZadania();
        for (Zadanie x: cList) {
            stringOrders.add(x.toString());
        }
        int i = 0;
        for (Zadanie x:cList) {
            lm.add(i, x);
            i++;
            System.out.println(x);
        }

    }
    public ListModel getListModel() {
        return lm;
    }
}