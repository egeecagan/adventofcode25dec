package day1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<String> movements = ReadInput.readFile("inputs/day1.txt");
        Safe safe = new Safe(50, movements);          

        int exactZeroCount = safe.calculateExactZeroes();
        System.out.println(exactZeroCount);

        int passOnZeroCount = safe.calculatePassOnZero();
        System.out.println(passOnZeroCount);
    }
}
