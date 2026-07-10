package FinalPrep_Streams;

import java.util.List;

import static java.util.Locale.filter;

public class findLongestPalindrome {
    public String findLongestPalindrome(List<String> words) {
        return words.stream().
                 filter(w -> w.toLowerCase().equals(new StringBuilder(w.toLowerCase()).reverse().toString()))
                .reduce((w1, w2) -> w1.length() >= w2.length() ? w1 : w2)
                .orElse("");
    }
}
