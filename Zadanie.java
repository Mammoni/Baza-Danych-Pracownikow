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


@Entity(name = "Zadanie")
public class Zadanie implements Serializable {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy ="increment")
    private long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Pracownik pracownik = null;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Projekt projekt;

    private String stanWykonania;
    private String opisZadania;


    public Zadanie(){}
    public Zadanie(Pracownik pracownik, Projekt projekt, String stanWykonania,
                   String opisZadania){
        this.pracownik = pracownik;
        this.projekt = projekt;
        this.stanWykonania = stanWykonania;
        this.opisZadania =opisZadania;
    }

    @Override
    public String toString() {
        return "Zadanie : "+opisZadania + " stan zadania  "+ stanWykonania;
    }

    public static List<Zadanie> showZadania(){
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

            List<Zadanie> p = session.createQuery("from Zadanie").list();
            for (Zadanie x: p) {
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
        public static void wykonajZadania(){
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
                List<Zadanie> p = session.createQuery("from Zadanie").list();
                for (Zadanie x: p) {
                    x.setStanWykonania("Wykonano");
                }
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


    public static void CreateNewZadanie(String opisZadania){
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
            List<String> jezyki = new ArrayList<>();
            jezyki.add("Polski");
            jezyki.add("Angielski");
            ArrayList<Pracownik> prac1 = new ArrayList<>();
            Dzial dza1 = new Dzial("Finanse",prac1);
            ArrayList<Zadanie> zadania = new ArrayList<>();
            Pracownik p1 = new Pracownik(1,"Kamil","Jedrzejczyk","Siedlce",2000.0,1980,
                    new DateOfEmployment(2010,10,15),190.0,jezyki,dza1,zadania);
            Projekt projekt1 = new Projekt("abc","cba","Normal",zadania);

            session.save(new Zadanie(p1,projekt1,"Nie Wykonano",opisZadania));
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

    //-----------------------------------------------------------------------


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    public Projekt getProjekt() {
        return projekt;
    }

    public void setProjekt(Projekt projekt) {
        this.projekt = projekt;
    }
    @Basic
    public String getStanWykonania() {
        return stanWykonania;
    }

    public void setStanWykonania(String stanWykonania) {
        this.stanWykonania = stanWykonania;
    }
    @Basic
    public String getOpisZadania() {
        return opisZadania;
    }

    public void setOpisZadania(String opisZadania) {
        this.opisZadania = opisZadania;
    }
}
