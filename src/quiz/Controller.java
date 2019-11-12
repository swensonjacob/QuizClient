package quiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Question currentQuestion;

    @FXML
    private Label questionText = new Label();

    @FXML
    private Button buttonOne = new Button();
    @FXML
    private Button buttonTwo = new Button();
    @FXML
    private Button buttonThree = new Button();
    @FXML
    private Button buttonFour = new Button();

    private List<Button> buttons = new ArrayList<>();


    public void initialize() {
        Thread t = new Thread(new QuestionGetter(questionText, buttonOne, buttonTwo, buttonThree, buttonFour));
        t.start();
        buttons.add(buttonOne);
        buttons.add(buttonTwo);
        buttons.add(buttonThree);
        buttons.add(buttonFour);
    }

    public static void setCurrentQuestion(Question currentQuestion) {
        Controller.currentQuestion = currentQuestion;
    }

    public void onButtonClicked(ActionEvent e) {

        for (Button button : buttons) {
            if (button.getText().equals(currentQuestion.getAnswerCorrect())) {
                button.setStyle("-fx-background-color: #85ff88; -fx-border-color: #85ff88");
                if(e.getSource().equals(button)) {
                    System.out.println("rätt");
                }

            } else {
                button.setStyle("-fx-background-color: rgb(255,118,124); -fx-border-color: rgb(255,118,124)");
            }

        }
    }
}