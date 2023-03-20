package Commands;

import Organization.Organization;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Remove extends Command{
    private static final String name = "remove_by_id";
    private final static String description = ": Remove organization by id;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void remove(Scanner scan, Vector<Organization> org){
        System.out.print("Input id: ");
        Integer id = scan.nextInt();
        scan.nextLine();
        try {
            final Organization t = org.stream().filter(o -> o.getId() == id).findFirst().orElseThrow();
            org.remove(t);
        } catch (NoSuchElementException e) {
            System.out.println("Sorry...\nDon't find organization by this id(");
        }

    }
}
