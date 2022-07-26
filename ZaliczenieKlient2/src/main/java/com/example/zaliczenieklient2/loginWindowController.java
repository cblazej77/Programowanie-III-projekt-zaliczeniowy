package com.example.zaliczenieklient2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class loginWindowController {
    @FXML
    private Label errorUsername;//pusty login
    @FXML
    private Label errorPassword;//puste haslo
    @FXML
    private TextField aLogin; //login z aplikacji
    @FXML
    private TextField aPassword; //haslo z aplikacji
    @FXML
    private Label errorLogin;

    @FXML
    protected void logInButton()throws IOException {
        if(aLogin.getLength() < 1) errorUsername.setText("Prosze uzupelnic login!");
        else errorUsername.setText("");
        if(aPassword.getLength() < 1) errorPassword.setText("Prosze uzupelnic haslo!");
        else errorPassword.setText("");
        if(aPassword.getLength() > 1 || aLogin.getLength() > 1) errorLogin.setText("Podany login i/lub haslo sa nieprawidlowe!");
        else{
            errorLogin.setText("");
            Application.setRoot("appWindow");
        }
    }
}