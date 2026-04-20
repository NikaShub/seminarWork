package seminar9;

public class Main {

    public static void main(String[] args) {
        BaisicView view = new swingView();
        CalcBrain brain = new CalcBrain();
        CalcContr controller = new CalcContr(view, brain);
        controller.start();
    }
}
