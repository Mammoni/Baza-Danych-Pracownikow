import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "podDzial")
public class PodDzial {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    private String nazwaPodDzialu;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Dzial dzial; // kompozycja dzial -- podDzial

    public PodDzial(){}
    public PodDzial(Dzial dzial,String nazwaPodDzialu){
        this.nazwaPodDzialu = nazwaPodDzialu;
        this.dzial = dzial;
    }

    public static PodDzial createPodDzial(Dzial dzial, String nazwaPodDzialu){
        PodDzial podDzial = new PodDzial(dzial,nazwaPodDzialu);
        try {
            dzial.addSubDepartment(podDzial);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return podDzial;
    }
    //---------------------------------------------------------------------------------


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public String getNazwaPodDzialu() {
        return nazwaPodDzialu;
    }

    public void setNazwaPodDzialu(String nazwaPodDzialu) {
        this.nazwaPodDzialu = nazwaPodDzialu;
    }
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Dzial getDzial() {
        return dzial;
    }

    public void setDzial(Dzial dzial) {
        this.dzial = dzial;
    }

    @Override
    public String toString() {
        return "PodDzial{" +
                "nazwaPodDzialu='" + nazwaPodDzialu + '\'' +
                '}';
    }

}
