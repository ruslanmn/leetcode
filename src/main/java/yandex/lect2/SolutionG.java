package yandex.lect2;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class SolutionG {
    public static void main(String[] args) throws IOException {
        try (
            var input = new Scanner(new FileReader("input.txt"));
            var output = new PrintWriter(new FileWriter("output.txt"));
        ) {
            var mins = new LimitedQueue<>(2, Long::compare);
            var maxes = new LimitedQueue<Long>(2, (x, y) -> -Long.compare(x, y));

            while (input.hasNextLong()) {
                var value = input.nextLong();
                mins.insert(value);
                maxes.insert(value);
            }

            var minsProduction = mins.getValues()
                .stream()
                .reduce(1L, (i, j) -> i*j);
            var maxProduction = maxes.getValues()
                .stream()
                .reduce(1L, (i, j) -> i*j);

            output.println(
                (minsProduction > maxProduction ?
                    mins
                    : maxes).getValues()
                    .stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "))
            );
        }
    }

    static class LimitedQueue<T> {
        private final int size;
        private final Comparator<T> comparator;
        private ArrayList<T> values;

        public LimitedQueue(int size, Comparator<T> comparator) {
            this.size = size;
            this.comparator = comparator;
            this.values = new ArrayList<>(size + 1);
        }

        public List<T> getValues() {
            return new ArrayList<>(values);
        }

        void insert(T value) {
            int i = 0;
            while (i < values.size() && comparator.compare(value, values.get(i)) >= 0) {
                i++;
            }
            if (i < size) {
                if (values.size() == size) {
                    values.remove(size - 1);
                }
                values.add(i, value);
            }
        }
    }
}
