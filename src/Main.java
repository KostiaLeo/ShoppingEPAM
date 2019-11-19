import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.listenWifeAndDoShopping();
    }

    private Husband husband = new Husband();

    private void listenWifeAndDoShopping(){
        husband.getRequiredProducts(new Wife());

        checkProductsInShops();
        showAllProductsAndCheckPossiblesBuys();
    }

    private void checkProductsInShops(){
        shops().forEach(shop -> shop.giveProductsToCustomer(husband));
    }

    private static ArrayList<AbstractShop> shops(){
        return new ArrayList<>(Arrays.asList(
                new TechShop(),
                new FoodShop(),
                new JewelryShop()
        ));
    }

    private void showAllProductsAndCheckPossiblesBuys(){
        husband.showAllProducts();
        husband.showPossibleProductsAndTotalPrice();
    }
}