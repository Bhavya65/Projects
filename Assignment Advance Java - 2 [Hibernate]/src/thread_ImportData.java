package com.nagarro.training.SearchFlight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class thread_ImportData extends Thread {

    private String path;

    public thread_ImportData(String path) {
        // TODO Auto-generated constructor stub
        this.path = path;
    }

    public void run() {

        createDB Manager = new createDB();
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader("C:\\Users\\bhavyachhabra\\Documents\\AssignmentLinks\\" + path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line[];
        try {
            line = reader.readNext();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            while ((line = reader.readNext()) != null) {
                System.out.println(line[4]);
                Manager.create(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
