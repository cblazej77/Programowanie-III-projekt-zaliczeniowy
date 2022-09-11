package com.example.zaliczenieklient2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class MarksWindowController implements Initializable {

    @FXML
    private TableView<MarkTable> table;

    @FXML
    private TableColumn<MarkTable, String> subject;

    @FXML
    private TableColumn<MarkTable, String> marks;

    @FXML
    private TableColumn<MarkTable, Double> avgMarks;



    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

    public void initialize(URL url, ResourceBundle resourceBundle) {

        client = data.getClient();
        ObservableList<MarkTable> list = FXCollections.observableArrayList();

        String subName;//Name of subject
        Integer n;//size for
        for(int z = 0; z < 3; z ++) {
            serwer = client.getData();
            n = serwer.optInt("size");
            subName = serwer.optString("subject");
            double suma = 0;
            String marksString = "";
            for (int i = 0; i < n; i++) {
                serwer = client.getData();
                if (i == 0) marksString = serwer.optString("id");
                else marksString = marksString + ", " + serwer.optString("id");
                suma = suma + serwer.optInt("id");
            }
            suma = suma * 1.0 / n;
            if(marksString.equals("")) {marksString = "brak ocen!"; suma = 0.0;};
            list.addAll(new MarkTable(subName, marksString, suma));
        }

        subject.setCellValueFactory(new PropertyValueFactory<MarkTable, String>("subject"));
        marks.setCellValueFactory(new PropertyValueFactory<MarkTable, String>("marks"));
        avgMarks.setCellValueFactory(new PropertyValueFactory<MarkTable, Double>("avgMarks"));

        table.setItems(list);
    }

}
