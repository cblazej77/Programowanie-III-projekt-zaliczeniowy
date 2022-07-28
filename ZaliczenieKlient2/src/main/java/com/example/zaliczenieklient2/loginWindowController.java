package com.example.zaliczenieklient2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable{
    @FXML
    private Label errorUsername;//pusty login
    @FXML
    private Label errorPassword;//puste haslo
    @FXML
    private TextField aLogin; //login z aplikacji
    @FXML
    protected TextField aPassword; //haslo z aplikacji
    @FXML
    private Label errorLogin;

    private Client client;

    @FXML
    protected void logInButton()throws IOException {
        if(aLogin.getLength() < 1) errorUsername.setText("Prosze uzupelnic login!");
        else {errorUsername.setText("");errorLogin.setText("");}
        if(aPassword.getLength() < 1) errorPassword.setText("Prosze uzupelnic haslo!");
        else {errorPassword.setText("");errorLogin.setText("");}

        System.out.println(aPassword.getText());
        System.out.println(aLogin.getText());

        if(aPassword.getText().length() >= 1 || aLogin.getText().length() >= 1){
            client.sendLogPassToSerwer(aLogin.getText(), aPassword.getText()); //wysyla login i haslo do serwera
            if(client.authorizationLogin()) Application.setRoot("appWindow");//sprawdza czy wpisalismy poprawny login i haslo
            else errorLogin.setText("Podany login i/lub haslo sa nieprawidlowe");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            client = new Client(new Socket("localhost", 8081));
            System.out.println("connected to server.");
        }catch (IOException e){e.printStackTrace();}
    }

}
