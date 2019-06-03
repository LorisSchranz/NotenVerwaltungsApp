package sample.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private ObservableList<Semester> notesModel = FXCollections.observableArrayList();

    @FXML
    public ListView<Semester> lv1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (notesModel != null) {
            lv1.setItems(notesModel);
        }
    }

    public void newSemester() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Semester.fxml"));
            Parent newSemester = fxmlLoader.load();
            SemesterController semesterController = fxmlLoader.getController();
            semesterController.setModel(notesModel);
            Scene scene1 = new Scene(newSemester, 500, 200);
            Stage stage1 = new Stage();
            stage1.setTitle("New Semester");
            stage1.setResizable(false);
            stage1.setScene(scene1);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}