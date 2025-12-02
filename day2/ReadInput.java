package day2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadInput {


    private ReadInput() {}

    public static List<String> readFile(String filename) {
        List<String> ranges = new ArrayList<>();

        try (FileReader f = new FileReader(filename)) {
            int c;
            String range = "";
            while ((c = f.read()) != -1) {
                if (c != ',') {
                    range += (char) c;
                } else {
                    ranges.add(range);
                    range = "";
                }
            }

            if (!range.isEmpty()) {
                ranges.add(range);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ranges;
    }


}
