package com.nagarro.training.SearchFlight;

import com.opencsv.bean.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class App extends Thread {
    private String DepLocation;
    private String ArrLocation;
    private String FlightDate;
    private String FlightClass;
    private String path;
    private ArrayList<ArrayList<String>> list;

    public App(String DepLocation, String ArrLocation, String FlightDate, String FlightClass, String path,
            ArrayList<ArrayList<String>> list) {
        this.DepLocation = DepLocation;
        this.ArrLocation = ArrLocation;
        this.FlightDate = FlightDate;
        this.FlightClass = FlightClass;
        this.path = "C:\\Users\\bhavyachhabra\\Documents\\AssignmentLinks\\" + path;
        this.list = list;
    }

    public void run() {

        try (Reader reader = Files.newBufferedReader(Paths.get(path));) {
            @SuppressWarnings({ "unchecked", "rawtypes" })

            CsvToBean<flight> csvToBean = new CsvToBeanBuilder(reader).withType(flight.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            Iterator<flight> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                flight csvUser = csvUserIterator.next();
                if (csvUser.getDEP_LOC().equals(DepLocation) && csvUser.getARR_LOC().equals(ArrLocation)
                        && csvUser.getVALID_TILL().equals(FlightDate)) {
                    list.add(new ArrayList<String>());
                    int i = list.size() - 1;
                    list.get(i).add(csvUser.getFLIGHT_NO());
                    list.get(i).add(csvUser.getDEP_LOC());
                    list.get(i).add(csvUser.getARR_LOC());
                    list.get(i).add(csvUser.getFLIGHT_DUR());
                    list.get(i).add(csvUser.getFLIGHT_TIME());
                    if (FlightClass.equals("B")) {
                        list.get(i).add((String.valueOf(Integer.parseInt(csvUser.getFARE()) * 1.4)));
                    } else {
                        list.get(i).add(csvUser.getFARE());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String[] arr = new String[] { "AirIndia.csv", "indigo.csv", "JetAir.csv" };
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ënter Departure Location Code");
        String DepLocation = sc.nextLine();
        System.out.println("Ënter Arrival Location Code");
        String ArrLocation = sc.nextLine();
        System.out.println("Ënter date of travel");
        String Date = sc.nextLine();
        System.out.println("Ënter class");
        String Class = sc.nextLine();
        System.out.println("Ënter output preference");
        String OutputPref = sc.nextLine();
        sc.close();

        Thread[] threads = new Thread[arr.length];
        for (int i = 0; i < arr.length; i++) {
//             threads[i] = new Thread(new readCSV("DEL", "MUB", "17-12-2013", "B", arr[i],
//             list));
            threads[i] = new Thread(new App(DepLocation, ArrLocation, Date, Class, arr[i], list));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (OutputPref.equals("F")) {

            Collections.sort(list, new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                    return o1.get(5).compareTo(o2.get(5));
                }
            });
        } else {
            Collections.sort(list, new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                    return o1.get(3).compareTo(o2.get(3));
                }
            });
            Collections.sort(list, new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                    return o1.get(5).compareTo(o2.get(5));
                }
            });
        }
        System.out.println(list);
    }
}