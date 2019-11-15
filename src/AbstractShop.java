
abstract class AbstractShop extends ShopsDataBase implements DBClientAgent {

    private String table;

    public AbstractShop(String table) {
        super(table);
        this.table = table;
    }

    @Override
    public void giveProductsToCustomer(DBCostumer costumer) {
        costumer.sendMeAllProducts(super.retrieveFromDataBase(table));
    }
}