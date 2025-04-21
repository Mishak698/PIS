
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmployeeView {
    public static void display() {
        JFrame frame = new JFrame("Evidence pracovníků");
        frame.setSize(400, 400);

        JTextField jmeno = new JTextField(15);
        JTextField prijmeni = new JTextField(15);
        JTextField pozice = new JTextField(15);
        JTextField kontakt = new JTextField(15);
        JButton save = new JButton("Uložit");
        JButton zobrazit = new JButton("Zobrazit vše");

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);

        save.addActionListener(e -> {
            Employee emp = new Employee(jmeno.getText(), prijmeni.getText(), pozice.getText(), kontakt.getText());
            EmployeeStorage.save(emp);
        });

        zobrazit.addActionListener(e -> {
            List<Employee> list = EmployeeStorage.loadAll();
            displayArea.setText("");
            for (Employee emp : list) {
                displayArea.append(emp.jmeno + " " + emp.prijmeni + " - " + emp.pozice + " - " + emp.kontakt + "\n");
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Jméno:"));
        inputPanel.add(jmeno);
        inputPanel.add(new JLabel("Příjmení:"));
        inputPanel.add(prijmeni);
        inputPanel.add(new JLabel("Pozice:"));
        inputPanel.add(pozice);
        inputPanel.add(new JLabel("Kontakt:"));
        inputPanel.add(kontakt);
        inputPanel.add(save);
        inputPanel.add(zobrazit);

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}