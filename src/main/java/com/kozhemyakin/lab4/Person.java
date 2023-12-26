package com.kozhemyakin.lab4;
/**
 * @author n.s.kozhemyakin
 */
public class Person {

    /**
     * The unique identifier for the person.
     */
    private final int id;

    /**
     * The name of the person.
     */
    private final String name;

    /**
     * The gender of the person.
     */
    private final Gender gender;

    /**
     * The department to which the person belongs.
     */
    private final Department department;

    /**
     * The salary of the person.
     */
    private final double salary;

    /**
     * The birth date of the person.
     */
    private final String birthDate;

    /**
     * Constructs a new `Person` object with the specified parameters.
     *
     * @param id         The unique identifier for the person.
     * @param name       The name of the person.
     * @param gender     The gender of the person.
     * @param department The department to which the person belongs.
     * @param salary     The salary of the person.
     * @param birthDate  The birthdate of the person.
     */
    public Person(int id, String name, Gender gender, Department department, double salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Gets the unique identifier of the person.
     *
     * @return The ID of the person.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the gender of the person.
     *
     * @return The gender of the person.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Gets the salary of the person.
     *
     * @return The salary of the person.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns a string representation of the person in the format:
     * "id;name;gender;birthDate;department;salary"
     *
     * @return The string representation of the person.
     */
    @Override
    public String toString() {
        return id + ";" + name + ";" + gender + ";" + birthDate + ";" + department.getName() + ";" + salary;
    }
}
