
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity(name = "dzial")
public class Dzial implements Serializable{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;
    private String nazwaDzialu;
    @OneToMany(mappedBy = "dzial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pracownik> pracownicy;
    @OneToMany(mappedBy = "dzial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PodDzial> PodDzialList; // kompozycja department -- subdepartment
    public static List<PodDzial> wszystkiePodDzialy = new ArrayList<PodDzial>();
    @ManyToMany
    private List<Dzial> ordersList = new ArrayList<Dzial>();

    public Dzial(){}
    public Dzial(String nazwaDzialu, List<Pracownik> pracownicy){
        this.nazwaDzialu = nazwaDzialu;
        this.pracownicy= pracownicy;
        this.PodDzialList = new ArrayList<>();
    }

    //----------------------------------------------------------------------------------------------------


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public String getNazwaDzialu() {
        return nazwaDzialu;
    }

    public void setNazwaDzialu(String nazwaDzialu) {
        this.nazwaDzialu = nazwaDzialu;
    }
    @OneToMany(mappedBy = "dzial", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
    @OneToMany(mappedBy = "dzial", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<PodDzial> getPodDzialList() {
        return PodDzialList;
    }

    public void setPodDzialList(List<PodDzial> podDzialList) {
        PodDzialList = podDzialList;
    }

    public static List<PodDzial> getWszystkiePodDzialy() {
        return wszystkiePodDzialy;
    }

    public static void setWszystkiePodDzialy(List<PodDzial> wszystkiePodDzialy) {
        Dzial.wszystkiePodDzialy = wszystkiePodDzialy;
    }
    @ManyToMany
    public List<Dzial> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Dzial> ordersList) {
        this.ordersList = ordersList;
    }

        public void addSubDepartment(PodDzial podDzial) throws Exception {
        if(wszystkiePodDzialy.contains(podDzial)){
            throw new Exception("Ten podDzial już istnieje");
        }else
            PodDzialList.add(podDzial);
        wszystkiePodDzialy.add(podDzial);
    }
    @Override
    public String toString() {
        return "Dzial{" +
                "nazwaDzialu='" + nazwaDzialu + '\'' +
                ", pracownicy=" + pracownicy.toString() +
                '}';
    }



}
