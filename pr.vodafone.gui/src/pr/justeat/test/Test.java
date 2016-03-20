package pr.justeat.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;


//xjc files\po.xsd -p mdiss.jaxb.example2.primer.po -d src

public class Test {
    
    // This sample application demonstrates how to modify a java content
    // tree and marshal it back to a xml data
    
    public static void main( String[] args ) {
        try {
            // create a JAXBContext capable of handling classes generated into
            // the primer.po package
            JAXBContext jc = JAXBContext.newInstance( "pr.justeat.dao.dto" );
            
            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();
            
            // validation
            SchemaFactory schemaFactory=SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new File("./files/schema.xsd"));
            u.setSchema(schema);
            
            // unmarshal a po instance document into a tree of Java content
            // objects composed of classes from the primer.po package.
            JAXBElement<Restaurante> poe = (JAXBElement<Restaurante>)u.unmarshal(new FileInputStream("./files/po.xml"));
            Restaurante po = poe.getValue();

            // change the billto address
            USAddress address = po.getBillTo();
            address.setName( "John Bob" );
            address.setStreet( "242 Main Street" );
            address.setCity( "Beverly Hills" );
            address.setState( "CA" );
            address.setZip( new BigDecimal( "90210" ) );
            //address.setRegion( "REGION" );
            
            // create a Marshaller and marshal to a file
            Marshaller m = jc.createMarshaller();
            m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            m.marshal( poe, new File("./files/po2.xml"));
            System.out.println("Done!");
            
        } catch( JAXBException je ) {
            je.printStackTrace();
        } catch( IOException ioe ) {
            ioe.printStackTrace();
        } catch (SAXException e) {
			e.printStackTrace();
		}
    }
}
