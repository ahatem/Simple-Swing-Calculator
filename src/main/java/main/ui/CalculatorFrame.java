package main.ui;

import main.math_evaluator.parser.ExpressionParser;
import main.math_evaluator.expression.Operand;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

  private static final ExpressionParser PARSER = new ExpressionParser();

  private final FieldsPanel fieldsPanel;
  private final NumPadPanel numPadPanel;

  public CalculatorFrame() {
    super("Simple Calculator");
    setPreferredSize(new Dimension(330, 430));
    setMinimumSize(new Dimension(290, 400));
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    fieldsPanel = new FieldsPanel();
    numPadPanel = new NumPadPanel();

    add(fieldsPanel, BorderLayout.PAGE_START);
    add(numPadPanel, BorderLayout.CENTER);

    initFieldsPanel();
    initButtonsPanel();

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void initFieldsPanel() {
    fieldsPanel.setOnEnterKeyPressed(this::calculate);
  }

  private void initButtonsPanel() {
    numPadPanel.setNumPadListener((text, action) -> {
      switch (action) {
        case "clear" -> fieldsPanel.clear();
        case "equal" -> calculate();
        default -> fieldsPanel.appendToInputField(action);
      }
    });
    numPadPanel.init();
  }

  private void calculate() {
    Operand operand = PARSER.parse(fieldsPanel.getUserInput());
    fieldsPanel.setOutputText(operand.evaluate() + "");
  }
}



