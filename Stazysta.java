import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "stazysta")
public class Stazysta extends Osoba implements IStudent {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    private String nazwaUczelni;
    private double sredniaOcen;
    private int semestr;
    private String numerindeksu;

    public Stazysta(){}
    public Stazysta(String imie,String nazwisko,int rokUrodzenia,
                    String nazwaUczelni,int semestr,String numerindeksu){
        super(imie, nazwisko, rokUrodzenia);
        this.nazwaUczelni=nazwaUczelni;
        this.semestr=semestr;
        this.numerindeksu=numerindeksu;
    }
    @Override
    public void getInfo() {

    }
    //-------------------------------------------------------------------------------------------------------------------


    @Override
    public long getId() {
        return id;
    }
    @Basic
    public String getNazwaUczelni() {
        return nazwaUczelni;
    }
    @Basic
    public double getSredniaOcen() {
        return sredniaOcen;
    }
    @Basic
    public int getSemestr() {
        return semestr;
    }
    @Basic
    public String getNumerindeksu() {
        return numerindeksu;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public void setNazwaUczelni(String nazwaUczelni) {
        this.nazwaUczelni = nazwaUczelni;
    }

    public void setSredniaOcen(double sredniaOcen) {
        this.sredniaOcen = sredniaOcen;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }

    public void setNumerindeksu(String numerindeksu) {
        this.numerindeksu = numerindeksu;
    }

    @Override
    public void czyMaSwiadectwo() {

    }
}
