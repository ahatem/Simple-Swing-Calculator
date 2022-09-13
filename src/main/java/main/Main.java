package main;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import main.ui.CalculatorFrame;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    UIManager.put("Button.arc", 0);
    UIManager.put("Button.innerFocusWidth", 0);
    UIManager.put("Component.focusWidth", 0);

//    FlatHiberbeeDarkIJTheme.setup(); // Dark Theme
    FlatCyanLightIJTheme.setup(); // Light Theme
    SwingUtilities.invokeLater(CalculatorFrame::new);
  }
}