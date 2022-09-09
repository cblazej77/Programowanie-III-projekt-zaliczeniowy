package com.example.zaliczenieklient2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class marksTWindowController implements Initializable {
    @FXML
    TextField Tclass;
    @FXML
    TextField Tdiarynr;
    @FXML
    TextField Tname;
    @FXML
    TextField Tmark;


    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        client = data.getClient();
        serwer = client.getData();


    }
}
