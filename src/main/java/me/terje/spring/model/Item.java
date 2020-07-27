package me.terje.spring.model;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    private int id;
    private int orderId;
    private String name;
    private String code;//商品编号
    private Date productDate;//生产日期
    private Date addDate;//上架日期

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", productDate=" + productDate +
                ", addDate=" + addDate +
                '}';
    }
}
