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
    private Text parentname;
    @FXML
    private Text parentsurname;
    @FXML
    private Text studentclass;
    @FXML
    private Text diarynumber;

    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        client = data.getClient();
        serwer = client.getData();

        String Sname = serwer.optString("imie");
        String Ssurname = serwer.optString("nazwisko");

        Tname.setText(Sname);
        Tsurname.setText(Ssurname);
    }
}
