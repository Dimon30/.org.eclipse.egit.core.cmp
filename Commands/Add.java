package Commands;

import Organization.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

public class Add {
    private static final String name = "add";
    private final static String description = ": Add new organization to collection;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void add(Scanner scan, Vector<Organization> org){
        System.out.println("Input name organization: ");
        String name = scan.nextLine();
        System.out.println("Input coordinate 'x' organization: ");
        Long xC = scan.nextLong();
        System.out.println("Input coordinate 'y' organization: ");
        Double yC = scan.nextDouble();
        System.out.println("Input creation date organization in format 'yyyy-mm-dd': ");
        String date = scan.nextLine();
        System.out.println("Input annual turnover organization: ");
        Float annualTurnover;
        annualTurnover = scan.nextFloat();
        /*while (true) {
            if (scan.hasNextFloat()) {
                annualTurnover = scan.nextFloat();
                break;
            }
            else {
                System.out.println("Please input <float> number: ");
            }
        }*/
        System.out.println("Choose type of organization (commercial, public, government, trust, private_limited_company): ");
        String type = scan.nextLine();
        System.out.println("Input zipcode organization: ");
        String zipCode = scan.nextLine();
        System.out.println("Input street organization: ");
        String street = scan.nextLine();
        System.out.println("Input name of town organization: ");
        String town = scan.nextLine();
        System.out.println("Input coordinate -x- town: ");
        Integer xL = scan.nextInt();
        System.out.println("Input coordinate -y- town: ");
        Long yL = scan.nextLong();

        Organization t = new Organization(name, xC, yC, LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(), annualTurnover, OrganizationType.valueOf(type), new Address(zipCode, street, new Location(xL, yL, town)));
        org.addElement(t);
    }
}
