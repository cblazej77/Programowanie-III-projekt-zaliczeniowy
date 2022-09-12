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
    private TextField addStudentNumberText;

    @FXML
    private TextField addStudentClassNameText;

    @FXML
    private TextField addStudentUserLoginText;

    @FXML
    private TextField addUserLoginText;

    @FXML
    private TextField addUserPasswordText;

    @FXML
    private TextField addUserFirstNameText;

    @FXML
    private TextField addUserSurnameText;

    @FXML
    private TextField addUserAccessText;

    @FXML
    private TextField addTeacherUsLoginText;

    @FXML
    private TextField addSubjectNameText;

    @FXML
    private TextField addClassDateText;

    @FXML
    private TextField addClassTeacherText;


    @FXML
    private TextField removeClassLoginText;

    @FXML
    private TextField addMarkNameText;

    @FXML
    private TextField addMarkValueText;

    @FXML
    private TextField addMarkSubNameText;

    @FXML
    private TextField addMarkULoginText;

    @FXML
    private TextField removeMarkNameText;

    @FXML
    private TextField removeMarkValueText;

    @FXML
    private TextField removeMarkUloginText;

    @FXML
    private TextField removeMarkSubNameText;

    @FXML
    private TextField removeStudentLoginText;

    @FXML
    private TextField removeSubjectNameText;

    @FXML
    private TextField removeTeacherLoginText;

    @FXML
    private TextField addLessonThemeText;

    @FXML
    private TextField addLessonDateText;

    @FXML
    private TextField addLessonHourText;

    @FXML
    private TextField addLessonClassText;

    @FXML
    private TextField addLessonTeacherText;

    @FXML
    private TextField addLessonSubjectText;
    
    @FXML
    private TextField removeLessonDateText;

    @FXML
    private TextField removeLessonHourText;
    
    @FXML
    private TextField removeLessonClassText;
    
    @FXML
    private TextField removeLessonTeacherLoginText;
    
    @FXML
    private TextField removeLessonSubjectText;
    
    @FXML
    private TextField removeUserLoginText;
    
    @FXML
    private TextField removeFrequencyDateText;

    @FXML
    private TextField removeFrequencySubNameText;

    @FXML
    private TextField removeFrequencyULoginText;

    @FXML
    private TextField removeFrequencyHourText;

    @FXML
    private TextField removeFrequencyClassText;

    @FXML
    private TextField addFrequencyDateText;

    @FXML
    private TextField addFrequencySubNameText;

    @FXML
    private TextField addFrequencyStudentLoginText;

    @FXML
    private TextField addFrequencyHourText;

    @FXML
    private TextField addFrequencyTypeText;

    @FXML
    private TextField addFrequencyClassText;
    
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
    void RemoveUserButton(ActionEvent event) {
        if(removeUserLoginText.getText().length()>0){
            client.SendRemoveSygnal(removeUserLoginText.getText(), 1);
        }
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

    public void AddStudentButton(ActionEvent actionEvent) {
    }
}
