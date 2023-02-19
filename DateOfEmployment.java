import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DateOfEmployment implements Serializable {
    int rok;
    int miesionc;
    int dzien;

    public DateOfEmployment(){}
    public DateOfEmployment(int rok,int miesionc,int dzien){
        this.rok=rok;
        this.miesionc=miesionc;
        this.dzien=dzien;
    }

    //-----------------------------------------------------------------

    @Basic
    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }
    @Basic
    public int getMiesionc() {
        return miesionc;
    }

    public void setMiesionc(int miesionc) {
        this.miesionc = miesionc;
    }
    @Basic
    public int getDzien() {
        return dzien;
    }

    public void setDzien(int dzien) {
        this.dzien = dzien;
    }
}
