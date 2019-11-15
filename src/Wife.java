import java.util.ArrayList;
import java.util.Arrays;

public class Wife implements FamilyCostumer {
    @Override
    public ArrayList<String> setRequiredProducts() {
        return new ArrayList<>(Arrays.asList("Sony", "Bread", "Lenovo", "Onion", "Earrings"));
    }
}