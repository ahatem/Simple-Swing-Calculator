package main.ui;

import net.miginfocom.swing.MigLayout;
import main.common.Constants;

import javax.swing.*;

public class NumPadPanel extends JPanel {

  private NumPadListener listener = (String text, String action) -> {
  };

  public NumPadPanel() {
    setLayout(new MigLayout("fill, gap 0, insets 0"));
  }

  public void init() {
    add(getButton("C", "clear"), "grow, span 1");
    add(getButton('\u00F7', " / "), "grow, span 1");
    add(getButton('\u00D7', " * "), "grow, span 1");
    add(getButton('\u2212', " - "), "grow, span 1, wrap");
    add(getButton("7", "7"), "grow, span 1");
    add(getButton("8", "8"), "grow, span 1");
    add(getButton("9", "9"), "grow, span 1");
    add(getButton('\u002B', " + "), "grow, span 1 2, wrap");
    add(getButton("4", "4"), "grow, span 1");
    add(getButton("5", "5"), "grow, span 1");
    add(getButton("6", "6"), "grow, span 1, wrap");
    add(getButton("1", "1"), "grow, span 1");
    add(getButton("2", "2"), "grow, span 1");
    add(getButton("3", "3"), "grow, span 1");
    add(getButton('\u003D', "equal"), "grow, span 1 2, wrap");
    add(getButton("0", "0"), "grow, span 2");
    add(getButton(".", "."), "grow, span 1");
  }

  public void setNumPadListener(NumPadListener listener) {
    this.listener = listener;
  }

  private JButton getButton(char text, String action) {
    return getButton(charToString(text), action);
  }

  private JButton getButton(String text, String action) {
    JButton button = new JButton(text);
    button.setFont(Constants.DEFAULT_FONT);
    button.addActionListener(e -> listener.onButtonClick(text, action));
    return button;
  }

  private String charToString(char character) {
    return Character.toString(character);
  }

  @FunctionalInterface
  public interface NumPadListener {
    void onButtonClick(String text, String action);
  }
}