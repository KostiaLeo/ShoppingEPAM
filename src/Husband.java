import java.util.ArrayList;

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
        for (Product product : allProducts) {
            System.out.println(product.toString());
        }
        System.out.println();
    }

// -------------- own methods ---------------------------------

    private ArrayList<Product> makeListOfPossibleProducts() {
        ArrayList<Product> possibles = new ArrayList<>();
        for (Product product : allProducts) {
            if (requiredProducts.contains(product.getName())) {
                possibles.add(product);
            }
        }
        return possibles;
    }

    public void showPossibleProductsAndTotalPrice() {
        System.out.println("Bought:\n");
        for (Product product : makeListOfPossibleProducts()) {
            System.out.println(product.toString());
        }
        System.out.println("Total price = " + countTotalPrice());
    }

    private int countTotalPrice() {
        int totalPrice = 0;
        for (Product product : makeListOfPossibleProducts()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}