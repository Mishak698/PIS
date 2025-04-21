
import java.io.*;
import java.util.*;

public class EmployeeStorage {
    private static final String FILE_NAME = "employees.csv";

    public static void save(Employee emp) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(emp.toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> loadAll() {
        List<Employee> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4)
                    list.add(new Employee(data[0], data[1], data[2], data[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}