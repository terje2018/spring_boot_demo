package me.terje.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
    private int id;
    private String code;
    private float price;
    private int customerId;//客户
    private Logistics logistics;//物流
    private Date orderDate;//下订单时间
    private List<Item> items;//商品 one vs many

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Logistics getLogistics() {
        return logistics;
    }

    public void setLogistics(Logistics logistics) {
        this.logistics = logistics;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", customerId=" + customerId +
                ", logistics=" + logistics +
                ", orderDate=" + orderDate +
                ", items=" + items +
                '}';
    }
}
