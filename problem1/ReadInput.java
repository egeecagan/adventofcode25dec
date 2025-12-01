import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadInput {

    private static ArrayList<String> input = new ArrayList<>();

    private ReadInput() {}

    public static void readFile(String filename) {

        StringBuilder sb = new StringBuilder();

        try (FileReader f = new FileReader(filename)) {

            int c;

            while ((c = f.read()) != -1) {
                if (c != '\n') {
                    sb.append((char) c);
                } else {
                    input.add(sb.toString());
                    sb.setLength(0);
                }
            }

            if (sb.length() > 0) {
                input.add(sb.toString());
            }

        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            System.out.println("read is done use ReadInput.getInput()");
        }
    }

    public static ArrayList<String> getInput() {
        return input;
    }
}
