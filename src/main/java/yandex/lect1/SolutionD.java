package yandex.lect1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SolutionD {
    public static void main(String[] args) throws IOException {
        var input = new Scanner(new FileReader("input.txt"));
        var output = new PrintWriter(new FileWriter("output.txt"));

        try {
            var a = input.nextInt();
            var b = input.nextInt();
            var c = input.nextInt();

            if (c < 0) {
                output.println("NO SOLUTION");
            } else {

            }
        } finally {
            input.close();
            output.close();
        }
    }
}
