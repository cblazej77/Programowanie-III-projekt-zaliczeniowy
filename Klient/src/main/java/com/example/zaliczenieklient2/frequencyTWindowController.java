package com.example.zaliczenieklient2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.net.URL;
import java.util.ResourceBundle;

public class frequencyTWindowController implements Initializable {


    @FXML
    private Label classerrorLabel;

    @FXML
    private DatePicker frequencyDatePicker;

    @FXML
    private TableColumn<FrequencyTable, Integer> id;
    @FXML
    private TableColumn<FrequencyTable, String> name;
    @FXML
    private TableColumn<FrequencyTable, String> surname;

    @FXML
    private TableColumn<FrequencyTable, String> presents;

    @FXML
    private TableColumn<FrequencyTable, String> absent;

    @FXML
    private TableColumn<FrequencyTable, String> exempt;

    @FXML
    private ChoiceBox<String> subjectCheckBox;
    @FXML
    private ChoiceBox<String> classCheckBox;

    @FXML
    private Label subjecterrorLabel;

    @FXML Label errorFrequency;

    @FXML
    private TableView<FrequencyTable> table;

    private Client client;
    private JSONObject serwer;
    private Boolean goodSubject= false, goodClass =false;

    SendDataToContoller data = SendDataToContoller.getInstance();
    ObservableList<FrequencyTable> list;

    ObservableList subjects = FXCollections.observableArrayList();
    ObservableList clasS = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        client = data.getClient();
        loadSubject();//zaladowuje przedmioty do ChoiceBox
        loadClass();//zaladowuje kladdo co choiceBox
        //goodSubject = checkTeacher();//sprawdza czy nauczyciel uczy tego przedmiotu
        checkData();
    }

    @FXML
    void clickSubjectBox() throws JSONException, IOException {
        client.sendCase(9);
        goodSubject = checkTeacher();
        checkData();
    }
    @FXML
    void clickClassBox(){
        goodClass = checkClass();
        checkData();
    }

    private void setTbleView() throws JSONException, IOException {
        client = data.getClient();
        client.sendCase(10);
        client.SendString(classCheckBox.getValue());
        list = FXCollections.observableArrayList();
        serwer = client.getData();
        int size = serwer.optInt("size");
        String cId, cName, cSurname;
        for(int i =0; i< size; i++){
            serwer = client.getData();
            cId = serwer.optString("id");
            cName = serwer.optString("name");
            cSurname = serwer.optString("surname");
            list.addAll(new FrequencyTable(cId, cName, cSurname, "", "", ""));
        }

        name.setCellValueFactory(new PropertyValueFactory<FrequencyTable, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<FrequencyTable, Integer>("id"));
        surname.setCellValueFactory(new PropertyValueFactory<FrequencyTable, String>("surname"));
        presents.setCellValueFactory(new PropertyValueFactory<FrequencyTable, String>("presents"));
        absent.setCellValueFactory(new PropertyValueFactory<FrequencyTable, String>("absent"));
        exempt.setCellValueFactory(new PropertyValueFactory<FrequencyTable, String>("exempt"));
        table.setItems(list);
    }
    private void checkData(){
        if(goodSubject && goodClass) {
            try {
                setTbleView();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            list = FXCollections.observableArrayList();
            list.removeAll(list);
            table.setItems(list);
        }
    }
    private Boolean checkClass(){
        String chooseClass = classCheckBox.getValue();
        if(chooseClass == null) classerrorLabel.setText("Wybierz klase");
        else{
            classerrorLabel.setText("Wybrano poprawnie");
            return true;
        }
        return false;
    }
    private Boolean checkTeacher(){
        //client = data.getClient();
        String chooseSubject = subjectCheckBox.getValue();
        if(chooseSubject == null) subjecterrorLabel.setText("Wybierz przedmiot");
        else {
            client.SendString(chooseSubject);
            serwer = client.getData();
            if (serwer.optString("boolean").equals("Yes")) {
                subjecterrorLabel.setText("Wybrano poprawnie");
                return true;
            } else subjecterrorLabel.setText("Nie uczysz tego przedmiotu!");
        }
        return false;
    }
    private void loadSubject(){
        client = data.getClient();
        serwer = client.getData();
        subjects.removeAll(subjects);
        int sizeSubject = serwer.optInt("size");
        String subjectName;
        for(int i =0; i<sizeSubject; i++){
            serwer = client.getData();
            subjectName = serwer.optString("subject");
            subjects.add(subjectName);
        }
        subjectCheckBox.setItems(subjects);
    }
    private void loadClass(){
        client = data.getClient();
        serwer = client.getData();
        clasS.removeAll(clasS);
        int sizeClass = serwer.optInt("size");
        String className;
        for(int i =0; i<sizeClass; i++){
            serwer = client.getData();
            className = serwer.optString("Class");
            clasS.add(className);
        }
        classCheckBox.setItems(clasS);
    }
    boolean checkCheckBoxes(){
        for(FrequencyTable bean : list)
        {
            int suma = 0;
            if(bean.getExempt().isSelected())suma++;
            if(bean.getPresents().isSelected())suma++;
            if(bean.getAbsent().isSelected())suma++;
            if(suma != 1){
                errorFrequency.setText("Źle zaznaczona frekfencja");
                return false;
            }
            else errorFrequency.setText("");
        }
        return true;
    }
    @FXML
    void printSelected(ActionEvent event){
        ArrayList<String> presentsList = new ArrayList<>();
        ArrayList<String> absentList = new ArrayList<>();
        ArrayList<String> exemptList = new ArrayList<>();
        if(checkCheckBoxes()) {
            for (FrequencyTable bean : list) {
                if(bean.getPresents().isSelected()) presentsList.add(bean.getId()+" "+bean.getName() +" "+ bean.getSurname());
                if(bean.getAbsent().isSelected()) absentList.add(bean.getId()+" "+bean.getName() +" "+ bean.getSurname());
                if(bean.getExempt().isSelected()) exemptList.add(bean.getId()+" "+bean.getName() +" "+ bean.getSurname());
            }
            System.out.println("Obecni: " + presentsList);
            System.out.println("Nie Obecni: " + absentList);
            System.out.println("Zwolnieni: " + exemptList);
        }
    }
}
