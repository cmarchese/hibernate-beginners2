
package com.research24x7.hibernate.beginners.test;


import java.util.Date;
import java.util.List;

import com.research24x7.hibernate.beginners.entity.Employee;
import com.research24x7.hibernate.beginners.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateAnnotationTest {


    private static SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger (HibernateAnnotationTest.class);


    public HibernateAnnotationTest () {

        super ();
    }


    @BeforeAll
    public static void setup () {

        sessionFactory = HibernateUtil.getSessionFactory ();
    }

    @AfterAll
    public static void destroy () {

        sessionFactory.close ();
    }


    @Test
    @DisplayName ("Create New Records")
    public void m1 () {
        // Get a session.
        Session session = null;
        Transaction tx = null;
        try {

            logger.info("Getting a session...");
            session = sessionFactory.openSession ();
            tx = session.beginTransaction ();

            // Set the data to save.
            logger.info("Creating values to insert...");
            Employee[] values = new Employee[]{

                    new Employee("Homer Simpson", "Test", new Date()),
                    new Employee("Marge Simpson", "Test", new Date()),
                    new Employee("Bart Simpson", "Test", new Date()),
                    new Employee("Lisa Simpson", "Test", new Date()),
                    new Employee("Maggie Simpson", "Test", new Date())
            };

            // Save the data.
            for (Employee e : values) {

                logger.info (String.format ("Saving value %s", e.getName ()));
                session.save(e);
                logger.info (String.format ("Value %s saved!", e.getName ()));
            }
            tx.commit ();
            Assertions.assertTrue (values[0].getId () > 0, String.format ("Problems creating teh new employee %s", values[0].getName ()));

        } catch (Exception ex) {

            logger.error (ex.getMessage ());
            tx.rollback ();
            Assertions.assertFalse (Boolean.TRUE, "Problems executing the test.");

        } finally { session.close (); }
    }



}
}