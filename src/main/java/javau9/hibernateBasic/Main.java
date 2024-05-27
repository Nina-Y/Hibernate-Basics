package javau9.hibernateBasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        saveEmployee();
        loadEmployees();
    }

    private static void saveEmployee() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        Address address1 = new Address("Laisves pr. 15", "Vilnius", "Lietuva");
        Address address2 = new Address("Gedimino pr. 25", "Vilnius", "Lietuva");
        Address address3 = new Address("Vytauto g. 35", "Vilnius", "Lietuva");
        Address address4 = new Address("Tilto g. 26", "Vilnius", "Lietuva");
        Address address5 = new Address("Mindaugo g. 53", "Vilnius", "Lietuva");

        session.persist(address1);
        session.persist(address2);
        session.persist(address3);
        session.persist(address4);
        session.persist(address5);

        session.persist(new Employee("Jonas", "Jonaitis", address1));
        session.persist(new Employee("Petras", "Petraitis", address2));
        session.persist(new Employee("Lukas", "Jankauskas", address3));
        session.persist(new Employee("Matas", "Petrauskas", address4));
        session.persist(new Employee("Arnas", "Butkus", address5));

        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    private static void loadEmployees() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        Query<Employee> query = session.createQuery("FROM Employee", Employee.class);

        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);

        session.close();
        factory.close();
    }
}