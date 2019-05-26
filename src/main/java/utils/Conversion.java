package utils;

public class Conversion {
    public static int[] toInts(String[] input) {
        int[] ints = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            ints[i] = Integer.parseInt(input[i]);
        }
        return ints;
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
