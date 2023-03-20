package Commands;

import Organization.Organization;

import java.util.Vector;

import static Auxiliary.OrganizatonSort.sort;

public class Sort{
    private static final String name = "sort";
    private final static String description = ": Sort collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void sort(Vector<Organization> org){sort(org);}
}
