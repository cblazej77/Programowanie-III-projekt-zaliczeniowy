package com.example.zaliczenieklient2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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

    @FXML
    private Label label;

    @FXML
    private BorderPane mainPane;

    @FXML
    private void ocenyButton(ActionEvent event){
        System.out.println("Oceny click!");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("marksWindow");
        mainPane.setCenter(view);
    }

    @FXML
    private void frekwencjaButton(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("frequencyWindow");
        mainPane.setCenter(view);
    }

    @FXML
    private void uwagiButton(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("remarksWindow");
        mainPane.setCenter(view);
    }

    @FXML
    private void planlekcjiButton(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("lessonplanWindow");
        mainPane.setCenter(view);
    }

    @FXML
    private void uczenButton(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("studentWindow");
        mainPane.setCenter(view);
    }
}
