import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventoryView {
    public static void display() {
        JFrame frame = new JFrame("Správa zásob");
        frame.setSize(400, 400);

        JTextField nazev = new JTextField(15);
        JTextField kod = new JTextField(15);
        JTextField mnozstvi = new JTextField(15);
        JTextField umisteni = new JTextField(15);
        JTextField cena = new JTextField(15);
        JButton save = new JButton("Uložit");
        JButton zobrazit = new JButton("Zobrazit vše");

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);

        save.addActionListener(e -> {
            Inventory item = new Inventory(
                    nazev.getText(),
                    kod.getText(),
                    Integer.parseInt(mnozstvi.getText()),
                    umisteni.getText(),
                    Double.parseDouble(cena.getText())
            );
            InventoryStorage.save(item);
        });

        zobrazit.addActionListener(e -> {
            List<Inventory> list = InventoryStorage.loadAll();
            displayArea.setText("");
            for (Inventory item : list) {
                displayArea.append(item.nazev + " (" + item.kod + ") - " + item.mnozstvi + " ks - " + item.umisteni + " - " + item.cena + " Kč\n");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Název:"));
        panel.add(nazev);
        panel.add(new JLabel("Kód:"));
        panel.add(kod);
        panel.add(new JLabel("Množství:"));
        panel.add(mnozstvi);
        panel.add(new JLabel("Umístění:"));
        panel.add(umisteni);
        panel.add(new JLabel("Cena:"));
        panel.add(cena);
        panel.add(save);
        panel.add(zobrazit);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
