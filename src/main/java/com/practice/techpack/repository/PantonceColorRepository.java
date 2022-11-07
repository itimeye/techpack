package com.practice.techpack.repository;

import com.practice.techpack.entity.PantoneColor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface PantonceColorRepository extends JpaRepository<PantoneColor, Long> {

    public static List<PantoneColor> uploadPantoneColors() throws IOException {
        File pantoneColorTable = new File("C:\\Users\\itima\\Practice\\techpack back end\\techpack\\src\\main\\resources\\documents\\Paontone Color Chart CSVUTF8.csv");
        FileReader fileReader = new FileReader(pantoneColorTable);
        Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.parse(fileReader);
        List<PantoneColor> pantoneColorRecords = new ArrayList<>();
        for (CSVRecord csvRecord : csvRecords){
            String PMS = csvRecord.get(0);
            int L = Integer.parseInt(csvRecord.get(1));
            int A = Integer.parseInt(csvRecord.get(2));
            int B = Integer.parseInt(csvRecord.get(3));
            int R = Integer.parseInt(csvRecord.get(4));
            int G = Integer.parseInt(csvRecord.get(5));
            int rgbB = Integer.parseInt(csvRecord.get(6));
            String Hex = csvRecord.get(7);

            PantoneColor pantoneColor = new PantoneColor(PMS, L, A, B, R, G, rgbB, Hex);
            pantoneColorRecords.add(pantoneColor);
        }

        //return list of PantoneColors = pantoneColorRecords
        return pantoneColorRecords;

        //save List to database
//        saveAll(pantoneColorRecords);
    }

    public static FileReader readFile() throws IOException {
        File pantoneColorTable = new File("C:\\Users\\itima\\Practice\\techpack back end\\techpack\\src\\main\\resources\\documents\\Paontone Color Chart CSVUTF8.csv");
        FileReader fileReader = new FileReader(pantoneColorTable);

        return fileReader;
    }

    public static List<PantoneColor> createRecords(FileReader fileReader) throws IOException {
        Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.parse(fileReader);
        List<PantoneColor> pantoneColorRecords = new ArrayList<>();
        for (CSVRecord csvRecord : csvRecords){
            String PMS = csvRecord.get(0);
            int L = Integer.parseInt(csvRecord.get(1));
            int A = Integer.parseInt(csvRecord.get(2));
            int B = Integer.parseInt(csvRecord.get(3));
            int R = Integer.parseInt(csvRecord.get(4));
            int G = Integer.parseInt(csvRecord.get(5));
            int rgbB = Integer.parseInt(csvRecord.get(6));
            String Hex = csvRecord.get(7);

            PantoneColor pantoneColor = new PantoneColor(PMS, L, A, B, R, G, rgbB, Hex);
            pantoneColorRecords.add(pantoneColor);
        }
        return pantoneColorRecords;
    }

    public default List<PantoneColor> uploadToTable() throws IOException {
        FileReader fileReader = readFile();
        List <PantoneColor> pantoneColorRecords = createRecords(fileReader);
        return pantoneColorRecords;
    }

}
