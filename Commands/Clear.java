package Commands;

import Organization.Organization;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Clear {
    private static final String name = "clear";
    private final static String description = ": Clear collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void clear(Vector<Organization> org){
        try {
            org.clear();
        } catch (Exception e) {
            System.out.println("Error cleaning..");
        }

    }
}
