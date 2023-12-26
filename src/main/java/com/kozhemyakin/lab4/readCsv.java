package com.kozhemyakin.lab4;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author n.s.kozhemyakin
 */
public class readCsv {
    /**
     * Flag indicating whether the CSV file has already been parsed.
     */
    private boolean parsedFile;
    /**
     * The file path of the CSV file containing foreign names data.
     */
    private String filePath = "src/main/resources/foreign_names.csv";
    /**
     * The field separator used in the CSV file.
     */
    private char fieldSeparator = ';';
    /**
     * A linked list to store the parsed `Person` objects.
     */
    private LinkedList<Person> personList = new LinkedList<>();
    /**
     * A set to store unique `Department` objects associated with the persons.
     */
    private HashSet<Department> departmentSet = new HashSet<>();
    /**
     * The CSV parser used to parse the CSV file.
     */
    private CSVParser csvParser = new CSVParserBuilder().withSeparator(fieldSeparator).build();
    /**
     * Parses the CSV file, creates `Person` objects, and populates the personList and departmentSet.
     *
     * @throws IOException           If an I/O error occurs while reading the CSV file.
     * @throws CsvValidationException If there is an issue with the CSV file's format.
     */
    public void parseCsv() throws IOException, CsvValidationException {
        if (parsedFile) {
            System.out.println("The file was already parsed");
            return;
        }

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {

            if (reader == null) {
                throw new FileNotFoundException(filePath);
            }

            String[] line;
            while ((line = reader.readNext()) != null) {
                Department division = findOrCreateDepartment(line[4]);
                Gender gender = parseGender(line[2]);

                Person person = new Person(
                        Integer.parseInt(line[0]),
                        line[1],
                        gender,
                        division,
                        Double.parseDouble(line[5]),
                        line[3]
                );
                personList.add(person);
            }
        }
        parsedFile = true;
    }
    /**
     * Finds an existing `Department` with the given name or creates a new one if not found.
     *
     * @param name The name of the department.
     * @return The found or newly created `Department` object.
     */
    private Department findOrCreateDepartment(String name) {
        for (Department department : departmentSet) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        Department newDepartment = new Department(name);
        departmentSet.add(newDepartment);
        return newDepartment;
    }
    /**
     * Parses the gender string and returns the corresponding `Gender` enum value.
     *
     * @param genderString The gender string ("Male" or "Female").
     * @return The parsed `Gender` enum value.
     */
    private Gender parseGender(String genderString) {
        return "Male".equalsIgnoreCase(genderString) ? Gender.Male : Gender.Female;
    }
    /**
     * Prints the string representation of the parsed `Person` objects.
     */
    public void printParsedCsv() {
        if (parsedFile) {
            for (Person person : personList) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println("The file was not parsed yet");
        }
    }
    /**
     * Returns a copy of the list containing the parsed `Person` objects.
     *
     * @return A linked list of `Person` objects.
     */
    public LinkedList<Person> getPersonList() {
        return new LinkedList<>(personList);
    }
}