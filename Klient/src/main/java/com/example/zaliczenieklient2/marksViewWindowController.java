package com.example.zaliczenieklient2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class marksViewWindowController implements Initializable {
    @FXML
    private ChoiceBox<String> subjectChoiceBox;

    @FXML
    private ChoiceBox<String> classChoiceBox;

    @FXML
    private Label infoLabel;

    @FXML
    private TableView<LessonsTable> table;

    @FXML
    private TableColumn<LessonsTable, String> student;

    @FXML
    private TableColumn<LessonsTable, String> marks;

    @FXML
    private TableColumn<LessonsTable, String> avgMarks;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    @FXML
    void showMarksButton(ActionEvent event){

    }
}
