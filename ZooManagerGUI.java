import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooManagerGUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Zoo Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        
        // Create components
        JLabel titleLabel = new JLabel("Zoo Manager Application");
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        
        JButton animalButton = new JButton("Show Animal");
        JButton mammalButton = new JButton("Show Mammal");
        JButton clearButton = new JButton("Clear");
        
        // Add action listeners
        animalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animal animal = new Animal("Generic Animal", 5);
                outputArea.append(animal.getInfo() + "\n");
                outputArea.append(animal.makeSound() + "\n");
                outputArea.append("--------------------\n");
            }
        });
        
        mammalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mammal mammal = new Mammal("Lion", 3, "Golden");
                outputArea.append(mammal.getInfo() + "\n");
                outputArea.append(mammal.makeSound() + "\n");
                outputArea.append("--------------------\n");
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
            }
        });
        
        // Add components to frame
        frame.add(titleLabel);
        frame.add(new JScrollPane(outputArea));
        frame.add(animalButton);
        frame.add(mammalButton);
        frame.add(clearButton);
        
        // Show the frame
        frame.setVisible(true);
    }
}