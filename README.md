# 💰 Java Billing System (GUI Version)

A simple and interactive **Billing System** built using **Java Swing**.  
This project allows users to add multiple items, calculate totals with GST, and display a formatted bill using a graphical user interface.

---

## 🚀 Features

- 🧾 Add multiple items (name, quantity, and price)
- 💵 Auto-calculates subtotal, GST (18%), and total amount
- 🧮 Displays bill in a formatted text area
- 🔁 Clear button to reset all fields and data
- 💻 Built with **pure Java Swing** (no external libraries)

---

## 🧩 Project Structure

```
Java-Billing-System/
│
├── BillingSystemGUI.java      # Main Java program file
└── README.md                  # Project documentation
```

---

## ⚙️ How to Run the Project

### 1️⃣ Prerequisites
- Install [JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)  
- Set up Java environment variables

### 2️⃣ Compile the Program
```bash
javac BillingSystemGUI.java
```

### 3️⃣ Run the Application
```bash
java BillingSystemGUI
```

---

## 🧠 Technologies Used

| Component | Technology |
|------------|-------------|
| GUI Framework | Java Swing |
| Language | Java |
| IDE (Optional) | IntelliJ / Eclipse / VS Code |

---

## 📸 GUI Overview

| Component | Description |
|------------|--------------|
| Item Name | Text field for entering item name |
| Quantity | Input field for number of items |
| Price | Input field for price per item |
| Add Item Button | Adds the item to the bill list |
| Generate Bill Button | Calculates total + GST and displays summary |
| Clear Button | Clears all data and resets the bill area |

---

## 🧾 Sample Bill Output

```
========================================
            BILLING SYSTEM
========================================
Item             Qty        Price      Total
----------------------------------------
Pen              2          10.00      20.00
Notebook         1          50.00      50.00
----------------------------------------
Subtotal:                   ₹70.00
GST (18%):                  ₹12.60
Grand Total:                ₹82.60
========================================
         THANK YOU! VISIT AGAIN
========================================
```

---

## 🧑‍💻 Author

- **SathvikaReddy** – Developer & Designer  

---

## 📝 License

This project is open-source and available under the **MIT License**.

---

## ⭐ Support

If you find this project helpful, don’t forget to **star this repository** on GitHub! 🌟
