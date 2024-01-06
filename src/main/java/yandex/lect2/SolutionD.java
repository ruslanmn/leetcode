package yandex.lect2;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PrimitiveIterator.OfInt;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class SolutionD {
    public static void main(String[] args) throws IOException {
        try (
            var input = new Scanner(new FileReader("input.txt"));
            var output = new PrintWriter(new FileWriter("output.txt"));
        ) {
            output.println(solve(input));
        }
    }

    static int solve(Scanner input) {
        int prev, cur;
        int count = 0;

        if (!input.hasNextInt()) {
            return count;
        }
        prev = input.nextInt();
        if (!input.hasNextInt()) {
            return count;
        }
        cur = input.nextInt();

        while (input.hasNextInt()) {
            int next = input.nextInt();

            if (cur > prev && cur > next) count++;

            prev = cur;
            cur = next;
        }

        return count;
    }
}
