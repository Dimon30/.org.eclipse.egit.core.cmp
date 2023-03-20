package Commands;

import Auxiliary.Write_XML;
import Organization.Organization;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Execute_script {
    private static final String name = "execute_script";
    private final static String description = ": Load commands from file;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}

    public static void execute_script(String filename, Vector<Organization> org){
        File file = new File(filename);
        String str = "";
        String[] lines;
        try (Scanner reader = new Scanner(new FileReader(file.getAbsolutePath()))) {
            while (reader.hasNext()) {
                str += reader.next();
            }
            lines = str.split(".");
            for (String line : lines)
                Command.command(line);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
