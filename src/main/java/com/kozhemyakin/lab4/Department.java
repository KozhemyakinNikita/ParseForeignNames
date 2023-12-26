package com.kozhemyakin.lab4;

/**
 * @author n.s.kozhemyakin
 */
public class Department {
    /**
     * A static variable to keep track of the next available department ID.
     */
    private static int countId = 1;
    /**
     * The unique identifier for the department.
     */
    private final int id;
    /**
     * The name of the department.
     */
    private final String name;
    /**
     * Constructs a new `Department` object with the specified name.
     *
     * @param name The name of the department.
     */
    public Department(String name) {
        this.id = countId++;
        this.name = name;
    }
    /**
     * Gets the unique identifier of the department.
     *
     * @return The ID of the department.
     */
    public int getId() {
        return id;
    }
    /**
     * Gets the name of the department.
     *
     * @return The name of the department.
     */
    public String getName() {
        return name;
    }
}
