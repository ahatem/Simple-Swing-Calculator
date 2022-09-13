package main.math_evaluator.expression;

public class Expression implements Operand {
  private final char operation;
  public Operand left, right;

  public Expression(char operation) {
    this.operation = operation;
  }

  @Override
  public double evaluate() {
    double leftValue = left.evaluate();
    double rightValue = right.evaluate();
    return switch (operation) {
      case '^' -> Math.pow(leftValue , rightValue);
      case '*' -> leftValue * rightValue;
      case '/' -> leftValue / rightValue;
      case '+' -> leftValue + rightValue;
      case '-' -> leftValue - rightValue;
      default -> -1;
    };
  }
}