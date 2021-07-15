package com.nagarro.training.SearchFlight;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import org.hibernate.SessionFactory;

public class App {

    protected SessionFactory sessionFactory;

    public static void main(String[] args) throws IOException, ParseException {

        File f = new File("C:\\Users\\bhavyachhabra\\Documents\\AssignmentLinks");
        String[] pathnames;
        pathnames = f.list();
        Thread[] threads = new Thread[pathnames.length];
        for (int i = 0; i < pathnames.length; i++) {
            threads[i] = new Thread(new thread_ImportData(pathnames[i]));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        Scanner sc = new Scanner(System.in);
        String DEP_LOC = sc.next();
        String ARR_LOC = sc.next();
        String FLIGHT_DATE = sc.next();
        String FLIGHT_CLASS = sc.next();
        String OutPref = sc.next();
        readDB.read(DEP_LOC, ARR_LOC, FLIGHT_DATE, FLIGHT_CLASS, OutPref);
        sc.close();

    }
}