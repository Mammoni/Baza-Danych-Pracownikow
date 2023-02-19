import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "projekt")
@Inheritance(strategy = InheritanceType.JOINED)
public class Projekt implements Serializable {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    private String nazwaProjektu;
    private String opis;
    private String typ;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Klient klient;
    @OneToMany(mappedBy = "projekt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zadanie> zadanieList;


    public Projekt(){}
    public Projekt(String nazwaProjektu,String opis,String typ,
                   List<Zadanie> zadanieList)
    {
            this.nazwaProjektu = nazwaProjektu;
            this.opis = opis;
            this.typ = typ;
            this.zadanieList = zadanieList;
    }

    @Override
    public String toString() {
        return "Projekt: " + nazwaProjektu +" "+opis+" "+typ;

    }

    public static List<Projekt> showProjects(){
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

            List<Projekt> p = session.createQuery("from Projekt").list();
            for (Projekt x: p) {
                System.out.println(x.toString());
            }
            //--------------------------------------------
            session.getTransaction().commit();
            session.close();
            return p;
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
        return null;
    }

    public static void CreateNewProject(String nazwaProjektu, String opis, String typ){
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
            session.save(new Projekt(nazwaProjektu,opis,typ,new ArrayList<>()));
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


//-----------------------------------------------------------------------------------------


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Basic
    public String getNazwaProjektu() {
        return nazwaProjektu;
    }

    public void setNazwaProjektu(String nazwaProjektu) {
        this.nazwaProjektu = nazwaProjektu;
    }
    @Basic
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    @Basic
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
    @OneToMany(mappedBy = "projekt", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Zadanie> getZadanieList() {
        return zadanieList;
    }

    public void setZadanieList(List<Zadanie> zadanieList) {
        this.zadanieList = zadanieList;
    }
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
}
