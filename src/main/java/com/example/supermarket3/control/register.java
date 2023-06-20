package com.example.supermarket3.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class register {

    @FXML
    private Button close;

    @FXML
    private PasswordField cpassword;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private Label result;

    @FXML
    private TextField user;

    @FXML
    void close(ActionEvent event) {
        Stage stage=(Stage) close.getScene().getWindow();
        stage.close();
    }

    @FXML
    void register(ActionEvent event) {
        if(password.getText().isBlank()==false&&user.getText().isBlank()==false&&password.getText().equals(cpassword.getText())){
coonection con=new coonection();
        Connection c=con.getconnection();
        String q="INSERT INTO admins(username,password) VALUES('"+user.getText()+"','"+password.getText()+"')";
        try {
            Statement s=c.createStatement();
            s.execute(q);
        }
        catch (SQLException e)
        {e.printStackTrace();}
result.setText("DONE");    }
    else {
        result.setText("Enter the data correctly");
        }
    }

}
