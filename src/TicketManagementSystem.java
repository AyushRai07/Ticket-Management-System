import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TicketManagementSystem {
    static final String FILE_NAME = "tickets.ser";
    static List<Ticket> allTickets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadTickets();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== Railway Ticket Booking System ====");
            System.out.println("1. Book Ticket");
            System.out.println("2. View All Tickets");
            System.out.println("3. Sort Tickets");
            System.out.println("4. Search Tickets");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Ticket ticket = createTicket(sc);
                    allTickets.add(ticket);
                    saveTickets();
                    System.out.println("\n✅ Ticket Booked Successfully:\n");
                    System.out.println(ticket);
                    break;

                case 2:
                    displayTickets(allTickets);
                    break;

                case 3:
                    sortTickets(sc);
                    break;

                case 4:
                    searchTickets(sc);
                    break;

                case 5:
                    cancelTicket(sc);
                    break;
                case 6:
                    exit = true;
                    System.out.println("👋 Exiting... Have a nice day!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
        sc.close();
    }

    private static Ticket createTicket(Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        int age;
        while (true) {
            System.out.print("Enter your age: ");
            age = sc.nextInt();
            sc.nextLine();
            if (ValidatorUtil.isValidAge(age)) break;
            System.out.println("❌ Invalid age. Try again.");
        }

        String phone;
        while (true) {
            System.out.print("Enter your phone number: ");
            phone = sc.nextLine();
            if (ValidatorUtil.isValidPhone(phone)) break;
            System.out.println("❌ Invalid phone number. Enter 10 digits.");
        }

        String aadhaar;
        while (true) {
            System.out.print("Enter your Aadhaar ID: ");
            aadhaar = sc.nextLine();
            if (ValidatorUtil.isValidAadhaar(aadhaar)) break;
            System.out.println("❌ Aadhaar must be 12 digits.");
        }

        UserDetails user = new UserDetails(name, age, phone, aadhaar);

        System.out.print("Enter source station: ");
        String source = sc.nextLine();
        System.out.print("Enter destination station: ");
        String destination = sc.nextLine();
        System.out.print("Enter train name: ");
        String trainName = sc.nextLine();

        LocalDate travelDate;
        while (true) {
            try {
                System.out.print("Enter travel date (dd-MM-yyyy): ");
                String dateStr = sc.nextLine();
                travelDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                if (ValidatorUtil.isValidTravelDate(travelDate)) break;
                System.out.println("❌ Date cannot be in the past.");
            } catch (Exception e) {
                System.out.println("❌ Invalid date format. Please use dd-MM-yyyy.");
            }
        }

        double amount;
        while (true) {
            System.out.print("Enter ticket amount: ₹");
            amount = sc.nextDouble();
            sc.nextLine();
            if (ValidatorUtil.isValidAmount(amount)) break;
            System.out.println("❌ Amount should be greater than Zero.");
        }

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. NetBanking");
        System.out.println("4. Other");

        int paymentChoice = sc.nextInt();
        sc.nextLine();

        PaymentMethod paymentMethod;
        switch (paymentChoice) {
            case 1:
                System.out.print("Enter UPI ID: ");
                paymentMethod = new UpiPayment(sc.nextLine());
                break;
            case 2:
                System.out.print("Enter Card Number: ");
                String cardNum = sc.nextLine();
                System.out.print("Enter Cardholder Name: ");
                String holder = sc.nextLine();
                paymentMethod = new CardPayment(cardNum, holder);
                break;
            case 3:
                System.out.print("Enter Bank Name: ");
                String bank = sc.nextLine();
                System.out.print("Enter Account Number: ");
                String accNum = sc.nextLine();
                paymentMethod = new NetBankingPayment(bank, accNum);
                break;
            default:
                paymentMethod = new OtherPaymentMethod();
        }

        paymentMethod.makePayment(amount);

        return new Ticket(source, destination, trainName, travelDate, user, paymentMethod, amount);
    }


    private static void displayTickets(List<Ticket> tickets) {
        if (tickets.isEmpty()) {
            System.out.println("\n⚠ No tickets booked yet.");
        } else {
            System.out.println("\n📄 All Booked Tickets:\n");
            for (Ticket t : tickets) {
                System.out.println(t);
                System.out.println("------------------------------------");
            }
        }
    }

    private static void sortTickets(Scanner sc) {
        System.out.println("\n📊 Sort Tickets By:");
        System.out.println("1. User Name");
        System.out.println("2. Travel Date");
        System.out.println("3. Ticket Amount");

        System.out.print("Enter your choice: ");
        int sortChoice = sc.nextInt();
        sc.nextLine();

        switch (sortChoice) {
            case 1:
                TicketUtils.sortByUserName(allTickets);
                break;
            case 2:
                TicketUtils.sortByTravelDate(allTickets);
                break;
            case 3:
                TicketUtils.sortByAmount(allTickets);
                break;
            default:
                System.out.println("❌ Invalid choice.");
                return;
        }
        System.out.println("\n✅ Tickets sorted successfully.");
        displayTickets(allTickets);
    }

    private static void searchTickets(Scanner sc) {
        System.out.println("\n🔍 Search Tickets By:");
        System.out.println("1. Ticket Number");
        System.out.println("2. User Name");
        System.out.println("3. Aadhaar ID");
        System.out.println("4. Travel Date");
        System.out.println("5. Source & Destination");
        System.out.print("Enter your choice: ");
        int searchChoice = sc.nextInt();
        sc.nextLine();

        List<Ticket> results = new ArrayList<>();

        switch (searchChoice) {
            case 1:
                System.out.print("Enter Ticket Number: ");
                String tno = sc.nextLine();
                Ticket result = TicketUtils.searchByTicketNumber(allTickets, tno);
                if (result != null) {
                    results.add(result);
                }
                break;
            case 2:
                System.out.print("Enter User Name: ");
                results = TicketUtils.searchByUserName(allTickets, sc.nextLine());
                break;
            case 3:
                System.out.print("Enter Aadhaar ID: ");
                results = TicketUtils.searchByAadhaarID(allTickets, sc.nextLine());
                break;
            case 4:
                System.out.print("Enter Travel Date (dd-MM-yyyy): ");
                String date = sc.nextLine();
                LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                results = TicketUtils.searchByTravelDate(allTickets, ld);
                break;
            case 5:
                System.out.print("Enter Source Station: ");
                String src = sc.nextLine();
                System.out.print("Enter Destination Station: ");
                String dst = sc.nextLine();
                results = TicketUtils.searchBySourceDestination(allTickets, src, dst);
                break;
            default:
                System.out.println("❌ Invalid choice.");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("\n⚠ No matching tickets found.");
        } else {
            System.out.println("\n🔍 Search Results:");
            displayTickets(results);
        }
    }
    private static void cancelTicket(Scanner sc) {
        System.out.print("\n❌ Enter Ticket Number to Cancel: ");
        String ticketNumber = sc.nextLine();

        Ticket ticketToCancel = TicketUtils.searchByTicketNumber(allTickets, ticketNumber);
        if (ticketToCancel != null) {
            System.out.println("\n⚠ Ticket Found:\n");
            System.out.println(ticketToCancel);
            System.out.print("Are you sure you want to cancel this ticket? (yes/no): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                allTickets.remove(ticketToCancel);
                saveTickets();
                System.out.println("✅ Ticket canceled successfully.");
            } else {
                System.out.println("❎ Ticket cancellation aborted.");
            }
        } else {
            System.out.println("❌ Ticket not found with number: " + ticketNumber);
        }
    }


    private static void saveTickets() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(allTickets);
        } catch (IOException e) {
            System.out.println("❌ Error saving tickets: " + e.getMessage());
            e.printStackTrace(); // helpful during development
        }
    }

    private static void loadTickets() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            allTickets = (List<Ticket>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ Failed to load previous tickets.");
            e.printStackTrace(); // helpful during development
        }
        System.out.println("✅ Tickets loaded successfully. Total: " + allTickets.size());
    }
}
