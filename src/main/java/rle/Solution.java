package rle;

class Solution {
    public int compress(char[] chars) {
        int size = 0;
        int charCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                charCount++;
            } else if (chars[i-1] == chars[i]) {
                charCount++;
            } else {
                chars[size] = chars[i-1];
                size++;

                size = fillNumber(size, charCount, chars);
                charCount = 1;
            }
        }

        if (charCount > 0) {
            chars[size] = chars[chars.length - 1];
            size++;
            size = fillNumber(size, charCount, chars);
        }

        return size;
    }

    int magnitude(int num) {
        if (num == 1) {
            return 0;
        }

        int magnitude = 1;
        while (num >= 10) {
            magnitude *= 10;
            num /= 10;
        }

        return magnitude;
    }

    int fillNumber(int size, int count, char[] chars) {
        var magnitude = magnitude(count);
        while (magnitude > 0) {
            chars[size] = Character.forDigit(count / magnitude % 10, 10);
            size++;
            magnitude /= 10;
        }

        return size;
    }

    public static void main(String[] args) {
        var input = "abbbbbbbbbbbb";

        var chars = input.toCharArray();
        var size = new Solution().compress(chars);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print(chars[i]);
        }
    }
}
