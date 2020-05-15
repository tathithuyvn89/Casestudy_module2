package model;

import java.io.Serializable;

public class Mobile extends Product implements Serializable {

    public Mobile(String ID, String name, Double price, int total, String branch, String idBySeller) {
        super(ID, name, price, total, branch, idBySeller);
    }

    @Override
    public void display() {
        System.out.println("ID= "+getID()+ ", Name= "+getName()
                + ", Price= "+getPrice()+", Total= "+getTotal()+", Branch= "+getBranch()+", isSeller= "+getIdBySeller());
    }
}
