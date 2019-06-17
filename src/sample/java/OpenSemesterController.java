package sample.java;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OpenSemesterController implements Initializable {
    private Semester mySemester;
    @FXML
    public Label labelSemester = new Label();

    public void editSemester(ActionEvent event) {

    }

    public void deleteSemester(ActionEvent event) {
    }

    public void setGridpane(GridPane gridPane) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelSemester.setText(mySemester.getId());
    }

    public void setList(Semester semester) {
        mySemester = semester;
    }
}
