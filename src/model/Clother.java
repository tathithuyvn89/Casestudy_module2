package model;

import java.io.Serializable;

public class Clother extends Product implements Serializable {
    private String color;

    public Clother(String ID, String name, Double price, int total, String branch, String idBySeller, String color) {
        super(ID, name, price, total, branch, idBySeller);
        this.color = color;
    }

    @Override
    public void display() {

    }
}
