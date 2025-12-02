package day1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadInput {


    private ReadInput() {}

    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try (FileReader f = new FileReader(filename)) {
            int c;
            while ((c = f.read()) != -1) {
                if (c != '\n') sb.append((char) c);
                else {
                    lines.add(sb.toString());
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                lines.add(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
