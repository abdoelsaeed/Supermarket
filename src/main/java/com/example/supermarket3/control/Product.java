package com.example.supermarket3.control;


import com.example.supermarket3.HelloApplication;
import com.example.supermarket3.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.sql.*;

import java.util.ResourceBundle;

public class Product implements Initializable {
    @FXML
    private Button close;
    @FXML
    private TableColumn<product,Integer> discount;

    @FXML
    private TextField discountt;

    @FXML
    private TableColumn<product,Integer> id;

    @FXML
    private TableView<product> mum;

    @FXML
    private TableColumn<product,String> name;

    @FXML
    private TextField namee;

    @FXML
    private TableColumn<product,Integer> number;

    @FXML
    private TextField numberr;

    @FXML
    private TableColumn<product,Double> price;

    @FXML
    private TextField pricee;

    @FXML
    private TableColumn<product,String> type;
    @FXML
    private TextField typee;
    @FXML
    private TextField search;
    product r=new product();

    @FXML
    void backhome(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void add(ActionEvent event) {
insert();
    }


    @FXML
    void search(ActionEvent event) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
mum.setItems(r.search(search.getText()));
    }

    @FXML
    void update(ActionEvent event) {
        try {
            coonection con=new coonection();
            Connection s=con.getconnection();
            String q="UPDATE product SET name='"+namee.getText()+"', number = "+numberr.getText()+",price ="+pricee.getText()+",type ='"+typee.getText()+"',discount = "+discountt.getText()+" WHERE name='"+namee.getText()+"'";
            Statement e=s.createStatement();
            e.execute(q);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void insert(){

        try {
            coonection con=new coonection();
            Connection s= coonection.getconnection();
            String q="INSERT INTO product(name,number,price,type,discount) VALUES('"+namee.getText()+"',"+numberr.getText()+","+pricee.getText()+",'"+typee.getText()+"',"+discountt.getText()+")";
            Statement e=s.createStatement();
            e.execute(q);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void delete(ActionEvent event) {
        try {
            coonection con=new coonection();
            Connection s=con.getconnection();
            String q="DELETE FROM product WHERE name='"+namee.getText()+"'";
            Statement e=s.createStatement();
            e.execute(q);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //refere to attribute
        coonection con=new coonection();
        Connection s= coonection.getconnection();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));

        //show data
        mum.setItems(r.getAllProduct());

    }
    @FXML
    void close(ActionEvent event) {
        Stage stage=(Stage) close.getScene().getWindow();
        stage.close();
    }




    @FXML
    void refresh(ActionEvent event)  {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        mum.setItems(refrechs());
    }
private  ObservableList<product> refrechs(){
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
}





