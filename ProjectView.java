
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProjectView {
    public static void display() {
        JFrame frame = new JFrame("Projekty");
        frame.setSize(400, 350);

        JTextField nazev = new JTextField(15);
        JTextField stav = new JTextField(15);
        JTextField start = new JTextField(15);
        JTextField konec = new JTextField(15);
        JButton save = new JButton("Uložit");
        JButton zobrazit = new JButton("Zobrazit vše");

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);

        save.addActionListener(e -> {
            Project p = new Project(nazev.getText(), stav.getText(), start.getText(), konec.getText());
            ProjectStorage.save(p);
        });

        zobrazit.addActionListener(e -> {
            List<Project> list = ProjectStorage.loadAll();
            displayArea.setText("");
            for (Project p : list) {
                displayArea.append(p.nazev + " - " + p.stav + " | " + p.datumStart + " → " + p.datumKonec + "\n");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Název:"));
        panel.add(nazev);
        panel.add(new JLabel("Stav:"));
        panel.add(stav);
        panel.add(new JLabel("Začátek:"));
        panel.add(start);
        panel.add(new JLabel("Konec:"));
        panel.add(konec);
        panel.add(save);
        panel.add(zobrazit);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
