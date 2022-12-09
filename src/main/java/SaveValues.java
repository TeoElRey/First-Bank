import java.io.*;
import static java.lang.System.exit;

public class SaveValues {
    public static void writeValues() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("values.txt"));
            writer.write(Bank.getMoney() + "\n" + (double)Bank.getPIN());
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }
    public static double[] readValues() {
        double[] values = new double[2];
        try {
            BufferedReader reader = new BufferedReader((new FileReader("values.txt")));
            values[0] = Double.parseDouble(reader.readLine());
            values[1] = Double.parseDouble(reader.readLine());
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return values;
    }
}
