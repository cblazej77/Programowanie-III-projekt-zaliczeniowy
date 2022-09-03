package com.example.zaliczenieklient2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.json.JSONObject;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppWindowController implements Initializable {

    @FXML
    private Label helloUser;
    @FXML
    private Label userData;

    private Client client;
    private JSONObject serwer;




    SendDataToContoller data = SendDataToContoller.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        client = data.getClient();//dzieki temy mamy dostep do serwera poprzez gniazdo, nie tworzac nowego
        serwer = client.getData();

        String name = serwer.optString("imie");
        String surname = serwer.optString("nazwisko");
        String access = serwer.optString("rola");

        helloUser.setText("Witam po zalogowaniu: " + data.getUsername());
        if(access.equals("UCZEN")) userData.setText("Dzien Dobry, " + name + " "+ surname +", zalogowales sie na konto ucznia.");
        else userData.setText("Dzien Dobry, " + name + " "+ surname +", zalogowales sie na konto " + access.toLowerCase()+"a.");
        System.out.println(name + " " + surname);

    }

}
