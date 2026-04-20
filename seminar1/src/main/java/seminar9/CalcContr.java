package seminar9;

import java.util.Objects;

public class CalcContr implements ButtonClicked{
    private final CalcBrain brain;
    private final CalcView view;

    public CalcContr(BaisicView view, CalcBrain brain) {
        this.view = view;
        this.brain = brain;
        brain.registerDisplay(view);
        view.registerInput(this);
    }

    public void start() {
        view.show();
    }

    @Override
    public void inputChanged(String input) {
        if (Objects.equals(input, "-") || Objects.equals(input, "+") || Objects.equals(input, "*") || Objects.equals(input, "/")) {
            brain.pushOperator(input.charAt(0));
        } else if (Character.isDigit(input.charAt(0))){
            brain.pushDigit(input);
        } else {
            brain.evaluate();
        }

    }
}
