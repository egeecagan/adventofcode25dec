import java.util.ArrayList;

public class Safe {
    private int dial;
    private int exactZeroCount = 0;
    private int passOnZeroCount = 0;
    private ArrayList<String> movements;

    public Safe(int dial, ArrayList<String> movements) {
        this.dial = dial;
        this.movements = movements;
    }

    // part1
    public int calculateExactZeroes() {
        int tempDial = this.dial;
        this.exactZeroCount = 0;
        for (String move : movements) {
            char direction = move.charAt(0);
            int amount = Integer.parseInt(move.substring(1));

            if (direction == 'L') {
                amount %= 100;
                dial = (dial - amount + 100) % 100;
            } else if (direction == 'R') {
                amount %= 100;
                dial = (dial + amount) % 100;
            } else {
                System.out.println("wrong way: " + direction);
                continue;
            }

            if (dial == 0) {
                exactZeroCount++;
            }
        }

        this.dial = tempDial;
        return exactZeroCount;
    }

    // part2
    public int calculatePassOnZero() {
        int tempDial = this.dial;
        this.passOnZeroCount = 0;

        for (String move : movements) {
            char direction = move.charAt(0);
            long amount = Long.parseLong(move.substring(1)); 

            long localPass = 0;

            if (amount > 0) {
                long k0; // 0 a kaç adımda geliriz dial pozisyonundan onun sayısı

                if (direction == 'R') {
                    k0 = (dial == 0) ? 100 : (100 - dial);
                } else if (direction == 'L') {
                    k0 = (dial == 0) ? 100 : dial;
                } else {
                    System.out.println("wrong way: " + direction);
                    continue;
                }

                if (amount >= k0) {
                    localPass = 1 + (amount - k0) / 100;
                }
            }

            passOnZeroCount += (int) localPass;

            long step = amount % 100; // dial in en son doğru yerini bulmak için lazım

            if (direction == 'R') {
                dial = (int) ((dial + step) % 100);
            } else if (direction == 'L') {
                dial = (int) ((dial - step) % 100);
                if (dial < 0) {
                    dial += 100;
                }
            }
        }

        this.dial = tempDial;
        return passOnZeroCount;
    }

}
