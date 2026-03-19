package seminar73;

public class minusNode extends Operations{
    public minusNode(Node left, Node right) {
        super(left, right);

    }

    @Override
    protected char symbol() {
        return '-';
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}
