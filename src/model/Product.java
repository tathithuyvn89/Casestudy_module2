package model;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String ID;
    private String name;
    private Double price;
    private String branch;
    private String idBySeller;
    private int total;

    public Product(String ID, String name, Double price,int total, String branch, String idBySeller) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.total=total;
        this.branch = branch;
        this.idBySeller = idBySeller;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getIdBySeller() {
        return idBySeller;
    }

    public void setIdBySeller(String idBySeller) {
        this.idBySeller = idBySeller;
    }
     public abstract void display();

}
