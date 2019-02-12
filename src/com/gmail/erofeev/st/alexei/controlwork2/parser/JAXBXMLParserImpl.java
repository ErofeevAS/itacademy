package com.gmail.erofeev.st.alexei.controlwork2.parser;

import com.gmail.erofeev.st.alexei.controlwork2.XMLParser;
import com.gmail.erofeev.st.alexei.controlwork2.model.Item;
import com.gmail.erofeev.st.alexei.controlwork2.model.ShipOrder;
import com.gmail.erofeev.st.alexei.controlwork2.model.ShipTo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JAXBXMLParserImpl implements XMLParser {

    @Override
    public void showTitleAndPriceForItem(File file) {
        JAXBContext jaxbContext = null;

        try {
            jaxbContext = JAXBContext.newInstance(ShipOrder.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ShipOrder shipOrder = (ShipOrder) jaxbUnmarshaller.unmarshal(file);
            List<Item> items = shipOrder.getItem();
            System.out.println("JAXB PARSER:");
            for (Item item : items) {
                System.out.println(item.getTitle() + " price: " + item.getPrice());
            }

//            Item item1 = new Item("ball", "superball", 2, 5f);
//            Item item2 = new Item("ball", "superball", 2, 5f);
//            List<Item> items = new ArrayList<>();
//            items.add(item1);
//            items.add(item2);
//            ShipTo shipTo = new ShipTo("Alex", "pr. Pobedi", "Minsk", "blr");
//            ShipOrder shipOrder = new ShipOrder(123, "VASKA PUPKIN", shipTo, items);

//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.it-academy.by shiporder.xsd");
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(shipOrder, new File("country.xml"));
//            jaxbMarshaller.marshal(shipOrder, System.out);
//            System.out.println(shipOrder);
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
