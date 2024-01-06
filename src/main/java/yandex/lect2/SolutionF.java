package yandex.lect2;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator.OfInt;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;


public class SolutionF {
    public static void main(String[] args) throws IOException {
        try (
            var input = new Scanner(new FileReader("input.txt"));
            var output = new PrintWriter(new FileWriter("output.txt"));
        ) {
            int n = input.nextInt();
            var nums = IntStream.range(0, n)
                .mapToObj(i -> input.nextInt())
                .collect(Collectors.toList());

            var even = nums.size() % 2 == 0;
            int l = nums.size() / 2 - 1;

            while (
                l < nums.size() - 1
                && !isSymmetric(nums, l, l + (even ? 1 : 2))
            ) {
                l += even ? 0 : 1;
                even = !even;
            }

            var r = l + (even ? 1 : 2);
            var matched = nums.size() - r;

            var addFrom = l - matched;

            output.println(addFrom + 1);
            if (addFrom >= 0) {
                output.print(nums.get(addFrom));
            }
            for (int i = addFrom - 1; i >= 0; i--) {
                output.print(" " + nums.get(i));
            }
        }
    }

    static boolean isSymmetric(List<Integer> nums, int l, int r) {
        while (0 <= l && r < nums.size()) {
            if (!Objects.equals(nums.get(l), nums.get(r))) return false;
            l--;
            r++;
        }
        return true;
    }
}
