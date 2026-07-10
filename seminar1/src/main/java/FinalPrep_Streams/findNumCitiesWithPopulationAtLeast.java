package FinalPrep_Streams;

import semina72.Node;
import seminar3.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class findNumCitiesWithPopulationAtLeast {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
         return numbers.stream()
                 .filter(num -> num % 2 == 0)
                 .reduce(0, (a, b) -> a + b);
    }

    public static List<String> filterStringsContainingA(List<String> strings) {
        return strings.stream()
                .filter(string -> string.toLowerCase().contains("a"))
                .collect(Collectors.toList());
    }

    public static OptionalDouble averageAgeOfANames(List<Person> people) {
        return people.stream()
                .filter(person -> person.getName().charAt(0) == 'A')
                .mapToInt(person -> person.getAge())
                .average();
    }

    public static Optional<Integer> findMaximum(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> {
                    if (b > a) return b;
                    return a;
                } );

    }

    public static String uppercaseAndConcatenate(List<String> strings) {
        return strings.stream()
                .map(word -> word.toUpperCase())
                .reduce("", (a, b) -> a + b);
    }

    public static int sumOfSquaresOfNumbersDivisibleByThree(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 3 == 0)
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);
    }

    public static int lengthOfLongestString(List<String> strings) {
        return strings.stream()
                .map(n -> n.length())
                .reduce(0, (a, b) -> {
                    if (a < b) return b;
                    return a;
                });
    }

    public static OptionalDouble averageOfFirstTenEvenNumbers(List<Integer> numbers) {
        Double[] doub = numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(
                        new Double[]{0.0, 0.0},
                        (state, num) -> {
                            if (state[1] >= 10) {
                                return state;
                            }
                            double newSum = state[0] + num;
                            double newCount = state[1] + 1;

                            return new Double[]{newSum, newCount};
                        },
                        (state1, state2) -> state1
                );
        return OptionalDouble.of(doub[0] / doub[1]);
    }/// in other way we can jsust limit 10 and that will do but this is more fun

    static List<String> filterShortAndSort(List<String> strings) {
        return strings.stream()
                .filter(word -> word.length() < 5)
                .sorted()
                .collect(Collectors.toList());
    }
}

