package main.math_evaluator.expression;

public class Number implements Operand {
  private final double value;

  public Number(double value) {
    this.value = value;
  }

  @Override
  public double evaluate() {
    return value;
  }
}
