package com.nagarro.training.SearchFlight;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class readDB {

    static void read(String depLoc, String arrLoc, String Date, String Class, String outPref) {

        String hql;
        if (outPref.equals("F")) {
            if (Class.equals("E")) {
                hql = "FROM flightdata f where f.DEP_LOC=?0 and f.ARR_LOC =?1 and (f.CLASS = 'E' OR f.CLASS='EB') and f.VALID_TILL=?2 ORDER BY f.FARE ASC";
            } else {
                hql = "FROM flightdata f where f.DEP_LOC=?0 and f.ARR_LOC =?1 and (f.CLASS = 'B' OR f.CLASS='EB') and f.VALID_TILL=?2 ORDER BY f.FARE ASC";
            }
        } else {
            if (Class.equals("E")) {
                hql = "FROM flightdata f where f.DEP_LOC=?0 and f.ARR_LOC =?1 and (f.CLASS = 'E' OR f.CLASS='EB') and f.VALID_TILL=?2 ORDER BY f.FLIGHT_DUR ASC";
            } else {
                hql = "FROM flightdata f where f.DEP_LOC=?0 and f.ARR_LOC =?1 and (f.CLASS = 'B' OR f.CLASS='EB') and f.VALID_TILL=?2 ORDER BY f.FLIGHT_DUR ASC";
            }
        }

        Configuration con = new Configuration().configure().addAnnotatedClass(flightdata.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(registry);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        @SuppressWarnings("unchecked")
        Query<flightdata> query = session.createQuery(hql);
        query.setParameter(0, depLoc);
        query.setParameter(1, arrLoc);
        query.setParameter(2, Date);

        final List<flightdata> list = new LinkedList<>();
        for (final Object o : query.list()) {
            list.add((flightdata) o);
        }

        List<flightdata> empList = query.list();
        if(empList.size()==0) {
            System.out.println("No result found");
        }
        for (flightdata emp : empList) {
            if (Class.equals("E")) {
                System.out
                        .println("FLIGHT_NO()" + ":" + emp.getFLIGHT_NO() + ", " + "DEP_LOC()" + ":" + emp.getDEP_LOC()
                                + ", " + "ARR_LOC()" + ":" + emp.getARR_LOC() + ", " + "FARE()" + ":" + emp.getFARE()
                                + ", " + "FLIGHT_TIME()" + ":" + emp.getFLIGHT_TIME() + ", " + "SEAT_AVAILABILITY()"
                                + ":" + emp.getSEAT_AVAILABILITY() + ", " + "CLASS()" + ":" + emp.getCLASS());
            } else {
                System.out.println("FLIGHT_NO()" + ":" + emp.getFLIGHT_NO() + ", " + "DEP_LOC()" + ":"
                        + emp.getDEP_LOC() + ", " + "ARR_LOC()" + ":" + emp.getARR_LOC() + ", " + "FARE()" + ":"
                        + 1.4 * Integer.parseInt(emp.getFARE()) + ", " + "FLIGHT_TIME()" + ":" + emp.getFLIGHT_TIME()
                        + ", " + "SEAT_AVAILABILITY()" + ":" + emp.getSEAT_AVAILABILITY() + ", " + "CLASS()" + ":"
                        + emp.getCLASS());
            }
        }

        tx.commit();

    }

}
