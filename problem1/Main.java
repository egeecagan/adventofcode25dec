import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ReadInput.readFile("input.txt");
        ArrayList<String> input = ReadInput.getInput();
        Safe safe = new Safe(50, input);

        int exactZeroCount = safe.calculateExactZeroes();
        System.out.println(exactZeroCount);

        int passOnZeroCount = safe.calculatePassOnZero();
        System.out.println(passOnZeroCount);
    }
}
