package day2;

import java.util.List;

public class InvalidFinder {

    /*
    hatali durum direk bir sayi 2 adet ayni kisimdan olusuyor ise invalid
    10510 hatali degil ama 101101 hatali mesela. aslinda sayi tek sayida 
    basamak iceriyor ise direk kontrol etmeye gerek yok
    
    
    */

    // part1
    public static long sumPatternRepeatedExactlyTwice(List<String> csv) {

        long counter = 0;

        for (String range : csv) {
            String[] splitted = range.split("-");

            // iki taraf da basamak sayisi ayni ve tek ise direk skip
            if (splitted[0].length() == splitted[1].length() && splitted[0].length() % 2 != 0) {
                continue;
            }

            long firstPart = Long.parseLong(splitted[0]);
            long secondPart = Long.parseLong(splitted[1]);

            String s = "";    
            int s_len = 0;
        
            for (long l = firstPart; l < secondPart + 1; l++) {
                s = Long.toString(l);
                s_len = s.length();
                if (s_len % 2 != 0) {

                    continue;
                } else {
                    // basamak sayisi cift ve o durum olabilir 
                    String left = s.substring(0, s_len / 2);
                    String right = s.substring(s_len / 2, s_len);
                    if (left.equals(right)) {
                        counter += l;
                    }
                }

                s_len = 0;
                s = "";
            }

        }
        return counter;
    }

    public static long sumPatternRepeatedAtLeastTwice(List<String> csv) {

        long counter = 0;

        for (String range : csv) {
            String[] splitted = range.split("-");

            long firstPart = Long.parseLong(splitted[0]);
            long secondPart = Long.parseLong(splitted[1]);

            String s = "";    
            int s_len = 0;
        
            for (long l = firstPart; l < secondPart + 1; l++) {
                s = Long.toString(l);
                s_len = s.length();

                if (s_len < 2) {
                    continue;
                }

                String constructed = "";

                // patern uzunlugu max yarisi kadar olur 
                for (int i = 1; i <= s_len / 2; i++) {
                    if (s_len % i != 0) {
                        continue;
                    }
                    String pattern = s.substring(0, i);
                    int repeatCount = s_len / i;

                    for (int k = 0; k < repeatCount; k++) {
                        constructed += pattern;
                    }

                    if (constructed.equals(s)) {
                        counter += l;
                        break;
                    }
                    constructed = "";


                }

            }

        }

        return counter;
    }
}
