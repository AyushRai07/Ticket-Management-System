import java.io.Serial;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public class Ticket implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    private final String ticketNumber;
    private String source;
    private String destination;
    private String trainName;
    private LocalDate travelDate;
    private UserDetails user;
    private PaymentMethod paymentMethod;
    private double amount;

    //Constructor
    public Ticket(String source, String destination, String trainName, LocalDate travelDate,
                  UserDetails user, PaymentMethod paymentMethod, double amount){
        this.source = source;
        this.destination = destination;
        this.trainName = trainName;
        this.travelDate = travelDate;
        this.user = user;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.ticketNumber = UUID.randomUUID().toString().substring(0, 8);
    }
    //Getters
    public String getSource() {
        return source;
    }
    public String getDestination() {
        return destination;
    }
    public String getTrainName() {
        return trainName;
    }
    public LocalDate getTravelDate() {
        return travelDate;
    }
    public UserDetails getUser() {
        return user;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    public double getAmount() {
        return amount;
    }
    public String getTicketNumber() {
        return ticketNumber;
    }

    //Setters
    public void setSource(String source) {
        this.source = source;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }
    public void setUser(UserDetails user) {
        this.user = user;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "Ticket Number : " + ticketNumber + "\n"
                + "User Details :\n" + user.toString() + "\n"
                + "Source : " + source + "\n"
                + "Destination : " + destination + "\n"
                + "Train Name : " + trainName + "\n"
                + "Travel Date : " + travelDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) + "\n"
                + "Amount Paid : ₹" + amount + "\n"
                + "Payment Method : " + paymentMethod.getClass().getSimpleName();
    }
}
