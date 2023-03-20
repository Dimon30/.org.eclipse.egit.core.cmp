package Commands;

import Organization.Organization;

import java.util.Vector;

import static Auxiliary.OrganizatonSort.revSort;

public class Reorder{
    private static final String name = "reorder";
    private final static String description = ": Reverse sort collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void reorder(Vector<Organization> org){revSort(org);}
}
