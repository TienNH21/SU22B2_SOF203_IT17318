package lesson7_demo_jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lesson5_demo.Product;

public class DemoSelect {
    public static void main(String[] args) {
        try {
            // B1: Load driver để kết nối tới CDSL
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String dbUser = "sa", dbPass = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=su22b2_sof203";
            
            // B2: Tạo kết nối tới CSDL
            Connection conn = DriverManager
                .getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Kết nối thành công");
            
            // B3: Tạo PreparedStatement & set tham số
            String query = "SELECT * FROM san_pham";

            PreparedStatement ps = conn.prepareStatement(query);

            // B4: Thực thi
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            ArrayList<Product> listProduct = new ArrayList<>();
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                int soLg = rs.getInt("so_luong");
                String mau = rs.getString("mau_sac");
                double gia = rs.getDouble("don_gia");
                int danhMucId = rs.getInt("danh_muc_id");
                Product p = new Product(id, ten, mau, soLg, gia, danhMucId);
                listProduct.add(p);
            }
            
            // B5: Đóng kết nối
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
