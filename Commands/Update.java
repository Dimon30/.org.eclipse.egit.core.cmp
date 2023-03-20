package Commands;

import Organization.Organization;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Update extends Command{
    private static final String name = "update";
    private final static String description = ": Update value of field for organization from collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void update(Scanner scan, Vector<Organization> org){
        System.out.print("Input id: ");
        Integer id = scan.nextInt();
        scan.nextLine();
        try {
            final Organization t = org.stream().filter(o -> o.getId() == id).findFirst().orElseThrow();
            System.out.println("What do u wanna change: ");
            System.out.println("0 - nothing\n1 - name\n2 - coordinates\n3 - creation date\n4 - annual turnover\n5 - type\n6 - postal address");
            switch (scan.nextLine()) {
                case "0", "nothing", "-" -> {}
                case "1", "name", "Name" -> {System.out.print("Input <string> name: ");
                    t.setName(scan.nextLine());}
                case "2", "coordinates", "Coordinates", "coordinate", "Coordinate" -> {System.out.print("Input coordinates 'x <long>, y <double>': ");
                    t.setCoordinates(scan.nextLine());}
                case "3", "date", "Date", "creation date", "creationDate", "creation_date" -> {System.out.print("Input date 'yyyy-mm-dd': ");
                    t.setCreationDate(LocalDateTime.parse(scan.nextLine()));}
                case "4", "annual turnover", "annualTurnover", "annualTurnOver", "annual_turnover", "annual_Turnover", "annual_TurnOver" -> {System.out.print("Input <float> annual turnover: ");
                    t.setAnnualTurnover(scan.nextLine());}
                case "5", "type", "Type" -> {System.out.print("Input <string> type: ");
                    t.setType(scan.nextLine());}
                case "6", "postalAddress", "postal address", "postal_address", "postal addres", "postal_addres", "postal adress", "postal_adress", "postal adres", "postal_adres" -> {System.out.print("Input postal address '<string> zipcode, <string> street, <int> x, <long> y, <string> town': ");
                    t.setPostalAddress(scan.nextLine());}


                default -> throw new IllegalStateException("Unexpected value: " + scan.next());
            }
        } catch (NoSuchElementException e) {
            System.out.println("Sorry...\nDon't find organization by this id(");
        }

    }
}
