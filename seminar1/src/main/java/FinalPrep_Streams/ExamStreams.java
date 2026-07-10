package FinalPrep_Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

///-----------------------------------------21
class Student {
    private String name;
    private String course;
    private int score;

    public Student(String name, String course, int score) {
        this.name = name;
        this.course = course;
        this.score = score;
    }

    public String getName() { return name; }
    public String getCourse() { return course; }
    public int getScore() { return score; }
}

public class ExamStreams {
    public static Optional<Student> findStudentWithMaxCumulativePoints(List<Student> students) {
        return students.stream()
                .reduce((a, b) -> {
                    if (a.getScore() < b.getScore()) return b;
                    return a;
                });
    }

    public static String findCourseWithMaxStudentsHavingScoreHigherThen(List<Student> students, int threshold) {
        return students.stream()
                .filter(s -> s.getScore() > threshold)
                .map(student -> new AbstractMap.SimpleImmutableEntry<>(student.getCourse(), 1))
                .collect(Collectors.toMap(
                        AbstractMap.SimpleImmutableEntry::getKey,
                        AbstractMap.SimpleImmutableEntry::getValue,
                        Integer::sum
                ))
                .entrySet().stream()
                .reduce((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? entry1 : entry2)
                .map(Map.Entry::getKey)
                .orElse("არ მოიძებნა");
    }
  /// ------------------------------------------------------25 fx

    class City {
        private String name;
        private String country;
        private int population;

        public City(String name, String country, int population) {
            this.name = name;
            this.country = country;
            this.population = population;
        }

        public String getName() { return name; }
        public String getCountry() { return country; }
        public int getPopulation() { return population; }
    }

    public static int findNumCitiesWithPopulationAtLeast(List<City> cities, int threshold) {
        return cities.stream()
                .filter(city -> city.getPopulation() > threshold)
                .map(city -> 1)
                .reduce (0, (a, b) -> a +  b);
    }

    public static String findCountryWithHighestAveragePopulation(List<City> cities) {
        return cities.stream()
                .map(city -> new AbstractMap.SimpleImmutableEntry<>(
                        city.getCountry(),
                        new double[]{city.getPopulation(), 1.0}
                ))
                .reduce(
                        new java.util.ArrayList<AbstractMap.SimpleImmutableEntry<String, double[]>>(),
                        (accumulatorList, currentEntry) -> {
                            AbstractMap.SimpleImmutableEntry<String, double[]> existingCountry = accumulatorList.stream()
                                    .filter(entry -> entry.getKey().equals(currentEntry.getKey()))
                                    .reduce(null, (first, second) -> second);

                            if (existingCountry != null) {
                                existingCountry.getValue()[0] += currentEntry.getValue()[0];
                                existingCountry.getValue()[1] += currentEntry.getValue()[1];
                            } else {
                                accumulatorList.add(currentEntry);
                            }
                            return accumulatorList;
                        },
                        (list1, list2) -> list1
                )
                .stream()
                .reduce((country1, country2) -> {
                    double average1 = country1.getValue()[0] / country1.getValue()[1];
                    double average2 = country2.getValue()[0] / country2.getValue()[1];
                    return average1 > average2 ? country1 : country2;
                })
                .map(winnerEntry -> winnerEntry.getKey())
                .orElse("არ მოიძებნა");
    }

    /// ////////////////////////////////////////////////23

    public static <T> List<T> removeConsecutiveDuplicates(Stream<T> items, Comparator<T> cmp) {
        return items.reduce(
                new java.util.ArrayList<T>(),
                (accumulatorList, currentItem) -> {
                    if (accumulatorList.isEmpty()) {
                        accumulatorList.add(currentItem);
                    }
                    else if (cmp.compare(accumulatorList.get(accumulatorList.size() - 1), currentItem) != 0) {
                        accumulatorList.add(currentItem);
                    }

                    return accumulatorList;
                },
                (list1, list2) -> list1
        );
    }


    ///////----------------------------------23fx

    interface Node {
        Stream<Node> getChildren();
        int weight();
    }

    public static int countTotalWeight(Node root) {
        return root.weight() + root.getChildren().map(n -> n.weight()).reduce(0, (a, b) -> a + b);

    }

    public static int mostOccurring(List<Integer> numbers) {
        return numbers.stream()
                .reduce(
                        new int[]{numbers.get(0), 0, numbers.get(0), 0},
                        (state, num) -> {
                            if (num == state[0]) {
                                state[1]++;
                            } else {
                                state[0] = num;
                                state[1] = 1;
                            }
                            if (state[1] > state[3]) {
                                state[2] = state[0];
                                state[3] = state[1];
                            }

                            return state;
                        },
                        (state1, state2) -> state1
                )[2];
    }
}

