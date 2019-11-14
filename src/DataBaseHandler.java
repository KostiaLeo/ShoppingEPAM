import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler {

    private static final String TABLE1 = "IndProducts", TABLE2 = "FoodProducts";
    private static final String selectQuery = "SELECT * FROM " + TABLE1 + " UNION " + "SELECT * FROM " + TABLE2;

    public void giveProductsForCostumer(DBCostumer costumer) {
        costumer.sendMeAllProducts(retrieveAllProductsList());
    }

    private ArrayList<Product> retrieveAllProductsList() {
        try {
            return queryToDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Product> queryToDataBase() throws SQLException{
        Connection conn = getConn();
        PreparedStatement sData = conn.prepareStatement(selectQuery);
        ResultSet result = sData.executeQuery();

        ArrayList<Product> selData = new ArrayList<>();
        while (result.next()) {
            Product product = new Product(result.getString(2), result.getInt(3));
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
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://remotemysql.com:3306/DMhXhcvaAp";
        String user = "DMhXhcvaAp";
        String pass = "2b8UjA6neH";

        Class.forName(driver);
        return DriverManager.getConnection(url, user, pass);
    }
}