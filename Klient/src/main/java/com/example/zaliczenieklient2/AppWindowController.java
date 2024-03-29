package com.example.zaliczenieklient2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppWindowController implements Initializable {

    @FXML
    private Text welcome;
    @FXML
    private BorderPane mainPane;

    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        client = data.getClient();//dzieki temu mamy dostep do serwera poprzez gniazdo, nie tworzac nowego
        serwer = client.getData();
        String name = serwer.optString("imie");
        welcome.setText("Witaj " + name + "!");
    }

    @FXML
    private void logout(ActionEvent event){
        client = null;
        data.setClient(client);
        try {
            Application.setRoot("loginWindow");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void ocenyButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(0);
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("marksWindow");
        mainPane.setCenter(view);
    }
    @FXML
    private void frekwencjaButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(1);
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("frequencyWindow");
        mainPane.setCenter(view);
    }
    @FXML
    private void planlekcjiButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(2);
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("lessonsplanWindow");
        mainPane.setCenter(view);
    }
    @FXML
    private void uczenButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(3);
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("userWindow");
        mainPane.setCenter(view);
    }

    @FXML
    private void ocenyTButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(0);
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("marksTWindow");
        mainPane.setCenter(view);
    }
    @FXML
    private void daneTButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(2);
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("editDBWindow");
        mainPane.setCenter(view);
    }

    @FXML
    private void teacherTButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(3);
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("teacher");
        mainPane.setCenter(view);
    }


}