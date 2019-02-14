package com.gmail.erofeev.st.alexei.controlTwo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlElement(name="PartNumber")
    private String partNumber;
    @XmlElement(name="ProductName")
    private String productName;
    @XmlElement(name="Quantity")
    private int quantity;
    @XmlElement(name="USPrice")
    private float usPrice;
    @XmlElement(name="Comment")
    private String comment;
    @XmlElement(name="ShipDate")
    private String shipDate;

    public Item() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUsPrice() {
        return usPrice;
    }

    public void setUsPrice(float usPrice) {
        this.usPrice = usPrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "partNumber='" + partNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", usPrice=" + usPrice +
                ", comment='" + comment + '\'' +
                ", shipDate='" + shipDate + '\'' +
                '}';
    }
}
