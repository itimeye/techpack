package com.practice.techpack.repository;

import com.practice.techpack.entity.PantoneColor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PantonceColorRepositoryTest {

    @Autowired
    private PantonceColorRepository pantonceColorRepository;

    @Test
    void uploadPantoneColors() throws IOException {
        File pantoneColorTable = new File("C:\\Users\\itima\\Practice\\techpack back end\\techpack\\src\\main\\resources\\documents\\Paontone Color Chart CSVUTF8.csv");
        FileReader fileReader = new FileReader(pantoneColorTable);
        List<PantoneColor> pantoneColorRecords = new ArrayList<>();
        Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.parse(fileReader);
        for (CSVRecord csvRecord : csvRecords){
          String PMS = csvRecord.get(0);
          int L = Integer.parseInt(csvRecord.get(1));
          int A = Integer.parseInt(csvRecord.get(2));
          int B = Integer.parseInt(csvRecord.get(3));
          int R = Integer.parseInt(csvRecord.get(4));
          int G = Integer.parseInt(csvRecord.get(5));
          int rgbB = Integer.parseInt(csvRecord.get(6));
          String Hex = csvRecord.get(7);
//          System.out.println(PMS + L + A + B + R + G + rgbB + Hex);
          PantoneColor pantoneColor = new PantoneColor(PMS, L, A, B, R, G, rgbB, Hex);
          pantoneColorRecords.add(pantoneColor);

        }

        //save array to table
        pantonceColorRepository.saveAll(pantoneColorRecords);
    }
}