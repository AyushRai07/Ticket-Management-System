import java.io.Serial;
import java.io.Serializable;

public class UserDetails implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String phoneNum;
    private final String aadhaarID;

    //Constructor
    public UserDetails(String name, int age, String phoneNum, String aadhaarID){
        this.name = name;
        this.age = age;
        this. phoneNum = phoneNum;
        this.aadhaarID = aadhaarID;
    }

    //Getters
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    public String getAadhaarID(){
        return aadhaarID;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Phone Number: " + phoneNum + "\n" +
                "Aadhaar ID: " + aadhaarID;
    }
}