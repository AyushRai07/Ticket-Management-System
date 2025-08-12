import java.io.Serial;
import java.io.Serializable;

public class OtherPaymentMethod implements PaymentMethod, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid ₹" + amount + " using Other Payment Method");
    }
}
