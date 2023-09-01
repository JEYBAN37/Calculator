package com.example.calculator_calidad_test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.calculator_calidad_test.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    private Controller calculatorController;

    @BeforeEach
    public void setUp() {
        calculatorController = new Controller();
    }

    @Test
    public void testAddition() {
        calculatorController.cleanScreen();
        calculatorController.addValue(new ActionEvent(), "5");
        calculatorController.addOperation(new ActionEvent(), "+");
        calculatorController.addValue(new ActionEvent(), "7");
        calculatorController.makeOperation();
        assertEquals("5 + 7 = 12.0", calculatorController.textFieldResults.getText());
    }

    @Test
    public void testSubtraction() {
        calculatorController.cleanScreen();
        calculatorController.addValue(new ActionEvent(), "10");
        calculatorController.addOperation(new ActionEvent(), "-");
        calculatorController.addValue(new ActionEvent(), "3");
        calculatorController.makeOperation();
        assertEquals("10 - 3 = 7.0", calculatorController.textFieldResults.getText());
    }

    @Test
    public void testMultiplication() {
        calculatorController.cleanScreen();
        calculatorController.addValue(new ActionEvent(), "6");
        calculatorController.addOperation(new ActionEvent(), "*");
        calculatorController.addValue(new ActionEvent(), "4");
        calculatorController.makeOperation();
        assertEquals("6 * 4 = 24.0", calculatorController.textFieldResults.getText());
    }

    @Test
    public void testDivision() {
        calculatorController.cleanScreen();
        calculatorController.addValue(new ActionEvent(), "15");
        calculatorController.addOperation(new ActionEvent(), "/");
        calculatorController.addValue(new ActionEvent(), "3");
        calculatorController.makeOperation();
        assertEquals("15 / 3 = 5.0", calculatorController.textFieldResults.getText());
    }

    @Test
    public void testPercentage() {
        calculatorController.cleanScreen();
        calculatorController.addValue(new ActionEvent(), "50");
        calculatorController.addOperation(new ActionEvent(), "%");
        calculatorController.addValue(new ActionEvent(), "20");
        calculatorController.makeOperation();
        assertEquals("50 % 20 = 10.0", calculatorController.textFieldResults.getText());
    }
}
