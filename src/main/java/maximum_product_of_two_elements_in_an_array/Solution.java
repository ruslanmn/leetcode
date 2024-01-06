package maximum_product_of_two_elements_in_an_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int maxProduct(int[] nums) {
        var mins = new LimitedQueue<>(2, Integer::compare);
        var maxes = new LimitedQueue<Integer>(2, (x, y) -> -Integer.compare(x, y));

        Arrays.stream(nums).forEach(value -> {
            mins.insert(value-1);
            maxes.insert(value-1);
        });

        var minProduction = mins.getValues()
            .stream()
            .reduce(1, (i, j) -> i * j);
        var maxProduction = maxes.getValues()
            .stream()
            .reduce(1, (i, j) -> i * j);

        return Math.max(minProduction, maxProduction);
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

    public static void main(String[] args) {
        var input = new int[] {3,4,5,2};
        var output = new Solution().maxProduct(input);
        System.out.println(output);
    }
}
