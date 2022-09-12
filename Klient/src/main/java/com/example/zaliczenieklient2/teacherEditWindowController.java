package com.example.zaliczenieklient2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    void transferStudentButton(ActionEvent event) {

    }

    @FXML
    void removeUserByLoginButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        if(removeUserLoginText.getText().length()>0){
            client.SendRemoveSygnal(removeUserLoginText.getText(), 0);
        }
    }

    @FXML
    void removeStudentByLoginButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        if(removeStudentLoginText.getText().length()>0){
            client.SendRemoveSygnal(removeStudentLoginText.getText(),1);
        }
    }

    @FXML
    void removeTeacherByLoginButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        if(removeTeacherLoginText.getText().length()>0){
            client.SendRemoveSygnal(removeTeacherLoginText.getText(),2);
        }
    }

    @FXML
    void removeSubjectByNameButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        if(removeSubjectNameText.getText().length()>0){
            client.SendRemoveSygnal(removeSubjectNameText.getText(),3);
        }
    }

    @FXML
    void removeClassByName(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
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
    void removeTurnoutByID(ActionEvent event) {

    }

    @FXML
    void addUserButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(7);
        List<String> Data=null;
        String uLogin = addUserLoginText.getText();
        String uPassword = addUserPasswordText.getText();
        String uName = addUserFirstNameText.getText();
        String uSurname = addUserSurnameText.getText();
        String uAccess = addUserAccessText.getText();
        if(uLogin.length()>0&&uPassword.length()>0&&uName.length()>0&&uSurname.length()>0&&uAccess.length()>0){
            Data.add(uLogin);
            Data.add(uPassword);
            Data.add(uName);
            Data.add(uSurname);
            Data.add(uAccess);
            client.SendAddSignal(Data,0,5);
        }
    }

    @FXML
    public void addStudentButton(ActionEvent event) {
    }

    @FXML
    void AddTeacherButton(ActionEvent event) {

    }
}
