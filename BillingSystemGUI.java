import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Item {
    String name;
    int quantity;
    double price;

    Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    double getTotal() {
        return quantity * price;
    }
}

public class BillingSystemGUI extends JFrame implements ActionListener {
    private JTextField itemNameField, quantityField, priceField;
    private JTextArea billArea;
    private JButton addButton, generateButton, clearButton;
    private ArrayList<Item> itemList = new ArrayList<>();

    public BillingSystemGUI() {
        setTitle("Billing System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ==== Top Panel ====
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Item Details"));

        inputPanel.add(new JLabel("Item Name:"));
        itemNameField = new JTextField();
        inputPanel.add(itemNameField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        inputPanel.add(new JLabel("Price (₹):"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        addButton = new JButton("Add Item");
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        generateButton = new JButton("Generate Bill");
        generateButton.addActionListener(this);
        inputPanel.add(generateButton);

        add(inputPanel, BorderLayout.NORTH);

        // ==== Center Panel ====
        billArea = new JTextArea();
        billArea.setEditable(false);
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(billArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Bill Summary"));
        add(scrollPane, BorderLayout.CENTER);

        // ==== Bottom Panel ====
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton, BorderLayout.SOUTH);

        // ==== Initial Bill Header ====
        billArea.setText("========================================\n");
        billArea.append("            BILLING SYSTEM\n");
        billArea.append("========================================\n");
        billArea.append(String.format("%-15s %-10s %-10s %-10s%n", "Item", "Qty", "Price", "Total"));
        billArea.append("----------------------------------------\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                String name = itemNameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                if (name.isEmpty() || quantity <= 0 || price <= 0) {
                    JOptionPane.showMessageDialog(this, "Enter valid details!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Item item = new Item(name, quantity, price);
                itemList.add(item);

                billArea.append(String.format("%-15s %-10d %-10.2f %-10.2f%n", name, quantity, price, item.getTotal()));

                // Clear input fields
                itemNameField.setText("");
                quantityField.setText("");
                priceField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Quantity and Price.", "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        else if (e.getSource() == generateButton) {
            if (itemList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No items added yet!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double subtotal = 0;
            for (Item item : itemList) {
                subtotal += item.getTotal();
            }

            double gst = subtotal * 0.18;
            double grandTotal = subtotal + gst;

            billArea.append("----------------------------------------\n");
            billArea.append(String.format("%-25s ₹%.2f%n", "Subtotal:", subtotal));
            billArea.append(String.format("%-25s ₹%.2f%n", "GST (18%):", gst));
            billArea.append(String.format("%-25s ₹%.2f%n", "Grand Total:", grandTotal));
            billArea.append("========================================\n");
            billArea.append("         THANK YOU! VISIT AGAIN\n");
            billArea.append("========================================\n");

            generateButton.setEnabled(false);
        }

        else if (e.getSource() == clearButton) {
            itemList.clear();
            billArea.setText("");
            billArea.append("========================================\n");
            billArea.append("            BILLING SYSTEM\n");
            billArea.append("========================================\n");
            billArea.append(String.format("%-15s %-10s %-10s %-10s%n", "Item", "Qty", "Price", "Total"));
            billArea.append("----------------------------------------\n");
            generateButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BillingSystemGUI().setVisible(true);
        });
    }
}
