package com.example.zaliczenieklient2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class marksTWindowController implements Initializable {
    @FXML
    private TextField Tclass;

    @FXML
    private TextField Tdiarynr;

    @FXML
    private TextField Tmark;

    @FXML
    private TextField Tname;

    @FXML
    private TextField Tsubject;


    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        client = data.getClient();
        //serwer = client.getData();


    }

    @FXML
    void addmarkButton(ActionEvent event) {

    }
}
