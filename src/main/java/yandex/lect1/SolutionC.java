package yandex.lect1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SolutionC {
    public static void main(String[] args) throws FileNotFoundException {
        try (var scanner = new Scanner(new FileReader("input.txt"))) {
            var phone = Phone.of(scanner.nextLine());

            String line;
            while (scanner.hasNextLine() && !((line = scanner.nextLine()).isBlank())) {
                var record = Phone.of(line);
                System.out.println(phone.equals(record) ? "YES" : "NO");
            }
        }
    }

    public static class Phone {
        private final int code;
        private final int number;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Phone phone = (Phone) o;
            return code == phone.code && number == phone.number;
        }

        public Phone(int code, int number) {
            this.code = code;
            this.number = number;
        }

        public static Phone of(String phone) {
            phone = phone.replaceAll("-", "");
            if (phone.length() == 7) {
                return new Phone(495, Integer.parseInt(phone));
            } else {
                var number = phone.substring(phone.length() - 7);
                var code = phone.substring(
                    phone.startsWith("+7") ? 2 : 1,
                    phone.length() - 7);
                if (code.startsWith("(")) {
                    code = code.substring(1, 4);
                }

                return new Phone(
                    Integer.parseInt(code),
                    Integer.parseInt(number)
                );
            }
        }
    }
}
