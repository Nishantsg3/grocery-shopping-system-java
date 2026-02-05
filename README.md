# Grocery Shopping System (Java)

A console-based grocery shopping application built using Java and object-oriented programming principles.  
The system simulates real-world grocery store operations such as item purchases, inventory management, billing, and receipt generation with persistent storage.

---

## Features

- Item-based shopping with quantity selection
- Inventory management with stock tracking
- Persistent inventory storage using file handling
- Automatic receipt generation for each transaction
- Discount application based on bill amount
- Custom exception handling for invalid items
- Price analytics:
  - Average item price
  - Items below a specified price threshold

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- File I/O
- Exception Handling
- Console-based user interaction

---

## Project Structure
```
src/
├── Main.java
├── Item.java
├── Inventory.java
├── GroceryStore.java
├── Receipt.java
└── ItemNotFoundException.java

README.md
inventory.txt
receipt.txt
```

---

## How to Run

### Navigate to the project root directory

**Compile the source files:**
```bash
javac src/*.java
```

**Run the application:**
```bash
java src.Main
```

---

## Preview & Demo

### Terminal Demo (Asciinema)

A full terminal walkthrough of the application showing:
- Item selection
- Quantity input
- Billing and discounts
- Inventory updates
- Receipt generation

▶️ **Watch here:** https://asciinema.org/a/Wx6hEYEFhRxn0ZTk

---

### Screenshots

Screenshots demonstrating core functionality:

- Order flow and billing output  
- Inventory persistence (`inventory.txt`)  
- Generated receipts (`receipt.txt`)  

Screenshots are available in the `preview/` folder:
- `preview/order.png`
- `preview/inventory.png`
- `preview/receipt.png`

---

## Sample Functionality

- Add grocery items by name
- Enter quantity to purchase
- Automatically updates inventory stock
- Generates and saves receipt to receipt.txt
- Inventory persists between runs using inventory.txt

---

## Future Enhancements

- Admin panel for restocking items
- User roles (Admin / Customer)
- Database integration
- GUI or Web interface

---

## Author

Nishant Gawande

---

## Cleaning Up `.class` Files

### Why remove `.class` files?
- `.class` files are **compiled output**
- GitHub repos should contain **source code only**
- Keeps your repository clean and professional

### How to remove them

**From project root:**
```bash
rm src/*.class
```

**If there are `.class` files elsewhere:**
```bash
find . -name "*.class" -delete
```

---

## License

This project is open source and available for educational purposes.