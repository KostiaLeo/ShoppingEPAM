
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.listenWifeAndMakeShopping();
    }

    private Husband husband = new Husband();

    private void listenWifeAndMakeShopping(){
        husband.setRequiredProductsFromWife(new Wife());

        seeWhatExistsInAShop();
        showAllProductsAndCheckPossiblesBuys();
    }

    private void seeWhatExistsInAShop(){
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        dataBaseHandler.giveProductsForCostumer(husband);
    }

    private void showAllProductsAndCheckPossiblesBuys(){
        husband.showAllProducts();
        husband.showPossibleProductsAndTotalPrice();
    }
}