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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LessonsPlanWindowController implements Initializable {
    @FXML
    private TableView<LessonsTable> table;

    @FXML
    private TableColumn<MarkTable, String> hour;

    @FXML
    private TableColumn<MarkTable, String> monday;

    @FXML
    private TableColumn<MarkTable, String> thesday;

    @FXML
    private TableColumn<MarkTable, String> wednesday;

    @FXML
    private TableColumn<MarkTable, String> thursday;

    @FXML
    private TableColumn<MarkTable, String> friday;

    private Client client;
    private JSONObject serwer;

    SendDataToContoller data = SendDataToContoller.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        String[] days = new String[] {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        String[] hours = new String[]{"8:00-8:45", "8:50-9:35", "9:40-10:25", "10:40-11:25", "11:35-12:20", "12:25-13:10", "13:15-14:00"};
        String[][] lessions = new String[5][7];
        LocalDate localDate = LocalDate.now();
        client = data.getClient();
                //System.out.println("LocalDate - System zone: " + localDate);
                //System.out.println("Day of week: " + localDate.getDayOfWeek());
                //String day = String.valueOf(localDate); //pobiera dzien tygodnia duzymi po angielsku
        ObservableList<LessonsTable> list = FXCollections.observableArrayList();

        Integer dayInt = localDate.getDayOfMonth(); // pobiera inta dzien miesiaca
        String setMonday="";    //wskaze kiedy bedzie poniedzialek
        for(int i =0; i<7; i++) if(String.valueOf(localDate.getDayOfWeek()).equals(days[i])) dayInt -= i;

        //System.out.println(localDate +" Poniedzialek wypada: " + setMonday);

        for(int i=0; i<5; i++){for(int j=0; j < 7; j++){lessions[i][j] ="";}}

        for(int i=0; i<5; i++){
            setMonday = String.valueOf(localDate).substring(0,8) + (dayInt+0);
            client.SendString(setMonday);
            serwer = client.getData();
            int size = serwer.optInt("size");
            for(int j=0; j < size; j++){
                serwer = client.getData();
                String lekcja = serwer.optString("lesson");
                lessions[i][j] = lekcja;
            }
        }

        for(int i=0; i<7; i++){
            list.addAll(new LessonsTable(hours[i], lessions[0][i], lessions[1][i], lessions[2][i], lessions[3][i], lessions[4][i]));
        }
        hour.setCellValueFactory(new PropertyValueFactory<MarkTable, String>("hour"));
        monday.setCellValueFactory(new PropertyValueFactory<MarkTable, String>("monday"));
        thesday.setCellValueFactory(new PropertyValueFactory<MarkTable, String>("thesday"));
        wednesday.setCellValueFactory(new PropertyValueFactory<MarkTable, String>("wednesday"));
        thursday.setCellValueFactory(new PropertyValueFactory<MarkTable, String>("thursday"));
        friday.setCellValueFactory(new PropertyValueFactory<MarkTable, String>("friday"));
        table.setItems(list);

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
    }

}

