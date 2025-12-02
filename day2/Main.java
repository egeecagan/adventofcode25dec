package day2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> ranges = ReadInput.readFile("inputs/day2.txt");

        long value = InvalidFinder.sumPatternRepeatedExactlyTwice(ranges);
        System.out.println(value);

        long answer2 = InvalidFinder.sumPatternRepeatedAtLeastTwice(ranges);
        System.out.println(answer2);
    }
}