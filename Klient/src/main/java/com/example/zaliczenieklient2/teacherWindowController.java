package com.example.zaliczenieklient2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class teacherWindowController implements Initializable {
    @FXML
    private Text Tname;
    @FXML
    private Text Tsurname;
    @FXML
    private Text Tclass;
    @FXML
    private Text Tsubjects;

    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        client = data.getClient();
        serwer = client.getData();

        Tname.setText(serwer.optString("imie"));
        Tsurname.setText(serwer.optString("nazwisko"));
        //Tclass.setText(serwer.optString("klasa"));
    }
}
