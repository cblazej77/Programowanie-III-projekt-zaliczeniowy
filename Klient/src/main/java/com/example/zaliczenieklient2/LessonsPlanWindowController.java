package com.example.zaliczenieklient2;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import org.json.JSONObject;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class LessonsPlanWindowController implements Initializable {
    @FXML
    private GridPane gridPane;
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
    ObservableList<LessonsPlanTable> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        String[] days = new String[] {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
        LocalDate localDate = LocalDate.now();
                //System.out.println("LocalDate - System zone: " + localDate);
                //System.out.println("Day of week: " + localDate.getDayOfWeek());
                //String day = String.valueOf(localDate); //pobiera dzien tygodnia duzymi po angielsku

        Integer dayInt = localDate.getDayOfMonth(); // pobiera inta dzien miesiaca
        String setMonday="";    //wskaze kiedy bedzie poniedzialek
        for(int i =0; i<5; i++) if(String.valueOf(localDate.getDayOfWeek()).equals(days[i])) dayInt -= i;
        setMonday = String.valueOf(localDate).substring(0,8) + dayInt;

        System.out.println(localDate +" Poniedzialek wypada: " + setMonday);

        //SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        //Date date = new Date(System.currentTimeMillis());
        //System.out.println(formatter.format(date));

        //Integer n;
        //client = data.getClient();
        //for(int i=0;i<5;i++){
          //  serwer = client.getData();
            //String day = serwer.optString("day");
            //System.out.println(day);
            //n = serwer.optInt("size");
            //for(int j=0;j<n;j++){
                //serwer = client.getData();
                //String s = serwer.optString("lesson");
                //Integer h = serwer.optInt("hour");
                //System.out.println(s);

          //  }
        //}


        //monday.setCellValueFactory(new PropertyValueFactory<LessonsPlanTable,String>("monday"));

    }

}

