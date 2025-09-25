import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZooFrame extends JFrame {
    private JTextField nameField, ageField, furColorField;
    private JCheckBox canFlyCheckBox;
    private JComboBox<String> animalTypeBox;
    private JTextArea logArea;
    private ArrayList<Animal> zoo;

    public ZooFrame() {
        zoo = new ArrayList<>();

        setTitle("Digital Zoo Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 5, 5));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Animal Type:"));
        animalTypeBox = new JComboBox<>(new String[]{"Generic Mammal", "Generic Bird"});
        inputPanel.add(animalTypeBox);

        inputPanel.add(new JLabel("Fur Color (if Mammal):"));
        furColorField = new JTextField();
        inputPanel.add(furColorField);

        inputPanel.add(new JLabel("Can Fly? (if Bird):"));
        canFlyCheckBox = new JCheckBox();
        inputPanel.add(canFlyCheckBox);

        add(inputPanel, BorderLayout.NORTH);

        // Tombol
        JButton addButton = new JButton("Add Animal");
        add(addButton, BorderLayout.CENTER);

        // Area Log
        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.SOUTH);

        // Listener Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimal();
            }
        });
    }

    private void addAnimal() {
        String name = nameField.getText();
        int age;

        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Age must be a number!");
            return;
        }

        String selectedType = (String) animalTypeBox.getSelectedItem();
        Animal newAnimal;

        if ("Generic Mammal".equals(selectedType)) {
            String furColor = furColorField.getText();
            newAnimal = new Mammal(name, age, furColor);
        } else {
            boolean canFly = canFlyCheckBox.isSelected();
            newAnimal = new Bird(name, age, canFly);
        }

        zoo.add(newAnimal);

        logArea.append("Added a new " + selectedType + "!\n");
        logArea.append("Info: " + newAnimal.getInfo() + "\n");
        logArea.append("Sound: " + newAnimal.makeSound() + "\n\n");

        // Clear form
        nameField.setText("");
        ageField.setText("");
        furColorField.setText("");
        canFlyCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ZooFrame().setVisible(true);
        });
    }
}
