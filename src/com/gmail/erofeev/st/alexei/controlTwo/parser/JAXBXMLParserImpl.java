package com.gmail.erofeev.st.alexei.controlTwo.parser;


import com.gmail.erofeev.st.alexei.controlTwo.ParserService;
import com.gmail.erofeev.st.alexei.controlTwo.model.Item;
import com.gmail.erofeev.st.alexei.controlTwo.model.PurchaseOrder;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBXMLParserImpl implements ParserService {

    @Override
    public String parse(File xml, File xsd) {
        JAXBContext jaxbContext;
        StringBuilder response = new StringBuilder("{");
        int totalPrice = 0;

        try {
            jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PurchaseOrder purchaseOrder = (PurchaseOrder) jaxbUnmarshaller.unmarshal(xml);
            List<Item> items = purchaseOrder.getItem();
            System.out.println("JAXB PARSER:");
            for (Item item : items) {
                response.append(item.getProductName()).append("-").append(item.getUsPrice()).append(",");
                totalPrice += item.getUsPrice();
            }

        } catch (JAXBException e) {
            e.getMessage();
            e.printStackTrace();
        }
        response.substring(0, response.length() - 1);
        return response + ":totalprice is " + totalPrice + "}";

    }


}
