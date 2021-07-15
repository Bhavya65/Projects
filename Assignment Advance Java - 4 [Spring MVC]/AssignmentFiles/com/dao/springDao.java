package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.spring;

@Component
public class springDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(spring t) {
        Integer i = (Integer) this.hibernateTemplate.save(t);
        return i;
    }

    public List<spring> getAll(String depLoc, String arrLoc, String validTill, String Class, String outPref) {
        String hql;
        if (outPref.equals("F")) {
            if (Class.equals("E")) {
                hql = "FROM spring f where f.arrLoc=?0 and f.delLoc =?1 and (f.class1 = 'E' OR f.class1='EB') and f.validTill=?2 ORDER BY f.fare ASC";
            } else {
                hql = "FROM spring f where f.arrLoc=?0 and f.delLoc =?1 and (f.class1 = 'B' OR f.class1='EB') and f.validTill=?2 ORDER BY f.fare ASC";
            }
        } else {
            if (Class.equals("E")) {
                hql = "FROM spring f where f.arrLoc=?0 and f.delLoc =?1 and (f.class1 = 'E' OR f.class1='EB') and f.validTill=?2 ORDER BY f.flightDur ASC";
            } else {
                hql = "FROM spring f where f.arrLoc=?0 and f.delLoc =?1 and (f.class1 = 'B' OR f.class1='EB') and f.validTill=?2 ORDER BY f.flightDur ASC";
            }
        }

        Configuration con = new Configuration().configure().addAnnotatedClass(spring.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(registry);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        @SuppressWarnings("unchecked")
        Query<spring> query = session.createQuery(hql);
        query.setParameter(0, arrLoc);
        query.setParameter(1, depLoc);
        query.setParameter(2, validTill);
        List<spring> empList = query.list();
        return empList;
    }
}
