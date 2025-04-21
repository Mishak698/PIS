import java.io.*;
import java.util.*;

public class InventoryStorage {
    private static final String FILE_NAME = "inventory.csv";

    public static void save(Inventory item) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(item.toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Inventory> loadAll() {
        List<Inventory> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    list.add(new Inventory(data[0], data[1], Integer.parseInt(data[2]), data[3], Double.parseDouble(data[4])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
