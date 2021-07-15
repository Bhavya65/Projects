package com.nagarro.training.SearchFlight;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class createDB {

    protected void create(String flightNo, String depLoc, String arrLoc, String validTill, String flightTime,
            String flightDur, String fare, String seatAvail, String Class) {
        
        flightdata example = new flightdata();
        example.setFLIGHT_NO(flightNo);
        example.setARR_LOC(arrLoc);
        example.setDEP_LOC(depLoc);
        example.setFARE(fare);
        example.setFLIGHT_DUR(flightDur);
        example.setFLIGHT_TIME(flightTime);
        example.setSEAT_AVAILABILITY(seatAvail);
        example.setCLASS(Class);
        example.setVALID_TILL(validTill);

        Configuration con = new Configuration().configure().addAnnotatedClass(flightdata.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(registry);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(example);

        tx.commit();
    }

}
