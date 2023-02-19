import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Osoba")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Osoba {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    private String imie;
    private String nazwisko;
    private int rokUrodzenia;

    public Osoba(){}
    public Osoba(String imie,String nazwisko,int rokUrodzenia){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia= rokUrodzenia;
    }

    public abstract  void getInfo();

    //---------------------------------------------------------------------------------------------------------------------
    @Basic
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
    @Basic
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    @Basic
    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public void setRokUrodzenia(int rokUrodzenia) {
        this.rokUrodzenia = rokUrodzenia;
    }
}

