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
    private TextField removeMarkTeacherLoginText1;

    @FXML
    private TextField addStudentParentLoginText;

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

    int idClass;
    String loginTeacher;
    SendDataToContoller data = SendDataToContoller.getInstance();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = data.getClient();
        //serwer = client.getData();
        //odbior danych
        //idClass //czy nauczyciel opiekuje się tylko jedną klasą?
        loginTeacher="";
        //jeszcze jakas lista/vektor czego uczy dany nauczyciel
        //druga lista/vektor jakie klasy uczy nauczyciel
    }

    @FXML
    void removeUserByLoginButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        List<String> Data=null;
        if(removeUserLoginText.getText().length()>0){
            Data.add(removeUserLoginText.getText());
            client.SendRemoveSignal(Data, 0, 1);
        }
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
    void removeStudentByLoginButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        List<String> Data=null;
        if(removeStudentLoginText.getText().length()>0){
            Data.add(removeStudentLoginText.getText());
            client.SendRemoveSignal(Data,1,1);
        }
    }

    @FXML
    public void addStudentButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(7);
        List<String> Data=null;
        if(addStudentNumberText.getText().length()>0&&addStudentClassNameText.getText().length()>0&&addStudentUserLoginText.getText().length()>0&&addStudentParentLoginText.getText().length()>0){
            Data.add(addStudentNumberText.getText());
            Data.add(addStudentClassNameText.getText());
            Data.add(addStudentUserLoginText.getText());
            Data.add(addStudentParentLoginText.getText());
            client.SendAddSignal(Data,1,4);
        }
    }

    @FXML
    void removeTeacherByLoginButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        List<String> Data=null;
        if(removeTeacherLoginText.getText().length()>0){
            Data.add(removeTeacherLoginText.getText());
            client.SendRemoveSignal(Data,2,1);
        }
    }

    @FXML
    void AddTeacherButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(7);
        List<String> Data=null;
        if(addTeacherUsLoginText.getText().length()>0){
            client.SendAddSignal(Data,2,1);
        }
    }

    @FXML
    void removeSubjectByNameButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        List<String> Data=null;
        if(removeSubjectNameText.getText().length()>0){
            Data.add(removeSubjectNameText.getText());
            client.SendRemoveSignal(Data,3,1);
        }
    }

    @FXML
    void addSubjectButton(ActionEvent event) throws JSONException, IOException {
        client.sendCase(7);
        List<String> Data=null;
        if(addSubjectNameText.getText().length()>0){
            Data.add(addSubjectNameText.getText());
            client.SendAddSignal(Data,3,1);
        }
    }

    @FXML
    void removeMarkByID(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        List<String> Data=null;
        if(removeMarkNameText.getText().length()>0 && removeMarkValueText.getText().length()>0 && removeMarkUloginText.getText().length()>0 && removeMarkSubNameText.getText().length() >0 && removeMarkTeacherLoginText1.getText().length()> 0) {
            if(loginTeacher.equals(removeMarkTeacherLoginText1.getText())) {//sprawdzic czy nauczyciel jest tym od tego przedmiotu
                Data.add(removeMarkNameText.getText());
                Data.add(removeMarkValueText.getText());
                Data.add(removeMarkUloginText.getText());
                Data.add(removeMarkSubNameText.getText());
                client.SendRemoveSignal(Data, 6,4);
            }
        }
    }

    @FXML
    void removeClassByName(ActionEvent event) throws JSONException, IOException {
        client.sendCase(6);
        List<String> Data=null;
            if(removeClassLoginText.getText().length()>0){
                Data.add(removeClassLoginText.getText());
                client.SendRemoveSignal(Data, 6,1);
            }
    }

    @FXML
    void removeLessonByID(ActionEvent event) throws JSONException, IOException{

    }

    @FXML
    void removeTurnoutByID(ActionEvent event) {

    }

    @FXML
    void transferStudentButton(ActionEvent event) {

    }
}
