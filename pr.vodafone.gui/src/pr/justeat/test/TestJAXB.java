package pr.justeat.test;
import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import pr.justeat.sw.RestauranteList;

//xjc files\po.xsd -p mdiss.jaxb.example2.primer.po -d src

public class TestJAXB {
    
    // This sample application demonstrates how to modify a java content
    // tree and marshal it back to a xml data
    
    public static void main( String[] args ) {
        try {
        	
        	File file = new File("files/restaurantes-jaxb.xml");
            // create a JAXBContext capable of handling classes generated into
            // the primer.po package
            JAXBContext jc = JAXBContext.newInstance(RestauranteList.class);
            
            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();
            System.out.println(u);
            System.out.println(file);
            // unmarshal a po instance document into a tree of Java content
            // objects composed of classes from the primer.po package.
            RestauranteList restaurantes = (RestauranteList)u.unmarshal(file);

            // change the billto address
            //restaurantes.getRestauranteList().get(0).setNombre("Nombre nuevo");
            //address.setRegion( "REGION" );
            
            // create a Marshaller and marshal to a file
            Marshaller m = jc.createMarshaller();
            m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            m.marshal( restaurantes, new File("files/restaurantes-jaxb2.xml"));
            System.out.println("Done!");
            
        } catch( JAXBException je ) {
            je.printStackTrace();
        }
    }
    
    /** returns a JAXP 1.3 schema by parsing the specified resource. */
    static Schema getSchema(String schemaResourceName) throws SAXException {
        SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
        try {
            return sf.newSchema(new File(schemaResourceName));
        } catch (SAXException se) {
            // this can only happen if there's a deployment error and the resource is missing.
            throw se;
        }
    }
}
