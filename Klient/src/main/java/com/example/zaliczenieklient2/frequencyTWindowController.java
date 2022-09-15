package com.example.zaliczenieklient2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class frequencyTWindowController implements Initializable {

    @FXML
    private ChoiceBox<?> classCheckBox;

    @FXML
    private Label classerrorLabel;

    @FXML
    private DatePicker frequencyDatePicker;

    @FXML
    private ListView<?> studentsListView;

    @FXML
    private ChoiceBox<?> subjectCheckBox;

    @FXML
    private Label subjecterrorLabel;


    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void absentButton(ActionEvent event) {

    }

    @FXML
    void exemptButton(ActionEvent event) {

    }

    @FXML
    void presentButton(ActionEvent event) {

    }
}
