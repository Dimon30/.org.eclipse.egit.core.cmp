package Commands;

import Auxiliary.Write_XML;
import Organization.Organization;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Vector;

public class Save {
    private static final String name = "save";
    private final static String description = ": Save collection in file;";

    public static String getName(){return name;}
    public static String getDescription(){return description;}
    public static void save(String filename, Vector<Organization> org){
        try {
            filename = filename.split(".")[0];
            Write_XML.Write(org, "src/" + filename + ".xml");
        } catch (Exception e){
            System.out.println(filename);
            System.out.println(Arrays.toString(filename.split(".")));
        }
    }
}
