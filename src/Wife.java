import java.util.ArrayList;
import java.util.Arrays;

public class Wife implements FamilyCustomer {
    @Override
    public ArrayList<String> setRequiredProducts() {
        return new ArrayList<>(Arrays.asList("Sony", "Bread", "Lenovo", "Onion", "Earrings"));
    }
}