package Auxiliary;

import Organization.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Auxiliary.OrganizatonSort.sort;

public class Read_XML {
    public static Vector<Organization> CreateVector(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Vector<Organization> org = new Vector<>();
        ArrayList<Map> arr = new ArrayList<Map>();
        int i = 0;
        String str = "";
        String[] lines;
        int tId = (int)(Math.random() * 999999);
        String tName = null;
        Coordinates tCoordinates; //Поле не может быть null
        long xC = 0;
        double yC = 0;
        LocalDateTime tCreationDate = LocalDateTime.now();
        Float tAnnualTurnover = null;
        OrganizationType tType = null;
        Address tPostalAddress;
        String zipCode = null;
        String street = null;
        int xL = 0;
        long yL = 0;
        String town = null;
        String lastUpdate = null;

        try (Scanner reader = new Scanner(new FileReader(file.getAbsolutePath()))) {
            while (reader.hasNext()) {
                str += reader.next();
            }
            lines = str.split("><");
        }
        try {
            for (String el : lines) {
                if (el.equalsIgnoreCase("organization")) {
                    arr.add(new HashMap<String, String>());
                    continue;
                }
                if (el.equalsIgnoreCase("/organization")) {
                    i += 1;
                    continue;
                }
                if (arr.size() > i) {
                    if (el.equalsIgnoreCase("coordinates"))
                        continue;
                    if (el.equalsIgnoreCase("/coordinates"))
                        continue;
                    if (el.equalsIgnoreCase("postaladdress"))
                        continue;
                    if (el.equalsIgnoreCase("/postaladdress"))
                        continue;
                    if (el.equalsIgnoreCase("location"))
                        continue;
                    if (el.equalsIgnoreCase("/location"))
                        continue;
                    arr.get(i).put(el.substring(0, el.indexOf('>')), el.substring(el.indexOf('>') + 1, el.indexOf('<')));
                }
            }

            for (Map<String, String> m : arr) {
                for (String key : m.keySet()) {
                    final String value = m.get(key);

                    switch (key) {
                        case "id" -> tId = Integer.parseInt(value);
                        case "name" -> tName = value;
                        case "xc" -> xC = Long.parseLong(value);
                        case "yc" -> yC = Double.parseDouble(value);
                        case "date" -> tCreationDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
                        case "annualTurnover" -> tAnnualTurnover = Float.parseFloat(value);
                        case "type" -> tType = OrganizationType.valueOf(value);
                        case "zipCode" -> zipCode = value;
                        case "street" -> street = value;
                        case "xl" -> xL = Integer.parseInt(value);
                        case "yl" -> yL = Long.parseLong(value);
                        case "town" -> town = value;
                        case "lastUpdate" -> lastUpdate = value;
                    }
                }
                Organization t = new Organization(tName, xC, yC, tCreationDate, tAnnualTurnover, tType, new Address(zipCode, street, new Location(xL, yL, town)));
                t.setId(tId);
                t.setLastUpdate(lastUpdate);
                org.addElement(t);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {sort(org); return org;}

    }
}
