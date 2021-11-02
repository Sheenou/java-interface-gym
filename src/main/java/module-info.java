module msinogl.gym {
    requires javafx.controls;
    requires javafx.fxml;


    opens msinogl.gym to javafx.fxml;
    exports msinogl.gym;
}