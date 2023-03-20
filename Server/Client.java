package Server;

import Commands.*;
import Organization.Organization;

import java.util.*;

public class Client {
    private Vector<Organization> org;
    private final Deque<String> history = new ArrayDeque<>(8);
    public Client(Vector<Organization> org){this.org = org;}
    public void run() {
        Scanner scanner = new Scanner(System.in);
        //Show.show();
        Help.help();
        //System.out.print("Input command: ");
        loop(scanner);
    }

    private void memorize(final String command) {
        history.offer(command);

        if (history.size() > 8) {
            history.pop();
        }
    }

    /**
     * Loop of client commands.
     */
    public void loop(Scanner scan) {
        while (true) {
            System.out.print("Input command: ");

            if (!scan.hasNext()) {
                break;
            }

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
                case "execute_script" -> {
                    System.out.print("Input filename: ");
                    Execute_script.execute_script(scan.nextLine(), org);
                }
                case "exit" -> Exit.exit();
                case "reorder" -> Reorder.reorder(org);
                case "sort" -> Sort.sort(org);
                case "history" -> History.history(history);
                /*
                case "print_field_descending_distance" -> {
                    print_field_descending_distance();
                }
                case "filter_greater_than_distance" -> {
                    filter_greater_than_distance(scan);
                }*/
                default -> {
                    System.out.println(command + ": this command doesn't exist.");
                    continue;
                }
            }

            memorize(command);
        }

        scan.close();
    }
}
