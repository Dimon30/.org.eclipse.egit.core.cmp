import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class Test_Read_XML
{
    public static void main(String[] args)
    {
        File fXml=new File("Test_Read_XML.xml");
        
        try
        {
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document doc=db.parse(fXml);
            
            doc.getDocumentElement().normalize();
            System.out.println("Root element ["+doc.getDocumentElement().getNodeName()+"]");
            
            NodeList nodeLst=doc.getElementsByTagName("point");
            System.out.println("Points");
            for(int je=0;je<nodeLst.getLength();je++)
            {
                Node fstNode=nodeLst.item(je);
                if(fstNode.getNodeType()==Node.ELEMENT_NODE)
                {
                    Element elj=(Element)fstNode;
                    NodeList nljx=elj.getElementsByTagName("x");
                    Element eljx=(Element)nljx.item(0);
                    NodeList nljxc=eljx.getChildNodes();
                    NodeList nljy=elj.getElementsByTagName("y");
                    Element eljy=(Element)nljy.item(0);
                    NodeList nljyc=eljy.getChildNodes();
                    
                    System.out.println(
                      "x, y ["+((Node)nljxc.item(0)).getNodeValue()+", "+((Node)nljyc.item(0)).getNodeValue()+"]"
                      );
                }
            }
        }
        catch(Exception ei){}
    }
}