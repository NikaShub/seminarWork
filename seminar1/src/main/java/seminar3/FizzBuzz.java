package seminar3;

public class FizzBuzz {
    public String evaluate(int i) {
        if (i % 15 == 0 || (containsDigit(i, 3) && containsDigit(i, 5))) return "FizzBuzz";
        else if (i % 3 == 0 || containsDigit(i, 3)) return "Fizz";
        else if (i % 5 == 0 || containsDigit(i, 5)) return "Buzz";
        return String.valueOf(i);
    }



    private boolean containsDigit(int i, int i1) {
        return String.valueOf(i).contains(String.valueOf(i1));
    }
}
