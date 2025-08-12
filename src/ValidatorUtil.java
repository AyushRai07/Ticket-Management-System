import java.time.LocalDate;

public class ValidatorUtil {

    public static boolean isValidAadhaar(String aadhaar) {
        return aadhaar.matches("\\d{12}");
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidTravelDate(LocalDate date) {
        return !date.isBefore(LocalDate.now());
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }
}
