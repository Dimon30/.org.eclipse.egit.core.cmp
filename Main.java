/* FILE NAME   : Main.java
 * PROGRAMMER  : DS6
 * @author     : Sokolov Dmitry
 * LAST UPDATE : 25.02.2023
 * PURPOSE     : Main file
 */

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "Organizations.xml";
		Vector Organizations = new Vector();
		//String filename = args[0];
		System.out.println(filename);
		
		File XMLfile = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			Document doc = (Document) dBuilder.parse(XMLfile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
