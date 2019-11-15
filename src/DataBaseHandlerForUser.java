
abstract class DataBaseHandlerForUser extends ShopsDataBase implements DBClientAgent {

    private String table;

    public DataBaseHandlerForUser(String table) {
        super(table);
        this.table = table;
    }

    @Override
    public void giveProductsForCostumer(DBCostumer costumer) {
        costumer.sendMeAllProducts(super.retrieveFromDataBase(table));
    }
}