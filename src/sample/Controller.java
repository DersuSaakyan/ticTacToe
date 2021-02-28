package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements EventHandler<ActionEvent> {
    boolean b = false;
    boolean xo = true;
    static int xScore;
    static int yScore;
    String str = "";
    @FXML
    Label x;
    @FXML
    Label y;
    @FXML
    Button label1, label2, label3, label4, label5, label6, label7, label8, label9;
    Button[] buttons;
    @FXML
    Button start;

    @FXML
    public void run() {
        buttons = new Button[]{label1, label2, label3, label4, label5, label6, label7, label8, label9};
        b = true;
        xo = true;
        for (Button label : buttons) {
            label.setText("");
            label.setOnAction(this);
        }
    }

    @Override
    public void handle(ActionEvent event) {
        if (b) {
            for (Button button : buttons) {
                if (button == event.getSource() && button.getText().isEmpty()) {
                    if (xo) {
                        button.setText("X");
                        xo = false;
                        if (check()) {
                            b = false;
                            end();
//                        JOptionPane.showMessageDialog(null,"Win","",JOptionPane.WARNING_MESSAGE);
                        }

                    } else {
                        button.setText("O");
                        xo = true;
                        if (check()) {
                            b = false;
                            end();
//                            JOptionPane.showMessageDialog(null, "Win", "", JOptionPane.WARNING_MESSAGE);
                        }

                    }
                }
            }
        }
    }

    public boolean check() {
        if (label1.getText().equals(label5.getText()) && label1.getText().equals(label9.getText()) && !label1.getText().isEmpty()) {
            str = label1.getText();
            return true;
        }
        if (label3.getText().equals(label5.getText()) && label3.getText().equals(label7.getText()) && !label3.getText().isEmpty()) {
            str = label3.getText();
            return true;
        }
        if (label1.getText().equals(label2.getText()) && label1.getText().equals(label3.getText()) && !label1.getText().isEmpty()) {
            str = label1.getText();
            return true;
        }
        if (label4.getText().equals(label5.getText()) && label5.getText().equals(label6.getText()) && !label4.getText().isEmpty()) {
            str = label4.getText();
            return true;
        }
        if (label7.getText().equals(label8.getText()) && label7.getText().equals(label9.getText()) && !label7.getText().isEmpty()) {
            str = label7.getText();
            return true;
        }
        if (label1.getText().equals(label4.getText()) && label1.getText().equals(label7.getText()) && !label1.getText().isEmpty()) {
            str = label1.getText();
            return true;
        }
        if (label2.getText().equals(label5.getText()) && label2.getText().equals(label8.getText()) && !label2.getText().isEmpty()) {
            str = label2.getText();
            return true;
        }
        if (label3.getText().equals(label6.getText()) && label3.getText().equals(label9.getText()) && !label3.getText().isEmpty()) {
            str = label3.getText();
            return true;
        }

        return false;
    }

    public void end(){
        if (str.equals("X")){
            xScore++;
        }else if(str.equals("O")){
            yScore++;
        }
        x.setText("X _ " + xScore);
        y.setText("O _ " + yScore);
    }
}
