import java.io.Serial;
import java.io.Serializable;

public class UpiPayment implements  PaymentMethod, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String upiID;

    public UpiPayment(String upiID){
        this.upiID = upiID;
    }
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid ₹"+ amount + "using UPI: " + upiID);
    }
}
