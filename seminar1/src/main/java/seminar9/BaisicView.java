package seminar9;

public abstract class BaisicView implements CalcView {
    private ButtonClicked cl;
    public void registerInput(ButtonClicked cl) {
        this.cl = cl;
    }

    public void fireInputChanged(String name) {
        cl.inputChanged(name);
    }
}
