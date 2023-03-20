package Commands;

import Organization.Organization;

import java.util.Vector;

public class Show {
    private static final String name = "show";
    private final static String description = ": Show all organizations in collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void show(Vector<Organization> org){
        for (Organization t : org){
            System.out.println("Organization #" + (int)(org.indexOf(t) + 1) + ":");
            t.print();
        }
    }
}
