package yandex.lect2;


import kotlin.Pair;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PrimitiveIterator.OfInt;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;


public class SolutionA {
    public static void main(String[] args) throws IOException {
        try (
            var input = new Scanner(new FileReader("input.txt"));
            var output = new PrintWriter(new FileWriter("output.txt"));
        ) {
            var isAsc = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                    new OfInt() {
                        @Override
                        public int nextInt() {
                            return input.nextInt();
                        }

                        @Override
                        public boolean hasNext() {
                            return input.hasNextInt();
                        }
                    },
                    Spliterator.ORDERED
                ),
                false
            ).reduce(
                Acc.init(),
                Acc::accumulate,
                Acc::combine
            ).asc();

            output.println(isAsc ? "YES" : "NO");
        }
    }

    public static class Acc {
        private final boolean asc;
        private final Integer value;

        public Acc(boolean asc, Integer value) {
            this.asc = asc;
            this.value = value;
        }

        public boolean asc() {
            return asc;
        }

        public Integer value() {
            return value;
        }

        public static Acc init() {
            return of(true, null);
        }

        public static Acc of(boolean isAsc, Integer value) {
            return new Acc(isAsc, value);
        }

        public static Acc accumulate(Acc acc, int value) {
            return of(
                acc.asc() && (acc.value() == null || acc.value()  < value),
                value
            );
        }

        public static Acc combine(Acc acc1, Acc acc2) {
            return of(
                acc1.asc() && acc2.asc(),
                acc2.value() == null ? acc1.value() : acc2.value()
            );
        }
    }
}
