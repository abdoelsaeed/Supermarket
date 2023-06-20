package com.example.supermarket3.control;

import com.example.supermarket3.HelloApplication;
import com.example.supermarket3.control.coonection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class logincontrol {
    @FXML
    private PasswordField password;
    @FXML
    private Label result;
    @FXML
    private Button exit;
    @FXML
    private Button signin;

    @FXML
    private Button signup;

    @FXML
    private TextField username;
    @FXML
    void sign(ActionEvent event) {
        if(password.getText().isBlank()==false&&username.getText().isBlank()==false){
            islogin();
        }
        else
        {result.setText("Please, Enter User name and Password");}
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
    public void islogin(){
        try
        {
            coonection con = new coonection();
            Connection c = con.getconnection();
            Statement s = c.createStatement();
            String q="SELECT COUNT(1) FROM admins WHERE username='"+username.getText()+"' AND '"+password.getText()+"';";
            ResultSet r=s.executeQuery(q);
            while (r.next()){

                if(r.getInt(1)==1){
                    try{
                    result.setText("WELCOME");
                    Stage stage=new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(scene);
                    stage.show();}

                     catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{result.setText("failed");

                }


            }
        }
        catch (SQLException e){e.printStackTrace();}
    }
    @FXML
    void exit(ActionEvent event) {
        Stage stage=(Stage) exit.getScene().getWindow();
        stage.close();
    }
}