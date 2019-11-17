import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

abstract class ShopsDataBase implements ShopDBHandler {
    private String table;
    private static final int NUMBER_OF_NAME_COLUMN = 2, NUMBER_OF_PRICE_COLUMN = 3;

    private static final String DRIVER = "com.mysql.jdbc.Driver",
            URL = "jdbc:mysql://remotemysql.com:3306/DMhXhcvaAp",
            USER = "DMhXhcvaAp",
            PASSWORD = "2b8UjA6neH",
            BASIC_STRING_QUERY = "SELECT * FROM ";

    ShopsDataBase(String table) {
        this.table = table;
    }

    @Override
    public ArrayList<Product> retrieveFromDataBase(String tableName) {
        try {
            return queryToDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String makeSelectQuery() {
        return BASIC_STRING_QUERY + table;
    }

    private ArrayList<Product> queryToDataBase() throws SQLException {
        Connection conn = getConn();
        PreparedStatement sData = Objects.requireNonNull(conn).prepareStatement(makeSelectQuery());
        ResultSet result = sData.executeQuery();

        ArrayList<Product> selData = new ArrayList<>();
        while (result.next()) {
            Product product = new Product(result.getString(NUMBER_OF_NAME_COLUMN), result.getInt(NUMBER_OF_PRICE_COLUMN));
            selData.add(product);
        }
        result.close();
        conn.close();

        return selData;
    }

    private Connection getConn() {
        try {
            return createLinkToDataBase();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private Connection createLinkToDataBase() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}