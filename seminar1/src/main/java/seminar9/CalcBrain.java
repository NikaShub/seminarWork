package seminar9;

public class CalcBrain {
    private String display;
    private String prevDisplay;
    private char operator;
    private DisplayChange ch;


    public CalcBrain() {
        display = "0";
        prevDisplay = "0";
    }

    public void pushOperator(char operator) {
        this.operator = operator;
        prevDisplay = display;
        display = "0";
    }

    public void pushDigit(String digit) {
        display = "" + digit.charAt(0);
        fireChangeView(display);
    }

    public void registerDisplay(DisplayChange ch) {
        this.ch = ch;
    }

    private void fireChangeView(String result) {
        ch.displayChanged(result);
    }

    public void evaluate() {
        double first = Double.valueOf(display);
        double second = Double.valueOf(prevDisplay);
        double result = switch (operator) {
            case '+' -> first + second;
            case '-' -> first - second;
            case '*' -> first * second;
            case '/' -> first / second;
            default -> 0;
        };
        String resultStr = String.valueOf(result);
        display = resultStr;
        fireChangeView(resultStr);
    }
}
