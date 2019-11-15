import java.util.ArrayList;
import java.util.stream.Stream;

public class Husband implements FamilyMan, DBCostumer {
    private ArrayList<String> requiredProducts;
    private ArrayList<Product> allProducts = new ArrayList<>();

// --------------- FamilyMan method --------------------------

    @Override
    public void getRequiredProducts(FamilyCostumer familyCostumer) {
        this.requiredProducts = familyCostumer.setRequiredProducts();
    }

// ---------------- DB Costumer methods ----------------------

    @Override
    public void sendMeAllProducts(ArrayList<Product> allProducts) {
        this.allProducts.addAll(allProducts);
    }

    @Override
    public void showAllProducts() {
        System.out.println("Total list:\n");
        allProducts.forEach(System.out::println);
        System.out.println();
    }

// ------------------- own methods ----------------------------

    private ArrayList<Product> makeListOfPossibleProducts() {
        ArrayList<Product> possibles = new ArrayList<>();
        allProducts.forEach(p -> {
            if (requiredProducts.contains(p.getName())) possibles.add(p);
        });
        return possibles;
    }

    void showPossibleProductsAndTotalPrice() {
        System.out.println("Bought:\n");
        makeListOfPossibleProducts().forEach(System.out::println);
        System.out.println("Total price = " + countTotalPrice());
    }

    private int countTotalPrice() {
        int totalPrice = 0;
        totalPrice += makeListOfPossibleProducts().stream().mapToInt(Product::getPrice).sum();
        return totalPrice;
    }
}