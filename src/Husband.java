import java.util.ArrayList;

public class Husband implements FamilyMan, DBCustomer {
    private ArrayList<String> requiredProducts = new ArrayList<>();
    private ArrayList<Product> allProducts = new ArrayList<>();

// --------------- FamilyMan method --------------------------

    @Override
    public void getRequiredProducts(FamilyCustomer familyCustomer) {
        this.requiredProducts.addAll(familyCustomer.setRequiredProducts());
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

    private ArrayList<Product> makeListOfPossibleProducts() {
        ArrayList<Product> possibles = new ArrayList<>();
        allProducts.forEach(p -> {
            if (requiredProducts.contains(p.getName())) possibles.add(p);
        });
        return possibles;
    }
}