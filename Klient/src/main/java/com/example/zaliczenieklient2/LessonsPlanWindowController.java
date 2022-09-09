package com.example.zaliczenieklient2;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONObject;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LessonsPlanWindowController implements Initializable {
    @FXML
    private TableView<LessonsPlanTable> table;

    @FXML
    private TableColumn<LessonsPlanTable, Integer> hour;

    @FXML
    private TableColumn<LessonsPlanTable, String> monday;

    @FXML
    private TableColumn<LessonsPlanTable, String> tuesday;

    @FXML
    private TableColumn<LessonsPlanTable, String> thursday;

    @FXML
    private TableColumn<LessonsPlanTable, String> wendesday;

    @FXML
    private TableColumn<LessonsPlanTable, String> friday;

    private Client client;
    private JSONObject serwer;
    private LessonsPlanTable l;

    SendDataToContoller data = SendDataToContoller.getInstance();
    //ObservableList<LessonsPlanTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        client = data.getClient();
        serwer = client.getData();
        Integer n = serwer.optInt("size");
        System.out.println(n);
        for(int i=0;i<n;i++){
            serwer = client.getData();
            String s = serwer.optString("id");
            System.out.println(s);

        }
        //monday.setCellValueFactory(new PropertyValueFactory<LessonsPlanTable,String>("id0"));

    }

}

