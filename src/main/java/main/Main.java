package main;

import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;
import main.ui.CalculatorFrame;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    UIManager.put("Button.arc", 0);
    UIManager.put("Button.innerFocusWidth", 0);
    FlatHiberbeeDarkIJTheme.setup();

    SwingUtilities.invokeLater(CalculatorFrame::new);
  }
}