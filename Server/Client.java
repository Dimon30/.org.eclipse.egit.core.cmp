package Server;

import Commands.*;
import Organization.Organization;

import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Client {
    private Vector<Organization> org;
    public Client(Vector<Organization> org){
        this.org = org;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        //Show.show();
        Help.help();
        System.out.print("Input command: ");
        loop(scanner);
    }

    /**
     * Loop of client commands.
     */
    public void loop(Scanner scan) {
        while (scan.hasNext()) {
            String command = scan.nextLine();
            switch (command) {
                case "help" -> Help.help();
                case "info" -> Info.info(this.org);
                case "show" -> Show.show(this.org);
                case "add" -> Add.add(scan, this.org);
                case "update" -> Update.update(scan, this.org);
                case "remove" -> Remove.remove(scan, this.org);
                case "clear" -> {
                    Clear.clear(org);
                    System.out.println("Now the collection is empty.\n");
                }
                case "save" -> {
                    System.out.print("Input filename: ");
                    String outfile = scan.nextLine();
                    Save.save(outfile, org);
                }
                case "exit" -> Exit.exit();/*
                case "execute_script" -> {
                    System.out.println("Input filename");
                    execute_script(scan.nextLine());
                }
                case "print_field_descending_distance" -> {
                    print_field_descending_distance();
                }
                case "filter_greater_than_distance" -> {
                    filter_greater_than_distance(scan);
                }*/
                default -> System.out.println(command + ": this command doesn't exist.");
            }

            System.out.print("Input command: ");
        }
        scan.close();
    }
}
