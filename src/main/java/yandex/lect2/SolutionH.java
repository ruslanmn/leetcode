package yandex.lect2;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SolutionH {
    public static void main(String[] args) throws IOException {
        try (
            var input = new Scanner(new FileReader("input.txt"));
            var output = new PrintWriter(new FileWriter("output.txt"));
        ) {
            var minQueue = new LimitedQueue<>(2, Long::compare);
            var maxQueue = new LimitedQueue<Long>(3, (x, y) -> -Long.compare(x, y));

            while (input.hasNextLong()) {
                var value = input.nextLong();
                minQueue.insert(value);
                maxQueue.insert(value);
            }


            var seq1 = List.of(
                minQueue.getValues().get(0),
                minQueue.getValues().get(1),
                maxQueue.getValues().get(0)
            );
            var seq2 = maxQueue.getValues();

            var prod1 = seq1.stream().reduce(1L, Math::multiplyExact);
            var prod2 = seq2.stream().reduce(1L, Math::multiplyExact);

            output.println(
                (prod1 > prod2 ? seq1 : seq2).stream()
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
