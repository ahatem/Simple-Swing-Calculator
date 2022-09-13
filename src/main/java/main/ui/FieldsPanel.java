package main.ui;

import main.common.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FieldsPanel extends JPanel {

  private final JTextField inputField;
  private final JTextField outputField;

  private Runnable onEnterKeyPressed = () -> {
  };

  public FieldsPanel() {
    setLayout(new GridLayout(2, 1));

    inputField = new JTextField();
    inputField.setFont(Constants.DEFAULT_FONT);
    inputField.setBorder(BorderFactory.createEmptyBorder(2, 3, 2, 3));
    inputField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
          onEnterKeyPressed.run();
      }
    });

    outputField = new JTextField();
    outputField.setFont(Constants.DEFAULT_FONT);
    outputField.setBorder(BorderFactory.createEmptyBorder(0, 3, 2, 3));
    outputField.setHorizontalAlignment(SwingConstants.RIGHT);
    outputField.setEnabled(true);
    outputField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });

    add(inputField);
    add(outputField);
  }

  public void appendToInputField(String text) {
    inputField.setText(inputField.getText() + text);
  }

  public void setOutputText(String text) {
    outputField.setText(text);
  }

  public String getUserInput() {
    return inputField.getText();
  }

  public void clear() {
    inputField.setText("");
    outputField.setText("");
  }

  public void setOnEnterKeyPressed(Runnable onEnterKeyPressed) {
    this.onEnterKeyPressed = onEnterKeyPressed;
  }
}
