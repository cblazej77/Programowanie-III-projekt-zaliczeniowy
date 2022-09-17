package com.example.zaliczenieklient2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    @FXML
    private Text errorText;

    private Client client;
    private JSONObject serwer;

    String loginTeacher;

    SendDataToContoller data = SendDataToContoller.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        client = data.getClient();
    }

    @FXML
    void addmarkButton(ActionEvent event) throws JSONException, IOException {
        if(Tname.getText().length() > 0 && Tmark.getText().length() > 0 && Tdiarynr.getText().length() > 0 &&
                Tclass.getText().length() > 0 && Tsubject.getText().length() > 0){
            client.sendCase(9);
            client.SendString(Tsubject.getText());
            serwer = client.getData();
            if(serwer.optBoolean("boolean")) {
                client.sendCase(11);
                client.SendString(Tclass.getText());
                serwer = client.getData();
                if(serwer.optBoolean("boolean")) {
                    List<String> Data = null;
                    Data.add(Tname.getText());
                    Data.add(Tmark.getText());
                    Data.add(Tdiarynr.getText());
                    Data.add(Tclass.getText());
                    Data.add(Tsubject.getText());
                    client.sendCase(6);
                    client.SendEditSignal(Data, 10,5);
                    errorText.setText("Dodano ocenę!");
                }
                else{
                    errorText.setText("Nie uczysz takiej klasy!");
                }
            }
            else{
                errorText.setText("Nie prowadzisz takiego przedmiotu!");
            }
        }
    }
}
