package model;

import java.io.Serializable;

public class ElectronicLeather extends Product implements Serializable {

    public ElectronicLeather(String ID, String name, Double price, int total, String branch, String idBySeller) {
        super(ID, name, price, total, branch, idBySeller);
    }

    public void display() {
        System.out.println("ID= "+getID()+ ", Name= "+getName()
                + ", Price= "+getPrice()+", Total="+getTotal()+", Branch= "+getBranch()+", isSeller= "+getIdBySeller());
    }

}
