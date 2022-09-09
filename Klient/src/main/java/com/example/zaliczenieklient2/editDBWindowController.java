package com.example.zaliczenieklient2;

import javafx.fxml.Initializable;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class editDBWindowController implements Initializable{
    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
            client = data.getClient();
            serwer = client.getData();



        }

}
