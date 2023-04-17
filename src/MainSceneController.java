import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MainSceneController {

    @FXML
    private GridPane seatingChart;
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> colorComboBox;
    @FXML
    private Label errorLabel;

    private Seat[][] seats;

    private ArrayList<String> usedColor = new ArrayList<String>();

    public void initialize() {
        // Initialize the seating chart
        seats = new Seat[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                seats[i][j] = new Seat(i, j);
                // Add a rectangle and a label to represent each seat
                Rectangle rect = new Rectangle(40, 40, Color.WHITE);
                Label label = new Label();
                label.setPrefWidth(80);
                label.setAlignment(Pos.CENTER);
                rect.setLayoutX(50);
                rect.setLayoutY(10);
                Pane pane = new Pane(rect, label);
                GridPane.setHalignment(pane, HPos.CENTER);
                GridPane.setValignment(pane, VPos.CENTER);
                label.setLayoutY(60);
                seatingChart.add(pane, j, i);
            }
        }
        colorComboBox.getItems().addAll("Red", "Green", "Blue", "White", "Black", "Purple", "Yellow", "Orange", "Brown", "Magenta", "Cyan");
        errorLabel.setVisible(false);
    }

    

    @FXML
    private void assignSeat(ActionEvent event) {
        String name = nameField.getText();
        String color = colorComboBox.getValue();
        if (name.isEmpty() || color == null) {
            errorLabel.setText("Please enter a name and select a color.");
            errorLabel.setVisible(true);
            return;
        }
        if(usedColor.contains(color)){
            errorLabel.setText("Please select a color that hasn't already been used!");
            errorLabel.setVisible(true);
            return;
        }
        Student student = new Student(name, color);
        boolean assigned = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Seat seat = seats[i][j];
                if (!seat.isOccupied()) {
                    seat.assignStudent(student);
                    Pane pane = (Pane) seatingChart.getChildren().get(i * 3 + j);
                    Label label = (Label) pane.getChildren().get(1);
                    Rectangle rect = (Rectangle) pane.getChildren().get(0);
                    label.setText(name);
                    label.layoutXProperty().bind(pane.widthProperty().subtract(label.widthProperty()).divide(2));
                    rect.setFill(Color.web(color));
                    assigned = true;
                    usedColor.add(color);
                    break;
                }
            }
            if (assigned) {
                break;
            }
        }
        if (!assigned) {
            errorLabel.setText("All seats are already assigned.");
            errorLabel.setVisible(true);
        } else {
            errorLabel.setVisible(false);
            nameField.clear();
            colorComboBox.getSelectionModel().clearSelection();
        }
    }
}