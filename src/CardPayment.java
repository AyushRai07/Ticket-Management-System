import java.io.Serial;
import java.io.Serializable;

public class CardPayment implements PaymentMethod, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String cardNumber;
    private final String cardHolderName;

    public CardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid ₹" + amount + " using Card: ****" + cardNumber.substring(cardNumber.length() - 4)+ " by " + cardHolderName);
    }
}
