package quiz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private Label questionText = new Label();

    @FXML
    private Button buttonOne = new Button();
    @FXML
    private Button buttonTwo  = new Button();
    @FXML
    private Button buttonThree = new Button();;
    @FXML
    private Button buttonFour = new Button();;


    public void initialize() {
        Thread t = new Thread(new QuestionGetter(questionText,buttonOne,buttonTwo,buttonThree,buttonFour));
        t.start();

    }

}
