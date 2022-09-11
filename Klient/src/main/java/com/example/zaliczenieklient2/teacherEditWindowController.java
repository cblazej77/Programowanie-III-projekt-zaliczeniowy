package com.example.zaliczenieklient2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.json.JSONObject;

import java.net.URL;
import java.util.ResourceBundle;

public class teacherEditWindowController implements Initializable {
    @FXML
    private TextField ParentIDText;

    @FXML
    private TextField StudentNumberText;

    @FXML
    private TextField UserIDText;

    @FXML
    private TextField accessUserText;

    @FXML
    private TextField hasloUserText;

    @FXML
    private TextField loginUserText;

    @FXML
    private TextField nameUserText;

    @FXML
    private TextField removeClassLoginText;

    @FXML
    private TextField removeLessonIDText;

    @FXML
    private TextField removeMarkIDText;

    @FXML
    private TextField removeStudentLoginText;

    @FXML
    private TextField removeSubjectNameText;

    @FXML
    private TextField removeTeacherLoginText;

    @FXML
    private TextField removeTurnoutIDText;

    @FXML
    private TextField removeUserLoginText;

    @FXML
    private TextField studentClassText;

    @FXML
    private TextField surnameUserText;

    @FXML
    private TextField teacherIDText;

    @FXML
    private TextField transerNewClassName;

    @FXML
    private TextField transferStudentLogin;
    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = data.getClient();

    }

    @FXML
    void AddStudentButton(ActionEvent event) {

    }

    @FXML
    void AddTeacherButton(ActionEvent event) {

    }

    @FXML
    void addUserButton(ActionEvent event) {

    }

    @FXML
    void removeClassByName(ActionEvent event) {
            if(removeClassLoginText.getText().length()>0){
                client.SendRemoveSygnal(removeClassLoginText.getText(), 6);
            }
    }

    @FXML
    void removeLessonByID(ActionEvent event) {

    }

    @FXML
    void removeMarkByID(ActionEvent event) {

    }

    @FXML
    void removeStudentByLoginButton(ActionEvent event) {

    }

    @FXML
    void removeSubjectByNameButton(ActionEvent event) {

    }

    @FXML
    void removeTeacherByLoginButton(ActionEvent event) {

    }

    @FXML
    void removeTurnoutByID(ActionEvent event) {

    }

    @FXML
    void removeUserByLoginButton(ActionEvent event) {

    }

    @FXML
    void transferStudentButton(ActionEvent event) {

    }

}
