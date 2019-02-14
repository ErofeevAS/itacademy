package com.gmail.erofeev.st.alexei.controlTwo.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "PurchaseOrder", namespace = "http://www.it-academy.by")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"orderDate", "item"})
public class PurchaseOrder {
    @XmlAttribute(name = "OrderDate", required = true)
    private String orderDate;
    @XmlElement(name = "item", required = true)
    private List<Item> item;

    public PurchaseOrder() {
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> items) {
        this.item = item;
    }
}
