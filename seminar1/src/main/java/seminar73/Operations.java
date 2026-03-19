package seminar73;

public abstract class Operations implements Node {
    protected Node left, right;

    public Operations(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    protected abstract char symbol();  // titoeul fails shemqni da + are



    @Override
    public String toString() {
        return left.toString() + symbol() + right.toString();
    }
}
