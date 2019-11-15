import java.util.ArrayList;

public interface ShopDBHandler {
    ArrayList<Product> retrieveFromDataBase(String tableName);
}