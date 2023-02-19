import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){

        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        List<Pracownik> testList = new ArrayList<>();

        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            /*List<String> jezyki = new ArrayList<>();
            jezyki.add("Polski");
            jezyki.add("Angielski");
            ArrayList<Pracownik> prac1 = new ArrayList<>();
            Dzial dza1 = new Dzial("Finanse",prac1);
            ArrayList<Zadanie> zadania = new ArrayList<>();
            Pracownik p1 = new Pracownik(1,"Kamil","Jedrzejczyk","Siedlce",2000.0,1980,
                    new DateOfEmployment(2010,10,15),190.0,jezyki,dza1,zadania);
            Pracownik p2 = new Pracownik(1,"Adam","Adamski","Warszawa",2000.0,1980,
                    new DateOfEmployment(2010,10,15),190.0,jezyki,dza1,zadania);
            Projekt projekt1 = new Projekt("ABC","CBA","Normal",zadania);





            session.save(dza1);
            session.save(p1);
            session.save(p2);
            session.save(projekt1);

            session.save(zad1);
            session.save(zad2);*/

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
                sessionFactory = null;
            }
        }

    }


}

