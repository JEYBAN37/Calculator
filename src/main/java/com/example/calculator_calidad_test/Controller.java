package com.example.calculator_calidad_test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

 public class Controller {
    @FXML
    private Button bMultiplication;

    @FXML
    private Button b0;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button bEquals;

    @FXML
    private Button b4;

    @FXML
    private Button bAdition;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button answer;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button bPoint;

    @FXML
    private Button bRest;

    @FXML
    private Button bPorcentage;

    @FXML
    private Button bdivition;

    @FXML
    public TextField textFieldResults;

    private boolean operation = true;
    private double lastOperation = 0;

    @FXML
    public void addValue(ActionEvent event) {
        textFieldResults.setText(textFieldResults.getText() + ((Button)event.getSource()).getText());
        operation = true;
    }

    @FXML
    public void addOperation(ActionEvent event) {
        if(operation){
            textFieldResults.setText(textFieldResults.getText() + ((Button)event.getSource()).getText() );
            operation = false;
        }
    }

    public void cleanScreen(){
        textFieldResults.setText("");
        operation = true;
    }

    public void deleteValue(){
        if(!(textFieldResults.getText().length()==0)){
            textFieldResults.setText(textFieldResults.getText().substring(0,textFieldResults.getText().length()-1));
        }
    }

    public void makeOperation() {
        if (operation) { // Verificar si hay una operación pendiente
            String expression = textFieldResults.getText();
            String[] parts = expression.split("[-+*/%]"); // Dividir la expresión en partes

            if (parts.length == 2) { // Verificar que haya dos operandos
                double num1 = Double.parseDouble(parts[0]);
                double num2 = Double.parseDouble(parts[1]);
                String operator = "";

                // Determinar el operador utilizado en la expresión
                if (expression.contains("+")) {
                    operator = "+";
                    lastOperation = num1 + num2;
                } else if (expression.contains("-")) {
                    operator = "-";
                    lastOperation = num1 - num2;
                } else if (expression.contains("*")) {
                    operator = "*";
                    lastOperation = num1 * num2;
                } else if (expression.contains("/")) {
                    operator = "/";
                    if (num2 != 0) {
                        lastOperation = num1 / num2;
                    } else {
                        textFieldResults.setText("Error: División por cero");
                        return;
                    }
                } else if (expression.contains("%")) {
                    operator = "%";
                    lastOperation = (num1 * num2) / 100;
                }

                // Mostrar el resultado en el campo de texto
                textFieldResults.setText( " = " + lastOperation);
                operation = true; // La operación ha sido completada
            }
        }
    }





    public void getAnswer() {
        if (!(lastOperation == 0)){
            textFieldResults.setText(textFieldResults.getText()+lastOperation);
        }

    }
}