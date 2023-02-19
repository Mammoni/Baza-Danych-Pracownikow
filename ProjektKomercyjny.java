import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "projektKomercyjny")
public class ProjektKomercyjny extends Projekt{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    private double dochodoczekiwany;

    public ProjektKomercyjny(){}
    public ProjektKomercyjny(String nazwaProjektu ,String opisProjektu, String typ,
                             double dochodoczekiwany){
        super(nazwaProjektu,opisProjektu,typ, new ArrayList<>());
        this.dochodoczekiwany = dochodoczekiwany;
    }
    public ProjektKomercyjny(ProjektNaukowy projektNaukowy,double dochodoczekiwany){
        super(projektNaukowy.getNazwaProjektu(),
                projektNaukowy.getOpis(), projektNaukowy.getTyp(),projektNaukowy.getZadanieList());
        this.dochodoczekiwany =dochodoczekiwany;

    }

    //--------------------------------------------------------------------------------------


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public double getDochodoczekiwany() {
        return dochodoczekiwany;
    }

    public void setDochodoczekiwany(double dochodoczekiwany) {
        this.dochodoczekiwany = dochodoczekiwany;
    }
}
