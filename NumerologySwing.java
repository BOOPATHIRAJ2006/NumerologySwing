 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumerologySwing extends JFrame {

    private JTextField nameField;
    private JLabel resultLabel;
    private JLabel meaningLabel;

    public NumerologySwing() {
        setTitle("Numerology Calculator");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Numerology Number Finder", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter Your Name:"));

        nameField = new JTextField(20);
        inputPanel.add(nameField);

        JButton calcButton = new JButton("Calculate");
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processName();
            }
        });
        inputPanel.add(calcButton);

        add(inputPanel, BorderLayout.CENTER);

        // Result display
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 1));

        resultLabel = new JLabel("Numerology Number: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        meaningLabel = new JLabel("", SwingConstants.CENTER);
        meaningLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));

        resultPanel.add(resultLabel);
        resultPanel.add(meaningLabel);

        add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void processName() {
        String name = nameField.getText().trim().toUpperCase();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid name!");
            return;
        }

        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sum += (ch - 64); // ASCII method
            }
        }

        int numerology = getNumerologyNumber(sum);
        resultLabel.setText("Numerology Number: " + numerology);
        meaningLabel.setText(getMeaning(numerology));
    }

    // Numerology calculation
    private int getNumerologyNumber(int num) {
        if (num == 11 || num == 22 || num == 33) return num;

        while (num > 9) {
            if (num == 11 || num == 22 || num == 33) return num;
            num = sod(num);
        }
        return num;
    }

    private int sod(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    // Meaning text
    private String getMeaning(int n) {
        switch (n) {
            case 1: return "PRIMAL FORCE";
            case 2: return "ALL KNOWING";
            case 3: return "CREATIVE CHILD";
            case 4: return "SALT OF THE EARTH";
            case 5: return "DYNAMIC FORCE";
            case 6: return "THE CARETAKER";
            case 7: return "THE SEEKER";
            case 8: return "BALANCE AND POWER";
            case 9: return "THE CARETAKER";
            case 11: return "THE INTUITIVE";
            case 22: return "MASTER BUILDER";
            case 33: return "MASTER TEACHER";
        }
        return "";
    }

    public static void main(String[] args) {
        new NumerologySwing();
    }
}
