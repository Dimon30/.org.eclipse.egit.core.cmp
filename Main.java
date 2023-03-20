/* FILE NAME   : Main.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 14.03.2023
 * PURPOSE     : Main file
 */

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Auxiliary.Read_XML;
import Auxiliary.Write_XML;
import Commands.*;
import Organization.*;
import Server.Client;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		//String filename = args[0];
		String filename = "Organizations.xml";
		String fileOut = "OutOrganizations.xml";
		Vector<Organization> Organizations = Read_XML.CreateVector(filename);
		Client client = new Client(Organizations);
		//ArrayList<Command> Commands = new ArrayList<>(Command);

		Organization KFC = new Organization("KFC", 900, 239.30, 100000F, OrganizationType.COMMERCIAL, new Address("23", "ulica", new Location(3, 20, "Spb")));
		Organizations.addElement(KFC);
		client.run();
		Write_XML.Write(Organizations, fileOut);
    }
}
