
import java.io.*;
import java.util.*;

public class ProjectStorage {
    private static final String FILE_NAME = "projects.csv";

    public static void save(Project project) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(project.toCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Project> loadAll() {
        List<Project> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    list.add(new Project(data[0], data[1], data[2], data[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
