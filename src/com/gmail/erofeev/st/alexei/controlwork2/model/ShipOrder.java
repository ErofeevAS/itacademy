package com.gmail.erofeev.st.alexei.controlwork2.model;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "shiporder",namespace = "http://www.it-academy.by")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"orderid", "orderPerson", "shipto", "item"})

public class ShipOrder {
    @XmlAttribute( required = true)
    private int orderid;
    @XmlElement(name = "orderperson",required = true)
    private String orderPerson;
    @XmlElement(required = true)
    private ShipTo shipto;
    @XmlElement(required = true)
    private List<Item> item;

    public ShipOrder() {
        super();
    }

    public ShipOrder(int orderid, String orderPerson, ShipTo shipto, List<Item> items) {
        this.orderid = orderid;
        this.orderPerson = orderPerson;
        this.shipto = shipto;
        this.item = items;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrderPerson() {
        return orderPerson;
    }

    public void setOrderPerson(String orderPerson) {
        this.orderPerson = orderPerson;
    }

    public ShipTo getShipTo() {
        return shipto;
    }

    public void setShipTo(ShipTo shipto) {
        this.shipto = shipto;
    }

    public ShipTo getShipto() {
        return shipto;
    }

    public void setShipto(ShipTo shipto) {
        this.shipto = shipto;
    }

    public List<Item> getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "ShipOrder{" +
                "orderid=" + orderid +
                ", orderPerson='" + orderPerson + '\'' +
                ", shipto=" + shipto +
                ", item=" + item +

                '}';
    }
}
