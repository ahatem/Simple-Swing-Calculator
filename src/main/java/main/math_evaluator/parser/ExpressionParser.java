package main.math_evaluator.parser;

import main.math_evaluator.expression.Expression;
import main.math_evaluator.expression.Number;
import main.math_evaluator.expression.Operand;

import java.util.Stack;

public class ExpressionParser {

  public Operand parse(String expression) {
    return buildExpression(convertToPostfixExpression(expression));
  }

  private String convertToPostfixExpression(String expression) {
    Stack<Character> stack = new Stack<>();
    StringBuilder postfixExpression = new StringBuilder();

    char[] chars = expression.toCharArray();
    for (char character : chars) {
      if (character == ' ') continue;

      if (Character.isLetterOrDigit(character) || character == '.') {
        postfixExpression.append(character);
      } else if (character == '(') {
        stack.push(character);
      } else if (character == ')') {
        // empty spaces in " %c " are important cuz we use it to split the expression into tokens (in buildExpression)
        while (stack.peek() != '(')
          postfixExpression.append(" %c ".formatted(stack.pop()));
        stack.pop();
      } else {
        while (!stack.isEmpty() && (priority(character) <= priority(stack.peek())))
          postfixExpression.append(" %c ".formatted(stack.pop()));
        stack.push(character);
        postfixExpression.append(" ");
      }
    }

    while (!stack.isEmpty()) postfixExpression.append(" %c ".formatted(stack.pop()));
    return postfixExpression.toString();
  }

  private int priority(char character) {
    return switch (character) {
      case '^' -> 3;
      case '*', '/' -> 2;
      case '+', '-' -> 1;
      default -> 0;
    };
  }

  private Operand buildExpression(String postfixExpression) {
    Stack<Operand> stack = new Stack<>();
    String operations = "+-*/^";

    String[] tokens = postfixExpression.split("\\s+");
    for (String token : tokens) {
      final boolean isNotOperation = operations.indexOf(token.charAt(0)) == -1;
      if (isNotOperation) {
        stack.push(new Number(Double.parseDouble(token)));
      } else {
        Expression expr = new Expression(token.charAt(0));
        expr.right = stack.pop();
        expr.left = stack.pop();
        stack.push(expr);
      }
    }

    return stack.pop();
  }

}
