import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "projektNaukowy")
public class ProjektNaukowy extends Projekt {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    private String cel;
    private String zlozonosc;

    public ProjektNaukowy(){}

    public ProjektNaukowy(String nazwaProjektu ,String opisProjektu, String typ,
                          String cel,String zlozonosc){
        super(nazwaProjektu,opisProjektu,typ, new ArrayList<>());
        this.cel = cel;
        this.zlozonosc=zlozonosc;

    }
    public ProjektNaukowy(ProjektKomercyjny projektKomercyjny,
                          String cel,String zlozonosc){
        super(projektKomercyjny.getNazwaProjektu(), projektKomercyjny.getOpis(),
                projektKomercyjny.getTyp(), projektKomercyjny.getZadanieList());
        this.cel = cel;
        this.zlozonosc=zlozonosc;

    }

    //------------------------------------------------------------------------------


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
    @Basic
    public String getZlozonosc() {
        return zlozonosc;
    }

    public void setZlozonosc(String zlozonosc) {
        this.zlozonosc = zlozonosc;
    }
}
