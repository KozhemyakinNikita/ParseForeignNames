package com.kozhemyakin.lab4;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;


/**
 * @author n.s.kozhemyakin
 */
public class Main {
    public static void main(String[] args) {
        readCsv reader = new readCsv();
        try {
            reader.parseCsv();
            reader.printParsedCsv();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

