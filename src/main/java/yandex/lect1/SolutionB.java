package yandex.lect1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class SolutionB {
    public static void main(String[] args) throws FileNotFoundException {
        try (var scanner = new Scanner(new FileReader("input.txt"))) {
            var triangle = List.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            var max = triangle.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
            var sum = triangle.stream()
                .mapToInt(Integer::intValue)
                .sum();

            System.out.println(sum - max > max ? "YES" : "NO");
        }
    }
}
