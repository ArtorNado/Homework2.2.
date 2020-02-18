package facade;

import Node.Tree;
import Node.Tree.KnotNode;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class FacadeForXML {

    private static FacadeForXML instatce;

    private FacadeForXML() {
    }

    public static FacadeForXML getInstance() {
        if (instatce == null) instatce = new FacadeForXML();
        return instatce;
    }

    public void writeInXML(KnotNode knotNode) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tree.KnotNode.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File("XMLnode.xml");
            jaxbMarshaller.marshal(knotNode, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void readXML(String fileName) {

        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(KnotNode.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            KnotNode knotNode = (KnotNode) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(knotNode.getTitle());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
