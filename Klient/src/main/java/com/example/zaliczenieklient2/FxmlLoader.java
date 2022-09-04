package com.example.zaliczenieklient2;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPane(String fileName) {
        try {
            URL fileUrl = AppWindowController.class.getResource("/com.example.zaliczenieklient2/" + fileName + ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            System.out.println("No page " + fileName);
        }
    return view;
    }

}
