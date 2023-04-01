package graphicalUserInterface;
import javax.swing.*;
import java.awt.*;

    public class View {

    private final JTextField firstPolynomialField;
    private final JTextField secondPolynomialField;
    private final JTextField resultPolynomialField;
    private final JButton addButton;
    private final JButton substractButton;
    private final JButton multiplyButton;
    private final JButton divideButton;
    private final JButton derivativeButton;
    private final JButton integralButton;

    public View() {
        JFrame frame = new JFrame("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 700));
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(247, 247, 247));
        GridBagConstraints c = new GridBagConstraints();

        // First Polynomial label and text field
        JLabel firstPolynomialLabel = new JLabel("First Polynomial:");
        firstPolynomialLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        firstPolynomialLabel.setForeground(new Color(76, 76, 76));
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(20, 20, 0, 20);
        panel.add(firstPolynomialLabel, c);

        firstPolynomialField = new JTextField(20);
        firstPolynomialField.setFont(new Font("Roboto", Font.PLAIN, 16));
        firstPolynomialField.setForeground(new Color(33, 33, 33));
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 20, 0, 20);
        panel.add(firstPolynomialField, c);

        // Second Polynomial label and text field
        JLabel secondPolynomialLabel = new JLabel("Second Polynomial:");
        secondPolynomialLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        secondPolynomialLabel.setForeground(new Color(76, 76, 76));
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(20, 20, 0, 20);
        panel.add(secondPolynomialLabel, c);

        secondPolynomialField = new JTextField(20);
        secondPolynomialField.setFont(new Font("Roboto", Font.PLAIN, 16));
        secondPolynomialField.setForeground(new Color(33, 33, 33));
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(0, 20, 0, 20);
        panel.add(secondPolynomialField, c);

        // Result Polynomial label and text field
        JLabel resultPolynomialLabel = new JLabel("Result:");
        resultPolynomialLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        resultPolynomialLabel.setForeground(new Color(76, 76, 76));
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(20, 20, 0, 20);
        panel.add(resultPolynomialLabel, c);

        resultPolynomialField = new JTextField(20);
        resultPolynomialField.setFont(new Font("Roboto", Font.PLAIN, 16));
        resultPolynomialField.setForeground(new Color(33, 33, 33));
        resultPolynomialLabel.setBackground(new Color(137,190,240));
        resultPolynomialField.setEditable(false);
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(0, 20, 20, 20);
        panel.add(resultPolynomialField, c);
        // Operation buttons
        addButton = new JButton("Add");
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 10, 20);
        addButton.setBackground(new Color(123, 103, 154));
        addButton.setForeground(new Color(250, 250, 250));
        panel.add(addButton, c);

        substractButton = new JButton("Substract");
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 10, 20);
        substractButton.setBackground(new Color(123, 103, 154));
        substractButton.setForeground(new Color(250, 250, 250));
        panel.add(substractButton, c);

        multiplyButton = new JButton("Multiply");
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(0, 0, 10, 20);
        multiplyButton.setBackground(new Color(123, 103, 154));
        multiplyButton.setForeground(new Color(250, 250, 250));
        panel.add(multiplyButton, c);

        divideButton = new JButton("Divide");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 20, 10, 0);
        divideButton.setBackground(new Color(123, 103, 154));
        divideButton.setForeground(new Color(250, 250, 250));
        panel.add(divideButton, c);

        derivativeButton = new JButton("Derivative");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 20, 10, 0);
        derivativeButton.setBackground(new Color(123, 103, 154));
        derivativeButton.setForeground(new Color(250, 250, 250));
        panel.add(derivativeButton, c);

        integralButton = new JButton("Integral");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 20, 10, 0);
        integralButton.setBackground(new Color(123, 103, 154));
        integralButton.setForeground(new Color(250, 250, 250));
        panel.add(integralButton, c);

// Layout configuration
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.setPreferredSize(new Dimension(800, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JTextField getFirstPolynomialField() {
        return firstPolynomialField;
    }

    public JTextField getSecondPolynomialField() {
        return secondPolynomialField;
    }

    public JTextField getResultPolynomialField() {
        return resultPolynomialField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubstractButton() {
        return substractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getDerivativeButton() {
        return derivativeButton;
    }

    public JButton getIntegralButton() {
        return integralButton;
    }
}