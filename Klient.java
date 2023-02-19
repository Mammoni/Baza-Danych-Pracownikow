import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "klient")
@Inheritance(strategy = InheritanceType.JOINED)
public class Klient {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    private String imieKlienta;
    private String email;
    private String adres;
    //REGISTERED
    private String nip;
    //NOTREGISTERED
    private int pesel;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private List<Projekt> projekt;
    private RodzajKlienta rodzajKlienta;


    public Klient(){}
    public Klient(String imieKlienta,String email,String adres){
        this.imieKlienta =imieKlienta;
        this.email=email;
        this.adres=adres;
    }
    public Klient(String imieKlienta,String email,String nip,
                  RodzajKlienta rodzajKlienta){
        this.imieKlienta =imieKlienta;
        this.email=email;
        this.nip = nip;
        this.rodzajKlienta = rodzajKlienta;
    }
    public Klient(String imieKlienta,String email,int pesel,
                  RodzajKlienta rodzajKlienta){
        this.imieKlienta =imieKlienta;
        this.email=email;
        this.pesel = pesel;
        this.rodzajKlienta = rodzajKlienta;
    }


    public static void CreateNewKlient(String imieKlienta, String email, String adres){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            //-------------------------------------------
            session.save(new Klient(imieKlienta, email, adres));
            //--------------------------------------------
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }



    //---------------------------------------------------------------------------


    public long getId() {
        return id;
    }
    @Basic
    public String getImieKlienta() {
        return imieKlienta;
    }
    @Basic
    public String getEmail() {
        return email;
    }
    @Basic
    public String getNip() {
        return nip;
    }
    @Basic
    public int getPesel() {
        return pesel;
    }
    @Enumerated
    public RodzajKlienta getRodzajKlienta() {
        return rodzajKlienta;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImieKlienta(String imieKlienta) {
        this.imieKlienta = imieKlienta;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public void setRodzajKlienta(RodzajKlienta rodzajKlienta) {
        this.rodzajKlienta = rodzajKlienta;
    }
    @Basic
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public List<Projekt> getProjekt() {
        return projekt;
    }

    public void setProjekt(List<Projekt> projekt) {
        this.projekt = projekt;
    }
}
