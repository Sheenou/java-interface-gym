import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
public class Controller {
    Gym gym = new Gym("Jim", 120);
    @FXML
    public Button switchBP;
    @FXML
    public Button switchWL;
    @FXML
    public Button switchPrintAthlete;
    @FXML
    public Button switchMainMenu;
    @FXML
    public TextField firstNameBP;
    @FXML
    public TextField lastNameBP;
    @FXML
    public TextField weightBP;
    @FXML
    public TextField heightBP;
    @FXML
    public RadioButton genderBP1;
    @FXML
    public RadioButton genderBP2;
    @FXML
    public RadioButton position1;
    @FXML
    public RadioButton position2;
    @FXML
    public RadioButton position3;
    @FXML
    public RadioButton dominantHand1;
    @FXML
    public RadioButton dominantHand2;
    @FXML
    public Label printAthletes;

    public void handleSwitchBP(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addBasketballPlayer.fxml"));
        Stage currentStage = (Stage) switchBP.getScene().getWindow();
        currentStage.setScene(new Scene(parent));
    }

    public void handleSwitchWL(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addWeightLifter.fxml"));
        Stage currentStage = (Stage) switchWL.getScene().getWindow();
        currentStage.setScene(new Scene(parent));
    }
    public void handleSwitchPrintAthletes(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("printAthletes.fxml"));
        Stage currentStage = (Stage) switchPrintAthlete.getScene().getWindow();
        currentStage.setScene(new Scene(parent));
        if (gym.getAthletes() != null) printAthletes.setText(gym.getAthletes());
    }
    public void handleSwitchMainMenu(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Stage currentStage = (Stage) switchMainMenu.getScene().getWindow();
        currentStage.setScene(new Scene(parent));
    }
    public void handleAddBP(ActionEvent e) {
        String firstName = firstNameBP.getText();
        String lastName = lastNameBP.getText();
        float weight = Float.parseFloat(weightBP.getText());
        float height = Float.parseFloat(heightBP.getText());

        Gender gender;
        BasketballPosition position;
        DominantHand dominantHand;

        if (genderBP1.isSelected()) gender = Gender.MALE;
        else gender = Gender.FEMALE;

        if (position1.isSelected()) position = BasketballPosition.LEFT_WING;
        else if (position2.isSelected()) position = BasketballPosition.CENTER;
        else position = BasketballPosition.RIGHT_WING;

        if (dominantHand1.isSelected()) dominantHand = DominantHand.LEFT;
        else dominantHand = DominantHand.RIGHT;

        BasketballPlayer basketballPlayer = new BasketballPlayer(firstName, lastName, gender, weight, height, position, dominantHand);

        gym.addAthlete(basketballPlayer);
        System.out.println(gym.getAthletes());
    }

}
