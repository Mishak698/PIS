
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Podnikový systém");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JButton employeeBtn = new JButton("Evidence pracovníků");
            JButton inventoryBtn = new JButton("Správa zásob");
            JButton projectBtn = new JButton("Projekty");

            employeeBtn.addActionListener(e -> EmployeeView.display());
            inventoryBtn.addActionListener(e -> InventoryView.display());
            projectBtn.addActionListener(e -> ProjectView.display());

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1));
            panel.add(employeeBtn);
            panel.add(inventoryBtn);
            panel.add(projectBtn);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}