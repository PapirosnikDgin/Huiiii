package com.example.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class DataBaseController {

    @FXML
    private Button addObjectButton;

    @FXML
    private TableColumn<Person, Integer> ageColumn;

    @FXML
    private TableColumn<Person, Integer> moneyColumn;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, Integer> numberColumn;

    @FXML
    private TableView<Person> objectsTableView;

    @FXML
    private Button readFileButton;

    @FXML
    private Button saveFileButton;

    private final DataBase data = new DataBase();
    private final String fileName = "dsa.txt";
    private ObservableList<Person> list = FXCollections.observableList(data.objects);

    public void initialize(){
        objectsTableView.setItems(list);
    }

    @FXML
    void clickAddOjbectButton(ActionEvent event) {
        list.add(new Person());
    }

    @FXML
    void clickReadFileButton(ActionEvent event) {
        try {
            data.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clickSaveFileButton(ActionEvent event) {
        data.saveFile(fileName);
    }


}
