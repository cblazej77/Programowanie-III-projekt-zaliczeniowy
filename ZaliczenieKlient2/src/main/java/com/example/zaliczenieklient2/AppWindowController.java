package com.example.zaliczenieklient2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppWindowController{

    @FXML
    private Label helloUser;

    public void initialize(){
        helloUser.setText("Witam po zalogowaniu");
    }




}
