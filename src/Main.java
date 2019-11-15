public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.listenWifeAndDoShopping();
    }

    private Husband husband = new Husband();

    private void listenWifeAndDoShopping(){
        husband.getRequiredProducts(new Wife());

        seeWhatExistsInAShop();
        showAllProductsAndCheckPossiblesBuys();
    }

    private void seeWhatExistsInAShop(){
        new TechShop().giveProductsToCustomer(husband);
        new FoodShop().giveProductsToCustomer(husband);
        new JewelryShop().giveProductsToCustomer(husband);
    }

    private void showAllProductsAndCheckPossiblesBuys(){
        husband.showAllProducts();
        husband.showPossibleProductsAndTotalPrice();
    }
}