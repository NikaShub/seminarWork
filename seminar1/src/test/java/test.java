import seminar3.seminar4.Parent;
import seminar3.seminar4.child;

public class test {
    public static void invoke(Parent p) {
        p.go();
    }

    public static void invoke(child ch) {
        ch.go();
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        invoke(parent);
        child child = new child();
        invoke(child);
        Parent parent1 = new child();
        invoke(parent1);
    }
}
