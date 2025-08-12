# 🎟️ Ticket Management System

A **Java-based console application** for managing tickets and processing payments through different payment methods.  
Built with **Object-Oriented Programming principles** and designed to be easily extensible.

## 📌 Features

- Add and manage tickets
- Process payments via:
  - 💳 Card Payment
  - 🏦 Net Banking
  - 📱 UPI
  - 💵 Other Payment Methods
- Validate user details and payment information
- Store ticket data in serialized format (`tickets.ser`)

## 🛠️ Tech Stack

- **Language:** Java
- **IDE:** IntelliJ IDEA
- **Version Control:** Git & GitHub

## 📂 Project Structure
```plaintext
src/
 ├── CardPayment.java
 ├── NetBankingPayment.java
 ├── OtherPaymentMethod.java
 ├── PaymentMethod.java
 ├── Ticket.java
 ├── TicketManagementSystem.java
 ├── TicketUtils.java
 ├── UpiPayment.java
 ├── UserDetails.java
 └── ValidatorUtil.java
```

## 🚀 How to Run

1. Clone this repository:
   ```bash
    git clone https://github.com/AyushRai07/Ticket-Management-System.git

2. Open the project in IntelliJ IDEA (or any Java IDE).

3. Compile and run:
   ```bash
    javac src/*.java
    java src/TicketManagementSystem
