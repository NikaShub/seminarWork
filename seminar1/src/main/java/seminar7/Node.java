package seminar7;

public class Node {

    private Double value;
    private Character operator;

    private Node left, right;

    private Double leftD, rightD;

    public Node(double value) {
        this.value = value;
    }

    public Node(char operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public Node(char operator, double left, double right) {
        this.operator = operator;
        this.left = new Node(left);
        this.right = new Node(right);
    }

    public double evaluate() {
        switch(this.operator) {
            case '+': return left.evaluate() + right.evaluate();
            case '-': return left.evaluate() - right.evaluate();
            case '*': return left.evaluate() * right.evaluate();
            case '/':
                if (right.evaluate() == 0) throw new IllegalArgumentException("0 as an denuminator");
                return left.evaluate() / right.evaluate();
            case null: return value;
            default: throw new ArithmeticException();
        }
    }

    public String toString() {
        switch(this.operator) {
            case '+': return left.toString() + " + " + right.toString();
            case '-': return left.toString() + " - " + right.toString();
            case '*': return left.toString() + " * " + right.toString();
            case '/':
                if (right.evaluate() == 0) throw new IllegalArgumentException("0 as an denuminator");
                return left.toString() + " / " + right.toString();
            case null: return String.valueOf(value);
            default: throw new ArithmeticException();
        }
    }
}
