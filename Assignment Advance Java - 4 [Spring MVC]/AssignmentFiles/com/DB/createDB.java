package com.DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.entities.spring;

public class createDB {

    protected void create(String flightNo, String depLoc, String arrLoc, String validTill, String flightTime,
            String flightDur, String fare, String seatAvail, String Class) {
        
        spring example = new spring();
        example.setFlightNo(flightNo);
        example.setArrLoc(arrLoc);
        example.setDelLoc(depLoc);
        example.setFare(fare);
        example.setFlightDur(flightDur);
        example.setFlightTime(flightTime);
        example.setSeatAvail(seatAvail);
        example.setClass1(Class);
        example.setValidTill(validTill);

        Configuration con = new Configuration().configure().addAnnotatedClass(spring.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(registry);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(example);

        tx.commit();
    }

}
