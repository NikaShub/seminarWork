package seminar4;

public abstract class phone1 extends interfaceElectroinc{
    public abstract void makeCall(String number);

    public void testCall(String number) {
        System.out.println("Calling" + number);
    }
}
