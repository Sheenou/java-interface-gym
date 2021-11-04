package msinogl.gym;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import msinogl.gym.base.Gender;
import msinogl.gym.base.Gym;
import msinogl.gym.base.WeightLifter;

import java.io.IOException;

public class Controller {
    private Gym gym = new Gym("Jim", 0);

//    Default
    @FXML
    private Button newAthleteButton;

    @FXML
    private Button printAthletesButton;

//    Add an athlete
    @FXML
    private Button mainMenuButton;

    @FXML
    private Button addWeightlifterButton;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField weight;

    @FXML
    private TextField height;

    @FXML
    private RadioButton gender1;

    @FXML
    private TextField maxWeight;


//    Select athlete type
    @FXML
    private Button newWeightlifterButton;

//    Print athletes
    @FXML
    private Label printAthletesLabel;

    @FXML
    protected void newAthlete() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("newAthlete.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) newAthleteButton.getScene().getWindow();

        stage.setTitle("Gym Manager");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToMainMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("default.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) mainMenuButton.getScene().getWindow();

        stage.setTitle("Gym Manager");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void addWeightlifter() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addWeightlifter.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) newWeightlifterButton.getScene().getWindow();

        stage.setTitle("Gym Manager");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void newWeightlifter() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("default.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) mainMenuButton.getScene().getWindow();

        gym.addAthlete(new WeightLifter(firstName.getText(), lastName.getText(), (gender1.isSelected()) ? Gender.MALE : Gender.FEMALE, Float.parseFloat(weight.getText()), Float.parseFloat((height.getText())), Double.parseDouble(maxWeight.getText())));


        stage.setTitle("Gym Manager");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToPrintAthletes() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("printAthletes.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) printAthletesButton.getScene().getWindow();

        stage.setTitle("Gym Manager");
        stage.setScene(scene);
        stage.show();

        if (gym.getAthletes().toString() != null) printAthletesLabel.setText(gym.getAthletes().toString());
    }
}