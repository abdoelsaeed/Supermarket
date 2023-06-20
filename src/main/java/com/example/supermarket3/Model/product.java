package com.example.supermarket3.Model;

import com.example.supermarket3.control.coonection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class product {

  public int id,number,discount;
  public String name,type;
   public double price;

    public product(int id, int number, int discount, String name, String type, double price) {
        this.id = id;
        this.number = number;
        this.discount = discount;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int numer) {
        this.number = numer;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public ObservableList<product> getAllProduct()
    {
        ObservableList<product> production =FXCollections.observableArrayList();
        try {

            coonection con = new coonection();
            Connection c = con.getconnection();
            ResultSet result =  c.createStatement().executeQuery("SELECT * FROM product");

            while(result.next())
            {
                // if define object out while will store last row n time
                production.add(new product(result.getInt("id"),
                        result.getInt("number"),
                        result.getInt("discount"),
                        result.getString("name"),
                        result.getString("type"),
                        result.getDouble("price")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return production;
    }



    public ObservableList<product> search(String name){
        ObservableList product= FXCollections.observableArrayList();
        try {

            coonection con=new coonection();
            Connection s= coonection.getconnection();
            String q="SELECT * FROM product WHERE name LIKE '%"+name+"%'";
            Statement e=s.createStatement();
            ResultSet r=e.executeQuery(q);
            while (r.next()){
                product p=new product();
                p.setId(r.getInt(1));
                p.setName(r.getString(2));
                p.setPrice(r.getDouble(3));
                p.setNumber(r.getInt(4));
                p.setType(r.getString(5));
                p.setDiscount(r.getInt(6));
                product.add(p);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", number=" + number +
                ", discount=" + discount +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
