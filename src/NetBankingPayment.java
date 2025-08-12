import java.io.Serial;
import java.io.Serializable;

public class NetBankingPayment implements PaymentMethod, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String bankName;
    private final String accountNumber;

    public NetBankingPayment(String bankName, String accountNumber){
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    @Override
    public void makePayment(double amount) {
        String maskedAccount;
        if (accountNumber.length() >= 4) {
            String last4 = accountNumber.substring(accountNumber.length() - 4);
            maskedAccount = "XXXX-XXXX-" + last4;
        } else {
            maskedAccount = "(Invalid Account Number)";
        }

        System.out.println("Paid ₹" + amount + " using Net-Banking from " + bankName +
                " (A/c: " + maskedAccount + ")");
    }
}
