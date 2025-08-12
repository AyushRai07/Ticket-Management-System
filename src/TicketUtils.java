import java.util.*;
import java.time.LocalDate;

public class TicketUtils {

    // Sort tickets by UserName (alphabetically)
    public static void sortByUserName(List<Ticket> tickets) {
        tickets.sort(Comparator.comparing(t -> t.getUser().getName().toLowerCase()));
    }

    // Sort tickets by Travel Date (ascending)
    public static void sortByTravelDate(List<Ticket> tickets) {
        tickets.sort(Comparator.comparing(Ticket::getTravelDate));
    }

    // Sort tickets by Amount Paid (ascending)
    public static void sortByAmount(List<Ticket> tickets) {
        tickets.sort(Comparator.comparingDouble(Ticket::getAmount));
    }

    // Search by Ticket Number
    public static Ticket searchByTicketNumber(List<Ticket> tickets, String ticketNumber) {
        for (Ticket t : tickets) {
            if (t.getTicketNumber().equalsIgnoreCase(ticketNumber)) {
                return t;
            }
        }
        return null;
    }

    // Search by UserName
    public static List<Ticket> searchByUserName(List<Ticket> tickets, String userName) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.getUser().getName().equalsIgnoreCase(userName)) {
                result.add(t);
            }
        }
        return result;
    }

    // Search by Aadhaar ID
    public static List<Ticket> searchByAadhaarID(List<Ticket> tickets, String aadhaarID) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.getUser().getAadhaarID().equalsIgnoreCase(aadhaarID)) {
                result.add(t);
            }
        }
        return result;
    }

    // Search by Travel Date
    public static List<Ticket> searchByTravelDate(List<Ticket> tickets, LocalDate date) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.getTravelDate().equals(date)) {
                result.add(t);
            }
        }
        return result;
    }

    // Search by Source and Destination
    public static List<Ticket> searchBySourceDestination(List<Ticket> tickets, String source, String destination) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets) {
            if (t.getSource().equalsIgnoreCase(source) && t.getDestination().equalsIgnoreCase(destination)) {
                result.add(t);
            }
        }
        return result;
    }
}
