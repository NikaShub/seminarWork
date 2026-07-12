package FinalPrep_Poly;


interface Expression {
    int evaluate();
    String format();
}

class NumberExpression implements Expression {
    private final int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String format() {
        return String.valueOf(value);
    }
}

class Add implements Expression {
    private final Expression left;
    private final Expression right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String format() {
        return "(" + left.format() + "+" + right.format() + ")";
    }
}

class SubtractExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }

    @Override
    public String format() {
        return "(" + left.format() + " - " + right.format() + ")";
    }
}

class MultiplyExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String format() {
        return "(" + left.format() + " * " + right.format() + ")";
    }
}

class DivideExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }

    @Override
    public String format() {
        return "(" + left.format() + " / " + right.format() + ")";
    }
}

class ExpressionFormatter {
    public static String format(Expression expression) {
        return expression.format();
    }
}

public class Main {
}
