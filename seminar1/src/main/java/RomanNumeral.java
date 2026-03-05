import java.util.Map;

public class RomanNumeral {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 3999;
    private static final String REGEX = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private int arabicNumber;
    private String romanNumber;
    private static final int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C"};//...
    private static final Map<Character, Integer> mp = Map.of(
            'I' , 1,
            'V' , 5,
            'X' , 10,
            'L' , 50,
            'C' , 100,
            'D' , 500,
            'M' , 1000
    );

    public RomanNumeral(int numbers) {
        if (numbers > MAX_VALUE || numbers < MIN_VALUE) {
            throw new IllegalArgumentException("sas");
        }
        this.arabicNumber = numbers;
        this.romanNumber = null;
    }

    public RomanNumeral(String RomanNumber) {
        if (!RomanNumber.matches(REGEX)) {
            throw new IllegalArgumentException("sas");
        }
        this.romanNumber = RomanNumber;
        this.arabicNumber = 0;
    }

    public String toString() {
        if (romanNumber != null) return romanNumber;
        int temp = arabicNumber;
        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            while (temp > numbers[i]) {
                temp -= numbers[i];
                result += symbols[i];
            }
        }
        return result;
    }

    public int toint() {
        if (arabicNumber != 0) return arabicNumber;
        int answer = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int cur = mp.get(romanNumber.charAt(i));
            if (i != romanNumber.length() - 1) {
                int cursc = mp.get(romanNumber.charAt(i+1));
                if (cursc > cur) answer -= cur;
                continue;
            }
            answer += cur;
        }
        return answer;
    }

}
