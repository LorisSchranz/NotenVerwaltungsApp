package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class SemesterController implements Initializable {
    @FXML
    public TextField School;
    @FXML
    public TextField Semester;
    @FXML
    public Button Save;
    @FXML
    public Label ErrorLabel;

    private ObservableList<Semester> myModel = FXCollections.observableArrayList();
    private ComboBox<Semester> myComboBox;
    private int Position = -1;


    void setModel(ObservableList<Semester> list) {
        myModel = list;
    }

    void setEdit(int position) {
        Position = position;
        School.setText(myModel.get(position).getSchool());
        Semester.setText(Integer.toString(myModel.get(position).getNumber()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void Save() {
        boolean canSave = true;
        boolean canEdit = true;
        ErrorLabel.setText("");
        String school = School.getText().trim();
        int semester = 0;
        try {
            semester = Integer.parseInt(Semester.getText().trim());
        } catch (Exception e){
            System.out.println(e);
        }
        ErrorLabel.setText("Errors: ");
        if (myModel.size() != 0) {
            for (int i = 0; i < myModel.size(); i++) {
                if (semester == myModel.get(i).getNumber() && i != Position && school.equals(myModel.get(i).getSchool())) {
                    canSave = false;
                    ErrorLabel.setText(ErrorLabel.getText() + "Already taken Topic ");
                }
            }
        }
        if (semester<= 0) {
            canSave = false;
            ErrorLabel.setText(ErrorLabel.getText() + "Invalid Semester");
        }
        if (Position == -1) {
            canEdit = false;
        }
        if (school.equals("")) {
            canSave = false;
            ErrorLabel.setText(ErrorLabel.getText() + "No School ");
        }
        if (canSave && !canEdit) {
            myModel.add(new Semester(semester, school));
            Stage stage = (Stage) Save.getScene().getWindow();
            stage.close();
        } else if (canSave) {
            myModel.add(new Semester(semester, school));
            myModel.remove(Position);
            Stage stage = (Stage) Save.getScene().getWindow();
            stage.close();
        }
    }
}
