import org.hibernate.annotations.GenericGenerator;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity(name = "pracownik")
public class Pracownik extends Osoba implements Serializable {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    private int idPracownika;
    private String adres;
    private double wyplata;
    private DateOfEmployment dateOfEmplyment;
    private Double bonus;
    @ElementCollection
    private List<String> jezyki;
    private static double minimalSalary = 2000.0;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Dzial dzial; // Pracownik"1" --- "*"Dzial
    @OneToMany(mappedBy = "pracownik", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zadanie> zadaniaList; // Asocjacja z atrybutem Pracownik -- Zadanie -- Projekt

    //Pola dla Programisty
    private String jezykProgramowania;
    private int dosJakoProgramista;
    //Pola dla analityka
    private String dosJakoAnalityk;
    private String stawki;


    public Pracownik(){}
    public Pracownik(int idPracownika,String imie, String nazwisko,
                     String adres,double wyplata, int rokUrodzenia,
                     DateOfEmployment dateOfEmplyment, Double bonus, List<String> jezyki,
                     Dzial dzial, ArrayList<Zadanie> zadaniaList){
        super(imie, nazwisko, rokUrodzenia);
        this.idPracownika =idPracownika;
        this.adres=adres;
        this.wyplata = wyplata;
        this.dateOfEmplyment =dateOfEmplyment;
        this.bonus =bonus;
        this.jezyki = jezyki;
        this.dzial = dzial;
        this.zadaniaList = zadaniaList;
    }

    //Programista
    public Pracownik(int idPracownika,String imie, String nazwisko,
                     String adres,double wyplata, int rokUrodzenia,
                     DateOfEmployment dateOfEmplyment, Double bonus, List<String> jezyki,
                     Dzial dzial, ArrayList<Zadanie> zadaniaList,
                     String jezykProgramowania,int dosJakoProgramista){
        super(imie, nazwisko, rokUrodzenia);
        this.idPracownika =idPracownika;
        this.adres=adres;
        this.wyplata = wyplata;
        this.dateOfEmplyment =dateOfEmplyment;
        this.bonus =bonus;
        this.jezyki = jezyki;
        this.dzial = dzial;
        this.zadaniaList = zadaniaList;
        this.jezykProgramowania = jezykProgramowania;
        this.dosJakoProgramista = dosJakoProgramista;
    }

    //Analityk
    public Pracownik(int idPracownika,String imie, String nazwisko,
                     String adres,double wyplata, int rokUrodzenia,
                     DateOfEmployment dateOfEmplyment, Double bonus, List<String> jezyki,
                     Dzial dzial, ArrayList<Zadanie> zadaniaList,
                         String stawki,String dosJakoAnalityk){
        super(imie, nazwisko, rokUrodzenia);
        this.idPracownika =idPracownika;
        this.adres=adres;
        this.wyplata = wyplata;
        this.dateOfEmplyment =dateOfEmplyment;
        this.bonus =bonus;
        this.jezyki = jezyki;
        this.dzial = dzial;
        this.zadaniaList = zadaniaList;
        this.stawki = stawki;
        this.dosJakoAnalityk = dosJakoAnalityk;
    }

    //Programista-Analityk
    public Pracownik(int idPracownika,String imie, String nazwisko,
                     String adres,double wyplata, int rokUrodzenia,
                     DateOfEmployment dateOfEmplyment, Double bonus, List<String> jezyki,
                     Dzial dzial, ArrayList<Zadanie> zadaniaList,
                     String stawki,String dosJakoAnalityk,
                     String jezykProgramowania, int dosJakoProgramista){
        super(imie, nazwisko, rokUrodzenia);
        this.idPracownika =idPracownika;
        this.adres=adres;
        this.wyplata = wyplata;
        this.dateOfEmplyment =dateOfEmplyment;
        this.bonus =bonus;
        this.jezyki = jezyki;
        this.dzial = dzial;
        this.zadaniaList = zadaniaList;
        this.stawki = stawki;
        this.dosJakoAnalityk = dosJakoAnalityk;
        this.jezykProgramowania = jezykProgramowania;
        this.dosJakoProgramista = dosJakoProgramista;
    }
    @Override
    public void getInfo() {
        System.out.println(super.getImie() +" "+super.getNazwisko()+" "+this.adres+" "+this.bonus);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + idPracownika +
                ", firstName='" + super.getImie() + '\'' +
                ", sureName='" + super.getNazwisko() + '\''+
                ", department=" + dzial.getNazwaDzialu();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public int getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(int idPracownika) {
        this.idPracownika = idPracownika;
    }
    @Basic
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    @Basic
    public double getWyplata() {
        return wyplata;
    }

    public void setWyplata(double wyplata) {
        this.wyplata = wyplata;
    }
    @Embedded
    public DateOfEmployment getDateOfEmplyment() {
        return dateOfEmplyment;
    }

    public void setDateOfEmplyment(DateOfEmployment dateOfEmplyment) {
        this.dateOfEmplyment = dateOfEmplyment;
    }
    @Basic
    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
    @ElementCollection
    public List<String> getJezyki() {
        return jezyki;
    }

    public void setJezyki(List<String> jezyki) {
        this.jezyki = jezyki;
    }
    @Transient
    public static double getMinimalSalary() {
        return minimalSalary;
    }

    public static void setMinimalSalary(double minimalSalary) {
        Pracownik.minimalSalary = minimalSalary;
    }
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Dzial getDzial() {
        return dzial;
    }

    public void setDzial(Dzial dzial) {
        this.dzial = dzial;
    }
    @OneToMany(mappedBy = "pracownik", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Zadanie> getZadaniaList() {
        return zadaniaList;
    }

    public void setZadaniaList(List<Zadanie> zadaniaList) {
        this.zadaniaList = zadaniaList;
    }
    @Basic
    public String getJezykProgramowania() {
        return jezykProgramowania;
    }

    public void setJezykProgramowania(String jezykProgramowania) {
        this.jezykProgramowania = jezykProgramowania;
    }
    @Basic
    public int getDosJakoProgramista() {
        return dosJakoProgramista;
    }

    public void setDosJakoProgramista(int dosJakoProgramista) {
        this.dosJakoProgramista = dosJakoProgramista;
    }
    @Basic
    public String getDosJakoAnalityk() {
        return dosJakoAnalityk;
    }

    public void setDosJakoAnalityk(String dosJakoAnalityk) {
        this.dosJakoAnalityk = dosJakoAnalityk;
    }
    @Basic
    public String getStawki() {
        return stawki;
    }

    public void setStawki(String stawki) {
        this.stawki = stawki;
    }
}
